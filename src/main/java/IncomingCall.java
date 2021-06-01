import java.util.concurrent.ArrayBlockingQueue;

public class IncomingCall {
    final private int CAPACITY = 140;
    final private int CALL_PERIOD = 100;

    ArrayBlockingQueue<Integer> currentCalls = new ArrayBlockingQueue<Integer>(CAPACITY, true);

    public void call() {
        while (!Thread.currentThread().isInterrupted()){
            Integer call = Call.generatePhoneNumber();
            Integer counter = Call.countCalls();
            currentCalls.add(call);
            System.out.println("Входящий звонок № " + counter + " номер " + call);
            try {
                Thread.sleep(CALL_PERIOD);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
