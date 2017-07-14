package project.android.mini2.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import project.android.mini2.Data.Item;
import project.android.mini2.Fragment.BaseFragment;
import project.android.mini2.R;
import project.android.mini2.Holder.ViewHolder;

/**
 * Created by qkrqh on 2017-07-14.
 */

public class ItemAdapter  extends RecyclerView.Adapter<ViewHolder>{

    private Context context;
    private ArrayList<Item> items;
    int item_layout;
    public ViewHolder viewHolder;

    public ItemAdapter(ArrayList<Item> items, Context context, int item_layout) {
        this.items = items;
        this.context = context;
        this.item_layout=item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        viewHolder = new ViewHolder(view);

        return viewHolder;

    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){ // 이방법너무비열한거같아요 ㅠㅠ 다른방법찾아볼게요

        final Item item = items.get(position);
        holder.name.setText(item.getName());
        holder.content.setText(item.getContent());
        holder.contentImg.setImageResource(item.getImg());
        if(item.getCheck() == true)
            holder.checkView.setImageResource(R.drawable.check);
        else
            holder.checkView.setImageResource(R.drawable.no_check);

        holder.checkView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Boolean isCkeck= BaseFragment.noti(position);
                if(isCkeck == true)
                    holder.checkView.setImageResource(R.drawable.check);
                else
                    holder.checkView.setImageResource(R.drawable.no_check);
            }
        });

    }

    @Override
    public int getItemCount() {

        return items.size();
    }

}