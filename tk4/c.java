package tk4;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Ltk4/c;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "", "b", "", "c", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "audiencePageParamsMap", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final c f436479c = new c();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ConcurrentHashMap<String, String> audiencePageParamsMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Ltk4/c$a;", "", "Ltk4/c;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Ltk4/c;", "a", "()Ltk4/c;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tk4.c$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final c a() {
            return c.f436479c;
        }

        Companion() {
        }
    }

    @NotNull
    public final ConcurrentHashMap<String, String> b() {
        ConcurrentHashMap<String, String> concurrentHashMap = this.audiencePageParamsMap;
        if (concurrentHashMap != null) {
            return new ConcurrentHashMap<>(concurrentHashMap);
        }
        return new ConcurrentHashMap<>();
    }

    public final void c() {
        this.audiencePageParamsMap = null;
    }
}
