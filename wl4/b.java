package wl4;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl4.a;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$GetUserCurrentTeamInfoReq;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lwl4/b;", "Lpl4/a;", "", "b", "<init>", "()V", "d", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b extends pl4.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lwl4/b$a;", "", "", "uidId", "", VirtualAppProxy.KEY_GAME_ID, "displayUid", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "displayUserId", "Lmqq/app/NewIntent;", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wl4.b$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final NewIntent a(long uidId, int gameId, long displayUid, @NotNull CommonOuterClass$QQUserId displayUserId) {
            Intrinsics.checkNotNullParameter(displayUserId, "displayUserId");
            PremadesTeamServerOuterClass$GetUserCurrentTeamInfoReq premadesTeamServerOuterClass$GetUserCurrentTeamInfoReq = new PremadesTeamServerOuterClass$GetUserCurrentTeamInfoReq();
            premadesTeamServerOuterClass$GetUserCurrentTeamInfoReq.game_id.set(gameId);
            premadesTeamServerOuterClass$GetUserCurrentTeamInfoReq.uid.set(uidId);
            premadesTeamServerOuterClass$GetUserCurrentTeamInfoReq.display_uid.set(displayUid);
            premadesTeamServerOuterClass$GetUserCurrentTeamInfoReq.display_user_id.set(displayUserId);
            return a.C11028a.a(premadesTeamServerOuterClass$GetUserCurrentTeamInfoReq, b.class);
        }

        Companion() {
        }
    }

    @Override // pl4.a
    protected int b() {
        return 511;
    }
}
