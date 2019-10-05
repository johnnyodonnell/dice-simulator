import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;


class Simulator {
    public static void main(String[] args) {
        int numberOfTrials = Integer.valueOf(args[0]);

        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for (int i = 0; i < numberOfTrials; ++i) {
            int sum = roll() + roll();
            counts.put(sum, counts.getOrDefault(sum, 0) + 1);
        }

        for (int i = 2; i <= 12; ++i) {
            double percentage =
                100 * counts.getOrDefault(i, 0) / (double)  numberOfTrials;
            System.out.println(i + "\t: " +  percentage);
        }
    }

    private static int roll() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}

