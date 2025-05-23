package us2;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.listitem.x.b.d;
import com.tencent.mobileqq.widget.listitem.x.c.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0005B\u001f\u0012\u0006\u0010\u001a\u001a\u00028\u0000\u0012\u0006\u0010\u001b\u001a\u00028\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014J\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lus2/a;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "L", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "view", "", "position", "", "", "payloads", "", "P", "Landroid/widget/LinearLayout;", "V", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "r", "Landroid/widget/LinearLayout;", "rightContainer", "left", "right", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/x$b$d;Lcom/tencent/mobileqq/widget/listitem/x$c$g;Landroid/content/Context;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a<L extends x.b.d, R extends x.c.g> extends x<x.b.d, x.c.g> {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private LinearLayout rightContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(L left, R right, Context context) {
        super(left, right);
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.leftMargin = com.tencent.mobileqq.util.x.c(context, 12.0f);
        marginLayoutParams.rightMargin = com.tencent.mobileqq.util.x.c(context, 12.0f);
        linearLayout.setLayoutParams(marginLayoutParams);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.rightContainer = linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    /* renamed from: P */
    public void F(QUISingleLineListItem view, int position, List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        LinearLayout linearLayout = this.rightContainer;
        if (linearLayout != null) {
            if (linearLayout.getParent() instanceof ViewGroup) {
                ViewParent parent = linearLayout.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(this.rightContainer);
            }
            view.f(linearLayout);
        }
    }

    /* renamed from: V, reason: from getter */
    public final LinearLayout getRightContainer() {
        return this.rightContainer;
    }
}
