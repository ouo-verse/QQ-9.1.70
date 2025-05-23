package retrofit2;

import com.tencent.mobileqq.text.EmotcationConstants;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: P */
/* loaded from: classes29.dex */
final class z {

    /* renamed from: l, reason: collision with root package name */
    private static final char[] f431364l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f431365m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a, reason: collision with root package name */
    private final String f431366a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpUrl f431367b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private String f431368c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private HttpUrl.Builder f431369d;

    /* renamed from: e, reason: collision with root package name */
    private final Request.Builder f431370e = new Request.Builder();

    /* renamed from: f, reason: collision with root package name */
    private final Headers.Builder f431371f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private MediaType f431372g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f431373h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private MultipartBody.Builder f431374i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private FormBody.Builder f431375j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private RequestBody f431376k;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class a extends RequestBody {

        /* renamed from: a, reason: collision with root package name */
        private final RequestBody f431377a;

        /* renamed from: b, reason: collision with root package name */
        private final MediaType f431378b;

        a(RequestBody requestBody, MediaType mediaType) {
            this.f431377a = requestBody;
            this.f431378b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.f431377a.contentLength();
        }

        @Override // okhttp3.RequestBody
        /* renamed from: contentType */
        public MediaType getContentType() {
            return this.f431378b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.f431377a.writeTo(bufferedSink);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(String str, HttpUrl httpUrl, @Nullable String str2, @Nullable Headers headers, @Nullable MediaType mediaType, boolean z16, boolean z17, boolean z18) {
        this.f431366a = str;
        this.f431367b = httpUrl;
        this.f431368c = str2;
        this.f431372g = mediaType;
        this.f431373h = z16;
        if (headers != null) {
            this.f431371f = headers.newBuilder();
        } else {
            this.f431371f = new Headers.Builder();
        }
        if (z17) {
            this.f431375j = new FormBody.Builder();
        } else if (z18) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.f431374i = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    private static String i(String str, boolean z16) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z16 || (codePointAt != 47 && codePointAt != 37))) {
                i3 += Character.charCount(codePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i3);
                j(buffer, str, i3, length, z16);
                return buffer.readUtf8();
            }
        }
        return str;
    }

    private static void j(Buffer buffer, String str, int i3, int i16, boolean z16) {
        Buffer buffer2 = null;
        while (i3 < i16) {
            int codePointAt = str.codePointAt(i3);
            if (!z16 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z16 || (codePointAt != 47 && codePointAt != 37))) {
                    buffer.writeUtf8CodePoint(codePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(codePointAt);
                    while (!buffer2.exhausted()) {
                        int readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        char[] cArr = f431364l;
                        buffer.writeByte((int) cArr[(readByte >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                }
            }
            i3 += Character.charCount(codePointAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, boolean z16) {
        if (z16) {
            this.f431375j.addEncoded(str, str2);
        } else {
            this.f431375j.add(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, String str2, boolean z16) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.f431372g = MediaType.get(str2);
                return;
            } catch (IllegalArgumentException e16) {
                throw new IllegalArgumentException("Malformed content type: " + str2, e16);
            }
        }
        if (z16) {
            this.f431371f.addUnsafeNonAscii(str, str2);
        } else {
            this.f431371f.add(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Headers headers) {
        this.f431371f.addAll(headers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Headers headers, RequestBody requestBody) {
        this.f431374i.addPart(headers, requestBody);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MultipartBody.Part part) {
        this.f431374i.addPart(part);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, boolean z16) {
        if (this.f431368c != null) {
            String i3 = i(str2, z16);
            String replace = this.f431368c.replace("{" + str + "}", i3);
            if (!f431365m.matcher(replace).matches()) {
                this.f431368c = replace;
                return;
            }
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, @Nullable String str2, boolean z16) {
        String str3 = this.f431368c;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.f431367b.newBuilder(str3);
            this.f431369d = newBuilder;
            if (newBuilder != null) {
                this.f431368c = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f431367b + ", Relative: " + this.f431368c);
            }
        }
        if (z16) {
            this.f431369d.addEncodedQueryParameter(str, str2);
        } else {
            this.f431369d.addQueryParameter(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void h(Class<T> cls, @Nullable T t16) {
        this.f431370e.tag(cls, t16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request.Builder k() {
        HttpUrl resolve;
        HttpUrl.Builder builder = this.f431369d;
        if (builder != null) {
            resolve = builder.build();
        } else {
            resolve = this.f431367b.resolve(this.f431368c);
            if (resolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f431367b + ", Relative: " + this.f431368c);
            }
        }
        RequestBody requestBody = this.f431376k;
        if (requestBody == null) {
            FormBody.Builder builder2 = this.f431375j;
            if (builder2 != null) {
                requestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.f431374i;
                if (builder3 != null) {
                    requestBody = builder3.build();
                } else if (this.f431373h) {
                    requestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f431372g;
        if (mediaType != null) {
            if (requestBody != null) {
                requestBody = new a(requestBody, mediaType);
            } else {
                this.f431371f.add("Content-Type", mediaType.getMediaType());
            }
        }
        return this.f431370e.url(resolve).headers(this.f431371f.build()).method(this.f431366a, requestBody);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(RequestBody requestBody) {
        this.f431376k = requestBody;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Object obj) {
        this.f431368c = obj.toString();
    }
}
