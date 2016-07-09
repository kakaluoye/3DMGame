package com.lin.a3gmgame.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.lin.a3gmgame.cache.CacheManager;
import com.lin.a3gmgame.cache.FileCache;
import com.lin.a3gmgame.cache.MemoryCache;
import com.lin.a3gmgame.cache.WebCache;

public class DownLoadService extends Service {
    //需要请求的数据的网页很多，用一个数组来存放。
    private String[] urlPaths = {"http://www.3dmgame.com/sitemap/api.php?row=10&typeid=181&paging=1&page=1",
            "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=182&paging=1&page=1",
            "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=183&paging=1&page=1",
            "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=184&paging=1&page=1",
            "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=2&paging=1&page=1",
            "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=151&paging=1&page=1",
            "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=152&paging=1&page=1",
            "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=153&paging=1&page=1",
            "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=154&paging=1&page=1",
            "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=196&paging=1&page=1",
            "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=197&paging=1&page=1",
            "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=199&paging=1&page=1",
            "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=25&paging=1&page=1"};
    private MemoryCache memoryCache;
    private FileCache fileCache;
    private WebCache webCache;
    private CacheManager cacheManager;

    @Override
    public void onCreate() {
        super.onCreate();
        memoryCache = new MemoryCache();
        fileCache = new FileCache();
        webCache = new WebCache();
        cacheManager = new CacheManager();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("aaa", "service,线程下载数据");
        //service的onStartCommand方法里进行数据的加载等耗时操作。需要在子线程里。
        // 数据的加载用三级缓存，web,file,cache。且图片要压缩后再保存，不然东西太多太大。
        download(urlPaths[0]);
        download(urlPaths[1]);
        download(urlPaths[2]);
        download(urlPaths[3]);
        download(urlPaths[4]);
        download(urlPaths[5]);
        download(urlPaths[6]);
        download(urlPaths[7]);
        download(urlPaths[8]);
        download(urlPaths[9]);
        download(urlPaths[10]);
        download(urlPaths[11]);
        download(urlPaths[12]);
        return START_REDELIVER_INTENT;//重复投递……………………………………
    }

    public void download(final String urlPath) {
        //图片压缩后保存到三级缓存，所有的信息加入数据库。
        //先别慌着加入数据库，加入数据库的图片地址换成缓存的sd卡的地址，
        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] b = webCache.getNetInfo(urlPath);
                if (b==null){
                    return;
                }




            }
        }).start();

    }


}
