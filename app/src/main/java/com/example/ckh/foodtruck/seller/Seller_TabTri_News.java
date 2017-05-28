package com.example.ckh.foodtruck.seller;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.example.ckh.viewDTO.Seller_News_EventFullDTO;
import com.example.ckh.viewDTO.Seller_News_EventListDTO;
import com.example.ckh.viewDTO.NewsViewHolderDTO;
import com.example.ckh.foodtruck.R;

import java.util.ArrayList;

/**
 * Created by Ckh on 2016-10-03.
 */
@SuppressLint("ValidFragment")
public class Seller_TabTri_News extends Fragment {
    Context mContext;

    public Seller_TabTri_News(Context context) {
        mContext = context;
    }

    private Seller_News_Parsing parser;
    private ListView seoulEventListView = null;
    private AQuery aq = new AQuery(getContext());
    private ListViewAdapter seoulEventAdapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b) {
        View view = inflater.inflate(R.layout.seller_tab3_news_list, null);
        seoulEventListView = (ListView) view.findViewById(R.id.seoulevent_menu_list);
        ListViewAdapter seoulEventAdapter = new ListViewAdapter(getActivity());
        seoulEventListView.setAdapter(seoulEventAdapter);

        StrictMode.enableDefaults();

        parser = new Seller_News_Parsing();     // 파싱하는 객체 생성
        new FestAsync().execute(null, null, null);  // 비동기식 스레드 시작하기

        return view;
    }


    private class ListViewAdapter extends BaseAdapter {
        private Context seoulEventContext = null;
        private ArrayList<Seller_News_EventListDTO> seoulEventListData = new ArrayList<Seller_News_EventListDTO>();

        public ListViewAdapter(Context seoulEventContext) {
            super();
            this.seoulEventContext = seoulEventContext;
        }

        @Override
        public int getCount() {
            return seoulEventListData.size();
        }

        @Override
        public Object getItem(int position) {
            return seoulEventListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void addItem(String eventImage, String eventName, String eventDate, String eventPlace) {
            Seller_News_EventListDTO addInfo = null;
            addInfo = new Seller_News_EventListDTO();
            addInfo.setEventImage(eventImage);
            // drawable로 선언 안하고 url로 바로 넣으면 이미지 등록되는 방식으로 String으로 바꿈


            addInfo.setEventName(eventName);// 이벤트 명
            addInfo.setEventDate(eventDate); // 이벤트 날짜
            addInfo.setEventPlace(eventPlace); // 이밴트 장소

            seoulEventListData.add(addInfo);
        }

        public void remove(int position) {
            seoulEventListData.remove(position);
            dataChange();
        }

        public void dataChange() {
            seoulEventAdapter.notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            NewsViewHolderDTO seoulEventHolder;
            if (convertView == null) {
                seoulEventHolder = new NewsViewHolderDTO();

                LayoutInflater inflater = (LayoutInflater) seoulEventContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.seller_tab3_news_customlayout, null);

                seoulEventHolder.setEventImage((ImageView) convertView.findViewById(R.id.seller_event_image));
                seoulEventHolder.setEventName((TextView) convertView.findViewById(R.id.seller_event_name));
                seoulEventHolder.setEventDate((TextView) convertView.findViewById(R.id.seller_event_date));
                seoulEventHolder.setEventPlace((TextView) convertView.findViewById(R.id.seller_event_place));

                convertView.setTag(seoulEventHolder);
            } else {
                seoulEventHolder = (NewsViewHolderDTO) convertView.getTag();
            }

            Seller_News_EventListDTO seoulEventData = seoulEventListData.get(position);

            if (seoulEventData.getEventImage() != null && seoulEventData.getEventImage().compareTo("Please Default Image (E)") != 0) {

                seoulEventHolder.getEventImage().setVisibility(View.VISIBLE);
                aq.id(seoulEventHolder.getEventImage()).image(seoulEventData.getEventImage());
                // url로 이미지 직접 삽입


            } else {
                seoulEventHolder.getEventImage().setVisibility(View.GONE);
            }

            seoulEventHolder.getEventName().setText(seoulEventData.getEventName());
            seoulEventHolder.getEventDate().setText(seoulEventData.getEventDate());
            seoulEventHolder.getEventPlace().setText(seoulEventData.getEventPlace());
            return convertView;
        }


    }

    // 비동기식 스레드의 필요성 : 파싱해서 리스트뷰 적용시 사용
    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    public class FestAsync extends AsyncTask<String, String, ArrayList<Seller_News_EventFullDTO>> {
        // 마지막에 ArrayList<Seller_News_EventFullDTO>>이라는 객체가 결과값으로 (파싱의 결과값) 나옴
        protected ArrayList<Seller_News_EventFullDTO> doInBackground(String... params) {
            return parser.connectFest();    // 파싱하기
        }

        protected void onPostExecute(ArrayList<Seller_News_EventFullDTO> result) {
            seoulEventAdapter = new ListViewAdapter(getActivity()); // 아답터를 받아와서
            seoulEventListView.setAdapter(seoulEventAdapter);   //설정하기
            for (int i = 0; i < result.size(); i++) {
                seoulEventAdapter.addItem(result.get(i).getMainIMGURL(), result.get(i).getTitle(),
                        result.get(i).getStartDate() + result.get(i).getEndDate(), result.get(i).getPlace());
            }   // 리스트뷰에 삽입

        }
    }

}
