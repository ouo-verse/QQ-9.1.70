package qy;

import com.tencent.gdtad.util.SsoReporter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lqy/a;", "", "", "c", "", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "a", SsoReporter.TAB_EXPERIMENT_KEY, "d", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "mEntityCache", "mMMKVEntityCache", "mMMKVExpHitCache", "e", "Ljava/lang/String;", "mCurrentUin", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mEntity", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f430302a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Object> mEntityCache = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Object> mMMKVEntityCache = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Object> mMMKVExpHitCache = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String mCurrentUin = "";

    a() {
    }

    private final String a(String expName) {
        return "public_account_hit_" + expName + util.base64_pad_url + mCurrentUin;
    }

    private final MMKVOptionEntityV2 b() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return fromV2;
    }

    private final void c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
        if (currentUin == null) {
            currentUin = "";
        }
        if (Intrinsics.areEqual(mCurrentUin, currentUin)) {
            return;
        }
        QLog.d("PublicAccountTabManager", 1, "reset cache uin " + mCurrentUin + " -> " + currentUin);
        mEntityCache.clear();
        mMMKVEntityCache.clear();
        mMMKVExpHitCache.clear();
        mCurrentUin = currentUin;
    }

    public final void d(String expName, String assignment) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        Intrinsics.checkNotNullParameter(assignment, "assignment");
        c();
        if (ABTestController.getInstance().isTabInited(ABTestController.APPID_1505)) {
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(expName);
            Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(expName)");
            String a16 = a(expName);
            boolean isExpHit = expEntity.isExpHit(assignment);
            expEntity.reportExpExposure();
            QLog.d("PublicAccountTabManager", 1, "uin: " + mCurrentUin + " save sdk exp " + expName + " hit info: " + isExpHit);
            b().putBoolean(a16, isExpHit);
        }
    }
}
