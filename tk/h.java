package tk;

import NS_MOBILE_PHOTO.Photo;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import androidx.core.util.Consumer;
import com.qzone.business.share.ShareUtils;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.qzone.report.QZonePerfReporter;
import com.qzone.util.l;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import tk.h;

/* compiled from: P */
/* loaded from: classes36.dex */
public class h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a implements RFWDownloader.RFWDownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ tk.a f436422d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f436423e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f436424f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f436425h;

        a(tk.a aVar, boolean z16, Activity activity, String str) {
            this.f436422d = aVar;
            this.f436423e = z16;
            this.f436424f = activity;
            this.f436425h = str;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onRspCallback(boolean z16, String str) {
            if (!z16) {
                QLog.e("QZoneFeedxLayerUtil", 1, "tryToDownloadMediaFile failed!");
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final tk.a aVar = this.f436422d;
                final boolean z17 = this.f436423e;
                final Activity activity = this.f436424f;
                uIHandlerV2.post(new Runnable() { // from class: tk.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.a.b(a.this, z17, activity);
                    }
                });
                return;
            }
            QLog.d("QZoneFeedxLayerUtil", 1, "tryToDownloadMediaFile success!filePath:" + str);
            h.i(this.f436424f, str, this.f436425h, this.f436423e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(tk.a aVar, boolean z16, Activity activity) {
            if (aVar != null && !z16) {
                aVar.a();
            } else {
                QQToast.makeText(activity, 0, z16 ? R.string.f238307je : R.string.cwi, 0).show();
            }
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void callEnd(Call call) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void callStart(Call call) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void requestBodyStart(Call call) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void requestHeadersStart(Call call) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void responseBodyStart(Call call) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void responseHeadersStart(Call call) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void secureConnectStart(Call call) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void callFailed(Call call, IOException iOException) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void connectionAcquired(Call call, Connection connection) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void connectionReleased(Call call, Connection connection) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void dnsStart(Call call, String str) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void requestBodyEnd(Call call, long j3) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void requestHeadersEnd(Call call, Request request) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void responseBodyEnd(Call call, long j3) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void responseHeadersEnd(Call call, Response response) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void secureConnectEnd(Call call, Handshake handshake) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void dnsEnd(Call call, String str, List<InetAddress> list) {
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onDownloadProgress(float f16, long j3, long j16) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f436430a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f436431b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f436432c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f436433d;

        c(Activity activity, String str, String str2, boolean z16) {
            this.f436430a = activity;
            this.f436431b = str;
            this.f436432c = str2;
            this.f436433d = z16;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            h.N(this.f436430a, this.f436431b, this.f436432c, this.f436433d);
        }
    }

    public static boolean C() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_OPEN_LAYER_CARVED_ANIM, 1) == 1;
    }

    public static boolean F(ArrayList<Photo> arrayList) {
        Iterator<Photo> it = arrayList.iterator();
        while (it.hasNext()) {
            Photo next = it.next();
            if (next == null) {
                RFWLog.e("QZoneFeedxLayerUtil", RFWLog.USR, "photo is null");
                return false;
            }
            if (!G(next)) {
                RFWLog.e("QZoneFeedxLayerUtil", RFWLog.USR, "photo video data is invalid, lloc is " + next.lloc);
                return false;
            }
        }
        return true;
    }

    public static boolean G(Photo photo) {
        return !TextUtils.isEmpty(r(PictureViewerFactory.r(com.qzone.proxy.feedcomponent.util.e.s(photo.videodata))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(Context context, boolean z16, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        QLog.i("QZoneFeedxLayerUtil", 1, "newSaveAlbumApi, result: " + rFWSaveMediaResultBean.isSuccess);
        j(context, Boolean.valueOf(rFWSaveMediaResultBean.isSuccess), z16);
    }

    private static void M(String str, String str2, String str3) {
        RFWLog.d("QZoneFeedxLayerUtil", RFWLog.USR, "reportDownloadPicResult: url: " + str + ", path: " + str2 + ", imageFormat: " + str3);
        QZonePerfReporter.f59697a.k(str, str3, "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(final Activity activity, String str, String str2, final boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            L(activity, str, str2, z16);
        } else {
            QLog.e("QZoneFeedxLayerUtil", 1, "saveMedia error\uff0cmediaPath is null!");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: tk.e
                @Override // java.lang.Runnable
                public final void run() {
                    h.J(activity, z16);
                }
            });
        }
    }

    public static void O(final Context context, String str, String str2, final boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            L(context, str, str2, z16);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: tk.c
                @Override // java.lang.Runnable
                public final void run() {
                    h.K(context, z16);
                }
            });
        }
    }

    public static void S(long j3) {
        ((Vibrator) MobileQQ.sMobileQQ.getSystemService("vibrator")).vibrate(j3);
    }

    private static String f(String str, String str2) {
        RFWLog.d("QZoneFeedxLayerUtil", RFWLog.USR, "avifToJpgFile: url: " + str2 + ", path: " + str);
        Bitmap b16 = com.tencent.qzone.image.api.a.c().b(str, str2, 0, 0);
        if (b16 != null) {
            String str3 = u6.a.f438462b + ("Image_" + System.currentTimeMillis() + ".jpeg");
            if (RFWSaveUtil.saveBitmapAsJpg(b16, str3)) {
                RFWLog.d("QZoneFeedxLayerUtil", RFWLog.USR, "avifToJpgFile success: url: " + str2 + ", new path: " + str3);
                return str3;
            }
            RFWLog.d("QZoneFeedxLayerUtil", RFWLog.USR, "avifToJpgFile fail: url: " + str2 + ", new path: " + str);
        } else {
            RFWLog.d("QZoneFeedxLayerUtil", RFWLog.USR, "avifToJpgFile fail bitmap is null: url: " + str2 + ", path: " + str);
        }
        return str;
    }

    public static int g(PhotoInfo photoInfo, PhotoParam photoParam, boolean z16) {
        return ShareUtils.d(com.qzone.preview.d.d(photoParam), photoInfo.shareSpaceRight, photoInfo.shareAlbumRight, z16, false);
    }

    public static int h(PhotoInfo photoInfo, PhotoParam photoParam, boolean z16) {
        return ShareUtils.b(com.qzone.preview.d.d(photoParam), photoInfo.shareSpaceRight, photoParam.videoUgcRight, z16);
    }

    public static void i(Activity activity, String str, String str2, boolean z16) {
        if (!com.tencent.mobileqq.startup.permission.a.f(activity)) {
            QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_PIC)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c(activity, str, str2, z16));
        } else {
            N(activity, str, str2, z16);
        }
    }

    private static void j(final Context context, Boolean bool, boolean z16) {
        final int i3 = bool.booleanValue() ? 2 : 0;
        final int i16 = z16 ? R.string.f238307je : R.string.cwi;
        if (bool.booleanValue()) {
            i16 = R.string.f173075h42;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: tk.f
            @Override // java.lang.Runnable
            public final void run() {
                h.H(context, i3, i16);
            }
        });
    }

    public static boolean m(int i3, int i16) {
        return com.qzone.reborn.configx.g.f53821a.b().Q() && E(i3, i16);
    }

    public static String n(PhotoInfo photoInfo) {
        if (photoInfo.appid == 311) {
            return photoInfo.pssCurLikeKey;
        }
        return photoInfo.curkey;
    }

    public static RFWLayerPicInfo o(PictureItem pictureItem, BusinessFeedData businessFeedData) {
        String str;
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setCurrentPicInfo(new RFWLayerPicInfo.RFWPicInfo());
        if (pictureItem == null) {
            return rFWLayerPicInfo;
        }
        PictureUrl pictureUrl = pictureItem.currentUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            str = pictureItem.currentUrl.url;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str) && pictureItem.videoflag == 1 && pictureItem.videodata != null) {
            if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
                RFWLog.e("QZoneFeedxLayerUtil", RFWLog.USR, "url is empty, try to get video cover url, feed id is " + businessFeedData.getFeedCommInfo().feedsid + " feedsKey is " + businessFeedData.getFeedCommInfo().feedskey);
            }
            PictureUrl pictureUrl2 = pictureItem.videodata.coverUrl;
            if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
                str = pictureItem.videodata.coverUrl.url;
            } else {
                PictureUrl pictureUrl3 = pictureItem.videodata.bigUrl;
                if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
                    str = pictureItem.videodata.bigUrl.url;
                } else {
                    PictureUrl pictureUrl4 = pictureItem.videodata.currentUrl;
                    if (pictureUrl4 != null && !TextUtils.isEmpty(pictureUrl4.url)) {
                        str = pictureItem.videodata.currentUrl.url;
                    } else {
                        PictureUrl pictureUrl5 = pictureItem.videodata.originUrl;
                        if (pictureUrl5 != null && !TextUtils.isEmpty(pictureUrl5.url)) {
                            str = pictureItem.videodata.originUrl.url;
                        }
                    }
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
                RFWLog.e("QZoneFeedxLayerUtil", RFWLog.USR, "url is still empty, feed id is " + businessFeedData.getFeedCommInfo().feedsid + " feedsKey is " + businessFeedData.getFeedCommInfo().feedskey);
            }
            PictureUrl pictureUrl6 = pictureItem.bigUrl;
            if (pictureUrl6 != null && !TextUtils.isEmpty(pictureUrl6.url)) {
                str = pictureItem.bigUrl.url;
            } else {
                PictureUrl pictureUrl7 = pictureItem.downloadUrl;
                if (pictureUrl7 != null && !TextUtils.isEmpty(pictureUrl7.url)) {
                    str = pictureItem.downloadUrl.url;
                } else {
                    PictureUrl pictureUrl8 = pictureItem.originUrl;
                    if (pictureUrl8 != null && !TextUtils.isEmpty(pictureUrl8.url)) {
                        str = pictureItem.originUrl.url;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
                RFWLog.e("QZoneFeedxLayerUtil", RFWLog.USR, "all url is empty, exception, feed id is " + businessFeedData.getFeedCommInfo().feedsid + " feedsKey is " + businessFeedData.getFeedCommInfo().feedskey);
            }
            RFWLog.e("QZoneFeedxLayerUtil", RFWLog.USR, "all url is empty, exception");
        }
        rFWLayerPicInfo.getCurrentPicInfo().setUrl(str);
        rFWLayerPicInfo.getCurrentPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(str)));
        return rFWLayerPicInfo;
    }

    public static String p(int i3) {
        if (i3 <= 0) {
            return "";
        }
        String str = i3 + "";
        if (i3 <= 9999) {
            return str;
        }
        if (i3 > 99999999) {
            return (i3 / 100000000) + l.a(R.string.s3s);
        }
        if (i3 > 9999999) {
            return (i3 / 10000000) + l.a(R.string.s3v);
        }
        return (i3 / 10000) + l.a(R.string.s3m);
    }

    public static LibraGroupKey q(PictureItem pictureItem) {
        return new LibraGroupKey(pictureItem.lloc);
    }

    public static String r(VideoInfo videoInfo) {
        if (videoInfo == null) {
            return "";
        }
        VideoUrl videoUrl = videoInfo.videoUrl;
        if (videoUrl != null && !TextUtils.isEmpty(videoUrl.url)) {
            return videoInfo.videoUrl.url;
        }
        VideoUrl videoUrl2 = videoInfo.downloadVideoUrl;
        if (videoUrl2 != null && !TextUtils.isEmpty(videoUrl2.url)) {
            return videoInfo.downloadVideoUrl.url;
        }
        VideoUrl videoUrl3 = videoInfo.highBrUrl;
        if (videoUrl3 != null && !TextUtils.isEmpty(videoUrl3.url)) {
            return videoInfo.highBrUrl.url;
        }
        if (!TextUtils.isEmpty(videoInfo.actionUrl)) {
            return videoInfo.actionUrl;
        }
        VideoUrl videoUrl4 = videoInfo.lowBrUrl;
        if (videoUrl4 != null && !TextUtils.isEmpty(videoUrl4.url)) {
            return videoInfo.lowBrUrl.url;
        }
        VideoUrl videoUrl5 = videoInfo.originVideoUrl;
        if (videoUrl5 != null && !TextUtils.isEmpty(videoUrl5.url)) {
            return videoInfo.originVideoUrl.url;
        }
        RFWLog.e("QZoneFeedxLayerUtil", RFWLog.USR, "all video url is null");
        return "";
    }

    public static String s(PictureItem pictureItem) {
        if (pictureItem == null) {
            return "";
        }
        PictureUrl pictureUrl = pictureItem.currentUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            return pictureItem.currentUrl.url;
        }
        PictureUrl pictureUrl2 = pictureItem.bigUrl;
        if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            return pictureItem.bigUrl.url;
        }
        PictureUrl pictureUrl3 = pictureItem.downloadUrl;
        if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
            return pictureItem.downloadUrl.url;
        }
        PictureUrl pictureUrl4 = pictureItem.originUrl;
        if (pictureUrl4 != null && !TextUtils.isEmpty(pictureUrl4.url)) {
            return pictureItem.originUrl.url;
        }
        RFWLog.e("QZoneFeedxLayerUtil", RFWLog.USR, "all picture url is null");
        return "";
    }

    public static String u(PhotoInfo photoInfo) {
        if (photoInfo.appid == 311) {
            return photoInfo.pssUgcKey;
        }
        if (photoInfo.videodata == null) {
            return "";
        }
        return new QZoneSchemeBean().convertSchemeToBean(photoInfo.videodata.actionUrl).getAttrs().get("feed_id");
    }

    public static String v(PhotoInfo photoInfo) {
        if (photoInfo.appid == 311) {
            return photoInfo.pssOrgLikeKey;
        }
        return photoInfo.unikey;
    }

    public static int y(PhotoInfo photoInfo, PhotoParam photoParam, boolean z16) {
        if (z(photoParam)) {
            return g(photoInfo, photoParam, z16);
        }
        return h(photoInfo, photoParam, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b implements RFWDownloader.RFWDownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ tk.a f436426d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f436427e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f436428f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f436429h;

        b(tk.a aVar, boolean z16, Context context, String str) {
            this.f436426d = aVar;
            this.f436427e = z16;
            this.f436428f = context;
            this.f436429h = str;
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callEnd(Call call) {
            v.a(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callFailed(Call call, IOException iOException) {
            v.b(this, call, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callStart(Call call) {
            v.c(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
            v.d(this, call, inetSocketAddress, proxy, protocol2);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
            v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            v.f(this, call, inetSocketAddress, proxy);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
            v.g(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionReleased(Call call, Connection connection) {
            v.h(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsEnd(Call call, String str, List list) {
            v.i(this, call, str, list);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsStart(Call call, String str) {
            v.j(this, call, str);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyEnd(Call call, long j3) {
            v.k(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyStart(Call call) {
            v.l(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
            v.m(this, call, request);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersStart(Call call) {
            v.n(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyEnd(Call call, long j3) {
            v.o(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyStart(Call call) {
            v.p(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
            v.q(this, call, response);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersStart(Call call) {
            v.r(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
            v.s(this, call, handshake);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectStart(Call call) {
            v.t(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onRspCallback(boolean z16, String str) {
            if (!z16) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final tk.a aVar = this.f436426d;
                final boolean z17 = this.f436427e;
                final Context context = this.f436428f;
                uIHandlerV2.post(new Runnable() { // from class: tk.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.b.b(a.this, z17, context);
                    }
                });
                return;
            }
            h.O(this.f436428f, str, this.f436429h, this.f436427e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(tk.a aVar, boolean z16, Context context) {
            if (aVar != null && !z16) {
                aVar.a();
            } else {
                QQToast.makeText(context, 0, z16 ? R.string.f238307je : R.string.cwi, 0).show();
            }
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onDownloadProgress(float f16, long j3, long j16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(Context context, int i3, int i16) {
        QQToast.makeText(context, i3, i16, 0).show();
    }

    public static void Q(Activity activity, String str, boolean z16) {
        R(activity, str, z16, null);
    }

    public static void R(Activity activity, String str, boolean z16, tk.a aVar) {
        if (activity == null) {
            QLog.e("QZoneFeedxLayerUtil", 1, "activity is null");
        } else if (TextUtils.isEmpty(str)) {
            QLog.e("QZoneFeedxLayerUtil", 1, "url is empty");
        } else {
            RFWDownloaderFactory.getDownloader(new u6.c()).download(str, new a(aVar, z16, activity, str));
        }
    }

    public static void k(Context context, String str, boolean z16) {
        l(context, str, z16, null);
    }

    public static void l(Context context, String str, boolean z16, tk.a aVar) {
        if (context == null) {
            QLog.e("QZoneFeedxLayerUtil", 1, "activity is null");
        } else if (TextUtils.isEmpty(str)) {
            QLog.e("QZoneFeedxLayerUtil", 1, "url is empty");
        } else {
            RFWDownloaderFactory.getDownloader(new u6.c()).download(str, new b(aVar, z16, context, str));
        }
    }

    public static int x(PhotoInfo photoInfo, PhotoParam photoParam) {
        return y(photoInfo, photoParam, true);
    }

    public static void L(final Context context, String str, String str2, final boolean z16) {
        if (!z16) {
            try {
                String B = com.qzone.util.image.c.B(str);
                M(str2, str, B);
                if (TextUtils.equals(B, "avif")) {
                    str = f(str, str2);
                }
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
        RFWSaveUtil.insertMedia(context, str, new Consumer() { // from class: tk.d
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                h.I(context, z16, (RFWSaveMediaResultBean) obj);
            }
        });
    }

    private static boolean z(PhotoParam photoParam) {
        return (photoParam == null || photoParam.appid == 311) ? false : true;
    }

    public static boolean D(PictureItem pictureItem) {
        PictureUrl pictureUrl;
        PictureUrl pictureUrl2;
        int i3;
        if (pictureItem == null || (pictureUrl = pictureItem.bigUrl) == null || TextUtils.isEmpty(pictureUrl.url) || (i3 = (pictureUrl2 = pictureItem.bigUrl).width) < 0 || pictureUrl2.height < 0) {
            return false;
        }
        return ((float) i3) >= ((float) ImmersiveUtils.getScreenWidth()) * 1.2f || ((float) pictureItem.bigUrl.height) >= ((float) ImmersiveUtils.getScreenHeight()) * 1.2f;
    }

    public static void P(View view, int i3) {
        if (view == null) {
            return;
        }
        view.setVisibility(i3);
    }

    public static boolean B(PictureItem pictureItem) {
        return (pictureItem == null || TextUtils.isEmpty(pictureItem.lloc) || !com.qzone.reborn.configx.g.f53821a.b().c0()) ? false : true;
    }

    public static PictureUrl t(PictureItem pictureItem) {
        if (pictureItem == null) {
            return null;
        }
        PictureUrl pictureUrl = pictureItem.downloadUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            return pictureItem.downloadUrl;
        }
        PictureUrl pictureUrl2 = pictureItem.originUrl;
        if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            return pictureItem.originUrl;
        }
        PictureUrl pictureUrl3 = pictureItem.bigUrl;
        if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
            return pictureItem.bigUrl;
        }
        PictureUrl pictureUrl4 = pictureItem.currentUrl;
        if (pictureUrl4 != null && !TextUtils.isEmpty(pictureUrl4.url)) {
            return pictureItem.currentUrl;
        }
        RFWLog.e("QZoneFeedxLayerUtil", RFWLog.USR, "getPictureUrlFirstDownload all picture url is null");
        return null;
    }

    public static PictureUrl w(com.qzone.proxy.feedcomponent.model.VideoInfo videoInfo) {
        if (videoInfo == null) {
            return null;
        }
        PictureUrl pictureUrl = videoInfo.originUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            return videoInfo.originUrl;
        }
        PictureUrl pictureUrl2 = videoInfo.bigUrl;
        if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            return videoInfo.bigUrl;
        }
        PictureUrl pictureUrl3 = videoInfo.currentUrl;
        if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
            return videoInfo.currentUrl;
        }
        PictureUrl pictureUrl4 = videoInfo.coverUrl;
        if (pictureUrl4 != null && !TextUtils.isEmpty(pictureUrl4.url)) {
            return videoInfo.coverUrl;
        }
        RFWLog.e("QZoneFeedxLayerUtil", RFWLog.USR, "getVideoPictureUrlFirstDownload all picture url is null");
        return null;
    }

    public static boolean A(RFWLayerState rFWLayerState, PhotoParam photoParam) {
        return rFWLayerState != null && photoParam != null && !ArrayUtils.isOutOfArrayIndex(0, rFWLayerState.getRichMediaDataList()) && rFWLayerState.getRichMediaDataList().size() == 1 && rFWLayerState.getRichMediaDataList().get(0).isVideo() && photoParam.appid == 4;
    }

    private static boolean E(int i3, int i16) {
        if (i3 <= 0 || i16 <= 0) {
            return false;
        }
        com.qzone.reborn.configx.g gVar = com.qzone.reborn.configx.g.f53821a;
        float c16 = gVar.b().c1();
        float b16 = gVar.b().b1();
        float f16 = i16;
        float f17 = i3;
        float f18 = f16 / f17;
        QLog.i("QZoneFeedxLayerUtil", 2, "magnificationStandard is " + c16 + ", lengthWidthRatioStandard is " + b16 + ", lengthWidthRatio is " + f18 + ", width is " + i3 + ", height is " + i16);
        return f17 > ((float) ImmersiveUtils.getScreenWidth()) * c16 || f16 > ((float) ImmersiveUtils.getScreenHeight()) * c16 || f18 > b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(Activity activity, boolean z16) {
        QQToast.makeText(activity, 0, z16 ? R.string.f238307je : R.string.cwi, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(Context context, boolean z16) {
        QQToast.makeText(context, 0, z16 ? R.string.f238307je : R.string.cwi, 0).show();
    }
}
