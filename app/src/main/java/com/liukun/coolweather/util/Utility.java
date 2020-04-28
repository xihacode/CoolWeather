package com.liukun.coolweather.util;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.liukun.coolweather.db.City;
import com.liukun.coolweather.db.County;
import com.liukun.coolweather.db.Province;
import com.liukun.coolweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Author: liukun on 2020/4/27.
 * Mail  : 3266817262@qq.com
 * Description: 解析处理json数据 并将各地区信息存入数据库
 */
public class Utility {

    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
//            List<Province> provinceList = new Gson().fromJson(response, new TypeToken<List<Province>>(){}.getType());
//            for (int i = 0; i < provinceList.size(); i++) {
//                Province province =  provinceList.get(i);
//                Log.d("Utility_name1",province.getName()+"");
//                Log.d("Utility_code2",province.getId()+"");
////            }
//            for (Province provinces : provinceList) {
//                Log.d("Utility_name",provinces.getProvinceName()+"");
//                Log.d("Utility_code",provinces.getProvinceCode()+"");
//                Province province = new Province();
//                province.setProvinceName(provinces.getProvinceName());
//                province.setProvinceCode(provinces.getProvinceCode());
////                province.save();
//            }
            try {
                JSONArray array = new JSONArray(response);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(jsonObject.getString("name"));
                    province.setProvinceCode(jsonObject.getInt("id"));
                    province.save();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }

        return false;
    }

    public static boolean handleCityResponse(String response, int provinceId) {

        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray array = new JSONArray(response);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    City province = new City();
                    province.setCityName(jsonObject.getString("name"));
                    province.setCityCode(jsonObject.getInt("id"));
                    province.setProvinceId(provinceId);
                    province.save();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }

        return false;
    }

    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray array = new JSONArray(response);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    County province = new County();
                    province.setCountyName(jsonObject.getString("name"));
                    province.setWeatherId(jsonObject.getString("weather_id"));
                    province.setCityId(cityId);
                    province.save();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Weather handleWeatherResponse(String response) {
        return new Gson().fromJson(response, new TypeToken<Weather>() {
        }.getType());
    }
}
