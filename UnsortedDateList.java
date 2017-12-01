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
public class UnsortedDateList extends DateList {
      //APPEND MOETHOD PLACES DATES IN LINKEDLIST IN UNSORTED FORM
        public void add(Date212 date){
	DateNode node = new DateNode(date);
	last.next = node;
	last = node;
	++length;
    }
    
}
