
public abstract class Light {
	protected Scene scene;
	
	
	public Light(Scene scene){
		this.scene = scene;
	}
	public Light(){}
	
	public abstract boolean illuminate(Ray ray, Vec3f intensity);

}
