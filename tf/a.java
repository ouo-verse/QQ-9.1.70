package tf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.friendposting.QZoneFriendPostingFeedItemView;
import com.qzone.reborn.util.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sg.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"Ltf/a;", "Lnf/a;", "Lcom/qzone/reborn/feedx/itemview/friendposting/QZoneFriendPostingFeedItemView;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "", "c", "Ljava/lang/Class;", "a", "Lcom/qzone/reborn/feedx/itemview/QZoneFeedType;", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends nf.a<QZoneFriendPostingFeedItemView> {
    @Override // nf.a
    public Class<QZoneFriendPostingFeedItemView> a() {
        return QZoneFriendPostingFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_FRIEND_POSTING_CARD_TYPE;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (k.f59549a.g()) {
            return false;
        }
        return d.f433774a.a(data.cellUniverse);
    }
}
