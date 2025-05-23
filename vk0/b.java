package vk0;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\t"}, d2 = {"Lvk0/b;", "", "", "event", "data", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "", "k", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface b {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, String str, String str2, com.tencent.zplan.zplantracing.c cVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    cVar = null;
                }
                bVar.k(str, str2, cVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatch");
        }
    }

    void k(@NotNull String event, @Nullable String data, @Nullable com.tencent.zplan.zplantracing.c zplanSpanContext);
}
