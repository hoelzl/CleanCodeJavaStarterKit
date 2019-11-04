package WS_06_Observer.WS_Timer;



public class AnalogClock implements Widget {

    private ClockTimer subject;

    public AnalogClock(ClockTimer subject) {
        this.subject = subject;

    }



    @Override
    public void draw() {

        int hour = subject.getHour();
        int minute = subject.getMinute();
        int second = subject.getSecond();
        System.out.println("Observer: Analog Clock{ " + hour + " : " + minute + " : " + second + " }");
    }
}
