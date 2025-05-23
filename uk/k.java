package uk;

import NS_MOBILE_PHOTO.Photo;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.model.PhotoInfo;

/* compiled from: P */
/* loaded from: classes36.dex */
public class k extends a {
    private PhotoInfo D;

    private void c2() {
        if (ArrayUtils.isOutOfArrayIndex(0, this.C)) {
            return;
        }
        this.D = this.C.get(0);
    }

    @Override // uk.a
    protected void M1(PhotoInfo photoInfo, RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        PhotoInfo photoInfo2 = this.D;
        photoInfo.videodata = photoInfo2.videodata;
        photoInfo.videoflag = photoInfo2.videoflag;
        photoInfo.videoUgcRight = photoInfo2.videoUgcRight;
        rFWLayerItemMediaInfo.setExtraData(photoInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // uk.a
    public void P1(Photo photo, RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        if (this.f439101m.appid == 202 && photo.videoflag != 1) {
            PhotoInfo photoInfo = this.D;
            if (photoInfo == null || photoInfo.videodata == null) {
                return;
            }
            PictureViewerFactory.c(photoInfo, rFWLayerItemMediaInfo);
            return;
        }
        super.P1(photo, rFWLayerItemMediaInfo);
    }

    @Override // uk.a
    protected boolean X1(Photo photo) {
        return true;
    }

    @Override // uk.a
    public void Z1(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder) {
        c2();
        QZoneFeedxPictureManager.getInstance().getQZonePhotoListEx(qZoneAlbumRequestBuilder, this);
    }
}
