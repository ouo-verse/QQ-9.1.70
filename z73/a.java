package z73;

import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lz73/a;", "", "", "a", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f452126a = new a();

    a() {
    }

    public final boolean a() {
        if (!((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_publish_add_yours", "exp_xsj_publish_add_yours_B") && !((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_publish_add_yours", "exp_xsj_publish_add_yours_C")) {
            return false;
        }
        return true;
    }
}
