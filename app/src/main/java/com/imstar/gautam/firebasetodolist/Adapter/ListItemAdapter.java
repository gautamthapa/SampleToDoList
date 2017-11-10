package com.imstar.gautam.firebasetodolist.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imstar.gautam.firebasetodolist.R;

/**
 * Created by Gautam on 11-11-2017.
 */

class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener {

    ItemClickListener itemClickListener;
    TextView item_title, item_description;

    public ListItemViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);
        item_title=itemView.findViewById(R.id.item_title);
        item_description=itemView.findViewById(R.id.item_description);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("select the action");
        menu.add(0,0,getAdapterPosition(), "DELETE");

    }
}

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder>{
    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
