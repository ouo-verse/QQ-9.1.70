package rx3;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lrx3/i;", "", "", "chatType", "a", "", "content", "peerUid", "", "b", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f432935a = new i();

    i() {
    }

    public final int a(int chatType) {
        if (chatType == 1) {
            return 0;
        }
        if (chatType == 2) {
            return 1;
        }
        if (chatType != 4) {
            return 0;
        }
        return 11;
    }

    public final void b(@NotNull String content, @NotNull String peerUid, int chatType) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(peerUid, chatType, 81L, 0, false, false, null, 120, null);
        LocalGrayTip.LocalGrayTipBuilder.i(localGrayTipBuilder, content, 0, 2, null);
        QRouteApi api = QRoute.api(INtGrayTipApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
        INtGrayTipApi.a.a((INtGrayTipApi) api, peekAppRuntime, localGrayTipBuilder.m(), null, 4, null);
    }
}
