package com.vogella.android.retrofitstackoverflow;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Sifat on 2/6/2016.
 */
public class MainActivity extends Activity implements Callback<List<WordpressMedia>> {
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

//        StackOverFlowAPI stackOverFlowAPI = retrofit.create(StackOverFlowAPI.class);
//        Call<StackOverFlowQuestions> call = stackOverFlowAPI.loadQuestions("android");
//        call.enqueue(this);

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("http://sifatsultan.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WordPressAPI wordPressAPI = retrofit2.create(WordPressAPI.class);
        Call<List<WordpressMedia>> call1 = wordPressAPI.loadMedia();
        call1.enqueue(this);

//        StackOverFlowAPI stackOverFlowAPI = retrofit.create(StackOverFlowAPI.class);
//        Call<StackOverFlowQuestions> call = stackOverFlowAPI.loadQuestions("android");
//        call.enqueue(this);

    }
//
//    @Override
//    public void onResponse(Response<StackOverFlowQuestions> response, Retrofit retrofit) {
//        listView.setAdapter(new MyListAdapter(this,response.body().items));
//    }

    @Override
    public void onResponse(Response<List<WordpressMedia>> response, Retrofit retrofit) {
        listView.setAdapter(new WPMediaAdapter(this,response.body()));
//        Toast.makeText(MainActivity.this, response.body().postTitle.toString(), Toast.LENGTH_SHORT).show();
//        listView.setAdapter(new );

    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();

    }
}
