package xb;

import android.view.View;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0007\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014\u00a8\u0006\u0014"}, d2 = {"Lxb/b;", "Lv9/a;", "", "y", "", "getLogTag", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "data", "", "position", "", "", "payload", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends v9.a {
    private final void y() {
        fo.b bVar = new fo.b();
        bVar.h(new IDynamicParams() { // from class: xb.a
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map z16;
                z16 = b.z(str);
                return z16;
            }
        });
        bVar.k(ExposurePolicy.REPORT_NONE);
        fo.c.o(u(), "em_qz_new_album", bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map z(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, eo.c.f396879a.c());
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumListAddSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n3f) {
            eo.c.f396879a.b();
            hb.a aVar = (hb.a) q(hb.a.class);
            if (aVar != null) {
                aVar.e();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        super.onBindData(data, position, payload);
        y();
    }
}
