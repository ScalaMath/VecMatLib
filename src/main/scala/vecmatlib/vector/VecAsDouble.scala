package vecmatlib.vector

trait VecAsDouble[D <: VecDouble[D]] {

  def toDouble: D

  def +(v: D): D = this.toDouble + v

  def plus(v: D): D = this + v

  def -(v: D): D = this.toDouble - v

  def minus(v: D): D = this - v

  def *(k: Double): D = this.toDouble * k

  def multipliedBy(k: Double): D = this * k

  def /(k: Double): D = this.toDouble / k

  def dividedBy(k: Double): D = this / k

  def *(v: D): D = this.toDouble * v

  def multiply(v: D): D = this * v

  def dot(v: D): Double = this.toDouble dot v

  def normalized: D = this.toDouble.normalized
}
