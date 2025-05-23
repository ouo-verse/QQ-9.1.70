package zd0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.tencent.biz.qui.noticebar.view.VQUINoticeBarLayout;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0019\u0012\u0006\u0010a\u001a\u00020\\\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\bg\u0010hJ\u001f\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0004J\u0019\u0010\f\u001a\u00028\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00028\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00028\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\bH\u0014J\u0019\u0010\u0017\u001a\u00028\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0015J\b\u0010\u0018\u001a\u00020\bH\u0014J\u0017\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\bH\u0004J\u0017\u0010 \u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u001eH\u0014\u00a2\u0006\u0004\b \u0010!J\b\u0010#\u001a\u00020\"H\u0016R\u001a\u0010(\u001a\u00020$8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010.\u001a\u00020)8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u00103\u001a\u00020/8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0014\u00100\u001a\u0004\b1\u00102R\u001a\u00109\u001a\u0002048\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001a\u0010>\u001a\u00020:8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010C\u001a\u00020\"8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\"\u0010E\u001a\u00020\u00198\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\b\f\u0010MR\"\u0010T\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010X\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010O\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR\u0014\u0010[\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010ZR\u001a\u0010a\u001a\u00020\\8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\"\u0010\u001f\u001a\u00020\u001e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010f\u00a8\u0006i"}, d2 = {"Lzd0/a;", "T", "Lcom/tencent/biz/qui/noticebar/b;", "", "sizeDp", "startDp", "a", "(FF)Ljava/lang/Object;", "", "v", "", "msg", "setMsg", "(Ljava/lang/String;)Ljava/lang/Object;", "", "msgId", "e", "(I)Ljava/lang/Object;", "Landroid/view/View$OnClickListener;", "clickListener", "c", "(Landroid/view/View$OnClickListener;)Ljava/lang/Object;", HippyTKDListViewAdapter.X, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "g", "(Z)Ljava/lang/Object;", "u", "Lyd0/a;", "res", "w", "(Lyd0/a;)Ljava/lang/Object;", "Landroid/view/View;", "getView", "Lcom/tencent/biz/qui/noticebar/view/VQUINoticeBarLayout;", "Lcom/tencent/biz/qui/noticebar/view/VQUINoticeBarLayout;", "getRoot", "()Lcom/tencent/biz/qui/noticebar/view/VQUINoticeBarLayout;", "root", "Landroid/widget/LinearLayout;", "b", "Landroid/widget/LinearLayout;", DomainData.DOMAIN_NAME, "()Landroid/widget/LinearLayout;", "contentLayout", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "r", "()Landroid/widget/TextView;", "msgView", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "p", "()Landroid/widget/FrameLayout;", "iconLayout", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "t", "()Landroid/widget/ImageView;", "rightIconView", "f", "Landroid/view/View;", "getSplitView", "()Landroid/view/View;", "splitView", "Z", "isContentBgTransparent", "()Z", "setContentBgTransparent", "(Z)V", h.F, "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "i", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()I", "setIconLayoutSize", "(I)V", "iconLayoutSize", "j", "getIconLayoutStartX", "setIconLayoutStartX", "iconLayoutStartX", "Lcom/tencent/theme/SkinnableView;", "Lcom/tencent/theme/SkinnableView;", "delegateSkinnableView", "Landroid/content/Context;", "l", "Landroid/content/Context;", "o", "()Landroid/content/Context;", "context", "Lyd0/a;", ReportConstant.COSTREPORT_PREFIX, "()Lyd0/a;", "setRes", "(Lyd0/a;)V", "<init>", "(Landroid/content/Context;Lyd0/a;)V", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public abstract class a<T> implements com.tencent.biz.qui.noticebar.b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VQUINoticeBarLayout root;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout contentLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView msgView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout iconLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView rightIconView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View splitView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isContentBgTransparent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String msg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int iconLayoutSize;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int iconLayoutStartX;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final SkinnableView delegateSkinnableView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private yd0.a res;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "onThemeChanged"}, k = 3, mv = {1, 4, 2})
    /* renamed from: zd0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C11674a implements SkinnableView {
        C11674a() {
        }

        @Override // com.tencent.theme.SkinnableView
        public final void onThemeChanged() {
            a aVar = a.this;
            aVar.w(aVar.getRes());
        }
    }

    public a(@NotNull Context context, @NotNull yd0.a res) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(res, "res");
        this.context = context;
        this.res = res;
        this.iconLayoutSize = com.tencent.biz.qui.quicommon.e.c(48.0f);
        this.iconLayoutStartX = com.tencent.biz.qui.quicommon.e.c(4.0f);
        SkinnableView c11674a = new C11674a();
        this.delegateSkinnableView = c11674a;
        VQUINoticeBarLayout vQUINoticeBarLayout = new VQUINoticeBarLayout(context);
        vQUINoticeBarLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, com.tencent.biz.qui.quicommon.e.c(48.0f)));
        vQUINoticeBarLayout.setTag(R.id.f66623b5, this);
        vQUINoticeBarLayout.setTag(R.id.f66633b6, Integer.valueOf(j()));
        vQUINoticeBarLayout.setDelegate(c11674a);
        Unit unit = Unit.INSTANCE;
        this.root = vQUINoticeBarLayout;
        View view = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.tencent.biz.qui.quicommon.e.c(0.5f));
        layoutParams.gravity = 80;
        view.setLayoutParams(layoutParams);
        vQUINoticeBarLayout.addView(view);
        view.setVisibility(8);
        this.splitView = view;
        LinearLayout linearLayout = new LinearLayout(context);
        if (!this.isContentBgTransparent) {
            linearLayout.setBackground(this.res.c());
        }
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        vQUINoticeBarLayout.addView(linearLayout);
        this.contentLayout = linearLayout;
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.iconLayoutSize, -1);
        layoutParams2.setMarginStart(this.iconLayoutStartX);
        layoutParams2.gravity = 16;
        frameLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(frameLayout);
        this.iconLayout = frameLayout;
        TextView textView = new TextView(context);
        textView.setText(this.msg);
        textView.setTextSize(14.0f);
        textView.setLines(1);
        textView.setGravity(8388627);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.res.g());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 1.0f;
        layoutParams3.gravity = 16;
        textView.setLayoutParams(layoutParams3);
        linearLayout.addView(textView);
        this.msgView = textView;
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int c16 = com.tencent.biz.qui.quicommon.e.c(40.0f);
        imageView.setPaddingRelative(com.tencent.biz.qui.quicommon.e.c(8.0f), 0, com.tencent.biz.qui.quicommon.e.c(16.0f), 0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(c16, -1);
        layoutParams4.gravity = 16;
        imageView.setLayoutParams(layoutParams4);
        imageView.setVisibility(8);
        linearLayout.addView(imageView);
        this.rightIconView = imageView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qui.noticebar.b
    public T a(float sizeDp, float startDp) {
        this.iconLayoutSize = com.tencent.biz.qui.quicommon.e.c(sizeDp);
        this.iconLayoutStartX = com.tencent.biz.qui.quicommon.e.c(startDp);
        v();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qui.noticebar.b
    public T c(@Nullable View.OnClickListener clickListener) {
        this.contentLayout.setOnClickListener(clickListener);
        x();
        u();
        m();
        return this;
    }

    @Override // com.tencent.biz.qui.noticebar.b
    public T e(@StringRes int msgId) {
        String string;
        if (msgId == 0) {
            string = null;
        } else {
            string = this.context.getString(msgId);
        }
        return setMsg(string);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qui.noticebar.b
    public T g(boolean isTransparent) {
        this.isContentBgTransparent = isTransparent;
        u();
        return this;
    }

    @Override // com.tencent.biz.qui.noticebar.b
    @NotNull
    public View getView() {
        return this.root;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qui.noticebar.b
    public T k(@Nullable View.OnClickListener clickListener) {
        this.rightIconView.setOnClickListener(clickListener);
        u();
        x();
        m();
        return this;
    }

    protected void m() {
        if (this.rightIconView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = this.msgView.getLayoutParams();
            if (layoutParams != null) {
                ((LinearLayout.LayoutParams) layoutParams).setMarginEnd(com.tencent.biz.qui.quicommon.e.c(16.0f));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        ViewGroup.LayoutParams layoutParams2 = this.msgView.getLayoutParams();
        if (layoutParams2 != null) {
            ((LinearLayout.LayoutParams) layoutParams2).setMarginEnd(0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: n, reason: from getter */
    public final LinearLayout getContentLayout() {
        return this.contentLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: o, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: p, reason: from getter */
    public final FrameLayout getIconLayout() {
        return this.iconLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: q, reason: from getter */
    public final int getIconLayoutSize() {
        return this.iconLayoutSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: r, reason: from getter */
    public final TextView getMsgView() {
        return this.msgView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: s, reason: from getter */
    public final yd0.a getRes() {
        return this.res;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qui.noticebar.b
    public T setMsg(@Nullable String msg2) {
        this.msg = msg2;
        this.msgView.setText(msg2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: t, reason: from getter */
    public final ImageView getRightIconView() {
        return this.rightIconView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u() {
        if (this.isContentBgTransparent) {
            this.contentLayout.setBackground(null);
        } else if (this.contentLayout.hasOnClickListeners()) {
            this.contentLayout.setBackground(yd0.b.f450165a.d(this.res.c(), this.res.h()));
        } else {
            this.contentLayout.setBackground(this.res.c());
        }
    }

    protected final void v() {
        ViewGroup.LayoutParams layoutParams = this.iconLayout.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = this.iconLayoutSize;
            layoutParams2.setMarginStart(this.iconLayoutStartX);
            this.iconLayout.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public T w(@NotNull yd0.a res) {
        Intrinsics.checkNotNullParameter(res, "res");
        this.res = res;
        if (this.splitView.getVisibility() == 0) {
            this.splitView.setBackgroundColor(res.i());
        }
        this.msgView.setTextColor(res.g());
        u();
        x();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
        if (this.rightIconView.hasOnClickListeners()) {
            this.rightIconView.setVisibility(0);
            this.rightIconView.setImageDrawable(this.res.b());
        } else if (this.contentLayout.hasOnClickListeners()) {
            this.rightIconView.setVisibility(0);
            this.rightIconView.setImageDrawable(this.res.a());
        } else {
            this.rightIconView.setVisibility(8);
        }
    }
}
