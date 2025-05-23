package yf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.individual.QZoneFeedIndividualDressUpItemView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends nf.a<QZoneFeedIndividualDressUpItemView> {
    @Override // nf.a
    public Class<QZoneFeedIndividualDressUpItemView> a() {
        return QZoneFeedIndividualDressUpItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_INDIVIDUAL_DRESS_UP_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || !businessFeedData.isLeftImageH5ShareFeed() || businessFeedData.isNewHandBlogFeed() || businessFeedData.isReprintedTextBlogFeed() || businessFeedData.getLeftThumb().getMediaType() != 0) ? false : true;
    }
}
