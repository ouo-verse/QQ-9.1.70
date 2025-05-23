package u53;

import com.tencent.util.QUIProfileConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes21.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f438420a;

    /* renamed from: b, reason: collision with root package name */
    protected static final String f438421b;

    /* renamed from: c, reason: collision with root package name */
    protected static final String f438422c = com.tencent.mobileqq.wink.b.c().getFilesDir().getParent();

    /* renamed from: d, reason: collision with root package name */
    protected static final String f438423d;

    /* renamed from: e, reason: collision with root package name */
    protected static final String f438424e;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f438425a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f438426b;

        /* renamed from: c, reason: collision with root package name */
        public static final String f438427c;

        static {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(h.f438424e);
            String str = File.separator;
            sb5.append(str);
            sb5.append(QUIProfileConstants.PROFILE_ID_WINK);
            f438425a = sb5.toString();
            f438426b = h.f438421b + str + QUIProfileConstants.PROFILE_ID_WINK;
            f438427c = h.f438420a + str + QUIProfileConstants.PROFILE_ID_WINK;
        }
    }

    static {
        boolean z16;
        if (com.tencent.mobileqq.wink.b.c().getExternalFilesDir(null) != null && com.tencent.mobileqq.wink.b.c().getExternalCacheDir() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f438421b = com.tencent.mobileqq.wink.b.c().getExternalFilesDir(null).getPath();
            f438420a = com.tencent.mobileqq.wink.b.c().getExternalCacheDir().getPath();
        } else {
            f438421b = com.tencent.mobileqq.wink.b.c().getFilesDir().getPath();
            f438420a = com.tencent.mobileqq.wink.b.c().getCacheDir().getPath();
        }
        f438424e = com.tencent.mobileqq.wink.b.c().getFilesDir().getPath();
        f438423d = com.tencent.mobileqq.wink.b.c().getCacheDir().getPath();
    }
}
