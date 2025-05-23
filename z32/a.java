package z32;

import com.tencent.icgame.game.liveroom.impl.room.audience.component.audiofocus.AudioFocusComponent;
import com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector;
import com.tencent.mobileqq.icgame.framework.component.d;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import f32.b;
import i22.e;
import i22.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u0006H\u0014J\b\u0010\u000b\u001a\u00020\u0006H\u0014J\b\u0010\f\u001a\u00020\u0006H\u0014\u00a8\u0006\u0011"}, d2 = {"Lz32/a;", "Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "Lcom/tencent/icgame/game/liveroom/impl/room/audience/component/audiofocus/AudioFocusComponent;", "E", "Li22/e;", "event", "", ReportConstant.COSTREPORT_PREFIX, "Li22/g;", "u", "j", "l", "g", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends RoomConnector {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    private final AudioFocusComponent E() {
        d a16 = getConnectorContext().a(AudioFocusComponent.class);
        if (a16 != null) {
            return (AudioFocusComponent) a16.a();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void g() {
        AudioFocusComponent E = E();
        if (E != null) {
            E.w();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void j() {
        AudioFocusComponent E = E();
        if (E != null) {
            E.x();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    protected void l() {
        AudioFocusComponent E = E();
        if (E != null) {
            E.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void s(@NotNull e event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AudioFocusComponent E = E();
        if (E != null) {
            E.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.base.room.service.connector.RoomConnector
    public void u(@NotNull g event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AudioFocusComponent E = E();
        if (E != null) {
            E.v();
        }
    }
}
