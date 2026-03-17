package bg.sofia.uni.fmi.mjt.show;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;
import bg.sofia.uni.fmi.mjt.show.elimination.EliminationRule;
import bg.sofia.uni.fmi.mjt.show.date.DateEvent;

public class ShowAPIImpl implements ShowAPI {

    private Ergenka[] ergenkas;
    private EliminationRule[] defaultEliminationRules;

    @Override
    public Ergenka[] getErgenkas() {
        return new Ergenka[0];
    };

    @Override
    public void playRound(DateEvent dateEvent) {
        for (Ergenka e : ergenkas) {
            e.reactToDate(dateEvent);
        }
        eliminateErgenkas(defaultEliminationRules);
    }

    @Override
    public void eliminateErgenkas(EliminationRule[] eliminationRules) {
        if (eliminationRules == null || eliminationRules.length == 0) {
            eliminationRules = defaultEliminationRules;
        }
        for (EliminationRule rule : eliminationRules) {
            rule.eliminateErgenkas(ergenkas);
        }
    }

    @Override
    public void organizeDate(Ergenka ergenka, DateEvent dateEvent) {
        ergenka.reactToDate(dateEvent);
    }

    public ShowAPIImpl(Ergenka[] ergenkas, EliminationRule[] defaultEliminationRules) {
        this.ergenkas = ergenkas;
        this.defaultEliminationRules = defaultEliminationRules;
    }
}