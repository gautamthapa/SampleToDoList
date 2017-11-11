package com.imstar.gautam.firebasetodolist.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imstar.gautam.firebasetodolist.MainActivity;
import com.imstar.gautam.firebasetodolist.Model.ToDo;
import com.imstar.gautam.firebasetodolist.R;

import java.util.ArrayList;
import java.util.List;

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
        item_title = itemView.findViewById(R.id.item_title);
        item_description = itemView.findViewById(R.id.item_description);
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
        menu.add(0, 0, getAdapterPosition(), "DELETE");

    }
}


public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    MainActivity mainActivity;
    List<ToDo> toDoList;

    public ListItemAdapter(MainActivity mainActivity, List<ToDo> toDoList) {
        this.mainActivity = mainActivity;
        this.toDoList = toDoList;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mainActivity.getBaseContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {

        // set data for item
        holder.item_title.setText(toDoList.get(position).getTitle());
        holder.item_description.setText(toDoList.get(position).getDescription());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                //when user select item , data will auto set for EditText view
                mainActivity.title.setText(toDoList.get(position).getTitle());
                mainActivity.description.setText(toDoList.get(position).getDescription());

                mainActivity.isUpdate = true;     // set flag is update = true
                mainActivity.idUpdate = toDoList.get(position).getId();

            }
        });
    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }
}
