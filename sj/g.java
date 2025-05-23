package sj;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import ho.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StPicSpecUrlEntry;
import qzone.QZoneBaseMeta$StPicUrl;
import qzone.QZoneBaseMeta$StVideo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J:\u0010\n\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\t\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\"\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J.\u0010#\u001a\u00020\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 J6\u0010%\u001a\u00020\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010$\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 JH\u0010-\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010&\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+JH\u0010.\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010&\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+\u00a8\u00061"}, d2 = {"Lsj/g;", "", "", "curPos", "", "Lqzone/QZoneBaseMeta$StMedia;", "initMediaList", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "g", "f", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "pictureItem", "Lqzone/QZoneBaseMeta$StImage;", "a", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "Lqzone/QZoneBaseMeta$StVideo;", "b", "width", "e", "height", "d", "businessFeedData", "Landroid/content/Context;", "context", "Landroid/widget/ImageView;", "clickView", "Lsj/f;", "spaceInfo", "", "k", "index", "j", "mediaPos", "Lcom/qzone/reborn/albumx/common/bean/a;", "batchBean", "", "attachInfo", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "albumDetailInitBean", "i", h.F, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f433870a = new g();

    g() {
    }

    private final QZoneBaseMeta$StImage a(PictureItem pictureItem) {
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage = new QZoneBaseMeta$StImage();
        if (pictureItem == null) {
            return qZoneBaseMeta$StImage;
        }
        qZoneBaseMeta$StImage.lloc.set(pictureItem.lloc);
        qZoneBaseMeta$StImage.sloc.set(pictureItem.sloc);
        ArrayList arrayList = new ArrayList();
        PictureUrl pictureUrl = pictureItem.currentUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry = new QZoneBaseMeta$StPicSpecUrlEntry();
            qZoneBaseMeta$StPicSpecUrlEntry.spec.set(5);
            QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = new QZoneBaseMeta$StPicUrl();
            qZoneBaseMeta$StPicUrl.url.set(pictureItem.currentUrl.url);
            qZoneBaseMeta$StPicUrl.width.set(e(pictureItem.currentUrl.width));
            qZoneBaseMeta$StPicUrl.height.set(d(pictureItem.currentUrl.height));
            qZoneBaseMeta$StPicSpecUrlEntry.url.set(qZoneBaseMeta$StPicUrl);
            arrayList.add(qZoneBaseMeta$StPicSpecUrlEntry);
        }
        PictureUrl pictureUrl2 = pictureItem.bigUrl;
        if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry2 = new QZoneBaseMeta$StPicSpecUrlEntry();
            qZoneBaseMeta$StPicSpecUrlEntry2.spec.set(1);
            QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl2 = new QZoneBaseMeta$StPicUrl();
            qZoneBaseMeta$StPicUrl2.url.set(pictureItem.bigUrl.url);
            qZoneBaseMeta$StPicUrl2.width.set(e(pictureItem.bigUrl.width));
            qZoneBaseMeta$StPicUrl2.height.set(d(pictureItem.bigUrl.height));
            qZoneBaseMeta$StPicSpecUrlEntry2.url.set(qZoneBaseMeta$StPicUrl2);
            arrayList.add(qZoneBaseMeta$StPicSpecUrlEntry2);
        }
        PictureUrl pictureUrl3 = pictureItem.downloadUrl;
        if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
            QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry3 = new QZoneBaseMeta$StPicSpecUrlEntry();
            qZoneBaseMeta$StPicSpecUrlEntry3.spec.set(1);
            QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl3 = new QZoneBaseMeta$StPicUrl();
            qZoneBaseMeta$StPicUrl3.url.set(pictureItem.downloadUrl.url);
            qZoneBaseMeta$StPicUrl3.width.set(e(pictureItem.downloadUrl.width));
            qZoneBaseMeta$StPicUrl3.height.set(d(pictureItem.downloadUrl.height));
            qZoneBaseMeta$StPicSpecUrlEntry3.url.set(qZoneBaseMeta$StPicUrl3);
            arrayList.add(qZoneBaseMeta$StPicSpecUrlEntry3);
        }
        PictureUrl pictureUrl4 = pictureItem.originUrl;
        if (pictureUrl4 != null && !TextUtils.isEmpty(pictureUrl4.url)) {
            QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry4 = new QZoneBaseMeta$StPicSpecUrlEntry();
            qZoneBaseMeta$StPicSpecUrlEntry4.spec.set(0);
            QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl4 = new QZoneBaseMeta$StPicUrl();
            qZoneBaseMeta$StPicUrl4.url.set(pictureItem.originUrl.url);
            qZoneBaseMeta$StPicUrl4.width.set(e(pictureItem.originUrl.width));
            qZoneBaseMeta$StPicUrl4.height.set(d(pictureItem.originUrl.height));
            qZoneBaseMeta$StPicSpecUrlEntry4.url.set(qZoneBaseMeta$StPicUrl4);
            arrayList.add(qZoneBaseMeta$StPicSpecUrlEntry4);
        }
        qZoneBaseMeta$StImage.photo_url.set(arrayList);
        return qZoneBaseMeta$StImage;
    }

    private final QZoneBaseMeta$StVideo b(VideoInfo videoInfo) {
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = new QZoneBaseMeta$StVideo();
        if (videoInfo == null) {
            return qZoneBaseMeta$StVideo;
        }
        qZoneBaseMeta$StVideo.f430340id.set(videoInfo.videoId);
        PBStringField pBStringField = qZoneBaseMeta$StVideo.url;
        VideoUrl videoUrl = videoInfo.videoUrl;
        pBStringField.set(videoUrl != null ? videoUrl.url : null);
        qZoneBaseMeta$StVideo.width.set(e(videoInfo.width));
        qZoneBaseMeta$StVideo.height.set(d(videoInfo.height));
        qZoneBaseMeta$StVideo.video_time.set(videoInfo.videoTime);
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage = new QZoneBaseMeta$StImage();
        qZoneBaseMeta$StImage.lloc.set(videoInfo.lloc);
        qZoneBaseMeta$StImage.sloc.set(videoInfo.sloc);
        ArrayList arrayList = new ArrayList();
        PictureUrl pictureUrl = videoInfo.coverUrl;
        if (!TextUtils.isEmpty(pictureUrl != null ? pictureUrl.url : null)) {
            QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry = new QZoneBaseMeta$StPicSpecUrlEntry();
            qZoneBaseMeta$StPicSpecUrlEntry.spec.set(1);
            QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = new QZoneBaseMeta$StPicUrl();
            qZoneBaseMeta$StPicUrl.url.set(videoInfo.coverUrl.url);
            qZoneBaseMeta$StPicUrl.width.set(e(videoInfo.width));
            qZoneBaseMeta$StPicUrl.height.set(d(videoInfo.height));
            qZoneBaseMeta$StPicSpecUrlEntry.url.set(qZoneBaseMeta$StPicUrl);
            arrayList.add(qZoneBaseMeta$StPicSpecUrlEntry);
        }
        qZoneBaseMeta$StImage.photo_url.set(arrayList);
        qZoneBaseMeta$StVideo.cover.set(qZoneBaseMeta$StImage);
        return qZoneBaseMeta$StVideo;
    }

    private final Pair<ArrayList<QZoneBaseMeta$StMedia>, Integer> c(int curPos, List<QZoneBaseMeta$StMedia> initMediaList) {
        int i3;
        int i16;
        ArrayList arrayList = new ArrayList();
        if (initMediaList.size() >= 30) {
            int size = initMediaList.size() - 1;
            if (curPos < 14) {
                i3 = 0;
                i16 = 29;
            } else if (curPos >= (initMediaList.size() - 1) - 14) {
                int i17 = (size - 30) + 1;
                curPos -= i17;
                i16 = size;
                i3 = i17;
            } else {
                i3 = curPos - 14;
                i16 = curPos + 14 + 1;
                curPos -= i3;
            }
            arrayList.addAll(initMediaList.subList(i3, i16 + 1));
        } else {
            arrayList.addAll(initMediaList);
        }
        return new Pair<>(arrayList, Integer.valueOf(curPos));
    }

    private final ArrayList<QZoneBaseMeta$StMedia> f(BusinessFeedData feedData) {
        CellPictureInfo pictureInfo;
        ArrayList<PictureItem> arrayList;
        ArrayList<QZoneBaseMeta$StMedia> arrayList2 = new ArrayList<>();
        if (feedData != null && feedData.getPictureInfo() != null && (arrayList = (pictureInfo = feedData.getPictureInfo()).pics) != null && !arrayList.isEmpty()) {
            Iterator<PictureItem> it = pictureInfo.pics.iterator();
            while (it.hasNext()) {
                PictureItem next = it.next();
                QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = new QZoneBaseMeta$StMedia();
                qZoneBaseMeta$StMedia.upload_time.set(next.uploadTime);
                qZoneBaseMeta$StMedia.desc.set(next.desc);
                if (next.isVideo()) {
                    qZoneBaseMeta$StMedia.type.set(1);
                    qZoneBaseMeta$StMedia.video.set(b(next.videodata));
                } else {
                    qZoneBaseMeta$StMedia.type.set(0);
                    qZoneBaseMeta$StMedia.image.set(a(next));
                }
                arrayList2.add(qZoneBaseMeta$StMedia);
            }
        }
        return arrayList2;
    }

    private final ArrayList<QZoneBaseMeta$StMedia> g(BusinessFeedData feedData) {
        ArrayList<QZoneBaseMeta$StMedia> arrayList = new ArrayList<>();
        if (feedData != null && feedData.getVideoInfo() != null) {
            VideoInfo videoInfo = feedData.getVideoInfo();
            Intrinsics.checkNotNull(videoInfo);
            QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = new QZoneBaseMeta$StMedia();
            qZoneBaseMeta$StMedia.type.set(1);
            qZoneBaseMeta$StMedia.video.set(b(videoInfo));
            qZoneBaseMeta$StMedia.desc.set(videoInfo.desc);
            arrayList.add(qZoneBaseMeta$StMedia);
        }
        return arrayList;
    }

    public final void h(Context context, ImageView clickView, int mediaPos, f spaceInfo, com.qzone.reborn.albumx.common.bean.a batchBean, String attachInfo, QZoneIntimateAlbumDetailInitBean albumDetailInitBean) {
        String str;
        Intrinsics.checkNotNullParameter(batchBean, "batchBean");
        List<CommonStMedia> j3 = batchBean.getBatchInfo().j();
        if (bl.b(j3)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = j3.iterator();
        while (it.hasNext()) {
            arrayList.add(xh.e.i((CommonStMedia) it.next()));
        }
        Pair<ArrayList<QZoneBaseMeta$StMedia>, Integer> c16 = c(mediaPos, arrayList);
        ArrayList<QZoneBaseMeta$StMedia> first = c16.getFirst();
        int intValue = c16.getSecond().intValue();
        d dVar = new d();
        dVar.j(batchBean.getAlbumId());
        dVar.k(batchBean.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
        if (spaceInfo == null || (str = spaceInfo.getSpaceId()) == null) {
            str = "";
        }
        dVar.c0(str);
        dVar.d0(spaceInfo != null ? spaceInfo.getSpaceType() : 0);
        dVar.w(first);
        dVar.x(first);
        dVar.l(clickView);
        dVar.m(intValue);
        if (attachInfo == null) {
            attachInfo = "";
        }
        dVar.a0(attachInfo);
        dVar.V(albumDetailInitBean);
        ((ck.a) i.t(ck.a.class)).a((Activity) context, dVar);
    }

    public final void i(Context context, ImageView clickView, int mediaPos, f spaceInfo, com.qzone.reborn.albumx.common.bean.a batchBean, String attachInfo, QZoneIntimateAlbumDetailInitBean albumDetailInitBean) {
        String str;
        Intrinsics.checkNotNullParameter(batchBean, "batchBean");
        List<CommonStMedia> j3 = batchBean.getBatchInfo().j();
        if (bl.b(j3)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = j3.iterator();
        while (it.hasNext()) {
            arrayList.add(xh.e.i((CommonStMedia) it.next()));
        }
        Pair<ArrayList<QZoneBaseMeta$StMedia>, Integer> c16 = c(mediaPos, arrayList);
        ArrayList<QZoneBaseMeta$StMedia> first = c16.getFirst();
        int intValue = c16.getSecond().intValue();
        d dVar = new d();
        dVar.j(batchBean.getAlbumId());
        dVar.k(batchBean.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
        if (spaceInfo == null || (str = spaceInfo.getSpaceId()) == null) {
            str = "";
        }
        dVar.c0(str);
        dVar.d0(spaceInfo != null ? spaceInfo.getSpaceType() : 0);
        dVar.w(first);
        dVar.x(first);
        dVar.l(clickView);
        dVar.m(intValue);
        if (attachInfo == null) {
            attachInfo = "";
        }
        dVar.a0(attachInfo);
        dVar.V(albumDetailInitBean);
        ((ck.a) i.t(ck.a.class)).b((Activity) context, dVar);
    }

    private final int d(int height) {
        return height == 0 ? vj.d.f441734a.f() : height;
    }

    private final int e(int width) {
        return width == 0 ? vj.d.f441734a.g() : width;
    }

    public final void j(BusinessFeedData businessFeedData, Context context, ImageView clickView, int index, f spaceInfo) {
        String str;
        if (businessFeedData == null) {
            return;
        }
        ArrayList<QZoneBaseMeta$StMedia> f16 = f(businessFeedData);
        d dVar = new d();
        CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
        dVar.j(pictureInfo != null ? pictureInfo.albumid : null);
        CellPictureInfo pictureInfo2 = businessFeedData.getPictureInfo();
        dVar.k(pictureInfo2 != null ? pictureInfo2.albumname : null);
        if (spaceInfo == null || (str = spaceInfo.getSpaceId()) == null) {
            str = "";
        }
        dVar.c0(str);
        dVar.d0(spaceInfo != null ? spaceInfo.getSpaceType() : 0);
        dVar.w(f16);
        dVar.x(f16);
        dVar.l(clickView);
        dVar.m(index);
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        String str2 = feedCommInfo != null ? feedCommInfo.feedsid : null;
        dVar.Z(str2 != null ? str2 : "");
        if (ef.b.e(businessFeedData)) {
            ((ck.a) i.t(ck.a.class)).b((Activity) context, dVar);
        } else {
            ((ck.a) i.t(ck.a.class)).c((Activity) context, dVar);
        }
    }

    public final void k(BusinessFeedData businessFeedData, Context context, ImageView clickView, f spaceInfo) {
        String str;
        if (businessFeedData == null) {
            return;
        }
        ArrayList<QZoneBaseMeta$StMedia> g16 = g(businessFeedData);
        d dVar = new d();
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        dVar.j(videoInfo != null ? videoInfo.albumid : null);
        VideoInfo videoInfo2 = businessFeedData.getVideoInfo();
        dVar.k(videoInfo2 != null ? videoInfo2.albumName : null);
        if (spaceInfo == null || (str = spaceInfo.getSpaceId()) == null) {
            str = "";
        }
        dVar.c0(str);
        dVar.d0(spaceInfo != null ? spaceInfo.getSpaceType() : 0);
        dVar.w(g16);
        dVar.x(g16);
        dVar.l(clickView);
        dVar.m(0);
        if (ef.b.e(businessFeedData)) {
            ((ck.a) i.t(ck.a.class)).b((Activity) context, dVar);
        } else {
            ((ck.a) i.t(ck.a.class)).c((Activity) context, dVar);
        }
    }
}
