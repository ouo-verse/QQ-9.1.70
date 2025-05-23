package qk;

import android.view.View;
import android.view.ViewGroup;
import com.qzone.reborn.layer.item.presenter.RFWLayerLongPicControlSection;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends AbsItemAdapterDelegate<RFWLayerItemMediaInfo, RFWLayerItemMediaInfo> {
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.f127921z;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup viewGroup, View view, List<Class<? extends Section<RFWLayerItemMediaInfo>>> list) {
        list.add(RFWLayerLongPicControlSection.class);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    protected /* bridge */ /* synthetic */ boolean isForViewType(Object obj, List list, int i3) {
        return isForViewType((RFWLayerItemMediaInfo) obj, (List<RFWLayerItemMediaInfo>) list, i3);
    }

    protected boolean isForViewType(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, List<RFWLayerItemMediaInfo> list, int i3) {
        return rFWLayerItemMediaInfo.getLayerPicInfo() != null && rFWLayerItemMediaInfo.getLayerVideoInfo() == null;
    }
}
