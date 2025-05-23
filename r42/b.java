package r42;

import com.tencent.mobileqq.icgame.api.login.ILiveLoginApi;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0004J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0004J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lr42/b;", "", "", "roomId", "", "query", "", "p", "j", "audienceQueryType", "g", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "c", "a", "e", "Lr42/a;", "b", "Lr42/a;", "i", "()Lr42/a;", "audience", "o", "()J", "selfUid", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: a */
    @NotNull
    public static final b f430720a = new b();

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final a audience = new a();

    b() {
    }

    public static /* synthetic */ String b(b bVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return bVar.a(j3, i3);
    }

    public static /* synthetic */ String d(b bVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return bVar.c(j3, i3);
    }

    public static /* synthetic */ int f(b bVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return bVar.e(j3, i3);
    }

    public static /* synthetic */ long h(b bVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return bVar.g(j3, i3);
    }

    public static /* synthetic */ long l(b bVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return bVar.k(j3, i3);
    }

    public static /* synthetic */ String n(b bVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return bVar.m(j3, i3);
    }

    public static /* synthetic */ boolean q(b bVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return bVar.p(j3, i3);
    }

    @NotNull
    public final String a(long roomId, int query) {
        boolean isBlank;
        String a16 = audience.a(roomId, query);
        isBlank = StringsKt__StringsJVMKt.isBlank(a16);
        if (!isBlank) {
            return a16;
        }
        return "";
    }

    @NotNull
    public final String c(long roomId, int query) {
        boolean isBlank;
        String b16 = audience.b(roomId, query);
        isBlank = StringsKt__StringsJVMKt.isBlank(b16);
        if (!isBlank) {
            return b16;
        }
        return "";
    }

    public final int e(long roomId, int query) {
        int c16 = audience.c(roomId, query);
        if (c16 > 0) {
            return c16;
        }
        return 0;
    }

    public final long g(long roomId, int audienceQueryType) {
        long d16 = audience.d(roomId, audienceQueryType);
        if (d16 <= 0) {
            return 0L;
        }
        return d16;
    }

    @NotNull
    public final a i() {
        return audience;
    }

    public final long j() {
        long f16 = audience.f();
        if (f16 <= 0) {
            return 0L;
        }
        return f16;
    }

    public final long k(long roomId, int audienceQueryType) {
        long g16 = audience.g(roomId, audienceQueryType);
        if (g16 <= 0) {
            return 0L;
        }
        return g16;
    }

    @NotNull
    public final String m(long j3, int i3) {
        return audience.i(j3, i3);
    }

    public final long o() {
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo("1078", ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (loginInfo != null) {
            return loginInfo.getUid();
        }
        return 0L;
    }

    public final boolean p(long roomId, int query) {
        return audience.o(roomId, query);
    }
}
