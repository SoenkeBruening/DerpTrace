
public abstract class Primitive {

	protected Vec3f color;
	protected Light light;
	
	public abstract boolean intersect(Ray ray);
	public abstract Vec3f getNormal(Ray ray);
	
	public boolean occluded(Ray ray){
		return intersect(ray);
	}
	
	public Vec3f getColor(){
		return color;
	}
	
	public Vec3f traceLight(Ray ray){
		//TODO: derp
		return null;
	}
}
