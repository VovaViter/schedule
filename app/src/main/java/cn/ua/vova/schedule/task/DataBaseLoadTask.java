package cn.ua.vova.schedule.task;

import android.content.Context;
import android.os.AsyncTask;

import java.sql.SQLException;
import java.util.List;

import cn.ua.vova.schedule.database.DataBaseHelper;
import cn.ua.vova.schedule.event.DataHandlerEvent;
import cn.ua.vova.schedule.pojo.ScheduleItem;

/**
 * Created by Viter on 25.04.2016.
 */
public class DataBaseLoadTask extends AsyncTask<Void, Void, List<ScheduleItem>> {

    private DataBaseHelper dbHelper;
    private Context appContext;
    private DataHandlerEvent listener;

    @Override
    protected void onPostExecute(List<ScheduleItem> scheduleItems) {
        super.onPostExecute(scheduleItems);
        listener.onHandle(scheduleItems);
    }

    public DataBaseLoadTask(Context appContext,DataHandlerEvent listener) {
        this.listener=listener;
        this.appContext = appContext;
    }

    @Override
    protected List<ScheduleItem> doInBackground(Void... params) {
        if (dbHelper == null) {
            dbHelper = new DataBaseHelper(appContext);
        }
        try {
            return dbHelper.getScheduleItemDAO().getAll();
        } catch (SQLException e) {
        }
        return null;
    }
}
