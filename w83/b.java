package w83;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qcircle.cooperation.config.debug.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b/\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bg\u0010hJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\fH\u0016R\u0014\u0010\u0014\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001e\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010!\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010#\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001dR\u0011\u0010'\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010)\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010&R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0*8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0011\u0010/\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b.\u0010\u001dR\u0011\u00101\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b0\u0010\u001dR\u0011\u00103\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b2\u0010&R\u0011\u00105\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b4\u0010&R\u0011\u00107\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b6\u0010&R\u0011\u00109\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b8\u0010&R\u0011\u0010=\u001a\u00020:8F\u00a2\u0006\u0006\u001a\u0004\b;\u0010<R\u0011\u0010?\u001a\u00020:8F\u00a2\u0006\u0006\u001a\u0004\b>\u0010<R\u0011\u0010A\u001a\u00020:8F\u00a2\u0006\u0006\u001a\u0004\b@\u0010<R\u0011\u0010C\u001a\u00020:8F\u00a2\u0006\u0006\u001a\u0004\bB\u0010<R\u0011\u0010E\u001a\u00020:8F\u00a2\u0006\u0006\u001a\u0004\bD\u0010<R\u0011\u0010G\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\bF\u0010&R\u0011\u0010I\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010&R\u0011\u0010K\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\bJ\u0010&R\u0011\u0010M\u001a\u00020:8F\u00a2\u0006\u0006\u001a\u0004\bL\u0010<R\u0011\u0010O\u001a\u00020:8F\u00a2\u0006\u0006\u001a\u0004\bN\u0010<R\u0011\u0010Q\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bP\u0010\u001dR\u0011\u0010R\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010&R\u0011\u0010T\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bS\u0010\u001dR\u0019\u0010U\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010*8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010,R\u0011\u0010V\u001a\u00020:8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010<R\u0011\u0010X\u001a\u00020:8F\u00a2\u0006\u0006\u001a\u0004\bW\u0010<R\u0011\u0010Z\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bY\u0010\u001dR\u0011\u0010\\\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b[\u0010\u001dR\u0013\u0010^\u001a\u0004\u0018\u00010\u000e8F\u00a2\u0006\u0006\u001a\u0004\b]\u0010 R\u0013\u0010`\u001a\u0004\u0018\u00010\u000e8F\u00a2\u0006\u0006\u001a\u0004\b_\u0010 R\u0011\u0010b\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\ba\u0010\u001dR\u0011\u0010d\u001a\u00020:8F\u00a2\u0006\u0006\u001a\u0004\bc\u0010<R\u0011\u0010f\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\be\u0010 \u00a8\u0006i"}, d2 = {"Lw83/b;", "", "", "J", "T", "Lw83/a;", ExifInterface.LATITUDE_SOUTH, "L", "K", "M", "N", "I", "", BdhLogUtil.LogTag.Tag_Req, "", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "f", "a", "b", "Ljava/lang/String;", "TAG", "c", "Lw83/a;", "funConfig", "Lcom/tencent/mobileqq/qcircle/api/IQCircle571ABTestApi;", "d", "Lcom/tencent/mobileqq/qcircle/api/IQCircle571ABTestApi;", "tab571Api", "O", "()Z", "isMemoryAlbumOpen", "v", "()Ljava/lang/String;", "newMemoryAlbumExpName", "P", "isNewAlbumOpen", "", ReportConstant.COSTREPORT_PREFIX, "()I", "minNewAlbumOSVersion", "r", "minNewAlbumCPUCoreCount", "", "l", "()Ljava/util/List;", "machineBlackList", "H", "isAlbumMasterSwitchOpen", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isUIMasterSwitchOpen", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "scanUpdateDBStep", HippyTKDListViewAdapter.X, "scanBatchSize", "u", "modelLoadRetryTimes", "t", "modelInputImageSize", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()D", "minImageShortSide", DomainData.DOMAIN_NAME, "maxImageLongSide", "p", "minAspectRatio", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "maxAspectRatio", "i", "collectorDropoutDisplayedRate", h.F, "collectorDayCount", "j", "collectorLoopCount", "k", "collectorSameStoryMinInterval", "w", "photoSimilarityThreshould", "o", "maxTextSimilarityThreshould", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "shouldClearStoryDBTableAfterCollector", "albumDisplayedTimeInterval", "y", "scanFilterVideo", "aestheticParams", "aestheticThreshold", "e", "albumRepeatFilterRatio", "B", "shouldUseLocationAlbum", BdhLogUtil.LogTag.Tag_Conn, "shouldUseTimeAlbum", "D", "solarFestivals", "g", "chineseFestivals", "G", "useNewImageScale", "E", "sortTimeWeight", UserInfo.SEX_FEMALE, "storyDDmobanIds", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f445025a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static volatile WinkAlbumFuncConfig funConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IQCircle571ABTestApi tab571Api;

    static {
        b bVar = new b();
        f445025a = bVar;
        TAG = "WinkNewAlbum_WinkAlbumFuncConfigManager";
        QLog.d("WinkNewAlbum_WinkAlbumFuncConfigManager", 1, "init ");
        funConfig = bVar.S();
        QRouteApi api = QRoute.api(IQCircle571ABTestApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQCircle571ABTestApi::class.java)");
        tab571Api = (IQCircle571ABTestApi) api;
    }

    b() {
    }

    private final boolean J() {
        return false;
    }

    public final boolean A() {
        return funConfig.getShouldClearStoryDBTableAfterCollector();
    }

    public final boolean B() {
        if (funConfig.getShouldUseLocationAlbum() && I()) {
            return true;
        }
        return false;
    }

    public final boolean C() {
        if (funConfig.getShouldUseTimeAlbum() && I()) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String D() {
        return funConfig.getSolarFestivals();
    }

    public final double E() {
        return funConfig.getSortTimeWeight();
    }

    @NotNull
    public final String F() {
        return funConfig.getStoryDDmobanIds();
    }

    public final boolean G() {
        if (funConfig.getNewImageScale() && I() && c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_WINK_NEWALBUM_SCALE, 1)) {
            return true;
        }
        return false;
    }

    public final boolean H() {
        boolean G = funConfig.G();
        QLog.d(TAG, 1, "isAlbumMasterSwitchOpen, ret:" + G);
        return G;
    }

    public final boolean I() {
        return M();
    }

    public final boolean K() {
        return true;
    }

    public final boolean L() {
        if (!J() && !K()) {
            return false;
        }
        return true;
    }

    public final boolean M() {
        return N();
    }

    public final boolean N() {
        IQCircle571ABTestApi iQCircle571ABTestApi = tab571Api;
        boolean isExperiment = iQCircle571ABTestApi.isExperiment("exp_xsj_memoryalbum_3");
        String str = TAG;
        QLog.d(str, 4, "isHitPreviewExp, ret:" + isExperiment);
        QLog.d(str, 4, "isHitPreviewExp, :" + iQCircle571ABTestApi.getAssignment("exp_xsj_memoryalbum_3"));
        return isExperiment;
    }

    public final boolean O() {
        boolean isMemoryAlbumOpen = funConfig.getIsMemoryAlbumOpen();
        QLog.d(TAG, 1, "isMemoryAlbumOpen, ret:" + isMemoryAlbumOpen);
        return isMemoryAlbumOpen;
    }

    public final boolean P() {
        boolean isNewAlbumOpen = funConfig.getIsNewAlbumOpen();
        QLog.d(TAG, 1, "isNewAlbumOpen, ret:" + isNewAlbumOpen);
        return isNewAlbumOpen;
    }

    public final boolean Q() {
        boolean K = funConfig.K();
        QLog.d(TAG, 1, "isUIMasterSwitchOpen, ret:" + K);
        return K;
    }

    public final void R() {
        IQCircle571ABTestApi iQCircle571ABTestApi = tab571Api;
        iQCircle571ABTestApi.reportExperimentExport("exp_xsj_memoryalbum_3");
        Unit unit = Unit.INSTANCE;
        QLog.d(TAG, 4, "exp_xsj_preview_memoryalbum expose, " + iQCircle571ABTestApi.getAssignment("exp_xsj_memoryalbum_3"));
    }

    @NotNull
    public final WinkAlbumFuncConfig S() {
        WinkAlbumFuncConfig a16 = WinkAlbumFuncConfig.INSTANCE.a();
        QLog.d(TAG, 1, "retrieveConfig, ret:" + a16);
        return a16;
    }

    public boolean T() {
        QLog.d(TAG, 1, "startProcess ");
        funConfig = S();
        return true;
    }

    @Nullable
    public final List<String> b() {
        return funConfig.b();
    }

    public final double c() {
        return funConfig.getAestheticThreshold();
    }

    public final int d() {
        return funConfig.getAlbumDisplayedTimeInterval();
    }

    public final double e() {
        return funConfig.getAlbumRepeatFilterRatio();
    }

    @Nullable
    public final String f(@NotNull String expName) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        return tab571Api.getAssignment(expName);
    }

    @Nullable
    public final String g() {
        return funConfig.getChineseFestivals();
    }

    public final int h() {
        return funConfig.getCollectorDayCount();
    }

    public final double i() {
        return funConfig.getDropoutDisplayedRate();
    }

    public final int j() {
        return funConfig.getCollectorLoopCount();
    }

    public final int k() {
        return funConfig.getCollectorSameStoryMinInterval();
    }

    @NotNull
    public final List<String> l() {
        return funConfig.k();
    }

    public final double m() {
        return funConfig.getMaxAspectRatio();
    }

    public final double n() {
        return funConfig.getMaxImageLongSide();
    }

    public final double o() {
        return funConfig.getMaxTextSimilarityThreshould();
    }

    public final double p() {
        return funConfig.getMinAspectRatio();
    }

    public final double q() {
        return funConfig.getMinImageShortSide();
    }

    public final int r() {
        return funConfig.getMinNewAlbumCPUCoreCount();
    }

    public final int s() {
        return funConfig.getMinNewAlbumOSVersion();
    }

    public final int t() {
        return funConfig.getModelInputImageSize();
    }

    public final int u() {
        return funConfig.getModelLoadRetryTimes();
    }

    @NotNull
    public final String v() {
        String newMemoryAlbumExpName = funConfig.getNewMemoryAlbumExpName();
        QLog.d(TAG, 1, "newMemoryAlbumExpName, ret: " + newMemoryAlbumExpName);
        return newMemoryAlbumExpName;
    }

    public final double w() {
        return funConfig.getPhotoSimilarityThreshould();
    }

    public final int x() {
        return funConfig.getScanBatchSize();
    }

    public final boolean y() {
        return funConfig.getScanFilterVideo();
    }

    public final int z() {
        return funConfig.getScanUpdateDBStep();
    }

    public void a() {
    }
}
