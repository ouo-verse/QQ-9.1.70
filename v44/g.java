package v44;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001*B'\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\u0002R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lv44/g;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "", "r0", "", "I", "Landroid/graphics/Bitmap;", "preView", "s0", "w0", "", "J0", UserInfo.SEX_FEMALE, "getMarginBottom", "()F", NodeProps.MARGIN_BOTTOM, "K0", "getMarginHorizontal", NodeProps.MARGIN_HORIZONTAL, "L0", "getMarginTop", NodeProps.MARGIN_TOP, "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;", "M0", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;", "getParam", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;", "param", "N0", "Landroid/graphics/Bitmap;", "getMPreView", "()Landroid/graphics/Bitmap;", "setMPreView", "(Landroid/graphics/Bitmap;)V", "mPreView", "Landroid/widget/ImageView;", "O0", "Landroid/widget/ImageView;", "loadingView", "<init>", "(FFFLcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;)V", "P0", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g extends ShareActionSheetV2 {

    /* renamed from: J0, reason: from kotlin metadata */
    private final float marginBottom;

    /* renamed from: K0, reason: from kotlin metadata */
    private final float marginHorizontal;

    /* renamed from: L0, reason: from kotlin metadata */
    private final float marginTop;

    /* renamed from: M0, reason: from kotlin metadata */
    @NotNull
    private final ShareActionSheetV2.Param param;

    /* renamed from: N0, reason: from kotlin metadata */
    @Nullable
    private Bitmap mPreView;

    /* renamed from: O0, reason: from kotlin metadata */
    @Nullable
    private ImageView loadingView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(float f16, float f17, float f18, @NotNull ShareActionSheetV2.Param param) {
        super(param);
        Intrinsics.checkNotNullParameter(param, "param");
        this.marginBottom = f16;
        this.marginHorizontal = f17;
        this.marginTop = f18;
        this.param = param;
    }

    private final void r0() {
        Context context;
        ConstraintLayout constraintLayout = (ConstraintLayout) this.G.findViewById(R.id.f84204lm);
        if (constraintLayout == null || (context = this.f317430e.get()) == null) {
            return;
        }
        ImageView imageView = new ImageView(context);
        this.loadingView = imageView;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(c24.a.a(20), c24.a.a(20));
        layoutParams.startToStart = 0;
        layoutParams.topToTop = 0;
        layoutParams.endToEnd = 0;
        layoutParams.bottomToBottom = 0;
        imageView.setLayoutParams(layoutParams);
        ImageView imageView2 = this.loadingView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(LoadingUtil.getLoadingDrawable(context, 2));
        }
        constraintLayout.addView(this.loadingView, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(final g this$0, DialogInterface dialogInterface) {
        ConstraintLayout constraintLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.G;
        if (view != null && (constraintLayout = (ConstraintLayout) view.findViewById(R.id.f84204lm)) != null) {
            int i3 = 0;
            constraintLayout.setVisibility(0);
            Context context = this$0.f317430e.get();
            if (context != null) {
                Intrinsics.checkNotNullExpressionValue(context, "mContextWeakRef.get() ?: return@let");
                ImageView imageView = new ImageView(context);
                imageView.setImageBitmap(this$0.mPreView);
                Bitmap bitmap = this$0.mPreView;
                if (bitmap != null) {
                    i3 = bitmap.hashCode();
                }
                QLog.i("robot.qr.ShareActionSheetWithPreView", 1, "preView hashMap " + i3);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(ViewUtils.dpToPx(this$0.marginHorizontal), ViewUtils.dpToPx(this$0.marginTop) + ImmersiveUtils.getStatusBarHeight(context), ViewUtils.dpToPx(this$0.marginHorizontal), ViewUtils.dpToPx(this$0.marginBottom));
                constraintLayout.addView(imageView, layoutParams);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: v44.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        g.u0(view2);
                    }
                });
                constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: v44.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        g.v0(g.this, view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2
    protected int I() {
        return R.layout.e3l;
    }

    public final void s0(@Nullable Bitmap preView) {
        int i3;
        this.mPreView = preView;
        if (preView != null) {
            i3 = preView.hashCode();
        } else {
            i3 = 0;
        }
        QLog.i("robot.qr.ShareActionSheetWithPreView", 1, "set preView hashMap " + i3);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: v44.d
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                g.t0(g.this, dialogInterface);
            }
        });
    }

    public final void w0() {
        if (this.loadingView == null) {
            r0();
        }
        ImageView imageView = this.loadingView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }
}
