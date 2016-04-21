package cn.ua.vova.schedule.database.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import cn.ua.vova.schedule.pojo.ScheduleItem;

/**
 * Created by Vova on 20.04.2016.
 */
public class ScheduleItemDAO extends BaseDaoImpl <ScheduleItem, Long>{


    public ScheduleItemDAO(ConnectionSource connectionSource, Class<ScheduleItem> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<ScheduleItem> getAll() throws  SQLException{
        return queryForAll();
    }
}
