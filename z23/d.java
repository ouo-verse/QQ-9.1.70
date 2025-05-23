package z23;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vas.data.SmallHomeGroupSettingData;
import com.tencent.mobileqq.vas.data.VasTroopSmallHomeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ4\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bJ4\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\bJ6\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\n0\bJB\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012J8\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012J8\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00062\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012J8\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00062\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012\u00a8\u0006\u001d"}, d2 = {"Lz23/d;", "", "Lcom/tencent/common/app/AppInterface;", "app", "", "groupId", "", "source", "Lkotlin/Function1;", "", "", "callback", "c", "Lcom/tencent/mobileqq/vas/data/g;", "e", "Lcom/tencent/mobileqq/vas/data/SmallHomeGroupSettingData;", "a", "currentState", "Lkotlin/Function2;", "", h.F, "rankSwitch", "k", "onlineSwitch", "j", "addedSwitch", "g", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {
    public final void a(AppInterface app, long groupId, int source, Function1<? super SmallHomeGroupSettingData, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(new SmallHomeGroupSettingData(groupId, 0, 0, 0, 0, 30, null));
    }

    public final void c(AppInterface app, long groupId, int source, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(Boolean.FALSE);
    }

    public final void e(AppInterface app, long groupId, int source, Function1<? super VasTroopSmallHomeInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(new VasTroopSmallHomeInfo(false, null, 0, 7, null));
    }

    public final void g(AppInterface app, long groupId, int addedSwitch, Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(0, "success");
    }

    public final void h(AppInterface app, long groupId, int currentState, int source, Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(0, "success");
    }

    public final void j(AppInterface app, long groupId, int onlineSwitch, Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(0, "success");
    }

    public final void k(AppInterface app, long groupId, int rankSwitch, Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(0, "success");
    }

    public static /* synthetic */ void d(d dVar, AppInterface appInterface, long j3, int i3, Function1 function1, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        dVar.c(appInterface, j3, i3, function1);
    }

    public static /* synthetic */ void f(d dVar, AppInterface appInterface, long j3, int i3, Function1 function1, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        dVar.e(appInterface, j3, i3, function1);
    }

    public static /* synthetic */ void i(d dVar, AppInterface appInterface, long j3, int i3, int i16, Function2 function2, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            i16 = 4;
        }
        dVar.h(appInterface, j3, i3, i16, function2);
    }
}
