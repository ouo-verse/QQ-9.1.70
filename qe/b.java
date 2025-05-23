package qe;

import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R3\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013`\u00148\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lqe/b;", "", "Lyd/a;", "adFeedData", "", "b", "i", "", "innerAdShowType", "g", "c", "f", "e", "d", h.F, "", "Ljava/lang/String;", "TAG", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "mVideoCurrentPosition", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f428879a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "QZoneAdFeedProUtils";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Long> mVideoCurrentPosition = new HashMap<>();

    b() {
    }

    public final HashMap<String, Long> a() {
        return mVideoCurrentPosition;
    }

    public final boolean b(yd.a adFeedData) {
        return c(yd.b.h(adFeedData));
    }

    public final boolean c(int innerAdShowType) {
        if (innerAdShowType == 3) {
            return true;
        }
        return false;
    }

    public final boolean d(int innerAdShowType) {
        if (innerAdShowType != 67 && innerAdShowType != 21 && innerAdShowType != 68) {
            return false;
        }
        return true;
    }

    public final boolean e(int innerAdShowType) {
        if (innerAdShowType == 1 || innerAdShowType == 2) {
            return true;
        }
        return false;
    }

    public final boolean f(int innerAdShowType) {
        if (innerAdShowType == 4) {
            return true;
        }
        return false;
    }

    public final boolean g(int innerAdShowType) {
        return c(innerAdShowType) || f(innerAdShowType);
    }

    public final boolean h(yd.a adFeedData) {
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label> i3 = yd.b.i(adFeedData);
        String j3 = yd.b.j(adFeedData);
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label> list = i3;
        if (list == null || list.isEmpty()) {
            return j3 == null || j3.length() == 0;
        }
        return false;
    }

    public final boolean i(yd.a adFeedData) {
        return f(yd.b.h(adFeedData));
    }
}
