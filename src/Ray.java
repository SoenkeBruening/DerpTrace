public class Ray {
	Vec3f origin;
	Vec3f direction;
	float t;
	Primitive hit;

	public Ray() {
		this.origin = new Vec3f(0.0f, 0.0f, 0.0f);
		this.direction = new Vec3f(0.0f, 0.0f, 0.0f);
		this.t = 0.0f;
	}

	public Ray(Vec3f origin, Vec3f direction, float t) {
		this.origin = origin;
		this.direction = direction;
		this.t = t;
	}

}
