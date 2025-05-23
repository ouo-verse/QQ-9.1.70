package uf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAlbumEntrance;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.game.QZoneGamePicShareItemView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends nf.a<QZoneGamePicShareItemView> {
    @Override // nf.a
    public Class<QZoneGamePicShareItemView> a() {
        return QZoneGamePicShareItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_GAME_PIC_SHARE_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        CellAlbumEntrance cellAlbumEntrance;
        return (businessFeedData == null || (cellAlbumEntrance = businessFeedData.cellAlbumEntrance) == null || cellAlbumEntrance.iAttr != 1) ? false : true;
    }
}
