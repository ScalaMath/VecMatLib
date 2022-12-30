package vecmatlib.matrix

import vecmatlib.vector.{VecAsFloat, VecFloat}

trait MatFloat[M <: MatFloat[M, V], V <: VecFloat[V]] extends MatBase[M, V] {

  def +(m: MatAsFloat[M, V]): M = this + m.toFloat

  def plus(m: MatAsFloat[M, V]): M = this + m

  def -(m: MatAsFloat[M, V]): M = this + m.toFloat

  def minus(m: MatAsFloat[M, V]): M = this - m

  def *(k: Float): M

  def multipliedBy(k: Float): M = this * k

  def *(v: VecAsFloat[V]): V = this * v.toFloat

  def multiply(v: VecAsFloat[V]): V = this * v

  def *(m: MatAsFloat[M, V]): M = this * m.toFloat

  def multiply(m: MatAsFloat[M, V]): M = this * m
}
