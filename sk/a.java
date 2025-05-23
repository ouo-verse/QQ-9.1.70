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

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends Section<RFWLayerItemMediaInfo> {
    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, int i3, List<Object> list) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        View view2 = new View(view.getContext());
        view2.setBackground(ResourcesCompat.getDrawable(view.getResources(), R.drawable.f15273y, null));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(216.0f));
        layoutParams.gravity = 80;
        ((ViewGroup) view).addView(view2, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, int i3, List list) {
        onBindData2(rFWLayerItemMediaInfo, i3, (List<Object>) list);
    }
}
