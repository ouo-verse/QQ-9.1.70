package th4;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lth4/n;", "", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "param", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "a", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f436362a = new n();

    n() {
    }

    private final ExpandHallListener a(ExpandHallLaunchParam param) {
        return new a();
    }

    @Nullable
    public final ExpandHallListener b(@NotNull ExpandHallLaunchParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        if (param.f376301d == 2) {
            return a(param);
        }
        return null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J,\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0015"}, d2 = {"th4/n$a", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "", "source", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "param", "Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "", "c", "", "roomId", "", "e", "errorCode", "", "errorMsg", "b", "teamId", "a", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements ExpandHallListener {
        a() {
        }

        @Override // com.tencent.timi.game.api.cb.ExpandHallListener
        public boolean c(int source, @Nullable ExpandHallLaunchParam param, @NotNull QBaseActivity context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String str = null;
            boolean z16 = true;
            boolean z17 = false;
            if (source != 0 && source != 1) {
                if (source != 2 && source != 3 && source != 4) {
                    z16 = false;
                } else {
                    IGuildMainFrameApi iGuildMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
                    if (param != null) {
                        str = param.C;
                    }
                    iGuildMainFrameApi.closeAppChannel(context, new rr1.b(str));
                }
            } else {
                gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
                if (I0 != null) {
                    z17 = I0.t2();
                }
                if (z17) {
                    IGuildMainFrameApi iGuildMainFrameApi2 = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
                    if (param != null) {
                        str = param.C;
                    }
                    iGuildMainFrameApi2.closeAppChannel(context, new rr1.b(str));
                } else {
                    ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).setCenterPanelInOrOut(context, 2, true);
                }
            }
            com.tencent.timi.game.utils.l.i("HallListenerFactory_", "createGuildDefaultListener#onExitEvent result=" + z16);
            return z16;
        }

        @Override // com.tencent.timi.game.api.cb.ExpandHallListener
        public void e(long roomId, @NotNull ExpandHallLaunchParam param, @NotNull QBaseActivity context) {
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(context, "context");
            com.tencent.timi.game.utils.l.i("HallListenerFactory_", "createGuildDefaultListener#onJoinHallSucceed param=" + param);
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).updateSelectedChannel(context, param.C);
        }

        @Override // com.tencent.timi.game.api.cb.ExpandHallListener
        public void a(long teamId, @Nullable ExpandHallLaunchParam param) {
        }

        @Override // com.tencent.timi.game.api.cb.ExpandHallListener
        public void b(long roomId, @Nullable ExpandHallLaunchParam param, int errorCode, @Nullable String errorMsg) {
        }

        @Override // com.tencent.timi.game.api.cb.ExpandHallListener
        public void d(long teamId, @Nullable ExpandHallLaunchParam param, int errorCode, @Nullable String errorMsg) {
        }
    }
}
