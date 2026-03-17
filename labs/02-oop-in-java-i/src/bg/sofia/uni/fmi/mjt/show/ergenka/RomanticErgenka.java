package bg.sofia.uni.fmi.mjt.show.ergenka;

import bg.sofia.uni.fmi.mjt.show.date.DateEvent;

public class RomanticErgenka extends AbstractErgenka {
    private final String favouriteDateLocation;

    public RomanticErgenka(String name, short age, int romanceLevel, int humorLevel, int rating,
            String favouriteDateLocation) {
        super(name, age, romanceLevel, humorLevel, rating);
        this.favouriteDateLocation = favouriteDateLocation;

    }

    @Override
    public void reactToDate(DateEvent dateEvent) {
        int newRating = (this.getRomanceLevel() * 7) / dateEvent.getTensionLevel()
                + (this.getHumorLevel() / 3);

        if (dateEvent.getLocation().equals(this.favouriteDateLocation))
            newRating += 5;
        if (dateEvent.getDuration() < 30)
            newRating -= 3;
        else if (dateEvent.getDuration() > 120)
            newRating -= 2;

        this.setRating(newRating);
    }
}
