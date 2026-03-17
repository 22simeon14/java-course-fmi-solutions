package bg.sofia.uni.fmi.mjt.show.elimination;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

public class LowestRatingEliminationRule implements EliminationRule {

    @Override
    public Ergenka[] eliminateErgenkas(Ergenka[] ergenkas) {
        int min = Integer.MAX_VALUE;
        for (Ergenka ergenka : ergenkas) {
            if (ergenka.getRating() < min)
                min = ergenka.getRating();
        }

        int count = 0;
        for (Ergenka e : ergenkas) {
            if (e.getRating() == min)
                count++;
        }

        Ergenka[] result = new Ergenka[ergenkas.length - count];
        int index = 0;
        for (Ergenka e : ergenkas) {
            if (e.getRating() != min)
                result[index++] = e;
        }

        return result;
    }
}
