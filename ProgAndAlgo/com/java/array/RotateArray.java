package com.java.array;

import java.util.Arrays;
import java.util.List;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("Ratated array-" + Arrays.toString(rotate(arr, 2)));

    }

    static int[] rotate(int[] nums, int k) {
        for(int i=0; i<k; i++){
            int temp = nums[i];
            int temp1 =0;
            for(int j=i+1; j < nums.length-2; j++){
                temp = nums[j];
              nums[j] = nums[j-1];
               temp1 = temp;


            }
            nums[i] = nums[nums.length-1-i];
        }

        return nums;
    }
}
