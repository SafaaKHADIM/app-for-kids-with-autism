package com.example.asus.autismproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asus.autismproject.DAO.Database;
import com.example.asus.autismproject.DAO.Object;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mdescription = new ArrayList<>();
    private Context mContext;
    public static Database database;

    public RecyclerViewAdapter(Context context, ArrayList<String> imageNames, ArrayList<String> images, ArrayList<String> description  ) {
        mImageNames = imageNames;
        mImages = images;
        this.mContext = context;
        mdescription=description;

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);


        holder.description.setText(mdescription.get(position));
        holder.imageName.setText(mImageNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));

                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, GalleryActivity.class);

                String item = mdescription.get(position);

                List<Object> objects = MainAppActivity.database._Dao()._getObject();
                for(Object obj: objects){
                    String label =obj.getDescription();

                    if(label.equals(item)){
                        intent.putExtra("image_url",obj.getImage());
                        intent.putExtra("image_name",obj.getCategorie());
                        intent.putExtra("image_description",obj.getDescription());
                        mContext.startActivity(intent);
                    }



                }





/*

                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mImageNames.get(position));
                intent.putExtra("image_description", mdescription.get(position));
*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdescription.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        CircleImageView image;
        TextView imageName;
       TextView description;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            description=itemView.findViewById(R.id.description);
        }
    }


  public void deleteItem(int position) {
      String item = mdescription.get(position);
      mdescription.remove(position);

        notifyItemRemoved(position);

      List<Object> objects = MainAppActivity.database._Dao()._getObject();
      for(Object obj: objects){
          String label =obj.getDescription();

          if(label.equals(item)){

             MainActivity1.delete_object(obj);


          }



      }





    }




}















