public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int TIME_TO_START = 1000;
        final int TIME_TO_STOP_RECEIVING = 10000;

        IncomingCall incomingCall = new IncomingCall();
        Operator operator = new Operator(incomingCall);

        Thread incomingCalls = new Thread(null, incomingCall::call ,"Входящие звонки");
        incomingCalls.start();

        try {
            incomingCalls.join(TIME_TO_START);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        Thread operator1 = new Thread(null, operator::takeCall, "Anton");
        Thread operator2 = new Thread(null, operator::takeCall, "Ivan");
        Thread operator3 = new Thread(null, operator::takeCall, "Olga");
        Thread operator4 = new Thread(null, operator::takeCall, "Helmut");
        Thread operator5 = new Thread(null, operator::takeCall, "Anton");

        operator1.start();
        operator2.start();
        operator3.start();
        operator4.start();
        operator5.start();

        try {
            Thread.sleep(TIME_TO_STOP_RECEIVING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        incomingCalls.interrupt();
    }
}
