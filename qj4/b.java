package qj4;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl4.a;
import trpc.yes.common.GameDataServerOuterClass$SetAnchorGameEquipRoleReq;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lqj4/b;", "Lpl4/a;", "", "b", "<init>", "()V", "d", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b extends pl4.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ8\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b\u00a8\u0006\u000f"}, d2 = {"Lqj4/b$a;", "", "", "anchorId", "", GdtGetUserInfoHandler.KEY_AREA, "partition", "equipStatus", "", "uId", "roomId", "Lmqq/app/NewIntent;", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qj4.b$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final NewIntent a(@NotNull String anchorId, int area, int partition, int equipStatus, long uId, long roomId) {
            Intrinsics.checkNotNullParameter(anchorId, "anchorId");
            GameDataServerOuterClass$SetAnchorGameEquipRoleReq gameDataServerOuterClass$SetAnchorGameEquipRoleReq = new GameDataServerOuterClass$SetAnchorGameEquipRoleReq();
            gameDataServerOuterClass$SetAnchorGameEquipRoleReq.anchor_id.set(anchorId);
            gameDataServerOuterClass$SetAnchorGameEquipRoleReq.area.set(area);
            gameDataServerOuterClass$SetAnchorGameEquipRoleReq.partition.set(partition);
            gameDataServerOuterClass$SetAnchorGameEquipRoleReq.equip_status.set(equipStatus);
            gameDataServerOuterClass$SetAnchorGameEquipRoleReq.uid.set(uId);
            gameDataServerOuterClass$SetAnchorGameEquipRoleReq.room_id.set(roomId);
            return a.C11028a.a(gameDataServerOuterClass$SetAnchorGameEquipRoleReq, b.class);
        }

        Companion() {
        }
    }

    @Override // pl4.a
    protected int b() {
        return 313;
    }
}
