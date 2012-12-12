public class Triangle extends Primitive {

	Vec3f a;
	Vec3f b;
	Vec3f c;

	public Triangle(Vec3f a, Vec3f b, Vec3f c, Light light, Vec3f color) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public Vec3f getNormal(Ray ray) {
		Vec3f normal = b.minus(a).cross(c.minus(a)); // cross(b-a, c-a)
		normal.normalize();
		return normal;
	}

	@Override
	public boolean intersect(Ray ray) {
		 	final Vec3f edge1 = b.minus(a);
		    final Vec3f edge2 = c.minus(a);
		    
		    final Vec3f pvec = ray.direction.cross(edge2);
		    
		    final float det = edge1.dot(pvec);
		    if (Math.abs(det) < Float.MIN_VALUE) return false;
		    
		    final float inv_det = 1.0f / det;
		    
		    final Vec3f tvec = ray.origin.copy();
		    tvec.sub(a);
		    
		    float lambda = tvec.dot(pvec);
		    lambda *= inv_det;
		    
		    if (lambda < 0.0f || lambda > 1.0f) return false;

		    final Vec3f qvec = tvec.cross(edge1);
		    float mue = ray.direction.dot(qvec);
		    mue *= inv_det;
		    
		    if (mue < 0.0f || mue+lambda > 1.0f) return false;

		    float f = edge2.dot(qvec);
		    f *= inv_det;
		    if (ray.t <= f || f <  1E-4  ) return false;
		    
		    ray.t = f;
		    ray.hit = this;
		    
		    return true;
	}
}
