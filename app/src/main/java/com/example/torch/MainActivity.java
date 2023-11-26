package com.example.torch;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;
    CameraManager cameraManager;
    String cameraId;
    Boolean state=false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=findViewById(R.id.cl);
        layout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                if(state == false){
                    try{
                        cameraManager= (CameraManager) getSystemService(CAMERA_SERVICE);
                        cameraId=cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(cameraId,!state);
                        layout.setBackgroundResource(R.drawable.onbulb);
                        state=true;

                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        cameraManager= (CameraManager) getSystemService(CAMERA_SERVICE);
                        cameraId=cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(cameraId,!state);
                        layout.setBackgroundResource(R.drawable.offbulb);
                        state=false;
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}