package uk;

import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.preview.service.QZoneFeedxPictureManager;

/* compiled from: P */
/* loaded from: classes36.dex */
public class h extends a {
    @Override // uk.a
    public void Z1(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        if (qZoneAlbumRequestBuilder.fetchLeft == 1) {
            qZoneAlbumRequestBuilder.direction = 2;
            QZoneFeedxPictureManager.getInstance().loadMoreUpRecentAlbumTimeline(qZoneAlbumRequestBuilder, this);
        } else {
            qZoneAlbumRequestBuilder.direction = 1;
            QZoneFeedxPictureManager.getInstance().loadMoreRecentAlbumTimeline(qZoneAlbumRequestBuilder, this);
        }
    }
}
