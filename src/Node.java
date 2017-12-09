/******************************************************
‘***  Final - TriLink Trees
‘***  Gabriel Brown
‘******************************************************
‘*** To Demonstrate a made up Data Structure
‘***
‘******************************************************
‘*** 12/08/2017
‘******************************************************
‘*****************************************************/


/**
 *
 * @author Gabe
 */
public class Node {
    private int V1;
    private int V2;
    private boolean isEmptyV1 = true;// would not need this with a dataItem class
    private boolean isEmptyV2 = true;// would not need this with a dataItem class
    public boolean isDeletedV1 = false;
    public boolean isDeletedV2 = false;
    public Node parent;
    public Node low;
    public Node middle;
    public Node high;
    
    public int getV1() {
        return V1;
    }

    public void setV1(int V1) {
        this.V1 = V1;
        isEmptyV1 = false;
        isDeletedV1 = false;
    }

    public int getV2() {
        return V2;
    }

    public void setV2(int V2) {
        this.V2 = V2;
        isEmptyV2 = false;
        isDeletedV2 = false;
    }

    public boolean isEmptyV1() {
        return isEmptyV1;
    }

    public boolean isEmptyV2() {
        return isEmptyV2;
    }
    
    public void deleteV1() {
        isDeletedV1 = true;
    }

    public void deleteV2() {
        isDeletedV2 = true;
    }
    
}
