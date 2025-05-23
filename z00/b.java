package z00;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 A2\u00020\u0001:\u0001BB\u000f\u0012\u0006\u0010>\u001a\u00020\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\nJ\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0016R\u001c\u0010!\u001a\n \u001f*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R\u001e\u0010$\u001a\n \u001f*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010#R\u001e\u0010'\u001a\n \u001f*\u0004\u0018\u00010%0%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010&R\u001e\u0010)\u001a\n \u001f*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010#R\u001e\u0010*\u001a\n \u001f*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010#R\u001e\u0010+\u001a\n \u001f*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010#R\u0018\u0010.\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R$\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010=\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b;\u00100\u001a\u0004\b(\u0010<\u00a8\u0006C"}, d2 = {"Lz00/b;", "Landroid/view/View$OnClickListener;", "", "c", "rightIconSpace", "", "b", "Landroid/view/View;", "view", "g", "", "isBlack", "e", "offset", "o", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewPropertyAnimator;", "animator", "d", "i", "f", "p", "", "title", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "show", "l", "k", "v", NodeProps.ON_CLICK, "kotlin.jvm.PlatformType", "Landroid/view/View;", "toolbar", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "ivBack", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvTitle", h.F, "ivShare", "ivFeedback", "ivDetail", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewPropertyAnimator;", "toolbarTextAnimator", "D", "Z", "isToolbarTextShown", "Lz00/c;", "E", "Lz00/c;", "getOnToolbarItemClickListener", "()Lz00/c;", "j", "(Lz00/c;)V", "onToolbarItemClickListener", "<set-?>", UserInfo.SEX_FEMALE, "()Z", "isToolbarIconBlack", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;)V", "G", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements View.OnClickListener {
    private static final float H;
    private static final float I;

    /* renamed from: C, reason: from kotlin metadata */
    private ViewPropertyAnimator toolbarTextAnimator;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isToolbarTextShown;

    /* renamed from: E, reason: from kotlin metadata */
    private c onToolbarItemClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isToolbarIconBlack;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View toolbar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBack;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView ivShare;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView ivFeedback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView ivDetail;
    private static final int J = ScreenUtil.dip2px(160.0f);

    static {
        float dip2px = ScreenUtil.dip2px(112.0f) - ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
        H = dip2px;
        I = dip2px * 0.6f;
    }

    public b(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.p6p);
        this.toolbar = findViewById;
        this.ivBack = (ImageView) rootView.findViewById(R.id.p4r);
        this.tvTitle = (TextView) rootView.findViewById(R.id.p8_);
        this.ivShare = (ImageView) rootView.findViewById(R.id.p4u);
        this.ivFeedback = (ImageView) rootView.findViewById(R.id.p4t);
        this.ivDetail = (ImageView) rootView.findViewById(R.id.p4s);
        this.ivBack.setOnClickListener(this);
        this.ivFeedback.setOnClickListener(this);
        this.ivShare.setOnClickListener(this);
        this.ivDetail.setOnClickListener(this);
        findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop() + ImmersiveUtils.getStatusBarHeight(findViewById.getContext()), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        o(0);
        this.tvTitle.setAlpha(0.0f);
        this.tvTitle.setHorizontallyScrolling(false);
        e(false);
    }

    private final void b(int rightIconSpace) {
        float width;
        int width2;
        int width3 = this.toolbar.getWidth() - (rightIconSpace * 2);
        if (((int) this.tvTitle.getPaint().measureText(this.tvTitle.getText().toString())) <= width3) {
            width = (this.toolbar.getWidth() - r5) / 2.0f;
            width2 = this.ivBack.getWidth();
        } else {
            width = (this.toolbar.getWidth() - width3) / 2.0f;
            width2 = this.ivBack.getWidth();
        }
        float f16 = width - width2;
        TextView textView = this.tvTitle;
        textView.setPadding((int) f16, textView.getPaddingTop(), this.tvTitle.getPaddingRight(), this.tvTitle.getPaddingBottom());
    }

    private final int c() {
        int paddingRight = this.toolbar.getPaddingRight();
        if (this.ivDetail.getVisibility() == 0) {
            paddingRight += g(this.ivDetail);
        }
        if (this.ivFeedback.getVisibility() == 0) {
            paddingRight += g(this.ivFeedback);
        }
        return this.ivShare.getVisibility() == 0 ? paddingRight + g(this.ivShare) : paddingRight;
    }

    private final void e(boolean isBlack) {
        if (!e00.b.b() && isBlack) {
            this.ivBack.setImageResource(R.drawable.qb_public_account_readinjoy_weishi_back_black);
            this.ivShare.setImageResource(R.drawable.f159774go2);
            this.ivFeedback.setImageResource(R.drawable.glr);
            this.ivDetail.setImageResource(R.drawable.crg);
            return;
        }
        this.ivBack.setImageResource(R.drawable.dts);
        this.ivShare.setImageResource(R.drawable.f159775go3);
        this.ivFeedback.setImageResource(R.drawable.glt);
        this.ivDetail.setImageResource(R.drawable.skin_header_icon_single_aio_detheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b(this$0.c());
    }

    private final void r(int offset) {
        boolean z16;
        int i3 = J;
        if (offset <= i3 && this.isToolbarTextShown) {
            z16 = false;
        } else if (offset <= i3 || this.isToolbarTextShown) {
            return;
        } else {
            z16 = true;
        }
        d(this.toolbarTextAnimator);
        this.isToolbarTextShown = z16;
        ViewPropertyAnimator duration = this.tvTitle.animate().alpha(z16 ? 1.0f : 0.0f).setDuration(200L);
        duration.start();
        this.toolbarTextAnimator = duration;
    }

    public final int f() {
        return this.toolbar.getMeasuredHeight();
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsToolbarIconBlack() {
        return this.isToolbarIconBlack;
    }

    public final void i() {
        this.toolbar.measure(0, 0);
    }

    public final void j(c cVar) {
        this.onToolbarItemClickListener = cVar;
    }

    public final void k(boolean show) {
        this.ivDetail.setVisibility(show ? 0 : 8);
    }

    public final void l(boolean show) {
        this.ivFeedback.setVisibility(show ? 0 : 8);
    }

    public final void m(String title) {
        this.tvTitle.setText(title);
        this.tvTitle.post(new Runnable() { // from class: z00.a
            @Override // java.lang.Runnable
            public final void run() {
                b.n(b.this);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        c cVar;
        if (Intrinsics.areEqual(v3, this.ivBack)) {
            c cVar2 = this.onToolbarItemClickListener;
            if (cVar2 != null) {
                cVar2.onBackClick();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(v3, this.ivShare)) {
            c cVar3 = this.onToolbarItemClickListener;
            if (cVar3 != null) {
                cVar3.b();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(v3, this.ivFeedback)) {
            c cVar4 = this.onToolbarItemClickListener;
            if (cVar4 != null) {
                cVar4.a();
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(v3, this.ivDetail) || (cVar = this.onToolbarItemClickListener) == null) {
            return;
        }
        cVar.c();
    }

    public final void p(int offset) {
        o(offset);
        q(offset);
        r(offset);
    }

    private final void o(int offset) {
        float f16 = offset;
        float f17 = H;
        float f18 = f16 < f17 ? (f16 * 1.0f) / f17 : 1.0f;
        Drawable background = this.toolbar.getBackground();
        if (background != null) {
            background.mutate().setAlpha((int) (f18 * 255));
        }
    }

    private final void q(int offset) {
        boolean z16;
        float f16 = offset;
        float f17 = I;
        if (f16 <= f17 && this.isToolbarIconBlack) {
            z16 = false;
        } else if (f16 <= f17 || this.isToolbarIconBlack) {
            return;
        } else {
            z16 = true;
        }
        this.isToolbarIconBlack = z16;
        e(z16);
    }

    private final void d(ViewPropertyAnimator animator) {
        if (animator != null) {
            animator.cancel();
        }
    }

    private final int g(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }
}
