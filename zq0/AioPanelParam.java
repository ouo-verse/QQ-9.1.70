package zq0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lzq0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "a", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "()Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "Lzq0/a;", "b", "Lzq0/a;", "()Lzq0/a;", "setStyleSheet", "(Lzq0/a;)V", "styleSheet", "<init>", "(Lcom/tencent/aio/part/root/panel/mvx/config/c;Lzq0/a;)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zq0.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class AioPanelParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.aio.part.root.panel.mvx.config.c panelParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private a styleSheet;

    public AioPanelParam(@NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam, @Nullable a aVar) {
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        this.panelParam = panelParam;
        this.styleSheet = aVar;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final com.tencent.aio.part.root.panel.mvx.config.c getPanelParam() {
        return this.panelParam;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final a getStyleSheet() {
        return this.styleSheet;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AioPanelParam)) {
            return false;
        }
        AioPanelParam aioPanelParam = (AioPanelParam) other;
        if (Intrinsics.areEqual(this.panelParam, aioPanelParam.panelParam) && Intrinsics.areEqual(this.styleSheet, aioPanelParam.styleSheet)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.panelParam.hashCode() * 31;
        a aVar = this.styleSheet;
        if (aVar == null) {
            hashCode = 0;
        } else {
            hashCode = aVar.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "AioPanelParam(panelParam=" + this.panelParam + ", styleSheet=" + this.styleSheet + ")";
    }

    public /* synthetic */ AioPanelParam(com.tencent.aio.part.root.panel.mvx.config.c cVar, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, (i3 & 2) != 0 ? null : aVar);
    }
}
