package api.apps.moises.com.ucaapirest.api;

import java.util.List;

import api.apps.moises.com.ucaapirest.models.TweetModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by isi3 on 23/02/2017.
 */

public interface ApiInterface {
    @GET("tweets")
    Call<List <TweetModel>> getTweets();

    @POST("")
    Call<TweetModel> setTweet(@Body TweetModel tweetModel);
}//fin de la clase
