package r9;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import fo.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lr9/b;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "", "d", "Ljava/lang/String;", "titleBarText", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivBack", "<init>", "(Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String titleBarText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBack;

    public b(String titleBarText) {
        Intrinsics.checkNotNullParameter(titleBarText, "titleBarText");
        this.titleBarText = titleBarText;
    }

    private final void C9() {
        ImageView imageView = this.ivBack;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView = null;
        }
        c.q(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.mn7 && (activity = getActivity()) != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.mn8);
            TextView textView = (TextView) findViewById;
            textView.setText(this.titleBarText);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TextView>(R\u2026itleBarText\n            }");
            this.tvTitle = textView;
            View findViewById2 = rootView.findViewById(R.id.mn7);
            ImageView imageView = (ImageView) findViewById2;
            imageView.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(\u2026lTitlePart)\n            }");
            this.ivBack = imageView;
            C9();
        }
    }
}
