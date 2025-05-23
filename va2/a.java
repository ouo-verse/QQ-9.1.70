package va2;

import android.content.Context;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.graytips.action.f;
import com.tencent.qqnt.graytips.handler.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lva2/a;", "Lcom/tencent/qqnt/graytips/handler/b;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/qqnt/graytips/action/f;", "a", "actionInfo", "b", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "Lgv3/a;", "aioAbility", "", "c", "<init>", "()V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements b {
    @Override // com.tencent.qqnt.graytips.handler.b
    @NotNull
    public f a(@NotNull JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        return new ua2.a(jsonObject.optLong("tinyId", 0L));
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    @NotNull
    public JSONObject b(@NotNull f actionInfo) {
        ua2.a aVar;
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        if (actionInfo instanceof ua2.a) {
            aVar = (ua2.a) actionInfo;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tinyId", aVar.getTinyId());
            return jSONObject;
        }
        return new JSONObject();
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public void c(@NotNull AppRuntime app, @NotNull Context context, @NotNull f actionInfo, @Nullable gv3.a aioAbility) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        if (actionInfo instanceof ua2.a) {
            ((INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class)).launchNearbyPersonalFragment(context, ((ua2.a) actionInfo).getTinyId(), false, 18);
            j.c().e("InviteTacitFAQGrayTipActionHandler", actionInfo.toString());
        }
    }
}
