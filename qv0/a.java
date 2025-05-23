package qv0;

import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.component.d;
import f32.b;
import i22.OrientationChangedEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\n"}, d2 = {"Lqv0/a;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "Li22/d;", "event", "", "p", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a extends RoomConnector {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void p(@NotNull OrientationChangedEvent event) {
        nv0.b bVar;
        Intrinsics.checkNotNullParameter(event, "event");
        d a16 = getConnectorContext().a(nv0.b.class);
        if (a16 != null && (bVar = (nv0.b) a16.a()) != null) {
            bVar.o(event.getIsLandscape());
        }
    }
}
