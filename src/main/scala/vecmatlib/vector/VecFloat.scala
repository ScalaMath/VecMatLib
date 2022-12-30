package vecmatlib.vector

trait VecFloat[F <: VecFloat[F]] extends VecBase[F] {

  def +(v: VecAsFloat[F]): F = this + v.toFloat

  def plus(v: VecAsFloat[F]): F = this + v

  def -(v: VecAsFloat[F]): F = this - v.toFloat

  def minus(v: VecAsFloat[F]): F = this - v

  def *(k: Float): F

  def multipliedBy(k: Float): F = this * k

  def /(k: Float): F = this * (1.0f / k)

  def dividedBy(k: Float): F = this / k

  def *(v: VecAsFloat[F]): F = this * v.toFloat

  def multiply(v: VecAsFloat[F]): F = this * v

  def dot(v: F): Float

  def dot(v: VecAsFloat[F]): Float = this dot v.toFloat

  def lengthSquared: Float

  override def length: Double = Math.sqrt(this.lengthSquared)
}
