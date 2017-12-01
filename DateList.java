/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

/**
 *
 * @author KINGSLEY OTTO
 */
public abstract class  DateList {
    // CREATE A NEW DATENODE
    protected final DateNode first = new DateNode(null);
    
    protected DateNode last = first;
    
    protected int length = 0;
	
    public int getLength(){
	return length;
    }
    //APPEND MOETHOD PLACES DATES IN LINKEDLIST IN UNSORTED FORM
    public void append(Date212 date){
	DateNode node = new DateNode(date);
	last.next = node;
	last = node;
	++length;
    }
    
    // INSERT METHOD TO PUT DATES IN A SORTED ORDER
    public void insert(Date212 date) {
	DateNode node = new DateNode(date);
	DateNode previous = first;
		
	while((previous.next != null) && (previous.next.data.compareTo(date) <= 0)){
            previous = previous.next;
		}
           
            node.next = previous.next;
            previous.next = node;
		
            if(node.next == null){
		last = node;
            }
            ++length;
           
        
	}
    
    //OVERRIDE IN ORDER FOR US TO CREATE OUR OWN TO STRING METHOD 
    @Override
    public String toString(){
	DateNode previous = first.next;
        String returnString = "";
        while (previous != null) {
            returnString += previous.data + " \n";
            previous = previous.next;
        }
        return returnString;
    }
}


