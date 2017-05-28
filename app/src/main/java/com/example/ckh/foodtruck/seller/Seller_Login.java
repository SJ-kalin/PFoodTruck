package com.example.ckh.foodtruck.seller;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ckh.foodtruck.R;

import kr.hyosang.coordinate.CoordPoint;
import kr.hyosang.coordinate.TransCoord;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ckh on 2016-09-10.
 */
public class Seller_Login extends Activity {

    public static ArrayList<MovingPeopleDTO> dobong = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> gangbuk = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> nowon = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> eunpyoung = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> seoungbook = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> jonglo = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> dongdaemoon = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> jungrang = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> seodaemoon = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> junggu = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> sungdong = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> gwangjin = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> youngsan = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> mapo = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> gangseo = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> yangcheon = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> guro = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> youngdengpo = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> gumcheon = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> gwhanak = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> dongjak = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> seocho = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> gangnam = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> songpa = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> gangdong = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<MovingPeopleDTO> allSeoul = new ArrayList<MovingPeopleDTO>();
    public static ArrayList<ArrayList<MovingPeopleDTO>> allofseoul = new ArrayList<>();

    HSSFRow row;
    MakingAbove5 m = new MakingAbove5();

    private void File() {
        try {
            InputStream in = getResources().getAssets().open("movingPeople.xls");
            POIFSFileSystem fileSystem = new POIFSFileSystem(in);
            HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
            HSSFSheet sheet = workbook.getSheetAt(0);
            int rows = sheet.getPhysicalNumberOfRows();

            for (int i = 1, j = 0; i < rows; i = i + 2) {

                row = sheet.getRow(i);    //i번째 행을 읽는다 첫행제외

                MovingPeopleDTO temp1 = new MovingPeopleDTO(row.getCell(j).toString(),
                        (int) (Double.parseDouble(row.getCell(j + 1).toString())),
                        (int) (Double.parseDouble(row.getCell(j + 2).toString())),
                        (int) (Double.parseDouble(row.getCell(j + 3).toString())),
                        (int) (Double.parseDouble(row.getCell(j + 4).toString())),
                        (int) (Double.parseDouble(row.getCell(j + 5).toString())),
                        (int) (Double.parseDouble(row.getCell(j + 6).toString())), row.getCell(j + 7).toString(),
                        Double.parseDouble(row.getCell(j + 8).toString()),
                        Double.parseDouble(row.getCell(j + 9).toString()), row.getCell(j + 10).toString(),
                        row.getCell(j + 11).toString());

                row = sheet.getRow(i + 1);        //두개를 합쳐야 하기 때문에 i+1행을 읽어온다.

                MovingPeopleDTO temp2 = new MovingPeopleDTO(row.getCell(j).toString(),
                        (int) (Double.parseDouble(row.getCell(j + 1).toString())),
                        (int) (Double.parseDouble(row.getCell(j + 2).toString())),
                        (int) (Double.parseDouble(row.getCell(j + 3).toString())),
                        (int) (Double.parseDouble(row.getCell(j + 4).toString())),
                        (int) (Double.parseDouble(row.getCell(j + 5).toString())),
                        (int) (Double.parseDouble(row.getCell(j + 6).toString())), row.getCell(j + 7).toString(),
                        Double.parseDouble(row.getCell(j + 8).toString()),
                        Double.parseDouble(row.getCell(j + 9).toString()), row.getCell(10).toString(),
                        row.getCell(j + 11).toString());

                CoordPoint pt = new CoordPoint(temp1.getXcode(), temp1.getXcode());
                CoordPoint ktmPt = TransCoord.getTransCoord(pt, TransCoord.COORD_TYPE_WTM, TransCoord.COORD_TYPE_WGS84);
                Double TransXCode = ktmPt.x;
                Double TransYCode = ktmPt.y;

                TransXCode = Math.round(TransXCode * 10000) / 10000.0;
                TransYCode = Math.round(TransYCode * 10000) / 10000.0;

                MovingPeopleDTO temp3 = new MovingPeopleDTO(temp1.getExamin_spot_cd(), temp1.getMale() + temp2.getMale(),
                        temp1.getFemale() + temp2.getFemale(), temp1.getTwyoBelow() + temp2.getTwyoBelow(),
                        temp1.getTwnt_thrts() + temp2.getTwnt_thrts(), temp1.getFrts_ffts() + temp2.getFrts_ffts(),
                        temp1.getSxts_above() + temp2.getSxts_above(), temp1.getExamin_spot_name(), TransXCode, TransYCode,
                        temp1.getGuCode(), temp1.getGuCode());

                allSeoul.add(temp3);
                //guname별로 case문을 통해 데이터를 입력함
                switch (temp3.getGuname()) {
                    case "종로구":
                        jonglo.add(temp3);
                        break;

                    case "중구":
                        junggu.add(temp3);
                        break;

                    case "용산구":
                        youngsan.add(temp3);
                        break;

                    case "성동구":
                        sungdong.add(temp3);
                        break;

                    case "광진구":
                        gwangjin.add(temp3);
                        break;

                    case "동대문구":
                        dongdaemoon.add(temp3);
                        break;

                    case "중랑구":
                        jungrang.add(temp3);
                        break;

                    case "성북구":
                        seoungbook.add(temp3);
                        break;

                    case "강북구":
                        gangbuk.add(temp3);
                        break;

                    case "도봉구":
                        dobong.add(temp3);
                        break;

                    case "노원구":
                        nowon.add(temp3);
                        break;

                    case "은평구":
                        eunpyoung.add(temp3);
                        break;

                    case "서대문구":
                        seodaemoon.add(temp3);
                        break;

                    case "마포구":
                        mapo.add(temp3);
                        break;

                    case "양천구":
                        yangcheon.add(temp3);
                        break;

                    case "강서구":
                        gangseo.add(temp3);
                        break;

                    case "구로구":
                        guro.add(temp3);
                        break;

                    case "금천구":
                        gumcheon.add(temp3);
                        break;

                    case "영등포구":
                        youngdengpo.add(temp3);
                        break;

                    case "동작구":
                        dongjak.add(temp3);
                        break;

                    case "관악구":
                        gwhanak.add(temp3);
                        break;

                    case "서초구":
                        seocho.add(temp3);
                        break;

                    case "강남구":
                        gangnam.add(temp3);
                        break;

                    case "송파구":
                        songpa.add(temp3);
                        break;

                    case "강동구":
                        gangdong.add(temp3);
                        break;
                }


            }
            allofseoul.add(dobong);
            allofseoul.add(seoungbook);
            allofseoul.add(gangbuk);
            allofseoul.add(nowon);
            allofseoul.add(eunpyoung);
            allofseoul.add(dongdaemoon);
            allofseoul.add(jungrang);
            allofseoul.add(seodaemoon);
            allofseoul.add(junggu);
            allofseoul.add(sungdong);
            allofseoul.add(gwangjin);
            allofseoul.add(youngsan);
            allofseoul.add(mapo);
            allofseoul.add(gangseo);
            allofseoul.add(dobong);
            allofseoul.add(yangcheon);
            allofseoul.add(guro);
            allofseoul.add(youngdengpo);
            allofseoul.add(gumcheon);
            allofseoul.add(gwhanak);
            allofseoul.add(dongjak);
            allofseoul.add(seocho);
            allofseoul.add(gangnam);
            allofseoul.add(songpa);
            allofseoul.add(gangdong);
            Toast.makeText(Seller_Login.this, "추출완료!", Toast.LENGTH_SHORT).show();

        }                    // for문 정렬
        catch (IOException e) {
        }
    }

    private void Gusort() {
        for (int i = 0; i < allofseoul.size(); i++) {
            m.quickSort(allofseoul.get(i), 0, allofseoul.get(i).size() - 1);
            Collections.reverse(allofseoul.get(i));
        }
    }

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.seller_main);

        ImageView sellerlogin = (ImageView) findViewById(R.id.sellermain_imgbtn_Login);
        final EditText i_login = (EditText) findViewById(R.id.seller_lgn_edit_text_id);
        final EditText i_password = (EditText) findViewById(R.id.seller_lgn_edit_text_password);

        sellerlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Seller_Login.this, Seller_TabFragment.class);
                startActivity(intent);
                finish();
            }
        });

        File();
        Gusort();
    }

}
