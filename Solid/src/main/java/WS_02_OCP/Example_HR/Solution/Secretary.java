package WS_02_OCP.Example_HR.Solution;

public class Secretary extends Employee {


    public Secretary(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void perform() {
        checkEmails();
        prepeareMeeting();
        callCustomer();
    }


    public void checkEmails(){

        System.out.println("Checking Emails...");
    }
    public void prepeareMeeting(){

        System.out.println("Prepearing Meeting...");
    }
    public void callCustomer(){

        System.out.println("Calling customer...");
    }
}
