package diana.com.worldinfo.io;

import java.util.ArrayList;

import diana.com.worldinfo.io.model.ApiConstants;
import diana.com.worldinfo.io.model.CityDetailResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Mayra on 27/10/15.
 */
public interface ApiService {

    @GET(ApiConstants.URL_AUTO_COMPLETE)
    void searchAutoComplete(@Query(ApiConstants.ARG_QUERY)String query, Callback<ArrayList<String>> autoCompleteApiResponse);

    @GET(ApiConstants.URL_CITY_DETAIL)
    void searchCityDetails(@Query(ApiConstants.ARG_FQCN)String city, Callback<CityDetailResponse> cityDetailsApiResponse);

}
