package com.bawei.chenlanglang20211228;

import android.content.Context;
import android.view.animation.Transformation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

/**
 * Date:2021/12/28
 * Time:8:21
 * author:chenlanglang
 * Describe:
 * <p>
 * .----------------.  .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.  .-----------------. .----------------.
 * | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |
 * | |     ______   | || |  ____  ____  | || |  _________   | || | ____  _____  | || |   _____      | || |      __      | || | ____  _____  | || |    ______    | || |   _____      | || |      __      | || | ____  _____  | || |    ______    | |
 * | |   .' ___  |  | || | |_   ||   _| | || | |_   ___  |  | || ||_   \|_   _| | || |  |_   _|     | || |     /  \     | || ||_   \|_   _| | || |  .' ___  |   | || |  |_   _|     | || |     /  \     | || ||_   \|_   _| | || |  .' ___  |   | |
 * | |  / .'   \_|  | || |   | |__| |   | || |   | |_  \_|  | || |  |   \ | |   | || |    | |       | || |    / /\ \    | || |  |   \ | |   | || | / .'   \_|   | || |    | |       | || |    / /\ \    | || |  |   \ | |   | || | / .'   \_|   | |
 * | |  | |         | || |   |  __  |   | || |   |  _|  _   | || |  | |\ \| |   | || |    | |   _   | || |   / ____ \   | || |  | |\ \| |   | || | | |    ____  | || |    | |   _   | || |   / ____ \   | || |  | |\ \| |   | || | | |    ____  | |
 * | |  \ `.___.'\  | || |  _| |  | |_  | || |  _| |___/ |  | || | _| |_\   |_  | || |   _| |__/ |  | || | _/ /    \ \_ | || | _| |_\   |_  | || | \ `.___]  _| | || |   _| |__/ |  | || | _/ /    \ \_ | || | _| |_\   |_  | || | \ `.___]  _| | |
 * | |   `._____.'  | || | |____||____| | || | |_________|  | || ||_____|\____| | || |  |________|  | || ||____|  |____|| || ||_____|\____| | || |  `._____.'   | || |  |________|  | || ||____|  |____|| || ||_____|\____| | || |  `._____.'   | |
 * | |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |
 * | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |
 * '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'
 */
public class GlideManager {
    private volatile static GlideManager manager;

    public static GlideManager getManager() {
        if (manager == null){
            synchronized (GlideManager.class){
                if (manager == null){
                    manager = new GlideManager();
                }
            }
        }
        return manager;
    }

//    展示正常图片
    public void show(Context context, String path, ImageView imageView){
        Glide.with(context).load(path).into(imageView);
    }
//    圆角
    public void showO(Context context, String path, int rounded,ImageView imageView){
        Glide.with(context).load(path).transform(new RoundedCorners(rounded)).into(imageView);
    }
//    圆形
    public void showOM(Context context, String path, ImageView imageView){
        Glide.with(context).load(path).circleCrop().into(imageView);
    }

}
