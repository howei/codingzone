package other;

public class MaximumGap {
    public static int maximumGap(int[] num) {
        if (num == null || num.length < 2) {
        	return 0;
        } else if (num.length == 2) {
        	return num[0] > num[1] ? num[0] - num[1] : num[1] - num[0];
        }
        
        int len = num.length;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
        	if (num[i] > max) {
        		max = num[i];
        	}
        	if (num[i] < min) {
        		min = num[i];
        	}
        }

        int maxGap = (max - min)%(len-1) == 0 ? (max - min)/(len-1) : (max - min)/(len-1) + 1;
        int bucket[][] = new int[len][2];
        for(int i = 0; i < len; i++) {
        	bucket[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < len; i++) {
        	int ind = (num[i] - min)/maxGap;
        	if (bucket[ind][0] > num[i]) {
        		bucket[ind][0] = num[i];
        	} if (bucket[ind][1] < num[i]) {
        		bucket[ind][1] = num[i];
        	}
        	
        }
        int prev = 0;
        int curr = 1;
        while (curr < len) {
        	if (bucket[curr][1] != 0) {
        		if (maxGap < bucket[curr][0] - bucket[prev][1]) {
        			maxGap = bucket[curr][0] - bucket[prev][1];
        		}
        		prev = curr;
        	}
    		curr++;
        }
        return maxGap;
    }
}
