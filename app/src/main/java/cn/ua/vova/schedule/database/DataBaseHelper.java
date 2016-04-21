package cn.ua.vova.schedule.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import cn.ua.vova.schedule.database.dao.CityDAO;
import cn.ua.vova.schedule.database.dao.ScheduleItemDAO;
import cn.ua.vova.schedule.pojo.City;
import cn.ua.vova.schedule.pojo.ScheduleItem;

/**
 * Created by Vova on 20.04.2016.
 */
public class DataBaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME="Schedule_DB";
    private static final int VERSION=10;

    private CityDAO cityDAO=null;
    private ScheduleItemDAO scheduleItemDAO=null;

    public CityDAO getCityDAO() {
        if (cityDAO==null){
            try {
                cityDAO = new CityDAO(getConnectionSource(), City.class);
            }catch ( SQLException e){
                e.printStackTrace();
            }
        }
        return cityDAO;
    }

    public ScheduleItemDAO getScheduleItemDAO() {
        if (scheduleItemDAO==null){
            try {
                scheduleItemDAO=new ScheduleItemDAO(getConnectionSource(), ScheduleItem.class);
            }catch ( SQLException e){
                e.printStackTrace();
            }
        }
        return scheduleItemDAO;
    }

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);;
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try{
            TableUtils.dropTable(connectionSource, ScheduleItem.class, true);
            TableUtils.dropTable(connectionSource, City.class, true);
            onCreate(database, connectionSource);
        }
        catch (SQLException e){
           e.printStackTrace();
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db,ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, ScheduleItem.class);
            TableUtils.createTable(connectionSource, City.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
