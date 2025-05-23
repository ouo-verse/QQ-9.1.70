package za;

import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\n\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lza/a;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "a", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "g", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;)V", "event", "", "b", "Z", "c", "()Z", "f", "(Z)V", "isClicked", "d", h.F, "isFirst", "e", "i", "isLast", "", "I", "()I", "j", "(I)V", NodeProps.MAX_WIDTH, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private CommonStTimeLineEvent event = new CommonStTimeLineEvent();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isClicked;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isFirst;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isLast;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int maxWidth;

    /* renamed from: a, reason: from getter */
    public final CommonStTimeLineEvent getEvent() {
        return this.event;
    }

    /* renamed from: b, reason: from getter */
    public final int getMaxWidth() {
        return this.maxWidth;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsClicked() {
        return this.isClicked;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsFirst() {
        return this.isFirst;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsLast() {
        return this.isLast;
    }

    public final void f(boolean z16) {
        this.isClicked = z16;
    }

    public final void g(CommonStTimeLineEvent commonStTimeLineEvent) {
        Intrinsics.checkNotNullParameter(commonStTimeLineEvent, "<set-?>");
        this.event = commonStTimeLineEvent;
    }

    public final void h(boolean z16) {
        this.isFirst = z16;
    }

    public final void i(boolean z16) {
        this.isLast = z16;
    }

    public final void j(int i3) {
        this.maxWidth = i3;
    }
}
