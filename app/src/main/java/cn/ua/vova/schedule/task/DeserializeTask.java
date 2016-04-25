package cn.ua.vova.schedule.task;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;

import cn.ua.vova.schedule.json.JsonReader;
import cn.ua.vova.schedule.pojo.ScheduleData;

/**
 * Created by Vova on 20.04.2016.
 */
public class DeserializeTask extends AsyncTask<String,Void,ScheduleData> {

    private JsonReader jsonReader=JsonReader.getInstance();
    private Context context;

    public DeserializeTask(Context context) {
        this.context=context;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onPostExecute(ScheduleData scheduleData) {
        super.onPostExecute(scheduleData);
        DataBaseSaveTask dataBaseSaveTask =new DataBaseSaveTask(context);
        dataBaseSaveTask.execute(scheduleData);

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
