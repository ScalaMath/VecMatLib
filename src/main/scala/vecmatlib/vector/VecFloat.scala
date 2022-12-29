package vecmatlib.vector

trait VecFloat[I <: VecInt[I, F, D], F <: VecFloat[I, F, D], D <: VecDouble[I, F, D]] extends Vec[F] {

  def +(v: I): F

  def plus(v: I): F = this + v

  def +(v: D): D

  def plus(v: D): D = this + v

  def -(v: I): F = this + -v

  def minus(v: I): F = this - v

  def -(v: D): D = this + -v

  def minus(v: D): D = this - v

  def *(k: Float): F

  def multipliedBy(k: Float): F = this * k

  def *(k: Double): D

  def multipliedBy(k: Double): D = this * k

  def /(k: Float): F = this * (1.0f / k)

  def dividedBy(k: Float): F = this / k

  def /(k: Double): D = this * (1.0 / k)

  def dividedBy(k: Double): D = this / k

  def *(v: I): F

  def multiply(v: I): F = this * v

  def *(v: D): D

  def multiply(v: D): D = this * v

  def dot(v: I): Float

  def dot(v: F): Float

  def dot(v: D): Double

  def lengthSquared: Float

  override def length: Double = Math.sqrt(this.lengthSquared)

  def normalized: D = this / this.length
}
