package zf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.memoryseal.QZoneGuestMemorySealFooterView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends nf.a<QZoneGuestMemorySealFooterView> {
    @Override // nf.a
    public Class<QZoneGuestMemorySealFooterView> a() {
        return QZoneGuestMemorySealFooterView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_GUEST_MEMORY_SEAL;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.isFakeMemorySealFeed();
    }
}
