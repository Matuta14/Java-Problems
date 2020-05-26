package sortedlist;

import java.util.ArrayList;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class BinarySearchSortedList implements SortedList {

    public ArrayList <Integer> list = new ArrayList<>(); 

    //Add element to the list
    @Override
    public  void add(int element){
        index i = findIndex(0, list.size(), element);
        list.add(i, element);   
    }

    //Returns amount of elements in the list
    @Override
    public int size(){
       return list.size()
    }

    //Returns true if the list is empty
    @Override
    public boolean isEmpty(){
        if(list.size())
            return true;
        return false;
    }

    //Removes element from the list
    //Return true if element like this exists, return false otherwise;
    @Override
    public boolean remove(int element){
        int i = findIndex(0, list.size(), element);
      
        if(list.get(i) == element){
            list.remove(i);
            return true;
        } else return false;
    }

    //Returns all the elements seperated with ',';
    @Override
    public String toString(){
        String s = "";

        for(int i = 0; i < list.size(); i++){
            s += Integer.toString(list.get(i)) + ",";
        }

        return s;
    }


    private int findIndex(int firstIndex, int lastIndex, int element){
        while(firstIndex < lastIndex){
            int middle = (lastIndex + firstIndex) / 2;
            if(element > list.get(middle)){
                firstIndex = middle + 1;
            } else {
                lastIndex = middle;
            }
        }
        return firstIndex;
    }
}

