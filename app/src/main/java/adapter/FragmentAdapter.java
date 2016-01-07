package adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bikram.mattabsapp.R;

import java.util.Collections;
import java.util.List;

import model.FragmentData;


/**
 * Created by bikram on 1/4/16.
 */
public class FragmentAdapter extends RecyclerView.Adapter<FragmentAdapter.MyViewHolder> {
//    private String[] mDataset;
    List<FragmentData> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);

            icon= (ImageView) itemView.findViewById(R.id.icon);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FragmentAdapter(Context context, List<FragmentData> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public FragmentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);
        return holder;
        // set the view's size, margins, paddings and layout parameters

    }

    // Replace the contents of a view (invoked by the layout manager)
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FragmentData current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconID);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return data.size();
    }


}