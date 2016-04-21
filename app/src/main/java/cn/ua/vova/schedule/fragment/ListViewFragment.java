package cn.ua.vova.schedule.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import cn.ua.vova.schedule.R;
import cn.ua.vova.schedule.json.JsonReader;
import cn.ua.vova.schedule.task.DeserializeTask;

public class ListViewFragment extends Fragment {

    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeserializeTask task=new DeserializeTask(JsonReader.getInstance(),getActivity().getApplicationContext());
        task.execute("http://smartbus.gmoby.org/web/index.php/api/trips?from_date=2016-01-01&to_date=2016-03-01");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_view, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView= (ListView) getView().findViewById(R.id.listView);
    }
}
