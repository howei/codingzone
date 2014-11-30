package other;

public class GasStation {

	public static void main(String[] args) {
		int[] gas = { 0, 3, 5, 6, 2 };
		int[] cost = { 1, 3, 4, 5, 1 };
		System.out.println(canCompleteCircuit(gas, cost));

	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0
				|| gas.length != cost.length) {
			return -1;
		}

		int sumToNow = 0;
		int sumTotal = 0;
		int start = 0;
		for (int i = 0; i < gas.length; i++) {
			sumToNow += gas[i] - cost[i];
			sumTotal += gas[i] - cost[i];
			if (sumToNow < 0) {
				start = i + 1;
				sumToNow = 0;
			}
		}
		if (sumTotal < 0) {
			return -1;
		}
		return start;
	}
}
