package vk0;

import al0.a;
import cl0.f;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.business.api.SceneType;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;
import uk0.e;
import wx4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 D2\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\bB\u0010CJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00182\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\rJ\u001a\u0010\u001b\u001a\u00020\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0018J\"\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006J\u001e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0006J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010#R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010$R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010'R\u0014\u0010*\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010)R\u0016\u0010,\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0018\u0010/\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010#R\u0018\u00103\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010#R\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010#R\u0018\u00107\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010#R\u0018\u00109\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010#R\u0018\u0010;\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010#R\u0018\u0010=\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010)R\u0014\u0010?\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010)R\u0014\u0010A\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010)\u00a8\u0006E"}, d2 = {"Lvk0/a;", "Luk0/e;", "", "threadPriority", "", "d", "", "sceneName", "Lcom/tencent/filament/zplan/business/api/SceneType;", "sceneType", "i", "f", "g", "", "isSuccess", "isDownload", "e", "Lal0/a;", "statistic", h.F, "Lorg/json/JSONObject;", "b", "appStatus", "needRecordFirstFrame", "", "a", "params", "l", "errorCode", "errorMessage", "j", "c", "type", "eventData", "onEvent", "Ljava/lang/String;", "Lcom/tencent/filament/zplan/business/api/SceneType;", "Ljava/lang/Integer;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasReportStartUp", "Lal0/a;", "startWithEntry2FirstRenderStep", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "costumeChange2FirstRenderStep", BdhLogUtil.LogTag.Tag_Conn, "Lorg/json/JSONObject;", "loadSoStatistic", "D", "fetchCharacterInfoStatistic", "E", "fetchBootResourceStatistic", UserInfo.SEX_FEMALE, "fetchAvatarResourceStatistic", "G", "fetchAllResourceStatistic", "H", "fetchAnimationResourceStatistic", "I", "fetchIndirectLightStatistic", "J", "reloadAvatarEvalFunctionStatistic", "K", "reloadAvatarEvalToFirstRenderStatistic", "L", "firstLifecyclePauseStatistic", "<init>", "()V", "M", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a implements e {

    /* renamed from: C, reason: from kotlin metadata */
    private JSONObject loadSoStatistic;

    /* renamed from: D, reason: from kotlin metadata */
    private String fetchCharacterInfoStatistic;

    /* renamed from: E, reason: from kotlin metadata */
    private String fetchBootResourceStatistic;

    /* renamed from: F, reason: from kotlin metadata */
    private String fetchAvatarResourceStatistic;

    /* renamed from: G, reason: from kotlin metadata */
    private String fetchAllResourceStatistic;

    /* renamed from: H, reason: from kotlin metadata */
    private String fetchAnimationResourceStatistic;

    /* renamed from: I, reason: from kotlin metadata */
    private String fetchIndirectLightStatistic;

    /* renamed from: J, reason: from kotlin metadata */
    private al0.a reloadAvatarEvalFunctionStatistic;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String sceneName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SceneType sceneType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Integer threadPriority;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean hasReportStartUp = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final al0.a startWithEntry2FirstRenderStep = new al0.a(0, 0, false, 0, null, 31, null);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private al0.a costumeChange2FirstRenderStep = new al0.a(0, 0, false, 0, null, 31, null);

    /* renamed from: K, reason: from kotlin metadata */
    private final al0.a reloadAvatarEvalToFirstRenderStatistic = new al0.a(0, 0, false, 0, null, 31, null);

    /* renamed from: L, reason: from kotlin metadata */
    private final al0.a firstLifecyclePauseStatistic = new al0.a(0, 0, false, 0, null, 27, null);

    public static /* synthetic */ void k(a aVar, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = null;
        }
        aVar.j(str, i3, str2);
    }

    @NotNull
    public final Map<String, String> a(@NotNull String appStatus, boolean needRecordFirstFrame) {
        Pair pair;
        Integer num;
        Map<String, String> mutableMapOf;
        al0.a aVar;
        int i3;
        long j3;
        int i16;
        int i17;
        al0.a aVar2;
        int i18;
        long j16;
        int i19;
        int i26;
        al0.a aVar3;
        long j17;
        al0.a aVar4;
        int i27;
        long j18;
        int i28;
        al0.a aVar5;
        int i29;
        long j19;
        int i36;
        long j26;
        al0.a aVar6;
        Intrinsics.checkNotNullParameter(appStatus, "appStatus");
        FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
        f p16 = filamentFeatureUtil.p();
        boolean g16 = filamentFeatureUtil.g();
        cl0.c o16 = filamentFeatureUtil.o();
        if (g16) {
            pair = new Pair(Boolean.valueOf(o16.getEnableCheck()), Integer.valueOf(o16.getCheckSelect()));
        } else {
            pair = new Pair(Boolean.valueOf(p16.getEnableCheck()), Integer.valueOf(p16.getCheckSelect()));
        }
        boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
        int intValue = ((Number) pair.component2()).intValue();
        Pair[] pairArr = new Pair[10];
        String str = this.sceneName;
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("scene", str);
        SceneType sceneType = this.sceneType;
        if (sceneType != null) {
            num = Integer.valueOf(sceneType.ordinal());
        } else {
            num = null;
        }
        int i37 = 1;
        pairArr[1] = TuplesKt.to("sceneType", String.valueOf(num));
        String str2 = "1";
        pairArr[2] = TuplesKt.to("startUpResult", "1");
        pairArr[3] = TuplesKt.to("errorCode", "0");
        pairArr[4] = TuplesKt.to("enableCheck", String.valueOf(booleanValue));
        pairArr[5] = TuplesKt.to("enableGenerate", String.valueOf(p16.getEnableGenerate()));
        pairArr[6] = TuplesKt.to("checkSelect", String.valueOf(intValue));
        d.Companion companion = wx4.d.INSTANCE;
        pairArr[7] = TuplesKt.to("enableCppDownload", String.valueOf(companion.b(g16)));
        pairArr[8] = TuplesKt.to("startWithEntry2FirstRenderTC", String.valueOf(this.startWithEntry2FirstRenderStep.f()));
        pairArr[9] = TuplesKt.to("costumeChange2FirstRenderTC", String.valueOf(this.costumeChange2FirstRenderStep.f()));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        com.tencent.zplan.common.utils.h hVar = com.tencent.zplan.common.utils.h.f385294a;
        JSONObject b16 = hVar.b(this.fetchBootResourceStatistic);
        if (b16 != null) {
            aVar = al0.a.INSTANCE.a(b16);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            i3 = aVar.getErrorCode();
        } else {
            i3 = -1;
        }
        long j27 = -1;
        if (aVar != null) {
            j3 = aVar.f();
        } else {
            j3 = -1;
        }
        if (b16 != null) {
            i16 = b16.optInt("downloadFromNet");
        } else {
            i16 = -1;
        }
        if (b16 != null) {
            i17 = b16.optInt("useCache");
        } else {
            i17 = -1;
        }
        mutableMapOf.put("fetchBootErrorCode", String.valueOf(i3));
        mutableMapOf.put("fetchBootTimeCost", String.valueOf(j3));
        mutableMapOf.put("fetchBootDownload", String.valueOf(i16));
        mutableMapOf.put("fetchBootUseCache", String.valueOf(i17));
        Unit unit = Unit.INSTANCE;
        JSONObject b17 = hVar.b(this.fetchAvatarResourceStatistic);
        if (b17 != null) {
            aVar2 = al0.a.INSTANCE.a(b17);
        } else {
            aVar2 = null;
        }
        if (aVar2 != null) {
            i18 = aVar2.getErrorCode();
        } else {
            i18 = -1;
        }
        if (aVar2 != null) {
            j16 = aVar2.f();
        } else {
            j16 = -1;
        }
        if (b17 != null) {
            i19 = b17.optInt("downloadFromNet");
        } else {
            i19 = -1;
        }
        if (b17 != null) {
            i26 = b17.optInt("useCache");
        } else {
            i26 = -1;
        }
        mutableMapOf.put("fetchAvatarErrorCode", String.valueOf(i18));
        mutableMapOf.put("fetchAvatarTimeCost", String.valueOf(j16));
        mutableMapOf.put("fetchAvatarDownload", String.valueOf(i19));
        mutableMapOf.put("fetchAvatarUseCache", String.valueOf(i26));
        JSONObject b18 = hVar.b(this.fetchAllResourceStatistic);
        if (b18 != null) {
            aVar3 = al0.a.INSTANCE.a(b18);
        } else {
            aVar3 = null;
        }
        if (aVar3 != null) {
            j17 = aVar3.f();
        } else {
            j17 = -1;
        }
        if (i16 != 1 && i19 != 1) {
            i37 = 0;
        }
        mutableMapOf.put("fetchAllTimeCost", String.valueOf(j17));
        mutableMapOf.put("fetchAllDownload", String.valueOf(i37));
        JSONObject b19 = hVar.b(this.fetchAnimationResourceStatistic);
        if (b19 != null) {
            aVar4 = al0.a.INSTANCE.a(b19);
        } else {
            aVar4 = null;
        }
        if (aVar4 != null) {
            i27 = aVar4.getErrorCode();
        } else {
            i27 = -1;
        }
        if (aVar4 != null) {
            j18 = aVar4.f();
        } else {
            j18 = -1;
        }
        if (b19 != null) {
            i28 = b19.optInt("downloadFromNet");
        } else {
            i28 = -1;
        }
        mutableMapOf.put("fetchAnimationErrorCode", String.valueOf(i27));
        mutableMapOf.put("fetchAnimationTimeCost", String.valueOf(j18));
        mutableMapOf.put("fetchAnimationDownload", String.valueOf(i28));
        JSONObject b26 = hVar.b(this.fetchIndirectLightStatistic);
        if (b26 != null) {
            aVar5 = al0.a.INSTANCE.a(b26);
        } else {
            aVar5 = null;
        }
        if (aVar5 != null) {
            i29 = aVar5.getErrorCode();
        } else {
            i29 = -1;
        }
        if (aVar5 != null) {
            j19 = aVar5.f();
        } else {
            j19 = -1;
        }
        if (b26 != null) {
            i36 = b26.optInt("downloadFromNet");
        } else {
            i36 = -1;
        }
        mutableMapOf.put("fetchIndirectLightErrorCode", String.valueOf(i29));
        mutableMapOf.put("fetchIndirectLightTimeCost", String.valueOf(j19));
        mutableMapOf.put("fetchIndirectLightDownload", String.valueOf(i36));
        JSONObject jSONObject = this.loadSoStatistic;
        if (jSONObject != null) {
            String valueOf = String.valueOf(al0.a.INSTANCE.a(jSONObject).f());
            int b27 = companion.b(jSONObject.optBoolean("downloadSo", false));
            mutableMapOf.put("loadSoTimeCost", valueOf);
            mutableMapOf.put("loadSoDownload", String.valueOf(b27));
        }
        al0.a aVar7 = this.reloadAvatarEvalFunctionStatistic;
        if (aVar7 != null) {
            j26 = aVar7.f();
        } else {
            j26 = -1;
        }
        mutableMapOf.put("reloadAvatarEvalFunctionTimeCost", String.valueOf(j26));
        mutableMapOf.put("reloadAvatarEval2FirstRenderTimeCost", String.valueOf(this.reloadAvatarEvalToFirstRenderStatistic.f()));
        mutableMapOf.put("lifecyclePauseHappened", String.valueOf(companion.b(this.firstLifecyclePauseStatistic.getSuccess())));
        mutableMapOf.put("lifecyclePauseTimeCost", String.valueOf(this.firstLifecyclePauseStatistic.f()));
        mutableMapOf.put("appStatus", appStatus);
        mutableMapOf.put("threadPriority", String.valueOf(this.threadPriority));
        if (!needRecordFirstFrame) {
            str2 = "0";
        }
        mutableMapOf.put("needRecordFirstFrame", str2);
        JSONObject b28 = hVar.b(this.fetchCharacterInfoStatistic);
        if (b28 != null) {
            aVar6 = al0.a.INSTANCE.a(b28);
        } else {
            aVar6 = null;
        }
        if (aVar6 != null) {
            j27 = aVar6.f();
        }
        mutableMapOf.put("fetchCharacterInfoTimeCost", String.valueOf(j27));
        return mutableMapOf;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final JSONObject getLoadSoStatistic() {
        return this.loadSoStatistic;
    }

    public final void c(@NotNull String appStatus, int errorCode, @NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(appStatus, "appStatus");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        j(appStatus, errorCode, errorMessage);
    }

    public final void d(int threadPriority) {
        this.threadPriority = Integer.valueOf(threadPriority);
        a.Companion companion = al0.a.INSTANCE;
        this.loadSoStatistic = companion.c(new al0.a(companion.b(), 0L, false, 0, null, 30, null));
    }

    public final void e(boolean isSuccess, boolean isDownload) {
        JSONObject jSONObject = this.loadSoStatistic;
        if (jSONObject != null) {
            jSONObject.put("endTime", al0.a.INSTANCE.b());
            jSONObject.put("success", isSuccess);
            jSONObject.put("downloadSo", isDownload);
        }
    }

    public final void f() {
        if (!this.firstLifecyclePauseStatistic.getSuccess()) {
            this.firstLifecyclePauseStatistic.m(true);
            this.firstLifecyclePauseStatistic.i(al0.a.INSTANCE.b());
        }
    }

    public final void g() {
        long b16 = al0.a.INSTANCE.b();
        this.reloadAvatarEvalToFirstRenderStatistic.i(b16);
        this.startWithEntry2FirstRenderStep.i(b16);
        this.costumeChange2FirstRenderStep.i(b16);
    }

    public final void h(@NotNull al0.a statistic) {
        Intrinsics.checkNotNullParameter(statistic, "statistic");
        this.reloadAvatarEvalFunctionStatistic = statistic;
        this.reloadAvatarEvalToFirstRenderStatistic.l(statistic.getEndTime());
    }

    public final void i(@NotNull String sceneName, @NotNull SceneType sceneType) {
        Intrinsics.checkNotNullParameter(sceneName, "sceneName");
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        this.sceneName = sceneName;
        this.sceneType = sceneType;
        long b16 = al0.a.INSTANCE.b();
        this.startWithEntry2FirstRenderStep.l(b16);
        this.firstLifecyclePauseStatistic.l(b16);
    }

    public final void j(@NotNull String appStatus, int errorCode, @Nullable String errorMessage) {
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(appStatus, "appStatus");
        if (this.hasReportStartUp.get()) {
            return;
        }
        this.hasReportStartUp.set(true);
        Pair[] pairArr = new Pair[6];
        String str = this.sceneName;
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("scene", str);
        pairArr[1] = TuplesKt.to("startUpResult", "0");
        pairArr[2] = TuplesKt.to("appStatus", appStatus);
        pairArr[3] = TuplesKt.to("errorCode", String.valueOf(errorCode));
        if (errorMessage == null) {
            errorMessage = "";
        }
        pairArr[4] = TuplesKt.to("errorMessage", errorMessage);
        pairArr[5] = TuplesKt.to("threadPriority", String.valueOf(this.threadPriority));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        FLog.INSTANCE.i("FilamentStartUpTrack", "reportStartUpFail, sceneName:" + this.sceneName + ", map:" + mapOf + ", " + this);
        dl0.h hVar = (dl0.h) fl0.a.f399763a.a(dl0.h.class);
        if (hVar != null) {
            hVar.a("nativeAppStartUp", mapOf);
        }
    }

    public final void l(@NotNull Map<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.hasReportStartUp.get()) {
            return;
        }
        this.hasReportStartUp.set(true);
        FLog.INSTANCE.i("FilamentStartUpTrack", "reportStartUpSuccess, sceneName:" + this.sceneName + ", map:" + params + ", " + this);
        dl0.h hVar = (dl0.h) fl0.a.f399763a.a(dl0.h.class);
        if (hVar != null) {
            hVar.a("nativeAppStartUp", params);
        }
    }

    @Override // uk0.e
    public void onEvent(@NotNull String type, @NotNull String eventData) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        FLog.INSTANCE.i("FilamentStartUpTrack", "innerEventListener onEvent:" + type + ", data:" + eventData);
        switch (type.hashCode()) {
            case -1577124611:
                if (type.equals("onAvatarResourceReady")) {
                    this.fetchAvatarResourceStatistic = eventData;
                    return;
                }
                return;
            case -1562155939:
                if (type.equals("onAvatarInfoReady")) {
                    this.fetchCharacterInfoStatistic = eventData;
                    return;
                }
                return;
            case -1359158767:
                if (type.equals("onCostumeChange")) {
                    this.costumeChange2FirstRenderStep.l(al0.a.INSTANCE.b());
                    return;
                }
                return;
            case -978430445:
                if (type.equals("onAllResourceReady")) {
                    this.fetchAllResourceStatistic = eventData;
                    return;
                }
                return;
            case -176089020:
                if (type.equals("onBootResourceReady")) {
                    this.fetchBootResourceStatistic = eventData;
                    return;
                }
                return;
            case 1147068880:
                if (type.equals("onAnimationResourceReady")) {
                    this.fetchAnimationResourceStatistic = eventData;
                    return;
                }
                return;
            case 1483189228:
                if (type.equals("onIndirectLightResourceReady")) {
                    this.fetchIndirectLightStatistic = eventData;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
