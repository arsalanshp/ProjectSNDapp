package com.example.root.tebsoundapp1.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.tebsoundapp1.R;

/**
 * Created by root on 9/6/16.
 */
public class SubCategoryAdapter extends ArrayAdapter<String> {

    Context context;
    String[] categories;
    int[] categories_id;

    public SubCategoryAdapter(Context context , String[] categories , int[] categories_id){
        super(context, R.layout.sub_category_row);
        this.context = context;
        this.categories = categories;
        this.categories_id = categories_id;
    }

    @Override
    public View getDropDownView (int position , View convertView, ViewGroup parent){

        if(convertView == null){
            LayoutInflater inflater =(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sub_category_row,null);
        }

        TextView subCategoryName =(TextView) convertView.findViewById(R.id.sub_category_name);
        ImageView subCategoryIcon = (ImageView)convertView.findViewById(R.id.sub_category_icon);



        //SET DATA
        if(position!=0) {

            subCategoryName.setText(categories[position]);
            subCategoryName.setTag(1,categories_id[position]);
//            img.setImageResource(images[position]);
            subCategoryIcon.setImageResource(R.drawable.music0);
        }
        else {
            subCategoryIcon.setImageResource(R.drawable.music);
            subCategoryName.setText("-");
        }

        return  convertView;
    }


    // is used for selected item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater =(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sub_category_row,null);
        }

        TextView subCategoryName =(TextView) convertView.findViewById(R.id.sub_category_name);
        ImageView subCategoryIcon = (ImageView)convertView.findViewById(R.id.sub_category_icon);


        subCategoryName.setText(categories[position]);
        subCategoryName.setTag(1,categories_id[position]);
        subCategoryIcon.setImageResource(R.drawable.music);

        return  convertView;
    }
}
