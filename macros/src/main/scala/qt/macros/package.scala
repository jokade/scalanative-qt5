package qt

package object macros {
  def signal: Nothing = throw new RuntimeException("the signal handler was not properly transformed during expansion of the @Qt macro!")
}
