package cn.ua.vova.schedule.pojo;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Vova on 20.04.2016.
 */
@DatabaseTable(tableName = "City")
public class City implements Serializable{

    @DatabaseField(id = true,dataType = DataType.LONG_OBJ)
    private Long id;
    @DatabaseField(dataType = DataType.STRING)
    private String name;
    @DatabaseField(dataType = DataType.INTEGER_OBJ)
    private Integer highlight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHighlight() {
        return highlight;
    }

    public void setHighlight(Integer highlight) {
        this.highlight = highlight;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", highlight=" + highlight +
                '}';
    }
}
