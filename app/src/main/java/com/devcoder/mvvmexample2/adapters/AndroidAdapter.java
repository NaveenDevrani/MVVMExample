package com.devcoder.mvvmexample2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devcoder.R;
import com.devcoder.mvvmexample2.models.DataModel;

import java.util.List;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.ViewHolder> {
    private Context context;
    private List<DataModel> list;

    public AndroidAdapter(Context context, List<DataModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel dataModel = list.get(position);
        holder.tvAndroidName.setText(dataModel.getAndroidName());
        holder.tvAndroidVersion.setText(dataModel.getAndroidVersion());
        holder.imageView.setImageDrawable(dataModel.getImageUrlInt());
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAndroidName, tvAndroidVersion;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAndroidName = itemView.findViewById(R.id.tvAndroidName);
            tvAndroidVersion = itemView.findViewById(R.id.tvAndroidVersion);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
