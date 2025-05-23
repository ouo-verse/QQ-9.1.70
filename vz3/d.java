package vz3;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<Bitmap> f443785a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    private final int f443786b;

    /* renamed from: c, reason: collision with root package name */
    private int f443787c;

    /* renamed from: d, reason: collision with root package name */
    private int f443788d;

    /* renamed from: e, reason: collision with root package name */
    private int f443789e;

    public d() {
        DisplayMetrics displayMetrics = wz3.g.a().getDisplayMetrics();
        this.f443786b = displayMetrics.widthPixels * displayMetrics.heightPixels * 8;
    }

    public static boolean c() {
        return true;
    }

    private void e(Bitmap bitmap) {
        this.f443785a.remove(bitmap);
        if (bitmap != null) {
            this.f443787c -= bitmap.getRowBytes() * bitmap.getHeight();
            if (!bitmap.isRecycled() && !c()) {
                bitmap.recycle();
            }
        }
    }

    public void a() {
        Iterator<Bitmap> it = this.f443785a.iterator();
        while (it.hasNext()) {
            Bitmap next = it.next();
            if (next != null && !next.isRecycled() && !c()) {
                next.recycle();
            }
        }
        this.f443785a.clear();
        this.f443787c = 0;
        this.f443788d = 0;
        this.f443789e = 0;
    }

    public Bitmap b(int i3, int i16) {
        this.f443788d++;
        Iterator<Bitmap> it = this.f443785a.iterator();
        Bitmap bitmap = null;
        while (it.hasNext()) {
            Bitmap next = it.next();
            if (next.getWidth() >= i3 && next.getHeight() >= i16 && (bitmap == null || bitmap.getHeight() * bitmap.getWidth() >= next.getHeight() * next.getWidth())) {
                bitmap = next;
            }
        }
        if (bitmap != null) {
            this.f443785a.remove(bitmap);
            this.f443787c -= bitmap.getRowBytes() * bitmap.getHeight();
            return bitmap;
        }
        try {
            this.f443789e++;
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_4444);
        } catch (OutOfMemoryError e16) {
            wz3.b.d("RFWBitmapCacheManager", "create bitmap out of memory", e16);
            return bitmap;
        }
    }

    public void d(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f443787c += bitmap.getRowBytes() * bitmap.getHeight();
            this.f443785a.addLast(bitmap);
            while (this.f443787c > this.f443786b) {
                Iterator<Bitmap> it = this.f443785a.iterator();
                Bitmap bitmap2 = null;
                while (it.hasNext()) {
                    Bitmap next = it.next();
                    if (bitmap2 == null || bitmap2.getHeight() * bitmap2.getWidth() >= next.getHeight() * next.getWidth()) {
                        bitmap2 = next;
                    }
                }
                if (bitmap2 != null) {
                    e(bitmap2);
                }
            }
        }
    }
}
