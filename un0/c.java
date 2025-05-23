package un0;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.guild.aio.component.plus.GuildAioPlusUIState;
import com.tencent.guild.aio.util.ex.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import un0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006%"}, d2 = {"Lun0/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lun0/a;", "Lcom/tencent/guild/aio/component/plus/GuildAioPlusUIState;", "", "show", "", "j1", "panelShowing", "i1", "g1", "Lcom/tencent/mvi/api/help/a;", "params", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "bindViewAndData", "state", "d1", NodeProps.VISIBLE, "h1", "e1", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mPlusLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mPlusImage", "f", "mPlusRedDot", "<init>", "()V", h.F, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<a, GuildAioPlusUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mPlusLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mPlusImage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mPlusRedDot;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(c this$0, View view) {
        boolean z16;
        com.tencent.aio.api.runtime.a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameworkVM mUIModel = this$0.getMUIModel();
        boolean z17 = true;
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && com.tencent.guild.aio.util.d.a(aVar)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this$0.g1();
            this$0.sendIntent(new a.b());
            ImageView imageView = this$0.mPlusRedDot;
            if (imageView == null || imageView.getVisibility() != 0) {
                z17 = false;
            }
            if (z17) {
                ImageView imageView2 = this$0.mPlusRedDot;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setPlusBtnRobotDotHasShow();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g1() {
        HashMap hashMap = new HashMap();
        ImageView imageView = this.mPlusImage;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusImage");
            imageView = null;
        }
        VideoReport.setElementId(imageView, "em_aio_plus");
        ImageView imageView3 = this.mPlusImage;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusImage");
            imageView3 = null;
        }
        VideoReport.setElementExposePolicy(imageView3, ExposurePolicy.REPORT_ALL);
        ImageView imageView4 = this.mPlusImage;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusImage");
            imageView4 = null;
        }
        VideoReport.setElementClickPolicy(imageView4, ClickPolicy.REPORT_ALL);
        ImageView imageView5 = this.mPlusImage;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusImage");
        } else {
            imageView2 = imageView5;
        }
        VideoReport.reportEvent("clck", imageView2, hashMap);
    }

    private final void i1(boolean panelShowing) {
        float f16;
        boolean z16;
        QLog.i("GuildAioPlusViewBinder", 4, "updatePlusIcon panelShowing=" + panelShowing);
        if (panelShowing) {
            f16 = 45.0f;
        } else {
            f16 = 0.0f;
        }
        ImageView imageView = this.mPlusImage;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusImage");
            imageView = null;
        }
        if (imageView.getRotation() == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ImageView imageView3 = this.mPlusImage;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusImage");
            imageView3 = null;
        }
        float[] fArr = new float[2];
        ImageView imageView4 = this.mPlusImage;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusImage");
        } else {
            imageView2 = imageView4;
        }
        fArr[0] = imageView2.getRotation();
        fArr[1] = f16;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView3, BasicAnimation.KeyPath.ROTATION, fArr);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View] */
    private final void j1(boolean show) {
        ImageView imageView = this.mPlusRedDot;
        if (imageView != null) {
            Boolean valueOf = Boolean.valueOf(show);
            imageView.setVisibility(0);
            ?? r36 = (View) g.a(valueOf, imageView);
            if (r36 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView = r36;
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        ImageView imageView = this.mPlusImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusImage");
            imageView = null;
        }
        imageView.setRotation(0.0f);
        sendIntent(new a.C11359a());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, GuildAioPlusUIState> createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioPlusUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioPlusUIState.PlusPanelShowingState) {
            i1(((GuildAioPlusUIState.PlusPanelShowingState) state).getPanelShowing());
        } else if (state instanceof GuildAioPlusUIState.PlusBtnRedDotState) {
            j1(((GuildAioPlusUIState.PlusBtnRedDotState) state).getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String());
        }
    }

    public final boolean e1() {
        LinearLayout linearLayout = this.mPlusLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusLayout");
            linearLayout = null;
        }
        View findViewById = linearLayout.findViewById(R.id.f165426vy1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mPlusLayout.findViewById\u2026.id.guild_aio_plus_image)");
        if (((ImageView) findViewById).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    public final void h1(boolean visible) {
        LinearLayout linearLayout = this.mPlusLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusLayout");
            linearLayout = null;
        }
        View findViewById = linearLayout.findViewById(R.id.f165426vy1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mPlusLayout.findViewById\u2026.id.guild_aio_plus_image)");
        ImageView imageView = (ImageView) findViewById;
        if (visible) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        View findViewById = params.b().findViewById(R.id.f165427vy2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "params.parent.findViewBy\u2026id.guild_aio_plus_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.mPlusLayout = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusLayout");
            linearLayout = null;
        }
        View findViewById2 = linearLayout.findViewById(R.id.f165426vy1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mPlusLayout.findViewById\u2026.id.guild_aio_plus_image)");
        this.mPlusImage = (ImageView) findViewById2;
        LinearLayout linearLayout2 = this.mPlusLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusLayout");
            linearLayout2 = null;
        }
        this.mPlusRedDot = (ImageView) linearLayout2.findViewById(R.id.f165428vy3);
        ImageView imageView = this.mPlusImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusImage");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: un0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.f1(c.this, view);
            }
        });
        LinearLayout linearLayout3 = this.mPlusLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlusLayout");
            return null;
        }
        return linearLayout3;
    }
}
