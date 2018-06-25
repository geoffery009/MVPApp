package com.aaa.mvpapp.model;

import com.aaa.mvpapp.http.Api;
import com.aaa.mvpapp.http.ApiService;
import com.aaa.mvpapp.http.DataSign;
import com.aaa.mvpapp.http.RSA;
import com.google.gson.Gson;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewModel<T> {
    private final ApiService apiService;
    private Retrofit retrofit;
    private Gson mGson;
    private T param;

    public ApiService getApiService() {
        return apiService;
    }

    public Gson getmGson() {
        return mGson;
    }

    public ViewModel() {
        mGson = new Gson();

        retrofit = new Retrofit.Builder()
                .baseUrl(Api.HTTP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public RequestBody getNetworkData(Callback callback) {
        //加密，加签
        String gsonStr = getmGson().toJson(param);
        String rsaData = RSA.encryptData(gsonStr);
        String rsaSign = RSA.generateSignature(rsaData);

        DataSign sign = new DataSign(rsaData, rsaSign);

        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), getmGson().toJson(sign));
    }

    /**
     * 解码 Unicode \\uXXXX
     *
     * @param str
     * @return
     */
    public static String decodeUnicode(String str) {
        Charset set = Charset.forName("UTF-16");
        Pattern p = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
        Matcher m = p.matcher(str);
        int start = 0;
        int start2 = 0;
        StringBuffer sb = new StringBuffer();
        while (m.find(start)) {
            start2 = m.start();
            if (start2 > start) {
                String seg = str.substring(start, start2);
                sb.append(seg);
            }
            String code = m.group(1);
            int i = Integer.valueOf(code, 16);
            byte[] bb = new byte[4];
            bb[0] = (byte) ((i >> 8) & 0xFF);
            bb[1] = (byte) (i & 0xFF);
            ByteBuffer b = ByteBuffer.wrap(bb);
            sb.append(String.valueOf(set.decode(b)).trim());
            start = m.end();
        }
        start2 = str.length();
        if (start2 > start) {
            String seg = str.substring(start, start2);
            sb.append(seg);
        }
        return sb.toString();
    }

}
