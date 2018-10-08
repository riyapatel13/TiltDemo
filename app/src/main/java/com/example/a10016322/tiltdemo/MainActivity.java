package com.example.a10016322.tiltdemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView x, y, z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x = (TextView)(findViewById(R.id.x_id));
        y = (TextView)(findViewById(R.id.y_id));
        z = (TextView)(findViewById(R.id.z_id));

        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x.setText(event.values[0]+"");
        y.setText(event.values[1]+"");
        z.setText(event.values[2]+"");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
