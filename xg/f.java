package xg;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.util.ToastUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import tk.k;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f {
    public static CellPictureInfo a(BusinessFeedData businessFeedData) {
        if (businessFeedData.isFakeFeedSafe() && businessFeedData.isLongPicsBrowsingModeFeed()) {
            if (businessFeedData.getLongPicsCellPictureInfo() == null) {
                businessFeedData = businessFeedData.getOriginalInfoSafe();
            }
            return businessFeedData.getLongPicsCellPictureInfo();
        }
        if (businessFeedData.getPictureInfo() == null) {
            businessFeedData = businessFeedData.getOriginalInfoSafe();
        }
        return businessFeedData.getPictureInfo();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c8, code lost:
    
        if (r3 != 50) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PhotoParam b(Activity activity, BusinessFeedData businessFeedData, int i3, BusinessFeedData businessFeedData2) {
        Map<Integer, String> map;
        ArrayList<PictureItem> arrayList;
        ArrayList arrayList2;
        PictureItem pictureItem;
        VideoInfo videoInfo;
        int i16;
        HashMap<String, Long> D0;
        Long l3;
        long longValue;
        CellFeedCommInfo feedCommInfo;
        User user;
        CellIdInfo idInfo;
        CellIdInfo idInfo2;
        CellFeedCommInfo feedCommInfo2;
        CellFeedCommInfo feedCommInfo3;
        CellPictureInfo a16 = a(businessFeedData);
        if (a16 == null) {
            return null;
        }
        PhotoParam photoParam = new PhotoParam();
        boolean z16 = false;
        photoParam.canAddFavor = (businessFeedData.getFeedCommInfo().operatemask & 131072) != 0;
        photoParam.appid = businessFeedData.getFeedCommInfo().appid;
        photoParam.subid = businessFeedData.getFeedCommInfo().subid;
        photoParam.isLike = businessFeedData.getLikeInfo().isLiked;
        photoParam.likeNum = businessFeedData.getLikeInfo().likeNum;
        photoParam.commentNum = c(businessFeedData);
        if (businessFeedData.getUser() != null && businessFeedData.getUser().famousSpaceMedal != null) {
            photoParam.qzoneUserType = businessFeedData.getUser().famousSpaceMedal.userTypeReport;
        }
        photoParam.isSharedFeeds = businessFeedData.isForwardFeed();
        photoParam.noNeedToFetchPhotoList = e(businessFeedData, businessFeedData2);
        photoParam.videoUgcRight = businessFeedData.getFeedCommInfo().ugcRight;
        photoParam.notAllowShareOutside = e(businessFeedData, businessFeedData2);
        f(photoParam, businessFeedData, businessFeedData2);
        photoParam.albumid = a16.albumid;
        photoParam.uploadnum = a16.uploadnum;
        photoParam.albumPriv = a16.albumrights;
        ArrayList<PictureItem> arrayList3 = a16.pics;
        if (arrayList3 != null && arrayList3.size() == 1) {
            z16 = true;
        }
        photoParam.isOnePictureFeed = z16;
        photoParam.isTihFeed = businessFeedData.getFeedCommInfo().isTodayInHistoryFeed();
        if (businessFeedData.getFeedCommInfo().recomtype == 7) {
            photoParam.isFriendPhotoBizFeed = true;
        }
        int i17 = businessFeedData.getFeedCommInfo().actiontype;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 == 7) {
                    PictureViewerFactory.P(activity, a16, i3, 1204);
                    return null;
                }
                if (i17 != 8 && i17 != 9) {
                    if (i17 == 11) {
                        PictureViewerFactory.P(activity, a16, i3, 1204);
                    } else if (i17 == 12) {
                        return null;
                    }
                }
                return null;
            }
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
            if (businessFeedData2 == null) {
                idInfo = businessFeedData.getIdInfo();
            } else {
                idInfo = businessFeedData2.getIdInfo();
            }
            photoParam.cell_id = idInfo.cellId;
            if (businessFeedData2 == null) {
                idInfo2 = businessFeedData.getIdInfo();
            } else {
                idInfo2 = businessFeedData2.getIdInfo();
            }
            photoParam.cell_subId = idInfo2.subId;
            if (businessFeedData2 == null) {
                feedCommInfo2 = businessFeedData.getFeedCommInfo();
            } else {
                feedCommInfo2 = businessFeedData2.getFeedCommInfo();
            }
            photoParam.curKey = feedCommInfo2.curlikekey;
            if (businessFeedData2 == null) {
                feedCommInfo3 = businessFeedData.getFeedCommInfo();
            } else {
                feedCommInfo3 = businessFeedData2.getFeedCommInfo();
            }
            photoParam.orgKey = feedCommInfo3.orglikekey;
            map = businessFeedData.getOperationInfo().busiParam;
            if (map != null) {
                photoParam.orgKey = c6.a.g(map.get(5), photoParam.orgKey);
                photoParam.curKey = c6.a.g(map.get(6), photoParam.curKey);
            }
            photoParam.busi_param = map;
            a16.allow_share = 1;
            photoParam.isVideoPicMix = businessFeedData.isMixVideoPic();
            arrayList = a16.pics;
            if (arrayList != null && arrayList.size() > i3 && a16.pics.get(i3).videoflag == 1) {
                arrayList2 = new ArrayList(a16.pics);
                pictureItem = (PictureItem) arrayList2.get(i3);
                videoInfo = pictureItem.videodata;
                if (videoInfo != null && !TextUtils.isEmpty(videoInfo.toast) && (((i16 = videoInfo.videoStatus) != 3 || i16 != 6) && !TextUtils.isEmpty(pictureItem.localFileUrl))) {
                    videoInfo.isAutoPlay = true;
                    videoInfo.videoStatus = 9;
                    if (videoInfo.videoUrl == null) {
                        videoInfo.videoUrl = new VideoUrl(pictureItem.localFileUrl);
                    }
                    D0 = QZoneWriteOperationService.v0().D0(videoInfo.videoId);
                    if (D0 != null && D0.get("videoPlayStartTime") != null && D0.get("videoPlayEndTime") != null) {
                        l3 = D0.get("videoPlayStartTime");
                        longValue = D0.get("videoPlayEndTime").longValue() - l3.longValue();
                        if (l3.longValue() >= 0 && longValue > 0) {
                            pictureItem.videodata.videoId = "local_" + videoInfo.videoId + "#" + l3 + "#" + longValue;
                        }
                    }
                    PictureViewerFactory.S(activity, arrayList2, i3);
                    return null;
                }
            }
            return photoParam;
        }
        photoParam.ownerUin = businessFeedData.getUser().uin;
        photoParam.appid = businessFeedData.getFeedCommInfo().appid;
        photoParam.cell_id = businessFeedData.getIdInfo().cellId;
        photoParam.cell_subId = businessFeedData.getIdInfo().subId;
        photoParam.curKey = businessFeedData.getFeedCommInfo().curlikekey;
        photoParam.orgKey = businessFeedData.getFeedCommInfo().orglikekey;
        map = businessFeedData.getOperationInfo().busiParam;
        if (map != null) {
        }
        photoParam.busi_param = map;
        a16.allow_share = 1;
        photoParam.isVideoPicMix = businessFeedData.isMixVideoPic();
        arrayList = a16.pics;
        if (arrayList != null) {
            arrayList2 = new ArrayList(a16.pics);
            pictureItem = (PictureItem) arrayList2.get(i3);
            videoInfo = pictureItem.videodata;
            if (videoInfo != null) {
                videoInfo.isAutoPlay = true;
                videoInfo.videoStatus = 9;
                if (videoInfo.videoUrl == null) {
                }
                D0 = QZoneWriteOperationService.v0().D0(videoInfo.videoId);
                if (D0 != null) {
                    l3 = D0.get("videoPlayStartTime");
                    longValue = D0.get("videoPlayEndTime").longValue() - l3.longValue();
                    if (l3.longValue() >= 0) {
                        pictureItem.videodata.videoId = "local_" + videoInfo.videoId + "#" + l3 + "#" + longValue;
                    }
                }
                PictureViewerFactory.S(activity, arrayList2, i3);
                return null;
            }
        }
        return photoParam;
    }

    private static int c(BusinessFeedData businessFeedData) {
        int i3 = 0;
        if (businessFeedData.getCommentInfo().commments != null && businessFeedData.getCommentInfo().commments.size() > 0) {
            Iterator<Comment> it = businessFeedData.getCommentInfo().commments.iterator();
            while (it.hasNext()) {
                i3 += it.next().replyNum;
            }
        }
        return Math.max(businessFeedData.getCommentInfo().realCount, businessFeedData.getCommentInfo().commentNum + i3);
    }

    public static void i(Activity activity, BusinessFeedData businessFeedData) {
        String str;
        CellOperationInfo operationInfoV2;
        if (businessFeedData.isPublicAccountContent() || businessFeedData.isPublicAccountShare()) {
            CellBottomRecomm cellBottomRecomm = businessFeedData.getCellBottomRecomm();
            if (cellBottomRecomm != null && !TextUtils.isEmpty(cellBottomRecomm.jsonData)) {
                try {
                    str = new JSONObject(cellBottomRecomm.jsonData).getString(IPublicAccountBrowser.KEY_PUB_UIN);
                } catch (Exception e16) {
                    QZLog.d("QZoneFeedxPhotoClickProcess", 4, "PUBLIC_ACCOUNT_NAVIGATE_DETAIL", e16);
                }
                operationInfoV2 = businessFeedData.getOperationInfoV2();
                if (operationInfoV2 != null || TextUtils.isEmpty(str)) {
                }
                if (operationInfoV2.actionType == 63 && !TextUtils.isEmpty(operationInfoV2.actionUrl) && operationInfoV2.actionUrl.startsWith("mqqapi://qsubscribe/opendetail")) {
                    try {
                        Uri parse = Uri.parse(operationInfoV2.actionUrl);
                        com.tencent.biz.subscribe.d.p(activity, com.tencent.biz.subscribe.d.a(parse.getQueryParameter("feedId"), parse.getQueryParameter("uin"), Integer.parseInt(parse.getQueryParameter("type")), Integer.parseInt(parse.getQueryParameter("width")), Integer.parseInt(parse.getQueryParameter("height")), Long.parseLong(parse.getQueryParameter("createtime"))), 9002);
                        return;
                    } catch (Exception e17) {
                        QLog.d("QZoneFeedxPhotoClickProcess", 2, "launchSubscribeVideoDetail failed", e17);
                        return;
                    }
                }
                if (!businessFeedData.isPublicAccountShare() || TextUtils.isEmpty(operationInfoV2.qqUrl)) {
                    return;
                }
                yo.d.e(operationInfoV2.qqUrl, activity, null, null);
                return;
            }
            str = null;
            operationInfoV2 = businessFeedData.getOperationInfoV2();
            if (operationInfoV2 != null) {
            }
        }
    }

    public static void k(Activity activity, String str, Long l3, String str2, int i3, long j3, long j16) {
        vo.b.b(activity, str, l3, str2, i3, j3, j16);
    }

    public static void l(Activity activity, String str, Long l3, String str2, int i3, boolean z16) {
        vo.b.c(activity, str, l3, str2, i3, z16);
    }

    public static void j(Activity activity, BusinessFeedData businessFeedData, com.qzone.proxy.feedcomponent.model.f fVar, ImageView imageView, BusinessFeedData businessFeedData2) {
        if (businessFeedData != null) {
            if (businessFeedData.isFakeFeedSafe() && businessFeedData.isDynamicAlbumFeed()) {
                ToastUtil.n(R.string.gg6);
                return;
            }
            if (businessFeedData.isFakeFeedSafe()) {
                int a16 = fVar.a();
                if (businessFeedData.isMixFakeFeed() && businessFeedData.isVideoInVideoPicMix(a16)) {
                    if (businessFeedData.isMixFake1()) {
                        ToastUtil.n(R.string.gpx);
                        return;
                    } else {
                        if (businessFeedData.isMixFake2()) {
                            ToastUtil.n(R.string.gps);
                            return;
                        }
                        return;
                    }
                }
            }
            if (businessFeedData.isFakeFeed() && businessFeedData.isDynamicAlbumFeed()) {
                ToastUtil.n(R.string.gg6);
                return;
            }
            CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
            if (pictureInfo == null && businessFeedData.getOriginalInfoSafe() != null) {
                pictureInfo = businessFeedData.getOriginalInfoSafe().getPictureInfo();
            }
            if (pictureInfo != null) {
                int i3 = pictureInfo.actiontype;
                if (i3 == 2) {
                    String str = pictureInfo.actionurl;
                    if (businessFeedData.getFeedCommInfo().recomtype == 5) {
                        str = str + "&from_kandian=1";
                    }
                    if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str) && businessFeedData.isAppShareCardFeed()) {
                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, str, 2003, null);
                        return;
                    } else {
                        yo.d.e(str, activity, null, null);
                        return;
                    }
                }
                if (i3 != 6) {
                    if (i3 == 20) {
                        gh.c.a(activity, businessFeedData, null);
                        return;
                    }
                    if (i3 == 22) {
                        if (!businessFeedData.isQCircleShareCardFeed() && !businessFeedData.isQCircleRecommFeed()) {
                            ho.i.g().d(activity, pictureInfo.actionurl);
                            return;
                        } else {
                            yo.d.e(pictureInfo.actionurl, activity, null, null);
                            return;
                        }
                    }
                    if (i3 != 32) {
                        if (i3 != 62) {
                            h(activity, fVar, businessFeedData, imageView, businessFeedData2);
                        }
                    } else if (g(activity, fVar, businessFeedData)) {
                        ClickReport.m("565", "2", "");
                    }
                }
            }
        }
    }

    public static boolean e(BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
        return (businessFeedData == null || businessFeedData.getFeedCommInfoV2() == null || businessFeedData2 == null || businessFeedData2.getFeedCommInfoV2() == null || businessFeedData.getFeedCommInfoV2().appid != 4 || businessFeedData2.getFeedCommInfoV2().appid != 202) ? false : true;
    }

    protected static boolean g(Activity activity, com.qzone.proxy.feedcomponent.model.f fVar, BusinessFeedData businessFeedData) {
        CellPictureInfo pictureInfo;
        Map<Integer, String> map;
        if (businessFeedData == null || businessFeedData.isFakeFeed()) {
            return false;
        }
        int a16 = fVar.a();
        BusinessFeedData originalInfoSafe = businessFeedData.getOriginalInfoSafe();
        if (businessFeedData.getPictureInfo() != null) {
            pictureInfo = businessFeedData.getPictureInfo();
        } else {
            pictureInfo = originalInfoSafe.getPictureInfo();
        }
        if (pictureInfo == null) {
            return false;
        }
        if (a16 >= pictureInfo.pics.size()) {
            a16 = pictureInfo.pics.size() - 1;
        }
        int t16 = QZoneAlbumUtil.t(pictureInfo.anonymity);
        PictureItem pictureItem = pictureInfo.pics.get(a16);
        if (pictureItem != null && (map = pictureItem.busi_param) != null) {
            String str = map.get(81);
            String str2 = pictureItem.busi_param.get(80);
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str) && !TextUtils.isEmpty(str2) && TextUtils.isDigitsOnly(str2)) {
                long parseLong = Long.parseLong(str2);
                long parseLong2 = Long.parseLong(str);
                long j3 = parseLong2 < parseLong ? parseLong : parseLong2;
                l(activity, pictureInfo.albumid, Long.valueOf(businessFeedData.getUser().uin), pictureInfo.albumname, t16, pictureInfo.individualAlbum);
                k(activity, pictureInfo.albumid, Long.valueOf(businessFeedData.getUser().uin), pictureInfo.albumname, t16, parseLong, j3);
                return true;
            }
            l(activity, pictureInfo.albumid, Long.valueOf(businessFeedData.getUser().uin), pictureInfo.albumname, t16, pictureInfo.individualAlbum);
            return true;
        }
        l(activity, pictureInfo.albumid, Long.valueOf(businessFeedData.getUser().uin), pictureInfo.albumname, t16, pictureInfo.individualAlbum);
        return true;
    }

    protected static void h(Activity activity, com.qzone.proxy.feedcomponent.model.f fVar, BusinessFeedData businessFeedData, ImageView imageView, BusinessFeedData businessFeedData2) {
        CellPictureInfo a16;
        int i3;
        String C0;
        if (businessFeedData == null) {
            return;
        }
        if (!businessFeedData.isPublicAccountContent() && !businessFeedData.isPublicAccountShare()) {
            int a17 = fVar.a();
            BusinessFeedData originalInfoSafe = businessFeedData.getOriginalInfoSafe();
            if ((businessFeedData.getPictureInfo() == null && originalInfoSafe.getPictureInfo() == null) || (a16 = a(businessFeedData)) == null) {
                return;
            }
            ArrayList<PictureItem> arrayList = a16.pics;
            if (arrayList != null && arrayList.size() > a17 && a16.pics.get(a17).videoflag == 1) {
                PictureItem pictureItem = a16.pics.get(a17);
                VideoInfo videoInfo = pictureItem.videodata;
                if (videoInfo != null && videoInfo.videoStatus == 1 && (C0 = QZoneWriteOperationService.v0().C0(videoInfo.videoId)) != null) {
                    QLog.d("QZoneBaseFeedActivity", 2, "#\u540e\u53f0\u8f6c\u7801\u4e2d,onPhotoClick,cachPah=" + C0);
                    VideoInfo videoInfo2 = pictureItem.videodata;
                    videoInfo2.isAutoPlay = true;
                    videoInfo2.videoStatus = 9;
                    pictureItem.localFileUrl = C0;
                    videoInfo.videoUrl = new VideoUrl(C0);
                }
                if (videoInfo != null && !TextUtils.isEmpty(videoInfo.toast) && (((i3 = videoInfo.videoStatus) != 3 || i3 != 6) && (TextUtils.isEmpty(pictureItem.localFileUrl) || !new File(pictureItem.localFileUrl).exists()))) {
                    ToastUtil.r(videoInfo.toast);
                    return;
                }
            }
            rk.d dVar = new rk.d();
            dVar.v(a16);
            dVar.g(a17);
            dVar.t(businessFeedData.getFeedCommInfo());
            dVar.i(1204);
            dVar.x(businessFeedData.getUser().isSafeModeUser != 0);
            dVar.f(imageView);
            dVar.u(e(businessFeedData, businessFeedData2));
            dVar.w(k.f436438a.c(businessFeedData, businessFeedData2));
            if (!businessFeedData.getLocalInfo().isFakeSafe() && !d(businessFeedData, businessFeedData2)) {
                PhotoParam b16 = b(activity, businessFeedData, a17, businessFeedData2);
                if (b16 == null) {
                    return;
                }
                dVar.h(b16);
                ((rk.e) ho.i.t(rk.e.class)).t(activity, dVar);
                return;
            }
            dVar.s(true);
            ((rk.e) ho.i.t(rk.e.class)).A(activity, dVar);
            return;
        }
        i(activity, businessFeedData);
    }

    public static boolean d(BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
        if (businessFeedData2 != null) {
            return businessFeedData2.getFeedCommInfo() != null && businessFeedData2.getFeedCommInfo().appid == 7035;
        }
        if (businessFeedData != null) {
            return businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid == 7035;
        }
        return false;
    }

    private static void f(PhotoParam photoParam, BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
        CellFeedCommInfo feedCommInfo;
        CellFeedCommInfo feedCommInfo2;
        User user;
        if (photoParam == null || businessFeedData == null) {
            return;
        }
        if (businessFeedData2 == null) {
            feedCommInfo = businessFeedData.getFeedCommInfo();
        } else {
            feedCommInfo = businessFeedData2.getFeedCommInfo();
        }
        photoParam.feedId = feedCommInfo.ugckey;
        if (businessFeedData2 == null) {
            feedCommInfo2 = businessFeedData.getFeedCommInfo();
        } else {
            feedCommInfo2 = businessFeedData2.getFeedCommInfo();
        }
        photoParam.ugcKey = feedCommInfo2.ugckey;
        if (businessFeedData2 == null) {
            user = businessFeedData.getUser();
        } else {
            user = businessFeedData2.getUser();
        }
        photoParam.feedUin = user.uin;
    }
}
