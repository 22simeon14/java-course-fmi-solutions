package bg.sofia.uni.fmi.mjt.show.ergenka;

import bg.sofia.uni.fmi.mjt.show.date.DateEvent;

public class HumorousErgenka extends AbstractErgenka {

    public HumorousErgenka(String name, short age, int romanceLevel, int humorLevel, int rating) {
        super(name, age, romanceLevel, humorLevel, rating);
    }

    @Override
    public void reactToDate(DateEvent dateEvent) {
        int newRating = (this.getHumorLevel() * 5) / dateEvent.getTensionLevel()
                + (this.getRomanceLevel() / 3);

        if (dateEvent.getDuration() >= 30 && dateEvent.getDuration() <= 90)
            newRating += 4;
        if (dateEvent.getDuration() < 30)
            newRating -= 2;
        else if (dateEvent.getDuration() > 90)
            newRating -= 3;

        this.setRating(newRating);
    }
}
