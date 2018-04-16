package naive.bayes;

public class ModelData {
    private String outlook;
    private String temperature;
    private String humidity;
    private String wind;
    private String playtenis;

    public ModelData(String[] s){
        this.outlook        = s[0];
        this.temperature    = s[1];
        this.humidity       = s[2];
        this.wind           = s[3];
        this.playtenis      = s[4];
    }
    
    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        this.outlook = outlook;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getPlaytenis() {
        return playtenis;
    }

    public void setPlaytenis(String playtenis) {
        this.playtenis = playtenis;
    }
    
}
