package ch19;

/*
Author: Jason Snow
Date: 02/09/21

Description: This program sorts an array list and uses generics to do so.
*/
import java.util.ArrayList;
import java.util.*;

public class Exercise19_09 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(4);
		list.add(42);
		list.add(5);
		Exercise19_09.<Integer>sort(list);
		
		System.out.print(list);
	}
	
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		E currentMin;
		int currentMinIndex;
		
		for (int i = 0; i < list.size() - 1; i++) {
			// Find the minimum in the list[i+1..list.length−2]
			currentMin = list.get(i); 
			currentMinIndex = i; 
			
			for (int j = i + 1; j < list.size(); j++) {
				if (currentMin.compareTo(list.get(j)) > 0) {
					currentMin = list.get(j); 
					currentMinIndex = j; 
				}
			}
			
			//put the currentMin at the current place in line being inspected
			if (currentMinIndex != i) {
				//places the cucrentMin in the proper place
				list.add(i, currentMin);
				//removes the duplicate of the currentMin that now exists, shifted right in the line
				list.remove(currentMinIndex+1);
			}
		}
	}
}
