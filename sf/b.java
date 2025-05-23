package sf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.friendplaying.QZoneFriendPlayingFeedItemView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends nf.a<QZoneFriendPlayingFeedItemView> {
    @Override // nf.a
    public Class<QZoneFriendPlayingFeedItemView> a() {
        return QZoneFriendPlayingFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_FRIEND_PLAYING;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        boolean isGameRecommendFeed = businessFeedData.isGameRecommendFeed();
        if (isGameRecommendFeed) {
            return isGameRecommendFeed && (businessFeedData.cellGameRecommend.f50335a == 2);
        }
        return false;
    }
}
