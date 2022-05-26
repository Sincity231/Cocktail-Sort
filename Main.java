/**
 * @author      Uddam Bhathal <Uddamsingh14@gmail.com>
 * @version     1
 * @since       1
 */
import java.util.Arrays;
public class Main {
    //initializing global variables based on if the array is sorted or not
    static int comparison = 0;
    static int sortedComparison = 0;
    public static void main(String[] args) {
        // initializing array
        int[] array = {4,5,2,3,1};
        int check = 1;
        //looping through array to check if array is reversed
        for(int i = 0; i < array.length-1; i++){
            if(array[i] > array[i+1]){
                check+=1;
            }
        }
        //printing original and sorted array
        System.out.println("Original Array: " + Arrays.toString(array));
        cocktailSort(array);
        System.out.println("Sorted Array:  " + Arrays.toString(array));
        if(check==array.length){ //printing number of comparisons for reversed array
            System.out.println("Comparisons: "+comparison);
        }
        else if(comparison==0){ //printing number of comparisons for sorted array
            System.out.println("Comparisons: "+sortedComparison);
        }
        else{ //printing number of comparisons for random array
            int total = comparison+sortedComparison;
            System.out.println("Comparisons: "+total);
        }
    }
    public static void cocktailSort(int[] array) {
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i <= array.length - 2; i++) {
                sortedComparison++;
                if (array[i] > array[i + 1]) {
                    comparison++;
                    //checks the elements from the start and sorts them together going forwards
                    int temp = array[i]; //assigning first comparison integer to temp variable
                    array[i] = array[i + 1]; //changing first integer to second integer value
                    array[i + 1] = temp; //changing second integer to first integer value
                    swap = true; //allowing swap to be true in order for backwards sorting to occur
                }
            }
            if (!swap) {
                //exit loop if elements have been sorted
                break;
            }
            swap = false;
            for (int i = array.length - 2; i >= 0; i--) {
                sortedComparison++;
                if (array[i] > array[i + 1]) {
                    comparison++;
                    //checks the elements from the ending and sorts them together going backwards
                    int temp = array[i]; //assigning first comparison integer to temp variable
                    array[i] = array[i + 1]; //changing first integer to second integer value
                    array[i + 1] = temp; //changing second integer to first integer value
                    swap = true; //allowing swap to be true in order for forwards sorting to occur
                }
            }
        }
        while (swap);
        //loop repeats forever until array is sorted
    }
}
