package zs;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"Lzs/a;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Runnable;", "runnable", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", h.F, "", "g", "", "e", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface a extends CoroutineContext {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: zs.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C11711a {
        @NotNull
        public static String a(@NotNull a aVar) {
            return "";
        }

        public static /* synthetic */ void b(a aVar, Runnable runnable, CoroutineScope coroutineScope, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    coroutineScope = GlobalScope.INSTANCE;
                }
                aVar.h(runnable, coroutineScope);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post");
        }
    }

    @NotNull
    String e();

    boolean g();

    void h(@NotNull Runnable runnable, @NotNull CoroutineScope scope);
}
