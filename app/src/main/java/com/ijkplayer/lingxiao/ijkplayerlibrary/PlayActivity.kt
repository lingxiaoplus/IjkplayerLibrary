package com.ijkplayer.lingxiao.ijkplayerlibrary

import android.content.res.Configuration
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.bilibili.lingxiao.ijkplayer.PlayState
import kotlinx.android.synthetic.main.activity_play.*

class PlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        //屏幕常亮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        /** 普通播放 start **/
        var url = getIntent().getStringExtra("url");
        simple_view
            .setVideoUrl(url)
            .hideTopBar()
            .hideBottomBar()
            .setVideoTitle("这是标题")
            .setAspectRatio(PlayState.fillparent)
            .startPlay()

    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        //横竖屏切换
        var isPortrait = simple_view.onConfigurationChang(newConfig)
        if (isPortrait) {
            supportActionBar?.show()
        } else {
            supportActionBar?.hide()
        }
    }

    override fun onBackPressed() {
        simple_view.onBackPressed()
        if (!simple_view.isPortrait){
            supportActionBar?.show()
        }else{
            super.onBackPressed()
        }
    }

    override fun onPause() {
        super.onPause()
        simple_view.onPause()
    }

    override fun onResume() {
        super.onResume()
        simple_view.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        simple_view.onDestory()
    }
}
