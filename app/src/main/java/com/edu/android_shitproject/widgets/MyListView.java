package com.edu.android_shitproject.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by Ming on 2015/12/25.
 */
public class MyListView extends ListView {

    private static final String TAG = "MyListView";

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "dispatchTouchEvent() MOVE");
                // 这种解决方法不好，listView  和 scrollView 不能用事件去拦截
                // requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_UP:
                // requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onInterceptTouchEvent() MOVE");
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    //------------------ 使用 onMeasure 方法，来解决尺寸高度的问题 以及事件冲突的问题


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSize = MeasureSpec.getSize(heightMeasureSpec);

        switch (hMode) {
            case MeasureSpec.UNSPECIFIED:
                Log.d(TAG, "onMeasure: UNSPECIFIED");
                break;

            case MeasureSpec.AT_MOST:
                Log.d(TAG, "onMeasure: AT_MOST");
                break;

            case MeasureSpec.EXACTLY:
                break;
        }

        Log.d(TAG, "onMeasure() returned: hSize =  " +hSize);

        // 因为 scrollView + listView 时，高度模式强制设置为 UNSPECIFIED
        // listView 只会计算一条的高度
        // 将 height 的模式，强制设置为 AT_MOST 就会进行计算实际的高度了
        // 那么考虑到 listView 的条目数量不确定，高度也不确定，height size 应该是 一个最大值。
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
