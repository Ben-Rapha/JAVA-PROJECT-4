/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;
import java.util.Comparator;

/**
 *
 * @author KINGSLEY OTTO
 */
public class DateComparator implements Comparator<Date212> {
    
    @Override
    public int compare(Date212 date1, Date212 date2){
        return date1.compareTo(date2);
    }
    
}
