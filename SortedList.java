package sortedlist;

public interface SortedList {
	
	//Add element to the list
	public void add(int element);
	
	//Returns amount of elements in the list
	public int size();
	
	//Returns true if the list is empty
	public boolean isEmpty();
	
	//Removes element from the list
    //Return true if element like this exists, return false otherwise;
	public boolean remove(int element);
	
	 //Returns all the elements seperated with ',';
	public String toString();
}
