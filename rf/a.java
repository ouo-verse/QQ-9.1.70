package rf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.friendbirthday.QZoneFriendBirthdayFeedItemView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends nf.a<QZoneFriendBirthdayFeedItemView> {
    @Override // nf.a
    public Class<QZoneFriendBirthdayFeedItemView> a() {
        return QZoneFriendBirthdayFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_FRIEND_BIRTHDAY;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().isGuideFeed() && businessFeedData.getCellGuiding() != null && businessFeedData.getCellGuiding().guiding_type == 5;
    }
}
