package com.gto.bang.util.request;

import android.content.Context;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.gto.bang.util.GsonUtils;

import java.util.Map;

public class Gson4MapRequest extends GsonRequest<Map<String, Object>>{

    /**
     *
     * @param context
     * @param url
     * @param headers
     * @param listener
     * @param errorListener
     */
    public Gson4MapRequest(Context context, String url, Map<String, String> headers, Response.Listener<Map<String, Object>> listener,
                           Response.ErrorListener errorListener,int method) {
        super(context, url, null, headers, listener, errorListener,method);
    }

    @Override
    protected Response<Map<String,Object>> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = getResponseStr(response);
            if (shouldCache()) {
//                SimpleDiskCacheUtils.getSimpleDiskCache(getContext()).put(getUrl(), json);
            }

            Map<String, Object> map = GsonUtils.getMap(getGson(), json);
            Log.i("sjl","response map:"+map+" json:"+json);
            return Response.success(map, HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        }
    }

}
