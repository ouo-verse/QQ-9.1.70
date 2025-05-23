package ws2;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J,\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J0\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0017j\b\u0012\u0004\u0012\u00020\u000e`\u0018H\u0014J\"\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016\u00a8\u0006\u001f"}, d2 = {"Lws2/b;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "Lmqq/observer/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "e", "f", "d", "onUpdate", "", "cmd", "errorCode", "", SquareJSConst.Params.PARAMS_UIN_LIST, "b", "Lcom/tencent/mobileqq/troop/troopgag/data/a;", "gagStatusInfo", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Landroid/os/Bundle;", "bundle", "onReceive", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class b implements BusinessObserver, mqq.observer.BusinessObserver {
    protected void a(boolean isSuccess, int errorCode, ArrayList<String> uinList) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        e(type, isSuccess, data);
        f(type, isSuccess, data);
        d(type, isSuccess, data);
    }

    private final void d(int type, boolean isSuccess, Object data) {
        if (type == 3 && (data instanceof Object[])) {
            Object[] objArr = (Object[]) data;
            if (objArr instanceof Object[]) {
                Object obj = objArr[0];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) obj).intValue();
                Object obj2 = objArr[1];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                a(isSuccess, intValue, (ArrayList) obj2);
            }
        }
    }

    private final void e(int type, boolean isSuccess, Object data) {
        if (type == 1 && (data instanceof Object[])) {
            Object[] objArr = (Object[]) data;
            if (objArr instanceof Object[]) {
                Object obj = objArr[0];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                Object obj2 = objArr[1];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) obj2).intValue();
                Object obj3 = objArr[2];
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.LongArray");
                b(isSuccess, (String) obj, intValue, (long[]) obj3);
            }
        }
    }

    private final void f(int type, boolean isSuccess, Object data) {
        if (type != 2) {
            return;
        }
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.tencent.mobileqq.troop.troopgag.data.GagStatus");
        c((com.tencent.mobileqq.troop.troopgag.data.a) data);
    }

    protected void c(com.tencent.mobileqq.troop.troopgag.data.a gagStatusInfo) {
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int type, boolean isSuccess, Bundle bundle) {
    }

    protected void b(boolean isSuccess, String cmd, int errorCode, long[] uinList) {
    }
}
