package xg;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qzone.commoncode.module.videorecommend.utils.WeishiHelper;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.qzone.util.ToastUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import tk.k;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g {

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f447951a;

        /* renamed from: b, reason: collision with root package name */
        public QZoneVideoItemWidgetView f447952b;
    }

    private static String a(PhotoParam photoParam, BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
        CellIdInfo idInfo;
        if (!TextUtils.isEmpty(photoParam.albumid)) {
            return photoParam.albumid;
        }
        if (businessFeedData2 == null) {
            idInfo = businessFeedData.getIdInfo();
        } else {
            idInfo = businessFeedData2.getIdInfo();
        }
        return idInfo.cellId;
    }

    private static int b(BusinessFeedData businessFeedData) {
        if (businessFeedData.getCommentInfo().realCount > 0) {
            return businessFeedData.getCommentInfo().realCount;
        }
        int i3 = 0;
        if (businessFeedData.getCommentInfo().commments != null && businessFeedData.getCommentInfo().commments.size() > 0) {
            Iterator<Comment> it = businessFeedData.getCommentInfo().commments.iterator();
            while (it.hasNext()) {
                i3 += it.next().replyNum;
            }
        }
        return businessFeedData.getCommentInfo().commentNum + i3;
    }

    private static boolean d(String str) {
        return (WeishiHelper.isWeishiVideoLayerScheme(str) || WeishiHelper.isWeishiScheme(str) || WeishiHelper.isVerticalNormalVideoLayerSchema(str) || WeishiHelper.isLandscapevideolayerSchema(str)) ? false : true;
    }

    private static void e(BusinessFeedData businessFeedData, Context context) {
        String str;
        CellOperationInfo operationInfoV2;
        if (businessFeedData.isPublicAccountContent() || businessFeedData.isPublicAccountShare()) {
            CellBottomRecomm cellBottomRecomm = businessFeedData.getCellBottomRecomm();
            if (cellBottomRecomm != null && !TextUtils.isEmpty(cellBottomRecomm.jsonData)) {
                try {
                    str = new JSONObject(cellBottomRecomm.jsonData).getString(IPublicAccountBrowser.KEY_PUB_UIN);
                } catch (Exception e16) {
                    QZLog.d("QZoneVideo_QZoneFeedxSingleVideoItemClickProcess", 4, "PUBLIC_ACCOUNT_NAVIGATE_DETAIL", e16);
                }
                operationInfoV2 = businessFeedData.getOperationInfoV2();
                if (operationInfoV2 != null || TextUtils.isEmpty(str)) {
                }
                if (operationInfoV2.actionType == 63 && !TextUtils.isEmpty(operationInfoV2.actionUrl) && operationInfoV2.actionUrl.startsWith("mqqapi://qsubscribe/opendetail")) {
                    try {
                        Uri parse = Uri.parse(operationInfoV2.actionUrl);
                        com.tencent.biz.subscribe.d.p(com.qzone.reborn.feedx.widget.i.b(context), com.tencent.biz.subscribe.d.a(parse.getQueryParameter("feedId"), parse.getQueryParameter("uin"), Integer.parseInt(parse.getQueryParameter("type")), Integer.parseInt(parse.getQueryParameter("width")), Integer.parseInt(parse.getQueryParameter("height")), Long.parseLong(parse.getQueryParameter("createtime"))), 9002);
                        return;
                    } catch (Exception e17) {
                        QLog.d("QZoneVideo_QZoneFeedxSingleVideoItemClickProcess", 2, "launchSubscribeVideoDetail failed", e17);
                        return;
                    }
                }
                if (!businessFeedData.isPublicAccountShare() || TextUtils.isEmpty(operationInfoV2.qqUrl)) {
                    return;
                }
                yo.d.b(context, new yo.g(operationInfoV2.qqUrl, null));
                return;
            }
            str = null;
            operationInfoV2 = businessFeedData.getOperationInfoV2();
            if (operationInfoV2 != null) {
            }
        }
    }

    public static void f(BusinessFeedData businessFeedData, int i3, Context context, a aVar, BusinessFeedData businessFeedData2, long j3) {
        PictureUrl pictureUrl;
        PictureUrl pictureUrl2;
        CellFeedCommInfo feedCommInfo;
        User user;
        CellFeedCommInfo feedCommInfo2;
        CellFeedCommInfo feedCommInfo3;
        User user2;
        if (businessFeedData == null) {
            QZLog.e("onSingleAlbumVideoClick", "bfd == null");
            return;
        }
        RFWLog.d("QZoneVideo_QZoneFeedxSingleVideoItemClickProcess", RFWLog.USR, "onSingleAlbumVideoClick feed id :" + businessFeedData.getFeedCommInfo().feedsid);
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (videoInfo == null && businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getVideoInfo() != null) {
            videoInfo = businessFeedData.getOriginalInfo().getVideoInfo();
        }
        if (videoInfo == null) {
            QZLog.e("onSingleAlbumVideoClick", "videoInfo == null");
            return;
        }
        if (xm.c.c() && videoInfo.isFakeFeed) {
            ToastUtil.n(R.string.gpy);
            return;
        }
        if (xm.c.e(businessFeedData)) {
            com.qzone.reborn.qqvideo.layer.d.k(businessFeedData, context, aVar, j3);
            return;
        }
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        cellPictureInfo.pics = new ArrayList<>();
        PictureItem pictureItem = new PictureItem();
        pictureItem.sloc = videoInfo.sloc;
        pictureItem.lloc = videoInfo.lloc;
        pictureItem.videodata = videoInfo;
        pictureItem.videoflag = 1;
        pictureItem.likeCount = businessFeedData.getLikeInfo().likeNum;
        pictureItem.isLike = businessFeedData.getLikeInfo().isLiked;
        pictureItem.commentCount = businessFeedData.getCommentInfo().commentNum;
        pictureItem.albumId = videoInfo.albumid;
        pictureItem.busi_param = businessFeedData.getOperationInfo().busiParam;
        pictureItem.currentUrl = videoInfo.currentUrl;
        PictureUrl pictureUrl3 = videoInfo.bigUrl;
        if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
            pictureItem.bigUrl = videoInfo.bigUrl;
        }
        PictureUrl pictureUrl4 = videoInfo.originUrl;
        if (pictureUrl4 != null && !TextUtils.isEmpty(pictureUrl4.url)) {
            pictureItem.originUrl = videoInfo.originUrl;
        }
        PictureUrl pictureUrl5 = pictureItem.bigUrl;
        if ((pictureUrl5 == null || TextUtils.isEmpty(pictureUrl5.url)) && (pictureUrl = videoInfo.coverUrl) != null && !TextUtils.isEmpty(pictureUrl.url)) {
            pictureItem.bigUrl = videoInfo.coverUrl;
        }
        PictureUrl pictureUrl6 = pictureItem.currentUrl;
        if ((pictureUrl6 == null || TextUtils.isEmpty(pictureUrl6.url)) && (pictureUrl2 = videoInfo.coverUrl) != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            pictureItem.currentUrl = videoInfo.coverUrl;
        }
        cellPictureInfo.pics.add(pictureItem);
        cellPictureInfo.uin = businessFeedData.getUser().uin;
        cellPictureInfo.albumid = videoInfo.albumid;
        cellPictureInfo.anonymity = videoInfo.anonymity;
        cellPictureInfo.uniKey = businessFeedData.getFeedCommInfo().orglikekey;
        cellPictureInfo.actionurl = videoInfo.actionUrl;
        PhotoParam photoParam = new PhotoParam();
        photoParam.canAddFavor = (businessFeedData.getFeedCommInfo().operatemask & 131072) != 0;
        if (businessFeedData2 == null) {
            feedCommInfo = businessFeedData.getFeedCommInfo();
        } else {
            feedCommInfo = businessFeedData2.getFeedCommInfo();
        }
        photoParam.appid = feedCommInfo.appid;
        if (businessFeedData2 == null) {
            user = businessFeedData.getUser();
        } else {
            user = businessFeedData2.getUser();
        }
        photoParam.ownerUin = user.uin;
        photoParam.subid = businessFeedData.getFeedCommInfo().subid;
        photoParam.isLike = businessFeedData.getLikeInfo().isLiked;
        photoParam.likeNum = businessFeedData.getLikeInfo().likeNum;
        photoParam.commentNum = b(businessFeedData);
        if (businessFeedData2 == null) {
            feedCommInfo2 = businessFeedData.getFeedCommInfo();
        } else {
            feedCommInfo2 = businessFeedData2.getFeedCommInfo();
        }
        photoParam.feedId = feedCommInfo2.ugckey;
        if (businessFeedData2 == null) {
            feedCommInfo3 = businessFeedData.getFeedCommInfo();
        } else {
            feedCommInfo3 = businessFeedData2.getFeedCommInfo();
        }
        photoParam.ugcKey = feedCommInfo3.ugckey;
        if (businessFeedData.getUser() != null && businessFeedData.getUser().famousSpaceMedal != null) {
            photoParam.qzoneUserType = businessFeedData.getUser().famousSpaceMedal.userTypeReport;
        }
        photoParam.isSharedFeeds = businessFeedData.isForwardFeed();
        if (businessFeedData2 == null) {
            user2 = businessFeedData.getUser();
        } else {
            user2 = businessFeedData2.getUser();
        }
        photoParam.feedUin = user2.uin;
        photoParam.albumid = cellPictureInfo.albumid;
        photoParam.uploadnum = cellPictureInfo.uploadnum;
        photoParam.albumPriv = cellPictureInfo.albumrights;
        ArrayList<PictureItem> arrayList = cellPictureInfo.pics;
        photoParam.isOnePictureFeed = arrayList != null && arrayList.size() == 1;
        photoParam.isTihFeed = businessFeedData.getFeedCommInfo().isTodayInHistoryFeed();
        photoParam.videoUgcRight = businessFeedData.getFeedCommInfo().ugcRight;
        photoParam.noNeedToFetchPhotoList = f.e(businessFeedData, businessFeedData2);
        photoParam.notAllowShareOutside = f.e(businessFeedData, businessFeedData2);
        photoParam.singleVideoQCircleSchema = videoInfo.mAfterLayerJumpUrl;
        Map<Integer, String> map = businessFeedData.getOperationInfo().busiParam;
        if (map != null) {
            photoParam.orgKey = c6.a.g(map.get(5), photoParam.orgKey);
            String g16 = c6.a.g(map.get(6), photoParam.curKey);
            photoParam.curKey = g16;
            if (TextUtils.isEmpty(g16)) {
                photoParam.curKey = businessFeedData.getFeedCommInfo().curlikekey;
            }
            if (TextUtils.isEmpty(photoParam.orgKey)) {
                photoParam.orgKey = businessFeedData.getFeedCommInfo().orglikekey;
            }
        }
        photoParam.cell_id = a(photoParam, businessFeedData, businessFeedData2);
        photoParam.busi_param = map;
        int a16 = new com.qzone.proxy.feedcomponent.model.f(i3, 0, false, true).a();
        rk.d dVar = new rk.d();
        dVar.v(cellPictureInfo);
        dVar.r(businessFeedData);
        dVar.g(a16);
        dVar.t(businessFeedData.getFeedCommInfo());
        dVar.h(photoParam);
        dVar.i(1204);
        dVar.x(businessFeedData.getUser().isSafeModeUser != 0);
        dVar.w(k.f436438a.c(businessFeedData, businessFeedData2));
        if (aVar != null && aVar.f447951a != null && !businessFeedData.isQQVideoFeeds()) {
            dVar.f(aVar.f447951a);
        }
        if (c(businessFeedData, businessFeedData2)) {
            dVar.s(true);
            ((rk.e) ho.i.t(rk.e.class)).A(com.qzone.reborn.feedx.widget.i.b(context), dVar);
        } else {
            ((rk.e) ho.i.t(rk.e.class)).t(com.qzone.reborn.feedx.widget.i.b(context), dVar);
        }
    }

    private static void h(boolean z16) {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(800, z16 ? 3 : 2, 4), false, false);
    }

    public static void g(BusinessFeedData businessFeedData, Context context, int i3, long j3, a aVar, BusinessFeedData businessFeedData2) {
        boolean z16;
        boolean z17;
        VideoUrl videoUrl;
        if (businessFeedData == null) {
            QZLog.w("QZoneVideo_QZoneFeedxSingleVideoItemClickProcess", "video clicked: businessFeedData == null");
            return;
        }
        if (businessFeedData.getFeedCommInfo() != null) {
            z16 = businessFeedData.getFeedCommInfo().isLikeRecommFamousFeed();
            z17 = businessFeedData.isCircleFriendLikeVideoRecomm();
        } else {
            z16 = false;
            z17 = false;
        }
        if (z16 && !z17) {
            h(false);
        }
        if (businessFeedData.isQCircleRecommFeed() && businessFeedData.getCellBottomRecomm() != null) {
            ho.i.q(context, businessFeedData.getCellBottomRecomm().actionurl);
            return;
        }
        if (businessFeedData.isQCircleShareCardFeed() && businessFeedData.getVideoInfo() != null && !TextUtils.isEmpty(businessFeedData.getVideoInfo().actionUrl)) {
            eg.f.l(businessFeedData, context, aVar, j3);
            return;
        }
        if (businessFeedData.isPublicAccountContent()) {
            e(businessFeedData, context);
            return;
        }
        if (businessFeedData.getVideoInfo() != null && businessFeedData.getVideoInfo().videoStatus == 3) {
            QZLog.w("QZoneVideo_QZoneFeedxSingleVideoItemClickProcess", "video clicked: videoStatus == 3");
            return;
        }
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (videoInfo == null && businessFeedData.getOriginalInfo() != null) {
            videoInfo = businessFeedData.getOriginalInfo().getVideoInfo();
        }
        String str = null;
        if (videoInfo != null) {
            CellLocalInfo cellLocalInfo = businessFeedData.cellLocalInfo;
            if (cellLocalInfo != null && !TextUtils.isEmpty(cellLocalInfo.videoLocalUrl)) {
                str = businessFeedData.cellLocalInfo.videoLocalUrl;
            }
            QZLog.i("QZoneVideo_QZoneFeedxSingleVideoItemClickProcess", "videoLocalFileUrl: " + str);
        }
        if (videoInfo != null && videoInfo.videoStatus == 1 && TextUtils.isEmpty(str)) {
            ToastUtil.r(videoInfo.toast);
            return;
        }
        if (videoInfo != null && videoInfo.actionType == 23 && !TextUtils.isEmpty(videoInfo.actionUrl) && d(videoInfo.actionUrl)) {
            RFWLog.d("QZoneVideo_QZoneFeedxSingleVideoItemClickProcess", RFWLog.USR, "processSingleVideoItemClick scheme: " + videoInfo.actionUrl);
            ho.i.q(context, videoInfo.actionUrl);
        } else if (videoInfo != null && videoInfo.videoStatus == 1 && !TextUtils.isEmpty(str) && new File(str).exists()) {
            RFWLog.d("QZoneVideo_QZoneFeedxSingleVideoItemClickProcess", RFWLog.USR, "processSingleVideoItemClick _enum_transfering");
            VideoInfo videoInfo2 = businessFeedData.cellVideoInfo;
            if (videoInfo2 != null && ((videoUrl = videoInfo2.videoUrl) == null || TextUtils.isEmpty(videoUrl.url))) {
                VideoUrl videoUrl2 = new VideoUrl();
                videoUrl2.url = str;
                RFWLog.d("QZoneVideo_QZoneFeedxSingleVideoItemClickProcess", RFWLog.USR, "processSingleVideoItemClick local video: old: " + businessFeedData.cellVideoInfo.videoUrl + ", new: " + videoUrl2);
                businessFeedData.cellVideoInfo.videoUrl = videoUrl2;
            }
            f(businessFeedData, i3, context, aVar, businessFeedData2, j3);
        } else {
            RFWLog.d("QZoneVideo_QZoneFeedxSingleVideoItemClickProcess", RFWLog.USR, "processSingleVideoItemClick normal");
            f(businessFeedData, i3, context, aVar, businessFeedData2, j3);
        }
        QZLog.i("QZoneVideo_QZoneFeedxSingleVideoItemClickProcess", 1, "end of auto video click.");
    }

    public static boolean c(BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
        if (businessFeedData2 != null) {
            return businessFeedData2.getFeedCommInfo() != null && businessFeedData2.getFeedCommInfo().appid == 7035;
        }
        if (businessFeedData != null) {
            return businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid == 7035;
        }
        return false;
    }
}
