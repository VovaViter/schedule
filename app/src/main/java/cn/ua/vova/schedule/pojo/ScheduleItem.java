package cn.ua.vova.schedule.pojo;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Vova on 20.04.2016.
 */
@DatabaseTable(tableName = "Item")
public class ScheduleItem implements Serializable {

    @DatabaseField(id = true,dataType = DataType.LONG_OBJ)
    private Long id;
    @DatabaseField(dataType = DataType.LONG_OBJ)
    private Long bus_id;
    @DatabaseField(dataType = DataType.BIG_DECIMAL)
    private BigDecimal price;
    @DatabaseField(dataType = DataType.INTEGER_OBJ)
    private Integer reservation_count;
    @DatabaseField(dataType = DataType.STRING)
    private String from_time;
    @DatabaseField(dataType = DataType.STRING)
    private String to_info;
    @DatabaseField(foreign = true, foreignAutoRefresh = true,canBeNull = false)
    private City from_city;
    @DatabaseField(foreign = true, foreignAutoRefresh = true,canBeNull = false)
    private City to_city;
    @DatabaseField(dataType = DataType.STRING)
    private String to_date;
    @DatabaseField(dataType = DataType.STRING)
    private String from_date;
    @DatabaseField(dataType = DataType.STRING)
    private String from_info;
    @DatabaseField(dataType = DataType.STRING)
    private String info;
    @DatabaseField(dataType = DataType.STRING)
    private String to_time;

    public String getTo_time() {
        return to_time;
    }

    public void setTo_time(String to_time) {
        this.to_time = to_time;
    }

    public Long getBus_id() {
        return bus_id;
    }

    public void setBus_id(Long bus_id) {
        this.bus_id = bus_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getReservation_count() {
        return reservation_count;
    }

    public void setReservation_count(Integer reservation_count) {
        this.reservation_count = reservation_count;
    }

    public String getFrom_time() {
        return from_time;
    }

    public void setFrom_time(String from_time) {
        this.from_time = from_time;
    }

    public String getTo_info() {
        return to_info;
    }

    public void setTo_info(String to_info) {
        this.to_info = to_info;
    }

    public City getFrom_city() {
        return from_city;
    }

    public void setFrom_city(City from_city) {
        this.from_city = from_city;
    }

    public City getTo_city() {
        return to_city;
    }

    public void setTo_city(City to_city) {
        this.to_city = to_city;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getFrom_info() {
        return from_info;
    }

    public void setFrom_info(String from_info) {
        this.from_info = from_info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ScheduleItem{" +
                "id=" + id +
                ", bus_id=" + bus_id +
                ", price=" + price +
                ", reservation_count=" + reservation_count +
                ", from_time='" + from_time + '\'' +
                ", to_info='" + to_info + '\'' +
                ", from_city=" + from_city +
                ", to_city=" + to_city +
                ", to_date='" + to_date + '\'' +
                ", from_date='" + from_date + '\'' +
                ", from_info='" + from_info + '\'' +
                ", info='" + info + '\'' +
                ", to_time='" + to_time + '\'' +
                '}';
    }
}
