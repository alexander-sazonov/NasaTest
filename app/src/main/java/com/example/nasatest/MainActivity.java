package com.example.nasatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nasatest.model.NasaPhoto;
import com.example.nasatest.network.NasaApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private Button getBtn;
    private NasaApi api;
    private final String API_KEY = "Ff2Hx4BpzXVz01PYLT712y8tCmfgHPcYgSDkfytl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = NasaApp.getApi();
        image = findViewById(R.id.image);
        getBtn = findViewById(R.id.get_data_btn);
        getBtn.setOnClickListener(view -> {
            api.getPhoto(API_KEY).enqueue(new Callback<NasaPhoto>() {
                @Override
                public void onResponse(Call<NasaPhoto> call, Response<NasaPhoto> response) {
                    NasaPhoto photo = response.body();
                    Toast.makeText(getApplicationContext(),"Success" + photo.getUrl(),
                            Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<NasaPhoto> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Failure",
                            Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}