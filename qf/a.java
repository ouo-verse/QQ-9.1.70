package qf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.friendanniversary.QZoneFriendAnniversaryFeedItemView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends nf.a<QZoneFriendAnniversaryFeedItemView> {
    @Override // nf.a
    public Class<QZoneFriendAnniversaryFeedItemView> a() {
        return QZoneFriendAnniversaryFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_FRIEND_ANNIVERSARY;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().isGuideFeed() && businessFeedData.getCellGuiding() != null && businessFeedData.getCellGuiding().guiding_type == 3;
    }
}
