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
    //------------------ 使用 onMeasure 方法，来解决尺寸高度的问题 以及事件冲突的问题
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 因为 scrollView + listView 时，高度模式强制设置为 UNSPECIFIED
        // listView 只会计算一条的高度
        // 将 height 的模式，强制设置为 AT_MOST 就会进行计算实际的高度了
        // 那么考虑到 listView 的条目数量不确定，高度也不确定，height size 应该是 一个最大值。
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
