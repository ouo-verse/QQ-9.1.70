package qk1;

import com.tencent.luggage.wxa.xd.t0;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.qphone.base.util.BaseApplication;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \f2\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0014J\b\u0010\t\u001a\u00020\u0003H\u0014\u00a8\u0006\u000e"}, d2 = {"Lqk1/b;", "Lok1/a;", "Lpk1/b;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "<init>", "()V", h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends ok1.a<pk1.b<?>> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return t0.NAME;
    }

    @Override // ok1.a
    protected boolean o(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(BaseApplication.getContext(), RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putString("url", g(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK));
        QRoute.startUri(activityURIRequest, (o) null);
        return true;
    }
}
