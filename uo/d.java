package uo;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    static final int f439305d = Runtime.getRuntime().availableProcessors();

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f439306e = true;

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap f439307a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f439308b;

    /* renamed from: c, reason: collision with root package name */
    private final b f439309c = new c();

    public d(Bitmap bitmap) {
        this.f439307a = bitmap;
    }

    public Bitmap a(int i3) {
        Bitmap blur = this.f439309c.blur(this.f439307a, i3);
        this.f439308b = blur;
        return blur;
    }
}
