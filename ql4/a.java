package ql4;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rl4.c;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JP\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H&JR\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00142\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH&JH\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00162\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H&JB\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H&\u00a8\u0006 "}, d2 = {"Lql4/a;", "Lmm4/a;", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "isVoiceRoom", "Lrl4/a;", "listener", "", "", "reportParamMap", "", "roomId", "isCaptain", "Lsl4/a;", "r1", "selfUserId", "otherUserId", "Lrl4/c;", "E2", "Lrl4/b;", "X1", "", VirtualAppProxy.KEY_GAME_ID, "currentYesUid", "needDestroyTg", "subId", WadlProxyConsts.SCENE_ID, "", "F2", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface a extends mm4.a {
    @Nullable
    sl4.a E2(@NotNull QBaseActivity activity, @Nullable CommonOuterClass$QQUserId selfUserId, @NotNull CommonOuterClass$QQUserId otherUserId, boolean isCaptain, @Nullable c listener, @NotNull Map<String, String> reportParamMap, long roomId);

    void F2(@Nullable QBaseActivity activity, @NotNull CommonOuterClass$QQUserId userId, int gameId, long currentYesUid, boolean needDestroyTg, int subId, int sceneId);

    @Nullable
    sl4.a X1(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId userId, @Nullable rl4.b listener, @NotNull Map<String, String> reportParamMap, long roomId, boolean isCaptain);

    @Nullable
    sl4.a r1(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId userId, boolean isVoiceRoom, @Nullable rl4.a listener, @NotNull Map<String, String> reportParamMap, long roomId, boolean isCaptain);
}
