package x01;

import com.tencent.mobileqq.msf.core.auth.k;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lx01/a;", "Lokhttp3/ResponseBody;", "Lokhttp3/MediaType;", "contentType", "", "contentLength", "Lokio/BufferedSource;", "source", "d", "J", "totalBytesRead", "e", "startTime", "f", "Lokhttp3/ResponseBody;", "responseBody", "Ljava/net/InetAddress;", h.F, "Ljava/net/InetAddress;", "inetAddress", "<init>", "(Lokhttp3/ResponseBody;Ljava/net/InetAddress;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a extends ResponseBody {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long totalBytesRead;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ResponseBody responseBody;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final InetAddress inetAddress;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"x01/a$a", "Lokio/ForwardingSource;", "Lokio/Buffer;", "sink", "", "byteCount", k.f247491e, "libra-core_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: x01.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C11523a extends ForwardingSource {
        C11523a(Source source) {
            super(source);
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(@NotNull Buffer sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (a.this.startTime == 0) {
                a.this.startTime = System.nanoTime();
            }
            long read = super.read(sink, byteCount);
            if (read != -1) {
                a.this.totalBytesRead += read;
            } else {
                long micros = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - a.this.startTime);
                if (a.this.inetAddress != null) {
                    com.tencent.libra.download.b.f118670d.a(a.this.inetAddress, a.this.totalBytesRead, ((float) micros) / 1000000);
                }
            }
            return read;
        }
    }

    public a(@NotNull ResponseBody responseBody, @Nullable InetAddress inetAddress) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        this.responseBody = responseBody;
        this.inetAddress = inetAddress;
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentLength */
    public long getContentLength() {
        return this.responseBody.getContentLength();
    }

    @Override // okhttp3.ResponseBody
    @Nullable
    /* renamed from: contentType */
    public MediaType get$contentType() {
        return this.responseBody.get$contentType();
    }

    @Override // okhttp3.ResponseBody
    @NotNull
    /* renamed from: source */
    public BufferedSource getSource() {
        return Okio.buffer(new C11523a(this.responseBody.getSource()));
    }
}
