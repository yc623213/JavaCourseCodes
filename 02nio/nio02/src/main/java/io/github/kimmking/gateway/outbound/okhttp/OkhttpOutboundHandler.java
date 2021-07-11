package io.github.kimmking.gateway.outbound.okhttp;

import cn.hutool.json.JSONUtil;
import okhttp3.*;

import java.io.IOException;

public class OkhttpOutboundHandler {
    private OkHttpClient okHttpClient = new OkHttpClient();

    public String base_url = "http://localhost:8801";

    /**
     * get 请求，常用于获取请求
     *
     * @param api
     */
    public void testGet(String api) throws IOException {
        Request request = new Request.Builder()
                .url(base_url + api)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().toString());

    }

    /**
     * put 请求,常用于更新请求
     *
     * @param api
     */
    public void testPut(String api) throws IOException {
        TestModel testModel = new TestModel();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                JSONUtil.toJsonStr(testModel));
        Request request = new Request.Builder()
                .url(base_url + api)
                .put(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().toString());
    }

    /**
     * POST 请求,常用于新增或复杂的获取请求
     *
     * @param api
     */
    public void testPost(String api) throws IOException {
        TestModel testModel = new TestModel();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                JSONUtil.toJsonStr(testModel));
        Request request = new Request.Builder()
                .url(base_url + api)
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().toString());
    }

    /**
     * DELETE 请求,常用于删除请求
     *
     * @param api
     */
    public void testDelete(String api) throws IOException {
        Request request = new Request.Builder()
                .url(base_url + api)
                .delete()
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().toString());
    }

    private class TestModel {
        private Integer testVo;
    }

}
