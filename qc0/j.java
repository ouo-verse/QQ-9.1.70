package qc0;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J#\u0010\b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lqc0/j;", "", "", "b", "c", "", "", "expectedAssignments", "a", "([Ljava/lang/String;)Z", "d", "e", "f", "", "g", "Z", "isInitExpAssignment", "Ljava/lang/String;", "expAssignment", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isInitExpAssignment;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f428831a = new j();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String expAssignment = "";

    j() {
    }

    private final boolean a(String... expectedAssignments) {
        boolean contains;
        if (!isInitExpAssignment) {
            isInitExpAssignment = true;
            String a16 = com.tencent.biz.qqcircle.utils.k.a("exp_pymkpromote");
            Intrinsics.checkNotNullExpressionValue(a16, "getAssignment(QCircleABT\u2026nstants.EXP_PYMK_PROMOTE)");
            expAssignment = a16;
        }
        contains = ArraysKt___ArraysKt.contains(expectedAssignments, expAssignment);
        return contains;
    }

    private final boolean b() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enable_pymk_promote", true);
    }

    private final boolean c() {
        if (AppSetting.isGrayVersion()) {
            QLog.d("QFSPYMKRecommendExpController", 4, "isGrayVersion show feat.");
            return true;
        }
        return false;
    }

    public final boolean d() {
        if (b() && (c() || a("exp_pymkpromote_B", "exp_pymkpromote_C", "exp_pymkpromote_D", "exp_pymkpromote_E"))) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (b() && (c() || a("exp_pymkpromote_B", "exp_pymkpromote_C"))) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (b() && (c() || a("exp_pymkpromote_D", "exp_pymkpromote_E"))) {
            return true;
        }
        return false;
    }

    public final void g() {
        isInitExpAssignment = false;
    }
}
