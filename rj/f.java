package rj;

import android.view.View;
import android.view.ViewGroup;
import com.qzone.reborn.intimate.bean.QZoneAlbumSyncBean;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0014J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f0\u0006H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lrj/f;", "Lcom/qzone/reborn/base/f;", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumSyncBean;", "", "getLayoutId", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "position", "", "c", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "", "f", "Ljava/lang/String;", "TAG", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f extends com.qzone.reborn.base.f<QZoneAlbumSyncBean> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneIntimateAlbumSyncItemDelegate";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(QZoneAlbumSyncBean item, List<QZoneAlbumSyncBean> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.cl8;
    }

    @Override // com.qzone.reborn.base.f, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup parent, View itemView, List<Class<? extends Section<QZoneAlbumSyncBean>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        super.initSection(parent, itemView, sections);
        sections.add(gk.b.class);
    }
}
