package dynamic.programming;

import java.util.LinkedList;
import java.util.Queue;

public class MaxSumContiguousSubArray {

    public static int calculateUsingQueue(int [] nums){
        int maxSum = calculateSum(nums);
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(maxSum);
        for(int i=1; i<nums.length; i++){
            int currSum = q.peek() - nums[nums.length-i];
            q.add(currSum);
            if(currSum > maxSum){
                maxSum = currSum;
            }
            for(int j=0; j<i; j++){
                currSum = q.remove() - nums[j];
                q.add(currSum);
                if(currSum > maxSum){
                    maxSum = currSum;
                }
            }

        }
        return maxSum;
    }

    public static int calculateSum(int [] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum;
    }

    public static int calculateUsingMultipleLoops(int [] nums){
        int n = nums.length;
        int maxSum = nums[0];
        for(int subArraySize=1; subArraySize<=nums.length; subArraySize++){
            for(int i=0; i<n-subArraySize+1; i++){
                int sum = 0;
                for(int j=i; j<i+subArraySize; j++){
                    sum += nums[j];
                }
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int calculateUsingDP(int [] nums){

        int maxSoFar = Integer.MIN_VALUE;
        int maxTillEnd = 0;
        int start = 0;
        int s = 0;
        int end = 0;

        for(int i=0; i<nums.length; i++){
            maxTillEnd += nums[i];
            if(maxSoFar < maxTillEnd){
                maxSoFar = maxTillEnd;
                start = s;
                end = i;
            }
            if(maxTillEnd < 0){
                maxTillEnd = 0;
                s = i + 1;
            }
        }
        return maxSoFar;
    }
}
