package ue;

import com.qzone.reborn.feedpro.widget.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lue/b;", "", "Lcom/qzone/reborn/feedpro/widget/l;", "a", "Lcom/qzone/reborn/feedpro/widget/l;", "b", "()Lcom/qzone/reborn/feedpro/widget/l;", "startItem", "endItem", "<init>", "(Lcom/qzone/reborn/feedpro/widget/l;Lcom/qzone/reborn/feedpro/widget/l;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final l startItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final l endItem;

    public b(l startItem, l endItem) {
        Intrinsics.checkNotNullParameter(startItem, "startItem");
        Intrinsics.checkNotNullParameter(endItem, "endItem");
        this.startItem = startItem;
        this.endItem = endItem;
    }

    /* renamed from: a, reason: from getter */
    public final l getEndItem() {
        return this.endItem;
    }

    /* renamed from: b, reason: from getter */
    public final l getStartItem() {
        return this.startItem;
    }
}
