package net.ingx.material.behavior;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import net.ingx.material.adapter.ComRecyclerAdapter;
import net.ingx.material.help.PullImgStretchBehaviorHelp;
import net.ingx.materialdemo.R;

/**
 * @author admin
 * @version 1.0
 * @date 创建时间：2017/12/15
 * @action
 */
public class PullImgStretchBehaviorDemo extends AppCompatActivity implements PullImgStretchBehaviorHelp.PullStretchBehaviorListener{
    private static final String TAG = "PullImager" ;
    private ImageView mImg ;
    private AppBarLayout mAppBarLayout ;

    @Override
    public void pullStretchBehaviorSlide(float mLastScale) {
        mImg.setScaleX(mLastScale);
        mImg.setScaleY(mLastScale);
        Log.i(TAG,"" + mLastScale) ;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_pullimgstretchbehavior);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAppBarLayout = findViewById(R.id.appbar_layout) ;
        mImg = findViewById(R.id.activity_me_appbar_bg) ;
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) mAppBarLayout.getLayoutParams()).getBehavior() ;
        PullImgStretchBehaviorHelp pullImgStretchBehaviorHelp = (PullImgStretchBehaviorHelp) behavior;
        pullImgStretchBehaviorHelp.setPullStretchBehaviorListener(this);
    }
}
