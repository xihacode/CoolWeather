package com.liukun.coolweather.db;

import org.litepal.crud.LitePalSupport;

/**
 * Author: liukun on 2020/4/27.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public class Province extends LitePalSupport {

    private  int id ;
    private String provinceName;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", provinceName='" + provinceName + '\'' +
                ", provinceCode=" + provinceCode +
                '}';
    }
}
