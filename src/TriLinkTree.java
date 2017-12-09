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
public class TriLinkTree {
    private Node root;
    private int oneValue;
    private int twoValue;
    
    public boolean delete(int key)
    {
        return recFind(root ,key, true);
    }
    
    public boolean find(int key)
    {
        return recFind(root ,key, false);
    }
    
    private boolean recFind(Node current, int key, boolean del)
    {
        boolean answer = false;
        if (current != null)
        {
        if (key <= current.getV1())
        {
            if (current.low != null) answer = recFind(current.low,key,del);
        }
        else if (key > current.getV1())
        {
            if (!current.isEmptyV2() && current.getV2() > key) 
            {
                if (current.middle != null) answer = recFind(current.middle,key,del);
            }
            if (!current.isEmptyV2() && current.getV2() <= key) 
            {
                if (current.high != null) answer = recFind(current.high,key,del);
            }  
            
        }
        
        if (current.getV1() == key && !current.isDeletedV1) 
        {
           current.isDeletedV1 = del; //delete if we are deleting
           answer = true; 
        }
            
        
        if (current.getV2() == key && !current.isDeletedV2) 
        {
           current.isDeletedV2 = del; //delete if we are deleting
           answer = true; 
        }      
        }         
        return answer;
    }
    
    public void addNum(int num)
    {
        if (root == null)
        {
            root = new Node();
            root.setV1(num);
        }
        else
            addNumRec(root, num);
    }
    
    private void addNumRec(Node current, int num)
    {  // this is an if else nightmare ;(
        //first check for a deleted value...
        if (!current.isEmptyV1() && current.isDeletedV1 && current.getV1() == num)
            current.isDeletedV1 = false;
        else if (!current.isEmptyV2() && current.isDeletedV2 && current.getV2() == num)
            current.isDeletedV2 = false;
        else if (current.isEmptyV2())
        {
            if (num >= current.getV1())
            {
                current.setV2(num);
            }
            else
            {
                if (current.low == null)
                {
                    Node tmp = new Node();
                    tmp.setV1(num);
                    tmp.parent = current;
                    current.low = tmp;     
                }
                else
                {
                    addNumRec(current.low, num);
                }
            }
        }
        else
        {
            if (num <= current.getV1())
            {
                if (current.low == null)
                {
                    Node tmp = new Node();
                    tmp.setV1(num);
                    tmp.parent = current;
                    current.low = tmp;     
                }
                else
                    addNumRec(current.low, num);
            }
            else if (num > current.getV1() && num < current.getV2())
            {
                if (current.middle == null)
                {
                    Node tmp = new Node();
                    tmp.setV1(num);
                    tmp.parent = current;
                    current.middle = tmp;     
                }
                else
                    addNumRec(current.middle, num);
            }
            else // must be greater than or equal to V2
            {
                if (current.high == null)
                {
                    Node tmp = new Node();
                    tmp.setV1(num);
                    tmp.parent = current;
                    current.high = tmp;     
                }
                else
                    addNumRec(current.high, num);
            }
        }         
    }
    
    public String printTri()
    {   
        oneValue = 0;
        twoValue = 0;
        return "<html><b>Tree Values:</b><br>" + recPrintTri(root) + recCountTri(root);
    }
    
    private String recPrintTri(Node current)
    {
        String answer = "";

        if (current != null)
        {
            answer += recPrintTri(current.low);
            if (!current.isDeletedV1 && !current.isEmptyV1()) answer += current.getV1() + ", ";
            answer += recPrintTri(current.middle);
            if (!current.isDeletedV2 && !current.isEmptyV2()) answer += current.getV2() + ", ";
            answer += recPrintTri(current.high);
        }
        //if (current == root)
        //   answer += "<br><br>Total Words: " + totalWords;
        return answer;
    }
    
    private String recCountTri(Node current)
    {
        

        if (current != null)
        {
            if (current.isEmptyV2())
                oneValue++;
            else
                twoValue++;
            
            recCountTri(current.low);
            recCountTri(current.middle);
            recCountTri(current.high);
        }
        //if (current == root)
        //   answer += "<br><br>Total Words: " + totalWords;
        
        return "<br><br><b>Node Occupancy</b><br>One value nodes: " + oneValue 
                + "<br>Two value nodes: " + twoValue;
    }
}
