package vf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.h5share.QZoneH5ShareItemView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends nf.a<QZoneH5ShareItemView> {
    @Override // nf.a
    public Class<QZoneH5ShareItemView> a() {
        return QZoneH5ShareItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_LEFT_H5_SHARE_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || !businessFeedData.isLeftImageH5ShareFeed() || businessFeedData.isNewHandBlogFeed() || businessFeedData.isReprintedTextBlogFeed() || businessFeedData.getLeftThumb().getMediaType() == 0) ? false : true;
    }
}
