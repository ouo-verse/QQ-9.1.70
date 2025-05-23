package u03;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import t03.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lu03/d;", "Lcom/tencent/cachedrawable/dynamicdrawable/business/dynamicInit/b;", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "a", "", "b", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d implements com.tencent.cachedrawable.dynamicdrawable.business.dynamicInit.b {
    @Override // com.tencent.cachedrawable.dynamicdrawable.business.dynamicInit.b
    @NotNull
    public com.tencent.cachedrawable.dynamicdrawable.e a() {
        return g.f435275a;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.dynamicInit.b
    @NotNull
    public String b() {
        String absolutePath = MobileQQ.sMobileQQ.getCacheDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "sMobileQQ.cacheDir.absolutePath");
        return absolutePath;
    }
}
