package t14;

import com.google.gson.annotations.SerializedName;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lt14/b;", "", "", "loopInterval", "J", "b", "()J", "setLoopInterval", "(J)V", "", "Lt14/e;", VideoTemplateParser.ITEM_LIST, "Ljava/util/List;", "a", "()Ljava/util/List;", "c", "(Ljava/util/List;)V", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {

    @SerializedName("content")
    @NotNull
    private List<e> itemList;

    @SerializedName("loop_interval")
    private long loopInterval = 5000;

    public b() {
        List<e> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.itemList = emptyList;
    }

    @NotNull
    public final List<e> a() {
        return this.itemList;
    }

    /* renamed from: b, reason: from getter */
    public final long getLoopInterval() {
        return this.loopInterval;
    }

    public final void c(@NotNull List<e> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.itemList = list;
    }
}
