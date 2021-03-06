package net.ingx.material.help;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author Admin
 * @version 1.0
 * @date 创建时间：2017/12/20
 * @action
 */
public class PullImgStretchBehaviorHelp extends AppBarLayout.Behavior {
    private static final String TAG = "BehaviorHelp";
    private boolean isAnimatingOut = false;
    private PullStretchBehaviorListener mPullStretchBehaviorListener;

    private int mParentHeight;
    // 控件的高度
    private int mLastdyUnconsumed = 0;
    // 消除相同的振幅

    public PullImgStretchBehaviorHelp() {
    }

    public PullImgStretchBehaviorHelp(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setPullStretchBehaviorListener(PullStretchBehaviorListener pullStretchBehaviorListener) {
        this.mPullStretchBehaviorListener = pullStretchBehaviorListener;
    }

    /* 初始化计算 */
    private void calculateAppBarLayout(AppBarLayout abl) {
        mParentHeight = abl.getHeight();
        abl.setClipChildren(false);
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, AppBarLayout abl, int layoutDirection) {
        boolean isOnLayoutChild = super.onLayoutChild(parent, abl, layoutDirection);
        calculateAppBarLayout(abl);
        return isOnLayoutChild;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes, int type) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes, type);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        if (mLastdyUnconsumed == dyUnconsumed)
            return;
        this.mLastdyUnconsumed = dyUnconsumed;
        if (child.getBottom() >= mParentHeight) {
            runSlide(child, target, dyUnconsumed);
        }
    }

    private void runSlide(AppBarLayout abl, View target, int dy) {
//        mTotalDy += -dy;
//        mTotalDy = Math.min(mTotalDy, TARGET_HEIGHT);
//        // 不能超过最大滑动距离
        float sss = (float) -dy * 2 / (float) mParentHeight;
        float mLastScale = Math.max(1f, 1f + sss);
//        // bit图片的最大伸展程度
//        mBigStretchView.setScaleX(mLastScale);
//        mBigStretchView.setScaleY(mLastScale);
//        // 图片伸展
//        mLastBottom = mParentHeight + (int) (mBigStretchViewHeight / 2 * (mLastScale - 1));
        // 计算目标View放大后增加的高度
        if (null != mPullStretchBehaviorListener) {
            mPullStretchBehaviorListener.pullStretchBehaviorSlide(mLastScale);
        }


        abl.setBottom(-dy + mParentHeight);
        target.setScrollY(0);

//        mUIToolView.setTop(mLastBottom - mUIToolViewHeight);
//        mUIToolView.setBottom(mLastBottom);
    }

    public interface PullStretchBehaviorListener {
        public void pullStretchBehaviorSlide(float mLastScale);
    }
}
