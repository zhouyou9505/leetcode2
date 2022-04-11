package com.leetcode;

import javax.jws.soap.SOAPBinding;

public class SortColor75 {

    public static void main(String[] args) {
        int[] nums = {2,0,1};
        new SortColor75().sortColors(nums);
    }

    public void sortColors(int[] nums) {

        //如果是0就放到最前面，如果是2就放到最后面
        //双指针，i<=q

        int p = 0;
        int q = nums.length-1;
        for(int i=0;i<=q;i++){
            if(nums[i] == 0){
                nums[i] = nums[p];
                nums[p] = 0;
                ++p;
            }

            if(nums[i] == 2){
                nums[i] = nums[q];
                nums[q] = 2;
                --q;
                //2,1,2 如果是这样，换出来的是2 就回退的
                if(nums[i] != 1){
                    --i;
                }
            }
        }
    }
}

