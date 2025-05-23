package rk;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f {
    public static CellPictureInfo a(BusinessFeedData businessFeedData, VideoInfo videoInfo) {
        PictureUrl pictureUrl;
        PictureUrl pictureUrl2;
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
        return cellPictureInfo;
    }

    public static PhotoParam b(BusinessFeedData businessFeedData, VideoInfo videoInfo, BusinessFeedData businessFeedData2, CellPictureInfo cellPictureInfo) {
        CellFeedCommInfo feedCommInfo;
        User user;
        CellFeedCommInfo feedCommInfo2;
        CellFeedCommInfo feedCommInfo3;
        User user2;
        PhotoParam photoParam = new PhotoParam();
        boolean z16 = false;
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
        photoParam.commentNum = d(businessFeedData);
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
        if (arrayList != null && arrayList.size() == 1) {
            z16 = true;
        }
        photoParam.isOnePictureFeed = z16;
        photoParam.isTihFeed = businessFeedData.getFeedCommInfo().isTodayInHistoryFeed();
        photoParam.videoUgcRight = businessFeedData.getFeedCommInfo().ugcRight;
        photoParam.noNeedToFetchPhotoList = xg.f.e(businessFeedData, businessFeedData2);
        photoParam.notAllowShareOutside = xg.f.e(businessFeedData, businessFeedData2);
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
        photoParam.cell_id = c(photoParam, businessFeedData, businessFeedData2);
        photoParam.busi_param = map;
        return photoParam;
    }

    private static String c(PhotoParam photoParam, BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
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

    private static int d(BusinessFeedData businessFeedData) {
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
}
