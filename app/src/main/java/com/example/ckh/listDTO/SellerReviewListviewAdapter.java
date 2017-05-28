package com.example.ckh.listDTO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ckh.foodtruck.R;
import com.example.ckh.viewDTO.ItemViewHolderDTO;
import com.example.ckh.viewDTO.ReviewItemDTO;

import java.util.ArrayList;

/**
 * Created by Ckh on 2016-10-27.
 */
public class SellerReviewListviewAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<ReviewItemDTO> reviewItemDTOListData = new ArrayList<ReviewItemDTO>();

    public SellerReviewListviewAdapter(Context allMenuContext) {
        super();
        this.mContext = allMenuContext;
    }

    @Override
    public int getCount() {
        return reviewItemDTOListData.size();
    }

    @Override
    public Object getItem(int position) {
        return reviewItemDTOListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolderDTO ItemHolder;
        if (convertView == null) {
            ItemHolder = new ItemViewHolderDTO();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.reviewformlayout, null);
            ItemHolder.setWriter((TextView) convertView.findViewById(R.id.reviewform_writer));
            ItemHolder.setDate((TextView) convertView.findViewById(R.id.reviewform_data));
            ItemHolder.setScore((TextView) convertView.findViewById(R.id.reviewform_score));
            ItemHolder.setContents((TextView) convertView.findViewById(R.id.reviewform_content));
            convertView.setTag(ItemHolder);
        } else {
            ItemHolder = (ItemViewHolderDTO) convertView.getTag();
        }
        ReviewItemDTO RevItemData = reviewItemDTOListData.get(position);

        ItemHolder.getWriter().setText(RevItemData.getWriter());
        ItemHolder.getDate().setText(RevItemData.getDate());
        ItemHolder.getScore().setText(" ");
        ItemHolder.getContents().setText(RevItemData.getContent());
        return convertView;
    }

    public void addItem(String writer, String date, double score, String contents) {
        ReviewItemDTO addingData = new ReviewItemDTO();
        addingData.setWriter(writer);
        addingData.setDate(date);
        addingData.setScore(score);
        addingData.setContent(contents);

        reviewItemDTOListData.add(addingData);
    }

    public void remove(int position) {
        reviewItemDTOListData.remove(position);
    }


}

