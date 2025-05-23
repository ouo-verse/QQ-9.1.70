package uo4;

import com.tencent.mobileqq.app.BusinessObserver;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\"\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Luo4/e;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "guildId", "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "a", "troopUin", "b", "type", "", "isSuccess", "", "data", "onUpdate", "<init>", "()V", "d", "troop-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class e implements BusinessObserver {
    public void a(@NotNull String guildId, int permission) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
    }

    public void b(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        if (data instanceof Object[]) {
            Object[] objArr = (Object[]) data;
            if (objArr.length == 2) {
                Object obj = objArr[0];
                if ((obj instanceof String) && (objArr[1] instanceof Integer)) {
                    String valueOf = String.valueOf(obj);
                    Object obj2 = objArr[1];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    a(valueOf, ((Integer) obj2).intValue());
                }
            }
        }
    }
}
