package tz1;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.listitem.x.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003B\u001f\u0012\u0006\u0010\u0016\u001a\u00028\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Ltz1/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "L", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "view", "", "position", "", "", "payloads", "", "P", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Z", "getRightGrayed", "()Z", "V", "(Z)V", "rightGrayed", "left", "right", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/x$b;Lcom/tencent/mobileqq/widget/listitem/x$c$g;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b<L extends x.b> extends x<L, x.c.g> {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean rightGrayed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull L left, @NotNull x.c.g right, boolean z16) {
        super(left, right);
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        this.rightGrayed = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    /* renamed from: P */
    public void F(@NotNull QUISingleLineListItem view, int position, @NotNull List<? extends Object> payloads) {
        float f16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        if (!getGrayed() && getEnabled()) {
            if (this.rightGrayed) {
                f16 = 0.5f;
            } else {
                f16 = 1.0f;
            }
            view.findViewById(R.id.f66293a9).setAlpha(f16);
            view.findViewById(R.id.f66263a6).setAlpha(f16);
            view.findViewById(R.id.f66213a1).setAlpha(f16);
        }
    }

    public final void V(boolean z16) {
        this.rightGrayed = z16;
    }
}
