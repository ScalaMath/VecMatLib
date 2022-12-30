package vecmatlib.matrix

import vecmatlib.vector.VecFloat

trait MatAsFloat[M <: MatFloat[M, V], V <: VecFloat[V]] {

  def toFloat: M

  def +(m: M): M = this.toFloat + m

  def plus(m: M): M = this + m

  def -(m: M): M = this.toFloat - m

  def minus(m: M): M = this - m

  def *(k: Float): M = this.toFloat * k

  def multipliedBy(k: Float): M = this * k

  def *(v: V): V = this.toFloat * v

  def multiply(v: V): V = this * v

  def *(m: M): M = this.toFloat * m

  def multiply(m: M): M = this * m
}
