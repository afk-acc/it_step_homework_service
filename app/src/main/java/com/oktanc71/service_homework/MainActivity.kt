package com.oktanc71.service_homework

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var reciver: MyBroadcastreciver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reciver = MyBroadcastreciver()
        registerReceiver(MyBroadcastreciver(), IntentFilter(Consts.BROADCAST_ACTION));
        checkBattery()

    }

    fun checkBattery() {
        val intent = Intent()
        intent.action = Consts.BROADCAST_ACTION
        sendBroadcast(intent)
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(MyBroadcastreciver(), IntentFilter(Consts.BROADCAST_ACTION));
    }
}