package com.example.wei.tw.listview4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    // 項目使用的畫面配置資源
    private int layoutId;
    // 所有項目資料
    private List<Fruit> items;

    // 建構子
    // 第一個參數 Context 物件，表示使用這個類別的 Activity 元件
    // 第二個參數是項目使用的畫面配置資源
    // 第三個參數是所有項目資料
    FruitAdapter(Context context,
                 int layoutId, List<Fruit> items) {

        // 呼叫父類別建構子，執行必要的設定
        super(context, layoutId, items);

        this.layoutId = layoutId;
        this.items = items;
    }

    // 至少要覆寫 getView 方法
    // 在方法中製作與回傳代表項目畫面的 View 物件
    // 第一個參數是項目的編號，第一個是 0
    // 第二個參數是代表項目的 View 物件
    // 第三個參數是 ListView 物件
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        // 取得使用這個類別的 Activity 物件
        Context context = getContext();

        // 因為項目的畫面使用 LinearLayout
        // 所以宣告一個 LinearLayout 變數
        LinearLayout view;

        // ListView 需要建立的新項目
        if (convertView == null) {

            // 在這個 Activity 上建立一個新的 View 物件
            view = new LinearLayout(context);

            // 使用 LayoutInflater 把畫面配置檔轉換為 View 物件
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            // 加載畫面
            LayoutInflater vi = (LayoutInflater)
                    context.getSystemService(inflater);

            // 轉換成 View
            // 第一個參數是畫面配置資源
            // 第二個參數是父畫面配置資源
            // 第三個參數是最外的畫面配置資源
            vi.inflate(layoutId, view, true);
        } else
            view = (LinearLayout)convertView;

        // 取得畫面配置檔中的畫面元件
        TextView txt_id = view.findViewById(R.id.txtId);
        TextView txt_name = view.findViewById(R.id.txtName);
        TextView txt_content = view.findViewById(R.id.txtContent);
        CheckBox ckb_select = view.findViewById(R.id.ckbSelected);

        // 取得目前項目的 Fruit 物件
        Fruit fruit = items.get(position);

        // 設定畫面元件顯示的內容
        txt_id.setText(Long.toString(fruit.getId()));
        txt_name.setText(fruit.getName());
        txt_content.setText(fruit.getContent());
        ckb_select.setChecked(fruit.isSelected());

        return view;
    }

    // 增加一個修改項目資料的方法宣告
    // 參數是位置與修改項目資料的 Fruit 物件
    void set(int index, Fruit fruit) {
        if (index > 0 && index < items.size()) {

            items.set(index, fruit);

            notifyDataSetChanged();
        }
    }
}
