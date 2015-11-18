package diana.com.worldinfo.io;

import java.util.ArrayList;

import diana.com.worldinfo.io.model.ApiConstants;
import diana.com.worldinfo.io.model.CityDetailResponse;
import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by Mayra on 27/10/15.
 */
public class ApiClient {

    public static ApiService mApiService;
    public static ApiService getApiService(){
        if (mApiService == null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstants.AUTOCOMPLETE_BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            mApiService = restAdapter.create(ApiService.class);
        }
        return mApiService;
    }

//    @GET AutoComplete
    public static void searchAutoComplete(String query, Callback<ArrayList<String>> autoCompleteApiResponse){
        getApiService().searchAutoComplete(query, autoCompleteApiResponse);
    }

    public static void searchCityDescription(String city, Callback<CityDetailResponse> cityDetailsApiResponse){
        getApiService().searchCityDetails(city, cityDetailsApiResponse);
    }
}
