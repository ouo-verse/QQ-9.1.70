package si;

import android.app.Activity;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ho.i;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v9.e;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0014J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lsi/c;", "Lv9/e;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "data", "", "H", "e", "", "getLogTag", "", "position", "", "", "payload", UserInfo.SEX_FEMALE, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends e {
    /* JADX WARN: Multi-variable type inference failed */
    private final void e() {
        Activity activity = p();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = new GroupAlbumAlbumDetailInitBean(fj.e.d(activity));
        groupAlbumAlbumDetailInitBean.setAlbumId(((CommonAlbumListBean) this.mData).getAlbumInfo().getAlbumId());
        groupAlbumAlbumDetailInitBean.setAlbumName(((CommonAlbumListBean) this.mData).getAlbumInfo().getName());
        oi.c m3 = i.m();
        Activity activity2 = p();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        m3.h(activity2, groupAlbumAlbumDetailInitBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        super.onBindData(data, position, payload);
        H(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumAlbumListNormalSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n3j) {
            e();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    private final void H(CommonAlbumListBean data) {
        if (data == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("albumid", data.getAlbumInfo().getAlbumId());
        hashMap.put("album_name", data.getAlbumInfo().getName());
        fo.c.o(B(), "em_qz_individual_album_item", new fo.b().l(hashMap).i(data.getAlbumInfo().getAlbumId()));
    }
}
