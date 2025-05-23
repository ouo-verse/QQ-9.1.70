package uz4;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class d<T> implements c<T> {

    /* renamed from: d, reason: collision with root package name */
    public static final MediaType f440693d = MediaType.get("application/octet-stream; charset=utf-8");

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f440694a;

    /* renamed from: b, reason: collision with root package name */
    public final String f440695b = "https://spider-tracker.xiaohongshu.com/";

    /* renamed from: c, reason: collision with root package name */
    public final tz4.a f440696c;

    public d(tz4.a aVar) {
        this.f440696c = aVar;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder writeTimeout = builder.connectTimeout(5000L, timeUnit).callTimeout(10000L, timeUnit).writeTimeout(5000L, timeUnit);
        writeTimeout.addInterceptor(new b());
        this.f440694a = writeTimeout.build();
    }

    @Override // uz4.c
    public final f a(ArrayList arrayList) {
        int i3;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            this.f440696c.getClass();
            byteArrayOutputStream = new ByteArrayOutputStream();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byteArrayOutputStream.write((byte[]) it.next());
            }
            try {
            } catch (Throwable th5) {
                th = th5;
                th.printStackTrace();
                i3 = -3;
            }
        } catch (Throwable th6) {
            th = th6;
            th.printStackTrace();
            i3 = -2;
        }
        try {
            Response response = null;
            try {
                response = this.f440694a.newCall(new Request.Builder().url(this.f440695b + "api/spider").post(RequestBody.create(f440693d, byteArrayOutputStream.toByteArray())).build()).execute();
                response.close();
                int code = response.code();
                String message = response.message();
                f fVar = new f();
                if (code >= 200 && code < 300) {
                    fVar.f440699a = true;
                } else {
                    fVar.f440699a = false;
                }
                fVar.f440700b = code;
                fVar.f440701c = message;
                try {
                    response.close();
                } catch (Exception unused) {
                }
                return fVar;
            } catch (Throwable th7) {
                try {
                    th7.printStackTrace();
                    f a16 = f.a(-1, th7);
                    if (response != null) {
                        try {
                            response.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return a16;
                } catch (Throwable th8) {
                    if (response != null) {
                        try {
                            response.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th8;
                }
            }
        } catch (Throwable th9) {
            th = th9;
            th.printStackTrace();
            i3 = -4;
            return f.a(i3, th);
        }
    }
}
