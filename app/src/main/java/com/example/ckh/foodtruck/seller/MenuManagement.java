package com.example.ckh.foodtruck.seller;
//data/data/com.example.ckh.foodtruck/files/
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.ckh.listDTO.SellerMenuListviewAdapter;
import com.example.ckh.foodtruck.GlobalApplication;
import com.example.ckh.foodtruck.R;
import com.example.ckh.foodtruck.database.DBSQLiteOpenHelper;

/**
 * Created by Ckh on 2016-10-02.
 * db가 오픈되면서 초기에 insert된 데이터들을 조건에 맞게
 */
public class MenuManagement extends Activity {
    DBSQLiteOpenHelper helper;
    SQLiteDatabase db;
    String imgpath = "data/data/com.example.ckh.foodtruck/files/";
    private ListView MenuList = null;
    private SellerMenuListviewAdapter ListViewAdapter = null;
    Bitmap bm;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.seller_tab2_menumng);

        Button adddetail = (Button) findViewById(R.id.seller_btn_menuadded);
        adddetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuManagement.this,Seller_MenuAdd.class);
                startActivityForResult(intent,100);
            }
        });

        MenuList=(ListView) findViewById(R.id.all_menu_list);
        ListViewAdapter = new SellerMenuListviewAdapter(this);
        MenuList.setAdapter(ListViewAdapter);

        helper = new DBSQLiteOpenHelper(
                MenuManagement.this,
                GlobalApplication.dbName,
                null,
                1
        );
        db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from menu where truck_id=102",null);
        while(c.moveToNext()){
            String imgcode = c.getString(6);
            int price = c.getInt(5);
            String origin = c.getString(4);
            try {
                bm = BitmapFactory.decodeFile(imgpath + imgcode+".png");
            }catch (Exception e){
                e.printStackTrace();
                Log.e("fileloadfailed","비트맵 이미지 불러오기 실패");
            }
            ListViewAdapter.addItem(bm,c.getString(2),Integer.toString(c.getInt(5)),c.getString(4),"");
        }

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == 50){
            ListViewAdapter.dataChange();
            Log.i("resultcode","결과 코드가 실행되나욧");
        }
    }

}
