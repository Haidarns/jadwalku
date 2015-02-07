package id.hnslabs.jadwalku;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by HaidarNS on 08/01/2015.
 */
public class JKAdapter extends CursorAdapter {
    private Cursor cursor;

    public JKAdapter(Context context, Cursor cur) {
        super(context, cur);
        cursor = cur;
        // TODO Auto-generated constructor stub
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // TODO Auto-generated method stub

        TextView txtJam1 = (TextView) view.findViewById(R.id.tvJam1);
        txtJam1.setText(cursor.getString(cursor.getColumnIndex("jam1")));

        TextView txtJam2 = (TextView) view.findViewById(R.id.tvJam2);
        txtJam2.setText(cursor.getString(cursor.getColumnIndex("jam2")));

        TextView txtMatkul = (TextView) view.findViewById(R.id.tvMatkul);
        txtMatkul.setText(cursor.getString(cursor.getColumnIndex("matkul")));

        TextView txtRuang = (TextView) view.findViewById(R.id.tvRuang);
        txtRuang.setText(cursor.getString(cursor.getColumnIndex("ruang")));

        TextView txtDosen = (TextView) view.findViewById(R.id.tvDosen);
        txtRuang.setText(cursor.getString(cursor.getColumnIndex("dosen")));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.jklist, parent, false);
        bindView(view, context, cursor);
        return view;
    }


    public int getCount() {
        // TODO Auto-generated method stub
        return cursor.getCount();
    }


    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
}
