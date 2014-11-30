package other;

public class Candy {

	public static void main(String[] args) {
		int[] ratings = {4,2,3,4,1};
		System.out.println(candy(ratings));

	}
	
    public static int candy(int[] ratings) {
    	if (ratings == null || ratings.length == 0) {
    		return 0;
    	}
    	int size = ratings.length;
    	if (size == 1) {
    		return 1;
    	}
    	
        int[] candies = new int[size];
        for (int i = 0; i < size; i++) {
        	candies[i] = 1;
        }
        for (int i = 1; i < size; i++) {
        	if (ratings[i] > ratings[i - 1]) {
        		candies[i] = candies[i - 1] + 1;
        	}
        }
        int total = candies[size - 1];
        for (int i = size - 2; i >= 0; i--) {
        	if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
        		candies[i] = candies[i + 1] + 1;
        	}
        	total += candies[i];
        }

        return total;
    }
}
