
# VecMatLib

A Scala library for vectors and matrix math.

## Project goals

The goal of VecMatLib is to provide easy-to-use and efficient linear algebra operations, needed by any 3D application.

Vectors and matrices structures are written in Scala to make the best use possible of Scala's operator overloading.

VecMatLib was designed to be usable both in Scala and Java projects.
All methods with symbolic names have an alias for better interoperability with Java.

All operations in VecMatLib are designed to **not** modify the object on which the operation is invoked to respect the principles of purity and immutability of functional programming.
Every operation returns a new object.

## Vector math

VecMatLib offers 2-dimensional, 3-dimensional, and 4-dimensional vectors of type Int, Float, and Double with all their basic operations.
All operations do not modify the vector on which the operation is performed.

Scala example:
```Scala
var a = Vec3f(1.0f, 1.5f, 1.0f)
var b = Vec3f(0.5f, 1.0f, 0.5f)

// 'a' and 'b' will not change
val c = a + b

// Increase 'a' by 'b'
a = a + b // or a += b

// Other operations
val dotProduct = a dot b
val normal = a.normalized
val reflection = b.reflect(normal)
```

Java example:
```Java
Vec3f a = new Vec3f(1.0f, 1.5f, 1.0f);
Vec3f b = new Vec3f(0.5f, 1.0f, 0.5f);

// 'a' and 'b' will not change
Vec3f c = a.plus(b);

// Increase 'a' by 'b'
a = a.plus(b);

// Other operations
float dotProduct = a.dot(b);
Vec3f normal = a.normalized();
Vec3f reflection = b.reflect(normal);
```

## Matrix math

VecMatLib offers 2x2, 2x3, 3x3, 3x4, and 4x4 matrices of type Int, Float, and Double with all their basic operations as well as methods to build matrices out of basic transformations.
All operations do not modify the matrix on which the operation is performed.

The following example shows how a translation matrix is created and how the transformation is applied.

Scala example:
```Scala
var position = Vec4f(x, y, z, 1.0f)
val translation = Mat4f.translation(tx, ty, tz)

// will result in (x + tx, y + ty, z + tz, 1.0f)
position = translation * position
```

Java example:
```Java
Vec4f position = new Vec4f(x, y, z, 1.0f);
Mat4f translation = Mat4f.translation(tx, ty, tz);

// will result in (x + tx, y + ty, z + tz, 1.0f)
position = translation.multiply(position);
```

Matrices can be multiplied together, allowing to create more complex transformations.
The same pattern can be used to create projection matrices and camera view matrices.

Scala example:
```Scala
// Create a 3x4 transformation matrix
val transform = Mat3x4f.translation(tx, ty, tz) * Mat4f.rotation(rx, ry, rz) * Mat4f.scaling(sx, sy, sz)
var point = Vec3f(x, y, z)

// Applies first a translation by (tx, ty, tz),
// then a rotation by (rx, ry, rz) in radians,
// then a scaling by (sx, sy, sz)
point = transform * (point, 1.0f)
```

Java example:
```Java
// Create a 3x4 transformation matrix
Mat3x4f transform = Mat3x4f.translation(tx, ty, tz)
        .multiply(Mat4f.rotation(rx, ry, rz))
        .multiply(Mat4f.scaling(sx, sy, sz));
Vec3f point = new Vec3f(x, y, z);

// Applies first a translation by (tx, ty, tz),
// then a rotation by (rx, ry, rz) in radians,
// then a scaling by (sx, sy, sz)
point = transform.multiply(point, 1.0f);
```

## Quaternions

VecMatLib provides a `Quatf` and a `Quatd` class for single-precision and double-precision quaternions respectively.
Operations concerning quaternions follow the same principles as the ones concerning vectors and matrices.

```Scala
val q1 = Quatd(0.7071068, 0.0, 0.7071068, 0.0)
val q1 = Quatd(0.7071068, 0.0, 0.0, 0.7071068)
val composed = q1 * q2
```

Unit quaternions can be used to represent rotations.

```Scala
val quaternion = Quatd(Vec3d.Up, math.Pi / 2.0) // Represents a rotation of 90 degrees around the y axis
val point = Vec3d(1.0, 0.0, 0.0)
point = quaternion.rotate(point) // Results in Vec3d(0.0, 0.0, -1.0)
```

Rotations can also be specified in terms of euler angles.
The default rotation order is `ZYX`.
Other rotation orders can be specified with the `EulerOrder` enum.

```Scala
val euler = Vec3d(math.Pi * 0.5, 0.0, math.Pi * 0.5)
val quaternion = Quatd.fromEuler(euler, EulerOrder.XYZ)
val matrix = Mat3d.rotation(quaternion)
```

## Complex numbers

An additional library for complex numbers is [CmplxLib](https://github.com/ScalaMath/CmplxLib).

CmplxLib depends on VecMatLib and provides complex numbers, as well as complex vectors and complex matrices.

## Color math

Colors can be seen as 3D or 4D vectors, whose components are the red, green, blue, and alpha components of the color.

A library for color math that depends on VecMatLib is [ColorLib](https://github.com/ScalaMath/ColorLib).

## Using with LWJGL

VecMatLib can be used together with [LWJGL](https://lwjgl.org) to build transformation matrices and set uniform variables in shaders.

This example first creates a 3D float vector, then loads the value into the active shader program.

```Java
Vec3f lightPosition = new Vec3f(-3.0f, 10.0f, 6.0f);
int location = GL20.glGetUniformLocation(program, "light_position");
GL20.glUniform3f(location, lightPosition.x(), lightPosition.y(), lightPosition.z());
```

Matrices can be loaded into shaders by converting them into float buffers by using the `BufferUtils` class provided by LWJGL.

```Java
Mat3f matrix = ...
FloatBuffer buffer = BufferUtils.createFloatBuffer(9);
buffer.put(matrix.m00()); buffer.put(matrix.m01()); buffer.put(matrix.m02());
buffer.put(matrix.m10()); buffer.put(matrix.m11()); buffer.put(matrix.m12());
buffer.put(matrix.m20()); buffer.put(matrix.m21()); buffer.put(matrix.m22());
GL20.glUniformMatrix3fv(location, true, buffer.flip());
```

Note that matrices in OpenGL uses column-major matrix order, therefore the matrix must be transposed by passing `true` to the OpenGL method when it is loaded.

The `Mat4f` and `Mat4d` classes also contain methods to create orthographic or perspective projection matrices.

```Java
// 70 degrees fov, 16/9 aspect ratio, 0.1 near plane distance, 1000 far plane distance
Mat4f projection = Mat4f.perspectiveProjection(Math.toRadians(70.0f), 16.0f / 9.0f, 0.1f, 1000.0f);
FloatBuffer buffer = BufferUtils.createFloatBuffer(16);
buffer.put(matrix.m00()); buffer.put(matrix.m01()); buffer.put(matrix.m02()); buffer.put(matrix.m03());
buffer.put(matrix.m10()); buffer.put(matrix.m11()); buffer.put(matrix.m12()); buffer.put(matrix.m13());
buffer.put(matrix.m20()); buffer.put(matrix.m21()); buffer.put(matrix.m22()); buffer.put(matrix.m23());
buffer.put(matrix.m30()); buffer.put(matrix.m31()); buffer.put(matrix.m32()); buffer.put(matrix.m33());
GL20.glUniformMatrix4fv(location, true, buffer.flip());
```

## Multithreading

Due to VecMatLib not using any internal or temporal objects during any computations, neither modifying objects on which operations are called, it can be used safely in a multithreaded application.

## Add VecMatLib to your project

### sbt

```sbt
libraryDependencies += "io.github.scalamath" % "vecmatlib" % "3.0"
```

### Maven

```xml
<dependency>
    <groupId>io.github.scalamath</groupId>
    <artifactId>vecmatlib</artifactId>
    <version>3.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'io.github.scalamath:vecmatlib:3.0'
```

## Questions and answers

Q: Why does VecMatLib not use scala 3?

A: One of the design goals of VecMatLib is to be usable both in Scala and Java. Support for Scala 3 in IDEs is still actively being developed.

## Contributing

VecMatLib was developed by a single person.
Initially a university project, later completed and turned into a fully usable library.

Your contributions are always welcome!
Please submit a pull request or open an issue if you want to contribute with bug fixes, code improvements, documentation, and better unit test coverage.

## Support

Support the project with a donation:

* [PayPal](https://paypal.me/hexagonnico)
* [Ko-fi](https://ko-fi.com/HexagonNico)