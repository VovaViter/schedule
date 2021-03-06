package cn.ua.vova.schedule.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cn.ua.vova.schedule.R;
import cn.ua.vova.schedule.database.DataBaseHelper;
import cn.ua.vova.schedule.event.DataHandlerEvent;
import cn.ua.vova.schedule.pojo.ScheduleItem;
import cn.ua.vova.schedule.task.DataBaseLoadTask;
import cn.ua.vova.schedule.task.DataBaseSaveTask;
import cn.ua.vova.schedule.task.DeserializeTask;

public class ListViewFragment extends Fragment implements DataHandlerEvent{

    private ListView listView;
    private DeserializeTask deserializeTask=null;
    private DataBaseLoadTask dataBaseLoadTask=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_view, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView= (ListView) getView().findViewById(R.id.listView);
        if (DataBaseSaveTask.doesDatabaseExist(getContext(), DataBaseHelper.DB_NAME)) {
            dataBaseLoadTask=new DataBaseLoadTask(getContext(),this);
            dataBaseLoadTask.execute();
        }else {
            deserializeTask = new DeserializeTask(getContext());
            deserializeTask.execute("http://smartbus.gmoby.org/web/index.php/api/trips?from_date=2016-01-01&to_date=2016-03-01");
        }
    }

    @Override
    public void onHandle(List<ScheduleItem> data) {
        ScheduleItemAdapter adapter = new ScheduleItemAdapter(data,getContext());
        listView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (deserializeTask!=null && deserializeTask.isCancelled()==false){
            deserializeTask.cancel(false);
        }
        if (dataBaseLoadTask!=null && dataBaseLoadTask.isCancelled()==false){
            dataBaseLoadTask.cancel(false);
        }
    }
}
