package wx4;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.action.MODE;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b?\b\u0086\b\u0018\u0000 \\2\u00020\u0001:\u0001\u0004B\u00e9\u0001\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0010\u0012\b\b\u0002\u0010%\u001a\u00020\"\u0012\b\b\u0002\u0010&\u001a\u00020\r\u0012\b\b\u0002\u0010'\u001a\u00020\"\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010*\u001a\u00020\r\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\bz\u0010{J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fJ\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u00fc\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u00102\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\"2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010*\u001a\u00020\r2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+H\u00c6\u0001\u00a2\u0006\u0004\b-\u0010.J\t\u0010/\u001a\u00020\rH\u00d6\u0001J\u0013\u00101\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u00106\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010<\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010D\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010\u0013\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010\u0014\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010E\u001a\u0004\bJ\u0010G\"\u0004\bK\u0010IR\"\u0010\u0015\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010E\u001a\u0004\bL\u0010G\"\u0004\bM\u0010IR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010E\u001a\u0004\bO\u0010G\"\u0004\bP\u0010IR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010E\u001a\u0004\bR\u0010G\"\u0004\bS\u0010IR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010E\u001a\u0004\bU\u0010G\"\u0004\bV\u0010IR\"\u0010\u0019\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010E\u001a\u0004\bW\u0010G\"\u0004\bX\u0010IR\"\u0010\u001a\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010E\u001a\u0004\bY\u0010G\"\u0004\bZ\u0010IR\"\u0010\u001b\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b[\u00103\"\u0004\b\\\u00105R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010E\u001a\u0004\b]\u0010G\"\u0004\b^\u0010IR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010E\u001a\u0004\b_\u0010G\"\u0004\b`\u0010IR\u0017\u0010\u001e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\ba\u00103R\u0017\u0010\u001f\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\bb\u00103R\u0017\u0010!\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\bB\u0010c\u001a\u0004\bT\u0010dR\u0017\u0010#\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b`\u0010e\u001a\u0004\b#\u0010fR\"\u0010$\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u00107\u001a\u0004\bg\u00109\"\u0004\bh\u0010;R\"\u0010%\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010e\u001a\u0004\bQ\u0010f\"\u0004\bj\u0010kR\"\u0010&\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010\u0011\u001a\u0004\bN\u00103\"\u0004\bi\u00105R\"\u0010'\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010e\u001a\u0004\bl\u0010f\"\u0004\bm\u0010kR$\u0010(\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR$\u0010)\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010n\u001a\u0004\bs\u0010p\"\u0004\bt\u0010rR\"\u0010*\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010\u0011\u001a\u0004\bu\u00103\"\u0004\bv\u00105R\u0019\u0010,\u001a\u0004\u0018\u00010+8\u0006\u00a2\u0006\f\n\u0004\bV\u0010w\u001a\u0004\bx\u0010y\u00a8\u0006|"}, d2 = {"Lwx4/d;", "", "", "time", "a", "f", "p", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "d", "e", "o", "", "k", "", "", "I", "toString", "evaluateStartTime", "evaluateEndTime", "scheduledFromQueueTime", "evaluateToEngineTime", "recordStartTime", "recordEndTime", "resourceDownloadStartTime", "resourceDownloadEndTime", "recordFrameCount", "encodeStartTime", "encodeEndTime", "width", "height", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "isBatch", "appearanceKey", "hitCache", "errCode", "oom", "aaType", "aaLevel", "useRecordV2", "Lcom/tencent/zplan/meme/EngineType;", "targetEngineType", "b", "(JJJJJJJJIJJIILcom/tencent/zplan/meme/action/MODE;ZLjava/lang/String;ZIZLjava/lang/Integer;Ljava/lang/Integer;ILcom/tencent/zplan/meme/EngineType;)Lwx4/d;", "hashCode", "other", "equals", "j", "()I", UserInfo.SEX_FEMALE, "(I)V", "scriptErrorCode", "Ljava/lang/String;", "getScriptStatisticData", "()Ljava/lang/String;", "G", "(Ljava/lang/String;)V", "scriptStatisticData", "Lwx4/e;", "c", "Lwx4/e;", "getAssetsResourceStatistic", "()Lwx4/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lwx4/e;)V", "assetsResourceStatistic", "J", "getEvaluateStartTime$record_debug", "()J", "v", "(J)V", "getEvaluateEndTime$record_debug", "u", "getScheduledFromQueueTime$record_debug", "E", "g", "getEvaluateToEngineTime", "w", h.F, "getRecordStartTime", "B", "i", "getRecordEndTime", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "getResourceDownloadStartTime$record_debug", "D", "getResourceDownloadEndTime$record_debug", BdhLogUtil.LogTag.Tag_Conn, "getRecordFrameCount", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getEncodeStartTime", ReportConstant.COSTREPORT_PREFIX, "getEncodeEndTime", "r", "getWidth", "getHeight", "Lcom/tencent/zplan/meme/action/MODE;", "()Lcom/tencent/zplan/meme/action/MODE;", "Z", "()Z", "getAppearanceKey", "setAppearanceKey", "t", HippyTKDListViewAdapter.X, "(Z)V", "getOom", "y", "Ljava/lang/Integer;", "getAaType", "()Ljava/lang/Integer;", "setAaType", "(Ljava/lang/Integer;)V", "getAaLevel", "setAaLevel", "getUseRecordV2", "H", "Lcom/tencent/zplan/meme/EngineType;", "getTargetEngineType", "()Lcom/tencent/zplan/meme/EngineType;", "<init>", "(JJJJJJJJIJJIILcom/tencent/zplan/meme/action/MODE;ZLjava/lang/String;ZIZLjava/lang/Integer;Ljava/lang/Integer;ILcom/tencent/zplan/meme/EngineType;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class d {

    /* renamed from: A, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int scriptErrorCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String scriptStatisticData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PrepareAssetsStatistic assetsResourceStatistic;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long evaluateStartTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long evaluateEndTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long scheduledFromQueueTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long evaluateToEngineTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long recordStartTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long recordEndTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long resourceDownloadStartTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long resourceDownloadEndTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int recordFrameCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long encodeStartTime;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long encodeEndTime;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MODE mode;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final boolean isBatch;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appearanceKey;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean hitCache;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private int errCode;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private boolean oom;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer aaType;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer aaLevel;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private int useRecordV2;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final EngineType targetEngineType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\u0018\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006*\u00020\u0005R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lwx4/d$a;", "", "", "", "b", "", "", "a", "TAG", "Ljava/lang/String;", "TIME_COST_THRESHOLD", "I", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: wx4.d$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final Map<String, String> a(@NotNull String jsonStringToMap) {
            JSONObject jSONObject;
            String str;
            Intrinsics.checkNotNullParameter(jsonStringToMap, "$this$jsonStringToMap");
            LinkedHashMap linkedHashMap = null;
            try {
                jSONObject = new JSONObject(jsonStringToMap);
            } catch (Throwable th5) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    a16.e("[zplan][MemeRecordStatistic]", 1, "jsonStringToMap exception, " + jsonStringToMap, th5);
                }
                jSONObject = null;
            }
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                linkedHashMap = new LinkedHashMap();
                while (keys.hasNext()) {
                    Object next = keys.next();
                    Intrinsics.checkNotNullExpressionValue(next, "keys.next()");
                    String str2 = (String) next;
                    Object opt = jSONObject.opt(str2);
                    if (opt == null || (str = opt.toString()) == null) {
                        str = "";
                    }
                    linkedHashMap.put(str2, str);
                }
            }
            return linkedHashMap;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int b(boolean z16) {
            return z16 ? 1 : 0;
        }
    }

    public d(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, int i3, long j29, long j36, int i16, int i17, @NotNull MODE mode, boolean z16, @NotNull String appearanceKey, boolean z17, int i18, boolean z18, @Nullable Integer num, @Nullable Integer num2, int i19, @Nullable EngineType engineType) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        this.evaluateStartTime = j3;
        this.evaluateEndTime = j16;
        this.scheduledFromQueueTime = j17;
        this.evaluateToEngineTime = j18;
        this.recordStartTime = j19;
        this.recordEndTime = j26;
        this.resourceDownloadStartTime = j27;
        this.resourceDownloadEndTime = j28;
        this.recordFrameCount = i3;
        this.encodeStartTime = j29;
        this.encodeEndTime = j36;
        this.width = i16;
        this.height = i17;
        this.mode = mode;
        this.isBatch = z16;
        this.appearanceKey = appearanceKey;
        this.hitCache = z17;
        this.errCode = i18;
        this.oom = z18;
        this.aaType = num;
        this.aaLevel = num2;
        this.useRecordV2 = i19;
        this.targetEngineType = engineType;
    }

    private final long a(long time) {
        if (time < 0 || time > 3600000) {
            return 0L;
        }
        return time;
    }

    public final void A(int i3) {
        this.recordFrameCount = i3;
    }

    public final void B(long j3) {
        this.recordStartTime = j3;
    }

    public final void C(long j3) {
        this.resourceDownloadEndTime = j3;
    }

    public final void D(long j3) {
        this.resourceDownloadStartTime = j3;
    }

    public final void E(long j3) {
        this.scheduledFromQueueTime = j3;
    }

    public final void F(int i3) {
        this.scriptErrorCode = i3;
    }

    public final void G(@Nullable String str) {
        this.scriptStatisticData = str;
    }

    public final void H(int i3) {
        this.useRecordV2 = i3;
    }

    @NotNull
    public final Map<String, String> I() {
        Map<String, String> mutableMapOf;
        Map<String, String> e16;
        Map<String, String> a16;
        boolean z16 = false;
        Companion companion = INSTANCE;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errorCode", String.valueOf(this.errCode)), TuplesKt.to("evaluateTimeCost", String.valueOf(f())), TuplesKt.to("scheduleTimeCost", String.valueOf(p())), TuplesKt.to("prepareEngineTimeCost", String.valueOf(l())), TuplesKt.to("evaluateEngineToGetResultTime", String.valueOf(e())), TuplesKt.to("prepareResourceTimeCost", String.valueOf(m())), TuplesKt.to("recordTimeCost", String.valueOf(n())), TuplesKt.to("encodeTimeCost", String.valueOf(d())), TuplesKt.to("nativeResourceDownloadTimeCost", String.valueOf(o())), TuplesKt.to("width", String.valueOf(this.width)), TuplesKt.to("height", String.valueOf(this.height)), TuplesKt.to("mode", this.mode.toString()), TuplesKt.to("isBatch", String.valueOf(companion.b(this.isBatch))), TuplesKt.to("hitCache", String.valueOf(companion.b(this.hitCache))), TuplesKt.to("frameCount", String.valueOf(this.recordFrameCount)), TuplesKt.to("occurOOM", String.valueOf(companion.b(this.oom))), TuplesKt.to("scriptErrorCode", String.valueOf(this.scriptErrorCode)), TuplesKt.to("aaType", String.valueOf(this.aaType)), TuplesKt.to("aaLevel", String.valueOf(this.aaLevel)), TuplesKt.to("useRecordV2", String.valueOf(this.useRecordV2)), TuplesKt.to("targetEngineType", String.valueOf(k())));
        String str = this.scriptStatisticData;
        if (str == null || str.length() == 0) {
            z16 = true;
        }
        if (!z16 && (a16 = companion.a(str)) != null) {
            mutableMapOf.putAll(a16);
        }
        PrepareAssetsStatistic prepareAssetsStatistic = this.assetsResourceStatistic;
        if (prepareAssetsStatistic != null && (e16 = prepareAssetsStatistic.e()) != null) {
            mutableMapOf.putAll(e16);
        }
        return mutableMapOf;
    }

    @NotNull
    public final d b(long evaluateStartTime, long evaluateEndTime, long scheduledFromQueueTime, long evaluateToEngineTime, long recordStartTime, long recordEndTime, long resourceDownloadStartTime, long resourceDownloadEndTime, int recordFrameCount, long encodeStartTime, long encodeEndTime, int width, int height, @NotNull MODE mode, boolean isBatch, @NotNull String appearanceKey, boolean hitCache, int errCode, boolean oom, @Nullable Integer aaType, @Nullable Integer aaLevel, int useRecordV2, @Nullable EngineType targetEngineType) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        return new d(evaluateStartTime, evaluateEndTime, scheduledFromQueueTime, evaluateToEngineTime, recordStartTime, recordEndTime, resourceDownloadStartTime, resourceDownloadEndTime, recordFrameCount, encodeStartTime, encodeEndTime, width, height, mode, isBatch, appearanceKey, hitCache, errCode, oom, aaType, aaLevel, useRecordV2, targetEngineType);
    }

    public final long d() {
        return a(this.encodeEndTime - this.encodeStartTime);
    }

    public final long e() {
        return a(this.encodeEndTime - this.evaluateToEngineTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof d) {
                d dVar = (d) other;
                if (this.evaluateStartTime != dVar.evaluateStartTime || this.evaluateEndTime != dVar.evaluateEndTime || this.scheduledFromQueueTime != dVar.scheduledFromQueueTime || this.evaluateToEngineTime != dVar.evaluateToEngineTime || this.recordStartTime != dVar.recordStartTime || this.recordEndTime != dVar.recordEndTime || this.resourceDownloadStartTime != dVar.resourceDownloadStartTime || this.resourceDownloadEndTime != dVar.resourceDownloadEndTime || this.recordFrameCount != dVar.recordFrameCount || this.encodeStartTime != dVar.encodeStartTime || this.encodeEndTime != dVar.encodeEndTime || this.width != dVar.width || this.height != dVar.height || !Intrinsics.areEqual(this.mode, dVar.mode) || this.isBatch != dVar.isBatch || !Intrinsics.areEqual(this.appearanceKey, dVar.appearanceKey) || this.hitCache != dVar.hitCache || this.errCode != dVar.errCode || this.oom != dVar.oom || !Intrinsics.areEqual(this.aaType, dVar.aaType) || !Intrinsics.areEqual(this.aaLevel, dVar.aaLevel) || this.useRecordV2 != dVar.useRecordV2 || !Intrinsics.areEqual(this.targetEngineType, dVar.targetEngineType)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long f() {
        return a(this.evaluateEndTime - this.evaluateStartTime);
    }

    /* renamed from: g, reason: from getter */
    public final int getErrCode() {
        return this.errCode;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getHitCache() {
        return this.hitCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int a16 = ((((((((((((((((((((((((androidx.fragment.app.a.a(this.evaluateStartTime) * 31) + androidx.fragment.app.a.a(this.evaluateEndTime)) * 31) + androidx.fragment.app.a.a(this.scheduledFromQueueTime)) * 31) + androidx.fragment.app.a.a(this.evaluateToEngineTime)) * 31) + androidx.fragment.app.a.a(this.recordStartTime)) * 31) + androidx.fragment.app.a.a(this.recordEndTime)) * 31) + androidx.fragment.app.a.a(this.resourceDownloadStartTime)) * 31) + androidx.fragment.app.a.a(this.resourceDownloadEndTime)) * 31) + this.recordFrameCount) * 31) + androidx.fragment.app.a.a(this.encodeStartTime)) * 31) + androidx.fragment.app.a.a(this.encodeEndTime)) * 31) + this.width) * 31) + this.height) * 31;
        MODE mode = this.mode;
        int i19 = 0;
        if (mode != null) {
            i3 = mode.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = (a16 + i3) * 31;
        boolean z16 = this.isBatch;
        int i27 = 1;
        int i28 = z16;
        if (z16 != 0) {
            i28 = 1;
        }
        int i29 = (i26 + i28) * 31;
        String str = this.appearanceKey;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i36 = (i29 + i16) * 31;
        boolean z17 = this.hitCache;
        int i37 = z17;
        if (z17 != 0) {
            i37 = 1;
        }
        int i38 = (((i36 + i37) * 31) + this.errCode) * 31;
        boolean z18 = this.oom;
        if (!z18) {
            i27 = z18 ? 1 : 0;
        }
        int i39 = (i38 + i27) * 31;
        Integer num = this.aaType;
        if (num != null) {
            i17 = num.hashCode();
        } else {
            i17 = 0;
        }
        int i46 = (i39 + i17) * 31;
        Integer num2 = this.aaLevel;
        if (num2 != null) {
            i18 = num2.hashCode();
        } else {
            i18 = 0;
        }
        int i47 = (((i46 + i18) * 31) + this.useRecordV2) * 31;
        EngineType engineType = this.targetEngineType;
        if (engineType != null) {
            i19 = engineType.hashCode();
        }
        return i47 + i19;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final MODE getMode() {
        return this.mode;
    }

    /* renamed from: j, reason: from getter */
    public final int getScriptErrorCode() {
        return this.scriptErrorCode;
    }

    public final int k() {
        boolean z16;
        EngineType engineType = this.targetEngineType;
        if (engineType != null && (engineType instanceof EngineType.Filament)) {
            z16 = true;
        } else {
            z16 = false;
        }
        return INSTANCE.b(z16);
    }

    public final long l() {
        return a(this.evaluateToEngineTime - this.scheduledFromQueueTime);
    }

    public final long m() {
        return a(this.recordStartTime - this.evaluateToEngineTime);
    }

    public final long n() {
        return a(this.recordEndTime - this.recordStartTime);
    }

    public final long o() {
        return a(this.resourceDownloadEndTime - this.resourceDownloadStartTime);
    }

    public final long p() {
        return a(this.scheduledFromQueueTime - this.evaluateStartTime);
    }

    public final void q(@Nullable PrepareAssetsStatistic prepareAssetsStatistic) {
        this.assetsResourceStatistic = prepareAssetsStatistic;
    }

    public final void r(long j3) {
        this.encodeEndTime = j3;
    }

    public final void s(long j3) {
        this.encodeStartTime = j3;
    }

    public final void t(int i3) {
        this.errCode = i3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("errCode:" + this.errCode + ", ");
        sb5.append("scriptErrCode:" + this.scriptErrorCode + ", ");
        sb5.append("hitCache:" + this.hitCache + ", ");
        sb5.append("frameCount:" + this.recordFrameCount + ", ");
        sb5.append("w:" + this.width + ", h:" + this.height + ", oom:" + this.oom + ", ");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("AAType:");
        sb6.append(this.aaType);
        sb6.append(", AALevel:");
        sb6.append(this.aaLevel);
        sb6.append(", ");
        sb5.append(sb6.toString());
        sb5.append("evaluateTimeCost:" + f() + ", ");
        sb5.append("scheduleTimeCost:" + p() + ", ");
        sb5.append("prepareEngineTimeCost:" + l() + ", ");
        sb5.append("evaluateEngineToGetResultTime:" + e() + ", ");
        sb5.append("prepareResourceTimeCost:" + m() + ", ");
        sb5.append("recordTimeCost:" + n() + ", ");
        sb5.append("encodeTimeCost:" + d() + ", ");
        StringBuilder sb7 = new StringBuilder();
        sb7.append("nativeResourceDownloadTimeCost:");
        sb7.append(o());
        sb5.append(sb7.toString());
        sb5.append("targetEngineType:" + k());
        String sb8 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb8, "StringBuilder().apply(builderAction).toString()");
        return sb8;
    }

    public final void u(long j3) {
        this.evaluateEndTime = j3;
    }

    public final void v(long j3) {
        this.evaluateStartTime = j3;
    }

    public final void w(long j3) {
        this.evaluateToEngineTime = j3;
    }

    public final void x(boolean z16) {
        this.hitCache = z16;
    }

    public final void y(boolean z16) {
        this.oom = z16;
    }

    public final void z(long j3) {
        this.recordEndTime = j3;
    }

    public /* synthetic */ d(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, int i3, long j29, long j36, int i16, int i17, MODE mode, boolean z16, String str, boolean z17, int i18, boolean z18, Integer num, Integer num2, int i19, EngineType engineType, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? 0L : j3, (i26 & 2) != 0 ? 0L : j16, (i26 & 4) != 0 ? 0L : j17, (i26 & 8) != 0 ? 0L : j18, (i26 & 16) != 0 ? 0L : j19, (i26 & 32) != 0 ? 0L : j26, (i26 & 64) != 0 ? 0L : j27, (i26 & 128) != 0 ? 0L : j28, (i26 & 256) != 0 ? 0 : i3, (i26 & 512) != 0 ? 0L : j29, (i26 & 1024) != 0 ? 0L : j36, i16, i17, mode, z16, (32768 & i26) != 0 ? "" : str, (65536 & i26) != 0 ? false : z17, (131072 & i26) != 0 ? 0 : i18, (262144 & i26) != 0 ? false : z18, (524288 & i26) != 0 ? null : num, (1048576 & i26) != 0 ? null : num2, (i26 & 2097152) != 0 ? 0 : i19, engineType);
    }
}
