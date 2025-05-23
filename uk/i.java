package uk;

import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.preview.service.QZoneFeedxPictureManager;

/* compiled from: P */
/* loaded from: classes36.dex */
public class i extends a {
    @Override // uk.a
    public void Z1(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder) {
        c2(qZoneAlbumRequestBuilder);
    }

    private void c2(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        if (qZoneAlbumRequestBuilder.fetchLeft == 1) {
            QZoneFeedxPictureManager.getInstance().getCacheRecentAlbumPhoto(qZoneAlbumRequestBuilder, this);
        } else {
            QZoneFeedxPictureManager.getInstance().getMoreRecentAlbumPhoto(qZoneAlbumRequestBuilder, this);
        }
    }
}
