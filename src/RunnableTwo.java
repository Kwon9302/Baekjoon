public class RunnableTwo implements Runnable {
    static int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++)
            count++;
    }
}
