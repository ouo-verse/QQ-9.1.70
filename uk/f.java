package uk;

import NS_MOBILE_PHOTO.Photo;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import cooperation.qzone.model.PhotoInfo;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f extends a {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // uk.a
    public void N1(Photo photo, RFWLayerItemMediaInfo rFWLayerItemMediaInfo, boolean z16, PhotoInfo photoInfo) {
        super.N1(photo, rFWLayerItemMediaInfo, z16, photoInfo);
        if (rFWLayerItemMediaInfo.getLayerPicInfo() == null) {
            return;
        }
        rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo().setWidth(photo.width);
        rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo().setHeight(photo.height);
    }

    @Override // uk.a
    public void Z1(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder) {
        QZoneFeedxPictureManager.getInstance().getQZonePhotoListEx(qZoneAlbumRequestBuilder, this);
    }

    @Override // uk.a
    protected void O1(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return;
        }
        photoInfo.hasPraise = this.f439101m.isLike;
    }
}
