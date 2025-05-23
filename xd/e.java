package xd;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.qzone.proxy.feedcomponent.model.CellLbsInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.CellTitleInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedpro.utils.ah;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonBytesEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellBottomRecomm;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellSummary;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellTitle;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonGPS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLikeMan;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicSpecUrlEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionExtID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import com.tencent.hippykotlin.demo.pages.qzone.data.CommonCellLike;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bE\u0010FJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J2\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018H\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\u0012\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(H\u0002J\u0012\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002J\u001a\u00103\u001a\u0002022\u0006\u00100\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u00105\u001a\u0002042\u0006\u00100\u001a\u00020\u0002H\u0002J\u0012\u00109\u001a\u0002082\b\u00107\u001a\u0004\u0018\u000106H\u0002J$\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=2\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;\u0018\u00010:H\u0002J\u001a\u0010A\u001a\u00020@2\u0006\u00100\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010D\u001a\u00020C2\u0006\u0010B\u001a\u00020\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u00a8\u0006G"}, d2 = {"Lxd/e;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellSummary;", "i", "Lcom/qzone/proxy/feedcomponent/model/CellPictureInfo;", "feedCellPicture", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellMedia;", "g", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "feedPicture", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", h.F, "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "feedVideo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonVideo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", "url", "", "spec", "Ljava/util/ArrayList;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicSpecUrlEntry;", "Lkotlin/collections/ArrayList;", "picArray", "", "a", "Lcom/qzone/proxy/feedcomponent/model/CellLbsInfo;", "lbsInfoV2", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellLBS;", "e", "Lcom/qzone/proxy/feedcomponent/model/CellCommentInfo;", "commentInfoV2", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellComment;", "c", "Lcom/qzone/proxy/feedcomponent/model/CellBottomRecomm;", "cellBottomRecomm", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellBottomRecomm;", "b", "Lcom/qzone/proxy/feedcomponent/model/CellLikeInfo;", "likeInfoV2", "Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;", "f", "Lcom/qzone/proxy/feedcomponent/model/CellTitleInfo;", "titleInfoV2", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellTitle;", "j", "feedData", "backUpFeedData", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellCommon;", "d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellUserInfo;", "k", "Lcom/qzone/proxy/feedcomponent/model/User;", "feedUser", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "l", "", "", "map", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonBytesEntry;", "o", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", DomainData.DOMAIN_NAME, "originFeedData", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "p", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: a */
    public static final e f447788a = new e();

    e() {
    }

    private final CommonCellBottomRecomm b(CellBottomRecomm cellBottomRecomm) {
        CommonCellBottomRecomm commonCellBottomRecomm = new CommonCellBottomRecomm();
        if (cellBottomRecomm == null) {
            return commonCellBottomRecomm;
        }
        commonCellBottomRecomm.setTitle(cellBottomRecomm.title);
        commonCellBottomRecomm.setIconToken(cellBottomRecomm.iconToken);
        commonCellBottomRecomm.setActionUrl(cellBottomRecomm.actionurl);
        return commonCellBottomRecomm;
    }

    private final CommonCellComment c(CellCommentInfo commentInfoV2) {
        CommonCellComment commonCellComment = new CommonCellComment();
        if (commentInfoV2 == null) {
            return commonCellComment;
        }
        commonCellComment.setNum(commentInfoV2.commentNum);
        ArrayList<Comment> arrayList = commentInfoV2.commments;
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            for (Comment comment : arrayList) {
                CommonComment commonComment = new CommonComment();
                commonComment.setTime(comment.time);
                commonComment.setUser(f447788a.l(comment.user));
                arrayList2.add(commonComment);
            }
        }
        commonCellComment.setComments(arrayList2);
        return commonCellComment;
    }

    private final CommonCellCommon d(BusinessFeedData feedData, BusinessFeedData backUpFeedData) {
        CommonCellCommon commonCellCommon = new CommonCellCommon();
        CellFeedCommInfo cellFeedCommInfo = feedData.cellFeedCommInfo;
        if (cellFeedCommInfo == null) {
            return commonCellCommon;
        }
        commonCellCommon.setUnionId(n(feedData, backUpFeedData));
        commonCellCommon.setBizId(Integer.valueOf(cellFeedCommInfo.bizId));
        Integer bizId = commonCellCommon.getBizId();
        if (bizId != null && bizId.intValue() == 2) {
            int i3 = cellFeedCommInfo.appid;
            if (i3 == 311) {
                commonCellCommon.setAppId(1);
            } else if (i3 == 4) {
                commonCellCommon.setAppId(2);
            }
        } else {
            Integer bizId2 = commonCellCommon.getBizId();
            if (bizId2 != null && bizId2.intValue() == 1) {
                commonCellCommon.setAppId(cellFeedCommInfo.appid);
            }
        }
        commonCellCommon.setSubId(cellFeedCommInfo.subid);
        commonCellCommon.setTime(cellFeedCommInfo.time / 1000);
        commonCellCommon.setFeedId(cellFeedCommInfo.feedsid);
        commonCellCommon.setClientKey(cellFeedCommInfo.clientkey);
        commonCellCommon.setCurLikeKey(cellFeedCommInfo.curlikekey);
        commonCellCommon.setExtendInfo(o(cellFeedCommInfo.extendInfo));
        commonCellCommon.setFeedType(Integer.valueOf(cellFeedCommInfo.feedsType));
        int i16 = cellFeedCommInfo.appid;
        if (i16 == 2) {
            commonCellCommon.setFeedSubType(3);
        } else if (i16 == 4) {
            commonCellCommon.setFeedSubType(2);
        } else if (i16 == 202) {
            commonCellCommon.setFeedSubType(4);
        } else if (i16 == 311) {
            commonCellCommon.setFeedSubType(1);
        }
        return commonCellCommon;
    }

    private final CommonCellLBS e(CellLbsInfo lbsInfoV2) {
        CommonCellLBS commonCellLBS = new CommonCellLBS();
        if (lbsInfoV2 == null) {
            return commonCellLBS;
        }
        commonCellLBS.setIconToken(lbsInfoV2.iconToken);
        CommonGPS commonGPS = new CommonGPS();
        commonGPS.setAlt(lbsInfoV2.gps != null ? r2.altitude : 0);
        commonGPS.setLon(lbsInfoV2.gps != null ? r2.longitude : 0);
        commonGPS.setLat(lbsInfoV2.gps != null ? r7.latitude : 0);
        CommonLBS commonLBS = new CommonLBS();
        commonLBS.setGps(commonGPS);
        commonCellLBS.setLbs(commonLBS);
        return commonCellLBS;
    }

    private final CommonCellLike f(CellLikeInfo likeInfoV2) {
        CommonCellLike commonCellLike = new CommonCellLike();
        if (likeInfoV2 == null) {
            return commonCellLike;
        }
        commonCellLike.num = likeInfoV2.likeNum;
        commonCellLike.liked = likeInfoV2.isLiked;
        ArrayList arrayList = new ArrayList();
        ArrayList<CellLikeInfo.LikeMan> arrayList2 = likeInfoV2.likeMans;
        if (arrayList2 != null) {
            for (CellLikeInfo.LikeMan likeMan : arrayList2) {
                CommonLikeMan commonLikeMan = new CommonLikeMan();
                commonLikeMan.setUser(f447788a.l(likeMan.user));
                arrayList.add(commonLikeMan);
            }
        }
        commonCellLike.likeMans = arrayList;
        commonCellLike.text = likeInfoV2.likeNumInfoFoldTxt;
        return commonCellLike;
    }

    private final CommonCellMedia g(CellPictureInfo feedCellPicture) {
        CommonCellMedia commonCellMedia = new CommonCellMedia();
        if (feedCellPicture == null) {
            return commonCellMedia;
        }
        commonCellMedia.setAlbumName(feedCellPicture.albumname);
        commonCellMedia.setAlbumId(feedCellPicture.albumid);
        commonCellMedia.setUploadNum(feedCellPicture.uploadnum);
        commonCellMedia.setBatchId(feedCellPicture.batchId);
        ArrayList arrayList = new ArrayList();
        ArrayList<PictureItem> arrayList2 = feedCellPicture.pics;
        if (arrayList2 != null) {
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(f447788a.h((PictureItem) it.next()));
            }
        }
        commonCellMedia.setMediaItems(arrayList);
        return commonCellMedia;
    }

    private final CommonMedia h(PictureItem pictureItem) {
        CommonMedia commonMedia = new CommonMedia();
        if (pictureItem == null) {
            return commonMedia;
        }
        commonMedia.setDesc(pictureItem.desc);
        if (pictureItem.videoflag == 1) {
            commonMedia.setType(1);
            CommonVideo m3 = m(pictureItem.videodata);
            CommonImage cover = m3.getCover();
            if (cover != null) {
                cover.setLloc(pictureItem.lloc);
            }
            commonMedia.setVideo(m3);
        } else {
            commonMedia.setType(0);
            CommonImage commonImage = new CommonImage();
            commonImage.setSloc(pictureItem.sloc);
            commonImage.setLloc(pictureItem.lloc);
            commonImage.setGif(pictureItem.isAutoPlayGif);
            ArrayList<CommonPicSpecUrlEntry> arrayList = new ArrayList<>();
            a(pictureItem.originUrl, 0, arrayList);
            a(pictureItem.bigUrl, 1, arrayList);
            a(pictureItem.currentUrl, 5, arrayList);
            a(pictureItem.downloadUrl, 6, arrayList);
            commonImage.setPhotoUrl(arrayList);
            commonMedia.setImage(commonImage);
        }
        return commonMedia;
    }

    private final CommonCellSummary i(BusinessFeedData feed) {
        CommonCellSummary commonCellSummary = new CommonCellSummary();
        if (feed == null) {
            return commonCellSummary;
        }
        ArrayList arrayList = new ArrayList();
        CellSummary cellSummary = feed.cellSummary;
        if (cellSummary != null) {
            arrayList.addAll(ah.f54303a.a(cellSummary.summary));
        }
        CellBottomRecomm cellBottomRecomm = feed.getCellBottomRecomm();
        if (cellBottomRecomm != null) {
            String title = cellBottomRecomm.title;
            boolean z16 = false;
            if (title != null) {
                Intrinsics.checkNotNullExpressionValue(title, "title");
                if (title.length() > 0) {
                    z16 = true;
                }
            }
            if (z16 && cellBottomRecomm.anonymity == CellBottomRecomm.TYPE_EVENT_TAG) {
                arrayList.addAll(ah.f54303a.a(cellBottomRecomm.title));
            }
        }
        commonCellSummary.setSummary(arrayList);
        return commonCellSummary;
    }

    private final CommonCellTitle j(CellTitleInfo titleInfoV2) {
        CommonCellTitle commonCellTitle = new CommonCellTitle();
        if (titleInfoV2 == null) {
            return commonCellTitle;
        }
        commonCellTitle.setTitleUrl(titleInfoV2.titleUrl);
        commonCellTitle.setTitle(ah.f54303a.a(titleInfoV2.title));
        return commonCellTitle;
    }

    private final CommonCellUserInfo k(BusinessFeedData feedData) {
        CommonCellUserInfo commonCellUserInfo = new CommonCellUserInfo();
        User user = feedData.cellUserInfo.user;
        if (user == null) {
            return commonCellUserInfo;
        }
        commonCellUserInfo.setUser(l(user));
        return commonCellUserInfo;
    }

    private final CommonUser l(User feedUser) {
        CommonUser commonUser = new CommonUser();
        if (feedUser == null) {
            return commonUser;
        }
        commonUser.setNick(feedUser.nickName);
        commonUser.setUid(feedUser.uid);
        commonUser.setUin(String.valueOf(feedUser.uin));
        return commonUser;
    }

    private final CommonVideo m(VideoInfo videoInfo) {
        String str;
        CommonVideo commonVideo = new CommonVideo();
        if (videoInfo == null) {
            return commonVideo;
        }
        commonVideo.setId(videoInfo.videoId);
        VideoUrl videoUrl = videoInfo.videoUrl;
        if (videoUrl == null || (str = videoUrl.url) == null) {
            VideoUrl videoUrl2 = videoInfo.downloadVideoUrl;
            str = videoUrl2 != null ? videoUrl2.url : null;
            if (str == null) {
                str = "";
            }
        }
        commonVideo.setUrl(str);
        CommonImage commonImage = new CommonImage();
        commonImage.setLloc(videoInfo.lloc);
        ArrayList<CommonPicSpecUrlEntry> arrayList = new ArrayList<>();
        a(videoInfo.originUrl, 0, arrayList);
        a(videoInfo.bigUrl, 1, arrayList);
        a(videoInfo.currentUrl, 5, arrayList);
        commonImage.setPhotoUrl(arrayList);
        commonVideo.setCover(commonImage);
        commonVideo.setWidth(videoInfo.width);
        commonVideo.setHeight(videoInfo.height);
        return commonVideo;
    }

    private final CommonUnionID n(BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
        CellOperationInfo operationInfo;
        String str;
        String str2;
        User user;
        CommonUnionID commonUnionID = new CommonUnionID();
        ArrayList arrayList = new ArrayList();
        CommonUnionExtID commonUnionExtID = new CommonUnionExtID();
        commonUnionExtID.setExtIdType(8);
        CellUserInfo cellUserInfo = businessFeedData.cellUserInfo;
        commonUnionExtID.setUnsignedNumeric((cellUserInfo == null || (user = cellUserInfo.user) == null) ? 0L : user.uin);
        arrayList.add(commonUnionExtID);
        CellFeedCommInfo cellFeedCommInfo = businessFeedData.cellFeedCommInfo;
        int i3 = cellFeedCommInfo != null ? cellFeedCommInfo.appid : 0;
        CommonUnionExtID commonUnionExtID2 = new CommonUnionExtID();
        commonUnionExtID2.setExtIdType(4);
        commonUnionExtID2.setNumeric(i3);
        arrayList.add(commonUnionExtID2);
        String str3 = "";
        if (i3 == 311) {
            CommonUnionExtID commonUnionExtID3 = new CommonUnionExtID();
            commonUnionExtID3.setExtIdType(5);
            CellIdInfo cellIdInfo = businessFeedData.cellIdInfo;
            if (cellIdInfo == null || (str2 = cellIdInfo.cellId) == null) {
                str2 = "";
            }
            commonUnionExtID3.setStr(str2);
            arrayList.add(commonUnionExtID3);
        }
        if (i3 == 2) {
            CommonUnionExtID commonUnionExtID4 = new CommonUnionExtID();
            commonUnionExtID4.setExtIdType(7);
            CellIdInfo cellIdInfo2 = businessFeedData.cellIdInfo;
            commonUnionExtID4.setNumeric(ef.d.k(cellIdInfo2 != null ? cellIdInfo2.cellId : null));
            arrayList.add(commonUnionExtID4);
            if (businessFeedData.cellFeedCommInfo != null) {
                CommonUnionExtID commonUnionExtID5 = new CommonUnionExtID();
                commonUnionExtID5.setExtIdType(9);
                CellIdInfo cellIdInfo3 = businessFeedData.cellIdInfo;
                commonUnionExtID5.setNumeric(ef.d.k(cellIdInfo3 != null ? cellIdInfo3.cellId : null));
                arrayList.add(commonUnionExtID5);
            }
        }
        if (i3 == 202) {
            CommonUnionExtID commonUnionExtID6 = new CommonUnionExtID();
            commonUnionExtID6.setExtIdType(6);
            CellIdInfo cellIdInfo4 = businessFeedData.cellIdInfo;
            commonUnionExtID6.setNumeric(ef.d.k(cellIdInfo4 != null ? cellIdInfo4.cellId : null));
            arrayList.add(commonUnionExtID6);
        }
        if (i3 == 4) {
            CommonUnionExtID commonUnionExtID7 = new CommonUnionExtID();
            commonUnionExtID7.setExtIdType(1);
            CellIdInfo cellIdInfo5 = businessFeedData.cellIdInfo;
            if (cellIdInfo5 != null && (str = cellIdInfo5.cellId) != null) {
                str3 = str;
            }
            commonUnionExtID7.setStr(str3);
            arrayList.add(commonUnionExtID7);
            CommonUnionExtID commonUnionExtID8 = new CommonUnionExtID();
            commonUnionExtID8.setExtIdType(3);
            Map<Integer, String> map = businessFeedData.getOperationInfo().busiParam;
            if (map == null) {
                map = (businessFeedData2 == null || (operationInfo = businessFeedData2.getOperationInfo()) == null) ? null : operationInfo.busiParam;
            }
            commonUnionExtID8.setStr(map != null ? map.get(2) : null);
            arrayList.add(commonUnionExtID8);
            CommonUnionExtID commonUnionExtID9 = new CommonUnionExtID();
            commonUnionExtID9.setExtIdType(2);
            CellIdInfo cellIdInfo6 = businessFeedData.cellIdInfo;
            commonUnionExtID9.setNumeric(ef.d.k(cellIdInfo6 != null ? cellIdInfo6.subId : null));
            arrayList.add(commonUnionExtID9);
        }
        commonUnionID.setExtIds(arrayList);
        return commonUnionID;
    }

    private final List<CommonBytesEntry> o(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                CommonBytesEntry commonBytesEntry = new CommonBytesEntry();
                commonBytesEntry.setKey(entry.getKey());
                byte[] bytes = entry.getValue().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                commonBytesEntry.setValue(new c45.a(bytes));
                arrayList.add(commonBytesEntry);
            }
        }
        return arrayList;
    }

    public final CommonFeed p(BusinessFeedData originFeedData, BusinessFeedData backUpFeedData) {
        Intrinsics.checkNotNullParameter(originFeedData, "originFeedData");
        CommonFeed commonFeed = new CommonFeed();
        commonFeed.setCellCommon(d(originFeedData, backUpFeedData));
        if (g.f53821a.b().E()) {
            commonFeed.setCellUserInfo(k(originFeedData));
            commonFeed.setCellTitle(j(originFeedData.getTitleInfoV2()));
            commonFeed.setCellSummary(i(originFeedData));
            commonFeed.setCellMedia(g(originFeedData.getPictureInfo()));
            CommonCellMedia cellMedia = commonFeed.getCellMedia();
            if (cellMedia != null) {
                CellFeedCommInfo cellFeedCommInfo = originFeedData.cellFeedCommInfo;
                cellMedia.setLongPicsBrowsingMode(cellFeedCommInfo != null ? cellFeedCommInfo.isLongPicsBrowsingMode() : false);
            }
            commonFeed.setCellLbs(e(originFeedData.getLbsInfoV2()));
            commonFeed.setCellComment(c(originFeedData.getCommentInfoV2()));
            commonFeed.setCellLike(f(originFeedData.getLikeInfoV2()));
            commonFeed.setCellBottomRecomm(b(originFeedData.getCellBottomRecomm()));
        }
        return commonFeed;
    }

    private final void a(PictureUrl url, int spec, ArrayList<CommonPicSpecUrlEntry> picArray) {
        if (url != null) {
            String url2 = url.url;
            boolean z16 = false;
            if (url2 != null) {
                Intrinsics.checkNotNullExpressionValue(url2, "url");
                if (url2.length() > 0) {
                    z16 = true;
                }
            }
            if (z16) {
                CommonPicSpecUrlEntry commonPicSpecUrlEntry = new CommonPicSpecUrlEntry();
                commonPicSpecUrlEntry.setSpec(Integer.valueOf(spec));
                CommonPicUrl commonPicUrl = new CommonPicUrl();
                String str = url.url;
                if (str == null) {
                    str = "";
                }
                commonPicUrl.setUrl(str);
                commonPicUrl.setWidth(url.width);
                commonPicUrl.setHeight(url.height);
                commonPicSpecUrlEntry.setUrl(commonPicUrl);
                picArray.add(commonPicSpecUrlEntry);
            }
        }
    }

    public static /* synthetic */ CommonFeed q(e eVar, BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            businessFeedData2 = null;
        }
        return eVar.p(businessFeedData, businessFeedData2);
    }
}
