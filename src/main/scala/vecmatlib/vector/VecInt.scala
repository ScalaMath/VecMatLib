package vecmatlib.vector

trait VecInt[I <: VecInt[I, F, D], F <: VecFloat[I, F, D], D <: VecDouble[I, F, D]] extends Vec[I] {

  def +(v: F): F

  def plus(v: F): F = this + v

  def +(v: D): D

  def plus(v: D): D = this + v

  def -(v: F): F = this + -v

  def minus(v: F): F = this - v

  def -(v: D): D = this + -v

  def minus(v: D): D = this - v

  def *(k: Int): I

  def multipliedBy(k: Int): I = this * k

  def *(k: Float): F

  def multipliedBy(k: Float): F = this * k

  def *(k: Double): D

  def multipliedBy(k: Double): D = this * k

  def /(k: Int): I

  def dividedBy(k: Int): I = this / k

  def /(k: Float): F = this * (1.0f / k)

  def dividedBy(k: Float): F = this / k

  def /(k: Double): D = this * (1.0 / k)

  def dividedBy(k: Double): D = this / k

  def *(v: F): F

  def multiply(v: F): F = this * v

  def *(v: D): D

  def multiply(v: D): D = this * v

  def dot(v: I): Int

  def dot(v: F): Float

  def dot(v: D): Double

  def lengthSquared: Int

  override def length: Double = Math.sqrt(this.lengthSquared)

  def normalized: D = this / this.length
}
