package WS_02_OCP.WS_BalanceLoader.Problem;

public class RoundRobin extends LoadBalancer {

    public RoundRobin(){

        super.algorithm = Algorithm.ROUND_RBON;
    }

    @Override
    public void balance() {

        System.out.println("Apply Round Robin");
    }
}
