package com.ctrlvideo.ivplayerdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;

import com.ctrlvideo.ivplayer.IVPlayer;


public class DemoActivity extends FragmentActivity implements View.OnClickListener {

    protected String TAG = "CTRLVIDEO";

    //互动视频视图组件
    private IVPlayer ivPlayer;

    //控制条
    private LinearLayout ll_Control;
    private FrameLayout fl_chapterOne;
    private FrameLayout fl_chapterTwo;
    private FrameLayout fl_chapterThree;
    private FrameLayout fl_chapterFour;
    private FrameLayout fl_chapterFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ivPlayer = findViewById(R.id.iv_Player);
        ll_Control = findViewById(R.id.ll_Control);
        fl_chapterOne = findViewById(R.id.fl_chapterOne);
        fl_chapterTwo = findViewById(R.id.fl_chapterTwo);
        fl_chapterThree = findViewById(R.id.fl_chapterThree);
        fl_chapterFour = findViewById(R.id.fl_chapterFour);
        fl_chapterFive = findViewById(R.id.fl_chapterFive);

        fl_chapterOne.setOnClickListener(this);
        fl_chapterTwo.setOnClickListener(this);
        fl_chapterThree.setOnClickListener(this);
        fl_chapterFour.setOnClickListener(this);
        fl_chapterFive.setOnClickListener(this);

        ivPlayer.loadIVideo("https://apiivetest.ctrlvideo.com/player/ajax/get_ivideo_info/?project_id=5925315322305659", null);
    }


    @Override
    public void onClick(View v) {
        if (v == fl_chapterOne) {//三国
//            ivPlayer.loadIVideo("5165902802815866", new PlayerListener());
            ivPlayer.loadIVideo("https://apiivetest.ctrlvideo.com/player/ajax/get_ivideo_info/?project_id=5925315322305659", null);
//            ivPlayer.loadIVideo("5926378841048816", new PlayerListener());
        } else if (v == fl_chapterTwo) {//驾照
            ivPlayer.loadIVideo("https://apiivetest.ctrlvideo.com/player/ajax/get_ivideo_info/?project_id=5159028427201742", null);
//            ivPlayer.loadIVideo("5159815275197916", new PlayerListener());

        } else if (v == fl_chapterThree) {//路虎
            ivPlayer.loadIVideo("https://apiivetest.ctrlvideo.com/player/ajax/get_ivideo_info/?project_id=5159028436931666", null);
        } else if (v == fl_chapterFour) {//刘岩
            ivPlayer.loadIVideo("https://apiivetest.ctrlvideo.com/player/ajax/get_ivideo_info/?project_id=5858022109443231", null);
        } else if (v == fl_chapterFive) {

        }
    }


    //是否因生命周期导致的暂停
    private boolean isLifeToPause = false;

    @Override
    protected void onResume() {
        super.onResume();
        if (isLifeToPause) {
            isLifeToPause = false;
            //继续播放
            ivPlayer.play();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (ivPlayer.isPlaying()) {
            //暂停视频
            ivPlayer.pause();
            isLifeToPause = true;
        }
    }


//    //播放器状态改变listener
//    private class PlayerListener implements IVPlayerListener {
//
//        /**
//         * 当IVPlayer状态改变时调用
//         *
//         * @param state 状态，PlayerState.STATE_LOADED 互动视频初始化完成，PlayerState.STATE_ONPAUSE 互动视频暂停，PlayerState.STATE_ONPLAY 互动视频播放
//         */
//        @Override
//        public void onStateChanged(String state) {
//            Log.d(TAG, "onStateChanged " + state);
//        }
//
//        /**
//         * 当IVPlayer点击时 [如点击IVPlayer中控件将阻止向上冒泡，不会调用此方法]
//         *
//         * @param info 点击信息
//         */
//        @Override
//        public void onViewClick(String info) {
////            if (ll_Control.getVisibility() == View.VISIBLE)
////                ll_Control.setVisibility(View.GONE);
////            else
////                ll_Control.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        public void onEventCallback(String result) {
//
//        }
//
//
//        /**
//         * 当IVPlayer发生错误时
//         *
//         * @param errorType 错误信息
//         */
//        @Override
//        public void onError(String errorType) {
//            Log.d(TAG, "onError " + errorType);
//        }
//
//        /**
//         * 当IVView收到自定义通知
//         *
//         * @param msg 通知内容
//         */
//        @Override
//        public void onCustomNotify(String msg) {
//            Toast.makeText(DemoActivity.this, "收到通知： " + msg, Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        public void onHrefUrl(String url) {
//            Toast.makeText(DemoActivity.this, "跳转链接： " + url, Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        public void onCallPhone(String phone) {
//            Toast.makeText(DemoActivity.this, "拨打电话： " + phone, Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        public void onProgressCallback(String resulr) {
//            Log.d(TAG, "onProgressCallback " + resulr);
//        }
//    }


}
