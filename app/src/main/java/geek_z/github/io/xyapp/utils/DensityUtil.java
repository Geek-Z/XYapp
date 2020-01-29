package geek_z.github.io.xyapp.utils;

/**
 * Created by Administrator on 2020/1/29 0029.
 */

import android.content.Context;

public class DensityUtil {
    /**
     *根据手机的分辨率从dp的单位转换成px（像素）
     */
    public static int dip2px(Context context,float dpValue){
        final float scal=context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scal + 0.5f);
    }
    /**
     * 根据手机的分辨率从px（像素）的单位转换成dp
     */
    public static int px2dip(Context context,float pxValue){
        final float scal=context.getResources().getDisplayMetrics().density;
        return (int) (pxValue * scal + 0.5f);
    }
}
