package com.liukun.coolweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.liukun.coolweather.gson.Weather;
import com.liukun.coolweather.util.HttpUtil;
import com.liukun.coolweather.util.Utility;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class WeatherActivity extends AppCompatActivity {
    private ScrollView weatherLayout;
    private TextView titleCity;
    private TextView titleUpdateTime;
    private TextView degreeText;
    private TextView weatherInfoText;
    private LinearLayout forecastLayout;
    private TextView apiText;
    private TextView pm25Text;
    private TextView comfortText;
    private TextView cartWashText;
    private TextView sportText;
    private ImageView bingPicImg;
    public SwipeRefreshLayout mRefreshLayout;
    public DrawerLayout mDrawerLayout;
    private Button navButton;
    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_weather);
        weatherLayout = (ScrollView) findViewById(R.id.weather_layout);
        titleCity = (TextView) findViewById(R.id.title_city);
        titleUpdateTime = (TextView) findViewById(R.id.title_update_city);
        degreeText = (TextView) findViewById(R.id.degree_text);
        weatherInfoText = (TextView) findViewById(R.id.weather_info_text);
        forecastLayout = (LinearLayout) findViewById(R.id.forecast_layout);
        apiText = (TextView) findViewById(R.id.api_text);
        pm25Text = (TextView) findViewById(R.id.pm25_text);
        comfortText = (TextView) findViewById(R.id.comfort_text);
        cartWashText = (TextView) findViewById(R.id.car_wash_text);
        sportText = (TextView) findViewById(R.id.sport_text);
        bingPicImg = (ImageView) findViewById(R.id.bing_pic_img);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navButton = (Button) findViewById(R.id.nav_button);


        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setRefreshing(true);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = preferences.getString("weather", null);
        String pic = preferences.getString("bing_pic", null);
        if (pic != null) {
            Glide.with(this).load(pic).into(bingPicImg);
        } else {
            loadBingPic();
        }
        final String weatherId;
        if (weatherString != null) {
            Log.d(TAG, "onCreate: " + weatherString);
            Weather weather = Utility.handleWeatherResponse(weatherString);
            weatherId = weather.getHeWeather().get(0).getBasic().getId();
            showWeatherInfo(weather.getHeWeather().get(0));
        } else {
            weatherId = getIntent().getStringExtra("weather_id");
            weatherLayout.setVisibility(View.INVISIBLE);
            requestWeather(weatherId);
        }
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestWeather(weatherId);
            }
        });

    }

    public void requestWeather(String weatherId) {
        String weatherUrl = "http://guolin.tech/api/weather?cityid=" + weatherId +
                "&key=d49ad74fb9064209928545d8605ffeae";
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this, "获取天气信息失败!",
                                Toast.LENGTH_LONG).show();
                        mRefreshLayout.setRefreshing(false);
                    }
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String responseText = response.body().string();
                final Weather weather = Utility.handleWeatherResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (Weather.HeWeatherEntity weatherEntity : weather.getHeWeather()) {
                            if (weatherEntity != null & "ok".equals(weatherEntity.getStatus())) {
                                SharedPreferences.Editor editor = PreferenceManager
                                        .getDefaultSharedPreferences(WeatherActivity.this)
                                        .edit();
                                editor.putString("weather_id", responseText);
                                editor.apply();
                                showWeatherInfo(weatherEntity);
                            } else {
                                Toast.makeText(WeatherActivity.this, "获取天气信息失败!",
                                        Toast.LENGTH_LONG).show();
                            }
                            mRefreshLayout.setRefreshing(false);
                        }
                    }

                });
            }
        });
        loadBingPic();

    }

    /**
     * 展示数据
     *
     * @param weatherEntity
     */
    private void showWeatherInfo(Weather.HeWeatherEntity weatherEntity) {
        mRefreshLayout.setRefreshing(false);
        String cityName = weatherEntity.getBasic().getCity();
        String updateTime = weatherEntity.getBasic().getUpdate().getLoc();
        String degree = weatherEntity.getNow().getTmp() + "摄氏度";
        String weatherInfo = weatherEntity.getNow().getCond_txt();
        titleCity.setText(cityName);
        titleUpdateTime.setText(updateTime);
        degreeText.setText(degree);
        weatherInfoText.setText(weatherInfo);
        forecastLayout.removeAllViews();

        for (Weather.HeWeatherEntity.DailyForecastEntity forecastEntity
                : weatherEntity.getDaily_forecast()) {
            View view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecastLayout, false);
            //TODO 添加未来天气的控件
            TextView dateText = (TextView) view.findViewById(R.id.data_text);
            TextView infoText = (TextView) view.findViewById(R.id.info_text);
            TextView maxText = (TextView) view.findViewById(R.id.max_text);
            TextView minText = (TextView) view.findViewById(R.id.min_text);
            dateText.setText(forecastEntity.getDate());
            infoText.setText(forecastEntity.getCond().getTxt_d());
            maxText.setText(forecastEntity.getTmp().getMax());
            minText.setText(forecastEntity.getTmp().getMin());
            forecastLayout.addView(view);
        }
        if (weatherEntity.getAqi() != null) {
            apiText.setText(weatherEntity.getAqi().getCity().getAqi());
            pm25Text.setText(weatherEntity.getAqi().getCity().getPm25());
        }
        String comfort = "舒适度：" + weatherEntity.getSuggestion().getComf().getTxt();
        String carWash = "洗车指数：" + weatherEntity.getSuggestion().getCw().getTxt();
        String sport = "运动建议：" + weatherEntity.getSuggestion().getSport().getTxt();
        comfortText.setText(comfort);
        cartWashText.setText(carWash);
        sportText.setText(sport);
        weatherLayout.setVisibility(View.VISIBLE);
    }

    private void loadBingPic() {
        String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String bingPic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager
                        .getDefaultSharedPreferences(WeatherActivity.this).edit();
                editor.putString("bing_pic", bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run: " + bingPic);
                        Glide.with(WeatherActivity.this).load(bingPic).into(bingPicImg);
                    }
                });

            }
        });
    }
}
