package bg.sofia.uni.fmi.mjt.show.elimination;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

public class LowAttributeSumEliminationRule implements EliminationRule {
    private int threshold;

    public LowAttributeSumEliminationRule(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public Ergenka[] eliminateErgenkas(Ergenka[] ergenkas) {
        int count = 0;
        for (Ergenka e : ergenkas) {
            if (e.getHumorLevel() + e.getRomanceLevel() < threshold)
                count++;
        }

        Ergenka[] result = new Ergenka[ergenkas.length - count];
        int index = 0;
        for (Ergenka e : ergenkas) {
            if (e.getHumorLevel() + e.getRomanceLevel() >= threshold) {
                result[index++] = e;
            }
        }

        return result;
    }
}
