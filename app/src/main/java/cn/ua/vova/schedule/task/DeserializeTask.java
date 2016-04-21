package cn.ua.vova.schedule.task;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.sql.SQLException;

import cn.ua.vova.schedule.activity.MainActivity;
import cn.ua.vova.schedule.database.DataBaseHelper;
import cn.ua.vova.schedule.json.JsonReader;
import cn.ua.vova.schedule.pojo.City;
import cn.ua.vova.schedule.pojo.ScheduleData;

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
            dbHelper.getCityDAO().create(new City());
        }catch ( SQLException e) {
            e.printStackTrace();
        }
        dbHelper.getScheduleItemDAO();
    }

    @Override
    protected ScheduleData doInBackground(String... params) {
        if (params[0]!=null){
            String jsonObjects= jsonReader.readJsonFromUrl(params[0]);
            Gson gSon= new Gson();
            ScheduleData data=gSon.fromJson(jsonObjects,ScheduleData.class);
            for (int i=0;i<data.getData().size();i++){
                Log.w(Integer.toString(i),data.getData().get(i).getId().toString());
            }
        }
        return null;
    }
}
