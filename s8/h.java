package s8;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.activities.base.BaseFeedFragmentFeedImp;
import com.qzone.common.event.EventCenter;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.manager.QZoneVideoLoader;
import com.qzone.proxy.feedcomponent.model.TencentVideoModule;
import com.qzone.proxy.feedcomponent.model.r;
import com.qzone.util.ToastUtil;
import com.qzone.video.service.QZoneVideoReportService;
import com.qzone.widget.AvatarImageView;
import com.qzone.widget.ExtendImageView;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.HeroPlayerAvailableCheck;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlaybackReportInfo;
import com.tencent.mobileqq.qzoneplayer.video.u;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.oskplayer.VideoLoader;
import com.tencent.oskplayer.model.VideoDecoderType;
import com.tencent.oskplayer.player.FFSegmentMediaPlayer;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.report.capability.decode.TVKDeviceDecodeCapabilityReportConstant;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.upload.network.base.ConnectionImpl;
import com.tencent.webbundle.sdk.WebBundleConstants;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class h implements FeedVideoEnv.FeedVideoExternalFunc {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f433438a = false;

    /* renamed from: b, reason: collision with root package name */
    public static volatile int f433439b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static String[] f433440c;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements SDKInitListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qzoneplayer.video.k f433441d;

        a(com.tencent.mobileqq.qzoneplayer.video.k kVar) {
            this.f433441d = kVar;
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            com.tencent.mobileqq.qzoneplayer.video.k kVar = this.f433441d;
            if (kVar != null) {
                kVar.onSDKInited(z16);
            } else {
                QZLog.w("FeedVideoExternalFuncImpl", "[onSDKInited] listener should not be null.");
            }
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ExtendImageView getAvatarImageView(Context context, long j3) {
        AvatarImageView avatarImageView = new AvatarImageView(context);
        avatarImageView.j(j3);
        return avatarImageView;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean canVideoPlayAuto() {
        return com.qzone.adapter.feedcomponent.i.H().m();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void checkVideoIllegal(String str, u uVar) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("FeedVideoExternalFuncImpl", 4, "[QZ_Video]video play check vid legality = " + str);
        }
        com.qzone.proxy.feedcomponent.model.u j3 = QZoneVideoLoader.l().j(str, uVar);
        if (j3 == null || j3.a() != -3 || uVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(j3.b())) {
            ToastUtil.r(j3.b());
        }
        uVar.a(str, j3.a(), j3.b());
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void cleanCacheFor403(String str) {
        TencentVideoModule.k(str);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public Bitmap drawableToBitmap(Drawable drawable) {
        return FeedGlobalEnv.g().drawableToBitmap(drawable);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean forceUrlExpired() {
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public int getCommentWidth_Rec() {
        return com.qzone.adapter.feedcomponent.i.H().Q();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean getCurrentLoadingImgStatus() {
        return com.qzone.adapter.feedcomponent.i.H().V();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    @Deprecated
    public HttpRetryLogic getHttpRetryLogic() {
        return QZoneVideoLoader.l().m();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public int getIPStackType() {
        if (ConnectionImpl.isLibraryPrepared()) {
            return UploadEnv.getIpStack(2);
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean getLogLevel() {
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public long getLoginUin() {
        return LoginData.getInstance().getUin();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public int getNetworkType(Context context) {
        if (f433439b != -1) {
            return f433439b;
        }
        return NetworkState.getNetworkType();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public HandlerThread getRealTimeThread() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("QZVDSDK", -2);
        if (!baseHandlerThread.isAlive()) {
            baseHandlerThread.start();
        }
        return baseHandlerThread;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public FeedVideoEnv.RunningEnv getRunningEnv() {
        return FeedVideoEnv.RunningEnv.DEFAULT;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void getSafeurl(String str, String str2, String str3, String str4, com.tencent.mobileqq.qzoneplayer.video.i iVar) {
        r.e().g(str, str2, str4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public List<String> getUgcVideoIp(String str) {
        String[] strArr = f433440c;
        if (strArr != null) {
            return Arrays.asList(strArr);
        }
        return com.qzone.adapter.feedcomponent.i.H().G0(str);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public VideoLoader getVideoLoader() {
        return QZoneVideoLoader.l();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public VideoDecoderType.LocalSetting getVideoPlayerLocalSetting() {
        if (QQTheme.isNowSimpleUI()) {
            boolean z16 = QzoneConfig.getInstance().getConfig("QZVideo", QzoneConfig.SECONDARY_QZONE_VIDEO_DECODE_TYPE_SW_ON_SIMPLE_UI, 1) == 1;
            boolean z17 = FFSegmentMediaPlayer.isSupported() && HeroPlayerAvailableCheck.h().i(VideoDecoderType.DecoderType.H264);
            boolean z18 = MobileQQ.sProcessId == 1;
            QZLog.i("FeedVideoExternalFuncImpl", 1, "[getVideoPlayerLocalSetting] isUseSWOnSimpleUI=" + z16 + ", isSWAvailable=" + z17 + ", isQQProcess=" + z18);
            if (z16 && z17 && z18) {
                return VideoDecoderType.LocalSetting.HERO;
            }
        }
        return VideoDecoderType.LocalSetting.AUTO;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public List<String> getWeishiVideoIp(String str) {
        String[] strArr = f433440c;
        if (strArr != null) {
            return Arrays.asList(strArr);
        }
        return com.qzone.adapter.feedcomponent.i.H().G0(str);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public int getWnsConfig(String str, String str2, int i3) {
        return QzoneConfig.getInstance().getConfig(str, str2, i3);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void initAutoVideoSetting(Context context) {
        com.qzone.adapter.feedcomponent.i.H().R0(context);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean initTcDataSource() {
        return true;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean initVideoSdk(com.tencent.mobileqq.qzoneplayer.video.k kVar) {
        QQVideoPlaySDKManager.initSDKAsync(BaseApplication.context, new a(kVar));
        return true;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void injectPreloadParam(SuperPlayerVideoInfo superPlayerVideoInfo, AtomicLong atomicLong, AtomicLong atomicLong2, SuperPlayerDownOption superPlayerDownOption) {
        com.qzone.commoncode.module.gdt.c.g().j(superPlayerVideoInfo, atomicLong, atomicLong2, superPlayerDownOption);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean isDebugVersion() {
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean isDecoderProbeEnabled() {
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean isEnable360Video() {
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean isForceDisableSuperPlayer() {
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean isForceUseFFPlayer() {
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean isFreeTraffic() {
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean isListViewScrollIdle() {
        return com.qzone.adapter.feedcomponent.i.H().g1();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean isNetworkAvailable(Context context) {
        return NetworkUtil.isNetworkAvailable(context);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean isPicBigMode() {
        return BaseFeedFragmentFeedImp.q() == 1 || (BaseFeedFragmentFeedImp.q() == 0 && NetworkState.isWifiConn());
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean isSuperPlayerEnabled() {
        return QZoneVideoLoader.s();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean isUgcOnCloudUrl(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        if (!TextUtils.isEmpty(host) && (split = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_ON_CLOUD_HOSTS, "photovideo.photo.qq.com").split("\\|")) != null && split.length > 0) {
            for (String str2 : split) {
                if (host.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public boolean needForceVkeyOutDate() {
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void notifyVideoStart() {
        EventCenter.getInstance().post("Personalize", 13, (Object[]) null);
        QZoneVideoLoader.l().w(true);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void openBrowser(String str, int i3, Bundle bundle, String str2) {
        Activity topActivity = BaseActivity.getTopActivity();
        if (topActivity == null) {
            return;
        }
        if (bundle != null && bundle.getBoolean("_ext_launch_activity_when_finish")) {
            if (topActivity instanceof BasePluginActivity) {
                QZoneHelper.forwardToQzoneBrowser(((BasePluginActivity) topActivity).getOutActivity(), QZoneHelper.UserInfo.getInstance(), str, i3, bundle, str2);
                return;
            } else {
                QZoneHelper.forwardToQzoneBrowser(topActivity, QZoneHelper.UserInfo.getInstance(), str, i3, bundle, str2);
                return;
            }
        }
        if (bundle != null && bundle.getBoolean("needTranslucentBrowser")) {
            if (topActivity instanceof BasePluginActivity) {
                QZoneHelper.startTranslucentBrowserActivityForResult(((BasePluginActivity) topActivity).getOutActivity(), str, i3, bundle, str2);
                return;
            } else {
                QZoneHelper.startTranslucentBrowserActivityForResult(topActivity, str, i3, bundle, str2);
                return;
            }
        }
        if (topActivity instanceof BasePluginActivity) {
            QZoneHelper.forwardToBrowser(((BasePluginActivity) topActivity).getOutActivity(), str, i3, bundle, str2);
        } else {
            QZoneHelper.forwardToBrowser(topActivity, str, i3, bundle, str2);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void reportCanvasVideoPlay(String str, int i3, int i16, boolean z16, boolean z17, boolean z18, int i17, Map<Integer, String> map, int i18) {
        com.qzone.adapter.feedcomponent.i.H().V1(str, i3, i16, z16, z17, z18, i17, map, i18);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void reportClick(String str, String str2, String str3) {
        com.qzone.adapter.feedcomponent.i.H().W1(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void reportTcDownloadProxySuccessRate(boolean z16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("what", String.valueOf(!z16 ? 1 : 0));
        BaseApplicationImpl.getApplication();
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), "tc_downlaod_proxy_success_rate", z16, 0L, 0L, hashMap, null);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void reportTcSDK(String str) {
        QZoneVideoReportService.l().n(str);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void reportToLp00064(int i3, int i16, int i17) {
        LpReportInfo_pf00064.allReport(i3, i16, i17);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void reportVideoPlay(int i3, boolean z16, boolean z17, boolean z18, int i16, Map<Integer, String> map, int i17, int i18) {
        com.qzone.adapter.feedcomponent.i.H().n2(i3, z16, z17, z18, i16, map, i17, i18);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void reportVideoSuccessRate(boolean z16, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("video_url");
            int i3 = jSONObject.getInt("what");
            int i16 = jSONObject.getInt("extra");
            com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
            BaseApplicationImpl.getApplication();
            H.o2(BaseApplication.getContext(), z16, string, null, i3, i16, 0, 0);
        } catch (JSONException e16) {
            QZLog.w("FeedVideoExternalFuncImpl", "fail parsing video success rate report detail", e16);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void sendEvent(int i3) {
        EventCenter.getInstance().post("WriteOperation", i3, (Object[]) null);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void showDebugDialog(Context context, String str) {
        if (BaseActivity.getTopActivity() != null) {
            QZoneFeedUtil.h0(BaseActivity.getTopActivity(), str, isDebugVersion());
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void showPlayTips(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i3) {
        Activity topActivity = BaseActivity.getTopActivity();
        if (topActivity == null) {
            return;
        }
        if (i3 == 0) {
            try {
                String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTrafficTips", "\u6d41\u91cf\u63d0\u793a");
                String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogLeaveWifiToPlaying", "\u4f60\u5df2\u7ecf\u79bb\u5f00WiFi\uff0c\u7ee7\u7eed\u64ad\u653e\u89c6\u9891\u5417\uff1f");
                DialogUtil.createCustomDialog(topActivity, 230, config, config2 + "\n", QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogStop", "\u6682\u505c"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogPlaying", "\u64ad\u653e"), onClickListener, onClickListener2).show();
                return;
            } catch (Throwable th5) {
                QZLog.w(th5);
                return;
            }
        }
        if (i3 != 1 || f433438a) {
            return;
        }
        try {
            String config3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTrafficTips", "\u6d41\u91cf\u63d0\u793a");
            String config4 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTrafficMessage", "\u4f60\u6b63\u5904\u4e8e\u975eWiFi\u73af\u5883\uff0c\u7ee7\u7eed\u64ad\u653e\u5c06\u4f1a\u6d88\u8017\u6d41\u91cf\uff0c\u8fd0\u8425\u5546\u53ef\u80fd\u4f1a\u6536\u53d6\u8d39\u7528\uff0c\u662f\u5426\u7ee7\u7eed");
            DialogUtil.createCustomDialog(topActivity, 230, config3, config4 + "\n", QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTrafficContinue", "\u7ee7\u7eed"), com.qzone.util.l.a(R.string.j6l), onClickListener2, onClickListener).show();
        } catch (Throwable th6) {
            QZLog.w(th6);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void showToast(String str) {
        ToastUtil.r(str);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public String getWnsConfig(String str, String str2, String str3) {
        return QzoneConfig.getInstance().getConfig(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void reportClick(String str, String str2, String str3, boolean z16) {
        com.qzone.adapter.feedcomponent.i.H().Y1(str, str2, str3, z16);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void reportVideoPlay(int i3, int i16, boolean z16, boolean z17, boolean z18, int i17, Map<Integer, String> map, int i18, int i19) {
        com.qzone.adapter.feedcomponent.i.H().m2(i3, i16, z16, z17, z18, i17, map, i18, i19);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void reportMTA(FeedVideoEnv.MtaReportConfig mtaReportConfig, HashMap<String, Object> hashMap) {
        String str;
        if (mtaReportConfig.equals(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_BUFFER_OCCURE_TIMES)) {
            return;
        }
        if (mtaReportConfig.equals(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_PLAY_H265_VIDEO)) {
            int i3 = 0;
            if (hashMap != null) {
                try {
                    Object obj = hashMap.get("video_play_ret");
                    r7 = obj instanceof Long ? ((Long) obj).longValue() : 0L;
                    Object obj2 = hashMap.get("video_first_buffer_time_cost");
                    r9 = obj2 instanceof Long ? ((Long) obj2).longValue() : -1L;
                    Object obj3 = hashMap.get("video_play_pgc");
                    if (obj3 instanceof Integer) {
                        i3 = ((Integer) obj3).intValue();
                    }
                } catch (Exception unused) {
                    QZLog.e("FeedVideoExternalFuncImpl", "beacon report data error");
                    return;
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("param_FailCode", String.valueOf(r7));
            hashMap2.put("reserve", String.valueOf(r9));
            hashMap2.put("ispgcvideo", String.valueOf(i3));
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_PLAY_H265_VIDEO, (HashMap<String, String>) hashMap2);
            return;
        }
        if (mtaReportConfig.equals(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_PLAYER_TYPE)) {
            Object obj4 = hashMap.get("video_player_type");
            Object obj5 = hashMap.get("video_decoder_name");
            Object obj6 = hashMap.get("video_first_buffer_time_cost");
            if (obj4 instanceof Integer) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("player_type", String.valueOf(obj4));
                hashMap3.put("reserve", "0");
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_PLAY_PLAYER_TYPE, (HashMap<String, String>) hashMap3);
                HashMap hashMap4 = new HashMap();
                if (obj5 == null || !(obj5 instanceof String) || TextUtils.isEmpty((String) obj5)) {
                    return;
                }
                hashMap3.put(TVKDeviceDecodeCapabilityReportConstant.DECODING_CAPABILITY_PARAM_DECODER_NAME, String.valueOf(obj5));
                hashMap3.put("buffered_time", String.valueOf(obj6));
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_PLAY_HARDWARE_DECODER_NAME, (HashMap<String, String>) hashMap4);
                return;
            }
            return;
        }
        if (mtaReportConfig.equals(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_INTERNAL_ERROR)) {
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_PLAY_PROXY_INTERNAL_ERROR_V2, (HashMap<String, String>) new HashMap());
            HashMap hashMap5 = new HashMap();
            hashMap5.put("uin", LoginData.getInstance().getUinString());
            if (hashMap.get("detailMessage") != null) {
                hashMap5.put("detail", hashMap.get("detailMessage"));
            }
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_PLAY_PROXY_INTERNAL_ERROR_V2, true, 0L, 0L, hashMap5, null);
            return;
        }
        if (!mtaReportConfig.equals(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_VIDEO_ACTIVITY)) {
            if (mtaReportConfig.equals(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_PRELOAD)) {
                if (hashMap != null) {
                    HashMap<String, String> hashMap6 = new HashMap<>();
                    Object obj7 = hashMap.get(WebBundleConstants.WEBBUNDLE_PRELOAD_URL);
                    Object obj8 = hashMap.get("status");
                    Object obj9 = hashMap.get("error_code");
                    if (obj7 != null) {
                        hashMap6.put(WebBundleConstants.WEBBUNDLE_PRELOAD_URL, String.valueOf(obj7));
                    }
                    if (obj8 != null) {
                        hashMap6.put("status", String.valueOf(obj8));
                    }
                    if (obj9 != null) {
                        hashMap6.put("error_code", String.valueOf(obj9));
                    }
                    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_PLAY_ACTIVITY_VERTICAL_PRELOAD, true, 0L, 0L, hashMap6, null);
                    return;
                }
                return;
            }
            if (mtaReportConfig.equals(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_VIDEO_RESOLUTION)) {
                if (hashMap != null) {
                    HashMap<String, String> hashMap7 = new HashMap<>();
                    Object obj10 = hashMap.get("declared_resolution");
                    if (obj10 != null) {
                        hashMap7.put("declared_resolution", String.valueOf(obj10));
                        hashMap7.put("all", "1");
                        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_QZ_PLAY_STREAM_RESOLUTION, true, 0L, 0L, hashMap7, null);
                        return;
                    }
                    return;
                }
                return;
            }
            if (!mtaReportConfig.equals(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_H265_DEC_STATS) || hashMap == null) {
                return;
            }
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_QZ_PLAY_H265_CHOOSE_STREAM, true, 0L, 0L, null, null);
            Object obj11 = hashMap.get("video_profile");
            Object obj12 = hashMap.get("video_dec_status");
            if (obj11 == null || obj12 == null) {
                return;
            }
            HashMap<String, String> hashMap8 = new HashMap<>();
            hashMap8.put("video_profile", String.valueOf(obj11));
            hashMap8.put("video_dec_status", String.valueOf(obj12));
            hashMap8.put("all", "1");
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_QZ_PLAY_H265_DEC_STATUS, true, 0L, 0L, hashMap8, null);
            return;
        }
        if (hashMap == null) {
            return;
        }
        Object obj13 = hashMap.get("video_player_refer");
        Object obj14 = hashMap.get("video_first_buffer_time_cost");
        Object obj15 = hashMap.get("video_buffering_count");
        Object obj16 = hashMap.get("video_player_type");
        Object obj17 = hashMap.get("video_play_ret");
        if (obj13 == null) {
            str = "";
        } else {
            try {
                str = (String) obj13;
            } catch (Exception e16) {
                QZLog.e("FeedVideoExternalFuncImpl", "MTA_REPORT_KEY_VIDEO_ACTIVITY report data error " + e16);
                return;
            }
        }
        int b16 = obj14 != null ? b(((Long) obj14).longValue()) : -1;
        int intValue = obj15 != null ? ((Integer) obj15).intValue() : -1;
        int intValue2 = obj16 != null ? ((Integer) obj16).intValue() : -1;
        int b17 = obj17 != null ? b(((Long) obj17).longValue()) : -1;
        if (!TextUtils.isEmpty(str) && b16 != -1 && intValue != -1 && b17 != -1 && intValue2 != -1) {
            HashMap hashMap9 = new HashMap();
            hashMap9.put("uin", LoginData.getInstance().getUinString());
            hashMap9.put("video_first_buffer_time_cost", b16 + "");
            hashMap9.put("video_buffering_count", intValue + "");
            hashMap9.put("video_player_type", intValue2 + "");
            hashMap9.put("video_play_ret", b17 + "");
            return;
        }
        QZLog.e("FeedVideoExternalFuncImpl", "MTA_REPORT_KEY_VIDEO_ACTIVITY illegal data ," + str + "," + b16 + "," + intValue2 + "," + b17 + "," + intValue);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void injectExtraParam(ISuperPlayer iSuperPlayer, SuperPlayerVideoInfo superPlayerVideoInfo, SuperPlayerOption superPlayerOption) {
        if (iSuperPlayer != null && superPlayerVideoInfo != null && superPlayerOption != null) {
            com.qzone.commoncode.module.gdt.c.g().i(iSuperPlayer, superPlayerVideoInfo, superPlayerOption);
        } else {
            QZLog.e("FeedVideoExternalFuncImpl", "injectExtraParam error");
        }
    }

    private static int b(long j3) {
        if (j3 >= WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && j3 <= TTL.MAX_VALUE) {
            return (int) j3;
        }
        throw new IllegalArgumentException(j3 + " cannot be cast to int without changing its value.");
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void gotoVideoSetting(Context context) {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void hidePlayTips() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void hideWindowPlay() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void reportFeedOpenShortVideoSoundClick() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void playWith(Context context, VideoPlayInfo videoPlayInfo, String str, VideoPlaybackReportInfo videoPlaybackReportInfo) {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv.FeedVideoExternalFunc
    public void reportOnWifiPlay(long j3, long j16, String str, boolean z16) {
    }
}
