package vecmatlib.vector

import vecmatlib.Float4

/**
 * Four-dimensional float vector.
 *
 * @param x X component of the vector
 * @param y Y component of the vector
 * @param z Z component of the vector
 * @param w W component of the vector
 */
case class Vec4f(x: Float, y: Float, z: Float, w: Float) extends Float4 with VecFloat[Vec4f] with VecAsDouble[Vec4d] {

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

  override def +(v: Vec4f): Vec4f = this + (v.x, v.y, v.z, v.w)

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

  override def unary_- : Vec4f = Vec4f(-this.x, -this.y, -this.z, -this.w)

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

  override def *(k: Float): Vec4f = Vec4f(this.x * k, this.y * k, this.z * k, this.w * k)

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

  override def *(v: Vec4f): Vec4f = this * (v.x, v.y, v.z, v.w)

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
  def dot(x: Float, y: Float, z: Float, w: Float): Float = this.x * x + this.y * y + this.z * z + this.w * w

  override def dot(v: Vec4f): Float = this.dot(v.x, v.y, v.z, v.w)

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

  override def lengthSquared: Float = this dot this

  /**
   * Returns the angle in radians between this vector and the one with the given components.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @param z Z component of the second vector
   * @param w W component of the second vector
   * @return The angle in radians between this vector and the one with the given components
   */
  def angle(x: Double, y: Double, z: Double, w: Double): Double = this.angle(Vec4d(x, y, z, w))

  /**
   * Returns the normalized vector pointing from this vector to the one with the given components.
   *
   * Using `a.directionTo(b)` is equivalent to using `(b - a).normalized`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @param z Z component of the second vector
   * @param w W component of the second vector
   * @return The normalized vector pointing from this vector to the given one
   */
  def directionTo(x: Double, y: Double, z: Double, w: Double): Vec4d = this.directionTo(Vec4d(x, y, z, w))

  /**
   * Returns the squared distance between this vector and the one with the given components.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @param z Z component of the second vector
   * @param w W component of the second vector
   * @return The squared distance between this vector and the one with the given components
   */
  def distanceSquaredTo(x: Float, y: Float, z: Float, w: Float): Float = this.distanceSquaredTo(Vec4f(x, y, z, w))

  /**
   * Returns the squared distance between this vector and the one with the given components.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @param z Z component of the second vector
   * @param w W component of the second vector
   * @return The squared distance between this vector and the one with the given components
   */
  def distanceSquaredTo(x: Double, y: Double, z: Double, w: Double): Double = this.distanceSquaredTo(Vec4d(x, y, z, w))

  /**
   * Returns the distance between this vector and the one with the given components.
   *
   * Using `a.distanceTo(b)` is equivalent to using `(b - a).length`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @param z Z component of the second vector
   * @param w W component of the second vector
   * @return The distance between this vector and the one with the given components
   */
  def distanceTo(x: Double, y: Double, z: Double, w: Double): Double = this.distanceTo(Vec4d(x, y, z, w))

  /**
   * Returns this vector reflected from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(x: Float, y: Float, z: Float, w: Float): Vec4f = this.reflect(Vec4f(x, y, z, w))

  /**
   * Returns this vector reflected from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(x: Double, y: Double, z: Double, w: Double): Vec4d = this.reflect(Vec4d(x, y, z, w))

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(x: Float, y: Float, z: Float, w: Float): Vec4f = this.bounce(Vec4f(x, y, z, w))

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(x: Double, y: Double, z: Double, w: Double): Vec4d = this.bounce(Vec4d(x, y, z, w))

  /**
   * Returns this vector projected onto the one with the given components.
   *
   * @param x X component of the vector to project onto
   * @param y Y component of the vector to project onto
   * @param z Z component of the vector to project onto
   * @param w W component of the vector to project onto
   * @return This vector projected onto the one with the given components
   */
  def project(x: Float, y: Float, z: Float, w: Float): Vec4f = this.project(Vec4f(x, y, z, w))

  /**
   * Returns this vector projected onto the one with the given components.
   *
   * @param x X component of the vector to project onto
   * @param y Y component of the vector to project onto
   * @param z Z component of the vector to project onto
   * @param w W component of the vector to project onto
   * @return This vector projected onto the one with the given components
   */
  def project(x: Double, y: Double, z: Double, w: Double): Vec4d = this.project(Vec4d(x, y, z, w))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Float, y: Float, z: Float, w: Float): Vec4f = this.slide(Vec4f(x, y, z, w))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Double, y: Double, z: Double, w: Double): Vec4d = this.slide(Vec4d(x, y, z, w))

  /**
   * Casts this vector to an int vector.
   *
   * @return A vector same as this one cast to int
   */
  def toInt: Vec4i = Vec4i(this.x.toInt, this.y.toInt, this.z.toInt, this.w.toInt)

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
  def ==(x: Float, y: Float, z: Float, w: Float): Boolean = this.x == x && this.y == y && this.z == z && this.w == w

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
  def equals(x: Float, y: Float, z: Float, w: Float): Boolean = this == (x, y, z, w)
}

object Vec4f {
  /** Shorthand for `new Vec4f(0.0f, 0.0f, 0.0f, 0.0f)` */
  val Zero: Vec4f = Vec4f(0.0f, 0.0f, 0.0f, 0.0f)
  /** Shorthand for `new Vec4f(1.0f, 1.0f, 1.0f, 1.0f)` */
  val One: Vec4f = Vec4f(1.0f, 1.0f, 1.0f, 1.0f)
}
