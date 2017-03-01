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

public class ChicagoHotelActivity extends AppCompatActivity implements NamesHotelFragment.ListSelectionListener{

    private final ImageHotelFragment imageChicagoHotelFragment = new ImageHotelFragment();
    private final NamesHotelFragment namesChicagoHotelFragment = new NamesHotelFragment();
    private FragmentManager myFragmentManager;
    private FrameLayout myChicagoNamesFrameLayout, myChicagoImagesFrameLayout;

    public static String[] namesArray;
    public static int[] imagesArray = new int[]{R.drawable.drake, R.drawable.trump, R.drawable.downtown, R.drawable.omni, R.drawable.hyatt, R.drawable.palmer};

    //for orientation
    boolean dualPane = false;

    //denotes current screen
    String currentActivity = "Hotels";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // chicago hotels and images
        namesArray = getResources().getStringArray(R.array.chicagohotels);

        //check orientation
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            dualPane = true;
        }

        setContentView(R.layout.activity_hotel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myChicagoNamesFrameLayout = (FrameLayout) findViewById(R.id.namesFragment);
        myChicagoImagesFrameLayout = (FrameLayout) findViewById(R.id.imagesFragment);
        myChicagoImagesFrameLayout.setPadding(0,100,0,0);
        myChicagoNamesFrameLayout.setPadding(0,100,0,0);

        // FragmentManager reference
        myFragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.namesFragment, namesChicagoHotelFragment);

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
            if(imageChicagoHotelFragment.isAdded()){
                myChicagoNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));
                myChicagoImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                myChicagoImagesFrameLayout.setPadding(0,150,0,0);
                myChicagoNamesFrameLayout.setPadding(0,150,0,0);
            }
            dualPane = false;
        }
        else if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            //Check if images fragment is added in the previous orientation if current is landscape
            if(imageChicagoHotelFragment.isAdded()){
                myChicagoNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
                myChicagoImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f));

                myChicagoImagesFrameLayout.setPadding(0,100,0,0);
                myChicagoNamesFrameLayout.setPadding(0,100,0,0);
            }
            dualPane = true;
        }
    }

    //This method is also to ensure that the correct fragments are displayed when the orientation changes.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        System.out.println(getResources().getConfiguration().orientation);
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
            //Check if images fragment is added in the previous orientation if current is portrait
            if(imageChicagoHotelFragment.isAdded()){
                myChicagoNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));
                myChicagoImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                myChicagoImagesFrameLayout.setPadding(0,100,0,0);
                myChicagoNamesFrameLayout.setPadding(0,100,0,0);
            }
            dualPane = false;
        }
        else if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            //Check if images fragment is added in the previous orientation if current is landscape
            if(imageChicagoHotelFragment.isAdded()){
                myChicagoNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
                myChicagoImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f));

                myChicagoImagesFrameLayout.setPadding(0,100,0,0);
                myChicagoNamesFrameLayout.setPadding(0,100,0,0);
            }
            dualPane = true;
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
        if(dualPane) {
            System.out.println("LANDSCAPE");
            if (!imageChicagoHotelFragment.isAdded()) {
                // names fragment occupies the entire screen
                myChicagoNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                myChicagoImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));

                myChicagoImagesFrameLayout.setPadding(0,100,0,0);
                myChicagoNamesFrameLayout.setPadding(0,100,0,0);
            } else {
                // names and images fragments occupy 1:2 of the screen.
                myChicagoNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
                myChicagoImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f));

                myChicagoImagesFrameLayout.setPadding(0,100,0,0);
                myChicagoNamesFrameLayout.setPadding(0,100,0,0);
            }
        }
        else{
            System.out.println("PORTRAIT");
            if (!imageChicagoHotelFragment.isAdded()) {
                // names fragment occupies the entire screen
                myChicagoNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                myChicagoImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));

                myChicagoImagesFrameLayout.setPadding(0,100,0,0);
                myChicagoNamesFrameLayout.setPadding(0,100,0,0);
            } else {
                // images fragment occupies the entire screen
                myChicagoNamesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));
                myChicagoImagesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                myChicagoImagesFrameLayout.setPadding(0,100,0,0);
                myChicagoNamesFrameLayout.setPadding(0,100,0,0);
            }
        }
    }

    @Override
    public void onListSelection(int index) {
        FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();

        if (!imageChicagoHotelFragment.isAdded()) {
            fragmentTransaction.add(R.id.imagesFragment, imageChicagoHotelFragment);
        }
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();

        myFragmentManager.executePendingTransactions();

        if (imageChicagoHotelFragment.getShownIndex() != index) {

            imageChicagoHotelFragment.showImage(index);

        }
    }


    //inflates menu_hotels.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu_hotels, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case (R.id.switchtoHotels):{
                if(currentActivity!="Hotels") {
                    Intent chicagoIntent = new Intent(ChicagoHotelActivity.this, ChicagoHotelActivity.class);
                    currentActivity = "Hotels";
                    startActivity(chicagoIntent);
                }
                return true;
            }
            case (R.id.switchtoRestaurants):{
                if(currentActivity!="Restaurants") {
                    Intent indianaIntent = new Intent(ChicagoHotelActivity.this, ChicagoRestaurantActivity.class);
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
