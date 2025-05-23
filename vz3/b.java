package vz3;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b<T> {

    /* renamed from: a, reason: collision with root package name */
    private LruCache<String, T> f443782a = new a(((int) Runtime.getRuntime().maxMemory()) / 32);

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends LruCache<String, T> {
        a(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, T t16) {
            if (t16 != null) {
                int c16 = b.this.c(t16);
                if (c16 == 0) {
                    return b.this.d(t16);
                }
                return c16;
            }
            return 0;
        }
    }

    private static int b(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public int c(T t16) {
        if (t16 instanceof Bitmap) {
            return b((Bitmap) t16);
        }
        if (t16 instanceof BitmapDrawable) {
            return b(((BitmapDrawable) t16).getBitmap());
        }
        return 0;
    }

    protected int d(T t16) {
        return 0;
    }

    @SuppressLint({"NewApi"})
    public void e(int i3) {
        synchronized (this) {
            this.f443782a.trimToSize(i3);
        }
    }
}
