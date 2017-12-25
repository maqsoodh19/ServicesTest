package com.example.maqso.servicestest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.pusher.android.PusherAndroid;
import com.pusher.android.notifications.ManifestValidator;
import com.pusher.android.notifications.PushNotificationRegistration;
import com.pusher.android.notifications.fcm.FCMPushNotificationReceivedListener;
import com.pusher.android.notifications.tokens.PushNotificationRegistrationListener;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MTAG";
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStartService);
        btnStop = findViewById(R.id.btnStopService);
        Log.d(TAG, "onCreate: token is: " + FirebaseInstanceId.getInstance().getId());
        // pusher service
//        PusherAndroid pusher = new PusherAndroid("5f892e9a9f61777766ef");
//        PushNotificationRegistration nativePusher = pusher.nativePusher();
//        try {
//            nativePusher.registerFCM(this, new PushNotificationRegistrationListener() {
//                @Override
//                public void onSuccessfulRegistration() {
//                    Log.d(TAG, "onSuccessfulRegistration: ");
//                }
//
//                @Override
//                public void onFailedRegistration(int statusCode, String response) {
//                    Log.d(TAG, "onFailedRegistration: " + response + statusCode);
//                }
//            });
//
//
//        } catch (ManifestValidator.InvalidManifestException e) {
//            e.printStackTrace();
//        }
//
//        nativePusher.subscribe("apple");
//        nativePusher.setFCMListener(new FCMPushNotificationReceivedListener() {
//            @Override
//            public void onMessageReceived(RemoteMessage remoteMessage) {
//                Log.d(TAG, "onMessageReceived: " + remoteMessage.getMessageId());
//            }
//        });


        // start service
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: strat buton ");
                startService(new Intent(MainActivity.this, MyService.class));
            }
        });
        // stop service
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick stop boolean value: ");
                stopService(new Intent(MainActivity.this, MyService.class));

            }
        });
    }
}
