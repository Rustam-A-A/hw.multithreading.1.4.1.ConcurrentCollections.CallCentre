import java.util.concurrent.ArrayBlockingQueue;

public class IncomingCall {
    final private int CAPACITY = 200;
    final private int CALL_PERIOD = 100;

    ArrayBlockingQueue<Call> currentCalls = new ArrayBlockingQueue<Call>(CAPACITY, true);

    public void call() {
        while (!Thread.currentThread().isInterrupted()){
            Integer phoneNumber = Call.generatePhoneNumber();
            int callNumber = Call.countCalls();
            Call call = new Call(phoneNumber, callNumber);
            currentCalls.add(call);
            System.out.println("Входящий звонок № " + call.getCallNumber() + " номер " + call.getPhoneNumber());
            try {
                Thread.sleep(CALL_PERIOD);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
