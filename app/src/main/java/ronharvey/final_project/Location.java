package ronharvey.final_project;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class Location extends FragmentActivity implements OnMapReadyCallback {

    ListView listView;
    private GoogleMap mMap;
    private String[] locations = new String[]{"All Stores", "Store 1 - 1234 S Canal Chicago, IL", "Store 2 - 901 W Madison St Chicago, IL", "Store 3 - 143 W Division Chicago, IL", "Store 4 - 321 East 35th Street Chicago, IL",
            "Store 5 - 2331 W. Madison Street Chicago, IL"};
    private LatLng PizzaHeaven1 = new LatLng(41.866255, -87.640332);
    private LatLng PizzaHeaven2 = new LatLng(41.881430, -87.649985);
    private LatLng PizzaHeaven3 = new LatLng(41.903758, -87.633192);
    private LatLng PizzaHeaven4 = new LatLng(41.830891, -87.618244);
    private LatLng PizzaHeaven5 = new LatLng(41.881198, -87.685163);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //gets list and sets adapter
        listView = (ListView) findViewById(R.id.list_loc);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, locations);

        listView.setAdapter(adapter);

        //when listitem clicked, move map lccation and add pin, clear other pins
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int itemPosition = position;
                //String itemValue = (String) listView.getItemAtPosition(position);

                if (position == 1) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(PizzaHeaven1).title("Pizza Heaven's First Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(PizzaHeaven1));
                    mMap.moveCamera(CameraUpdateFactory.zoomTo(13));
                } else if (position == 2) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(PizzaHeaven2).title("Pizza Heaven's Second Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(PizzaHeaven2));
                    mMap.moveCamera(CameraUpdateFactory.zoomTo(13));
                }
                else if (position == 3) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(PizzaHeaven3).title("Pizza Heaven's Third Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(PizzaHeaven3));
                    mMap.moveCamera(CameraUpdateFactory.zoomTo(13));
                }
                else if (position == 4) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(PizzaHeaven4).title("Pizza Heaven's Fourth Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(PizzaHeaven4));
                    mMap.moveCamera(CameraUpdateFactory.zoomTo(13));
                }
                else if (position == 5) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(PizzaHeaven5).title("Pizza Heaven's Fifth Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(PizzaHeaven5));
                    mMap.moveCamera(CameraUpdateFactory.zoomTo(13));
                }else {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(PizzaHeaven1).title("Pizza Heaven's First Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
                    mMap.addMarker(new MarkerOptions().position(PizzaHeaven2).title("Pizza Heaven's Second Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
                    mMap.addMarker(new MarkerOptions().position(PizzaHeaven3).title("Pizza Heaven's Third Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
                    mMap.addMarker(new MarkerOptions().position(PizzaHeaven4).title("Pizza Heaven's Fourth Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
                    mMap.addMarker(new MarkerOptions().position(PizzaHeaven5).title("Pizza Heaven's Fifth Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));

                    mMap.moveCamera(CameraUpdateFactory.zoomTo(12));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(41.871832, -87.633177)));
                }
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //PizzaHeaven1 = new LatLng(41.864584, -87.624905);
        //LatLng PizzaHeaven2 = new LatLng(41.871452, -87.627124);

        //mMap.addMarker(new MarkerOptions().position(PizzaHeaven1).title("Pizza Heaven's First Location"));
        //mMap.addMarker(new MarkerOptions().position(PizzaHeaven2).title("Pizza Heaven's Second Location"));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(13));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PizzaHeaven1));

    }
}
