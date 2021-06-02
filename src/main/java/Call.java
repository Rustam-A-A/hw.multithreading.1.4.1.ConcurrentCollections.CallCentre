public class Call {
    private static double DECIMALS = 10000000;
    Integer phoneNumber;
    private int callNumber;
    private static int countCalls = 0;

    public Call(Integer phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public Call(int phoneNumber, int callNumber){
        this.phoneNumber = phoneNumber;
        this.callNumber = callNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(int callNumber) {
        this.callNumber = callNumber;
    }

    public static Integer generatePhoneNumber(){
        Integer phoneNumber = (int) Math.round((Math.random()*DECIMALS));
        return phoneNumber;
    }

    public static Integer countCalls(){
        countCalls++;
        return countCalls;
    }

}
