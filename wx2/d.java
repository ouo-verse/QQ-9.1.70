package wx2;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vx2.Definition;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lwx2/d;", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "Lvx2/a;", "a", "Lvx2/a;", "()Lvx2/a;", "currentDefinition", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "supportDefinition", "<init>", "(Lvx2/a;Ljava/util/List;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends com.tencent.biz.qqcircle.immersive.feed.event.h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Definition currentDefinition;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Definition> supportDefinition;

    public d(@NotNull Definition currentDefinition, @NotNull List<Definition> supportDefinition) {
        Intrinsics.checkNotNullParameter(currentDefinition, "currentDefinition");
        Intrinsics.checkNotNullParameter(supportDefinition, "supportDefinition");
        this.currentDefinition = currentDefinition;
        this.supportDefinition = supportDefinition;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Definition getCurrentDefinition() {
        return this.currentDefinition;
    }

    @NotNull
    public final List<Definition> b() {
        return this.supportDefinition;
    }
}
