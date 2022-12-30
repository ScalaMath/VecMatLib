package vecmatlib.vector

trait VecInt[I <: VecInt[I]] extends VecBase[I] {

  def *(k: Int): I

  def multipliedBy(k: Int): I = this * k

  def /(k: Int): I

  def dividedBy(k: Int): I = this / k

  def dot(v: I): Int

  def lengthSquared: Int

  override def length: Double = Math.sqrt(this.lengthSquared)
}
