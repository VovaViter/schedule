package cn.ua.vova.schedule.database.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import cn.ua.vova.schedule.pojo.City;

/**
 * Created by Vova on 20.04.2016.
 */
public class CityDAO extends BaseDaoImpl <City, Long> {

    public CityDAO(ConnectionSource connectionSource, Class<City> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<City> getAll() throws SQLException{
        return this.queryForAll();
    }

    public City getById(Long id) throws  SQLException{
        return  this.queryForId(id);
    }
}
