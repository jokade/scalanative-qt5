package qt.macros

import scala.language.experimental.macros
import scala.annotation.StaticAnnotation
import scala.reflect.macros.whitebox
import scala.scalanative.cobj.NamingConvention
import scala.scalanative.cobj.internal.CommonHandler
import scala.scalanative.cxx.internal.CxxWrapperGen
import scala.scalanative.unsafe._

class Qt(cxxType: String = null) extends StaticAnnotation {
  def macroTransform(annottees: Any*): Any = macro Qt.Macro.impl
}

object Qt {
  private class Macro(val c: whitebox.Context) extends CommonHandler with CxxWrapperGen {
    override def annotationName = "scala.scalanative.native.cxx.Cxx"
    override def supportsClasses: Boolean = true
    override def supportsTraits: Boolean = true
    override def supportsObjects: Boolean = true
    override def createCompanion: Boolean = true

    import c.universe._

    val exprExtern = q"scalanative.unsafe.extern"
    val tFunc0 = weakTypeOf[CFuncPtr0[_]]
    val tFunc1 = weakTypeOf[CFuncPtr1[_,_]]
    val tFunc2 = weakTypeOf[CFuncPtr2[_,_,_]]
    val tFunc3 = weakTypeOf[CFuncPtr3[_,_,_,_]]
    val tFunc4 = weakTypeOf[CFuncPtr4[_,_,_,_,_]]
    val tFunc5 = weakTypeOf[CFuncPtr5[_,_,_,_,_,_]]
    val tFunc6 = weakTypeOf[CFuncPtr6[_,_,_,_,_,_,_]]
    val tFunc7 = weakTypeOf[CFuncPtr7[_,_,_,_,_,_,_,_]]
    val tFunc8 = weakTypeOf[CFuncPtr8[_,_,_,_,_,_,_,_,_]]
    val tFunc9 = weakTypeOf[CFuncPtr9[_,_,_,_,_,_,_,_,_,_]]
    val tFunc10 = weakTypeOf[CFuncPtr10[_,_,_,_,_,_,_,_,_,_,_]]

    case class Signal(name: TermName)

    implicit class QtData(data: Map[String,Any]) {
      type Data = Map[String, Any]
      type Signals = Seq[Signal]

      def qtSignals: Signals = data.getOrElse("qtSignals",Nil).asInstanceOf[Signals]
      def withQtSignals(signals: Signals): Data = data.updated("qtSignals",signals)
    }

    override protected def tpeDefaultParent = tpeCxxObject
    private val tpeCxxObject = tq"$tCxxObject"
    //val annotationParamNames = Seq("namespace","prefix")
    val annotationParamNames = Seq("cxxType")

    override def analyze: Analysis = super.analyze andThen {
      case (cls: ClassParts, data) =>
        val updData = (
          analyzeMainAnnotation(cls) _
            andThen analyzeTypes(cls) _
            andThen analyzeConstructor(cls) _
            andThen analyzeBody(cls) _
            andThen analyzeSignals(cls) _
          )(data)
        (cls, updData)
      case (obj: ObjectParts, data) =>
        val updData = (
          analyzeMainAnnotation(obj) _
            andThen analyzeBody(obj) _
          )(data)
        (obj, updData)
      case default => default
    }

    override def transform: Transformation = super.transform andThen {
      case cls: ClassTransformData =>
        cls
          .updBody(genTransformedTypeBody(cls))
          .addAnnotations(genCxxSource(cls.data),genCxxWrapperAnnot(cls.data))
          .updCtorParams(genTransformedCtorParams(cls))
          .updParents(genTransformedParents(cls))
      case obj: ObjectTransformData =>
        val transformedBody = genTransformedCompanionBody(obj) ++ obj.data.additionalCompanionStmts :+ genBindingsObject(obj.data)
        if(obj.modParts.isCompanion)
          obj
            .updBody(transformedBody)
        else
          obj
            .updBody(transformedBody)
            .addAnnotations(genCxxSource(obj.data))
      case default => default
    }


    private def analyzeMainAnnotation(tpe: CommonParts)(data: Data): Data = {
      val annotParams = extractAnnotationParameters(c.prefix.tree, annotationParamNames)

      val cxxType = annotParams("cxxType") match {
        case Some(t) => Some(extractStringConstant(t).get)
        case None => None
      }
      val updData = data
        .withExternalPrefix(genPrefixName(tpe))
        .withCxxNamespace(None)
        .withCxxType(cxxType)
      analyzeCxxAnnotation(tpe)(updData)
    }

    private def analyzeConstructor(cls: ClassParts)(data: Data): Data = {
      val companionStmts =
        if (cls.isClass && !cls.modifiers.hasFlag(Flag.ABSTRACT))
          List(genWrapperImplicit(cls.name, cls.tparams, cls.params))
        else
          Nil
      data
        .withAdditionalCompanionStmts(data.additionalCompanionStmts ++ companionStmts)
    }

    private def genPrefixName(tpe: CommonParts): String =
      tpe.fullName.replaceAll("\\.","_") + "_"

    private def analyzeSignals(tpe: CommonParts)(data: Data): Data = {
      val prefix = data.externalPrefix
      val (externalBindings,signalHandlers) = tpe.body.collect {
        case t@DefDef(mods, name, types, args, rettype, rhs) if isSignal(rhs) =>
          val f = DefDef(mods,name,types,args, rettype, exprExtern)
          (genExternalBinding(prefix,f,!tpe.isObject)(data),
            genQtConnect(t)(data))
      }.unzip

      data
        .addExternals(externalBindings.toMap)
        .addCxxWrappers(signalHandlers)
    }

    override def genTransformedTypeBody(t: TypeTransformData[TypeParts]): Seq[c.universe.Tree] = {
      val updBody = t.modParts.body map {
        case tree @ DefDef(mods, name, types, args, rettype, rhs) if isSignal(rhs) =>
          transformSignalHandler(tree)(t.data)
        case default => default
      }
      super.genTransformedTypeBody(t.updBody(updBody))
    }

    override protected def genCxxFQClassName(tpe: Type)(implicit data: Data): String =
      tpe.typeSymbol.name.toString

    private def transformSignalHandler(scalaDef: DefDef)(implicit data: Data): Tree = {
      val scalaName = genScalaName(scalaDef)
      val externalName = data.externals(scalaName)._1
      genExternalCall(externalName,scalaDef,false,data)

    }

    private def genQtConnect(scalaDef: DefDef)(implicit data: Data): String = {
      val returnType = "void"
      val name = genCxxName(scalaDef)
      val scalaName = genScalaName(scalaDef)
      val params = Nil
      val clsPtr = data.cxxFQClassName + "* __p"
      val (cbParam,cbArg) = genQtCallback(scalaDef)
      val signalSender = genQtSignalSender(scalaDef)
      val body = findCxxBody(scalaDef).getOrElse(s"QObject::connect(__p,$signalSender,$cbArg);")
      s"""$returnType ${data.externalPrefix}$scalaName($clsPtr, $cbParam) { $body }"""
    }

    private def genQtCallback(scalaDef: DefDef)(implicit data: Data): (String,String) = {
      val (cb,hasContext) = scalaDef.vparamss match {
        case List(args) =>
          if(args.length==1)
            (args(0).tpt,false)
          else if(args.length==2)
            (args(0).tpt,true)
          else {
            c.error(c.enclosingPosition,"Qt signal callbacks must have either the signature (arg0: CFuncPtrN[]) or (arg0: CFuncPtrN[], ctx: T)")
            ???
          }
        case _ =>
          c.error(c.enclosingPosition,"Qt signal callbacks must have either the signature (arg0: CFuncPtrN[]) or (arg0: CFuncPtrN[], ctx: T)")
          ???
      }
      val types = getType(cb,true).dealias match {
        case t if t <:< tFunc0 || t <:< tFunc1 || t <:< tFunc2 || t <:< tFunc3 || t <:< tFunc4 || t <:< tFunc5 ||
                  t <:< tFunc6 || t <:< tFunc7 || t <:< tFunc8 || t <:< tFunc9 || t <:< tFunc10 =>
          t.typeArgs.map(genCxxWrapperType(_) match {
            case cls: ClassType => s"const ${cls.name}&"
            case x => x.default
          })
        case _ =>
          c.error(c.enclosingPosition,"Qt signal callbacks must have either the signature (arg0: CFuncPtrN[]) or (arg0: CFuncPtrN[], ctx: T)")
          ???
      }
      val cbParams = types.init.mkString(", ")
      if(hasContext) {
        val lambdaParams = types.tail.init.zipWithIndex.map( p => (p._1,"arg"+p._2))
        val cbArgs = "ctx" +: lambdaParams.map( _._2 )
        val cb = s"[cb,ctx](${lambdaParams.map(p => p._1 + " " + p._2).mkString(", ")}){ cb(${cbArgs.mkString(", ")}); }"
        (s"""void (*cb)($cbParams), char* ctx""", cb)
      }
      else
        (s"""void (*cb)($cbParams)""", "cb")
    }

    private def genQtSignalSender(scalaDef: DefDef)(implicit data: Data): String = {
      val cls = data.cxxFQClassName
      val method = genQtMethodName(scalaDef)
      s"""&$cls::$method"""
    }

    private def genQtMethodName(scalaDef: DefDef)(implicit data: Data): String = {
      val name =scalaDef.name.toString.stripPrefix("on")
      name.head.toLower + name.tail
    }
    private def isSignal(rhs: Tree): Boolean = rhs match {
      case Ident(TermName(id)) =>
        id == "signal"
      case Select(_,name) =>
        name.toString == "signal"
      case x =>
        false
    }

    override def analyzeBody(tpe: CommonParts)(data: Data): Data =
      ( super.analyzeBody(tpe) _ andThen analyzeCxxBody(tpe) _ )(data)
  }
}
