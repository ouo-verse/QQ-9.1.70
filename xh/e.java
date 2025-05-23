package xh;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.common.convert.bean.CommonStVideo;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StPicSpecUrlEntry;
import qzone.QZoneBaseMeta$StPicUrl;
import qzone.QZoneBaseMeta$StUser;
import qzone.QZoneBaseMeta$StVideo;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000\u001a\f\u0010\u0006\u001a\u00020\u0003*\u0004\u0018\u00010\u0001\u001a\f\u0010\t\u001a\u00020\b*\u0004\u0018\u00010\u0007\u001a\f\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\n\u001a\f\u0010\u000f\u001a\u00020\u000e*\u0004\u0018\u00010\r\u001a\f\u0010\u0012\u001a\u00020\u0011*\u0004\u0018\u00010\u0010\u001a\f\u0010\u0015\u001a\u00020\u0014*\u0004\u0018\u00010\u0013\u001a\f\u0010\u0018\u001a\u00020\u0017*\u0004\u0018\u00010\u0016\u001a\u001c\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0002j\b\u0012\u0004\u0012\u00020\u0001`\u0004*\u0004\u0018\u00010\u0019\u001a\f\u0010\u001c\u001a\u00020\u001b*\u0004\u0018\u00010\u0019\u001a\u001c\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0002j\b\u0012\u0004\u0012\u00020\u0001`\u0004*\u0004\u0018\u00010\u0019\u001a\f\u0010\u001f\u001a\u00020\r*\u0004\u0018\u00010\u001e\u001a\f\u0010!\u001a\u00020\u0010*\u0004\u0018\u00010 \u001a\n\u0010\"\u001a\u00020\u001b*\u00020\u001b\u001a\n\u0010#\u001a\u00020\u001b*\u00020\u001b\u00a8\u0006$"}, d2 = {"", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Ljava/util/ArrayList;", "Lqzone/QZoneBaseMeta$StMedia;", "Lkotlin/collections/ArrayList;", "g", "i", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "Lqzone/QZoneBaseMeta$StUser;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "f", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;", "Lqzone/QZoneBaseMeta$StVideo;", "l", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "Lqzone/QZoneBaseMeta$StImage;", tl.h.F, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicSpecUrlEntry;", "Lqzone/QZoneBaseMeta$StPicSpecUrlEntry;", "j", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicUrl;", "Lqzone/QZoneBaseMeta$StPicUrl;", "k", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "a", "", "d", "b", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "o", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", DomainData.DOMAIN_NAME, "e", "c", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {
    public static final ArrayList<CommonStMedia> a(BusinessFeedData businessFeedData) {
        CellPictureInfo pictureInfo;
        ArrayList<PictureItem> arrayList;
        ArrayList<CommonStMedia> arrayList2 = new ArrayList<>();
        if (businessFeedData != null && businessFeedData.getPictureInfo() != null && (arrayList = (pictureInfo = businessFeedData.getPictureInfo()).pics) != null && !arrayList.isEmpty()) {
            Iterator<PictureItem> it = pictureInfo.pics.iterator();
            while (it.hasNext()) {
                PictureItem next = it.next();
                CommonStMedia commonStMedia = new CommonStMedia();
                commonStMedia.M(next.uploadTime);
                commonStMedia.F(next.uploadUid);
                commonStMedia.x(next.desc);
                if (next.isVideo()) {
                    commonStMedia.E(1);
                    commonStMedia.V(o(next.videodata));
                } else {
                    commonStMedia.E(0);
                    commonStMedia.y(n(next));
                }
                arrayList2.add(commonStMedia);
            }
        }
        return arrayList2;
    }

    public static final ArrayList<CommonStMedia> b(BusinessFeedData businessFeedData) {
        ArrayList<CommonStMedia> arrayList = new ArrayList<>();
        if (businessFeedData != null && businessFeedData.getVideoInfo() != null) {
            VideoInfo videoInfo = businessFeedData.getVideoInfo();
            Intrinsics.checkNotNull(videoInfo);
            CommonStMedia commonStMedia = new CommonStMedia();
            commonStMedia.E(1);
            commonStMedia.F(videoInfo.uploadUid);
            commonStMedia.V(o(videoInfo));
            commonStMedia.x(videoInfo.desc);
            arrayList.add(commonStMedia);
        }
        return arrayList;
    }

    public static final QZoneBaseAlbumMeta$AlbumInfo f(CommonAlbumInfo commonAlbumInfo) {
        QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo = new QZoneBaseAlbumMeta$AlbumInfo();
        if (commonAlbumInfo == null) {
            return qZoneBaseAlbumMeta$AlbumInfo;
        }
        qZoneBaseAlbumMeta$AlbumInfo.album_id.set(commonAlbumInfo.getAlbumId());
        qZoneBaseAlbumMeta$AlbumInfo.owner.set(commonAlbumInfo.getOwner());
        qZoneBaseAlbumMeta$AlbumInfo.name.set(commonAlbumInfo.getName());
        qZoneBaseAlbumMeta$AlbumInfo.desc.set(commonAlbumInfo.getDesc());
        qZoneBaseAlbumMeta$AlbumInfo.create_time.set(commonAlbumInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CREATE_TIME java.lang.String());
        qZoneBaseAlbumMeta$AlbumInfo.upload_number.set(commonAlbumInfo.getUploadNumber());
        qZoneBaseAlbumMeta$AlbumInfo.cover.set(i(commonAlbumInfo.getCover()));
        qZoneBaseAlbumMeta$AlbumInfo.creator.set(m(commonAlbumInfo.getCreator()));
        qZoneBaseAlbumMeta$AlbumInfo.top_flag.set(commonAlbumInfo.getTopFlag());
        qZoneBaseAlbumMeta$AlbumInfo.status.set(commonAlbumInfo.getStatus());
        return qZoneBaseAlbumMeta$AlbumInfo;
    }

    public static final ArrayList<QZoneBaseMeta$StMedia> g(List<CommonStMedia> list) {
        ArrayList<QZoneBaseMeta$StMedia> arrayList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            Iterator<CommonStMedia> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(i(it.next()));
            }
        }
        return arrayList;
    }

    public static final QZoneBaseMeta$StImage h(CommonStImage commonStImage) {
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage = new QZoneBaseMeta$StImage();
        if (commonStImage == null) {
            return qZoneBaseMeta$StImage;
        }
        qZoneBaseMeta$StImage.name.set(commonStImage.getName());
        qZoneBaseMeta$StImage.sloc.set(commonStImage.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.SLOC java.lang.String());
        qZoneBaseMeta$StImage.lloc.set(commonStImage.getLloc());
        Iterator<T> it = commonStImage.e().iterator();
        while (it.hasNext()) {
            qZoneBaseMeta$StImage.photo_url.add(j((CommonStPicSpecUrlEntry) it.next()));
        }
        qZoneBaseMeta$StImage.default_url.set(k(commonStImage.getDefaultUrl()));
        qZoneBaseMeta$StImage.is_gif.set(commonStImage.getIsGif());
        return qZoneBaseMeta$StImage;
    }

    public static final QZoneBaseMeta$StMedia i(CommonStMedia commonStMedia) {
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = new QZoneBaseMeta$StMedia();
        if (commonStMedia == null) {
            return qZoneBaseMeta$StMedia;
        }
        qZoneBaseMeta$StMedia.upload_time.set(commonStMedia.getUploadTime());
        qZoneBaseMeta$StMedia.desc.set(commonStMedia.getDesc());
        if (commonStMedia.getType() == CommonEnumMediaType.VIDEO.ordinal()) {
            qZoneBaseMeta$StMedia.type.set(1);
            qZoneBaseMeta$StMedia.video.set(l(commonStMedia.getVideo()));
        } else {
            qZoneBaseMeta$StMedia.type.set(0);
            qZoneBaseMeta$StMedia.image.set(h(commonStMedia.getImage()));
        }
        qZoneBaseMeta$StMedia.uploader.set(commonStMedia.getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String());
        qZoneBaseMeta$StMedia.batch_id.set(commonStMedia.getBatchId());
        qZoneBaseMeta$StMedia.upload_time.set(commonStMedia.getUploadTime());
        return qZoneBaseMeta$StMedia;
    }

    public static final QZoneBaseMeta$StPicSpecUrlEntry j(CommonStPicSpecUrlEntry commonStPicSpecUrlEntry) {
        QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry = new QZoneBaseMeta$StPicSpecUrlEntry();
        if (commonStPicSpecUrlEntry == null) {
            return qZoneBaseMeta$StPicSpecUrlEntry;
        }
        int spec = commonStPicSpecUrlEntry.getSpec();
        if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal()) {
            qZoneBaseMeta$StPicSpecUrlEntry.spec.set(0);
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal()) {
            qZoneBaseMeta$StPicSpecUrlEntry.spec.set(1);
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_MEDIUM.ordinal()) {
            qZoneBaseMeta$StPicSpecUrlEntry.spec.set(2);
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_SMALL.ordinal()) {
            qZoneBaseMeta$StPicSpecUrlEntry.spec.set(3);
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_THUMB.ordinal()) {
            qZoneBaseMeta$StPicSpecUrlEntry.spec.set(4);
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal()) {
            qZoneBaseMeta$StPicSpecUrlEntry.spec.set(5);
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD.ordinal()) {
            qZoneBaseMeta$StPicSpecUrlEntry.spec.set(6);
        }
        qZoneBaseMeta$StPicSpecUrlEntry.url.set(k(commonStPicSpecUrlEntry.getUrl()));
        return qZoneBaseMeta$StPicSpecUrlEntry;
    }

    public static final QZoneBaseMeta$StPicUrl k(CommonStPicUrl commonStPicUrl) {
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = new QZoneBaseMeta$StPicUrl();
        if (commonStPicUrl == null) {
            return qZoneBaseMeta$StPicUrl;
        }
        qZoneBaseMeta$StPicUrl.url.set(commonStPicUrl.getUrl());
        qZoneBaseMeta$StPicUrl.width.set(commonStPicUrl.getWidth());
        qZoneBaseMeta$StPicUrl.height.set(commonStPicUrl.getHeight());
        return qZoneBaseMeta$StPicUrl;
    }

    public static final QZoneBaseMeta$StVideo l(CommonStVideo commonStVideo) {
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = new QZoneBaseMeta$StVideo();
        if (commonStVideo == null) {
            return qZoneBaseMeta$StVideo;
        }
        qZoneBaseMeta$StVideo.f430340id.set(commonStVideo.getId());
        qZoneBaseMeta$StVideo.url.set(commonStVideo.getUrl());
        qZoneBaseMeta$StVideo.cover.set(h(commonStVideo.getCover()));
        qZoneBaseMeta$StVideo.width.set(commonStVideo.getWidth());
        qZoneBaseMeta$StVideo.height.set(commonStVideo.getHeight());
        qZoneBaseMeta$StVideo.video_time.set(commonStVideo.getVideoTime());
        return qZoneBaseMeta$StVideo;
    }

    public static final QZoneBaseMeta$StUser m(CommonStUser commonStUser) {
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = new QZoneBaseMeta$StUser();
        if (commonStUser == null) {
            return qZoneBaseMeta$StUser;
        }
        qZoneBaseMeta$StUser.uid.set(commonStUser.getUid());
        qZoneBaseMeta$StUser.nick.set(commonStUser.getNick());
        return qZoneBaseMeta$StUser;
    }

    public static final CommonStImage n(PictureItem pictureItem) {
        CommonStImage commonStImage = new CommonStImage();
        if (pictureItem == null) {
            return commonStImage;
        }
        String str = pictureItem.lloc;
        Intrinsics.checkNotNullExpressionValue(str, "this.lloc");
        commonStImage.l(str);
        String str2 = pictureItem.sloc;
        Intrinsics.checkNotNullExpressionValue(str2, "this.sloc");
        commonStImage.o(str2);
        ArrayList arrayList = new ArrayList();
        PictureUrl pictureUrl = pictureItem.currentUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = new CommonStPicSpecUrlEntry();
            commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal());
            CommonStPicUrl commonStPicUrl = new CommonStPicUrl();
            String str3 = pictureItem.currentUrl.url;
            Intrinsics.checkNotNullExpressionValue(str3, "this.currentUrl.url");
            commonStPicUrl.c(str3);
            commonStPicUrl.e(e(pictureItem.currentUrl.width));
            commonStPicUrl.b(c(pictureItem.currentUrl.height));
            commonStPicSpecUrlEntry.e(commonStPicUrl);
            arrayList.add(commonStPicSpecUrlEntry);
        }
        PictureUrl pictureUrl2 = pictureItem.bigUrl;
        if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            CommonStPicSpecUrlEntry commonStPicSpecUrlEntry2 = new CommonStPicSpecUrlEntry();
            commonStPicSpecUrlEntry2.c(CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal());
            CommonStPicUrl commonStPicUrl2 = new CommonStPicUrl();
            String str4 = pictureItem.bigUrl.url;
            Intrinsics.checkNotNullExpressionValue(str4, "this.bigUrl.url");
            commonStPicUrl2.c(str4);
            commonStPicUrl2.e(e(pictureItem.bigUrl.width));
            commonStPicUrl2.b(c(pictureItem.bigUrl.height));
            commonStPicSpecUrlEntry2.e(commonStPicUrl2);
            arrayList.add(commonStPicSpecUrlEntry2);
        }
        PictureUrl pictureUrl3 = pictureItem.downloadUrl;
        if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
            CommonStPicSpecUrlEntry commonStPicSpecUrlEntry3 = new CommonStPicSpecUrlEntry();
            commonStPicSpecUrlEntry3.c(CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD.ordinal());
            CommonStPicUrl commonStPicUrl3 = new CommonStPicUrl();
            String str5 = pictureItem.downloadUrl.url;
            Intrinsics.checkNotNullExpressionValue(str5, "this.downloadUrl.url");
            commonStPicUrl3.c(str5);
            commonStPicUrl3.e(e(pictureItem.downloadUrl.width));
            commonStPicUrl3.b(c(pictureItem.downloadUrl.height));
            commonStPicSpecUrlEntry3.e(commonStPicUrl3);
            arrayList.add(commonStPicSpecUrlEntry3);
        }
        PictureUrl pictureUrl4 = pictureItem.originUrl;
        if (pictureUrl4 != null && !TextUtils.isEmpty(pictureUrl4.url)) {
            CommonStPicSpecUrlEntry commonStPicSpecUrlEntry4 = new CommonStPicSpecUrlEntry();
            commonStPicSpecUrlEntry4.c(CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal());
            CommonStPicUrl commonStPicUrl4 = new CommonStPicUrl();
            String str6 = pictureItem.originUrl.url;
            Intrinsics.checkNotNullExpressionValue(str6, "this.originUrl.url");
            commonStPicUrl4.c(str6);
            commonStPicUrl4.e(e(pictureItem.originUrl.width));
            commonStPicUrl4.b(c(pictureItem.originUrl.height));
            commonStPicSpecUrlEntry4.e(commonStPicUrl4);
            arrayList.add(commonStPicSpecUrlEntry4);
        }
        commonStImage.e().addAll(arrayList);
        return commonStImage;
    }

    public static final CommonStVideo o(VideoInfo videoInfo) {
        CommonStVideo commonStVideo = new CommonStVideo();
        if (videoInfo == null) {
            return commonStVideo;
        }
        String str = videoInfo.videoId;
        Intrinsics.checkNotNullExpressionValue(str, "this.videoId");
        commonStVideo.j(str);
        VideoUrl videoUrl = videoInfo.videoUrl;
        String str2 = videoUrl != null ? videoUrl.url : null;
        if (str2 == null) {
            str2 = "";
        }
        commonStVideo.k(str2);
        commonStVideo.m(e(videoInfo.width));
        commonStVideo.g(c(videoInfo.height));
        commonStVideo.l(videoInfo.videoTime);
        CommonStImage commonStImage = new CommonStImage();
        String str3 = videoInfo.lloc;
        Intrinsics.checkNotNullExpressionValue(str3, "this.lloc");
        commonStImage.l(str3);
        String str4 = videoInfo.sloc;
        Intrinsics.checkNotNullExpressionValue(str4, "this.sloc");
        commonStImage.o(str4);
        ArrayList arrayList = new ArrayList();
        PictureUrl pictureUrl = videoInfo.coverUrl;
        if (!TextUtils.isEmpty(pictureUrl != null ? pictureUrl.url : null)) {
            CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = new CommonStPicSpecUrlEntry();
            commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal());
            CommonStPicUrl commonStPicUrl = new CommonStPicUrl();
            String str5 = videoInfo.coverUrl.url;
            Intrinsics.checkNotNullExpressionValue(str5, "this.coverUrl.url");
            commonStPicUrl.c(str5);
            commonStPicUrl.e(e(videoInfo.width));
            commonStPicUrl.b(c(videoInfo.height));
            commonStPicSpecUrlEntry.e(commonStPicUrl);
            arrayList.add(commonStPicSpecUrlEntry);
        }
        commonStImage.e().addAll(arrayList);
        commonStVideo.f(commonStImage);
        return commonStVideo;
    }

    public static final int c(int i3) {
        return i3 == 0 ? (ImmersiveUtils.getScreenWidth() * 4) / 3 : i3;
    }

    public static final int e(int i3) {
        return i3 == 0 ? ImmersiveUtils.getScreenWidth() : i3;
    }

    public static final int d(BusinessFeedData businessFeedData) {
        CellPictureInfo pictureInfo;
        ArrayList<PictureItem> arrayList;
        if (businessFeedData == null || businessFeedData.getPictureInfo() == null || (arrayList = (pictureInfo = businessFeedData.getPictureInfo()).pics) == null || arrayList.isEmpty()) {
            return 0;
        }
        return pictureInfo.pics.size();
    }
}
