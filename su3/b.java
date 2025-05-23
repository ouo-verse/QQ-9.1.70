package su3;

import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0007\u001a\u00020\u0003*\u00020\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aio/data/AIOParam;", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "a", "", "c", "Lcom/tencent/aio/data/AIOSession;", "b", "d", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    @NotNull
    public static final SessionInfo a(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        SessionInfo b16 = b(aIOParam.r());
        long j3 = aIOParam.l().getLong("key_peerUin", 0L);
        if (j3 != 0) {
            b16.f179557e = String.valueOf(j3);
        }
        return b16;
    }

    @NotNull
    public static final SessionInfo b(@NotNull AIOSession aIOSession) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(aIOSession, "<this>");
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = d(aIOSession);
        if (aIOSession.c().f().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = aIOSession.c().f();
        } else if (aIOSession.c().e() == 2) {
            str = aIOSession.c().j();
        } else {
            str = "";
        }
        sessionInfo.f179559f = str;
        sessionInfo.f179557e = aIOSession.c().j();
        sessionInfo.f179563i = aIOSession.c().g();
        return sessionInfo;
    }

    public static final int c(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        return d(aIOParam.r());
    }

    public static final int d(@NotNull AIOSession aIOSession) {
        Intrinsics.checkNotNullParameter(aIOSession, "<this>");
        return com.tencent.nt.adapter.session.c.c(aIOSession.c().e());
    }
}
