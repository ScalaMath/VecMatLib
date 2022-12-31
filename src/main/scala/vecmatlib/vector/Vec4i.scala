package vecmatlib.vector

import vecmatlib.Int4

/**
 * Four-dimensional int vector.
 *
 * @param x X component of the vector
 * @param y Y component of the vector
 * @param z Z component of the vector
 * @param w W component of the vector
 */
case class Vec4i(x: Int, y: Int, z: Int, w: Int) extends Int4 with VecInt[Vec4i] with VecAsFloat[Vec4f] with VecAsDouble[Vec4d] {

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @param w W component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Int, y: Int, z: Int, w: Int): Vec4i = Vec4i(this.x + x, this.y + y, this.z + z, this.w + w)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @param w W component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def plus(x: Int, y: Int, z: Int, w: Int): Vec4i = this + (x, y, z, w)

  override def +(v: Vec4i): Vec4i = this + (v.x, v.y, v.z, v.w)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @param w W component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Float, y: Float, z: Float, w: Float): Vec4f = Vec4f(this.x + x, this.y + y, this.z + z, this.w + w)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @param w W component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def plus(x: Float, y: Float, z: Float, w: Float): Vec4f = this + (x, y, z, w)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @param w W component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Double, y: Double, z: Double, w: Double): Vec4d = Vec4d(this.x + x, this.y + y, this.z + z, this.w + w)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @param w W component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def plus(x: Double, y: Double, z: Double, w: Double): Vec4d = this + (x, y, z, w)

  override def unary_- : Vec4i = Vec4i(-this.x, -this.y, -this.z, -this.w)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @param w W component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Int, y: Int, z: Int, w: Int): Vec4i = this + (-x, -y, -z, -w)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @param w W component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def minus(x: Int, y: Int, z: Int, w: Int): Vec4i = this - (x, y, z, w)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @param w W component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Float, y: Float, z: Float, w: Float): Vec4f = this + (-x, -y, -z, -w)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @param w W component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def minus(x: Float, y: Float, z: Float, w: Float): Vec4f = this - (x, y, z, w)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @param w W component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Double, y: Double, z: Double, w: Double): Vec4d = this + (-x, -y, -z, -w)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @param w W component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def minus(x: Double, y: Double, z: Double, w: Double): Vec4d = this - (x, y, z, w)

  override def *(k: Int): Vec4i = Vec4i(this.x * k, this.y * k, this.z * k, this.w * k)

  override def /(k: Int): Vec4i = Vec4i(this.x / k, this.y / k, this.z / k, this.w / k)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @param w Value by which the W component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Int, y: Int, z: Int, w: Int): Vec4i = Vec4i(this.x * x, this.y * y, this.z * z, this.w * w)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @param w Value by which the W component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def multiply(x: Int, y: Int, z: Int, w: Int): Vec4i = this * (x, y, z, w)

  override def *(v: Vec4i): Vec4i = this * (v.x, v.y, v.z, v.w)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @param w Value by which the W component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Float, y: Float, z: Float, w: Float): Vec4f = Vec4f(this.x * x, this.y * y, this.z * z, this.w * w)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @param w Value by which the W component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def multiply(x: Float, y: Float, z: Float, w: Float): Vec4f = this * (x, y, z, w)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @param w Value by which the W component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Double, y: Double, z: Double, w: Double): Vec4d = Vec4d(this.x * x, this.y * y, this.z * z, this.w * w)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @param w Value by which the W component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def multiply(x: Double, y: Double, z: Double, w: Double): Vec4d = this * (x, y, z, w)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @param w W component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Int, y: Int, z: Int, w: Int): Int = this.x * x + this.y * y + this.z * z + this.w * w

  override def dot(v: Vec4i): Int = this.dot(v.x, v.y, v.z, v.w)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @param w W component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Float, y: Float, z: Float, w: Float): Float = this.x * x + this.y * y + this.z * z + this.w * w

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @param w W component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Double, y: Double, z: Double, w: Double): Double = this.x * x + this.y * y + this.z * z + this.w * w

  override def lengthSquared: Int = this dot this

  override def toFloat: Vec4f = Vec4f(this.x.toFloat, this.y.toFloat, this.z.toFloat, this.w.toFloat)

  override def toDouble: Vec4d = Vec4d(this.x.toDouble, this.y.toDouble, this.z.toDouble, this.w.toDouble)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param z Z component of the vector
   * @param w W component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def ==(x: Int, y: Int, z: Int, w: Int): Boolean = this.x == x && this.y == y && this.z == z && this.w == w

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param z Z component of the vector
   * @param w W component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def equals(x: Int, y: Int, z: Int, w: Int): Boolean = this == (x, y, z, w)
}

object Vec4i {
  /** Shorthand for `new Vec4i(0, 0, 0, 0)` */
  val Zero: Vec4i = Vec4i(0, 0, 0, 0)
  /** Shorthand for `new Vec4i(1, 1, 1, 1)` */
  val One: Vec4i = Vec4i(1, 1, 1, 1)
}
