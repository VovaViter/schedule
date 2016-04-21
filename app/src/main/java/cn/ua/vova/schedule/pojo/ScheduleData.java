package cn.ua.vova.schedule.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vova on 20.04.2016.
 */

public class ScheduleData {

    private List<ScheduleItem> data;
    private Boolean success;

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setData(List<ScheduleItem> data) {
        this.data = data;
    }

    public List<ScheduleItem> getData() {

        return data;
    }

    public Boolean getSuccess() {
        return success;
    }
}
