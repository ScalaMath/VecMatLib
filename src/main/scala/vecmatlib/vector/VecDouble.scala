package vecmatlib.vector

trait VecDouble[I <: VecInt[I, F, D], F <: VecFloat[I, F, D], D <: VecDouble[I, F, D]] extends Vec[D] {

  def +(v: I): D

  def plus(v: I): D = this + v

  def +(v: F): D

  def plus(v: F): D = this + v

  def -(v: I): D = this + -v

  def minus(v: I): D = this - v

  def -(v: F): D = this + -v

  def minus(v: F): D = this - v

  def *(k: Double): D

  def multipliedBy(k: Double): D = this * k

  def /(k: Double): D = this * (1.0 / k)

  def dividedBy(k: Double): D = this / k

  def *(v: I): D

  def multiply(v: I): D = this * v

  def *(v: F): D

  def multiply(v: F): D = this * v

  def dot(v: I): Double

  def dot(v: F): Double

  def dot(v: D): Double

  def lengthSquared: Double

  override def length: Double = Math.sqrt(this.lengthSquared)

  def normalized: D = this / this.length
}
