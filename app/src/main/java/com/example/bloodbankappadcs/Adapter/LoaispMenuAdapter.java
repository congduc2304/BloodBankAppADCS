package com.example.bloodbankappadcs.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bloodbankappadcs.Model.Loaisp_menu;
import com.example.bloodbankappadcs.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaispMenuAdapter extends BaseAdapter {
    ArrayList<Loaisp_menu> arrayListloaisp;
    Context context;

    public LoaispMenuAdapter(ArrayList<Loaisp_menu> arrayListloaisp, Context context) {
        this.arrayListloaisp = arrayListloaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListloaisp.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListloaisp.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder{
        TextView txttenloaisp;
        ImageView imgloaisp;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_listview_menu,null);
            viewHolder.txttenloaisp = view.findViewById(R.id.textviewloaisp);
            viewHolder.imgloaisp = view.findViewById(R.id.imageviewloaisp);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();

        }
        Loaisp_menu loaisp_menu = (Loaisp_menu) getItem(i);
        viewHolder.txttenloaisp.setText(loaisp_menu.getTenloaisp());
        Picasso.with(context).load(loaisp_menu.getHinhanhloaisp())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(viewHolder.imgloaisp);
        return view;
    }
}
