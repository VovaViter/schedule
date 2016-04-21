package cn.ua.vova.schedule.task;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.sql.SQLException;
import java.util.List;

import cn.ua.vova.schedule.database.DataBaseHelper;
import cn.ua.vova.schedule.json.JsonReader;
import cn.ua.vova.schedule.pojo.City;
import cn.ua.vova.schedule.pojo.ScheduleData;
import cn.ua.vova.schedule.pojo.ScheduleItem;

/**
 * Created by Vova on 20.04.2016.
 */
public class DeserializeTask extends AsyncTask<String,Void,ScheduleData> {

    private JsonReader jsonReader;
    private DataBaseHelper dbHelper;
    private Context appContext;

    public DeserializeTask(JsonReader jsonReader, Context context) {
        this.appContext=context;
        this.jsonReader = jsonReader;
    }

    @Override
    protected void onPostExecute(ScheduleData scheduleData) {
        super.onPostExecute(scheduleData);
        if (dbHelper==null){
            dbHelper=new DataBaseHelper(appContext);
        }
        try {
             for (ScheduleItem item:scheduleData.getData()) {
                 City from=item.getFrom_city();
                 City to=item.getTo_city();
                 //TODO optimization make one select per loop
                 if (from!=null & dbHelper.getCityDAO().getById(from.getId())== null){
                     dbHelper.getCityDAO().create(from);
                 }
                 if (to!=null & dbHelper.getCityDAO().getById(to.getId())== null){
                     dbHelper.getCityDAO().create(to);
                 }
                 dbHelper.getScheduleItemDAO().create(item);
             }
        }catch ( SQLException e) {
            e.printStackTrace();
        }

        dbHelper.getScheduleItemDAO();
    }

    @Override
    protected ScheduleData doInBackground(String... params) {
        ScheduleData retval=null;
        if (params[0]!=null){
            String jsonObjects= jsonReader.readJsonFromUrl(params[0]);
            Gson gSon= new Gson();
            retval=gSon.fromJson(jsonObjects,ScheduleData.class);
        }
        return retval;
    }

}
