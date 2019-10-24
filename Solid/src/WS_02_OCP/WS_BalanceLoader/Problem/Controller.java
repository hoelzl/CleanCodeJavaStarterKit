package WS_02_OCP.WS_BalanceLoader.Problem;

public class Controller {

    private LoadBalancer loadBalancer;

    public void balance(){
        if(loadBalancer.algorithm == Algorithm.ROUND_RBON)
            startRoundRobin(loadBalancer);
        else if(loadBalancer.algorithm == Algorithm.WEIGHTED_ROUND_ROBIN)
            startWeightedRoundRobin(loadBalancer);
    }

    public void setLoadBalancer(LoadBalancer loadBalancer) {

        this.loadBalancer = loadBalancer;
    }

    private void startRoundRobin(LoadBalancer loadBalancer) {

        loadBalancer.balance();
    }

    private void startWeightedRoundRobin(LoadBalancer loadBalancer) {

        loadBalancer.balance();
    }

}
