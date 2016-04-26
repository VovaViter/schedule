package cn.ua.vova.schedule.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.ua.vova.schedule.R;
import cn.ua.vova.schedule.pojo.ScheduleItem;

/**
 * Created by Vova on 26.04.2016.
 */
public class ScheduleItemAdapter extends BaseAdapter {

    private List<ScheduleItem> data;
    private LayoutInflater layoutInflater;

    public ScheduleItemAdapter(List<ScheduleItem> data,Context context) {
        this.data = data;
        this.layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        int retval=-1;
        if (data!=null){
            retval=data.size();
        }
        return retval;
    }

    @Override
    public Object getItem(int position) {
        ScheduleItem retval=null;
        if (data!=null){
            retval=data.get(position);
        }
        return  retval;
    }

    @Override
    public long getItemId(int position) {
        long retval=-1;
        if (data!=null){
            retval=data.get(position).getId();
        }
        return retval;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if (view==null){
            view=layoutInflater.inflate(R.layout.scheduelt_item_layout,parent, false);
        }
        ScheduleItem item=(ScheduleItem)getItem(position);
        if(item!=null){
            TextView textViewCity=(TextView)view.findViewById(R.id.textView);
            textViewCity.setText(item.getFrom_city().getName()+" - "+item.getTo_city().getName());
            TextView textViewPrice=(TextView)view.findViewById(R.id.textView2);
            textViewPrice.setText(item.getPrice().toString());
            TextView textViewInfo=(TextView)view.findViewById(R.id.textView5);
            textViewInfo.setText(item.getInfo());
            TextView textViewTimeSend=(TextView)view.findViewById(R.id.textView3);
            textViewTimeSend.setText(item.getFrom_date()+" "+item.getFrom_time());
            TextView textViewTimeRecive=(TextView)view.findViewById(R.id.textView4);
            textViewTimeRecive.setText(item.getTo_date()+" "+item.getTo_time());
        }
        return view;
    }
}
