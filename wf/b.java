package wf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.handblog.QZoneHandBlogItemView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends nf.a<QZoneHandBlogItemView> {
    @Override // nf.a
    public Class<QZoneHandBlogItemView> a() {
        return QZoneHandBlogItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_HAND_BLOG_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.isNewHandBlogFeed();
    }
}
