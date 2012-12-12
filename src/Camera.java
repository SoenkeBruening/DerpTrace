import javax.swing.JTextField;


public abstract class Camera {

	int resX;
    int resY;
	
    public Camera(){}
	public Camera(int resX, int resY){
		this.resX = resX;
		this.resY = resY;
	}
	 public abstract boolean initRay(float x, float y, Ray ray);
}
