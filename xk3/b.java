package xk3;

import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Lxk3/b;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "c", "", "b", "activityName", "", "hashCode", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f448110a = new b();

    b() {
    }

    public final String a(String activityName, int hashCode) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        return activityName + "-" + hashCode;
    }

    public final String b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String canonicalName = activity.getClass().getCanonicalName();
        return canonicalName == null ? activity.toString() : canonicalName;
    }

    public final boolean c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return ((a) i.INSTANCE.a(a.class)).isTopEngineActivity(b(activity), activity.hashCode());
    }
}
