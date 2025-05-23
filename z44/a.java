package z44;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.chats.main.vm.usecase.click.c;
import com.tencent.robot.aio.background.api.IRobotBackgroundApi;
import com.tencent.robot.api.IRobotIdentityApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0011\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"Lz44/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/c;", "", "robotUin", "", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "invoke", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements c {
    private final void a(String robotUin) {
        try {
            Result.Companion companion = Result.INSTANCE;
            ((IRobotBackgroundApi) QRoute.api(IRobotBackgroundApi.class)).preloadRobotBackground(robotUin, true);
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.c
    public void invoke(@NotNull b.a params) {
        g gVar;
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof g) {
            gVar = (g) b16;
        } else {
            gVar = null;
        }
        if (gVar != null && gVar.n() == 1 && ((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isRobotUin(String.valueOf(gVar.l()))) {
            a(String.valueOf(gVar.l()));
        }
    }
}
