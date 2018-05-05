package com.example.justdoit.androidbluetoothplugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;

import java.util.Set;

import me.aflak.bluetooth.Bluetooth;

/**
 * Created by taiga on 2018/05/05.
 */

public class BlueToothUnit {
    public static void showToast() {
        final Activity activity = UnityPlayer.currentActivity;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, "successful!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // デリゲート関数
    public static void execDelegateMethod(final String str, final String gameobject, final String method) {
        final Activity activity = UnityPlayer.currentActivity;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    // 文字列一つしか送れないから、複数の場合はJSONとかに
                    com.unity3d.player.UnityPlayer.UnitySendMessage(gameobject, method, str);

                    Toast.makeText(activity, "文字列が送信されたよ！", Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void showDeviceList() {
        final Activity activity = UnityPlayer.currentActivity;

//        final ArrayAdapter<String> deviceAdapter=new ArrayAdapter<String>(activity,android.R.layout.simple_list_item_1);
//
//        Bluetooth bluetooth = new Bluetooth(activity);
//        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
//        if(pairedDevices.size() > 0){
//            for(BluetoothDevice device : pairedDevices){
//                deviceAdapter.add(device.getName() + "\n" + device.getAddress());
//            }
//        }else{
//            String noDevices = "No devices found";
//            deviceAdapter.add(noDevices);
//        }
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Dialog用レイアウトの読み込み
//                LayoutInflater factory = LayoutInflater.from(activity);
//                View inputView = factory.inflate(R.layout.dialog_device_list, null);
//                final ListView deviceList=(ListView) inputView.findViewById(R.id.device_list);
//                deviceList.setAdapter(deviceAdapter);
//                final AlertDialog alertDlg = new AlertDialog.Builder(activity)
//                        .setView(inputView)
//                        .show();

                new AlertDialog.Builder(activity)
                        .setTitle("aa")
                        .setMessage("bb")
                        .setPositiveButton("YES, YES, YES!", null)
                        .setNegativeButton("...No?", null)
                        .show();
            }
        });
    }
}
