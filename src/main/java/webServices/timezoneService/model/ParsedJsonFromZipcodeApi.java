package webServices.timezoneService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParsedJsonFromZipcodeApi {
    @JsonProperty("zip_code")
    private String zipCode;
    @JsonProperty("timezone")
    private Timezone timezone;

    public ParsedJsonFromZipcodeApi() {
    }

    public ParsedJsonFromZipcodeApi(String zipCode, Timezone timezone) {
        this.zipCode = zipCode;
        this.timezone = timezone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "ParsedJsonFromZipcodeApi{" +
                "zipCode='" + zipCode + '\'' +
                ", timezone Abbr=" + timezone.getTimezoneAbbr() + '\'' +
                ", timezone Identifier=" + timezone.getTimezoneIdentifier() + '\'' +
                '}';
    }
}



