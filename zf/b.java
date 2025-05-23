package zf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.memoryseal.QZoneMemorySealFeedItemView;
import com.qzone.reborn.feedx.util.y;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"Lzf/b;", "Lnf/a;", "Lcom/qzone/reborn/feedx/itemview/memoryseal/QZoneMemorySealFeedItemView;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "", "c", "Ljava/lang/Class;", "a", "Lcom/qzone/reborn/feedx/itemview/QZoneFeedType;", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends nf.a<QZoneMemorySealFeedItemView> {
    @Override // nf.a
    public Class<QZoneMemorySealFeedItemView> a() {
        return QZoneMemorySealFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_MEMORY_SEAL;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData data) {
        return y.d(data);
    }
}
