package wadamasaya.recycleviewsample;


import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ScrollListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.toolbarLayout);
        toolbarLayout.setTitle(getString(R.string.toolbar_title));
        toolbarLayout.setExpandedTitleColor(Color.WHITE);
        toolbarLayout.setCollapsedTitleTextColor(Color.LTGRAY);

        RecyclerView lvMenu = findViewById(R.id.lvMenu);
        LinearLayoutManager layout = new LinearLayoutManager(ScrollListActivity.this);
        lvMenu.setLayoutManager(layout);
        List<Map<String, Object>> menuList = createTeishokuList();
        RecyclerListAdapter adapter = new RecyclerListAdapter(menuList);
        lvMenu.setAdapter(adapter);
        DividerItemDecoration decorator = new DividerItemDecoration(ScrollListActivity.this, layout.getOrientation());
        lvMenu.addItemDecoration(decorator);

    }

    private List<Map<String, Object>> createTeishokuList() {
        List<Map<String, Object>> menuList = new ArrayList<>();

        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "から揚げ定食");
        menu.put("price", 800);
        menu.put("desc", "若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", 850);
        menu.put("desc", "ハンバーグ定食にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", 850);
        menu.put("desc", "生姜焼き定食にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", 1000);
        menu.put("desc", "ステーキ定食にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", 750);
        menu.put("desc", "野菜炒め定食にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", 900);
        menu.put("desc", "とんかつ定食にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ミンチカツ定食");
        menu.put("price", 850);
        menu.put("desc", "ミンチカツ定食にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", 900);
        menu.put("desc", "チキンカツ定食にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", 850);
        menu.put("desc", "コロッケ定食にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼き魚定食");
        menu.put("price", 800);
        menu.put("desc", "焼き魚定食にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼肉定食");
        menu.put("price", 1000);
        menu.put("desc", "焼肉定食にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        return menuList;

    }

    private List<Map<String, Object>> createCurryList() {
        List<Map<String, Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "ビーフカレー");
        menu.put("price", 520);
        menu.put("desc", "特選スパイスをきかせた国産ビーフ100％のカレーです。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "ポークカレー");
        menu.put("price", "特選スパイスをきかせた国産ポーク100％のカレーです。");
        menuList.add(menu);

        return menuList;
    }


    private class RecyclerListViewHolder extends RecyclerView.ViewHolder {

        public TextView _tvMenuName;

        public TextView _tvMenuPrice;

        public RecyclerListViewHolder(View itemView) {
            super(itemView);
            _tvMenuName = itemView.findViewById(R.id.tvMenuName);
            _tvMenuPrice = itemView.findViewById(R.id.tvMenuPrice);
        }
    }

    private class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListViewHolder> {

        private List<Map<String, Object>> _listData;

        public RecyclerListAdapter(List<Map<String, Object>> listData) {
            _listData = listData;
        }

        @Override
        public RecyclerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(ScrollListActivity.this);
            View view = inflater.inflate(R.layout.row, parent, false);
            view.setOnClickListener(new ItemClickListener());
            RecyclerListViewHolder holder = new RecyclerListViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerListViewHolder holder, int position) {
            Map<String, Object> item = _listData.get(position);
            String menuName = (String) item.get("name");
            int menuPrice = (Integer) item.get("price");
            String menuPriceStr = String.valueOf(menuPrice);
            holder._tvMenuName.setText(menuName);
            holder._tvMenuPrice.setText(menuPriceStr);
        }

        @Override
        public int getItemCount() {
            return _listData.size();
        }
    }

    private class ItemClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            TextView tvMenuName =  view.findViewById(R.id.tvMenuName);
            String menuName = tvMenuName.getText().toString();
            String msg = getString(R.string.msg_header) + menuName;
            Toast.makeText(ScrollListActivity.this, msg, Toast.LENGTH_SHORT).show();
        }

    }

}