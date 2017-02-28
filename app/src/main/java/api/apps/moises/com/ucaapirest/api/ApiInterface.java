package api.apps.moises.com.ucaapirest.api;

import java.util.List;

import api.apps.moises.com.ucaapirest.models.TweetModel;
import api.apps.moises.com.ucaapirest.models.UserModel;
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

    @POST("tweets")
    Call<TweetModel> setTweet(@Body TweetModel tweetModel);

    @POST("Users")
    Call<UserModel> signup(@Body UserModel userModel);
}//fin de la clase
