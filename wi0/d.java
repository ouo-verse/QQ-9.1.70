package wi0;

import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.biz.productcenter.fragment.ECSelectProductFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lwi0/d;", "Lwi0/a;", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "fragment", "", "accept", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class d extends a {
    @Override // com.tencent.ecommerce.base.router.api.IECRouterFilter
    public boolean accept(Class<? extends Fragment> fragment) {
        return Intrinsics.areEqual(fragment, ECSelectProductFragment.class);
    }
}
