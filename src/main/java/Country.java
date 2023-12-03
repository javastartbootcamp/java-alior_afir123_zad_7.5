public class Country {
    private final String code;
    private final String name;
    private final int population;

    public Country(String name, String code,  int population) {
        this.code = code;
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return name +" ("+code+") ma "+population+" ludności.";
    }
}