package retrofit2;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public final class r<T> implements d<T> {

    @GuardedBy("this")
    @Nullable
    private Call C;

    @GuardedBy("this")
    @Nullable
    private Throwable D;

    @GuardedBy("this")
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private final aa f431299d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f431300e;

    /* renamed from: f, reason: collision with root package name */
    private final Object[] f431301f;

    /* renamed from: h, reason: collision with root package name */
    private final Call.Factory f431302h;

    /* renamed from: i, reason: collision with root package name */
    private final h<ResponseBody, T> f431303i;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f431304m;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    class a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f431305a;

        a(f fVar) {
            this.f431305a = fVar;
        }

        private void a(Throwable th5) {
            try {
                this.f431305a.onFailure(r.this, th5);
            } catch (Throwable th6) {
                ae.t(th6);
                th6.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                try {
                    this.f431305a.onResponse(r.this, r.this.d(response));
                } catch (Throwable th5) {
                    ae.t(th5);
                    th5.printStackTrace();
                }
            } catch (Throwable th6) {
                ae.t(th6);
                a(th6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class b extends ResponseBody {

        /* renamed from: d, reason: collision with root package name */
        private final ResponseBody f431307d;

        /* renamed from: e, reason: collision with root package name */
        private final BufferedSource f431308e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        IOException f431309f;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        class a extends ForwardingSource {
            a(Source source) {
                super(source);
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j3) throws IOException {
                try {
                    return super.read(buffer, j3);
                } catch (IOException e16) {
                    b.this.f431309f = e16;
                    throw e16;
                }
            }
        }

        b(ResponseBody responseBody) {
            this.f431307d = responseBody;
            this.f431308e = Okio.buffer(new a(responseBody.getBodySource()));
        }

        void a() throws IOException {
            IOException iOException = this.f431309f;
            if (iOException == null) {
            } else {
                throw iOException;
            }
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f431307d.close();
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentLength */
        public long getContentLength() {
            return this.f431307d.getContentLength();
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentType */
        public MediaType get$contentType() {
            return this.f431307d.get$contentType();
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: source */
        public BufferedSource getBodySource() {
            return this.f431308e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class c extends ResponseBody {

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private final MediaType f431311d;

        /* renamed from: e, reason: collision with root package name */
        private final long f431312e;

        c(@Nullable MediaType mediaType, long j3) {
            this.f431311d = mediaType;
            this.f431312e = j3;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentLength */
        public long getContentLength() {
            return this.f431312e;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentType */
        public MediaType get$contentType() {
            return this.f431311d;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: source */
        public BufferedSource getBodySource() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(aa aaVar, Object obj, Object[] objArr, Call.Factory factory, h<ResponseBody, T> hVar) {
        this.f431299d = aaVar;
        this.f431300e = obj;
        this.f431301f = objArr;
        this.f431302h = factory;
        this.f431303i = hVar;
    }

    private Call b() throws IOException {
        Call newCall = this.f431302h.newCall(this.f431299d.a(this.f431300e, this.f431301f));
        if (newCall != null) {
            return newCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    @GuardedBy("this")
    private Call c() throws IOException {
        Call call = this.C;
        if (call != null) {
            return call;
        }
        Throwable th5 = this.D;
        if (th5 != null) {
            if (!(th5 instanceof IOException)) {
                if (th5 instanceof RuntimeException) {
                    throw ((RuntimeException) th5);
                }
                throw ((Error) th5);
            }
            throw ((IOException) th5);
        }
        try {
            Call b16 = b();
            this.C = b16;
            return b16;
        } catch (IOException | Error | RuntimeException e16) {
            ae.t(e16);
            this.D = e16;
            throw e16;
        }
    }

    @Override // retrofit2.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public r<T> clone() {
        return new r<>(this.f431299d, this.f431300e, this.f431301f, this.f431302h, this.f431303i);
    }

    @Override // retrofit2.d
    public void cancel() {
        Call call;
        this.f431304m = true;
        synchronized (this) {
            call = this.C;
        }
        if (call != null) {
            call.cancel();
        }
    }

    ab<T> d(Response response) throws IOException {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new c(body.get$contentType(), body.getContentLength())).build();
        int code = build.code();
        if (code >= 200 && code < 300) {
            if (code != 204 && code != 205) {
                b bVar = new b(body);
                try {
                    return ab.f(this.f431303i.convert(bVar), build);
                } catch (RuntimeException e16) {
                    bVar.a();
                    throw e16;
                }
            }
            body.close();
            return ab.f(null, build);
        }
        try {
            return ab.c(ae.a(body), build);
        } finally {
            body.close();
        }
    }

    @Override // retrofit2.d
    public ab<T> execute() throws IOException {
        Call c16;
        synchronized (this) {
            if (!this.E) {
                this.E = true;
                c16 = c();
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.f431304m) {
            c16.cancel();
        }
        return d(c16.execute());
    }

    @Override // retrofit2.d
    public void g(f<T> fVar) {
        Call call;
        Throwable th5;
        Objects.requireNonNull(fVar, "callback == null");
        synchronized (this) {
            if (!this.E) {
                this.E = true;
                call = this.C;
                th5 = this.D;
                if (call == null && th5 == null) {
                    try {
                        Call b16 = b();
                        this.C = b16;
                        call = b16;
                    } catch (Throwable th6) {
                        th5 = th6;
                        ae.t(th5);
                        this.D = th5;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th5 != null) {
            fVar.onFailure(this, th5);
            return;
        }
        if (this.f431304m) {
            call.cancel();
        }
        call.enqueue(new a(fVar));
    }

    @Override // retrofit2.d
    public boolean isCanceled() {
        boolean z16 = true;
        if (this.f431304m) {
            return true;
        }
        synchronized (this) {
            Call call = this.C;
            if (call == null || !call.getCanceled()) {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // retrofit2.d
    public synchronized Request request() {
        try {
        } catch (IOException e16) {
            throw new RuntimeException("Unable to create request.", e16);
        }
        return c().request();
    }
}
