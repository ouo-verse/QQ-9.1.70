package s;

import android.content.Context;
import java.io.File;
import s.d;

/* compiled from: P */
/* loaded from: classes.dex */
public final class f extends d {

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f433027a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f433028b;

        a(Context context, String str) {
            this.f433027a = context;
            this.f433028b = str;
        }

        @Override // s.d.a
        public File a() {
            File cacheDir = this.f433027a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            if (this.f433028b != null) {
                return new File(cacheDir, this.f433028b);
            }
            return cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(Context context, String str, long j3) {
        super(new a(context, str), j3);
    }
}
