package qt.widgets

import qt.core.{QAbstractTableModel, QVariant, QtItemFlags}

import scala.scalanative._
import unsafe._
import cxx._
import scala.scalanative.annotation.InlineSource
import scala.scalanative.runtime.{Intrinsics, RawPtr}
/*
trait TableModelData {
  def rowCount: Int
  def columnCount: Int
  def get(row: Int, column: Int, result: QVariant): Unit

  def flags(row: Int, column: Int): QtItemFlags.Value = QtItemFlags.NoItemFlags
}

@Cxx(namespace = "snqt", classname = "TableModel")
class TableModel private() extends QAbstractTableModel {
  private var _data: TableModelData = _
  private val _value = QVariant()
  private def setCallbacks(snobj: RawPtr, callbacks: Ptr[Byte]): Unit = extern

  def data: TableModelData = _data

  private def init(): Unit = {
    val ptr = stackalloc[TableModel.Callbacks]
    ptr._1 = TableModel.rowCount
    ptr._2 = TableModel.columnCount
    ptr._3 = TableModel.get
    ptr._4 = TableModel.flags
    setCallbacks(Intrinsics.castObjectToRawPtr(this),ptr.asInstanceOf[Ptr[Byte]])
  }
  init()

  override def rowCount: Int = _data.rowCount
  override def columnCount: Int = _data.columnCount
}

@InlineSource("Cxx",
"""
#include <QAbstractTableModel>
namespace snqt {
  struct TableModelCallbacks {
    int (*rowCount)(void* snobj);
    int (*columnCount)(void* snobj);
    QVariant* (*get)(void* snobj, int row, int column);
    Qt::ItemFlags (*flags)(void* snobj, int row, int column);
  };

  class TableModel : QAbstractTableModel {
    TableModelCallbacks callbacks;
    void* snobj;
  public:
    void setCallbacks(void* snobj, char* cb) {
      this->snobj = snobj;
      this->callbacks = *(TableModelCallbacks*)cb;
    }
    int rowCount(const QModelIndex &parent = QModelIndex()) const override { return callbacks.rowCount(snobj); }
    int columnCount(const QModelIndex &parent = QModelIndex()) const override { return callbacks.columnCount(snobj); }
    QVariant data(const QModelIndex &index, int role) const override { return *callbacks.get(snobj,index.row(),index.column()); }
    Qt::ItemFlags flags(const QModelIndex &index) const override { return callbacks.flags(snobj,index.row(),index.column()); }
  };
}
""")
object TableModel {
  private type Callbacks = CStruct4[
    // rowCount
    CFuncPtr1[RawPtr,Int],
    // columnCount
    CFuncPtr1[RawPtr,Int],
    // get
    CFuncPtr3[RawPtr,Int,Int,Ptr[Byte]],
    // flags
    CFuncPtr3[RawPtr,Int,Int,Int]]

  @inline private final def toInstance(ptr: RawPtr): TableModel = Intrinsics.castRawPtrToObject(ptr).asInstanceOf[TableModel]

  private val rowCount = new CFuncPtr1[RawPtr,Int] {
    override def apply(arg1: RawPtr): CInt = Intrinsics.castRawPtrToObject(arg1).asInstanceOf[TableModel].rowCount
  }

  private val columnCount = new CFuncPtr1[RawPtr,Int] {
    override def apply(arg1: RawPtr): CInt = toInstance(arg1)._data.columnCount
  }

  private val get = new CFuncPtr3[RawPtr,Int,Int,Ptr[Byte]] {
    override def apply(ptr: RawPtr, row: CInt, column: CInt): Ptr[Byte] = {
      val model = toInstance(ptr)
      model._data.get(row,column,model._value)
      model._value.__ptr
    }
  }

  private val flags = new CFuncPtr3[RawPtr,Int,Int,Int] {
    override def apply(ptr: RawPtr, row: Int, col: Int): Int = toInstance(ptr)._data.flags(row,col).value
  }

  @constructor
  private def apply(): TableModel = extern

  def apply(data: TableModelData): TableModel = {
    val model = apply()
    model._data = data
    model
  }
}
*/