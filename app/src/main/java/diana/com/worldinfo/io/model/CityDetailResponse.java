package diana.com.worldinfo.io.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mayra on 27/10/15.
 */
public class CityDetailResponse {

    @SerializedName("geobytescode")
    String countryCode;

    @SerializedName("geobytescountry")
    String country;

    @SerializedName("geobytescity")
    String city;

    @SerializedName("geobytesfqcn")
    String fullyQualifiedName;

    @SerializedName("geobyteslatitude")
    String cityLatitude;

    @SerializedName("geobyteslongitude")
    String cityLongitude;

    @SerializedName("geobytescapital")
    String countryCapital;

    @SerializedName("geobytestimezone")
    String countryTimeZone;

    @SerializedName("geobytespopulation")
    String cityPopulation;

    @SerializedName("geobytesmapreference")
    String countryLocation;

    @SerializedName("geobytescurrency")
    String countryCurrency;

    @SerializedName("geobytescurrencycode")
    String countryCurrencyCode;

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    public String getCityLatitude() {
        return cityLatitude;
    }

    public String getCityLongitude() {
        return cityLongitude;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public String getCountryTimeZone() {
        return countryTimeZone;
    }

    public String getCityPopulation() {
        return cityPopulation;
    }

    public String getCountryLocation() {
        return countryLocation;
    }

    public String getCountryCurrency() {
        return countryCurrency;
    }

    public String getCountryCurrencyCode() {
        return countryCurrencyCode;
    }
}
