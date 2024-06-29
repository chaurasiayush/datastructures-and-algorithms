public class Threads {

    public static void main(String[] args) {
        TaskA a = new TaskA();
        TaskB b = new TaskB();

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);

        t1.start();
        t2.start();

        // since Runnable is a functional interface, we can use lambda functions directly

        Thread t3 = new Thread(() -> {
            for(int i=0; i<1000; i++){
                System.out.println("executed A");
            }
        });

        Thread t4 = new Thread(() -> {
            for(int i=0; i<1000; i++){
                System.out.println("Executed B");
            }
        });

        t3.start();
        t4.start();
    }
}

class TaskA implements Runnable{    // runnable is a functional interface
    public void run() {
        for(int i=0; i<1000; i++){
            System.out.println("executed A");
        }
    }
}

class TaskB implements Runnable{
    public void run() {
        for(int i=0; i<1000; i++){
            System.out.println("executed B");
        }
    }
}