
# VecMatLib

VecMatLib provides simple data structures for vectors and matrices and an implementation of all their basic operations that can be integrated in any Java or Scala project.

## Project goals

The goal of VecMatLib is to provide easy-to-use and efficient linear algebra operations.

Vectors and matrices structures are written in Scala to make the best use possible of Scala's operator overloading.
All methods with symbolic names have an alias for better interoperability with java.

## Vector math

All operations in VecMatLib are designed to **not** modify the object on which the operation is invoked to respect the principles of purity and immutability of functional programming.

Scala example:

```scala
var a = Vec3f(1.0f, 1.0f, 1.0f)
var b = Vec3f(0.5f, 0.5f, 0.5f)

// 'a' and 'b' will not change
val c = a + b

// Increase 'a' by 'b'
a = a + b
```

Java example:

```java
Vec3f a = new Vec3f(1.0f, 1.0f, 1.0f);
Vec3f b = new Vec3f(0.5f, 0.5f, 0.5f);

// 'a' and 'b' will not change
Vec3f c = a.plus(b);

// Increase 'a' by 'b'
a = a.plus(b);
```

The vector package offers int, float, and double vectors with all their basic operations.

```scala
val a = Vec3f(1.0f, 1.0f, 1.0f)
val b = Vec3f(0.5f, 0.5f, 0.5f)

val dotProduct = a dot b
val normal = a.normalized
val reflection = b.reflect(normal)
```

```java
Vec3f a = new Vec3f(1.0f, 1.0f, 1.0f);
Vec3f b = new Vec3f(0.5f, 0.5f, 0.5f);

float dotProduct = a.dot(b);
Vec3f normal = a.normalized();
Vec3f reflection = b.reflect(normal);
```

## Matrix math

With VecMatLib you can create matrices for geometric transformations such as translation, rotation, and scale.
None of these operations modify the matrix on which they are called.

```scala
var position = Vec4f(x, y, z, 1.0f)
val translation = Mat4f.translation(tx, ty, tz)

// will result in (x + tx, y + ty, z + tz, 1.0f)
position = translation * position
```

```java
Vec4f position = new Vec4f(x, y, z, 1.0f);
Mat4f translation = Mat4f.translation(tx, ty, tz);

// will result in (x + tx, y + ty, z + tz, 1.0f)
position = translation.multiply(position);
```

## Color math

VecMatLib also provides a structure to represent a color as four-dimensional or three-dimensional floating point tuples with values between 0.0 and 1.0.

```scala
val white = Color3f(1.0f, 1.0f, 1.0f) // RGB #FFFFFF
val green = Color3f(0.0f, 1.0f, 0.0f) // RGB #00FF00
val transparentBlue = Color4f(0.0f, 0.0f, 1.0f, 0.5f) // RGBA #0000FF88
```

Values outside the range (0.0, 1.0) are allowed.

## Using with LWJGL

VecMatLib can be used together with [LWJGL](https://lwjgl.org) to set uniform variables in shaders.

```java
Vec3f lightPosition = new Vec3f(-3.0f, 10.0f, 6.0f);
int location = GL20.glGetUniformLocation(program, "light_position");
GL20.glUniform3f(location, lightPosition.x(), lightPosition.y(), lightPosition.z());
```

An LWJGL project using VecMatLib is [Gamma Engine](https://github.com/Gamma-Engine), a general purpose graphics engine written in Java.

## Add VecMatLib to your project

VecMatLib can be added to any Java or Scala project as a dependency using [Jitpack](https://jitpack.io/).

[![](https://jitpack.io/v/HexagonNico/VecMatLib.svg)](https://jitpack.io/#HexagonNico/VecMatLib)

### Gradle

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```groovy
dependencies {
    implementation 'com.github.HexagonNico:VecMatLib:1.2.1'
}
```

### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

```xml
<dependency>
    <groupId>com.github.HexagonNico</groupId>
    <artifactId>VecMatLib</artifactId>
    <version>1.2.1</version>
</dependency>
```

### SBT

```sbt
resolvers += "jitpack" at "https://jitpack.io"
```

```sbt
libraryDependencies += "com.github.HexagonNico" % "VecMatLib" % "1.2.1"
```

## Support the project

VecMatLib was developed by a single person.

Initially a university project, later completed and turned into a fully usable library.

## Contributing

Your contributions are always welcome! Please submit a pull request or open an issue if you want to contribute with bug fixes, code improvements, documentation, and better unit test coverage.
