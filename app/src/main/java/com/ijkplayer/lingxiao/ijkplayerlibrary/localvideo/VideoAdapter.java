package com.ijkplayer.lingxiao.ijkplayerlibrary.localvideo;



import android.support.annotation.Nullable;
import com.bilibili.lingxiao.ijkplayer.localvideo.VideoModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ijkplayer.lingxiao.ijkplayerlibrary.R;

import java.util.List;


public class VideoAdapter extends BaseQuickAdapter<VideoModel,BaseViewHolder> {
    public VideoAdapter(int layoutResId, @Nullable List<VideoModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoModel item) {
        int size = item.getSize();
        float sizeF = size /1024f/1024f;
        helper.setText(R.id.tv_name,"标题："+item.getName());
        if (String.valueOf(sizeF).length() > 4){
            helper.setText(R.id.tv_size,"大小："+(sizeF+"").substring(0,4)+"M");
        }else {
            helper.setText(R.id.tv_size,"大小：" + sizeF + "M");
        }
        helper.setText(R.id.tv_path,"路径："+item.getPath());
        helper.addOnClickListener(R.id.cardView);
    }
}
