package net.ingx.materialdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.ingx.material.behavior.BottomSheetBehaviorDemo;
import net.ingx.material.behavior.BottomSheetBehaviorDialogDemo;
import net.ingx.material.behavior.PullImgStretchBehaviorDemo;
import net.ingx.material.behavior.ScaleUpShowBehaviorDemo;

public class MainActivity extends AppCompatActivity {

    public void pullImgStretchBehaviorDemoClick(View view){
        Intent intent = new Intent(this, PullImgStretchBehaviorDemo.class);
        startActivity(intent);
    }

    public void scaleUpShowBehaviorClick(View view){
        Intent intent = new Intent(this, ScaleUpShowBehaviorDemo.class);
        startActivity(intent);
    }

    public void bottomSheetBehaviorDialogClick(View view) {
        Intent intent = new Intent(this, BottomSheetBehaviorDialogDemo.class);
        startActivity(intent);
    }

    public void bottomSheetBehaviorClick(View view) {
        Intent intent = new Intent(this, BottomSheetBehaviorDemo.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
