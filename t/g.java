package t;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class g implements com.bumptech.glide.load.c {

    /* renamed from: b, reason: collision with root package name */
    private final h f435095b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final URL f435096c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f435097d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private String f435098e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private URL f435099f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private volatile byte[] f435100g;

    /* renamed from: h, reason: collision with root package name */
    private int f435101h;

    public g(URL url) {
        this(url, h.f435103b);
    }

    private byte[] d() {
        if (this.f435100g == null) {
            this.f435100g = c().getBytes(com.bumptech.glide.load.c.f31560a);
        }
        return this.f435100g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f435098e)) {
            String str = this.f435097d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) h0.j.d(this.f435096c)).toString();
            }
            this.f435098e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f435098e;
    }

    private URL g() throws MalformedURLException {
        if (this.f435099f == null) {
            this.f435099f = new URL(f());
        }
        return this.f435099f;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f435097d;
        if (str == null) {
            return ((URL) h0.j.d(this.f435096c)).toString();
        }
        return str;
    }

    public Map<String, String> e() {
        return this.f435095b.getHeaders();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!c().equals(gVar.c()) || !this.f435095b.equals(gVar.f435095b)) {
            return false;
        }
        return true;
    }

    public URL h() throws MalformedURLException {
        return g();
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.f435101h == 0) {
            int hashCode = c().hashCode();
            this.f435101h = hashCode;
            this.f435101h = (hashCode * 31) + this.f435095b.hashCode();
        }
        return this.f435101h;
    }

    public String toString() {
        return c();
    }

    public g(String str) {
        this(str, h.f435103b);
    }

    public g(URL url, h hVar) {
        this.f435096c = (URL) h0.j.d(url);
        this.f435097d = null;
        this.f435095b = (h) h0.j.d(hVar);
    }

    public g(String str, h hVar) {
        this.f435096c = null;
        this.f435097d = h0.j.b(str);
        this.f435095b = (h) h0.j.d(hVar);
    }
}
