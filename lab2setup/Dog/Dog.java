package Dog;

public class Dog {
    private int size;

    public Dog(int s) {
        size = s;
    }

    /** Makes a noise. */
    public String noise() {
        if (size < 10) {
            return "yip";
        } 
        return "bark";
    }
    public static void main(){
        Dog charlie = new Dog(10);
        charlie.noise();
    }

}
