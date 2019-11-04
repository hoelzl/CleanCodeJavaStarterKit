package WS_05_DIP.Example_DIP_Violaition;

public class DatabaseHandler {

    private SQLDatabase sqlDatabase;

    public DatabaseHandler() {

        this.sqlDatabase = new SQLDatabase();
    }

    public void connect(){

        sqlDatabase.connect();
    }

    public void disconnect(){

        sqlDatabase.disconnect();
    }
}
