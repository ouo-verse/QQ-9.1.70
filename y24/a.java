package y24;

import com.tencent.freesia.IConfigData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Ly24/a;", "Lcom/tencent/freesia/IConfigData;", "", "robotUin", "", "b", "", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "whiteUinList", "<init>", "()V", "e", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> whiteUinList = new ArrayList();

    @NotNull
    public final List<String> a() {
        return this.whiteUinList;
    }

    public final boolean b(@NotNull String robotUin) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        return this.whiteUinList.contains(robotUin);
    }
}
