package api.apps.moises.com.ucaapirest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import api.apps.moises.com.ucaapirest.api.Api;
import api.apps.moises.com.ucaapirest.models.TweetModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        setData("Mi nombre es Moises. :)");
    }//fin del metodo

    private void setData(String text){
        TweetModel tweetModel = new TweetModel();
        tweetModel.setText(text);
        Call<TweetModel> call = Api.instance().setTweet(tweetModel);
        call.enqueue(new Callback<TweetModel>() {
            @Override
            public void onResponse(Call<TweetModel> call, Response<TweetModel> response) {
                if(response != null){
                    Log.i(TAG, response.body().getText());
                }else{
                    Log.i(TAG, "error en la peticion");
                }
            }//fin del metodo

            @Override
            public void onFailure(Call<TweetModel> call, Throwable throwable) {
                Log.e(TAG, throwable.getMessage());
            }//fin del metodo
        });
    }//fin del metodo

    private void getData(){
        Call<List<TweetModel>> call = Api.instance().getTweets();
        call.enqueue(new Callback<List<TweetModel>>() {
            @Override
            public void onResponse(Call<List<TweetModel>> call, Response<List<TweetModel>> response) {
                //valida si la respusta fue nula porque no habia tweets
                if(response != null){
                    for(TweetModel tweetModel: response.body()){
                        Log.d(TAG, tweetModel.getText());
                    }
                }else{
                    Log.d(TAG, "La respuesta es incorrecta");
                }
            }//fin del metodo

            @Override
            public void onFailure(Call<List<TweetModel>> call, Throwable throwable) {
                Log.d(TAG, throwable.getMessage());
            }
        });
    }//fin del metodo
}//fin de la clase
