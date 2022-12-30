package vecmatlib.matrix

import vecmatlib.vector.VecDouble

trait MatAsDouble[M <: MatDouble[M, V], V <: VecDouble[V]] {

  def toDouble: M

  def +(m: M): M = this.toDouble + m

  def plus(m: M): M = this + m

  def -(m: M): M = this.toDouble - m

  def minus(m: M): M = this - m

  def *(k: Double): M = this.toDouble * k

  def multipliedBy(k: Double): M = this * k

  def *(v: V): V = this.toDouble * v

  def multiply(v: V): V = this * v

  def *(m: M): M = this.toDouble * m

  def multiply(m: M): M = this * m
}
