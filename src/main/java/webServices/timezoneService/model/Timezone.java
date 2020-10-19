package webServices.timezoneService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Timezone{

    @JsonProperty("timezone_identifier")
    private String timezoneIdentifier;
    @JsonProperty("timezone_abbr")
    private String timezoneAbbr;

    public Timezone() {
    }

    public Timezone(String timezoneIdentifier, String timezoneAbbr) {
        this.timezoneIdentifier = timezoneIdentifier;
        this.timezoneAbbr = timezoneAbbr;
    }

    public String getTimezoneIdentifier() {
        return timezoneIdentifier;
    }

    public void setTimezoneIdentifier(String timezoneIdentifier) {
        this.timezoneIdentifier = timezoneIdentifier;
    }

    public String getTimezoneAbbr() {
        return timezoneAbbr;
    }

    public void setTimezoneAbbr(String timezoneAbbr) {
        this.timezoneAbbr = timezoneAbbr;
    }

    @Override
    public String toString() {
        return "Timezone{" +
                "timezoneIdentifier='" + timezoneIdentifier + '\'' +
                ", timezoneAbbr='" + timezoneAbbr + '\'' +
                '}';
    }
}