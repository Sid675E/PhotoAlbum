package com.example.sidra.photoalbum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends Activity {

    static Integer[] mThumbIds = {
            R.drawable.s_1, R.drawable.s_2,
            R.drawable.s_3, R.drawable.s_4,
            R.drawable.s_5, R.drawable.s_6,
            R.drawable.s_7, R.drawable.s_8,
            R.drawable.s_9
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                Intent intent= new Intent(MainActivity.this,PhotoActivity.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }

        });



    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        // Constructor
        public ImageAdapter(Context context) {
            mContext = context;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;

            if (convertView == null) {

                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(250, 250)); //size of photos
                //imageView.setLayoutParams(
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            }
            else
            {
                imageView = (ImageView) convertView;
            }
            //imageView.setImageResource(mThumbIds[position]);

            Picasso.with(mContext)
                    .load(mThumbIds[position])
                    //.placeholder(R.drawable.err)
                    //.error(R.drawable.err)
                    //.resize(50, 50)
                    //.centerInside()
                    .into(imageView);
            return imageView;
        }
    }
}

