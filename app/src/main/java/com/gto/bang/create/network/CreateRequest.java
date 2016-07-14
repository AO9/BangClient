package com.gto.bang.create.network;

import android.content.Context;

import com.android.volley.Response;
import com.gto.bang.util.Constant;
import com.gto.bang.util.request.Gson4MapRequest;

import java.util.Map;

/**
 * Created by shenjialong on 16/7/11 21:20.
 */
public class CreateRequest {

    public static final String 	 AJAX = "create.ajax?";

    public static class Request extends Gson4MapRequest {
        public Request(Context context,
                                Response.Listener<Map<String, Object>> listener,
                                Response.ErrorListener errorListener,String params) {

            super(context, Constant.URL_BASE+AJAX+params, null, listener,
                    errorListener);
        }
    }
}
