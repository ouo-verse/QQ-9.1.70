package yo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.album.business.albumlist.activity.QzonePhotoCategoryDetailsActivity;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.commoncode.module.videorecommend.utils.WeishiHelper;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.feedpro.utils.ao;
import com.qzone.reborn.feedx.bean.QZoneFeedEventTagInitBean;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.qzone.reborn.route.QZoneUserHomeBean;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ads.data.AdParam;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.recommend.RecommendFriendActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoConst;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.zebra.ZebraPluginProxy;
import ho.i;
import ho.k;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r6.a;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f450704a = "c";

    public static void A(Context context, String str) {
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        PictureItem pictureItem = new PictureItem();
        PictureUrl pictureUrl = new PictureUrl();
        ImageUrl imageUrl = new ImageUrl();
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("picUrl");
        String queryParameter2 = parse.getQueryParameter("albumId");
        String queryParameter3 = parse.getQueryParameter(AppConstants.Key.KEY_QZONE_VIDEO_URL);
        String queryParameter4 = parse.getQueryParameter("id");
        String queryParameter5 = parse.getQueryParameter("vid");
        String queryParameter6 = parse.getQueryParameter(QFSEdgeItem.KEY_VIDEO_TIME);
        imageUrl.url = queryParameter;
        imageUrl.isNetWorkUrl = true;
        pictureUrl.imageUrl = imageUrl;
        pictureUrl.url = queryParameter;
        pictureItem.currentUrl = pictureUrl;
        pictureItem.bigUrl = pictureUrl;
        pictureItem.lloc = queryParameter4;
        pictureItem.albumId = queryParameter2;
        if (!TextUtils.isEmpty(queryParameter3)) {
            pictureItem.videoflag = 1;
            VideoUrl videoUrl = new VideoUrl();
            videoUrl.url = queryParameter3;
            VideoInfo videoInfo = new VideoInfo();
            pictureItem.videodata = videoInfo;
            videoInfo.videoUrl = videoUrl;
            videoInfo.coverUrl = pictureUrl;
            videoInfo.albumid = queryParameter2;
            videoInfo.bigUrl = pictureUrl;
            videoInfo.currentUrl = pictureUrl;
            videoInfo.originUrl = pictureUrl;
            videoInfo.videoId = queryParameter5;
            if (!TextUtils.isEmpty(queryParameter6)) {
                pictureItem.videodata.videoTime = Long.parseLong(queryParameter6);
            } else {
                w5.b.g(f450704a, 1, "videoTime is null, scheme is: " + str);
            }
        }
        cellPictureInfo.albumid = queryParameter2;
        ArrayList<PictureItem> arrayList = new ArrayList<>();
        cellPictureInfo.pics = arrayList;
        arrayList.add(pictureItem);
        PictureViewerFactory.Q((Activity) context, cellPictureInfo, null, 0, -1, null, false, true);
    }

    public static void B(Context context, String str) {
        String str2;
        int indexOf = str.indexOf("url=");
        if (indexOf > 0) {
            str2 = URLDecoder.decode(str.substring(indexOf + 4, str.length()));
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        d.d(str2, context, null);
    }

    public static void C(Context context, String str) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str));
        intent.setPackage("com.tencent.mobileqq");
        if (!TextUtils.isEmpty(str) && str.contains("qz_gdt")) {
            intent.putExtra("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            intent.putExtra(LaunchParam.KEY_REF_ID, "biz_src_jc_qzone");
        }
        context.startActivity(intent);
    }

    public static void D(Context context, String str) {
        Bundle e16 = f.e(str);
        Intent l3 = ak.l(context, "com.qzone.album.business.editalbum.QZoneNewAlbumActivity");
        l3.putExtra("QZoneNewAlbumActivity.key_type_src", 0);
        if (e16.containsKey("type")) {
            l3.putExtra("QZoneNewAlbumActivity.key_choose_type", Integer.parseInt(e16.getString("type")));
        }
        com.qzone.feed.utils.b.d(context, l3);
    }

    public static void E(Context context, String str, Map map) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("eventtag");
        if (queryParameter == null) {
            return;
        }
        i.j().c(context, new QZoneFeedEventTagInitBean(queryParameter, (map == null || map.get("from_page") == null) ? null : (Integer) map.get("from_page"), parse.getQueryParameter("source") != null ? Integer.valueOf(parse.getQueryParameter("source")) : null, parse.getQueryParameter("source2") != null ? Integer.valueOf(parse.getQueryParameter("source2")) : null, parse.getQueryParameter(AlbumCacheData.ACTIONURL)));
    }

    public static void F(Context context, String str) {
        int i3;
        int i16;
        int i17;
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("id");
            try {
                i3 = Integer.parseInt(parse.getQueryParameter("width"));
            } catch (NumberFormatException unused) {
                QZLog.e("QZoneSchemeHandleLogic", "parsing video cover width error no an integer");
                i3 = -1;
            }
            try {
                i16 = Integer.parseInt(parse.getQueryParameter("height"));
            } catch (NumberFormatException unused2) {
                QZLog.e("QZoneSchemeHandleLogic", "parsing video cover height error no an integer");
                i16 = -1;
            }
            String queryParameter2 = parse.getQueryParameter("picUrl");
            if (!TextUtils.isEmpty(queryParameter2)) {
                queryParameter2 = URLDecoder.decode(queryParameter2, "UTF-8");
            }
            String str2 = queryParameter2;
            String queryParameter3 = parse.getQueryParameter(AppConstants.Key.KEY_QZONE_VIDEO_URL);
            if (!TextUtils.isEmpty(queryParameter3)) {
                queryParameter3 = URLDecoder.decode(queryParameter3, "UTF-8");
            }
            String str3 = queryParameter3;
            String queryParameter4 = parse.getQueryParameter("name");
            if (!TextUtils.isEmpty(queryParameter4)) {
                queryParameter4 = URLDecoder.decode(queryParameter4, "UTF-8");
            }
            String str4 = queryParameter4;
            try {
                i17 = Integer.parseInt(parse.getQueryParameter("coverType"));
            } catch (NumberFormatException unused3) {
                QZLog.e("QZoneSchemeHandleLogic", "parsing video cover type error no an integer");
                i17 = -1;
            }
            ((k) i.t(k.class)).a(context, queryParameter, str2, str3, 2, i3, i16, i17, QzoneCoverConst.CoverStringType.COVER_TYPE_NEW_VIDEO_COVER, str4);
        } catch (Exception e16) {
            QZLog.e("QZoneSchemeHandleLogic", "openVideoCoverPreviewActivity", e16);
        }
    }

    public static void G(Context context, String str) {
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) RecommendFriendActivity.class);
        intent.putExtra("EntranceId", 5);
        context.startActivity(intent);
    }

    public static void H(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            QZLog.e("QZoneSchemeHandleLogic", 1, "scheme is null");
            return;
        }
        String decode = URLDecoder.decode(str);
        try {
            String queryParameter = Uri.parse(decode).getQueryParameter("realScheme");
            if (TextUtils.isEmpty(queryParameter)) {
                QZLog.e("QZoneSchemeHandleLogic", 1, "realScheme is null");
                return;
            }
            d.b(context, new g(URLDecoder.decode(queryParameter)));
            if (QZLog.isColorLevel()) {
                QZLog.i("QZoneSchemeHandleLogic", 2, "scheme open scucss:", decode);
            }
        } catch (Exception e16) {
            QZLog.e("QZoneSchemeHandleLogic", 1, e16, new Object[0]);
        }
    }

    public static void I(Context context, String str) {
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str);
        if (argumentsFromURL == null || argumentsFromURL.isEmpty()) {
            return;
        }
        String str2 = argumentsFromURL.get("appid");
        String str3 = argumentsFromURL.get("packagename");
        argumentsFromURL.get("from");
        argumentsFromURL.get("appname");
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            if (InstalledAppListMonitor.getPackageInfo(packageManager, str3, 1) != null) {
                Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, str3);
                b.a(launchIntentForPackage);
                launchIntentForPackage.addFlags(67108864);
                context.startActivity(launchIntentForPackage);
                W(str3);
            } else {
                U(context, str2, str3);
            }
        } catch (Exception unused) {
            U(context, str2, str3);
        }
    }

    public static void J(Context context, String str) {
        int i3;
        int i16;
        long j3;
        int i17;
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter(AppConstants.Key.KEY_QZONE_VIDEO_URL);
            String queryParameter2 = parse.getQueryParameter(MessageForQQStory.KEY_COVER_IMG_URL);
            String queryParameter3 = parse.getQueryParameter("videoId");
            if (!TextUtils.isEmpty(parse.getQueryParameter("videoWidth"))) {
                i3 = Integer.parseInt(parse.getQueryParameter("videoWidth"));
            } else {
                QZLog.e("QZoneSchemaHandleLogic", 1, "H5 openVideoLayout Err videoWidth");
                i3 = 0;
            }
            if (!TextUtils.isEmpty(parse.getQueryParameter("videoHeight"))) {
                i16 = Integer.parseInt(parse.getQueryParameter("videoHeight"));
            } else {
                QZLog.e("QZoneSchemaHandleLogic", 1, "H5 openVideoLayout Err videoHeight");
                i16 = 0;
            }
            String queryParameter4 = parse.getQueryParameter(AppConstants.Key.KEY_QZONE_UGCKEY);
            long j16 = -1;
            if (!TextUtils.isEmpty(parse.getQueryParameter("uin"))) {
                j3 = Long.parseLong(parse.getQueryParameter("uin"));
            } else {
                QZLog.e("QZoneSchemaHandleLogic", 1, "H5 openVideoLayout Err uin");
                j3 = -1;
            }
            String queryParameter5 = parse.getQueryParameter("nickName");
            if (!TextUtils.isEmpty(parse.getQueryParameter("durationTime"))) {
                j16 = Long.parseLong(parse.getQueryParameter("durationTime"));
            } else {
                QZLog.e("QZoneSchemaHandleLogic", 1, "H5 openVideoLayout Err durationTime");
            }
            long j17 = j16;
            if (!TextUtils.isEmpty(parse.getQueryParameter("appid"))) {
                i17 = Integer.parseInt(parse.getQueryParameter("appid"));
            } else {
                QZLog.e("QZoneSchemaHandleLogic", 1, "H5 openVideoLayout Err appid");
                i17 = -1;
            }
            String queryParameter6 = parse.getQueryParameter("videoAdPos");
            String queryParameter7 = parse.getQueryParameter("currentPosition");
            if (!TextUtils.isEmpty(queryParameter7)) {
                Long.parseLong(queryParameter7);
            }
            String queryParameter8 = parse.getQueryParameter("orgWebSite");
            int intValue = parse.getQueryParameter("nh") != null ? Integer.valueOf(parse.getQueryParameter("nh")).intValue() : 2;
            parse.getQueryParameter("kw");
            int i18 = intValue & 2;
            int parseInt = !TextUtils.isEmpty(queryParameter8) ? Integer.parseInt(queryParameter8) : 0;
            parse.getQueryParameter("bypassparam");
            BusinessFeedData businessFeedData = new BusinessFeedData();
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.videoUrl = new VideoUrl(queryParameter);
            videoInfo.coverUrl = new PictureUrl(queryParameter2, i3, i16);
            videoInfo.videoId = queryParameter3;
            videoInfo.videoTime = j17;
            videoInfo.height = i16;
            videoInfo.width = i3;
            VideoInfo.VideoRemark videoRemark = new VideoInfo.VideoRemark();
            videoInfo.videoRemark = videoRemark;
            videoRemark.orgwebsite = parseInt;
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            obtain.extraProcessor = videoInfo.processor;
            PictureUrl pictureUrl = videoInfo.coverUrl;
            if (pictureUrl != null) {
                obtain.clipWidth = pictureUrl.width;
                obtain.clipHeight = pictureUrl.height;
                obtain.preferQuality = false;
                obtain.priority = true;
                ImageLoader.getInstance().loadImage(videoInfo.coverUrl.url, (ImageLoader.ImageLoadListener) null, obtain);
            }
            CellFeedCommInfo cellFeedCommInfo = new CellFeedCommInfo();
            cellFeedCommInfo.ugckey = queryParameter4;
            cellFeedCommInfo.appid = i17;
            CellUserInfo cellUserInfo = new CellUserInfo();
            User user = new User(j3, queryParameter5);
            cellUserInfo.setUser(user);
            CellOperationInfo cellOperationInfo = new CellOperationInfo();
            HashMap hashMap = new HashMap();
            if (queryParameter6 != null) {
                hashMap.put(93, queryParameter6);
            }
            cellOperationInfo.busiParam = Collections.synchronizedMap(hashMap);
            businessFeedData.setVideoInfo(videoInfo);
            businessFeedData.setCommInfo(cellFeedCommInfo);
            businessFeedData.setUser(user);
            businessFeedData.cellOperationInfo = cellOperationInfo;
            if (businessFeedData.getFeedCommInfo().isVideoAdv()) {
                BaseVideoManager.getFeedVideoManager().D(new ArrayList());
                VideoInfo videoInfo2 = businessFeedData.getVideoInfo();
                if (businessFeedData.getFeedCommInfo().isVideoAdv()) {
                    com.qzone.proxy.feedcomponent.ui.c.j(context, videoInfo2, null, 0, businessFeedData.getOperationInfo().downloadUrl, businessFeedData);
                } else {
                    com.qzone.proxy.feedcomponent.ui.c.i(context, videoInfo2, null, 0, null);
                }
            }
        } catch (Exception e16) {
            QZLog.e("QZoneSchemeHandleLogic", "onOpenVideoLayer", e16);
        }
    }

    public static void L() {
        QZoneHelper.forwardToPictureSetting(BaseApplication.getContext(), QZoneHelper.UserInfo.getInstance());
    }

    public static void M(Context context, String str, byte[] bArr, Map map) {
        Object obj;
        try {
            URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        if (str.startsWith("mqzone")) {
            Map map2 = (map == null || (obj = map.get("key2")) == null || !(obj instanceof Map)) ? null : (Map) obj;
            if (b.g(context, b.f450700b)) {
                g gVar = new g(str);
                HashMap hashMap = new HashMap();
                hashMap.put("key2", map2);
                gVar.f450714g = hashMap;
                d.b(context, gVar);
                return;
            }
            c(context, "funnymood", str);
            if (QZLog.isColorLevel()) {
                QZLog.d("JUMP DowloadPage", 2, "URL: " + str);
            }
        }
    }

    public static void N(Context context, String str) {
        Bundle e16 = f.e(str);
        if (QCircleDaTongConstant.ElementParamValue.OPERATION.equals(e16.getString("mode")) && !NetworkState.isNetSupport()) {
            ToastUtil.n(R.string.ghi);
            return;
        }
        Intent intent = new Intent(context, lc.b.b());
        intent.putExtras(e16);
        String stringExtra = intent.getStringExtra("refer");
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = ".qzone_scheme_refer";
        }
        qZonePublishMoodInitBean.C0(stringExtra);
        i.w().d(context, qZonePublishMoodInitBean, intent);
    }

    public static void O(Context context) {
        d.d(f.t(f.w(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_PHONELABELSETTING, "https://h5.qzone.qq.com/show/tail?_wv=2097159&_bid=2178&uin={uin}&qua={qua}"), LoginData.getInstance().getUin())), context, null);
    }

    public static void P(Context context, long j3) {
        d.d(f.g(f.t(f.w(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_DESCRIPTIONSETTING, "https://h5.qzone.qq.com/show/desc?_wv=2097159&uin={uin}&qua={qua}&friendUin={friendUin}"), LoginData.getInstance().getUin())), j3), context, null);
    }

    public static void Q(Context context, String str) {
        long j3;
        try {
            j3 = Long.parseLong(f.e(str).getString("friendUin"));
        } catch (Exception unused) {
            QZLog.w(QZoneDTLoginReporter.SCHEMA, "qzonedesc schema uin error");
            j3 = 0;
        }
        P(context, j3);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0108 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void R(Activity activity, String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z19;
        Uri parse;
        if (TextUtils.isEmpty(str)) {
            QZLog.e("onSetTakeVideoClick", "url is empty");
            return;
        }
        Bundle e16 = f.e(str);
        String string = e16.getString("is_take_gif");
        try {
            parse = Uri.parse(str);
            z16 = parse.getBooleanQueryParameter("widget_category_unfold", false);
        } catch (Throwable th5) {
            th = th5;
            z16 = false;
            z17 = false;
        }
        try {
            str2 = parse.getQueryParameter("widget_category_name");
        } catch (Throwable th6) {
            th = th6;
            z17 = false;
            z18 = z17;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            QZLog.e("onSetTakeVideoClick", "getQueryParameter exception", th);
            z19 = true;
            if (!z16) {
            }
            e16.putBoolean(PeakConstants.ARG_UNFOLD_DD, true);
            if (!TextUtils.isEmpty(str2)) {
            }
            if (!TextUtils.isEmpty(str3)) {
            }
            if (!z17) {
            }
            e16.putBoolean(PeakConstants.ARG_UNFOLD_FILTER, true);
            if (!TextUtils.isEmpty(str4)) {
            }
            if (!TextUtils.isEmpty(str5)) {
            }
            e16.putBoolean(QzoneVerticalVideoConst.KEY_SUPPORTPIC, z18);
            if (!TextUtils.isEmpty(str6)) {
            }
            if ("1".equals(string)) {
            }
            e16.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, !z18 && z19);
            ag.n(activity, e16.getString(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT), e16, true, new Object[0]);
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_ENTRANCE, "3", null);
        }
        try {
            str3 = parse.getQueryParameter("widget_item_id");
            try {
                z17 = parse.getBooleanQueryParameter("filter_category_unfold", false);
            } catch (Throwable th7) {
                th = th7;
                z17 = false;
                z18 = false;
            }
            try {
                str4 = parse.getQueryParameter("filter_category_name");
            } catch (Throwable th8) {
                th = th8;
                z18 = false;
                str4 = null;
                str5 = null;
                str6 = null;
                QZLog.e("onSetTakeVideoClick", "getQueryParameter exception", th);
                z19 = true;
                if (!z16) {
                }
                e16.putBoolean(PeakConstants.ARG_UNFOLD_DD, true);
                if (!TextUtils.isEmpty(str2)) {
                }
                if (!TextUtils.isEmpty(str3)) {
                }
                if (!z17) {
                }
                e16.putBoolean(PeakConstants.ARG_UNFOLD_FILTER, true);
                if (!TextUtils.isEmpty(str4)) {
                }
                if (!TextUtils.isEmpty(str5)) {
                }
                e16.putBoolean(QzoneVerticalVideoConst.KEY_SUPPORTPIC, z18);
                if (!TextUtils.isEmpty(str6)) {
                }
                if ("1".equals(string)) {
                }
                e16.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, !z18 && z19);
                ag.n(activity, e16.getString(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT), e16, true, new Object[0]);
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_ENTRANCE, "3", null);
            }
            try {
                str5 = parse.getQueryParameter("filter_item_id");
                try {
                    z18 = parse.getBooleanQueryParameter(QzoneVerticalVideoConst.KEY_SUPPORTPIC, false);
                } catch (Throwable th9) {
                    th = th9;
                    z18 = false;
                }
            } catch (Throwable th10) {
                th = th10;
                z18 = false;
                str5 = null;
                str6 = null;
                QZLog.e("onSetTakeVideoClick", "getQueryParameter exception", th);
                z19 = true;
                if (!z16) {
                }
                e16.putBoolean(PeakConstants.ARG_UNFOLD_DD, true);
                if (!TextUtils.isEmpty(str2)) {
                }
                if (!TextUtils.isEmpty(str3)) {
                }
                if (!z17) {
                }
                e16.putBoolean(PeakConstants.ARG_UNFOLD_FILTER, true);
                if (!TextUtils.isEmpty(str4)) {
                }
                if (!TextUtils.isEmpty(str5)) {
                }
                e16.putBoolean(QzoneVerticalVideoConst.KEY_SUPPORTPIC, z18);
                if (!TextUtils.isEmpty(str6)) {
                }
                if ("1".equals(string)) {
                }
                e16.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, !z18 && z19);
                ag.n(activity, e16.getString(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT), e16, true, new Object[0]);
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_ENTRANCE, "3", null);
            }
            try {
                str6 = parse.getQueryParameter("force_camera");
            } catch (Throwable th11) {
                th = th11;
                str6 = null;
                QZLog.e("onSetTakeVideoClick", "getQueryParameter exception", th);
                z19 = true;
                if (!z16) {
                }
                e16.putBoolean(PeakConstants.ARG_UNFOLD_DD, true);
                if (!TextUtils.isEmpty(str2)) {
                }
                if (!TextUtils.isEmpty(str3)) {
                }
                if (!z17) {
                }
                e16.putBoolean(PeakConstants.ARG_UNFOLD_FILTER, true);
                if (!TextUtils.isEmpty(str4)) {
                }
                if (!TextUtils.isEmpty(str5)) {
                }
                e16.putBoolean(QzoneVerticalVideoConst.KEY_SUPPORTPIC, z18);
                if (!TextUtils.isEmpty(str6)) {
                }
                if ("1".equals(string)) {
                }
                e16.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, !z18 && z19);
                ag.n(activity, e16.getString(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT), e16, true, new Object[0]);
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_ENTRANCE, "3", null);
            }
        } catch (Throwable th12) {
            th = th12;
            z17 = false;
            z18 = false;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            QZLog.e("onSetTakeVideoClick", "getQueryParameter exception", th);
            z19 = true;
            if (!z16) {
            }
            e16.putBoolean(PeakConstants.ARG_UNFOLD_DD, true);
            if (!TextUtils.isEmpty(str2)) {
            }
            if (!TextUtils.isEmpty(str3)) {
            }
            if (!z17) {
            }
            e16.putBoolean(PeakConstants.ARG_UNFOLD_FILTER, true);
            if (!TextUtils.isEmpty(str4)) {
            }
            if (!TextUtils.isEmpty(str5)) {
            }
            e16.putBoolean(QzoneVerticalVideoConst.KEY_SUPPORTPIC, z18);
            if (!TextUtils.isEmpty(str6)) {
            }
            if ("1".equals(string)) {
            }
            e16.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, !z18 && z19);
            ag.n(activity, e16.getString(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT), e16, true, new Object[0]);
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_ENTRANCE, "3", null);
        }
        try {
            z19 = parse.getBooleanQueryParameter("support_pic_quick_publish", true);
        } catch (Throwable th13) {
            th = th13;
            QZLog.e("onSetTakeVideoClick", "getQueryParameter exception", th);
            z19 = true;
            if (!z16) {
            }
            e16.putBoolean(PeakConstants.ARG_UNFOLD_DD, true);
            if (!TextUtils.isEmpty(str2)) {
            }
            if (!TextUtils.isEmpty(str3)) {
            }
            if (!z17) {
            }
            e16.putBoolean(PeakConstants.ARG_UNFOLD_FILTER, true);
            if (!TextUtils.isEmpty(str4)) {
            }
            if (!TextUtils.isEmpty(str5)) {
            }
            e16.putBoolean(QzoneVerticalVideoConst.KEY_SUPPORTPIC, z18);
            if (!TextUtils.isEmpty(str6)) {
            }
            if ("1".equals(string)) {
            }
            e16.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, !z18 && z19);
            ag.n(activity, e16.getString(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT), e16, true, new Object[0]);
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_ENTRANCE, "3", null);
        }
        if (!z16 || !TextUtils.isEmpty(str2)) {
            e16.putBoolean(PeakConstants.ARG_UNFOLD_DD, true);
        }
        if (!TextUtils.isEmpty(str2)) {
            e16.putString(PeakConstants.ARG_DD_CATEGORY_NAME, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            e16.putString(PeakConstants.ARG_DD_ITEM_ID, str3);
        }
        if (!z17 || !TextUtils.isEmpty(str4)) {
            e16.putBoolean(PeakConstants.ARG_UNFOLD_FILTER, true);
        }
        if (!TextUtils.isEmpty(str4)) {
            e16.putString(PeakConstants.ARG_FILTER_CATEGORY_NAME, str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            e16.putString(PeakConstants.ARG_FILTER_ITEM_ID, str5);
        }
        e16.putBoolean(QzoneVerticalVideoConst.KEY_SUPPORTPIC, z18);
        if (!TextUtils.isEmpty(str6)) {
            try {
                e16.putInt(PeakConstants.ARG_FORCE_CAMERA, Integer.parseInt(str6));
            } catch (Throwable th14) {
                QZLog.e("onSetTakeVideoClick", "parse PeakConstants.ARG_FORCE_CAMERA exception", th14);
            }
        }
        if ("1".equals(string)) {
            e16.putBoolean("is_glance_video", true);
            e16.putBoolean("enable_local_button", false);
        }
        e16.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, !z18 && z19);
        ag.n(activity, e16.getString(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT), e16, true, new Object[0]);
        QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_ENTRANCE, "3", null);
    }

    public static void S(Context context, String str) {
        Bundle e16 = f.e(str);
        Intent E = ak.E(context, 0, null, null, "uploadphoto.qzone_scheme_refer", 14);
        E.putExtra("IsBack", true);
        if (e16.containsKey("albumid")) {
            E.putExtra("UploadPhoto.key_album_id", e16.getString("albumid"));
        }
        if (e16.containsKey("albumtitle")) {
            E.putExtra("UploadPhoto.key_album_name", e16.getString("albumtitle"));
        }
        E.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 1);
        E.putExtras(e16);
        if (lc.b.d()) {
            i.x().l(context, new QZAlbumxUploadAlbumInitBean(LoginData.getInstance().getUinString(), 0, true, null, 0), E);
        } else {
            i.w().h(context, new QZonePublishMoodInitBean(System.currentTimeMillis()), E);
        }
    }

    public static void T(Context context, String str) {
        int i3;
        String str2;
        String a16 = a(str, "subaid");
        try {
            i3 = Integer.parseInt(a(str, "viptype"));
        } catch (Exception unused) {
            i3 = 0;
        }
        int i16 = i3;
        if (TextUtils.isEmpty(a16)) {
            str2 = null;
        } else {
            str2 = "jhan_" + a16;
        }
        Intent t16 = ak.t(context, str2, null, false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip(), i16, a(str, "url"));
        String a17 = a(str, TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
        if (!TextUtils.isEmpty(a17)) {
            t16.putExtra(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, a17);
        }
        ak.Q(context, t16, -1);
    }

    private static void U(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str2);
        bundle.putString("appId", str);
        b.b(bundle);
        if (context instanceof BasePluginActivity) {
            AppClient.l(((BasePluginActivity) context).getOutActivity(), bundle);
            W(str2);
        } else if (context instanceof Activity) {
            AppClient.l((Activity) context, bundle);
            W(str2);
        } else {
            QZLog.e(QZLog.TO_DEVICE_TAG, "onOpenThridApp mContext \u5fc5\u73b0\u662f\u4e00\u4e2aActivity");
        }
    }

    public static void V(Context context, String str, QZoneUserHomeBean qZoneUserHomeBean) {
        if (context != null && qZoneUserHomeBean != null) {
            try {
                qZoneUserHomeBean.setUin(Long.parseLong(str));
                i.z().t(context, qZoneUserHomeBean);
                return;
            } catch (Exception unused) {
                QZLog.e(QZLog.TO_DEVICE_TAG, "openHomePage uin parse error");
                return;
            }
        }
        QZLog.e(QZLog.TO_DEVICE_TAG, "openHomePage context==null");
    }

    private static void W(String str) {
        StartAppCheckHandler.I2(ZPlanPublishSource.FROM_SCHEME, "", str, "2", "QZoneTail", "");
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = f.e(str).getString(str2);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    private static void b(Context context, long j3, String str, String str2) {
        String str3 = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_VISIT_DOWNLOAD, "https://mobile.qzone.qq.com/l?g=360") + "&sid={sid}";
        if (j3 > 10000) {
            str3 = str3 + "&res_uin=" + j3;
        }
        String str4 = str3 + "&type=" + str;
        if (str2 != null && !str2.equals("")) {
            str4 = str4 + "&scheme=" + Uri.encode(str2);
        }
        d.b(context, new g(str4));
    }

    private static void d(Bundle bundle, Uri uri) {
        if (TextUtils.isEmpty(uri.getQueryParameter("hydtgzh"))) {
            return;
        }
        bundle.putBoolean("frompublicaccount", true);
        String queryParameter = uri.getQueryParameter(AppConstants.Key.COLUMN_MSG_TYPE);
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle.putInt(AppConstants.Key.COLUMN_MSG_TYPE, Integer.parseInt(queryParameter));
        }
        String queryParameter2 = uri.getQueryParameter("todayinhistoryheader");
        if (TextUtils.isEmpty(queryParameter2)) {
            return;
        }
        bundle.putString("todayinhistoryheader", queryParameter2);
    }

    private static void f(Context context) {
        g gVar = new g("mqzonev2://arouse/livevideo?room=&uin=&nickname=&source=qq&version=1&type=1&syncuin=&from=".replace("syncuin=", "syncuin=" + LoginData.getInstance().getUinString()).replace("from=", "from=5"));
        gVar.f450709b = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_BIZ, QzoneConfig.SECONDARY_DOWNLOAD_QZONE_APP_URL, QzoneConfig.DefaultValue.BIZ_DOWNLOAD_QZONE_APP_URL);
        d.b(context, gVar);
    }

    public static void g(Context context, String str) {
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter(PictureConst.KEY_CATEGORY_TYPE);
            String queryParameter2 = parse.getQueryParameter(PictureConst.KEY_CATEGORY_ID);
            if (QZLog.isColorLevel()) {
                QZLog.d(f450704a, 2, "[jumpToAlbumCategoryDetail] categoryType=" + queryParameter + ", categoryId=" + queryParameter2);
            }
            Intent intent = new Intent(context, (Class<?>) QzonePhotoCategoryDetailsActivity.class);
            intent.putExtra(QZoneHelper.QzonePhotoCategoryConstants.CATEGORY_BUSI_TYPE, Integer.valueOf(queryParameter));
            intent.putExtra("categoryId", queryParameter2);
            com.qzone.feed.utils.b.d(context, intent);
        } catch (Exception e16) {
            QZLog.e(f450704a, "[jumpToAlbumCategoryDetail]", e16);
        }
    }

    public static void h(Context context, String str) {
        Intent qZoneVideoDownloadActivityIntent = QZoneHelper.getQZoneVideoDownloadActivityIntent(context.getApplicationContext());
        qZoneVideoDownloadActivityIntent.putExtra(QzoneVerticalVideoConst.KEY_SUPPORT_DYNAMIC_VIDEO, true);
        qZoneVideoDownloadActivityIntent.putExtra(RemoteHandleConst.DYNAMIC_VIDEO_PARAM_JUMP_PHOTO_LIST, true);
        qZoneVideoDownloadActivityIntent.putExtra(RemoteHandleConst.DYNAMIC_VIDEO_ENTRANCE, 123);
        context.startActivity(qZoneVideoDownloadActivityIntent);
    }

    public static void i(Context context, String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("id");
        String queryParameter2 = parse.getQueryParameter("name");
        String queryParameter3 = parse.getQueryParameter("fakeurl");
        QZLog.d(f450704a, 2, "jumpToMiniGame: scheme = ", str, "id=", queryParameter, " name= ", queryParameter2, "url= ", queryParameter3);
        d.d(queryParameter3, context, null);
    }

    public static void j(Context context, String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("albumid");
        String queryParameter2 = parse.getQueryParameter("uin");
        if (queryParameter != null) {
            long uin = LoginData.getInstance().getUin();
            if (!TextUtils.isEmpty(queryParameter2)) {
                uin = Long.parseLong(queryParameter2);
            }
            Intent M = ak.M((Activity) context, queryParameter, uin, LoginData.getInstance().getUin());
            M.putExtra("needOpenAddFunction", false);
            com.qzone.feed.utils.b.d(context, M);
        }
    }

    public static void k(Activity activity, String str, int i3) {
        if (str.contains("directory=localvideo")) {
            i3 = 12;
        }
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(Integer.valueOf(i3));
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.R0(bool);
        qZonePublishMoodInitBean.v0(bool);
        qZonePublishMoodInitBean.C0("shuoshuoOther");
        qZonePublishMoodInitBean.O0(23);
        i.w().c(activity, qZonePublishMoodInitBean);
    }

    public static void m(Context context, String str, Map map) {
        WeishiHelper.dealWeishicheme(context, str, map);
    }

    public static void n(Context context, String str) {
        String a16 = a(str, "uin");
        long uin = LoginData.getInstance().getUin();
        if (!TextUtils.isEmpty(a16)) {
            try {
                uin = Long.parseLong(a16);
            } catch (NumberFormatException e16) {
                QLog.e(f450704a, 1, "onAlbumListSchemeClick e=" + e16);
            }
        }
        if (com.qzone.reborn.albumx.qzonex.utils.d.a()) {
            QLog.i(f450704a, 1, "onAlbumListSchemeClick  context = " + context + " | uin = " + uin + " | scheme = " + str);
            i.x().i(context, new QZAlbumxMainPageInitBean(String.valueOf(uin)), null);
            return;
        }
        com.qzone.feed.utils.b.d(context, ak.G(context, Long.valueOf(uin), 0));
    }

    public static void o(Context context, String str) {
        String[] split = str.split("[&|?]");
        String str2 = "";
        String str3 = "feed";
        if (split.length > 0) {
            String str4 = "";
            for (String str5 : split) {
                if (str5.startsWith("uin")) {
                    str4 = str5.replace("uin=", "");
                }
                if (str5.startsWith("templateid")) {
                    str3 = str5;
                }
            }
            str2 = str4;
        }
        long uin = LoginData.getInstance().getUin();
        if (!TextUtils.isEmpty(str2)) {
            uin = Long.valueOf(str2).longValue();
        }
        Intent e16 = e8.f.a().c().e(uin, str3);
        if (e16 != null) {
            context.startActivity(e16);
        }
    }

    public static int p(Context context, String str, Map map) {
        if (str.startsWith(QZoneJsConstants.SCHEME_PREFIX_SET_DECORATION)) {
            Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str);
            long longValue = (map == null || !map.containsKey("uin")) ? 0L : ((Long) map.get("uin")).longValue();
            String str2 = argumentsFromURL.get("refer");
            if (TextUtils.isEmpty(str2)) {
                str2 = "decofeeds";
            }
            if (argumentsFromURL.containsKey("decorationid")) {
                vo.c.f(context, Uri.parse(str).getQueryParameter("decorationid"), str2, longValue);
                return 4;
            }
            vo.c.g(context, str2, longValue);
            return 4;
        }
        if (!g.f450707i) {
            return -1;
        }
        g gVar = new g(str);
        gVar.f450714g = map;
        return b.c(context, gVar);
    }

    public static void q(Context context, String str, Map map) {
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str);
        long longValue = (map == null || !map.containsKey("uin")) ? 0L : ((Long) map.get("uin")).longValue();
        String str2 = argumentsFromURL.get("from");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (argumentsFromURL.containsKey("id")) {
            String str3 = argumentsFromURL.get("id");
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            vo.c.d(context, str3, str2, longValue);
            return;
        }
        if (argumentsFromURL.containsKey("classid")) {
            String str4 = argumentsFromURL.get("classid");
            if (TextUtils.isEmpty(str4)) {
                return;
            }
            vo.c.b(context, str4, str2, longValue);
            return;
        }
        vo.c.c(context, str2, longValue);
    }

    public static void r(Context context) {
        vo.c.L(context);
        ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).updateCTime(0, Long.valueOf(LoginData.getInstance().getUin()));
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(13);
    }

    public static void s(Context context, String str, byte[] bArr, Map map) {
        Intent h16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = Common.z(str).get("from");
        if (str2 == null) {
            str2 = "";
        }
        String str3 = URLUtil.getArgumentsFromURL(str).get(AdParam.COVERID);
        long longValue = (map == null || !map.containsKey("uin")) ? 0L : ((Long) map.get("uin")).longValue();
        if (!TextUtils.isEmpty(str3) && !str3.equals("0")) {
            if (NetworkState.isNetSupport()) {
                h16 = ak.g(str3, 4, str2, longValue);
            } else {
                ToastUtil.n(R.string.ghi);
                return;
            }
        } else {
            h16 = ak.h(4, str2, longValue);
        }
        context.startActivity(h16);
        ClickReport.e(0, "", 32, 1);
    }

    public static int t(Context context, String str) {
        String str2;
        Bundle bundle = new Bundle();
        bundle.putInt("fromTranslucent", 1);
        try {
            Uri parse = Uri.parse(str);
            int i3 = ef.d.i(parse.getQueryParameter("appid"));
            if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                i.f().j(context, str, i3);
                return 4;
            }
            if (ao.f54312a.e(parse.getQueryParameter("oldlink"), context)) {
                return 4;
            }
            bundle.putString(s4.c.CELLID, parse.getQueryParameter(s4.c.CELLID));
            bundle.putString("lloc", parse.getQueryParameter("lloc"));
            String queryParameter = parse.getQueryParameter("subid");
            if (str.contains(AlbumCacheData.PHOTO_NUM)) {
                HashMap hashMap = new HashMap();
                hashMap.put(7, parse.getQueryParameter(AlbumCacheData.PHOTO_NUM));
                if (Integer.valueOf(parse.getQueryParameter(AlbumCacheData.PHOTO_NUM)).intValue() > 1) {
                    str2 = parse.getQueryParameter("bid");
                    if (str.contains("bid")) {
                        hashMap.put(2, parse.getQueryParameter("bid"));
                        hashMap.put(1, parse.getQueryParameter("bid"));
                    }
                } else {
                    str2 = "";
                    if (str.contains("bid")) {
                        hashMap.put(2, parse.getQueryParameter("bid"));
                        hashMap.put(1, parse.getQueryParameter("bid"));
                    }
                }
                bundle.putParcelable("businessparam", new MapParcelable(hashMap));
                queryParameter = str2;
            }
            if (str.contains("bid")) {
                bundle.putString("bid", parse.getQueryParameter("bid"));
            }
            bundle.putString("subid", queryParameter);
            bundle.putLong("targetuin", Long.parseLong(parse.getQueryParameter("uin")));
            bundle.putInt("appid", Integer.parseInt(parse.getQueryParameter("appid")));
            d(bundle, parse);
            i.e().g(context, bundle);
            return 4;
        } catch (Exception e16) {
            QLog.e("QZoneSchemeHandleLogic", 1, "getQZoneDetailIntent", e16);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void v(Context context, String str) {
        int i3;
        int parseInt;
        boolean z16;
        int i16;
        boolean z17;
        if (com.qzone.reborn.albumx.qzonex.utils.d.a()) {
            new wb.a().a(context, new QZoneSchemeBean().convertSchemeToBean(str));
            return;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("albumid");
        String queryParameter2 = parse.getQueryParameter("uin");
        String queryParameter3 = parse.getQueryParameter("appid");
        boolean z18 = false;
        int i17 = 1;
        boolean z19 = !TextUtils.isEmpty(queryParameter3) && queryParameter3.equals("1000398");
        String queryParameter4 = parse.getQueryParameter("albumtype");
        String queryParameter5 = parse.getQueryParameter("individualalbum");
        String queryParameter6 = parse.getQueryParameter(AlbumCacheData.ANONYMITY);
        String queryParameter7 = parse.getQueryParameter("fromspace");
        String queryParameter8 = parse.getQueryParameter("is_public");
        String queryParameter9 = parse.getQueryParameter("invite_key");
        if (queryParameter4 != null) {
            try {
                parseInt = Integer.parseInt(queryParameter4);
            } catch (Exception e16) {
                e = e16;
                i3 = -1;
                z16 = false;
                i16 = 0;
                e.printStackTrace();
                z17 = false;
                parseInt = i17;
                int i18 = i16;
                boolean z26 = z16;
                if (i3 != -1) {
                }
                long uin = LoginData.getInstance().getUin();
                if (!TextUtils.isEmpty(queryParameter2)) {
                }
                vo.b.d(context, queryParameter, Long.valueOf(uin), "", r5, z26, i18, z17, queryParameter9, z19);
            }
        } else {
            parseInt = 1;
        }
        if (queryParameter5 != null) {
            try {
            } catch (Exception e17) {
                i3 = -1;
                i17 = parseInt;
                e = e17;
                z16 = false;
                i16 = 0;
                e.printStackTrace();
                z17 = false;
                parseInt = i17;
                int i182 = i16;
                boolean z262 = z16;
                if (i3 != -1) {
                }
                long uin2 = LoginData.getInstance().getUin();
                if (!TextUtils.isEmpty(queryParameter2)) {
                }
                vo.b.d(context, queryParameter, Long.valueOf(uin2), "", r5, z262, i182, z17, queryParameter9, z19);
            }
            if (Integer.parseInt(queryParameter5) == 1) {
                z16 = true;
                if (queryParameter6 == null) {
                    try {
                        i3 = Integer.parseInt(queryParameter6);
                    } catch (Exception e18) {
                        e = e18;
                        i3 = -1;
                        i16 = 0;
                        Exception exc = e;
                        i17 = parseInt;
                        e = exc;
                        e.printStackTrace();
                        z17 = false;
                        parseInt = i17;
                        int i1822 = i16;
                        boolean z2622 = z16;
                        if (i3 != -1) {
                        }
                        long uin22 = LoginData.getInstance().getUin();
                        if (!TextUtils.isEmpty(queryParameter2)) {
                        }
                        vo.b.d(context, queryParameter, Long.valueOf(uin22), "", r5, z2622, i1822, z17, queryParameter9, z19);
                    }
                } else {
                    i3 = -1;
                }
                if (queryParameter7 == null) {
                    try {
                        i16 = Integer.parseInt(queryParameter7);
                    } catch (Exception e19) {
                        e = e19;
                        i16 = 0;
                        Exception exc2 = e;
                        i17 = parseInt;
                        e = exc2;
                        e.printStackTrace();
                        z17 = false;
                        parseInt = i17;
                        int i18222 = i16;
                        boolean z26222 = z16;
                        if (i3 != -1) {
                        }
                        long uin222 = LoginData.getInstance().getUin();
                        if (!TextUtils.isEmpty(queryParameter2)) {
                        }
                        vo.b.d(context, queryParameter, Long.valueOf(uin222), "", r5, z26222, i18222, z17, queryParameter9, z19);
                    }
                } else {
                    i16 = 0;
                }
                if (queryParameter8 != null) {
                    try {
                        if (Integer.parseInt(queryParameter8) == 1) {
                            z18 = true;
                        }
                    } catch (Exception e26) {
                        e = e26;
                        Exception exc22 = e;
                        i17 = parseInt;
                        e = exc22;
                        e.printStackTrace();
                        z17 = false;
                        parseInt = i17;
                        int i182222 = i16;
                        boolean z262222 = z16;
                        if (i3 != -1) {
                        }
                        long uin2222 = LoginData.getInstance().getUin();
                        if (!TextUtils.isEmpty(queryParameter2)) {
                        }
                        vo.b.d(context, queryParameter, Long.valueOf(uin2222), "", r5, z262222, i182222, z17, queryParameter9, z19);
                    }
                }
                z17 = z18;
                int i1822222 = i16;
                boolean z2622222 = z16;
                int t16 = i3 != -1 ? QZoneAlbumUtil.t(i3) : parseInt;
                long uin22222 = LoginData.getInstance().getUin();
                if (!TextUtils.isEmpty(queryParameter2)) {
                    uin22222 = Long.valueOf(queryParameter2).longValue();
                }
                vo.b.d(context, queryParameter, Long.valueOf(uin22222), "", t16, z2622222, i1822222, z17, queryParameter9, z19);
            }
        }
        z16 = false;
        if (queryParameter6 == null) {
        }
        if (queryParameter7 == null) {
        }
        if (queryParameter8 != null) {
        }
        z17 = z18;
        int i18222222 = i16;
        boolean z26222222 = z16;
        if (i3 != -1) {
        }
        long uin222222 = LoginData.getInstance().getUin();
        if (!TextUtils.isEmpty(queryParameter2)) {
        }
        vo.b.d(context, queryParameter, Long.valueOf(uin222222), "", t16, z26222222, i18222222, z17, queryParameter9, z19);
    }

    public static void x(Context context, String str) {
        if (str.indexOf("url=") != -1) {
            String substring = str.substring(str.indexOf("url=") + 4, str.length());
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("mqqflag", 1);
            intent.putExtra("cell_operation.qq_url", substring);
            i.e().g(context, intent.getExtras());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0071 A[Catch: Exception -> 0x0094, TryCatch #2 {Exception -> 0x0094, blocks: (B:2:0x0000, B:27:0x003e, B:5:0x004d, B:22:0x0053, B:8:0x0060, B:10:0x0071, B:11:0x0074, B:13:0x0084, B:14:0x0087, B:16:0x008d, B:17:0x0090, B:25:0x0059, B:30:0x0047), top: B:1:0x0000, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0084 A[Catch: Exception -> 0x0094, TryCatch #2 {Exception -> 0x0094, blocks: (B:2:0x0000, B:27:0x003e, B:5:0x004d, B:22:0x0053, B:8:0x0060, B:10:0x0071, B:11:0x0074, B:13:0x0084, B:14:0x0087, B:16:0x008d, B:17:0x0090, B:25:0x0059, B:30:0x0047), top: B:1:0x0000, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008d A[Catch: Exception -> 0x0094, TryCatch #2 {Exception -> 0x0094, blocks: (B:2:0x0000, B:27:0x003e, B:5:0x004d, B:22:0x0053, B:8:0x0060, B:10:0x0071, B:11:0x0074, B:13:0x0084, B:14:0x0087, B:16:0x008d, B:17:0x0090, B:25:0x0059, B:30:0x0047), top: B:1:0x0000, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void y(Context context, String str) {
        int parseInt;
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("uin");
            String queryParameter2 = parse.getQueryParameter(QZoneHelper.INTENT_EXTINFO);
            String queryParameter3 = parse.getQueryParameter("actiontype");
            String queryParameter4 = parse.getQueryParameter(AlbumCacheData.ACTIONURL);
            String queryParameter5 = parse.getQueryParameter("bottomurl");
            String queryParameter6 = parse.getQueryParameter("bottomtext");
            String queryParameter7 = parse.getQueryParameter("is_famous_space");
            if (!TextUtils.isEmpty(queryParameter4)) {
                try {
                    queryParameter4 = URLDecoder.decode(queryParameter4, "UTF-8");
                } catch (UnsupportedEncodingException e16) {
                    QZLog.e("onGoHomePage", "decode actionurl", e16);
                }
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                try {
                    parseInt = Integer.parseInt(queryParameter3);
                } catch (NumberFormatException e17) {
                    QZLog.e("onGoHomePage", "parse actiontype", e17);
                }
                QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean();
                qZoneUserHomeBean.setExtInfo(queryParameter2);
                qZoneUserHomeBean.setActionType(parseInt);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    qZoneUserHomeBean.setActionUrl(queryParameter4);
                }
                qZoneUserHomeBean.setFamousSpace("1".equals(queryParameter7));
                if (!TextUtils.isEmpty(queryParameter5)) {
                    qZoneUserHomeBean.setBottomBubbleUrl(queryParameter5);
                }
                if (!TextUtils.isEmpty(queryParameter6)) {
                    qZoneUserHomeBean.setBottomBubbleText(queryParameter6);
                }
                V(context, queryParameter, qZoneUserHomeBean);
            }
            parseInt = 0;
            QZoneUserHomeBean qZoneUserHomeBean2 = new QZoneUserHomeBean();
            qZoneUserHomeBean2.setExtInfo(queryParameter2);
            qZoneUserHomeBean2.setActionType(parseInt);
            if (!TextUtils.isEmpty(queryParameter4)) {
            }
            qZoneUserHomeBean2.setFamousSpace("1".equals(queryParameter7));
            if (!TextUtils.isEmpty(queryParameter5)) {
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
            }
            V(context, queryParameter, qZoneUserHomeBean2);
        } catch (Exception e18) {
            xe.b.f447841a.d(e18);
        }
    }

    public static void z(Context context, String str) {
        try {
            if (!xo.a.b()) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("QZoneSchemaHandleLogic", 2, "onGoPaster, paster not support");
                }
                QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
                qZonePublishMoodInitBean.t0(0);
                Boolean bool = Boolean.FALSE;
                qZonePublishMoodInitBean.R0(bool);
                qZonePublishMoodInitBean.v0(bool);
                qZonePublishMoodInitBean.C0("shuoshuoPlus");
                qZonePublishMoodInitBean.O0(21);
                i.w().c((Activity) context, qZonePublishMoodInitBean);
                return;
            }
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("pasterid");
            String queryParameter2 = parse.getQueryParameter("pastercatid");
            if (TextUtils.isEmpty(queryParameter2)) {
                queryParameter2 = "-1";
            }
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = "-1";
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("PhotoConst.IS_SINGLE_MODE", false);
            bundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
            bundle.putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, false);
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
            bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
            bundle.putString("PhotoConst.PLUGIN_NAME", "QZone");
            bundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
            bundle.putString("PhotoConst.UIN", LoginData.getInstance().getUinString());
            bundle.putBoolean("PhotoConst.IS_CALL_IN_PLUGIN", true);
            bundle.putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
            bundle.putString("uin", LoginData.getInstance().getUinString());
            bundle.putInt("uintype", 0);
            bundle.putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
            bundle.putBoolean(PeakConstants.SHOW_MAGIC_USE_PASTER, true);
            bundle.putString("PasterConstants.paster_id", queryParameter);
            bundle.putString("PasterConstants.paster_cate_id", queryParameter2);
            bundle.putBoolean("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
            bundle.putInt("PasterConstants.intent_params_refer", 5);
            bundle.putBoolean("cleartop", true);
            bundle.putLong(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
            ZebraPluginProxy.startPhotoList((Activity) context, bundle);
        } catch (Exception e16) {
            QZLog.w(e16);
        } catch (Throwable th5) {
            QZLog.w(th5);
        }
    }

    public static int u(Context context, String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("fromTranslucent", 1);
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("base64url");
            String queryParameter2 = parse.getQueryParameter("from");
            if (TextUtils.isEmpty(queryParameter)) {
                return -1;
            }
            String str2 = new String(PluginBaseInfoHelper.Base64Helper.decode(queryParameter, 0));
            bundle.putInt("mqqflag", 1);
            bundle.putString("cell_operation.qq_url", str2);
            if ("aio".equals(queryParameter2)) {
                bundle.putInt(QZoneHelper.QZoneAppConstants.JUMP_TO_DETAIL_FROM_QQ_WHAT, 2);
            }
            i.e().g(context, bundle);
            return 4;
        } catch (Exception e16) {
            QLog.e("QZoneSchemeHandleLogic", 1, "getQZoneDetailIntent", e16);
            return -1;
        }
    }

    private static void c(Context context, String str, String str2) {
        b(context, 10000L, str, str2);
    }

    public static void l(Activity activity, String str) {
        k(activity, str, 11);
    }

    public static void e(Context context, int i3) {
        if (i3 == 2) {
            if (b.g(context, b.f450703e)) {
                f(context);
                return;
            } else {
                d.f(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_LIVEVIDEO_DULI_DOWNLOAD, QzoneConfig.DefaultValue.DEFAULT_LIVEVIDEO_DULI_DOWNLOAD), context, null);
                return;
            }
        }
        if (i3 == 3) {
            if (b.g(context, b.f450703e)) {
                f(context);
            }
        } else if (i3 == 4) {
            d.b(context, new g(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_VIDEO_LIST_URL, "https://h5.qzone.qq.com/live/list?_wv=1027&_proxy=1&source=6")));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r6v3 */
    public static void w(Context context, String str, BusinessFeedData businessFeedData) {
        ?? r65;
        int i3;
        int i16;
        String str2;
        if (com.qzone.reborn.albumx.qzonex.utils.d.a()) {
            new wb.a().a(context, new QZoneSchemeBean().convertSchemeToBean(str));
            return;
        }
        String[] split = str.split("[&|?]");
        int i17 = 0;
        String str3 = "";
        if (split.length <= 0) {
            r65 = 0;
            i3 = 0;
            i16 = 1;
            str2 = "";
        } else {
            int length = split.length;
            int i18 = 0;
            boolean z16 = false;
            i3 = 0;
            i16 = 1;
            String str4 = "";
            String str5 = str4;
            while (i17 < length) {
                String str6 = split[i17];
                if (str6.startsWith("albumid")) {
                    str4 = str6.replace("albumid=", "");
                } else if (str6.startsWith("uin")) {
                    str5 = str6.replace("uin=", "");
                } else if (str6.startsWith("albumtype")) {
                    if (!TextUtils.isEmpty(str6.replace("albumtype=", ""))) {
                        i16 = Integer.valueOf(str6.replace("albumtype=", "")).intValue();
                    }
                } else if (str6.contains("individualalbum=1")) {
                    z16 = true;
                } else if (str6.contains("anonymity=5") || str6.contains("anonymity=6")) {
                    try {
                        i3 = Integer.parseInt(str6.replace("anonymity=", ""));
                    } catch (NumberFormatException e16) {
                        QZLog.e(AlbumCacheData.ANONYMITY, "parse ", e16);
                    }
                    i18 = 1;
                }
                i17++;
            }
            i17 = i18;
            r65 = z16;
            str2 = str4;
            str3 = str5;
        }
        if (r65 == 0 && i17 == 0) {
            long uin = LoginData.getInstance().getUin();
            if (!TextUtils.isEmpty(str3)) {
                uin = Long.valueOf(str3).longValue();
            }
            vo.b.c(context, str2, Long.valueOf(uin), "", i16, r65);
            return;
        }
        new a.C11115a();
        d.d("mqzone://arouse/album?albumid=" + str2 + "&version=1&source=tafrefer&uin=" + str3 + "&albumtype=" + QZoneAlbumUtil.t(i3) + "&syncuin=" + LoginData.getInstance().getUin() + "&individualalbum=" + ((int) r65), context, null);
    }

    public static void K(Context context, String str) {
    }
}
