package vecmatlib;

import vecmatlib.vector.Vec2f;
import vecmatlib.vector.Vec3f;

public class Test {

	public static void main(String[] args) {
		Vec3f vec3f = new Vec3f(1.0f, 1.0f, 1.0f);
		Vec3f vec3f1 = vec3f.plus(new Vec3f(1.0f, 1.0f, 1.0f));
		Vec3f vec3f2 = vec3f1.minus(new Vec3f(1.0f, 1.0f, 1.0f));
		Vec3f vec3f3 = vec3f2.multipliedBy(1.5f);
		Vec3f vec3f4 = vec3f3.multiply(new Vec3f(2.0f, 2.0f, 2.0f));
	}
}
