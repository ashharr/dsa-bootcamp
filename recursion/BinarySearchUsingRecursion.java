public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        // write a function that takes in a number and prints it
        // print first 5 numbers: 1 2 3 4 5
        int ans = fibo(10);
       System.out.println(ans);

        int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int index = binarySearch(intArray,0, intArray.length-1,10);
        System.out.println(index);
        System.out.println(factorial(5));
        System.out.println(sumOfDigits(4556));
        System.out.println(countSteps(8, 0));


    }

    static int fibo(int n) {
        if (n == 0 || n ==1 ){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
    static int binarySearch(int[] arr,int left,int right, int x) {
        int mid = (left + right) /2;
        if (left > right){
            return -1;
        }
        if (arr[mid] == x) {
            return mid;
        }
        else  if( x >= arr[mid]){
            return binarySearch(arr, mid+1, right, x);
        }
        return binarySearch(arr, left, mid, x);

    }
    public static int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n-1); 
        
    }
    public static int sumOfDigits( int n) {
        if(n == 0) {
            return 0;
        }
        return n%10 + sumOfDigits((int)n/10);
    }

    public static int countSteps( int num, int c){
        if(num==0){
            return c;
        }
        if(num % 2 == 0){
            return countSteps((int)num/2, c+1);
        }
        return countSteps(num - 1, c+1);
    }
}
