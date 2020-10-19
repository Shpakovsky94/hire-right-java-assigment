package webServices.forecastService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {
    @JsonProperty("temp_c")
    private double tempC;
    @JsonProperty("condition")
    private Condition condition;

    public Current() {
    }

    public Current(double tempC, Condition condition) {
        this.tempC = tempC;
        this.condition = condition;
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
