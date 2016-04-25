package cn.ua.vova.schedule.event;

import java.util.List;

import cn.ua.vova.schedule.pojo.ScheduleItem;

/**
 * Created by Viter on 25.04.2016.
 */
public interface DataHandlerEvent {

    void onHandle(List<ScheduleItem> data);
}
