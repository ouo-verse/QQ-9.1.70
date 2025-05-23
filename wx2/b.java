package wx2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vx2.Definition;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lwx2/b;", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "Lvx2/a;", "a", "Lvx2/a;", "()Lvx2/a;", "definition", "<init>", "(Lvx2/a;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends com.tencent.biz.qqcircle.immersive.feed.event.h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Definition definition;

    public b(@NotNull Definition definition) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        this.definition = definition;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Definition getDefinition() {
        return this.definition;
    }
}
