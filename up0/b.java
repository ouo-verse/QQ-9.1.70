package up0;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lup0/b;", "", "", "a", "I", "b", "()I", "maxSize", "", "Z", "()Z", "clearOnDestroy", "<init>", "(IZ)V", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean clearOnDestroy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002R\u0014\u0010\u0006\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lup0/b$a;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lup0/b;", "a", "TAG_EMOJI_REACTION_CACHE", "Ljava/lang/String;", "TAG_LEVEL_MEMBER_ROLE_CACHE", "TAG_MEMBER_ROLE_CACHE", "TAG_MEMBER_ROLE_COLOR_CACHE", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: up0.b$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConcurrentHashMap<String, b> a() {
            ConcurrentHashMap<String, b> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put("TAG_MEMBER_ROLE_CACHE", new b(30, true));
            concurrentHashMap.put("TAG_EMOJI_REACTION_CACHE", new b(50, true));
            concurrentHashMap.put("TAG_LEVEL_MEMBER_ROLE_CACHE", new b(30, true));
            concurrentHashMap.put("TAG_MEMBER_ROLE_COLOR_CACHE", new b(30, true));
            return concurrentHashMap;
        }

        Companion() {
        }
    }

    public b(int i3, boolean z16) {
        this.maxSize = i3;
        this.clearOnDestroy = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getClearOnDestroy() {
        return this.clearOnDestroy;
    }

    /* renamed from: b, reason: from getter */
    public final int getMaxSize() {
        return this.maxSize;
    }
}
