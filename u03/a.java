package u03;

import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.vas.ar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lu03/a;", "Lcom/tencent/cachedrawable/dynamicdrawable/business/cache/b;", "", "key", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "frameAnimData", "", "a", "b", "", "Z", "isUseSystemCache", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements com.tencent.cachedrawable.dynamicdrawable.business.cache.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isUseSystemCache = ar.INSTANCE.b("shouyouye", "2024-04-08", "vas_dynamic_cache_access_sys").isEnable(true);

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.cache.b
    public void a(@NotNull String key, @NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b frameAnimData) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(frameAnimData, "frameAnimData");
        if (this.isUseSystemCache) {
            com.tencent.qqnt.util.b.f362976b.isDebugVersion();
            ImageCacheHelper.f98636a.i(key, frameAnimData, com.tencent.cache.core.manager.api.c.f98725d.e());
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.cache.b
    @Nullable
    public com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b b(@NotNull String key) {
        Object g16;
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.isUseSystemCache && (g16 = ImageCacheHelper.f98636a.g(key)) != null) {
            if (!(g16 instanceof com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b)) {
                g16 = null;
            }
            if (g16 != null) {
                com.tencent.qqnt.util.b.f362976b.isDebugVersion();
                return (com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b) g16;
            }
        }
        return null;
    }
}
