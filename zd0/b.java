package zd0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\b\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0014\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0014R\u001a\u0010\u0019\u001a\u00020\u00148\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lzd0/b;", "T", "Lzd0/a;", "Lcom/tencent/biz/qui/noticebar/a;", "", "msg", "Landroid/view/View$OnClickListener;", "onClickListener", "b", "(Ljava/lang/String;Landroid/view/View$OnClickListener;)Ljava/lang/Object;", "", "msgRes", "f", "(ILandroid/view/View$OnClickListener;)Ljava/lang/Object;", "Lyd0/a;", "res", "w", "(Lyd0/a;)Ljava/lang/Object;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "y", "()Landroid/widget/TextView;", "linkBtnView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lyd0/a;)V", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public abstract class b<T> extends a<T> implements com.tencent.biz.qui.noticebar.a<T> {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView linkBtnView;

    public /* synthetic */ b(Context context, yd0.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? new yd0.a(context) : aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qui.noticebar.a
    public T b(@Nullable String msg2, @Nullable View.OnClickListener onClickListener) {
        this.linkBtnView.setText(msg2);
        if (msg2 == null) {
            this.linkBtnView.setVisibility(8);
        } else {
            this.linkBtnView.setVisibility(0);
            this.linkBtnView.setOnClickListener(onClickListener);
        }
        m();
        return this;
    }

    @Override // com.tencent.biz.qui.noticebar.a
    public T f(int msgRes, @Nullable View.OnClickListener onClickListener) {
        String string;
        if (msgRes == 0) {
            string = null;
        } else {
            string = getContext().getString(msgRes);
        }
        return b(string, onClickListener);
    }

    @Override // zd0.a
    protected void m() {
        if (getRightIconView().getVisibility() == 8) {
            if (this.linkBtnView.getVisibility() == 8) {
                ViewGroup.LayoutParams layoutParams = getMsgView().getLayoutParams();
                if (layoutParams != null) {
                    ((LinearLayout.LayoutParams) layoutParams).setMarginEnd(com.tencent.biz.qui.quicommon.e.c(16.0f));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            ViewGroup.LayoutParams layoutParams2 = this.linkBtnView.getLayoutParams();
            if (layoutParams2 != null) {
                ((LinearLayout.LayoutParams) layoutParams2).setMarginEnd(com.tencent.biz.qui.quicommon.e.c(16.0f));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        if (this.linkBtnView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams3 = getMsgView().getLayoutParams();
            if (layoutParams3 != null) {
                ((LinearLayout.LayoutParams) layoutParams3).setMarginEnd(0);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        ViewGroup.LayoutParams layoutParams4 = this.linkBtnView.getLayoutParams();
        if (layoutParams4 != null) {
            ((LinearLayout.LayoutParams) layoutParams4).setMarginEnd(0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // zd0.a
    public T w(@NotNull yd0.a res) {
        Intrinsics.checkNotNullParameter(res, "res");
        this.linkBtnView.setTextColor(res.f());
        return (T) super.w(res);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: y, reason: from getter */
    public final TextView getLinkBtnView() {
        return this.linkBtnView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Context context, @NotNull yd0.a res) {
        super(context, res);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(res, "res");
        TextView textView = new TextView(context);
        textView.setTextSize(14.0f);
        textView.setTextColor(res.f());
        textView.setLines(1);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.setMarginStart(com.tencent.biz.qui.quicommon.e.c(8.0f));
        layoutParams.gravity = 16;
        Unit unit = Unit.INSTANCE;
        textView.setLayoutParams(layoutParams);
        textView.setVisibility(8);
        getContentLayout().addView(textView, 2);
        this.linkBtnView = textView;
    }
}
