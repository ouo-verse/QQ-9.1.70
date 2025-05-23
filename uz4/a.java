package uz4;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class a extends RequestBody {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RequestBody f440692a;

    public a(RequestBody requestBody) {
        this.f440692a = requestBody;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return -1L;
    }

    @Override // okhttp3.RequestBody
    /* renamed from: contentType */
    public final MediaType getContentType() {
        return this.f440692a.getContentType();
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) {
        BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
        this.f440692a.writeTo(buffer);
        buffer.close();
    }
}
