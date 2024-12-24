package arrays.java;

import java.util.Arrays;

public class SecondLargest {

    public static void main(String[] args) {

        int[] arr = {20, 60, 50, 34, 5, 6, 99, 8, 17};

        System.out.println(getSecondLargest(arr));
        System.out.println(getSecondLargestStream(arr));


    }

    public static int getSecondLargest(int[] arr) {


        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > secondMax) {
                secondMax = arr[i];

                if (secondMax > max) {
                    int temp = max;
                    max = secondMax;
                    secondMax = temp;
                }

            }
        }


        return secondMax;
    }

    public static int getSecondLargestStream(int[] arr) {


        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;

        return Arrays.stream(arr).boxed().sorted().skip(arr.length - 2).findFirst().get();

    }


}
