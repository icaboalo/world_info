package diana.com.worldinfo.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import diana.com.worldinfo.R;
import diana.com.worldinfo.constant.PrefConstants;
import diana.com.worldinfo.io.ApiClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Bind(R.id.search_view)
    SearchView searchView;

    @Bind(R.id.places_list)
    ListView placesListView;

    List<String> cityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        setupSearchView();
        placesListView.setOnItemClickListener(this);
    }

    void setupSearchView(){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                executeAutoComplete(newText);
                return false;
            }
        });
    }

    void setupPlaceList(List<String> placeList){
        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, placeList);
        placesListView.setAdapter(listAdapter);
        cityList = placeList;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void executeAutoComplete(String query){
        ApiClient.searchAutoComplete(query, new Callback<ArrayList<String>>() {
            @Override
            public void success(ArrayList<String> strings, Response response) {
                for (int i = 0; i < strings.size(); i++) {
                    Log.d("test", strings.get(i));
                }
                if (!strings.get(0).equals("%s")){
                    setupPlaceList(strings);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String cityClicked = cityList.get(position);
        goToCityDescription(cityClicked);
        SharedPreferences sharedPreferences = getSharedPreferences(PrefConstants.FILE_CITY, MODE_PRIVATE);
        sharedPreferences.edit().putString(PrefConstants.PREF_CITY, cityClicked).apply();
    }

    private void goToCityDescription(String city) {
        Intent goToCityDescription = new Intent(MainActivity.this, CityDescriptionActivity.class);
        startActivity(goToCityDescription);
        Toast.makeText(MainActivity.this, city, Toast.LENGTH_SHORT).show();
        goToCityDescription.putExtra("City", city);
    }
}
