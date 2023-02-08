package com.example.aidl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    IAdditionalService mService;
    final String TAG = "NQH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent iService = new Intent(this, AdditionalService.class);
        bindService(iService, mConnection, Context.BIND_AUTO_CREATE);
        Log.d(TAG, "bind");


    }

    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = IAdditionalService.Stub.asInterface(service);
            Log.d(TAG, "Connected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "Disconnect");
        }
    };

    public void add(View v) throws RemoteException {
        EditText text1 = findViewById(R.id.txt1);
        EditText text2 = findViewById(R.id.txt2);
        int val1 = Integer.valueOf(text1.getText().toString());
        int val2 = Integer.valueOf(text2.getText().toString());

        TextView txtView = findViewById(R.id.res);

        int res = mService.add(val1, val2);
        txtView.setText(res + "");
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mConnection);
        Log.d(TAG, "unbind");
    }
}