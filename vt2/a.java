package vt2;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.listitem.x.b.d;
import com.tencent.mobileqq.widget.listitem.x.c.g;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0005B#\u0012\u0006\u0010\u001d\u001a\u00028\u0000\u0012\u0006\u0010\u001e\u001a\u00028\u0001\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\b\u0010\u0016\u001a\u0004\u0018\u00010\bR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lvt2/a;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "L", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/x;", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "W", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "view", "", "position", "", "", "payloads", "", "P", "V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/Integer;", "marginEndDp", "r", "Landroid/widget/LinearLayout;", "mFaceBoxLayout", "left", "right", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/x$b$d;Lcom/tencent/mobileqq/widget/listitem/x$c$g;Ljava/lang/Integer;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a<L extends x.b.d, R extends x.c.g> extends x<x.b.d, x.c.g> {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Integer marginEndDp;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mFaceBoxLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(L left, R right, Integer num) {
        super(left, right);
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        this.marginEndDp = num;
    }

    private final LinearLayout W(Context context) {
        int c16;
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.leftMargin = com.tencent.mobileqq.util.x.c(context, 12.0f);
        Integer num = this.marginEndDp;
        if (num != null) {
            c16 = num.intValue();
        } else {
            c16 = com.tencent.mobileqq.util.x.c(context, 12.0f);
        }
        marginLayoutParams.rightMargin = c16;
        linearLayout.setLayoutParams(marginLayoutParams);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    /* renamed from: P */
    public void F(QUISingleLineListItem view, int position, List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        LinearLayout linearLayout = this.mFaceBoxLayout;
        if (linearLayout != null) {
            if (linearLayout.getParent() instanceof ViewGroup) {
                ViewParent parent = linearLayout.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(this.mFaceBoxLayout);
            }
            view.f(linearLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    /* renamed from: Q */
    public QUISingleLineListItem H(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        this.mFaceBoxLayout = W(context);
        return super.H(parent);
    }

    /* renamed from: V, reason: from getter */
    public final LinearLayout getMFaceBoxLayout() {
        return this.mFaceBoxLayout;
    }
}
