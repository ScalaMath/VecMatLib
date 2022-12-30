package vecmatlib.matrix

import vecmatlib.vector.VecBase

trait MatBase[M <: MatBase[M, V], V <: VecBase[V]] {

  def +(m: M): M

  def plus(m: M): M = this + m

  def unary_- : M

  def negated: M = -this

  def -(m: M): M = this + -m

  def minus(m: M): M = this - m

  def *(v: V): V

  def multiply(v: V): V = this * v

  def transposed: M

  def negatedTransposed: M = -this.transposed

  def symmetric: Boolean = this == this.transposed

  def skewSymmetric: Boolean = this == this.negatedTransposed
  
  def *(m: M): M

  def multiply(m: M): M = this * m

  def power(exp: Int): M
}
