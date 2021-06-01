public class Main {

    public static void main(String[] args) {
        final int TIME_TO_START = 1000;
        final int TIME_TO_STOP_RECEIVING = 10000;

        IncomingCall incomingCall = new IncomingCall();
        Operator operator = new Operator(incomingCall);

        Thread incomingCalls = new Thread(null, incomingCall::call ,"Входящие звонки");
        incomingCalls.start();

        //Время необходимое для начального формирования очереди
        try {
            Thread.sleep(TIME_TO_START);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(null, operator::takeCall, "Anton").start();
        new Thread(null, operator::takeCall, "Ivan").start();
        new Thread(null, operator::takeCall, "Olga").start();
        new Thread(null, operator::takeCall, "Helmut").start();
        new Thread(null, operator::takeCall, "John").start();

        try {
            Thread.sleep(TIME_TO_STOP_RECEIVING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        incomingCalls.interrupt();
    }
}
