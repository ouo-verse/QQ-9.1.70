package ua0;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.utils.aa;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StHotTagInfo;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;
import tianshu.QQCircleTianShu$AdItem;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends QCircleLpReportDc05501.DataBuilder {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f438614a;

        a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f438614a = feedCloudMeta$StFeed;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        @Override // cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mergeFrom() {
            boolean z16;
            PBBytesField pBBytesField;
            QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f438614a;
            if (feedCloudMeta$StFeed != null && (pBBytesField = feedCloudMeta$StFeed.reportInfoForClient) != null && pBBytesField.has()) {
                try {
                    qQCircleFeedBase$StReportInfoForClient.mergeFrom(this.f438614a.reportInfoForClient.get().toByteArray());
                    setFeedType1(qQCircleFeedBase$StReportInfoForClient.feedtype1.get());
                    setFeedType2(qQCircleFeedBase$StReportInfoForClient.feedtype2.get());
                    setFeedType3(qQCircleFeedBase$StReportInfoForClient.feedtype3.get());
                    z16 = true;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (z16) {
                    int[] reportFeedType = QCirclePluginUtil.getReportFeedType(this.f438614a);
                    setFeedType1(reportFeedType[0]);
                    setFeedType2(reportFeedType[1]);
                    return;
                }
                return;
            }
            z16 = false;
            if (z16) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b extends QCircleLpReportDc05502.DataBuilder {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f438615a;

        b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f438615a = feedCloudMeta$StFeed;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        @Override // cooperation.qqcircle.report.QCircleLpReportDc05502.DataBuilder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mergeFrom() {
            boolean z16;
            PBBytesField pBBytesField;
            QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f438615a;
            if (feedCloudMeta$StFeed != null && (pBBytesField = feedCloudMeta$StFeed.reportInfoForClient) != null && pBBytesField.has()) {
                try {
                    qQCircleFeedBase$StReportInfoForClient.mergeFrom(this.f438615a.reportInfoForClient.get().toByteArray());
                    setFeedType1(qQCircleFeedBase$StReportInfoForClient.feedtype1.get());
                    setFeedType2(qQCircleFeedBase$StReportInfoForClient.feedtype2.get());
                    setFeedType3(qQCircleFeedBase$StReportInfoForClient.feedtype3.get());
                    z16 = true;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (z16) {
                    int[] reportFeedType = QCirclePluginUtil.getReportFeedType(this.f438615a);
                    setFeedType1(reportFeedType[0]);
                    setFeedType2(reportFeedType[1]);
                    return;
                }
                return;
            }
            z16 = false;
            if (z16) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ua0.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C11333c extends QCircleLpReportDc05507.DataBuilder {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f438616a;

        C11333c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f438616a = feedCloudMeta$StFeed;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
        @Override // cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mergeFrom() {
            boolean z16;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
            FeedCloudMeta$StUser feedCloudMeta$StUser;
            String str;
            PBBytesField pBBytesField;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.f438616a;
            if (feedCloudMeta$StFeed3 != null && (pBBytesField = feedCloudMeta$StFeed3.reportInfoForClient) != null && pBBytesField.has()) {
                try {
                    QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
                    qQCircleFeedBase$StReportInfoForClient.mergeFrom(this.f438616a.reportInfoForClient.get().toByteArray());
                    setFeedType1(qQCircleFeedBase$StReportInfoForClient.feedtype1.get());
                    setFeedType2(qQCircleFeedBase$StReportInfoForClient.feedtype2.get());
                    setFeedType3(qQCircleFeedBase$StReportInfoForClient.feedtype3.get());
                    z16 = true;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (!z16) {
                    int[] reportFeedType = QCirclePluginUtil.getReportFeedType(this.f438616a);
                    setFeedType1(reportFeedType[0]);
                    setFeedType2(reportFeedType[1]);
                }
                feedCloudMeta$StFeed = this.f438616a;
                if (feedCloudMeta$StFeed != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null) {
                    if (!QCirclePluginUtil.isAuth(feedCloudMeta$StUser.get())) {
                        str = "2";
                    } else {
                        str = "1";
                    }
                    setVideoType(str);
                }
                feedCloudMeta$StFeed2 = this.f438616a;
                if (feedCloudMeta$StFeed2 == null && feedCloudMeta$StFeed2.extInfo.has()) {
                    String d16 = bh.d(this.f438616a.extInfo.get(), "tmpl_id");
                    if (!TextUtils.isEmpty(d16)) {
                        setTmplId(d16);
                        return;
                    }
                    return;
                }
            }
            z16 = false;
            if (!z16) {
            }
            feedCloudMeta$StFeed = this.f438616a;
            if (feedCloudMeta$StFeed != null) {
                if (!QCirclePluginUtil.isAuth(feedCloudMeta$StUser.get())) {
                }
                setVideoType(str);
            }
            feedCloudMeta$StFeed2 = this.f438616a;
            if (feedCloudMeta$StFeed2 == null) {
            }
        }
    }

    public static QCircleLpReportDc05501.DataBuilder a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        a aVar = new a(feedCloudMeta$StFeed);
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QCirclePluginReportUtil", 1, "feed == null");
            return aVar;
        }
        aVar.setFeedId(feedCloudMeta$StFeed.f398449id.get());
        aVar.setFeedTag(QCirclePluginUtil.getFeedTagName(feedCloudMeta$StFeed));
        aVar.setAuthorUin(feedCloudMeta$StFeed.poster.f398463id.get());
        aVar.setExt1(feedCloudMeta$StFeed.video.fileId.get());
        PBBytesField pBBytesField = feedCloudMeta$StFeed.busiReport;
        if (pBBytesField != null && pBBytesField.has()) {
            aVar.setReportInfo(feedCloudMeta$StFeed.busiReport.get().toByteArray());
        }
        return aVar;
    }

    public static QCircleLpReportDc05502.DataBuilder b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        b bVar = new b(feedCloudMeta$StFeed);
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QCirclePluginReportUtil", 1, "feed == null");
            return bVar;
        }
        bVar.setToUin(feedCloudMeta$StFeed.poster.f398463id.get());
        bVar.setFeedId(feedCloudMeta$StFeed.f398449id.get());
        bVar.setFeedTag(QCirclePluginUtil.getFeedTagName(feedCloudMeta$StFeed));
        bVar.setAuthorUin(feedCloudMeta$StFeed.poster.f398463id.get());
        if (feedCloudMeta$StFeed.busiReport.has()) {
            bVar.setReportInfo(feedCloudMeta$StFeed.busiReport.get().toByteArray());
        }
        return bVar;
    }

    public static QCircleLpReportDc05507.DataBuilder c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        C11333c c11333c = new C11333c(feedCloudMeta$StFeed);
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QCirclePluginReportUtil", 1, "feed == null");
            return c11333c;
        }
        c11333c.setToUin(feedCloudMeta$StFeed.poster.f398463id.get());
        c11333c.setFeedId(feedCloudMeta$StFeed.f398449id.get());
        c11333c.setAuthorUin(feedCloudMeta$StFeed.poster.f398463id.get());
        FeedCloudMeta$StVideo feedCloudMeta$StVideo = feedCloudMeta$StFeed.video;
        if (feedCloudMeta$StVideo != null) {
            c11333c.setVideoTotalTime(feedCloudMeta$StVideo.duration.get());
            c11333c.setCubage(feedCloudMeta$StFeed.video.fileSize.get());
            c11333c.setWidth(feedCloudMeta$StFeed.video.width.get());
            c11333c.setHeight(feedCloudMeta$StFeed.video.height.get());
            c11333c.setClear(feedCloudMeta$StFeed.video.videoRate.get());
            c11333c.setPlayId(feedCloudMeta$StFeed.video.fileId.get());
            c11333c.setVid(feedCloudMeta$StFeed.video.fileId.get());
            c11333c.setLloc(feedCloudMeta$StFeed.cover.picId.get());
            c11333c.setPlayUrl(feedCloudMeta$StFeed.video.playUrl.get());
            c11333c.setVideoTag(feedCloudMeta$StFeed.video.playUrl.get());
            c11333c.setPicInfo(feedCloudMeta$StFeed.cover.picUrl.get());
        }
        if (feedCloudMeta$StFeed.musicInfo.MID.has()) {
            c11333c.setMusicId(feedCloudMeta$StFeed.musicInfo.MID.get());
        }
        c11333c.setFeedTag(QCirclePluginUtil.getFeedTagName(feedCloudMeta$StFeed));
        c11333c.setItemDetail(feedCloudMeta$StFeed.title.get() + "|" + feedCloudMeta$StFeed.content.get());
        c11333c.setActTime(System.currentTimeMillis());
        if (feedCloudMeta$StFeed.busiReport.has()) {
            c11333c.setReportInfo(feedCloudMeta$StFeed.busiReport.get().toByteArray());
        }
        return c11333c;
    }

    public static Map<String, Object> d(e30.b bVar) {
        HashMap hashMap = new HashMap();
        if (bVar != null && bVar.g() != null) {
            QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = (QQCircleFeedBase$StReportInfoForClient) bVar.b("DITTO_REPORT_INFO_FOR_CLIENT");
            int i3 = 1;
            if (qQCircleFeedBase$StReportInfoForClient != null) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE1, Integer.valueOf(qQCircleFeedBase$StReportInfoForClient.feedtype1.get()));
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE2, Integer.valueOf(qQCircleFeedBase$StReportInfoForClient.feedtype2.get()));
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE3, Integer.valueOf(qQCircleFeedBase$StReportInfoForClient.feedtype3.get()));
                if (!TextUtils.isEmpty(qQCircleFeedBase$StReportInfoForClient.datongJsonData.get())) {
                    hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
                }
            } else {
                int[] reportFeedType = QCirclePluginUtil.getReportFeedType(bVar.g());
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE1, Integer.valueOf(reportFeedType[0]));
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE2, Integer.valueOf(reportFeedType[1]));
            }
            if (QCirclePluginUtil.getUserBusiData(bVar).certification.get() == 0) {
                i3 = 0;
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_AUTHENTICATION, Integer.valueOf(i3));
            FeedCloudMeta$StHotTagInfo feedCloudMeta$StHotTagInfo = QCirclePluginUtil.getBusiData(bVar).hotTagInfo.get();
            if (feedCloudMeta$StHotTagInfo != null && feedCloudMeta$StHotTagInfo.has()) {
                FeedCloudMeta$StHotTagInfo feedCloudMeta$StHotTagInfo2 = feedCloudMeta$StHotTagInfo.get();
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_TOPIC_ID, feedCloudMeta$StHotTagInfo2.f398452id.get());
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_TOPIC_NAME, feedCloudMeta$StHotTagInfo2.title.get());
            }
            hashMap.putAll(e(bVar.g()));
        }
        return hashMap;
    }

    public static Map<String, Object> e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Object obj;
        HashMap hashMap = new HashMap();
        if (feedCloudMeta$StFeed == null) {
            return hashMap;
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
        hashMap.put("xsj_target_qq", feedCloudMeta$StFeed.poster.f398463id.get());
        hashMap.put("xsj_topic_id", QCirclePluginUtil.getFeedTagName(feedCloudMeta$StFeed));
        hashMap.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_POI_MSG, aa.a(feedCloudMeta$StFeed));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_LIKE_NUM, Integer.valueOf(feedCloudMeta$StFeed.likeInfo.count.get()));
        FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(feedCloudMeta$StFeed.f398449id.get());
        if (f16 != null) {
            obj = Integer.valueOf(f16.totalClickCount.get());
        } else {
            obj = "";
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUSH_NUM, obj);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_NUM, Integer.valueOf(feedCloudMeta$StFeed.commentCount.get()));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_NUM, Integer.valueOf(feedCloudMeta$StFeed.share.sharedCount.get()));
        if (feedCloudMeta$StFeed.musicInfo.ID.get() == 0) {
            hashMap.put("xsj_music_id", feedCloudMeta$StFeed.musicInfo.MID.get());
        } else {
            hashMap.put("xsj_music_id", Long.valueOf(feedCloudMeta$StFeed.musicInfo.ID.get()));
        }
        hashMap.put("xsj_music_name", feedCloudMeta$StFeed.musicInfo.musicName.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE, Integer.valueOf(feedCloudMeta$StFeed.type.get()));
        QQCircleTianShu$AdItem L = r.L(feedCloudMeta$StFeed, 1050);
        if (L != null) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MULTIMEDIA_LIKE_TIANSHU_ID, Integer.valueOf(L.iAdId.get()));
        }
        PBRepeatMessageField<FeedCloudMeta$FeedAlbumInfo> pBRepeatMessageField = feedCloudMeta$StFeed.album_infos;
        if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0 && feedCloudMeta$StFeed.album_infos.get(0) != null) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(feedCloudMeta$StFeed.album_infos.get(0).album.f398441id.get()));
        }
        return hashMap;
    }

    public static String f(Context context) {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(context);
        if (qCircleInitBean == null) {
            return "";
        }
        return g(qCircleInitBean.getExtraTypeInfo().mReportExtraMap);
    }

    public static String g(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        String str = (String) map.get(QFS5507ReportHelper.JsonKey.TRANS_FEEDID);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(QFS5507ReportHelper.JsonKey.TRANS_FEEDID, str);
        }
        String str2 = (String) map.get(QFS5507ReportHelper.JsonKey.TRANS_REQID);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(QFS5507ReportHelper.JsonKey.TRANS_REQID, str2);
        }
        if (!hashMap.isEmpty()) {
            return new Gson().toJson(hashMap);
        }
        return "";
    }
}
