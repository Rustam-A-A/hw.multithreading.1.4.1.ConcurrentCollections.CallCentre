public class Operator{
    final private int CALL_TIME_FRAME = 3000;
    private static int counter = 0;
    IncomingCall incomingCall;

    public Operator(IncomingCall incomingCall){
        this.incomingCall = incomingCall;
    }

    public void takeCall()  {
        while(true){
            if (!incomingCall.currentCalls.isEmpty()){
                System.out.println("Оператор " + Thread.currentThread().getName() +
                        " принял звонок №" + (counter + 1) +
                        " от абонента " + incomingCall.currentCalls.poll());
                counter++;
                try {
                    Thread.sleep(CALL_TIME_FRAME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Необработанных звонков оператором " +
                        Thread.currentThread().getName() + " больше нет");
                break;
            }
        }
    }
}
