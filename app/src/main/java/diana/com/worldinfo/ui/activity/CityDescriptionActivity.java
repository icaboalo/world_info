package diana.com.worldinfo.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import diana.com.worldinfo.R;
import diana.com.worldinfo.constant.PrefConstants;
import diana.com.worldinfo.io.ApiClient;
import diana.com.worldinfo.io.model.CityDetailResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CityDescriptionActivity extends AppCompatActivity {

    @Bind(R.id.country_code)
    TextView countryCode;

    @Bind(R.id.country_name)
    TextView countryName;

    @Bind(R.id.city_name)
    TextView cityName;

    @Bind(R.id.fully_qualified_name)
    TextView fullyQualifiedName;

    @Bind(R.id.latitude)
    TextView latitude;

    @Bind(R.id.longitude)
    TextView longitude;

    @Bind(R.id.country_capital)
    TextView countryCapital;

    @Bind(R.id.time_zone)
    TextView timeZone;

    @Bind(R.id.population)
    TextView population;

    @Bind(R.id.map_reference)
    TextView mapReference;

    @Bind(R.id.currency)
    TextView currency;

    @Bind(R.id.currency_code)
    TextView currencyCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences sharedPreferences = getSharedPreferences(PrefConstants.FILE_CITY, MODE_PRIVATE);
        String city = sharedPreferences.getString(PrefConstants.PREF_CITY, "");
        getSupportActionBar().setTitle(city);
        ButterKnife.bind(this);
        executeCityDescription(city);
    }

    public void executeCityDescription(final String city){
        ApiClient.searchCityDescription(city, new Callback<CityDetailResponse>() {
            @Override
            public void success(CityDetailResponse cityDetailResponse, Response response) {
                countryCode.setText("Country code: " + cityDetailResponse.getCountryCode());
                countryName.setText("Country name: " + cityDetailResponse.getCountry());
                cityName.setText("City name: " + cityDetailResponse.getCity());
                fullyQualifiedName.setText("FQCN: " + cityDetailResponse.getFullyQualifiedName());
                latitude.setText("Latitude: " + cityDetailResponse.getCityLatitude());
                longitude.setText("Longitude: " + cityDetailResponse.getCityLongitude());
                countryCapital.setText("Country Capital: " + cityDetailResponse.getCountryCapital());
                timeZone.setText("Country time zone: " + cityDetailResponse.getCountryTimeZone());
                population.setText("City population: " + cityDetailResponse.getCityPopulation());
                mapReference.setText("Map reference: " + cityDetailResponse.getCountryLocation());
                currency.setText("Country currency: " + cityDetailResponse.getCountryCurrency());
                currencyCode.setText("Country currency code: " + cityDetailResponse.getCountryCurrencyCode());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}
