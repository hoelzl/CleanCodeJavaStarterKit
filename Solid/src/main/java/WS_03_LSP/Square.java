package WS_03_LSP;

public class Square extends Rectangle {

    private double side;

    public void setSide(double side){
        this.side = side;
        super.setHeight(side);
        super.setWidth(side);
    }

    @Override
    public void setHeight(double side){
        super.setHeight(side);
        super.setWidth(side);

    }

    @Override
    public void setWidth(double side){
        super.setHeight(side);
        super.setWidth(side);
    }
}
