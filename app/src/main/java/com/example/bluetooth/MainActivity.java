package com.example.bluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {


    Button b1, b2, b3;
    TextView  tv1,tv3,tv4;

     BluetoothAdapter adapter;
    private static final int REQUEST_ENABLE_BLUETOOTH = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button b1 = (findViewById(R.id.button));
        Button b2 = (findViewById(R.id.button2));
        Button b3 = (findViewById(R.id.button3));
        TextView tv1 = (findViewById(R.id.textView));
        TextView tv3= (findViewById(R.id.textView3));
        TextView tv4  = (findViewById(R.id.textView4));


        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

        if (adapter == null) {

            Toast.makeText(this, "Bluetooth is NOT ENABLED", Toast.LENGTH_LONG
            ).show();
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!adapter.isEnabled()) {
                    Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(i, REQUEST_ENABLE_BLUETOOTH);

                }
            }
        });
        //STEP 7 : Disable Bluetooth

        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                adapter.disable();
                // i disabled add permission check here
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder sb = new StringBuilder();
                @SuppressLint("MissingPermission") Set<BluetoothDevice> ad = adapter.getBondedDevices();

                for (BluetoothDevice temp : ad)
                {
                    sb.append("\n" + temp.getName() + "\n");

                }
                tv1.setText(sb.toString());

            }
        });
    }
}
//
///*************************************************************************************
//
//
//    // Get the default adapter
//    //BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//
//    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//if (bluetoothAdapter == null) {
//        // Device doesn't support Bluetooth
//    }
//      if (bluetoothAdapter == null) {
//          System.out.println("Doesnt support blue tooth");
//        // Device doesn't support Bluetooth
//    }
//if (bluetoothAdapter == null) {
//        // Device doesn't support Bluetooth
//    }
//if (!bluetoothAdapter.isEnabled()) {
//        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//        startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//    private BluetoothProfile.ServiceListener profileListener = new BluetoothProfile.ServiceListener() {
//        public void onServiceConnected(int profile, BluetoothProfile proxy) {
//            if (profile == BluetoothProfile.HEADSET) {
//                bluetoothHeadset = (BluetoothHeadset) proxy;
//            }
//        }
//        public void onServiceDisconnected(int profile) {
//            if (profile == BluetoothProfile.HEADSET) {
//                bluetoothHeadset = null;
//            }
//        }
//    };
//
//// Establish connection to the proxy.
//bluetoothAdapter.getProfileProxy(context, profileListener, BluetoothProfile.HEADSET);
//
//// ... call functions on bluetoothHeadset
//
//// Close proxy connection after use.
//bluetoothAdapter.closeProfileProxy(bluetoothHeadset);
//}