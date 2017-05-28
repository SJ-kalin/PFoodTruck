package com.example.ckh.listDTO;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ckh.foodtruck.R;
import com.example.ckh.viewDTO.MenuViewHolderDTO;
import com.example.ckh.viewDTO.Seller_MenuItemDTO;

import java.util.ArrayList;

/**
 * Created by Ckh on 2016-10-02.
 */
public class SellerMenuListviewAdapter extends BaseAdapter {
    private Context allMenuContext = null;
    private ArrayList<Seller_MenuItemDTO> allMenuListData = new ArrayList<Seller_MenuItemDTO>();

    public SellerMenuListviewAdapter(Context allMenuContext) {
        super();
        this.allMenuContext = allMenuContext;
    }

    @Override
    public int getCount() {
        return allMenuListData.size();
    }

    @Override
    public Object getItem(int position) {
        return allMenuListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(Bitmap foodImage, String foodName, String foodPrice, String foodOrigin, String foodInfo) {
        Seller_MenuItemDTO addInfo = new Seller_MenuItemDTO();
        addInfo.setMenuImage(foodImage);
        addInfo.setMenuTitle(foodName);
        addInfo.setPrice(foodPrice);
        addInfo.setOrigin(foodOrigin);
        addInfo.setInfo(foodInfo);

        allMenuListData.add(addInfo);
    }

    public void remove(int position) {
        allMenuListData.remove(position);
    }

    public void dataChange() {
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MenuViewHolderDTO MenuHolderDTO;
        if (convertView == null) {
            MenuHolderDTO = new MenuViewHolderDTO();

            LayoutInflater inflater = (LayoutInflater) allMenuContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.seller_menu_added_layout, null);

            MenuHolderDTO.setFoodImage((ImageView) convertView.findViewById(R.id.all_menu_image));
            MenuHolderDTO.setFoodName((TextView) convertView.findViewById(R.id.all_menu_foodname));
            MenuHolderDTO.setFoodPrice((TextView) convertView.findViewById(R.id.all_menu_price));
            MenuHolderDTO.setFoodOrigin((TextView) convertView.findViewById(R.id.all_menu_origin));

            convertView.setTag(MenuHolderDTO);
        } else {
            MenuHolderDTO = (MenuViewHolderDTO) convertView.getTag();
        }

        Seller_MenuItemDTO allMenuData = allMenuListData.get(position);

        if (allMenuData.getMenuImage() != null) {
            MenuHolderDTO.getFoodImage().setVisibility(View.VISIBLE);
            MenuHolderDTO.getFoodImage().setImageBitmap(allMenuData.getMenuImage());
        } else {
            MenuHolderDTO.getFoodImage().setVisibility(View.GONE);
        }

        MenuHolderDTO.getFoodName().setText(allMenuData.getMenuTitle());
        MenuHolderDTO.getFoodPrice().setText(allMenuData.getPrice());
        MenuHolderDTO.getFoodOrigin().setText(allMenuData.getOrigin());

        return convertView;
    }


}
