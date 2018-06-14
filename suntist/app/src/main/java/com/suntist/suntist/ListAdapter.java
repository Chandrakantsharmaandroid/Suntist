package com.suntist.suntist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import modelclass.Detail;

public class ListAdapter extends BaseAdapter {
    Bitmap bm, bm1;
    ImageView imageView1;
    Activity useactivity;
    List<Detail> detail;
    LayoutInflater inlator;
    Context c;

    public ListAdapter(Activity activity, List<Detail> detail) {
        this.useactivity = activity;
        this.detail = detail;

        inlator = (LayoutInflater) useactivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return detail.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static class ViewHolder {
        Layout layout;
        TextView name, tel,sex;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder viewholder;
        if (convertView == null) {
            viewholder = new ViewHolder();
            convertView = inlator.inflate(R.layout.list_adapter, null);
            //		layout=findViewById(R.id.layoutList);
            viewholder.name = (TextView) convertView.findViewById(R.id.name);
            viewholder.tel = (TextView) convertView.findViewById(R.id.tel);
            viewholder.sex = (TextView) convertView.findViewById(R.id.sex);
            convertView.setTag(viewholder);
            int pos = position;
        } else
            viewholder = (ViewHolder) convertView.getTag();

        viewholder.name.setText(detail.get(position).getName());
        viewholder.tel.setText(detail.get(position).getMobileno());
        viewholder.sex.setText(detail.get(position).getSex());
        viewholder.tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+detail.get(position).getMobileno()));
                useactivity.startActivity(callIntent);
            }
        });

        return convertView;
    }


}
