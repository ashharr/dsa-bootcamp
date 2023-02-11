public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        // write a function that takes in a number and prints it
        // print first 5 numbers: 1 2 3 4 5
        int ans = fibo(10);
//        System.out.println(ans);

        int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int index = binarySearch(intArray,0, intArray.length-1,10);
        System.out.println(index);
    }

    static int fibo(int n) {
        if (n == 0 || n ==1 ){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
    static int binarySearch(int[] arr,int left,int right, int x) {
        int mid = (left + right) /2;
        int i;
        if (arr[mid] == x) {
            return mid;
        }
        else  if( x >= arr[mid]){
            i = binarySearch(arr, mid+1, right, x);
        }
        else if( x < arr[mid]){
            i =binarySearch(arr, left, mid, x);
        }
        else{
                return -1;
            }
        return i;
    }
}
