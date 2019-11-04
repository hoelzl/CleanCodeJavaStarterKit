package WS_04_ISP.WS_Tree.Problem;

import java.util.List;

public interface Tree<T> {

    public T findMin();
    public T findMax();
    public List<T> traverse();
    public void rotateLeft();
    public void rotateRight();

}
