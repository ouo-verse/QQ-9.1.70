package zh1;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Lzh1/b;", "", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "a", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "feedsCardPool", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f452544a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lzh1/b$a;", "", "Lzh1/b;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zh1.b$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f452544a = new Companion();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"zh1/b$a$a", "Lzh1/b;", "Lxh1/b;", "b", "Lxh1/b;", "()Lxh1/b;", "feedsCardPool", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: zh1.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C11681a implements b {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final xh1.b feedsCardPool = new xh1.b();

            C11681a() {
            }

            @Override // zh1.b
            @NotNull
            /* renamed from: b, reason: from getter and merged with bridge method [inline-methods] */
            public xh1.b a() {
                return this.feedsCardPool;
            }
        }

        Companion() {
        }

        @NotNull
        public final b a() {
            return new C11681a();
        }
    }

    @NotNull
    RecyclerView.RecycledViewPool a();
}
