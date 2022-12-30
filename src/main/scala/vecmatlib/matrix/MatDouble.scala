package vecmatlib.matrix

import vecmatlib.vector.{VecAsDouble, VecDouble}

trait MatDouble[M <: MatDouble[M, V], V <: VecDouble[V]] extends MatBase[M, V] {

  def +(m: MatAsDouble[M, V]): M = this + m.toDouble

  def plus(m: MatAsDouble[M, V]): M = this + m

  def -(m: MatAsDouble[M, V]): M = this - m.toDouble

  def minus(m: MatAsDouble[M, V]): M = this - m

  def *(k: Double): M

  def multipliedBy(k: Double): M = this * k

  def *(v: VecAsDouble[V]): V = this * v.toDouble

  def multiply(v: VecAsDouble[V]): V = this * v

  def *(m: MatAsDouble[M, V]): M = this * m.toDouble

  def multiply(m: MatAsDouble[M, V]): M = this * m
}
