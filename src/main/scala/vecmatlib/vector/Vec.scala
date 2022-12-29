package vecmatlib.vector

trait Vec[V <: Vec[V]] {

  def +(v: V): V

  def plus(v: V): V = this + v

  def unary_- : V

  def negated(): V = -this

  def -(v: V): V = this + -v

  def minus(v: V): V = this - v

  def *(v: V): V

  def multiply(v: V): V = this * v

  def length: Double
}
