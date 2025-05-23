package si;

import android.view.View;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014\u00a8\u0006\u0014"}, d2 = {"Lsi/a;", "Lv9/a;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "data", "", HippyTKDListViewAdapter.X, "", "getLogTag", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "position", "", "", "payload", "<init>", "()V", h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends v9.a {
    private final void x(CommonAlbumListBean data) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i3 = data.getAlbumInfo().getUploadNumber() > 0 ? 2 : 1;
        fo.b bVar = new fo.b();
        bVar.l(linkedHashMap);
        linkedHashMap.put("new_album_entry_status", Integer.valueOf(i3));
        fo.c.o(u(), "em_qz_new_album", bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumAlbumListAddSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        ai.a aVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n3f && (aVar = (ai.a) q(ai.a.class)) != null) {
            aVar.e();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        super.onBindData(data, position, payload);
        if (data != null) {
            x(data);
        }
    }
}
