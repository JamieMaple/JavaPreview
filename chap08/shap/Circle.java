package shap;

public class Circle extends Shap {
    final int wheels = 2;
    @Override public void draw() {
        print("Circle.draw()");
    }
    @Override public void erase() {
        print("Circle.erase()");
    }
    public int wheels() {
        return wheels;
    }
    public void ride() {
        print("ride " + wheels() + " wheels!");
    }
}

