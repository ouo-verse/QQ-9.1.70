package uk;

import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.preview.service.QZoneFeedxPictureManager;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends a {
    @Override // uk.a
    public void Z1(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder) {
        QZoneFeedxPictureManager.getInstance().getQZonePhotoListEx(qZoneAlbumRequestBuilder, this);
    }
}
