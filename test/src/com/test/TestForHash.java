package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ListenYoung on 2017/7/26.
 */
public class TestForHash {
    public static Integer countNumberInArray(Integer number, int[] arr) {
        Integer result = 0;

        if (arr != null && arr.length > 0) {
            Map<Integer, Integer> sumIndexMap = new HashMap<>();
            Integer sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (sum < number) {

                } else if (sum == number) {
                    result++;
                } else {
                    int temp = sum - number;
                    if (sumIndexMap.containsKey(temp)) {
                        result += sumIndexMap.get(temp);
                    }
                }

                if (!sumIndexMap.containsKey(sum)) {
                    sumIndexMap.put(sum, 1);
                } else {
                    sumIndexMap.put(sum, sumIndexMap.get(sum) + 1);
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 5, 8, 4, 6};
        System.out.println(countNumberInArray(6, arr));
    }
}
