
public class PointLight extends Light{
	Vec3f intensity = new Vec3f(0.0f,0.0f,0.0f);
	Vec3f position = new Vec3f(0.0f,0.0f,0.0f);

	public PointLight(Vec3f intensity, Vec3f position, Scene scene){
		this.intensity = intensity;
		this.position = position;
		this.scene = scene;
	}
	
	@Override
	public boolean illuminate(Ray ray, Vec3f intensity) {
		ray.direction = position.minus(ray.origin);
		ray.hit = null;
		ray.t = ray.direction.length();
		ray.direction.normalize();
		
		//it is reciprocal to the squared distance
	    float val = 1.0f / (ray.t * ray.t); 

	    //Multiply it with the light source's intensity
	    intensity = this.intensity.copy();
	    intensity.scale(val);
	    
		return false;
	}

}
