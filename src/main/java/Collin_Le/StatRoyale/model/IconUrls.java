package Collin_Le.StatRoyale.model;

public class IconUrls {
    String medium;
    String evolutionMedium;

    public IconUrls() {}

    public IconUrls(String medium, String evolutionMedium) {
        this.medium = medium;
        this.evolutionMedium = evolutionMedium;
    }

    public String getMedium() {
        return medium;
    }
    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getEvolutionMedium() { return evolutionMedium; }
    public void setEvolutionMedium(String evolutionMedium) { this.evolutionMedium = evolutionMedium; }
}
