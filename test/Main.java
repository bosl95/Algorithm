

public class Main {
    public synchronized void a() {
        System.out.println("a");
        b();
    }

    public synchronized void b() {
        System.out.println("b");
    }


    public static void main(String[] args) {
        new Main().a();
    }
}
