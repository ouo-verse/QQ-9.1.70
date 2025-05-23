package wf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.handblog.QZoneForwardHandBlogItemView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends nf.a<QZoneForwardHandBlogItemView> {
    @Override // nf.a
    public Class<QZoneForwardHandBlogItemView> a() {
        return QZoneForwardHandBlogItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_FORWARD_HAND_BLOG_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().isNewHandBlogFeed();
    }
}
