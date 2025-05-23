package r9;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lr9/a;", "Lcom/qzone/reborn/base/k;", "", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "d", "Ljava/lang/String;", "initText", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "contentView", "<init>", "(Ljava/lang/String;)V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String initText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView contentView;

    public a(String initText) {
        Intrinsics.checkNotNullParameter(initText, "initText");
        this.initText = initText;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.mn9);
        TextView textView = (TextView) findViewById;
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(this.initText);
        textView.setMaxHeight(C9());
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Te\u2026tentMaxHeight()\n        }");
        this.contentView = textView;
    }

    private final int C9() {
        int dpToPx = ImmersiveUtils.dpToPx(50.0f);
        int dpToPx2 = ImmersiveUtils.dpToPx(16.0f);
        return (((pl.a.f426446a.n(getContext()) - ImmersiveUtils.getStatusBarHeight(getContext())) - dpToPx) - dpToPx2) - ImmersiveUtils.dpToPx(30.0f);
    }
}
