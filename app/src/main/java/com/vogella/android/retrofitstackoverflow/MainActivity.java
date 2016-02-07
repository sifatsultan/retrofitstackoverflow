package com.vogella.android.retrofitstackoverflow;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Sifat on 2/6/2016.
 */
public class MainActivity extends Activity implements Callback<StackOverFlowQuestions> {
    ListView listView;
    MyListAdapter myListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        Button button = (Button)findViewById(R.id.button_load);
   }

    public void load(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StackOverFlowAPI stackOverFlowAPI = retrofit.create(StackOverFlowAPI.class);
        Call<StackOverFlowQuestions> call = stackOverFlowAPI.loadQuestions("android");
        call.enqueue(this);
    }

    @Override
    public void onResponse(Response<StackOverFlowQuestions> response, Retrofit retrofit) {

        try {
            Toast.makeText(MainActivity.this, "second q item "+response.body().items.get(1).creation_date, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this,"error: "+e.toString(),Toast.LENGTH_LONG).show();
            Log.v("response", "uncessful");
        }

//        myListAdapter = new MyListAdapter(this, response.body().questions);
//        listView.setAdapter(myListAdapter);
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();

    }
}
