package u54;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import x64.m;
import x64.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J#\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lu54/b;", "Lml3/b;", "T", "Ljava/lang/Class;", "clazz", "Lml3/a;", "a", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "", "Ljava/util/Map;", "servicePool", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements ml3.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Class<?>, ml3.a<?>> servicePool;

    public b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.servicePool = linkedHashMap;
        linkedHashMap.put(m.class, new n());
    }

    @Override // ml3.b
    @NotNull
    public <T> ml3.a<T> a(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Object obj = this.servicePool.get(clazz);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mvi.api.business.IEmitterRegister<T of com.tencent.robot.slash.dialog.SlashDialogEmitterService.fetchEmitter>");
        return (ml3.a) obj;
    }

    @Override // ml3.b
    public <T> T b(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.servicePool.get(clazz);
    }
}
