package com.lin.a3gmgame.utils;

import com.lin.a3gmgame.models.News;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by my on 2016/7/8.
 */
public class JsonUtils {

    public static List<News> getList(String Json,int j){
        List<News> list = null;
        try {
            JSONObject root = new JSONObject(Json);
            JSONObject data = root.getJSONObject("data");
           for (int i=0;i<j;i++){
               JSONObject object = data.getJSONObject(i+"");
               News news = new News();
               String id = object.getString("id");
               String typeid = object.getString("typeid");
               String typeid2 = object.getString("typeid2");
               String sortrank = object.getString("sortrank");
//               String flag = object.getString("flag");
               String ismake = object.getString("ismake");
               String channel = object.getString("channel");
               String arcrank = object.getString("arcrank");
               String click = object.getString("click");
               String money = object.getString("money");
               String title = object.getString("title");
               String shorttitle = object.getString("shorttitle");
//               String color = object.getString("color");
               String writer = object.getString("writer");
               String source = object.getString("source");
               String litpic = "http://www.3dmgame.com" + object.getString("litpic");//加上网址前缀。
               String pubdate = object.getString("pubdate");
               String senddate = object.getString("senddate");
               String mid = object.getString("mid");
               String keywords = object.getString("keywords");
               String lastpost = object.getString("lastpost");
               String scores = object.getString("scores");
               String goodpost = object.getString("goodpost");
               String badpost = object.getString("badpost");
               String voteid = object.getString("voteid");
               String notpost = object.getString("notpost");
               String description = object.getString("description");
//               String filename = object.getString("filename");
               String dutyadmin = object.getString("dutyadmin");
               String tackid = object.getString("tackid");
               String mtype = object.getString("mtype");
               String weight = object.getString("weight");
               String fby_id = object.getString("fby_id");
               String game_id = object.getString("game_id");
               String feedback = object.getString("feedback");
               String typedir = object.getString("typedir");
               String typename = object.getString("typename");
               String corank = object.getString("corank");
               String isdefault = object.getString("isdefault");
               String defaultname = object.getString("defaultname");
               String namerule = object.getString("namerule");
               String namerule2 = object.getString("namerule2");
               String ispart = object.getString("ispart");
               String moresite = object.getString("moresite");
//               String siteurl = object.getString("siteurl");
               String sitepath = object.getString("sitepath");
               String arcurl = object.getString("arcurl");
               String typeurl = object.getString("typeurl");


           }





        } catch (Exception e) {
            e.printStackTrace();
        }


        return list;
    }


}
