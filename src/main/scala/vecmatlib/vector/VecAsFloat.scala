package vecmatlib.vector

trait VecAsFloat[F <: VecFloat[F]] {

  def toFloat: F

  def +(v: F): F = this.toFloat + v

  def plus(v: F): F = this + v

  def -(v: F): F = this.toFloat - v

  def minus(v: F): F = this - v

  def *(k: Float): F = this.toFloat * k

  def multipliedBy(k: Float): F = this * k

  def /(k: Float): F = this.toFloat / k

  def dividedBy(k: Float): F = this / k

  def *(v: F): F = this.toFloat * v

  def multiply(v: F): F = this * v

  def dot(v: F): Float = this.toFloat dot v
}
