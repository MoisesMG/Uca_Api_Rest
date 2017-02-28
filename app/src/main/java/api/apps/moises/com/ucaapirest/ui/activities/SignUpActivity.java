package api.apps.moises.com.ucaapirest.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import api.apps.moises.com.ucaapirest.R;
import api.apps.moises.com.ucaapirest.api.Api;
import api.apps.moises.com.ucaapirest.models.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "SignUpActivity";
    private EditText email;
    private EditText password;
    private Button signUp;
    private Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initview();
    }//fin del method

    private boolean validate(){
        boolean success = false;
        if(email.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), getString(R.string.email_required), Toast.LENGTH_SHORT).show();
        }else{
            if(password.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), getString(R.string.password_requered), Toast.LENGTH_SHORT).show();
            }else{
                success=true;
            }
        }
        return success;
    }//fin del metodo

    private void signUp(){
        if(validate()){
            //intance user
            UserModel userModel = new UserModel();
            userModel.setEmail(email.getText().toString());
            userModel.setPassword(email.getText().toString());

            //make http request
            Call<UserModel> call = Api.instance().signup(userModel);
            call.enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    if(response != null){
                        Log.i(TAG, response.body().getEmail());
                    }else {
                        Log.i("TAG", "error en la peticion");
                    }
                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {
                    Log.e(TAG, t.getMessage());
                }
            });
        }
    }//fin del metodo

    private void initview(){
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signUp = (Button) findViewById(R.id.signup);
        signIn = (Button) findViewById(R.id.signin);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }//fin del metodo
}//end of class
