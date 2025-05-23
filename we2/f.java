package we2;

import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lwe2/f;", "", "", "b", "a", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f445549a = new f();

    f() {
    }

    public final boolean a() {
        return ((Number) ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).getAladdinConfig(633, "ecomerence_metric_enable", 0)).intValue() == 1;
    }

    public final boolean b() {
        return ((Number) ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).getAladdinConfig(633, "ecomerence_trace_enable", 0)).intValue() == 1;
    }
}
