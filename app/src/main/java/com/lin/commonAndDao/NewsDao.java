package com.lin.commonAndDao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lin.a3gmgame.models.News;

/**
 * Created by my on 2016/7/9.
 */
public class NewsDao {
    //Dao   database access object  对数据库数据的访问层。

    private NewsSQliteOpenHelper sQliteOpenHelper;
    private Context context;

    public NewsDao(NewsSQliteOpenHelper sQliteOpenHelper, Context context) {
        this.sQliteOpenHelper = sQliteOpenHelper;
        this.context = context;
    }

    /**
     * 添加数据到数据库的News表中。news对象。
     */
    public synchronized void addNewsToSQliteTable(News news) {
        //添加数据，先判断数据库里面有没有这个数据，根据title属性是否相同来判断。
        SQLiteDatabase db = sQliteOpenHelper.getReadableDatabase();
        String newtitle = news.getTitle();
        Cursor cursor = getAllTitleCursor();
        //把要加入的作为是否唯一的title和已经存在的所有title进行比较。
        while (cursor.moveToNext()) {
            String title = cursor.getColumnName(cursor.getColumnIndex("title"));
//            String title = cursor.getColumnName(0); ………………………………………………
            if (title.equals(newtitle)) {
                return;//比较插入的title,一旦相同就返回。
            }
        }
        //进入到这里数据就是新的数据，要添加进数据库。
        ContentValues values = new ContentValues();
        values.put("id", news.getId());
        values.put("typeid", news.getTypeid());
        values.put("typeid2", news.getTypeid2());
        values.put("sortrank", news.getSortrank());
        values.put("ismake", news.getIsmake());
        values.put("channel", news.getChannel());
        values.put("arcrank", news.getArcrank());
        values.put("click", news.getClick());
        values.put("money", news.getMoney());
        values.put("title", news.getTitle());
        values.put("shorttitle", news.getShorttitle());
        values.put("writer", news.getWriter());
        values.put("source", news.getSource());
        values.put("litpic", news.getLitpic());//图片地址
        values.put("pubdate", news.getPubdate());
        values.put("senddate", news.getSenddate());
        values.put("mid", news.getMid());
        values.put("keywords", news.getKeywords());
        values.put("lastpost", news.getLastpost());
        values.put("scores", news.getScores());
        values.put("goodpost", news.getGoodpost());
        values.put("badpost", news.getBadpost());
        values.put("voteid", news.getVoteid());
        values.put("notpost", news.getNotpost());
        values.put("description", news.getDescription());
        values.put("dutyadmin", news.getDutyadmin());
        values.put("tackid", news.getTackid());
        values.put("mtype", news.getMtype());
        values.put("weight", news.getWeight());
        values.put("fby_id", news.getFby_id());
        values.put("game_id", news.getGame_id());
        values.put("feedback", news.getFeedback());
        values.put("typedir", news.getTypedir());
        values.put("typename", news.getTypename());
        values.put("corank", news.getCorank());
        values.put("isdefault", news.getIsdefault());
        values.put("defaultname", news.getDefaultname());
        values.put("namerule", news.getNamerule());
        values.put("namerule2", news.getNamerule2());
        values.put("ispart", news.getIspart());
        values.put("moresite", news.getMoresite());
        values.put("sitepath", news.getSitepath());
        values.put("typeurl", news.getTypeurl());
        values.put("arcurl", news.getArcurl());
        db.insert("news", null, values);
        //数据添加完，关闭数据库。
        if (db != null) {
            db.close();
        }
    }

    /**
     * 得到所有文章的Cursor      title
     */
    public Cursor getAllTitleCursor() {
        SQLiteDatabase db = sQliteOpenHelper.getReadableDatabase();
        Cursor cursor = db.query("news.db", new String[]{"title"}, null, null, null, null, null);
        return cursor;
    }

    /**
     * 分页显示数据的cursor
     */
    public Cursor getCursorPaging(int pageindex, int pagesize) {
        SQLiteDatabase db = sQliteOpenHelper.getReadableDatabase();
        Cursor cursor = db.query("news", null, null, null, null, null, (pageindex - 1) * pagesize + "," + pagesize);
        return cursor;
    }

    /**
     * 返回指定type的cursor
     */
    public Cursor getTypeCursor(int type, int pageindex, int pagesize) {
        SQLiteDatabase db = sQliteOpenHelper.getReadableDatabase();
        Cursor cursor = db.query("news", null, "type=?", new String[]{type + ""}, null, null, null, pagesize * (pageindex - 1) + "," + pagesize);
        return cursor;
    }
}
