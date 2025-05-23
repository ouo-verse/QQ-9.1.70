package zx4;

import com.tencent.zplan.mod.data.ZPlanModRPCData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lzx4/p;", "", "Lcom/tencent/zplan/mod/data/a;", "msg", "Lux4/c;", "callback", "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface p {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        public static /* synthetic */ void a(p pVar, ZPlanModRPCData zPlanModRPCData, ux4.c cVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    cVar = null;
                }
                pVar.a(zPlanModRPCData, cVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMsg2Native");
        }
    }

    void a(@NotNull ZPlanModRPCData msg2, @Nullable ux4.c callback);
}
