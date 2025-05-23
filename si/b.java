package si;

import android.app.Activity;
import android.view.View;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import fj.e;
import ho.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J*\u0010\r\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0014J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u0015"}, d2 = {"Lsi/b;", "Lv9/b;", "", "e", "", "getLogTag", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "data", "", "position", "", "", "payload", "w", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends v9.b {
    /* JADX WARN: Multi-variable type inference failed */
    private final void e() {
        Activity activity = p();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = new GroupAlbumAlbumDetailInitBean(e.d(activity));
        groupAlbumAlbumDetailInitBean.setAlbumId(((CommonAlbumListBean) this.mData).getAlbumInfo().getAlbumId());
        groupAlbumAlbumDetailInitBean.setAlbumName(((CommonAlbumListBean) this.mData).getAlbumInfo().getName());
        oi.c m3 = i.m();
        Activity activity2 = p();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        m3.h(activity2, groupAlbumAlbumDetailInitBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumAlbumListNameSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n3s) {
            e();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v9.b, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        super.onBindData(data, position, payload);
    }
}
