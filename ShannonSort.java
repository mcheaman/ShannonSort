public class ShannonSort {

    public static int[] Shannon(int[] arr){
        //Initialize gap_sequence, original gap, starting index, and finishing index
        int gap_increase = 10;
        int gap = 10;
        int start = 0;
        int finish = gap;
        //Create variables to track the number of different gaps as well as the 'height' of the imaginary 2d arry at each gap
        int height = 0;
        int gaps = 0;
        if(arr.length % gap == 0){
            gaps = arr.length / gap;
        }
        else{
            gaps = (arr.length / gap) + 1;
        }
         //Loop through every gap size
        for(int i = 0; i < gaps; i++){ 
            //Calculate 'height' of the imaginary 2d arry at each gap
            height = 0;
            if(arr.length % gap == 0){
                height = arr.length / gap;
            }
            else{
                height = (arr.length / gap) + 1;
            }
         
            //Loop through the entire array with the current gap size
            for(int j = 0; j < height; j++){ 
                //sort the gap with insertion sort
                arr = insertionGapSort(arr, start, finish);
                //move to next gap
                start += gap;
                finish += gap;    
            }
            //// To check that insertion has gaps in sorted order
            //printGapArr(arr, gap);
            //System.out.println("\n");

            //Increase gap size
            gap += gap_increase;

            //If gap size exceeds array size, set gap to the whole array
            if(gap > arr.length){
                gap = arr.length;
            }
            //Reset start and finish indicies
            start = 0;
            finish = gap;
        }
        return arr;
    }
    //Sorts a gap (start -> finish) using insertion sort
    public static int[] insertionGapSort(int[] arr, int start, int finish){
        //Ensure that gap does not try to access past array bounds
        if(finish > arr.length){
            finish = arr.length;
        }
        //Insertion sort algorithm
        for (int i = start+1; i < finish; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
	}
    //Print the current array as if it were a 2d aray [heigh][gap]. Used for debugging
    private static void printGapArr(int [] arr,int gap){
        int height;
        int row = gap;
        if(arr.length % gap == 0){
            height = arr.length / gap;
        }
        else{
            height = (arr.length / gap) + 1;
        }
        for(int i = 0; i < height; i++){
            if(i == height - 1){
                row = arr.length - (i * gap);
            }
            for(int j = 0; j < row; j++){
                if(j+(i*gap) > arr.length + 1){
                    continue;
                }
                System.out.print(arr[j+(i*gap)]+ "\t");
            }
            System.out.println();
        }
    }
        
    public static void main(String[] args) {
        int[] input = {6,13,22,31,2,7,12,3,55,67,22,17,30,40, 19,6,22,45,61,31,53,35,1,18,2,23,78,51,2,66,23,9,5,100,20};
        //ShannonSort input
        int[] output = Shannon(input);
        //Display output
        for(int i = 0; i< output.length; i++){
            System.out.print(output[i]+ "  " );
        }
    }

      
     
}
