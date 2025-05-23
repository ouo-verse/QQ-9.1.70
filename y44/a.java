package y44;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.chats.data.converter.c;
import com.tencent.qqnt.chats.data.converter.f;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.k;
import com.tencent.robot.api.IRobotChatsPreloadService;
import com.tencent.robot.api.IRobotIdentityApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Ly44/a;", "Lcom/tencent/qqnt/chats/data/converter/g;", "", "robotUin", "", "b", "(Ljava/lang/Long;)V", "", "a", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "matchPayload", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "update", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends g {
    private final boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102314", true);
    }

    private final void b(Long robotUin) {
        IRuntimeService iRuntimeService;
        try {
            Result.Companion companion = Result.INSTANCE;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Unit unit = null;
            String str = null;
            if (peekAppRuntime != null) {
                iRuntimeService = peekAppRuntime.getRuntimeService(IRobotChatsPreloadService.class, "");
            } else {
                iRuntimeService = null;
            }
            IRobotChatsPreloadService iRobotChatsPreloadService = (IRobotChatsPreloadService) iRuntimeService;
            if (iRobotChatsPreloadService != null) {
                if (robotUin != null) {
                    str = robotUin.toString();
                }
                iRobotChatsPreloadService.preloadRobotBackgroundForChats(str);
                unit = Unit.INSTANCE;
            }
            Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull f payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return Intrinsics.areEqual(k.f355124a, payload);
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull c params) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!a()) {
            return;
        }
        QRouteApi api = QRoute.api(IRobotIdentityApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRobotIdentityApi::class.java)");
        IRobotIdentityApi iRobotIdentityApi = (IRobotIdentityApi) api;
        if (iRobotIdentityApi.isMatchRobotChatType(Integer.valueOf(item.n())) && iRobotIdentityApi.isRobotUin(Long.valueOf(item.l()))) {
            b(Long.valueOf(item.l()));
        }
    }
}
