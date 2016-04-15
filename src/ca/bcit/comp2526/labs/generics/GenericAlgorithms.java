package ca.bcit.comp2526.labs.generics;

public class GenericAlgorithms {

    
    
    public static <T extends Number> T getSumOfTwoLargestInts(T[] arrayOfInts) {
        
        
        T first;
        T second;
        T temp;
        
        
        
        if(arrayOfInts.length == 1) {
            first = arrayOfInts[0];
        }
        else if (arrayOfInts.length >= 2){
            first = arrayOfInts[0];
            second = arrayOfInts[1];
            
            for(int i=2; i < arrayOfInts.length;i++){
               /* if(first < second){
                    temp = first;
                    first = second;
                    second = temp;
                }
                if (second < arrayOfInts[i]){
                    second = arrayOfInts[i];
                }*/
            }
        }
        
       // temp = first + second;
        
        return null;
   
    }
    
     
    
    public static void main(String args[]){
        Integer a[] = {2, 1}; // 3
        Integer b[] = {2, 4, 6, 8, 10, 12, 14}; // 26
        Integer c[] = {14, 12, 10, 8, 10, 12, 14}; // 28
        Integer d[] = {8, 8, 8, 8, 8, 8, 8}; // 16
        
        System.out.println("a) " + getSumOfTwoLargestInts(a));
        System.out.println("b) " + getSumOfTwoLargestInts(b));
        System.out.println("c) " + getSumOfTwoLargestInts(c));
        System.out.println("d) " + getSumOfTwoLargestInts(d));
        
    }
    
}
