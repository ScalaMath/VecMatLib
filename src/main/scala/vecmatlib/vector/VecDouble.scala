package vecmatlib.vector

trait VecDouble[D <: VecDouble[D]] extends VecBase[D] {

  def +(v: VecAsDouble[D]): D = this + v.toDouble

  def plus(v: VecAsDouble[D]): D = this + v

  def -(v: VecAsDouble[D]): D = this - v.toDouble

  def minus(v: VecAsDouble[D]): D = this - v

  def *(k: Double): D

  def multipliedBy(k: Double): D = this * k

  def /(k: Double): D = this * (1.0 / k)

  def dividedBy(k: Double): D = this / k

  def *(v: VecAsDouble[D]): D = this * v.toDouble

  def multiply(v: VecAsDouble[D]): D = this * v

  def dot(v: D): Double

  def dot(v: VecAsDouble[D]): Double = this dot v.toDouble

  def lengthSquared: Double

  override def length: Double = Math.sqrt(this.lengthSquared)

  def normalized: D = this / this.length
}
