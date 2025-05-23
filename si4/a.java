package si4;

import androidx.annotation.Nullable;
import com.tencent.timi.game.utils.IResultListener;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface a {
    void a(boolean z16, @NotNull kf4.a aVar, int i3);

    boolean b();

    void c(@NotNull kf4.a aVar);

    void d(kf4.b bVar);

    @Nullable
    kf4.b e();

    void f(b bVar);

    long g();

    PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp h(@NotNull kf4.a aVar);

    void i(@NotNull kf4.a aVar, IResultListener<PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp> iResultListener);

    void j(@NotNull kf4.a aVar, b bVar);

    @Nullable
    kf4.a k();
}
