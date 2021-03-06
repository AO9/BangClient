package com.gto.bang.util;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.gto.bang.util.request.CacheTask;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wjying on 13-12-22.
 */
public class SimpleDiskCacheUtils {
    private static final int DISK_CACHE_SIZE = 1024 * 1024 * 50; // 10MB
    private static final String DISK_CACHE_DIR = "bangbang_cache";

    private static SimpleDiskCache sSimpleDiskCache;
    private static Map<String, CacheTask> sCacheTasks = new HashMap<String, CacheTask>();

    private static final Object sLockObject=new Object();
    public static SimpleDiskCache getSimpleDiskCache(Context context) {
        synchronized (sLockObject) {
            if (sSimpleDiskCache == null) {
                File cacheDir = new File(context.getExternalCacheDir(), DISK_CACHE_DIR);
                int version = PackageUtils.getAppVersionCode(context);
                try {
                    sSimpleDiskCache = SimpleDiskCache.open(cacheDir, version, DISK_CACHE_SIZE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return sSimpleDiskCache;
    }
    public static void postCacheTask(String key, CacheTask task) {
        if (TextUtils.isEmpty(key) || task == null) {
            return;
        }
        CacheTask old = sCacheTasks.get(key);
        if (old != null) {
            old.cancel(true);
        }
        sCacheTasks.put(key, task);
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    public static void removeCacheTask(String key) {
        if (TextUtils.isEmpty(key)) {
            return;
        }
        CacheTask old = sCacheTasks.remove(key);
        if (old != null) {
            old.cancel(true);
        }
    }

    public static boolean isCacheTaskRunning(String key) {
        if (TextUtils.isEmpty(key)) {
            return false;
        }
        CacheTask old = sCacheTasks.remove(key);
        if (old == null) {
            return false;
        }

        return old.getStatus() != AsyncTask.Status.FINISHED;
    }

}
