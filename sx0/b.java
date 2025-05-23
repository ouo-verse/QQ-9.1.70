package sx0;

import com.tencent.icgame.game.tim.api.message.c;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.icgame.trpc.yes.common.TcloudServerOuterClass$GetUserTCloudSignRsp;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH&J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0011H&\u00a8\u0006\u0014"}, d2 = {"Lsx0/b;", "Lmm4/a;", "Lsx0/a;", "callback", "", "Z2", "logout", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/icgame/trpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "O", "", "uid", "Lcom/tencent/icgame/game/tim/api/message/c;", BdhLogUtil.LogTag.Tag_Conn, "groupId", "M", "", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$TimMsgBody;", "timMsgBody", "S0", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public interface b extends mm4.a {
    @NotNull
    c C(long uid);

    @NotNull
    c M(long groupId);

    void O(@Nullable IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> callback);

    void S0(@NotNull String groupId, @NotNull MessageOuterClass$TimMsgBody timMsgBody);

    void Z2(@Nullable a callback);

    void logout();
}
