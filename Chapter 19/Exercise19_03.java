package ch19;

/*
Author: Jason Snow
Date: 02/09/21

Description: This program uses a generic lists and removes duplicates from a list of generic integers.
 */
import java.util.ArrayList;

public class Exercise19_03 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }
	
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> holder = new ArrayList<E>();
		for (int i = 0; i < list.size(); i++) {
			//check if the next element in list is not already in holder
			if (!holder.contains(list.get(i))) {
				//add it if it is not
				holder.add(list.get(i));
			}	
		}
		return holder;
	}
}
