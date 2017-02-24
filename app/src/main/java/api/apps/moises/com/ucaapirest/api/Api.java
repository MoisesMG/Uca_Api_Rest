package api.apps.moises.com.ucaapirest.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by isi3 on 23/02/2017.
 */

public class Api {
    private final static String URL = "https://api-demo-uca.herokuapp.com/api";

    public static String getBase() {
        return URL + "/";
    }//fin del metodo

    public static ApiInterface instance(){
        Retrofit retrofit = new Retrofit.
                Builder().
                baseUrl(Api.getBase()).
                addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(ApiInterface.class);
    }
}//fin de la clase
