package sk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J&\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014\u00a8\u0006\u0012"}, d2 = {"Lsk/b;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "", "getViewStubLayoutId", "Landroid/view/View;", "view", "", "onInitView", "rfwLayerItemMediaInfo", "", "i", "", "", "list", "onBindData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends Section<RFWLayerItemMediaInfo> {
    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(RFWLayerItemMediaInfo rfwLayerItemMediaInfo, int i3, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(rfwLayerItemMediaInfo, "rfwLayerItemMediaInfo");
        Intrinsics.checkNotNullParameter(list, "list");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View view2 = new View(view.getContext());
        view2.setBackground(ResourcesCompat.getDrawable(view.getResources(), R.drawable.f16305z, null));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(150.0f));
        layoutParams.gravity = 48;
        ((ViewGroup) view).addView(view2, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, int i3, List list) {
        onBindData2(rFWLayerItemMediaInfo, i3, (List<? extends Object>) list);
    }
}
