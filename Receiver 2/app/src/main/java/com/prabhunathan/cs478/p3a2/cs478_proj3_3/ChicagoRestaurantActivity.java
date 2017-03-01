package com.prabhunathan.cs478.p3a2.cs478_proj3_3;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class ChicagoRestaurantActivity extends AppCompatActivity implements ChicagoRestaurantNamesFragment.ListSelectionListener {

    private final ChicagoRestaurantImageFragment chicagoRestaurantImageFragment = new ChicagoRestaurantImageFragment();
    private final ChicagoRestaurantNamesFragment chicagoRestaurantNamesFragment = new ChicagoRestaurantNamesFragment();
    private FragmentManager myFragmentManager;
    private FrameLayout myNamesFrameLayout, myImagesFrameLayout;

    public static String[] namesArray;
    public static int[] imagesArray = new int[]{R.drawable.girlgoat, R.drawable.alinea, R.drawable.purplepig, R.drawable.quartino, R.drawable.boka, R.drawable.tanta};


    //for orientation
    boolean orientation = false;

    //denotes current screen
    String currentActivity = "Restaurants";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // chicago restaurants and images
        namesArray = getResources().getStringArray(R.array.chicagorestaurants);


        setContentView(R.layout.activity_restaurant);

        setContentView(R.layout.activity_restaurant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myNamesFrameLayout= (FrameLayout) findViewById(R.id.namesFragment);
        myImagesFrameLayout = (FrameLayout) findViewById(R.id.imagesFragment);

        myImagesFrameLayout.setPadding(0,100,0,0);
        myNamesFrameLayout.setPadding(0,100,0,0);

        // FragmentManager reference
        myFragmentManager = getFragmentManager();

        // Start a new FragmentTransaction
        FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();

        // Adding fragment to the layout
        fragmentTransaction.add(R.id.namesFragment, chicagoRestaurantNamesFragment);

        fragmentTransaction.commit();

        myFragmentManager
                .addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        setLayout();
                    }
                });
    }

    //This method is to ensure that the correct fragments are displayed when the orientation changes.
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
            //Check if images fragment is added in the previous orientation if current is portrait
            if(chicagoRestaurantImageFragment.isAdded()){
                myNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));
                myImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                myImagesFrameLayout.setPadding(0,100,0,0);
                myNamesFrameLayout.setPadding(0,100,0,0);
            }
            orientation = false;
        }
        else if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            //Check if images fragment is added in the previous orientation if current is landscape
            if(chicagoRestaurantImageFragment.isAdded()){
                myNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
                myImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f));

                myImagesFrameLayout.setPadding(0,100,0,0);
                myNamesFrameLayout.setPadding(0,100,0,0);
            }
            orientation = true;
        }
    }

    //This method is also to ensure that the correct fragments are displayed when the orientation changes.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        System.out.println(getResources().getConfiguration().orientation);
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
            //Check if images fragment is added in the previous orientation if current is portrait
            if(chicagoRestaurantImageFragment.isAdded()){
                myNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));
                myImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                myImagesFrameLayout.setPadding(0,100,0,0);
                myNamesFrameLayout.setPadding(0,100,0,0);
            }
            orientation = false;
        }
        else if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            //Check if images fragment is added in the previous orientation if current is landscape
            if(chicagoRestaurantImageFragment.isAdded()){
                myNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
                myImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f));

                myImagesFrameLayout.setPadding(0,100,0,0);
                myNamesFrameLayout.setPadding(0,100,0,0);
            }
            orientation = true;
        }
        super.onConfigurationChanged(newConfig);
    }

    // This method is to ensure that the images fragment -> names fragment is handled in portrait mode.
    @Override
    public void onBackPressed() {
        if (myFragmentManager.getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }


    private void setLayout() {
        if(orientation) {
            System.out.println("LANDSCAPE");
            if (!chicagoRestaurantImageFragment.isAdded()) {
                // names fragment occupies the entire screen
                myNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                myImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));

                myImagesFrameLayout.setPadding(0,100,0,0);
                myNamesFrameLayout.setPadding(0,100,0,0);
            } else {
                // names and images fragments occupy 1:2 of the screen.
                myNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
                myImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f));

                myImagesFrameLayout.setPadding(0,100,0,0);
                myNamesFrameLayout.setPadding(0,100,0,0);
            }
        }
        else{
            System.out.println("PORTRAIT");
            if (!chicagoRestaurantImageFragment.isAdded()) {
                // the names fragment occupies the entire screen
                myNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                myImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));

                myImagesFrameLayout.setPadding(0,100,0,0);
                myNamesFrameLayout.setPadding(0,100,0,0);
            } else {
                // the images fragment occupies the entire screen
                myNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));
                myImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                myImagesFrameLayout.setPadding(0,100,0,0);
                myNamesFrameLayout.setPadding(0,100,0,0);
            }
        }
    }

    @Override
    public void onListSelection(int index) {
        FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();

        if (!chicagoRestaurantImageFragment.isAdded()) {
            fragmentTransaction.add(R.id.imagesFragment, chicagoRestaurantImageFragment);
        }
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();

        myFragmentManager.executePendingTransactions();

        if (chicagoRestaurantImageFragment.getShownIndex() != index) {

            chicagoRestaurantImageFragment.showImage(index);

        }
    }


    //This method inflates the menu with the menu_hotel.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu_hotels, menu);
        return true;
    }

    //This method handles options menu items clicks.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case (R.id.switchtoHotels):{
                if(currentActivity!="Hotels") {
                    Intent chicagoIntent = new Intent(ChicagoRestaurantActivity.this, ChicagoHotelActivity.class);
                    currentActivity = "Hotels";
                    startActivity(chicagoIntent);
                }
                return true;
            }
            case (R.id.switchtoRestaurants):{
                if(currentActivity!="Restaurants") {
                    Intent indianaIntent = new Intent(ChicagoRestaurantActivity.this, ChicagoRestaurantActivity.class);
                    currentActivity = "Restaurants";
                    startActivity(indianaIntent);
                }
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
