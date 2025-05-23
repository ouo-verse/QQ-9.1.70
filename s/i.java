package s;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;

/* compiled from: P */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final int f433030a;

    /* renamed from: b, reason: collision with root package name */
    private final int f433031b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f433032c;

    /* renamed from: d, reason: collision with root package name */
    private final int f433033d;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: i, reason: collision with root package name */
        static final int f433034i;

        /* renamed from: a, reason: collision with root package name */
        final Context f433035a;

        /* renamed from: b, reason: collision with root package name */
        ActivityManager f433036b;

        /* renamed from: c, reason: collision with root package name */
        c f433037c;

        /* renamed from: e, reason: collision with root package name */
        float f433039e;

        /* renamed from: d, reason: collision with root package name */
        float f433038d = 2.0f;

        /* renamed from: f, reason: collision with root package name */
        float f433040f = 0.4f;

        /* renamed from: g, reason: collision with root package name */
        float f433041g = 0.33f;

        /* renamed from: h, reason: collision with root package name */
        int f433042h = 4194304;

        static {
            int i3;
            if (Build.VERSION.SDK_INT < 26) {
                i3 = 4;
            } else {
                i3 = 1;
            }
            f433034i = i3;
        }

        public a(Context context) {
            this.f433039e = f433034i;
            this.f433035a = context;
            this.f433036b = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            this.f433037c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.e(this.f433036b)) {
                this.f433039e = 0.0f;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f433043a;

        b(DisplayMetrics displayMetrics) {
            this.f433043a = displayMetrics;
        }

        @Override // s.i.c
        public int a() {
            return this.f433043a.heightPixels;
        }

        @Override // s.i.c
        public int getWidthPixels() {
            return this.f433043a.widthPixels;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    interface c {
        int a();

        int getWidthPixels();
    }

    i(a aVar) {
        int i3;
        boolean z16;
        this.f433032c = aVar.f433035a;
        if (e(aVar.f433036b)) {
            i3 = aVar.f433042h / 2;
        } else {
            i3 = aVar.f433042h;
        }
        this.f433033d = i3;
        int c16 = c(aVar.f433036b, aVar.f433040f, aVar.f433041g);
        float widthPixels = aVar.f433037c.getWidthPixels() * aVar.f433037c.a() * 4;
        int round = Math.round(aVar.f433039e * widthPixels);
        int round2 = Math.round(widthPixels * aVar.f433038d);
        int i16 = c16 - i3;
        int i17 = round2 + round;
        if (i17 <= i16) {
            this.f433031b = round2;
            this.f433030a = round;
        } else {
            float f16 = i16;
            float f17 = aVar.f433039e;
            float f18 = aVar.f433038d;
            float f19 = f16 / (f17 + f18);
            this.f433031b = Math.round(f18 * f19);
            this.f433030a = Math.round(f19 * aVar.f433039e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Calculation complete, Calculated memory cache size: ");
            sb5.append(f(this.f433031b));
            sb5.append(", pool size: ");
            sb5.append(f(this.f433030a));
            sb5.append(", byte array size: ");
            sb5.append(f(i3));
            sb5.append(", memory class limited? ");
            if (i17 > c16) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(", max size: ");
            sb5.append(f(c16));
            sb5.append(", memoryClass: ");
            sb5.append(aVar.f433036b.getMemoryClass());
            sb5.append(", isLowMemoryDevice: ");
            sb5.append(e(aVar.f433036b));
            Log.d("MemorySizeCalculator", sb5.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f16, float f17) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (e(activityManager)) {
            f16 = f17;
        }
        return Math.round(memoryClass * f16);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String f(int i3) {
        return Formatter.formatFileSize(this.f433032c, i3);
    }

    public int a() {
        return this.f433033d;
    }

    public int b() {
        return this.f433030a;
    }

    public int d() {
        return this.f433031b;
    }
}
