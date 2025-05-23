package sf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.friendplaying.QZoneFriendPlayingBigCardFeedItemView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends nf.a<QZoneFriendPlayingBigCardFeedItemView> {
    @Override // nf.a
    public Class<QZoneFriendPlayingBigCardFeedItemView> a() {
        return QZoneFriendPlayingBigCardFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_FRIEND_PLAYING_BIG_CARD;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        boolean isGameRecommendFeed = businessFeedData.isGameRecommendFeed();
        if (isGameRecommendFeed) {
            return isGameRecommendFeed && (businessFeedData.cellGameRecommend.f50335a == 1);
        }
        return false;
    }
}
