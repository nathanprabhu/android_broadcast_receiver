package com.prabhunathan.cs478.p3a2.cs478_proj3_3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Prabhunathan Gnanasekaran on 10/29/16.
 */
public class ReceiverA3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String type =(String) extras.get("type");

        //Receive the broadcast and decide which activity to call.
        if(type.equals("Hotels")) {
            Intent i = new Intent();
            i.setClassName("com.prabhunathan.cs478.p3a2.cs478_proj3_3", "com.prabhunathan.cs478.p3a2.cs478_proj3_3.ChicagoHotelActivity");
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        else{
            Intent i = new Intent();
            i.setClassName("com.prabhunathan.cs478.p3a2.cs478_proj3_3", "com.prabhunathan.cs478.p3a2.cs478_proj3_3.ChicagoRestaurantActivity");
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
