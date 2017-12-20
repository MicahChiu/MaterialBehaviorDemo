package net.ingx.material.behavior;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import net.ingx.material.adapter.ComRecyclerAdapter;
import net.ingx.materialdemo.R;

/**
 * @author admin
 * @version 1.0
 * @date 创建时间：2017/12/15
 * @action
 */
public class PullImgStretchBehaviorDemo extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_pullimgstretchbehavior);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
