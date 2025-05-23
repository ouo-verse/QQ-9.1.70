package vj;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellIntimateSpaceInfo;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StPicSpecUrlEntry;
import qzone.QZoneBaseMeta$StPicUrl;
import qzone.QZoneBaseMeta$StVideo;
import sj.f;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000fJ\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a8\u0006\u001f"}, d2 = {"Lvj/d;", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "extraInfo", "Lqzone/QZoneBaseMeta$StImage;", "d", "Lqzone/QZoneBaseMeta$StVideo;", "e", "", "width", "i", "height", h.F, "Lqzone/QZoneBaseMeta$StMedia;", "a", "g", "f", "stMedia", "", "j", "spaceId", "spaceType", "Lsj/f;", "c", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f441734a = new d();

    d() {
    }

    private final QZoneBaseMeta$StImage d(RFWLayerItemMediaInfo mediaInfo, QZIntimateLayerExtraInfoBean extraInfo) {
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        RFWLayerPicInfo.RFWPicInfo originPicInfo2;
        RFWLayerPicInfo.RFWPicInfo originPicInfo3;
        RFWLayerPicInfo.RFWPicInfo originPicInfo4;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo2;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo3;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo4;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo2;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo3;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo4;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo2;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo3;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo4;
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage = new QZoneBaseMeta$StImage();
        PBStringField pBStringField = qZoneBaseMeta$StImage.lloc;
        String lLoc = extraInfo.getLLoc();
        if (lLoc == null) {
            lLoc = "";
        }
        pBStringField.set(lLoc);
        PBStringField pBStringField2 = qZoneBaseMeta$StImage.sloc;
        String sLoc = extraInfo.getSLoc();
        pBStringField2.set(sLoc != null ? sLoc : "");
        ArrayList arrayList = new ArrayList();
        RFWLayerPicInfo layerPicInfo = mediaInfo.getLayerPicInfo();
        String str = null;
        int i3 = 0;
        if (!TextUtils.isEmpty((layerPicInfo == null || (currentPicInfo4 = layerPicInfo.getCurrentPicInfo()) == null) ? null : currentPicInfo4.getUrl())) {
            QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry = new QZoneBaseMeta$StPicSpecUrlEntry();
            qZoneBaseMeta$StPicSpecUrlEntry.spec.set(5);
            QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = new QZoneBaseMeta$StPicUrl();
            PBStringField pBStringField3 = qZoneBaseMeta$StPicUrl.url;
            RFWLayerPicInfo layerPicInfo2 = mediaInfo.getLayerPicInfo();
            pBStringField3.set((layerPicInfo2 == null || (currentPicInfo3 = layerPicInfo2.getCurrentPicInfo()) == null) ? null : currentPicInfo3.getUrl());
            PBInt32Field pBInt32Field = qZoneBaseMeta$StPicUrl.width;
            RFWLayerPicInfo layerPicInfo3 = mediaInfo.getLayerPicInfo();
            pBInt32Field.set(i((layerPicInfo3 == null || (currentPicInfo2 = layerPicInfo3.getCurrentPicInfo()) == null) ? 0 : currentPicInfo2.getWidth()));
            PBInt32Field pBInt32Field2 = qZoneBaseMeta$StPicUrl.height;
            RFWLayerPicInfo layerPicInfo4 = mediaInfo.getLayerPicInfo();
            pBInt32Field2.set(h((layerPicInfo4 == null || (currentPicInfo = layerPicInfo4.getCurrentPicInfo()) == null) ? 0 : currentPicInfo.getHeight()));
            qZoneBaseMeta$StPicSpecUrlEntry.url.set(qZoneBaseMeta$StPicUrl);
            arrayList.add(qZoneBaseMeta$StPicSpecUrlEntry);
        }
        RFWLayerPicInfo layerPicInfo5 = mediaInfo.getLayerPicInfo();
        if (!TextUtils.isEmpty((layerPicInfo5 == null || (bigPicInfo4 = layerPicInfo5.getBigPicInfo()) == null) ? null : bigPicInfo4.getUrl())) {
            QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry2 = new QZoneBaseMeta$StPicSpecUrlEntry();
            qZoneBaseMeta$StPicSpecUrlEntry2.spec.set(1);
            QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl2 = new QZoneBaseMeta$StPicUrl();
            PBStringField pBStringField4 = qZoneBaseMeta$StPicUrl2.url;
            RFWLayerPicInfo layerPicInfo6 = mediaInfo.getLayerPicInfo();
            pBStringField4.set((layerPicInfo6 == null || (bigPicInfo3 = layerPicInfo6.getBigPicInfo()) == null) ? null : bigPicInfo3.getUrl());
            PBInt32Field pBInt32Field3 = qZoneBaseMeta$StPicUrl2.width;
            RFWLayerPicInfo layerPicInfo7 = mediaInfo.getLayerPicInfo();
            pBInt32Field3.set(i((layerPicInfo7 == null || (bigPicInfo2 = layerPicInfo7.getBigPicInfo()) == null) ? 0 : bigPicInfo2.getWidth()));
            PBInt32Field pBInt32Field4 = qZoneBaseMeta$StPicUrl2.height;
            RFWLayerPicInfo layerPicInfo8 = mediaInfo.getLayerPicInfo();
            pBInt32Field4.set(h((layerPicInfo8 == null || (bigPicInfo = layerPicInfo8.getBigPicInfo()) == null) ? 0 : bigPicInfo.getHeight()));
            qZoneBaseMeta$StPicSpecUrlEntry2.url.set(qZoneBaseMeta$StPicUrl2);
            arrayList.add(qZoneBaseMeta$StPicSpecUrlEntry2);
        }
        RFWLayerPicInfo layerPicInfo9 = mediaInfo.getLayerPicInfo();
        if (!TextUtils.isEmpty((layerPicInfo9 == null || (downloadPicInfo4 = layerPicInfo9.getDownloadPicInfo()) == null) ? null : downloadPicInfo4.getUrl())) {
            QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry3 = new QZoneBaseMeta$StPicSpecUrlEntry();
            qZoneBaseMeta$StPicSpecUrlEntry3.spec.set(1);
            QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl3 = new QZoneBaseMeta$StPicUrl();
            PBStringField pBStringField5 = qZoneBaseMeta$StPicUrl3.url;
            RFWLayerPicInfo layerPicInfo10 = mediaInfo.getLayerPicInfo();
            pBStringField5.set((layerPicInfo10 == null || (downloadPicInfo3 = layerPicInfo10.getDownloadPicInfo()) == null) ? null : downloadPicInfo3.getUrl());
            PBInt32Field pBInt32Field5 = qZoneBaseMeta$StPicUrl3.width;
            RFWLayerPicInfo layerPicInfo11 = mediaInfo.getLayerPicInfo();
            pBInt32Field5.set(i((layerPicInfo11 == null || (downloadPicInfo2 = layerPicInfo11.getDownloadPicInfo()) == null) ? 0 : downloadPicInfo2.getWidth()));
            PBInt32Field pBInt32Field6 = qZoneBaseMeta$StPicUrl3.height;
            RFWLayerPicInfo layerPicInfo12 = mediaInfo.getLayerPicInfo();
            pBInt32Field6.set(h((layerPicInfo12 == null || (downloadPicInfo = layerPicInfo12.getDownloadPicInfo()) == null) ? 0 : downloadPicInfo.getHeight()));
            qZoneBaseMeta$StPicSpecUrlEntry3.url.set(qZoneBaseMeta$StPicUrl3);
            arrayList.add(qZoneBaseMeta$StPicSpecUrlEntry3);
        }
        RFWLayerPicInfo layerPicInfo13 = mediaInfo.getLayerPicInfo();
        if (!TextUtils.isEmpty((layerPicInfo13 == null || (originPicInfo4 = layerPicInfo13.getOriginPicInfo()) == null) ? null : originPicInfo4.getUrl())) {
            QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry4 = new QZoneBaseMeta$StPicSpecUrlEntry();
            qZoneBaseMeta$StPicSpecUrlEntry4.spec.set(0);
            QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl4 = new QZoneBaseMeta$StPicUrl();
            PBStringField pBStringField6 = qZoneBaseMeta$StPicUrl4.url;
            RFWLayerPicInfo layerPicInfo14 = mediaInfo.getLayerPicInfo();
            if (layerPicInfo14 != null && (originPicInfo3 = layerPicInfo14.getOriginPicInfo()) != null) {
                str = originPicInfo3.getUrl();
            }
            pBStringField6.set(str);
            PBInt32Field pBInt32Field7 = qZoneBaseMeta$StPicUrl4.width;
            RFWLayerPicInfo layerPicInfo15 = mediaInfo.getLayerPicInfo();
            pBInt32Field7.set(i((layerPicInfo15 == null || (originPicInfo2 = layerPicInfo15.getOriginPicInfo()) == null) ? 0 : originPicInfo2.getWidth()));
            PBInt32Field pBInt32Field8 = qZoneBaseMeta$StPicUrl4.height;
            RFWLayerPicInfo layerPicInfo16 = mediaInfo.getLayerPicInfo();
            if (layerPicInfo16 != null && (originPicInfo = layerPicInfo16.getOriginPicInfo()) != null) {
                i3 = originPicInfo.getHeight();
            }
            pBInt32Field8.set(h(i3));
            qZoneBaseMeta$StPicSpecUrlEntry4.url.set(qZoneBaseMeta$StPicUrl4);
            arrayList.add(qZoneBaseMeta$StPicSpecUrlEntry4);
        }
        qZoneBaseMeta$StImage.photo_url.set(arrayList);
        return qZoneBaseMeta$StImage;
    }

    private final QZoneBaseMeta$StVideo e(RFWLayerItemMediaInfo mediaInfo, QZIntimateLayerExtraInfoBean extraInfo) {
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = new QZoneBaseMeta$StVideo();
        qZoneBaseMeta$StVideo.f430340id.set(extraInfo.getVideoId());
        PBStringField pBStringField = qZoneBaseMeta$StVideo.url;
        RFWLayerVideoInfo layerVideoInfo = mediaInfo.getLayerVideoInfo();
        pBStringField.set(layerVideoInfo != null ? layerVideoInfo.getNormalVideoUrl() : null);
        qZoneBaseMeta$StVideo.cover.set(d(mediaInfo, extraInfo));
        PBInt32Field pBInt32Field = qZoneBaseMeta$StVideo.width;
        RFWLayerVideoInfo layerVideoInfo2 = mediaInfo.getLayerVideoInfo();
        pBInt32Field.set(i(layerVideoInfo2 != null ? layerVideoInfo2.getVideoWidth() : 0));
        PBInt32Field pBInt32Field2 = qZoneBaseMeta$StVideo.height;
        RFWLayerVideoInfo layerVideoInfo3 = mediaInfo.getLayerVideoInfo();
        pBInt32Field2.set(h(layerVideoInfo3 != null ? layerVideoInfo3.getVideoHeight() : 0));
        if (mediaInfo.getLayerVideoInfo() != null) {
            qZoneBaseMeta$StVideo.video_time.set(r4.getVideoDurationSec());
        }
        return qZoneBaseMeta$StVideo;
    }

    public final QZoneBaseMeta$StMedia a(RFWLayerItemMediaInfo mediaInfo, QZIntimateLayerExtraInfoBean extraInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = new QZoneBaseMeta$StMedia();
        if (extraInfo.getIsVideo()) {
            qZoneBaseMeta$StMedia.type.set(1);
            qZoneBaseMeta$StMedia.video.set(e(mediaInfo, extraInfo));
        } else {
            qZoneBaseMeta$StMedia.type.set(0);
            qZoneBaseMeta$StMedia.image.set(d(mediaInfo, extraInfo));
        }
        PBStringField pBStringField = qZoneBaseMeta$StMedia.desc;
        String desc = extraInfo.getDesc();
        if (desc == null) {
            desc = "";
        }
        pBStringField.set(desc);
        qZoneBaseMeta$StMedia.batch_id.set(extraInfo.getBatchId());
        PBStringField pBStringField2 = qZoneBaseMeta$StMedia.uploader;
        String uploadUid = extraInfo.getUploadUid();
        pBStringField2.set(uploadUid != null ? uploadUid : "");
        return qZoneBaseMeta$StMedia;
    }

    public final f b(BusinessFeedData feedData) {
        CellIntimateSpaceInfo cellIntimateSpaceInfo;
        CellIntimateSpaceInfo cellIntimateSpaceInfo2;
        f fVar = new f();
        String str = (feedData == null || (cellIntimateSpaceInfo2 = feedData.cellIntimateSpaceInfo) == null) ? null : cellIntimateSpaceInfo2.spaceId;
        if (str == null) {
            str = "";
        }
        fVar.c(str);
        fVar.d((feedData == null || (cellIntimateSpaceInfo = feedData.cellIntimateSpaceInfo) == null) ? 0 : cellIntimateSpaceInfo.spaceType);
        return fVar;
    }

    public final f c(String spaceId, int spaceType) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        f fVar = new f();
        fVar.c(spaceId);
        fVar.d(spaceType);
        return fVar;
    }

    public final int f() {
        return (ImmersiveUtils.getScreenWidth() * 4) / 3;
    }

    public final int g() {
        return ImmersiveUtils.getScreenWidth();
    }

    public final String j(QZoneBaseMeta$StMedia stMedia) {
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        String str = null;
        if (stMedia.type.get() == 0) {
            QZoneBaseMeta$StImage qZoneBaseMeta$StImage2 = stMedia.image;
            if (qZoneBaseMeta$StImage2 != null && (pBStringField2 = qZoneBaseMeta$StImage2.lloc) != null) {
                str = pBStringField2.get();
            }
            if (str == null) {
                return "";
            }
        } else {
            QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = stMedia.video;
            if (qZoneBaseMeta$StVideo != null && (qZoneBaseMeta$StImage = qZoneBaseMeta$StVideo.cover) != null && (pBStringField = qZoneBaseMeta$StImage.lloc) != null) {
                str = pBStringField.get();
            }
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    private final int h(int height) {
        return height == 0 ? f() : height;
    }

    private final int i(int width) {
        return width == 0 ? g() : width;
    }
}
