package diana.com.worldinfo.io.model;

/**
 * Created by Mayra on 27/10/15.
 */
public class ApiConstants {

    public static final String AUTOCOMPLETE_BASE_URL = "http://gd.geobytes.com";
    public static final String PATH_AUTOCOMPLETE = "/AutoCompleteCity";
    public static final String ARG_CALLBACK = "callback";
    public static final String ARG_QUERY = "q";

    public static final String CITY_BASE_URL = "http://gd.geobytes.com/GetCityDetails?&fqcn=";
    public static final String PATH_CITY_DETAIL = "/GetCityDetails";
    public static final String ARG_FQCN = "fqcn";

    public static final String URL_AUTO_COMPLETE = PATH_AUTOCOMPLETE;
    public static final String URL_CITY_DETAIL = PATH_CITY_DETAIL;
}
