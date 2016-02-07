package com.vogella.android.retrofitstackoverflow;

import android.app.Activity;
import android.os.Bundle;
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
//        Question question = response.body().items.get(1);
        listView.setAdapter(new MyListAdapter(this,response.body().items));

    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();

    }
}
