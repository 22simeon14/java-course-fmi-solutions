package bg.sofia.uni.fmi.mjt.show.elimination;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

public class PublicVoteEliminationRule implements EliminationRule {

    private final String[] votes;

    public PublicVoteEliminationRule(String[] votes) {
        this.votes = votes;
    }

    @Override
    public Ergenka[] eliminateErgenkas(Ergenka[] ergenkas) {
        int neededVotes = votes.length / 2 + 1;

        String keyName;
        int currentVotes;

        for (int i = 0; i < ergenkas.length; i++) {
            keyName = ergenkas[i].getName();
            currentVotes = 0;
            for (int j = 0; j < votes.length; j++) {
                if (votes[j].equals(keyName)) {
                    currentVotes++;
                }
                if (currentVotes == neededVotes) {
                    Ergenka[] result = new Ergenka[ergenkas.length - 1];
                    int index = 0;
                    for (Ergenka e : ergenkas) {
                        if (!e.getName().equals(keyName)) {
                            result[index++] = e;
                        }
                    }
                    return result;
                }
            }
        }

        return ergenkas;
    }
}
