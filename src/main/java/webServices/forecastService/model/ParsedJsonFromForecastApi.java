package webServices.forecastService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParsedJsonFromForecastApi {
    @JsonProperty("location")
    private Location location;
    @JsonProperty("current")
    private Current current;

    public ParsedJsonFromForecastApi() {
    }

    public ParsedJsonFromForecastApi(Location location, Current current) {
        this.location = location;
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "ParsedJsonFromForecastApi{" +
                "city=" + location.getName()  +
                "region=" + location.getRegion()  +
                "country=" + location.getCountry()  +
                ", temperature=" + current.getTempC() +
                '}';
    }
}
