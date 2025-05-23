package tl4;

import android.content.Context;
import bo4.d;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.profile.impl.ProfileDestroyObserver;
import fm4.g;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rl4.c;
import trpc.yes.common.CommonOuterClass$QQUserId;
import ul4.f;
import ul4.i;
import ul4.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0007H\u0002JP\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\rH\u0016JR\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001d2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0006\u001a\u00020\u0002H\u0016JH\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\rH\u0016JB\u0010$\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0012\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Ltl4/b;", "Lql4/a;", "", "currentYesUid", "", "P3", "roomId", "", "N3", "(Ljava/lang/Long;)I", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "uid", VirtualAppProxy.KEY_GAME_ID, "", "O3", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "userId", "isVoiceRoom", "Lrl4/a;", "listener", "", "", "reportParamMap", "isCaptain", "Lsl4/a;", "r1", "selfUserId", "otherUserId", "Lrl4/c;", "E2", "Lrl4/b;", "X1", "needDestroyTg", "subId", WadlProxyConsts.SCENE_ID, "F2", "Landroid/content/Context;", "context", "init", "o2", "", "a", "Ljava/util/List;", "destroyActivityList", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b implements ql4.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> destroyActivityList = new ArrayList();

    private final int N3(Long roomId) {
        long j3;
        g gVar = (g) mm4.b.b(g.class);
        if (roomId != null) {
            j3 = roomId.longValue();
        } else {
            j3 = 0;
        }
        return gVar.K0(j3).o1();
    }

    private final boolean O3(CommonOuterClass$QQUserId uid, int gameId) {
        return ((d) mm4.b.b(d.class)).W0(uid, gameId);
    }

    private final void P3(long currentYesUid) {
        if (currentYesUid != 0) {
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
            commonOuterClass$QQUserId.yes_uid.set(currentYesUid);
            commonOuterClass$QQUserId.user_from.set(4);
            ((d) mm4.b.b(d.class)).c1(commonOuterClass$QQUserId, null);
        }
    }

    @Override // ql4.a
    @Nullable
    public sl4.a E2(@NotNull QBaseActivity activity, @Nullable CommonOuterClass$QQUserId selfUserId, @NotNull CommonOuterClass$QQUserId otherUserId, boolean isCaptain, @Nullable c listener, @NotNull Map<String, String> reportParamMap, long roomId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(otherUserId, "otherUserId");
        Intrinsics.checkNotNullParameter(reportParamMap, "reportParamMap");
        if (O3(otherUserId, N3(Long.valueOf(roomId)))) {
            return null;
        }
        i iVar = new i(activity, otherUserId, isCaptain, reportParamMap, roomId);
        iVar.R1(selfUserId);
        iVar.Q1(listener);
        iVar.show();
        return iVar;
    }

    @Override // ql4.a
    public void F2(@Nullable QBaseActivity activity, @NotNull CommonOuterClass$QQUserId userId, int gameId, long currentYesUid, boolean needDestroyTg, int subId, int sceneId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (activity != null) {
            String yesId = ((ll4.a) mm4.b.b(ll4.a.class)).o(userId.yes_uid.get());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Intrinsics.checkNotNullExpressionValue(yesId, "yesId");
            linkedHashMap.put("yes_to_yes_uid", yesId);
            new m(activity, userId, gameId, linkedHashMap, subId, sceneId).show();
            if (needDestroyTg) {
                if (!this.destroyActivityList.contains(Integer.valueOf(activity.hashCode()))) {
                    this.destroyActivityList.add(Integer.valueOf(activity.hashCode()));
                    activity.getLifecycle().addObserver(new ProfileDestroyObserver());
                    P3(currentYesUid);
                }
            }
        }
    }

    @Override // ql4.a
    @Nullable
    public sl4.a X1(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId userId, @Nullable rl4.b listener, @NotNull Map<String, String> reportParamMap, long roomId, boolean isCaptain) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(reportParamMap, "reportParamMap");
        if (O3(userId, N3(Long.valueOf(roomId)))) {
            return null;
        }
        f fVar = new f(activity, userId, reportParamMap, roomId, isCaptain);
        fVar.M1(listener);
        fVar.show();
        fVar.x1(true);
        return fVar;
    }

    @Override // mm4.a
    public void o2() {
        a.INSTANCE.a().c();
        this.destroyActivityList.clear();
    }

    @Override // ql4.a
    @Nullable
    public sl4.a r1(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId userId, boolean isVoiceRoom, @Nullable rl4.a listener, @NotNull Map<String, String> reportParamMap, long roomId, boolean isCaptain) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(reportParamMap, "reportParamMap");
        if (O3(userId, N3(Long.valueOf(roomId)))) {
            return null;
        }
        ul4.d dVar = new ul4.d(activity, userId, isVoiceRoom, reportParamMap, roomId, isCaptain);
        dVar.S1(listener);
        dVar.show();
        if (!isVoiceRoom) {
            dVar.x1(false);
        } else {
            dVar.x1(true);
        }
        return dVar;
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
    }
}
