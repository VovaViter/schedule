package cn.ua.vova.schedule.task;

import android.content.Context;
import android.os.AsyncTask;

import java.io.File;
import java.sql.SQLException;

import cn.ua.vova.schedule.database.DataBaseHelper;
import cn.ua.vova.schedule.pojo.City;
import cn.ua.vova.schedule.pojo.ScheduleData;
import cn.ua.vova.schedule.pojo.ScheduleItem;

/**
 * Created by Viter on 25.04.2016.
 */
public class DataBaseSaveTask extends AsyncTask <ScheduleData,Void,Boolean> {

    private DataBaseHelper dbHelper;
    private Context appContext;

    @Override
    protected Boolean doInBackground(ScheduleData... params) {
        Boolean retval=Boolean.FALSE;
        if (params[0]!=null) {
                if (dbHelper == null) {
                    dbHelper = new DataBaseHelper(appContext);
                }
                try {
                    for (ScheduleItem item : params[0].getData()) {
                        City from = item.getFrom_city();
                        City to = item.getTo_city();
                        if (from != null & dbHelper.getCityDAO().getById(from.getId()) == null) {
                            dbHelper.getCityDAO().create(from);
                        }
                        if (to != null & dbHelper.getCityDAO().getById(to.getId()) == null) {
                            dbHelper.getCityDAO().create(to);
                        }
                        dbHelper.getScheduleItemDAO().create(item);
                    }
                    retval = Boolean.TRUE;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return retval;
    }

    public DataBaseSaveTask(Context appContext) {
        super();
        this.appContext=appContext;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    public static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }

}
