//Listing 2: Using two surbodinate classes that inherit from the thread class

public class ThreadHelloCount{
    public static void main(String [] args){
        HelloThread hello = new HelloThread();
        CountThread count = new CountThread();

        hello.start();
        count.start();

    }
}
    class HelloThread extends Thread{
        public void run(){
            int pause;

            for (int i= 0; i < 5; i++){
                try{
                    System.out.println("hello !");
                    pause = (int)(Math.random() * 3000);
                    sleep(pause);

                }
                catch(InterruptedException intEx){
                    System.out.println(intEx);
                }
            }
        }
    }
        class CountThread extends Thread{
        public void run(){
            int pause;

            for (int i= 0; i < 5; i++){
                try{
                    System.out.println(i);
                    pause = (int)(Math.random() * 3000);
                    sleep(pause);

                }
                catch(InterruptedException intEx){
                    System.out.println(intEx);
                }
            }
        }
    }
