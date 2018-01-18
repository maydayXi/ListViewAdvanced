package com.example.wei.tw.listview4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView txt_info;
    private ListView list_view;

    protected List<Fruit> items;
    private FruitAdapter a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processViews();
        processControllers();

        // 建立 ListView 元件需要的項目資料
        // 只能放 Fruit 的 List 物件
        items = new ArrayList<>();

        // 加入三個 Fruit 物件
        items.add(new Fruit(1, "Strawberry",
                "Sweet fleshy red fruit", true));
        items.add(new Fruit(2, "Carrot",
                "Edible root of the cultivated carrot plant", false));
        items.add(new Fruit(3, "Pumpkin",
                "Usually large purpy deep-yellow round fruit", true));

        // 建立自己設計的 Adapter 物件
        a = new FruitAdapter(this, R.layout.listview_item, items);
        // 呼叫 setAdapter 方法指定使用的 Adapter 物件
        list_view.setAdapter(a);
    }

    // 初始所有畫面元件
    private void processViews() {
        txt_info = findViewById(R.id.txtInfo);
        list_view = findViewById(R.id.listView);
    }

    // 註冊監聽事件
    private void processControllers() {
        list_view.setOnItemClickListener(new MyItem());
    }

    // 選擇監聽類別
    private class MyItem implements AdapterView.OnItemClickListener {

        @SuppressLint("SetTextI18n")
        @Override
        public void onItemClick(AdapterView<?> parent,
                                View view, int pos, long id) {

            // 取得選擇項目的 Fruit 物件
            Fruit fruit = a.getItem(pos);

            // 切換選擇狀態
            if (fruit != null)
                fruit.setSelected(!fruit.isSelected());

            // 設定切換選擇狀態的 Fruit 物件
            a.set(pos, fruit);

            txt_info.setText(fruit.getName() + "：" +
                    (fruit.isSelected() ? "selected":"unselected"));
        }
    }
}
