package WS_02_OCP.Example_HR.Problem;

public class HumanRessourceManagement {

    public void callUpon(Employee employee){

        if(employee instanceof Secretary){
            checkEmails();
            prepeareMeeting();
            callCustomer();
        } else if(employee instanceof Developer){
            writeCode();
            testCode();
        } else {
            throw new IllegalArgumentException("unknown type!");
        }

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

    public void writeCode(){

        System.out.println("Writing code...");
    }

    public void testCode(){

        System.out.println("Testing code...");
    }
}


