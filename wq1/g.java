package wq1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lwq1/g;", "Lcom/tencent/aio/base/mvvm/a;", "", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "f1", "Lvp1/e;", "d", "Lvp1/e;", "c1", "()Lvp1/e;", "g1", "(Lvp1/e;)V", "binding", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g extends com.tencent.aio.base.mvvm.a<Object, TitleUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public vp1.e binding;

    private final void d1() {
        c1().f443004b.setOnClickListener(new View.OnClickListener() { // from class: wq1.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.e1(g.this, view);
            }
        });
        LinearLayout root = c1().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        f1(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context mContext = this$0.getMContext();
        Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) mContext).onBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final vp1.e c1() {
        vp1.e eVar = this.binding;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void f1(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (QQTheme.isVasTheme()) {
            rootView.setBackground(ResourcesCompat.getDrawable(rootView.getResources(), R.drawable.skin_header_bar_bg, null));
        } else {
            rootView.setBackgroundColor(ie0.a.f().g(rootView.getContext(), R.color.qui_common_bg_bottom_standard, 1000));
        }
    }

    public final void g1(@NotNull vp1.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.binding = eVar;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        vp1.e g16 = vp1.e.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, false)");
        g1(g16);
        d1();
        LinearLayout root = c1().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }
}
