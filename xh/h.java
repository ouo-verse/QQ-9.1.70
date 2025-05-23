package xh;

import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMediaComment;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMediaLike;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonStVideo;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.tencent.qqnt.kernel.nativeinterface.MediaType;
import com.tencent.qqnt.kernel.nativeinterface.PhotoSpec;
import com.tencent.qqnt.kernel.nativeinterface.StImage;
import com.tencent.qqnt.kernel.nativeinterface.StLBS;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StMediaComment;
import com.tencent.qqnt.kernel.nativeinterface.StMediaLike;
import com.tencent.qqnt.kernel.nativeinterface.StPicSpecUrlEntry;
import com.tencent.qqnt.kernel.nativeinterface.StPicUrl;
import com.tencent.qqnt.kernel.nativeinterface.StVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\n\u001a\u00020\t*\u00020\b\u001a\n\u0010\u000b\u001a\u00020\b*\u00020\t\u001a\n\u0010\u000e\u001a\u00020\r*\u00020\f\u001a\n\u0010\u0011\u001a\u00020\u0010*\u00020\u000f\u001a\n\u0010\u0014\u001a\u00020\u0013*\u00020\u0012\u001a\n\u0010\u0015\u001a\u00020\u0012*\u00020\u0013\u001a\n\u0010\u0018\u001a\u00020\u0017*\u00020\u0016\u001a\n\u0010\u0019\u001a\u00020\u0016*\u00020\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/StMedia;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "b", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/StImage;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "a", tl.h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/StVideo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;", "g", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/StMediaLike;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMediaLike;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/StMediaComment;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMediaComment;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/StPicSpecUrlEntry;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicSpecUrlEntry;", "e", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/StPicUrl;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicUrl;", "f", "k", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h {
    public static final CommonStImage a(StImage stImage) {
        Intrinsics.checkNotNullParameter(stImage, "<this>");
        CommonStImage commonStImage = new CommonStImage();
        String str = stImage.name;
        Intrinsics.checkNotNullExpressionValue(str, "this.name");
        commonStImage.m(str);
        String str2 = stImage.sloc;
        Intrinsics.checkNotNullExpressionValue(str2, "this.sloc");
        commonStImage.o(str2);
        String str3 = stImage.lloc;
        Intrinsics.checkNotNullExpressionValue(str3, "this.lloc");
        commonStImage.l(str3);
        ArrayList<StPicSpecUrlEntry> arrayList = stImage.photoUrl;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.photoUrl");
        for (StPicSpecUrlEntry it : arrayList) {
            List<CommonStPicSpecUrlEntry> e16 = commonStImage.e();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            e16.add(e(it));
        }
        StPicUrl stPicUrl = stImage.defaultUrl;
        Intrinsics.checkNotNullExpressionValue(stPicUrl, "this.defaultUrl");
        commonStImage.j(f(stPicUrl));
        commonStImage.k(stImage.isGif);
        return commonStImage;
    }

    public static final CommonStMedia b(StMedia stMedia) {
        String str;
        Intrinsics.checkNotNullParameter(stMedia, "<this>");
        CommonStMedia commonStMedia = new CommonStMedia();
        if (stMedia.type == MediaType.KMEDIATYPEIMAGE.ordinal()) {
            commonStMedia.E(CommonEnumMediaType.IMAGE.ordinal());
        } else if (stMedia.type == MediaType.KMEDIATYPEVIDEO.ordinal()) {
            commonStMedia.E(CommonEnumMediaType.VIDEO.ordinal());
        }
        StImage stImage = stMedia.image;
        Intrinsics.checkNotNullExpressionValue(stImage, "this.image");
        commonStMedia.y(a(stImage));
        StVideo stVideo = stMedia.video;
        Intrinsics.checkNotNullExpressionValue(stVideo, "this.video");
        commonStMedia.V(g(stVideo));
        commonStMedia.x(stMedia.desc);
        String str2 = stMedia.uploader;
        if (str2 == null || str2.length() == 0) {
            str = stMedia.uploadUser.uin;
        } else {
            str = stMedia.uploader;
        }
        commonStMedia.F(str);
        commonStMedia.N(stMedia.uploadUser.nick);
        commonStMedia.v(stMedia.batchId);
        commonStMedia.M(stMedia.uploadTime);
        commonStMedia.G(stMedia.uploadOrder);
        StMediaLike stMediaLike = stMedia.like;
        Intrinsics.checkNotNullExpressionValue(stMediaLike, "this.like");
        commonStMedia.A(d(stMediaLike));
        StMediaComment stMediaComment = stMedia.comment;
        Intrinsics.checkNotNullExpressionValue(stMediaComment, "this.comment");
        commonStMedia.w(c(stMediaComment));
        commonStMedia.D(stMedia.shootTime);
        StLBS stLBS = stMedia.lbs;
        Intrinsics.checkNotNullExpressionValue(stLBS, "this.lbs");
        commonStMedia.z(g.a(stLBS));
        commonStMedia.B(stMedia.linkId);
        ArrayList<Integer> arrayList = stMedia.opMask;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.opMask");
        commonStMedia.C(arrayList);
        return commonStMedia;
    }

    public static final CommonStMediaComment c(StMediaComment stMediaComment) {
        Intrinsics.checkNotNullParameter(stMediaComment, "<this>");
        CommonStMediaComment commonStMediaComment = new CommonStMediaComment();
        commonStMediaComment.b(stMediaComment.num);
        return commonStMediaComment;
    }

    public static final CommonStMediaLike d(StMediaLike stMediaLike) {
        Intrinsics.checkNotNullParameter(stMediaLike, "<this>");
        CommonStMediaLike commonStMediaLike = new CommonStMediaLike();
        String str = stMediaLike.key;
        Intrinsics.checkNotNullExpressionValue(str, "this.key");
        commonStMediaLike.e(str);
        commonStMediaLike.g(stMediaLike.num);
        commonStMediaLike.f(stMediaLike.liked ? 1 : 0);
        return commonStMediaLike;
    }

    public static final CommonStPicSpecUrlEntry e(StPicSpecUrlEntry stPicSpecUrlEntry) {
        Intrinsics.checkNotNullParameter(stPicSpecUrlEntry, "<this>");
        CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = new CommonStPicSpecUrlEntry();
        int i3 = stPicSpecUrlEntry.spec;
        if (i3 == PhotoSpec.KPHOTOSPECORIGIN.ordinal()) {
            commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal());
        } else if (i3 == PhotoSpec.KPHOTOSPECBIG.ordinal()) {
            commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal());
        } else if (i3 == PhotoSpec.KPHOTOSPECMEDIUM.ordinal()) {
            commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_MEDIUM.ordinal());
        } else if (i3 == PhotoSpec.KPHOTOSPECSMALL.ordinal()) {
            commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_SMALL.ordinal());
        } else if (i3 == PhotoSpec.KPHOTOSPECTHUMB.ordinal()) {
            commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_THUMB.ordinal());
        } else if (i3 == PhotoSpec.KPHOTOSPECCURRENT.ordinal()) {
            commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal());
        } else if (i3 == PhotoSpec.KPHOTOSPECDOWNLOAD.ordinal()) {
            commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD.ordinal());
        } else {
            commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal());
        }
        StPicUrl stPicUrl = stPicSpecUrlEntry.url;
        Intrinsics.checkNotNullExpressionValue(stPicUrl, "this.url");
        commonStPicSpecUrlEntry.e(f(stPicUrl));
        return commonStPicSpecUrlEntry;
    }

    public static final CommonStPicUrl f(StPicUrl stPicUrl) {
        Intrinsics.checkNotNullParameter(stPicUrl, "<this>");
        CommonStPicUrl commonStPicUrl = new CommonStPicUrl();
        String str = stPicUrl.url;
        Intrinsics.checkNotNullExpressionValue(str, "this.url");
        commonStPicUrl.c(str);
        commonStPicUrl.e(stPicUrl.width);
        commonStPicUrl.b(stPicUrl.height);
        return commonStPicUrl;
    }

    public static final CommonStVideo g(StVideo stVideo) {
        Intrinsics.checkNotNullParameter(stVideo, "<this>");
        CommonStVideo commonStVideo = new CommonStVideo();
        String str = stVideo.f359227id;
        Intrinsics.checkNotNullExpressionValue(str, "this.id");
        commonStVideo.j(str);
        String str2 = stVideo.url;
        Intrinsics.checkNotNullExpressionValue(str2, "this.url");
        commonStVideo.k(str2);
        StImage stImage = stVideo.cover;
        Intrinsics.checkNotNullExpressionValue(stImage, "this.cover");
        commonStVideo.f(a(stImage));
        commonStVideo.m(stVideo.width);
        commonStVideo.g(stVideo.height);
        commonStVideo.l(stVideo.videoTime);
        ArrayList<StPicSpecUrlEntry> arrayList = stVideo.videoUrl;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.videoUrl");
        for (StPicSpecUrlEntry it : arrayList) {
            List<CommonStPicSpecUrlEntry> e16 = commonStVideo.e();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            e16.add(e(it));
        }
        return commonStVideo;
    }

    public static final StImage h(CommonStImage commonStImage) {
        Intrinsics.checkNotNullParameter(commonStImage, "<this>");
        StImage stImage = new StImage();
        stImage.name = commonStImage.getName();
        stImage.sloc = commonStImage.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.SLOC java.lang.String();
        stImage.lloc = commonStImage.getLloc();
        Iterator<T> it = commonStImage.e().iterator();
        while (it.hasNext()) {
            stImage.photoUrl.add(j((CommonStPicSpecUrlEntry) it.next()));
        }
        stImage.defaultUrl = k(commonStImage.getDefaultUrl());
        stImage.isGif = commonStImage.getIsGif();
        return stImage;
    }

    public static final StMedia i(CommonStMedia commonStMedia) {
        Intrinsics.checkNotNullParameter(commonStMedia, "<this>");
        StMedia stMedia = new StMedia();
        if (commonStMedia.getType() == CommonEnumMediaType.IMAGE.ordinal()) {
            stMedia.type = MediaType.KMEDIATYPEIMAGE.ordinal();
        } else if (commonStMedia.getType() == CommonEnumMediaType.VIDEO.ordinal()) {
            stMedia.type = MediaType.KMEDIATYPEVIDEO.ordinal();
        }
        stMedia.image = h(commonStMedia.getImage());
        stMedia.video = l(commonStMedia.getVideo());
        stMedia.desc = commonStMedia.getDesc();
        stMedia.uploader = commonStMedia.getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String();
        stMedia.batchId = commonStMedia.getBatchId();
        stMedia.uploadTime = commonStMedia.getUploadTime();
        stMedia.shootTime = commonStMedia.getShootTime();
        stMedia.linkId = commonStMedia.getLinkId();
        stMedia.opMask = commonStMedia.n();
        return stMedia;
    }

    public static final StPicSpecUrlEntry j(CommonStPicSpecUrlEntry commonStPicSpecUrlEntry) {
        Intrinsics.checkNotNullParameter(commonStPicSpecUrlEntry, "<this>");
        StPicSpecUrlEntry stPicSpecUrlEntry = new StPicSpecUrlEntry();
        int spec = commonStPicSpecUrlEntry.getSpec();
        if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal()) {
            stPicSpecUrlEntry.spec = PhotoSpec.KPHOTOSPECORIGIN.ordinal();
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal()) {
            stPicSpecUrlEntry.spec = PhotoSpec.KPHOTOSPECBIG.ordinal();
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_MEDIUM.ordinal()) {
            stPicSpecUrlEntry.spec = PhotoSpec.KPHOTOSPECMEDIUM.ordinal();
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_SMALL.ordinal()) {
            stPicSpecUrlEntry.spec = PhotoSpec.KPHOTOSPECSMALL.ordinal();
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_THUMB.ordinal()) {
            stPicSpecUrlEntry.spec = PhotoSpec.KPHOTOSPECTHUMB.ordinal();
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal()) {
            stPicSpecUrlEntry.spec = PhotoSpec.KPHOTOSPECCURRENT.ordinal();
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD.ordinal()) {
            stPicSpecUrlEntry.spec = PhotoSpec.KPHOTOSPECDOWNLOAD.ordinal();
        } else {
            stPicSpecUrlEntry.spec = PhotoSpec.KPHOTOSPECORIGIN.ordinal();
        }
        stPicSpecUrlEntry.url = k(commonStPicSpecUrlEntry.getUrl());
        return stPicSpecUrlEntry;
    }

    public static final StPicUrl k(CommonStPicUrl commonStPicUrl) {
        Intrinsics.checkNotNullParameter(commonStPicUrl, "<this>");
        StPicUrl stPicUrl = new StPicUrl();
        stPicUrl.url = commonStPicUrl.getUrl();
        stPicUrl.width = commonStPicUrl.getWidth();
        stPicUrl.height = commonStPicUrl.getHeight();
        return stPicUrl;
    }

    public static final StVideo l(CommonStVideo commonStVideo) {
        Intrinsics.checkNotNullParameter(commonStVideo, "<this>");
        StVideo stVideo = new StVideo();
        stVideo.f359227id = commonStVideo.getId();
        stVideo.url = commonStVideo.getUrl();
        stVideo.cover = h(commonStVideo.getCover());
        stVideo.width = commonStVideo.getWidth();
        stVideo.height = commonStVideo.getHeight();
        stVideo.videoTime = commonStVideo.getVideoTime();
        Iterator<T> it = commonStVideo.e().iterator();
        while (it.hasNext()) {
            stVideo.videoUrl.add(j((CommonStPicSpecUrlEntry) it.next()));
        }
        return stVideo;
    }
}
