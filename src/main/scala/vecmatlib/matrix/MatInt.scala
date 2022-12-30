package vecmatlib.matrix

import vecmatlib.vector.VecInt

trait MatInt[M <: MatInt[M, V], V <: VecInt[V]] extends MatBase[M, V] {

  def *(k: Int): M

  def multipliedBy(k: Int): M = this * k
}
