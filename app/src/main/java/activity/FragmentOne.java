package activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import adapter.FragmentAdapter;
import model.FragmentData;

import com.example.bikram.mattabsapp.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentOne extends Fragment{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public FragmentOne() {
        // Required empty public constructor
    }
    public static List<FragmentData> getData() {
        List<FragmentData> data = new ArrayList<>();
        int[] icons={R.drawable.job,R.drawable.suv,R.drawable.phone,R.drawable.manual};
        String[] titles={"Facebook" ,"Twitter","Youtube","Gmail"};
        // preparing navigation drawer items
        for (int i = 0; i < titles.length; i++) {
            FragmentData navItem = new FragmentData();
            navItem.iconID=icons[i];
            navItem.title=titles[i];
            data.add(navItem);
        }
        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_one, container, false);


        // recycle view edit
        recyclerView = (RecyclerView) layout.findViewById(R.id.my_recycler_view);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new FragmentAdapter(getActivity(), getData());
        recyclerView.setAdapter(mAdapter);

        return layout;


    }

}