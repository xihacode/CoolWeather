package com.liukun.coolweather.gson;

import java.util.List;

/**
 * Author: liukun on 2020/4/29.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public class Weather {

    private List<HeWeatherEntity> HeWeather;

    public List<HeWeatherEntity> getHeWeather() {
        return HeWeather;
    }

    public void setHeWeather(List<HeWeatherEntity> HeWeather) {
        this.HeWeather = HeWeather;
    }

    public static class HeWeatherEntity {
        /**
         * basic : {"cid":"CN101190408","location":"太仓","parent_city":"苏州","admin_area":"江苏","cnty":"中国","lat":"30.5843544","lon":"114.29856873","tz":"+8.00","city":"太仓","id":"CN101190408","update":{"loc":"2020-04-29 05:53","utc":"2020-04-28 21:53"}}
         * update : {"loc":"2020-04-29 05:53","utc":"2020-04-28 21:53"}
         * status : ok
         * now : {"cloud":"91","cond_code":"101","cond_txt":"多云","fl":"21","hum":"68","pcpn":"0.0","pres":"1012","tmp":"21","vis":"16","wind_deg":"281","wind_dir":"西北风","wind_sc":"2","wind_spd":"8","cond":{"code":"101","txt":"多云"}}
         * daily_forecast : [{"date":"2020-04-30","cond":{"txt_d":"多云"},"tmp":{"max":"22","min":"10"}},{"date":"2020-05-01","cond":{"txt_d":"小雨"},"tmp":{"max":"18","min":"8"}},{"date":"2020-05-02","cond":{"txt_d":"多云"},"tmp":{"max":"19","min":"6"}},{"date":"2020-05-03","cond":{"txt_d":"雷阵雨"},"tmp":{"max":"16","min":"10"}},{"date":"2020-05-04","cond":{"txt_d":"小雨"},"tmp":{"max":"18","min":"10"}},{"date":"2020-05-05","cond":{"txt_d":"多云"},"tmp":{"max":"17","min":"8"}}]
         * aqi : {"city":{"aqi":"83","pm25":"61","qlty":"良"}}
         * suggestion : {"comf":{"type":"comf","brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"},"sport":{"type":"sport","brf":"较适宜","txt":"天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。"},"cw":{"type":"cw","brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}}
         * msg : 所有天气数据均为模拟数据，仅用作学习目的使用，请勿当作真实的天气预报软件来使用。
         */

        private BasicEntity basic;
        private UpdateEntityX update;
        private String status;
        private NowEntity now;
        private AqiEntity aqi;
        private SuggestionEntity suggestion;
        private String msg;
        private List<DailyForecastEntity> daily_forecast;

        public BasicEntity getBasic() {
            return basic;
        }

        public void setBasic(BasicEntity basic) {
            this.basic = basic;
        }

        public UpdateEntityX getUpdate() {
            return update;
        }

        public void setUpdate(UpdateEntityX update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public NowEntity getNow() {
            return now;
        }

        public void setNow(NowEntity now) {
            this.now = now;
        }

        public AqiEntity getAqi() {
            return aqi;
        }

        public void setAqi(AqiEntity aqi) {
            this.aqi = aqi;
        }

        public SuggestionEntity getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(SuggestionEntity suggestion) {
            this.suggestion = suggestion;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<DailyForecastEntity> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastEntity> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public static class BasicEntity {
            /**
             * cid : CN101190408
             * location : 太仓
             * parent_city : 苏州
             * admin_area : 江苏
             * cnty : 中国
             * lat : 30.5843544
             * lon : 114.29856873
             * tz : +8.00
             * city : 太仓
             * id : CN101190408
             * update : {"loc":"2020-04-29 05:53","utc":"2020-04-28 21:53"}
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;
            private String city;
            private String id;
            private UpdateEntity update;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public UpdateEntity getUpdate() {
                return update;
            }

            public void setUpdate(UpdateEntity update) {
                this.update = update;
            }

            public static class UpdateEntity {
                /**
                 * loc : 2020-04-29 05:53
                 * utc : 2020-04-28 21:53
                 */

                private String loc;
                private String utc;

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public String getUtc() {
                    return utc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }
            }
        }

        public static class UpdateEntityX {
            /**
             * loc : 2020-04-29 05:53
             * utc : 2020-04-28 21:53
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class NowEntity {
            /**
             * cloud : 91
             * cond_code : 101
             * cond_txt : 多云
             * fl : 21
             * hum : 68
             * pcpn : 0.0
             * pres : 1012
             * tmp : 21
             * vis : 16
             * wind_deg : 281
             * wind_dir : 西北风
             * wind_sc : 2
             * wind_spd : 8
             * cond : {"code":"101","txt":"多云"}
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;
            private CondEntity cond;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }

            public CondEntity getCond() {
                return cond;
            }

            public void setCond(CondEntity cond) {
                this.cond = cond;
            }

            public static class CondEntity {
                /**
                 * code : 101
                 * txt : 多云
                 */

                private String code;
                private String txt;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class AqiEntity {
            /**
             * city : {"aqi":"83","pm25":"61","qlty":"良"}
             */

            private CityEntity city;

            public CityEntity getCity() {
                return city;
            }

            public void setCity(CityEntity city) {
                this.city = city;
            }

            public static class CityEntity {
                /**
                 * aqi : 83
                 * pm25 : 61
                 * qlty : 良
                 */

                private String aqi;
                private String pm25;
                private String qlty;

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getQlty() {
                    return qlty;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }
            }
        }

        public static class SuggestionEntity {
            /**
             * comf : {"type":"comf","brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"}
             * sport : {"type":"sport","brf":"较适宜","txt":"天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。"}
             * cw : {"type":"cw","brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
             */

            private ComfEntity comf;
            private SportEntity sport;
            private CwEntity cw;

            public ComfEntity getComf() {
                return comf;
            }

            public void setComf(ComfEntity comf) {
                this.comf = comf;
            }

            public SportEntity getSport() {
                return sport;
            }

            public void setSport(SportEntity sport) {
                this.sport = sport;
            }

            public CwEntity getCw() {
                return cw;
            }

            public void setCw(CwEntity cw) {
                this.cw = cw;
            }

            public static class ComfEntity {
                /**
                 * type : comf
                 * brf : 舒适
                 * txt : 白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。
                 */

                private String type;
                private String brf;
                private String txt;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class SportEntity {
                /**
                 * type : sport
                 * brf : 较适宜
                 * txt : 天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。
                 */

                private String type;
                private String brf;
                private String txt;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class CwEntity {
                /**
                 * type : cw
                 * brf : 较适宜
                 * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
                 */

                private String type;
                private String brf;
                private String txt;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class DailyForecastEntity {
            /**
             * date : 2020-04-30
             * cond : {"txt_d":"多云"}
             * tmp : {"max":"22","min":"10"}
             */

            private String date;
            private CondEntityX cond;
            private TmpEntity tmp;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public CondEntityX getCond() {
                return cond;
            }

            public void setCond(CondEntityX cond) {
                this.cond = cond;
            }

            public TmpEntity getTmp() {
                return tmp;
            }

            public void setTmp(TmpEntity tmp) {
                this.tmp = tmp;
            }

            public static class CondEntityX {
                /**
                 * txt_d : 多云
                 */

                private String txt_d;

                public String getTxt_d() {
                    return txt_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }
            }

            public static class TmpEntity {
                /**
                 * max : 22
                 * min : 10
                 */

                private String max;
                private String min;

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }
        }
    }
}
