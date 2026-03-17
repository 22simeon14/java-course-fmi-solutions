package bg.sofia.uni.fmi.mjt;

public class TaskDistributor {

    public static int minDifference(int[] tasks) {
        if (tasks.length == 0)
            return 0;

        int totalSum = 0;

        for (int task : tasks)
            totalSum += task;

        int halfSum = totalSum / 2 + 1;
        boolean[] possibleSums = new boolean[halfSum];

        for (int task : tasks) {
            boolean repeated = false;
            for (int j = 1; j < halfSum; j++) {
                if (j == task && repeated == false) {
                    possibleSums[j] = true;
                    repeated = true;
                    continue;
                }

                if (possibleSums[j] == true && j + task < halfSum) {
                    possibleSums[j + task] = true;
                }
            }
        }

        int s = 0;
        for (int i = halfSum - 1; i >= 1; i--) {
            if (possibleSums[i] == true) {
                s = i;
                break;
            }
        }

        return totalSum - 2 * s;
    }

    public static void main(String[] args) {
        System.out.println(minDifference(new int[] { 9, 1, 1, 1 }));
    }
}
