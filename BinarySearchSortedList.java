package sortedlist;

import java.util.ArrayList;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class BinarySearchSortedList implements SortedList {

	public int size = 0;
    public ArrayList <Integer> list = new ArrayList<>(); 

    //Add element to the list
    public  void add(int element){
        int a = 0;
        int b = size;
        while(a < b){
            int middle = (b + a)/2;
            if(element > list.get(middle)){
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        list.add(a, element);
        size++;   
    }

    //Returns amount of elements in the list
    public int size(){
       return size;
    }

    //Returns true if the list is empty
    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }

    //Removes element from the list
    //Return true if element like this exists, return false otherwise;
    public boolean remove(int element){

        int a = 0;
        int b = size;
        while(a < b){
            int middle = (b + a)/2;
            if(element > list.get(middle)){
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        
        if(list.get(a) == element){
            list.remove(a);
            size--;
            return true;
        } else return false;
        
    }

    //Returns all the elements seperated with ',';
    public String toString(){
        String s = "";

        for(int i = 0; i < list.size(); i++){
            s += Integer.toString(list.get(i)) + ",";
        }
        return s;
    }
}

