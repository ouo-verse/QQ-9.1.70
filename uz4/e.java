package uz4;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class e<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final tz4.a f440697a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f440698b = true;

    public e(tz4.a aVar) {
        this.f440697a = aVar;
    }

    @Override // uz4.c
    public final f a(ArrayList arrayList) {
        int i3;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://spider-tracker.xiaohongshu.com/api/spider").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream; charset=utf-8");
            if (this.f440698b) {
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            }
            httpURLConnection.connect();
            try {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                if (this.f440698b) {
                    outputStream = new GZIPOutputStream(outputStream);
                }
                this.f440697a.getClass();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    byteArrayOutputStream.write((byte[]) it.next());
                }
                outputStream.write(byteArrayOutputStream.toByteArray());
                outputStream.flush();
                outputStream.close();
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    String responseMessage = httpURLConnection.getResponseMessage();
                    httpURLConnection.disconnect();
                    f fVar = new f();
                    if (responseCode >= 200 && responseCode < 300) {
                        fVar.f440699a = true;
                    } else {
                        fVar.f440699a = false;
                    }
                    fVar.f440700b = responseCode;
                    fVar.f440701c = responseMessage;
                    return fVar;
                } catch (Throwable th5) {
                    th = th5;
                    i3 = -1;
                    return f.a(i3, th);
                }
            } catch (Throwable th6) {
                th = th6;
                i3 = -2;
            }
        } catch (Throwable th7) {
            th = th7;
            i3 = -4;
        }
    }
}
