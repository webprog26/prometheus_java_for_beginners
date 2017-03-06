/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirdweektask;

/**
 *
 * @author webpr
 */
public class LinkedList {
    
    private Node mHead = null;
    private Node mTail = null;
    private int mSize;

    public LinkedList() {
        this.mSize = 0;
    }
    
    public void add(Integer data) {
        Node node = new Node();
        node.setData(data);
        
        if(mHead == null){
            mHead = node;
            mTail = node;
        } else {
            mTail.setNext(node);
            mTail = node;
        }
        this.mSize++;
    }
     
    public Integer get(int index) {
        if(mHead == null || index >= mSize){
        //list is empty return null
        return null;
        }
        
        return find(index).getData();
    }
     
    public boolean delete(int index) {
        //if index >= size or < 0 return false
        if(index >= mSize || index < 0){
            return false;
        }
        
        //if first element
        if(index == 0){
            //find first element
            Node firstNode = find(index);
            //if list isn't empty
            if(firstNode != null){
                            System.out.println("first data is " + firstNode.getData());
                //if we got second element
                if(firstNode.getNext() != null){
                    //move first element right at one position
                    mHead = firstNode.getNext();
                    //delete first element;
                    firstNode = null;
                    //descrease size
                    this.mSize--;
                    //operation successful return true
                    return true;
                } else {
                    //there is only one element in the list
                    mHead = null;
                    mTail = null;
                    //descrease size
                    this.mSize--;
                    //operation successful return true
                    return true;
                }
            } else {
                return false;
            }
        }
        
        //if last element
        if(index == (this.mSize - 1)){
            //find penult element
            Node penultNode = findPrev(index);
            if(penultNode != null){
                //find last element
                Node lastNode = find(index);
                if(lastNode != null){
                    mTail = penultNode;
                    lastNode = null;
                     //descrease size
                    this.mSize--;
                    //operation successful return true
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        //looking for the numbered element
        Node currentNode = find(index);
        if(currentNode == null){
            return false;
        }
        
        Node prevNode = findPrev(index);
        if(prevNode != null){
            prevNode.setNext(currentNode.getNext());
        } else {
            mHead = currentNode.getNext();
        }
        currentNode = null;
        this.mSize--;
        return true;
    }
     
    public int size() {
        return this.mSize;
    }
    
    private Node find(int index){
        int i = 0;
        Node node = mHead;
        while(i < index){
            node = node.getNext();
            i++;
        }
        return node;
    }
    
    private Node findPrev(int index){
        int i = 0;
        Node node = mHead;
        while(i < (index - 1)){
            node = node.getNext();
            i++;
        }
        
        if(node != null){
            return node;
        }
        
        return null;
    }
}
