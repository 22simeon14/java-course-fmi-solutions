package bg.sofia.uni.fmi.mjt.show.ergenka;

abstract class AbstractErgenka implements Ergenka {
    private final String name;
    private final short age;
    private int romanceLevel;
    private int humorLevel;
    private int rating;

    public AbstractErgenka(String name, short age, int romanceLevel, int humorLevel, int rating) {
        this.name = name;
        this.age = age;
        this.romanceLevel = romanceLevel;
        this.humorLevel = humorLevel;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public short getAge() {
        return this.age;
    }

    @Override
    public int getRomanceLevel() {
        return this.romanceLevel;
    }

    protected void setRomanceLevel(int romanceLevel) {
        if (romanceLevel >= 0)
            this.romanceLevel = romanceLevel;
    }

    @Override
    public int getHumorLevel() {
        return this.humorLevel;
    }

    protected void setHumorLevel(int humorLevel) {
        if (humorLevel > 0)
            this.humorLevel = humorLevel;
    }

    @Override
    public int getRating() {
        return this.rating;
    }

    protected void setRating(int rating) {
        if (rating > 0)
            this.rating = rating;
    }
}