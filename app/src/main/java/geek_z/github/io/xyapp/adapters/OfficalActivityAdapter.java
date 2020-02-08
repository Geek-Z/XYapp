package geek_z.github.io.xyapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import geek_z.github.io.xyapp.R;
import geek_z.github.io.xyapp.adapter_entities.OfficalActivity;

/**
 * Created by MusaGeek on 2020/2/7 0007.
 * 官方活动的RecyclerView的适配器
 */

public class OfficalActivityAdapter extends RecyclerView.Adapter<OfficalActivityAdapter.ViewHolder> {

    private List<OfficalActivity> mList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView activityImage;
        TextView activityTitle;

        public ViewHolder(View view) {
            super(view);
            activityImage = (ImageView) view.findViewById(R.id.offical_activity_image);
            activityTitle = (TextView) view.findViewById(R.id.offical_activity_title);
        }
    }

    // 构造函数
    public OfficalActivityAdapter(List<OfficalActivity> list) {
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offical_activity_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        OfficalActivity activity = mList.get(position);
        holder.activityImage.setImageResource(activity.getImageId());
        holder.activityTitle.setText(activity.getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
