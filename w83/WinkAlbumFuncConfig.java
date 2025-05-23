package w83;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.process.config.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\b%\n\u0002\u0010\u0006\n\u0002\b@\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\nB\u00ef\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f\u0012\b\b\u0002\u0010-\u001a\u00020\u0005\u0012\b\b\u0002\u00101\u001a\u00020\u0003\u0012\b\b\u0002\u00105\u001a\u00020\u0003\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\b\b\u0002\u0010=\u001a\u00020\u0003\u0012\b\b\u0002\u0010@\u001a\u00020\u0003\u0012\b\b\u0002\u0010D\u001a\u00020\u0002\u0012\b\b\u0002\u0010L\u001a\u00020E\u0012\b\b\u0002\u0010O\u001a\u00020E\u0012\b\b\u0002\u0010Q\u001a\u00020E\u0012\b\b\u0002\u0010S\u001a\u00020E\u0012\b\b\u0002\u0010U\u001a\u00020E\u0012\b\b\u0002\u0010W\u001a\u00020\u0003\u0012\b\b\u0002\u0010Y\u001a\u00020\u0003\u0012\b\b\u0002\u0010[\u001a\u00020\u0003\u0012\b\b\u0002\u0010_\u001a\u00020\u0002\u0012\b\b\u0002\u0010b\u001a\u00020E\u0012\b\b\u0002\u0010d\u001a\u00020E\u0012\b\b\u0002\u0010f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001f\u0012\b\b\u0002\u0010j\u001a\u00020E\u0012\b\b\u0002\u0010l\u001a\u00020E\u0012\b\b\u0002\u0010o\u001a\u00020\u0002\u0012\b\b\u0002\u0010r\u001a\u00020\u0002\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010z\u001a\u00020\u0002\u0012\b\b\u0002\u0010}\u001a\u00020E\u0012\b\b\u0002\u0010\u007f\u001a\u00020\u0005\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010-\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00101\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0012\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019R\"\u00105\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0012\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u000b\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR\"\u0010=\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0012\u001a\u0004\b;\u0010\u0017\"\u0004\b<\u0010\u0019R\"\u0010@\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0012\u001a\u0004\b>\u0010\u0017\"\u0004\b?\u0010\u0019R\"\u0010D\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR\"\u0010L\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010O\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010G\u001a\u0004\bF\u0010I\"\u0004\bN\u0010KR\"\u0010Q\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010G\u001a\u0004\bP\u0010I\"\u0004\b\u000b\u0010KR\"\u0010S\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010G\u001a\u0004\bA\u0010I\"\u0004\bR\u0010KR\"\u0010U\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010G\u001a\u0004\b:\u0010I\"\u0004\bT\u0010KR\"\u0010W\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b.\u0010\u0017\"\u0004\bV\u0010\u0019R\"\u0010Y\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0012\u001a\u0004\b2\u0010\u0017\"\u0004\bX\u0010\u0019R\"\u0010[\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0012\u001a\u0004\b6\u0010\u0017\"\u0004\bZ\u0010\u0019R\"\u0010_\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010\u000b\u001a\u0004\b]\u0010\r\"\u0004\b^\u0010\u000fR\"\u0010b\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010G\u001a\u0004\b`\u0010I\"\u0004\ba\u0010KR\"\u0010d\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010G\u001a\u0004\bM\u0010I\"\u0004\bc\u0010KR\"\u0010f\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0012\u001a\u0004\b\u001b\u0010\u0017\"\u0004\be\u0010\u0019R*\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010!\u001a\u0004\b\u0011\u0010#\"\u0004\bg\u0010%R\"\u0010j\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010G\u001a\u0004\b\u0015\u0010I\"\u0004\bi\u0010KR\"\u0010l\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010G\u001a\u0004\b \u0010I\"\u0004\bk\u0010KR\"\u0010o\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010\u000b\u001a\u0004\bm\u0010\r\"\u0004\bn\u0010\u000fR\"\u0010r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010\u000b\u001a\u0004\bp\u0010\r\"\u0004\bq\u0010\u000fR$\u0010t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010(\u001a\u0004\bG\u0010*\"\u0004\bs\u0010,R$\u0010w\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010(\u001a\u0004\b'\u0010*\"\u0004\bv\u0010,R\"\u0010z\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010\u000b\u001a\u0004\b\\\u0010\r\"\u0004\by\u0010\u000fR\"\u0010}\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b{\u0010G\u001a\u0004\bu\u0010I\"\u0004\b|\u0010KR\"\u0010\u007f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010(\u001a\u0004\bx\u0010*\"\u0004\b~\u0010,R\u0012\u0010\u0080\u0001\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b{\u0010\rR\u0013\u0010\u0082\u0001\u001a\u00020\u00028F\u00a2\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010\r\u00a8\u0006\u0085\u0001"}, d2 = {"Lw83/a;", "", "", "", "t0", "", "toString", "hashCode", "other", "equals", "a", "Z", "H", "()Z", "Y", "(Z)V", "isMemoryAlbumOpen", "b", "I", "f0", "isNewAlbumOpen", "c", "r", "()I", "c0", "(I)V", "minNewAlbumOSVersion", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b0", "minNewAlbumCPUCoreCount", "", "e", "Ljava/util/List;", "k", "()Ljava/util/List;", "U", "(Ljava/util/List;)V", "machineBlackList", "f", "Ljava/lang/String;", "v", "()Ljava/lang/String;", "h0", "(Ljava/lang/String;)V", "newMemoryAlbumExpName", "g", "t", "e0", "modelLoadRetryTimes", h.F, ReportConstant.COSTREPORT_PREFIX, "d0", "modelInputImageSize", "i", "J", "p0", "isShowOldTemplateLibAlbumEntrance", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "l0", "scanUpdateDBStep", HippyTKDListViewAdapter.X, "j0", "scanBatchSize", "l", "y", "k0", "scanFilterVideo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "D", "p", "()D", "a0", "(D)V", "minImageShortSide", DomainData.DOMAIN_NAME, "W", "maxImageLongSide", "o", "minAspectRatio", "V", "maxAspectRatio", "T", "dropoutDisplayedRate", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "collectorDayCount", BdhLogUtil.LogTag.Tag_Req, "collectorLoopCount", ExifInterface.LATITUDE_SOUTH, "collectorSameStoryMinInterval", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "m0", "shouldClearStoryDBTableAfterCollector", "w", "i0", "photoSimilarityThreshould", "X", "maxTextSimilarityThreshould", "N", "albumDisplayedTimeInterval", "L", "aestheticParams", "M", "aestheticThreshold", "O", "albumRepeatFilterRatio", "B", "n0", "shouldUseLocationAlbum", BdhLogUtil.LogTag.Tag_Conn, "o0", "shouldUseTimeAlbum", "q0", "solarFestivals", "E", "P", "chineseFestivals", UserInfo.SEX_FEMALE, "g0", "newImageScale", "G", "r0", "sortTimeWeight", "s0", "storyDDmobanIds", "isAlbumMasterSwitchOpen", "K", "isUIMasterSwitchOpen", "<init>", "(ZZIILjava/util/List;Ljava/lang/String;IIZIIZDDDDDIIIZDDILjava/util/List;DDZZLjava/lang/String;Ljava/lang/String;ZDLjava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: w83.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkAlbumFuncConfig {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata and from toString */
    private double albumRepeatFilterRatio;

    /* renamed from: B, reason: from kotlin metadata and from toString */
    private boolean shouldUseLocationAlbum;

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private boolean shouldUseTimeAlbum;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @Nullable
    private String solarFestivals;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @Nullable
    private String chineseFestivals;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private boolean newImageScale;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private double sortTimeWeight;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private String storyDDmobanIds;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isMemoryAlbumOpen;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isNewAlbumOpen;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int minNewAlbumOSVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int minNewAlbumCPUCoreCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<String> machineBlackList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String newMemoryAlbumExpName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int modelLoadRetryTimes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int modelInputImageSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isShowOldTemplateLibAlbumEntrance;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int scanUpdateDBStep;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private int scanBatchSize;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean scanFilterVideo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private double minImageShortSide;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private double maxImageLongSide;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private double minAspectRatio;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private double maxAspectRatio;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private double dropoutDisplayedRate;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private int collectorDayCount;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private int collectorLoopCount;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private int collectorSameStoryMinInterval;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean shouldClearStoryDBTableAfterCollector;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    private double photoSimilarityThreshould;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata and from toString */
    private double maxTextSimilarityThreshould;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata and from toString */
    private int albumDisplayedTimeInterval;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private List<String> aestheticParams;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata and from toString */
    private double aestheticThreshold;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0014\u0010\u0013\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0014\u0010\u0015\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\tR\u0014\u0010\u0017\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\tR\u0014\u0010\u0018\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\tR\u0014\u0010\u0019\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\tR\u0014\u0010\u001a\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\tR\u0014\u0010\u001b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\tR\u0014\u0010\u001c\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\tR\u0014\u0010\u001d\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\tR\u0014\u0010\u001e\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\tR\u0014\u0010\u001f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\tR\u0014\u0010 \u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\tR\u0014\u0010!\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\tR\u0014\u0010\"\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\tR\u0014\u0010#\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\tR\u0014\u0010$\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\tR\u0014\u0010%\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\tR\u0014\u0010&\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\tR\u0014\u0010'\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010\tR\u0014\u0010(\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010\tR\u0014\u0010)\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010\tR\u0014\u0010+\u001a\u00020*8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020*8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010.\u001a\u00020*8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0014\u0010/\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u0010\t\u00a8\u00062"}, d2 = {"Lw83/a$a;", "", "Lorg/json/JSONObject;", "jsonObject", "Lw83/a;", "b", "a", "", "KEY_AESTHETIC_PARAMS", "Ljava/lang/String;", "KEY_AESTHETIC_THRESHOLD", "KEY_ALBUM_DISPLAY_TIME_INTERVAL", "KEY_ALBUM_FUNC_CONFIG", "KEY_ALBUM_REPEAT_FILTER_RATIO", "KEY_ALBUM_TAB_EXP_NAME", "KEY_CHINESE_FESTIVALS", "KEY_COLLECTOR_DAY_COUNT", "KEY_COLLECTOR_DROPOUT_DISPLAYED_PHOTO_RATE", "KEY_COLLECTOR_EACH_LOOP", "KEY_COLLECTOR_SAME_STORY_MIN_INTERVAL", "KEY_ENABLE_NEW_MEMORY_ALBUM_CPU_MINI_CORE_COUNT", "KEY_ENABLE_NEW_MEMORY_ALBUM_MACHINE_LIST", "KEY_ENABLE_NEW_MEMORY_ALBUM_OS_MINI_VERSION", "KEY_MAX_TEXT_SIMILARITY_THRESHOULD", "KEY_MODEL_INPUT_IMAGE_SIZE", "KEY_MODEL_RETRY_TIMES", "KEY_NEW_IMAGE_SCALE", "KEY_PHOTO_REPEAT_THRESHOULD", "KEY_SCAN_METADATA_BATCH_SIZE", "KEY_SCAN_METADATA_UPDATE_DATABASE_STEP", "KEY_SHIFT_IMAGE_CONFIG", "KEY_SHOULD_CLEAR_STORY_DATABSE_TABEL", "KEY_SHOULD_FILTER_VIDEO_ASSET", "KEY_SHOULD_MEMORY_ALBUM_IN_OLD_TEMPLATE_OPEN", "KEY_SHOULD_NEW_MEMORY_ALBUM_OPEN", "KEY_SHOULD_OLD_MEMORY_ALBUM_OPEN", "KEY_SHOULD_USE_LOCATION_ALBUM", "KEY_SHOULD_USE_TIME_ALBUM", "KEY_SOLAR_FESTIVALS", "KEY_SORT_TIME_WEIGHT", "KEY_STORY_DD_MOBAN_IDS", "SHIFT_IMAGE_CONFIG", "", "SHIFT_IMAGE_CONFIG_NUM", "I", "SWITCH_CLOSE", "SWITCH_ON", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: w83.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final WinkAlbumFuncConfig b(JSONObject jsonObject) {
            boolean z16;
            boolean z17;
            boolean z18;
            List split$default;
            int collectionSizeOrDefault;
            boolean z19;
            boolean z26;
            boolean z27;
            boolean z28;
            int lastIndex;
            Object valueOf;
            int lastIndex2;
            Object valueOf2;
            int lastIndex3;
            Object valueOf3;
            int lastIndex4;
            Object valueOf4;
            WinkAlbumFuncConfig winkAlbumFuncConfig = new WinkAlbumFuncConfig(false, false, 0, 0, null, null, 0, 0, false, 0, 0, false, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, 0, 0, false, 0.0d, 0.0d, 0, null, 0.0d, 0.0d, false, false, null, null, false, 0.0d, null, -1, 3, null);
            boolean z29 = false;
            if (jsonObject.optInt("should_use_old_memory_album", winkAlbumFuncConfig.t0(winkAlbumFuncConfig.getIsMemoryAlbumOpen())) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            winkAlbumFuncConfig.Y(z16);
            String optString = jsonObject.optString("album_tab_exp_key", winkAlbumFuncConfig.getNewMemoryAlbumExpName());
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(KEY\u2026E, newMemoryAlbumExpName)");
            winkAlbumFuncConfig.h0(optString);
            if (jsonObject.optInt("switch_on_feature", winkAlbumFuncConfig.t0(winkAlbumFuncConfig.getIsNewAlbumOpen())) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            winkAlbumFuncConfig.f0(z17);
            winkAlbumFuncConfig.c0(jsonObject.optInt("enable_new_album_os_mini_version", winkAlbumFuncConfig.getMinNewAlbumOSVersion()));
            winkAlbumFuncConfig.b0(jsonObject.optInt("enable_new_album_cpu_mini_core_count", winkAlbumFuncConfig.getMinNewAlbumCPUCoreCount()));
            winkAlbumFuncConfig.U(g.a(jsonObject, "disable_new_album_machine_list"));
            winkAlbumFuncConfig.l0(jsonObject.optInt("scan_metadata_update_db_step", winkAlbumFuncConfig.getScanUpdateDBStep()));
            winkAlbumFuncConfig.j0(jsonObject.optInt("scan_metadata_batch_size", winkAlbumFuncConfig.getScanBatchSize()));
            winkAlbumFuncConfig.e0(jsonObject.optInt("model_load_retry_times", winkAlbumFuncConfig.getModelLoadRetryTimes()));
            winkAlbumFuncConfig.d0(jsonObject.optInt("model_input_img_size", winkAlbumFuncConfig.getModelInputImageSize()));
            if (jsonObject.optInt("should_use_memory_album_in_old_template", winkAlbumFuncConfig.t0(winkAlbumFuncConfig.getIsShowOldTemplateLibAlbumEntrance())) == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            winkAlbumFuncConfig.p0(z18);
            String shiftConfig = jsonObject.optString("skip_config", "500,5000,0.333,3.0");
            Intrinsics.checkNotNullExpressionValue(shiftConfig, "shiftConfig");
            split$default = StringsKt__StringsKt.split$default((CharSequence) shiftConfig, new String[]{","}, false, 0, 6, (Object) null);
            List list = split$default;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Double.valueOf(Double.parseDouble((String) it.next())));
            }
            if (arrayList.size() == 4) {
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                if (lastIndex >= 0) {
                    valueOf = arrayList.get(0);
                } else {
                    valueOf = Double.valueOf(winkAlbumFuncConfig.getMinImageShortSide());
                }
                winkAlbumFuncConfig.a0(((Number) valueOf).doubleValue());
                lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                if (1 <= lastIndex2) {
                    valueOf2 = arrayList.get(1);
                } else {
                    valueOf2 = Double.valueOf(winkAlbumFuncConfig.getMaxImageLongSide());
                }
                winkAlbumFuncConfig.W(((Number) valueOf2).doubleValue());
                lastIndex3 = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                if (2 <= lastIndex3) {
                    valueOf3 = arrayList.get(2);
                } else {
                    valueOf3 = Double.valueOf(winkAlbumFuncConfig.getMinAspectRatio());
                }
                winkAlbumFuncConfig.Z(((Number) valueOf3).doubleValue());
                lastIndex4 = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                if (3 <= lastIndex4) {
                    valueOf4 = arrayList.get(3);
                } else {
                    valueOf4 = Double.valueOf(winkAlbumFuncConfig.getMaxAspectRatio());
                }
                winkAlbumFuncConfig.V(((Number) valueOf4).doubleValue());
            }
            winkAlbumFuncConfig.T(jsonObject.optDouble("dropout_displayed_photo_rate", winkAlbumFuncConfig.getDropoutDisplayedRate()));
            winkAlbumFuncConfig.Q(jsonObject.optInt("day_count", winkAlbumFuncConfig.getCollectorDayCount()));
            winkAlbumFuncConfig.R(jsonObject.optInt("package_count", winkAlbumFuncConfig.getCollectorLoopCount()));
            winkAlbumFuncConfig.S(jsonObject.optInt("memory_same_min_interval", winkAlbumFuncConfig.getCollectorSameStoryMinInterval()));
            if (jsonObject.optInt("should_package_clear_table", winkAlbumFuncConfig.t0(winkAlbumFuncConfig.getShouldClearStoryDBTableAfterCollector())) == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            winkAlbumFuncConfig.m0(z19);
            winkAlbumFuncConfig.i0(jsonObject.optDouble("repeat_threshold", winkAlbumFuncConfig.getPhotoSimilarityThreshould()));
            winkAlbumFuncConfig.X(jsonObject.optDouble("memory_max_similarity", winkAlbumFuncConfig.getMaxTextSimilarityThreshould()));
            winkAlbumFuncConfig.N(jsonObject.optInt("album_displayed_time_interval", winkAlbumFuncConfig.getAlbumDisplayedTimeInterval()));
            if (jsonObject.optInt("should_filter_video_asset", winkAlbumFuncConfig.t0(winkAlbumFuncConfig.getScanFilterVideo())) == 1) {
                z26 = true;
            } else {
                z26 = false;
            }
            winkAlbumFuncConfig.k0(z26);
            winkAlbumFuncConfig.L(g.a(jsonObject, "aesthetic_params"));
            winkAlbumFuncConfig.M(jsonObject.optDouble("aesthetic_threshold", winkAlbumFuncConfig.getAestheticThreshold()));
            winkAlbumFuncConfig.O(jsonObject.optDouble("album_repeat_filter_ratio", winkAlbumFuncConfig.getAlbumRepeatFilterRatio()));
            if (jsonObject.optInt("should_use_location_album", winkAlbumFuncConfig.t0(winkAlbumFuncConfig.getShouldUseLocationAlbum())) == 1) {
                z27 = true;
            } else {
                z27 = false;
            }
            winkAlbumFuncConfig.n0(z27);
            if (jsonObject.optInt("should_use_time_album", winkAlbumFuncConfig.t0(winkAlbumFuncConfig.getShouldUseTimeAlbum())) == 1) {
                z28 = true;
            } else {
                z28 = false;
            }
            winkAlbumFuncConfig.o0(z28);
            winkAlbumFuncConfig.q0(jsonObject.optString("solar_festivals", null));
            winkAlbumFuncConfig.P(jsonObject.optString("chinese_festivals", null));
            if (jsonObject.optInt("new_image_scale", winkAlbumFuncConfig.t0(winkAlbumFuncConfig.getNewImageScale())) == 1) {
                z29 = true;
            }
            winkAlbumFuncConfig.g0(z29);
            winkAlbumFuncConfig.r0(jsonObject.optDouble("sort_time_weight", winkAlbumFuncConfig.getSortTimeWeight()));
            String optString2 = jsonObject.optString("story_dd_moban_ids", winkAlbumFuncConfig.getStoryDDmobanIds());
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(KEY\u2026BAN_IDS, storyDDmobanIds)");
            winkAlbumFuncConfig.s0(optString2);
            return winkAlbumFuncConfig;
        }

        @NotNull
        public final WinkAlbumFuncConfig a() {
            boolean z16;
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102776", "");
            QLog.d("WinkNewAlbum_WinkAlbumFuncConfig", 1, "retrieve, jsonStr:" + loadAsString);
            if (loadAsString.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return new WinkAlbumFuncConfig(false, false, 0, 0, null, null, 0, 0, false, 0, 0, false, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, 0, 0, false, 0.0d, 0.0d, 0, null, 0.0d, 0.0d, false, false, null, null, false, 0.0d, null, -1, 3, null);
            }
            try {
                try {
                    WinkAlbumFuncConfig b16 = b(new JSONObject(loadAsString));
                    QLog.d("WinkNewAlbum_WinkAlbumFuncConfig", 1, "retrieve, ret:" + b16);
                    return b16;
                } catch (Exception e16) {
                    e = e16;
                    QLog.e("WinkNewAlbum_WinkAlbumFuncConfig", 1, "retrieve, error ", e);
                    return new WinkAlbumFuncConfig(false, false, 0, 0, null, null, 0, 0, false, 0, 0, false, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, 0, 0, false, 0.0d, 0.0d, 0, null, 0.0d, 0.0d, false, false, null, null, false, 0.0d, null, -1, 3, null);
                }
            } catch (Exception e17) {
                e = e17;
            }
        }

        Companion() {
        }
    }

    public WinkAlbumFuncConfig() {
        this(false, false, 0, 0, null, null, 0, 0, false, 0, 0, false, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, 0, 0, false, 0.0d, 0.0d, 0, null, 0.0d, 0.0d, false, false, null, null, false, 0.0d, null, -1, 3, null);
    }

    /* renamed from: A, reason: from getter */
    public final boolean getShouldClearStoryDBTableAfterCollector() {
        return this.shouldClearStoryDBTableAfterCollector;
    }

    /* renamed from: B, reason: from getter */
    public final boolean getShouldUseLocationAlbum() {
        return this.shouldUseLocationAlbum;
    }

    /* renamed from: C, reason: from getter */
    public final boolean getShouldUseTimeAlbum() {
        return this.shouldUseTimeAlbum;
    }

    @Nullable
    /* renamed from: D, reason: from getter */
    public final String getSolarFestivals() {
        return this.solarFestivals;
    }

    /* renamed from: E, reason: from getter */
    public final double getSortTimeWeight() {
        return this.sortTimeWeight;
    }

    @NotNull
    /* renamed from: F, reason: from getter */
    public final String getStoryDDmobanIds() {
        return this.storyDDmobanIds;
    }

    public final boolean G() {
        if (!this.isMemoryAlbumOpen && !this.isNewAlbumOpen) {
            return false;
        }
        return true;
    }

    /* renamed from: H, reason: from getter */
    public final boolean getIsMemoryAlbumOpen() {
        return this.isMemoryAlbumOpen;
    }

    /* renamed from: I, reason: from getter */
    public final boolean getIsNewAlbumOpen() {
        return this.isNewAlbumOpen;
    }

    /* renamed from: J, reason: from getter */
    public final boolean getIsShowOldTemplateLibAlbumEntrance() {
        return this.isShowOldTemplateLibAlbumEntrance;
    }

    public final boolean K() {
        return G();
    }

    public final void L(@Nullable List<String> list) {
        this.aestheticParams = list;
    }

    public final void M(double d16) {
        this.aestheticThreshold = d16;
    }

    public final void N(int i3) {
        this.albumDisplayedTimeInterval = i3;
    }

    public final void O(double d16) {
        this.albumRepeatFilterRatio = d16;
    }

    public final void P(@Nullable String str) {
        this.chineseFestivals = str;
    }

    public final void Q(int i3) {
        this.collectorDayCount = i3;
    }

    public final void R(int i3) {
        this.collectorLoopCount = i3;
    }

    public final void S(int i3) {
        this.collectorSameStoryMinInterval = i3;
    }

    public final void T(double d16) {
        this.dropoutDisplayedRate = d16;
    }

    public final void U(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.machineBlackList = list;
    }

    public final void V(double d16) {
        this.maxAspectRatio = d16;
    }

    public final void W(double d16) {
        this.maxImageLongSide = d16;
    }

    public final void X(double d16) {
        this.maxTextSimilarityThreshould = d16;
    }

    public final void Y(boolean z16) {
        this.isMemoryAlbumOpen = z16;
    }

    public final void Z(double d16) {
        this.minAspectRatio = d16;
    }

    public final void a0(double d16) {
        this.minImageShortSide = d16;
    }

    @Nullable
    public final List<String> b() {
        return this.aestheticParams;
    }

    public final void b0(int i3) {
        this.minNewAlbumCPUCoreCount = i3;
    }

    /* renamed from: c, reason: from getter */
    public final double getAestheticThreshold() {
        return this.aestheticThreshold;
    }

    public final void c0(int i3) {
        this.minNewAlbumOSVersion = i3;
    }

    /* renamed from: d, reason: from getter */
    public final int getAlbumDisplayedTimeInterval() {
        return this.albumDisplayedTimeInterval;
    }

    public final void d0(int i3) {
        this.modelInputImageSize = i3;
    }

    /* renamed from: e, reason: from getter */
    public final double getAlbumRepeatFilterRatio() {
        return this.albumRepeatFilterRatio;
    }

    public final void e0(int i3) {
        this.modelLoadRetryTimes = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkAlbumFuncConfig)) {
            return false;
        }
        WinkAlbumFuncConfig winkAlbumFuncConfig = (WinkAlbumFuncConfig) other;
        if (this.isMemoryAlbumOpen == winkAlbumFuncConfig.isMemoryAlbumOpen && this.isNewAlbumOpen == winkAlbumFuncConfig.isNewAlbumOpen && this.minNewAlbumOSVersion == winkAlbumFuncConfig.minNewAlbumOSVersion && this.minNewAlbumCPUCoreCount == winkAlbumFuncConfig.minNewAlbumCPUCoreCount && Intrinsics.areEqual(this.machineBlackList, winkAlbumFuncConfig.machineBlackList) && Intrinsics.areEqual(this.newMemoryAlbumExpName, winkAlbumFuncConfig.newMemoryAlbumExpName) && this.modelLoadRetryTimes == winkAlbumFuncConfig.modelLoadRetryTimes && this.modelInputImageSize == winkAlbumFuncConfig.modelInputImageSize && this.isShowOldTemplateLibAlbumEntrance == winkAlbumFuncConfig.isShowOldTemplateLibAlbumEntrance && this.scanUpdateDBStep == winkAlbumFuncConfig.scanUpdateDBStep && this.scanBatchSize == winkAlbumFuncConfig.scanBatchSize && this.scanFilterVideo == winkAlbumFuncConfig.scanFilterVideo && Double.compare(this.minImageShortSide, winkAlbumFuncConfig.minImageShortSide) == 0 && Double.compare(this.maxImageLongSide, winkAlbumFuncConfig.maxImageLongSide) == 0 && Double.compare(this.minAspectRatio, winkAlbumFuncConfig.minAspectRatio) == 0 && Double.compare(this.maxAspectRatio, winkAlbumFuncConfig.maxAspectRatio) == 0 && Double.compare(this.dropoutDisplayedRate, winkAlbumFuncConfig.dropoutDisplayedRate) == 0 && this.collectorDayCount == winkAlbumFuncConfig.collectorDayCount && this.collectorLoopCount == winkAlbumFuncConfig.collectorLoopCount && this.collectorSameStoryMinInterval == winkAlbumFuncConfig.collectorSameStoryMinInterval && this.shouldClearStoryDBTableAfterCollector == winkAlbumFuncConfig.shouldClearStoryDBTableAfterCollector && Double.compare(this.photoSimilarityThreshould, winkAlbumFuncConfig.photoSimilarityThreshould) == 0 && Double.compare(this.maxTextSimilarityThreshould, winkAlbumFuncConfig.maxTextSimilarityThreshould) == 0 && this.albumDisplayedTimeInterval == winkAlbumFuncConfig.albumDisplayedTimeInterval && Intrinsics.areEqual(this.aestheticParams, winkAlbumFuncConfig.aestheticParams) && Double.compare(this.aestheticThreshold, winkAlbumFuncConfig.aestheticThreshold) == 0 && Double.compare(this.albumRepeatFilterRatio, winkAlbumFuncConfig.albumRepeatFilterRatio) == 0 && this.shouldUseLocationAlbum == winkAlbumFuncConfig.shouldUseLocationAlbum && this.shouldUseTimeAlbum == winkAlbumFuncConfig.shouldUseTimeAlbum && Intrinsics.areEqual(this.solarFestivals, winkAlbumFuncConfig.solarFestivals) && Intrinsics.areEqual(this.chineseFestivals, winkAlbumFuncConfig.chineseFestivals) && this.newImageScale == winkAlbumFuncConfig.newImageScale && Double.compare(this.sortTimeWeight, winkAlbumFuncConfig.sortTimeWeight) == 0 && Intrinsics.areEqual(this.storyDDmobanIds, winkAlbumFuncConfig.storyDDmobanIds)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getChineseFestivals() {
        return this.chineseFestivals;
    }

    public final void f0(boolean z16) {
        this.isNewAlbumOpen = z16;
    }

    /* renamed from: g, reason: from getter */
    public final int getCollectorDayCount() {
        return this.collectorDayCount;
    }

    public final void g0(boolean z16) {
        this.newImageScale = z16;
    }

    /* renamed from: h, reason: from getter */
    public final int getCollectorLoopCount() {
        return this.collectorLoopCount;
    }

    public final void h0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.newMemoryAlbumExpName = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v29, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v41, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v43, types: [boolean] */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        boolean z16 = this.isMemoryAlbumOpen;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isNewAlbumOpen;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int hashCode3 = (((((((((((((i16 + i17) * 31) + this.minNewAlbumOSVersion) * 31) + this.minNewAlbumCPUCoreCount) * 31) + this.machineBlackList.hashCode()) * 31) + this.newMemoryAlbumExpName.hashCode()) * 31) + this.modelLoadRetryTimes) * 31) + this.modelInputImageSize) * 31;
        ?? r27 = this.isShowOldTemplateLibAlbumEntrance;
        int i18 = r27;
        if (r27 != 0) {
            i18 = 1;
        }
        int i19 = (((((hashCode3 + i18) * 31) + this.scanUpdateDBStep) * 31) + this.scanBatchSize) * 31;
        ?? r28 = this.scanFilterVideo;
        int i26 = r28;
        if (r28 != 0) {
            i26 = 1;
        }
        int a16 = (((((((((((((((((i19 + i26) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.minImageShortSide)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.maxImageLongSide)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.minAspectRatio)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.maxAspectRatio)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.dropoutDisplayedRate)) * 31) + this.collectorDayCount) * 31) + this.collectorLoopCount) * 31) + this.collectorSameStoryMinInterval) * 31;
        ?? r29 = this.shouldClearStoryDBTableAfterCollector;
        int i27 = r29;
        if (r29 != 0) {
            i27 = 1;
        }
        int a17 = (((((((a16 + i27) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.photoSimilarityThreshould)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.maxTextSimilarityThreshould)) * 31) + this.albumDisplayedTimeInterval) * 31;
        List<String> list = this.aestheticParams;
        int i28 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int a18 = (((((a17 + hashCode) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.aestheticThreshold)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.albumRepeatFilterRatio)) * 31;
        ?? r210 = this.shouldUseLocationAlbum;
        int i29 = r210;
        if (r210 != 0) {
            i29 = 1;
        }
        int i36 = (a18 + i29) * 31;
        ?? r211 = this.shouldUseTimeAlbum;
        int i37 = r211;
        if (r211 != 0) {
            i37 = 1;
        }
        int i38 = (i36 + i37) * 31;
        String str = this.solarFestivals;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i39 = (i38 + hashCode2) * 31;
        String str2 = this.chineseFestivals;
        if (str2 != null) {
            i28 = str2.hashCode();
        }
        int i46 = (i39 + i28) * 31;
        boolean z17 = this.newImageScale;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((((i46 + i3) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.sortTimeWeight)) * 31) + this.storyDDmobanIds.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final int getCollectorSameStoryMinInterval() {
        return this.collectorSameStoryMinInterval;
    }

    public final void i0(double d16) {
        this.photoSimilarityThreshould = d16;
    }

    /* renamed from: j, reason: from getter */
    public final double getDropoutDisplayedRate() {
        return this.dropoutDisplayedRate;
    }

    public final void j0(int i3) {
        this.scanBatchSize = i3;
    }

    @NotNull
    public final List<String> k() {
        return this.machineBlackList;
    }

    public final void k0(boolean z16) {
        this.scanFilterVideo = z16;
    }

    /* renamed from: l, reason: from getter */
    public final double getMaxAspectRatio() {
        return this.maxAspectRatio;
    }

    public final void l0(int i3) {
        this.scanUpdateDBStep = i3;
    }

    /* renamed from: m, reason: from getter */
    public final double getMaxImageLongSide() {
        return this.maxImageLongSide;
    }

    public final void m0(boolean z16) {
        this.shouldClearStoryDBTableAfterCollector = z16;
    }

    /* renamed from: n, reason: from getter */
    public final double getMaxTextSimilarityThreshould() {
        return this.maxTextSimilarityThreshould;
    }

    public final void n0(boolean z16) {
        this.shouldUseLocationAlbum = z16;
    }

    /* renamed from: o, reason: from getter */
    public final double getMinAspectRatio() {
        return this.minAspectRatio;
    }

    public final void o0(boolean z16) {
        this.shouldUseTimeAlbum = z16;
    }

    /* renamed from: p, reason: from getter */
    public final double getMinImageShortSide() {
        return this.minImageShortSide;
    }

    public final void p0(boolean z16) {
        this.isShowOldTemplateLibAlbumEntrance = z16;
    }

    /* renamed from: q, reason: from getter */
    public final int getMinNewAlbumCPUCoreCount() {
        return this.minNewAlbumCPUCoreCount;
    }

    public final void q0(@Nullable String str) {
        this.solarFestivals = str;
    }

    /* renamed from: r, reason: from getter */
    public final int getMinNewAlbumOSVersion() {
        return this.minNewAlbumOSVersion;
    }

    public final void r0(double d16) {
        this.sortTimeWeight = d16;
    }

    /* renamed from: s, reason: from getter */
    public final int getModelInputImageSize() {
        return this.modelInputImageSize;
    }

    public final void s0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.storyDDmobanIds = str;
    }

    /* renamed from: t, reason: from getter */
    public final int getModelLoadRetryTimes() {
        return this.modelLoadRetryTimes;
    }

    @NotNull
    public String toString() {
        return "WinkAlbumFuncConfig(isMemoryAlbumOpen=" + this.isMemoryAlbumOpen + ", isNewAlbumOpen=" + this.isNewAlbumOpen + ", minNewAlbumOSVersion=" + this.minNewAlbumOSVersion + ", minNewAlbumCPUCoreCount=" + this.minNewAlbumCPUCoreCount + ", machineBlackList=" + this.machineBlackList + ", newMemoryAlbumExpName=" + this.newMemoryAlbumExpName + ", modelLoadRetryTimes=" + this.modelLoadRetryTimes + ", modelInputImageSize=" + this.modelInputImageSize + ", isShowOldTemplateLibAlbumEntrance=" + this.isShowOldTemplateLibAlbumEntrance + ", scanUpdateDBStep=" + this.scanUpdateDBStep + ", scanBatchSize=" + this.scanBatchSize + ", scanFilterVideo=" + this.scanFilterVideo + ", minImageShortSide=" + this.minImageShortSide + ", maxImageLongSide=" + this.maxImageLongSide + ", minAspectRatio=" + this.minAspectRatio + ", maxAspectRatio=" + this.maxAspectRatio + ", dropoutDisplayedRate=" + this.dropoutDisplayedRate + ", collectorDayCount=" + this.collectorDayCount + ", collectorLoopCount=" + this.collectorLoopCount + ", collectorSameStoryMinInterval=" + this.collectorSameStoryMinInterval + ", shouldClearStoryDBTableAfterCollector=" + this.shouldClearStoryDBTableAfterCollector + ", photoSimilarityThreshould=" + this.photoSimilarityThreshould + ", maxTextSimilarityThreshould=" + this.maxTextSimilarityThreshould + ", albumDisplayedTimeInterval=" + this.albumDisplayedTimeInterval + ", aestheticParams=" + this.aestheticParams + ", aestheticThreshold=" + this.aestheticThreshold + ", albumRepeatFilterRatio=" + this.albumRepeatFilterRatio + ", shouldUseLocationAlbum=" + this.shouldUseLocationAlbum + ", shouldUseTimeAlbum=" + this.shouldUseTimeAlbum + ", solarFestivals=" + this.solarFestivals + ", chineseFestivals=" + this.chineseFestivals + ", newImageScale=" + this.newImageScale + ", sortTimeWeight=" + this.sortTimeWeight + ", storyDDmobanIds=" + this.storyDDmobanIds + ")";
    }

    /* renamed from: u, reason: from getter */
    public final boolean getNewImageScale() {
        return this.newImageScale;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final String getNewMemoryAlbumExpName() {
        return this.newMemoryAlbumExpName;
    }

    /* renamed from: w, reason: from getter */
    public final double getPhotoSimilarityThreshould() {
        return this.photoSimilarityThreshould;
    }

    /* renamed from: x, reason: from getter */
    public final int getScanBatchSize() {
        return this.scanBatchSize;
    }

    /* renamed from: y, reason: from getter */
    public final boolean getScanFilterVideo() {
        return this.scanFilterVideo;
    }

    /* renamed from: z, reason: from getter */
    public final int getScanUpdateDBStep() {
        return this.scanUpdateDBStep;
    }

    public WinkAlbumFuncConfig(boolean z16, boolean z17, int i3, int i16, @NotNull List<String> machineBlackList, @NotNull String newMemoryAlbumExpName, int i17, int i18, boolean z18, int i19, int i26, boolean z19, double d16, double d17, double d18, double d19, double d26, int i27, int i28, int i29, boolean z26, double d27, double d28, int i36, @Nullable List<String> list, double d29, double d36, boolean z27, boolean z28, @Nullable String str, @Nullable String str2, boolean z29, double d37, @NotNull String storyDDmobanIds) {
        Intrinsics.checkNotNullParameter(machineBlackList, "machineBlackList");
        Intrinsics.checkNotNullParameter(newMemoryAlbumExpName, "newMemoryAlbumExpName");
        Intrinsics.checkNotNullParameter(storyDDmobanIds, "storyDDmobanIds");
        this.isMemoryAlbumOpen = z16;
        this.isNewAlbumOpen = z17;
        this.minNewAlbumOSVersion = i3;
        this.minNewAlbumCPUCoreCount = i16;
        this.machineBlackList = machineBlackList;
        this.newMemoryAlbumExpName = newMemoryAlbumExpName;
        this.modelLoadRetryTimes = i17;
        this.modelInputImageSize = i18;
        this.isShowOldTemplateLibAlbumEntrance = z18;
        this.scanUpdateDBStep = i19;
        this.scanBatchSize = i26;
        this.scanFilterVideo = z19;
        this.minImageShortSide = d16;
        this.maxImageLongSide = d17;
        this.minAspectRatio = d18;
        this.maxAspectRatio = d19;
        this.dropoutDisplayedRate = d26;
        this.collectorDayCount = i27;
        this.collectorLoopCount = i28;
        this.collectorSameStoryMinInterval = i29;
        this.shouldClearStoryDBTableAfterCollector = z26;
        this.photoSimilarityThreshould = d27;
        this.maxTextSimilarityThreshould = d28;
        this.albumDisplayedTimeInterval = i36;
        this.aestheticParams = list;
        this.aestheticThreshold = d29;
        this.albumRepeatFilterRatio = d36;
        this.shouldUseLocationAlbum = z27;
        this.shouldUseTimeAlbum = z28;
        this.solarFestivals = str;
        this.chineseFestivals = str2;
        this.newImageScale = z29;
        this.sortTimeWeight = d37;
        this.storyDDmobanIds = storyDDmobanIds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int t0(boolean z16) {
        return z16 ? 1 : 0;
    }

    public /* synthetic */ WinkAlbumFuncConfig(boolean z16, boolean z17, int i3, int i16, List list, String str, int i17, int i18, boolean z18, int i19, int i26, boolean z19, double d16, double d17, double d18, double d19, double d26, int i27, int i28, int i29, boolean z26, double d27, double d28, int i36, List list2, double d29, double d36, boolean z27, boolean z28, String str2, String str3, boolean z29, double d37, String str4, int i37, int i38, DefaultConstructorMarker defaultConstructorMarker) {
        this((i37 & 1) != 0 ? true : z16, (i37 & 2) != 0 ? true : z17, (i37 & 4) != 0 ? 21 : i3, (i37 & 8) != 0 ? 4 : i16, (i37 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i37 & 32) != 0 ? "exp_qqvideo_upload_recommand_1" : str, (i37 & 64) != 0 ? 3 : i17, (i37 & 128) != 0 ? 224 : i18, (i37 & 256) != 0 ? true : z18, (i37 & 512) != 0 ? 10 : i19, (i37 & 1024) != 0 ? 1000 : i26, (i37 & 2048) != 0 ? true : z19, (i37 & 4096) != 0 ? 500.0d : d16, (i37 & 8192) != 0 ? 5000.0d : d17, (i37 & 16384) != 0 ? 0.333d : d18, (32768 & i37) != 0 ? 3.0d : d19, (65536 & i37) != 0 ? 0.5d : d26, (131072 & i37) != 0 ? 5 : i27, (i37 & 262144) != 0 ? 100 : i28, (i37 & 524288) == 0 ? i29 : 3, (i37 & 1048576) != 0 ? true : z26, (i37 & 2097152) != 0 ? 97.0d : d27, (i37 & 4194304) != 0 ? 100.0d : d28, (i37 & 8388608) != 0 ? 500 : i36, (i37 & 16777216) != 0 ? null : list2, (i37 & 33554432) != 0 ? 1.2d : d29, (i37 & 67108864) == 0 ? d36 : 0.5d, (i37 & 134217728) != 0 ? true : z27, (i37 & 268435456) != 0 ? true : z28, (i37 & 536870912) != 0 ? null : str2, (i37 & 1073741824) == 0 ? str3 : null, (i37 & Integer.MIN_VALUE) != 0 ? true : z29, (i38 & 1) != 0 ? 0.9d : d37, (i38 & 2) != 0 ? "dapian_yuanxiangji,dapian_fuguluxiang,dapian_zaiyujian,dapian_meirixinqing" : str4);
    }
}
