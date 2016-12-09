
public class Exercise11_1International {

}

class ThreeDPoint extends MyPoint {
  private double z;
  
  ThreeDPoint() {
    
  }
  
  ThreeDPoint(double x, double y, double z) {
    super(x, y);
    this.z = z;
  }
  
  public double getZ() {
    return z;
  }
  
  public double distance() {
    return 1; // Compute distance
  }
}
