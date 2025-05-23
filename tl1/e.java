package tl1;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Ltl1/e;", "", "", "needReport", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f436522a = new e();

    e() {
    }

    public static /* synthetic */ boolean[] b(e eVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return eVar.a(z16);
    }

    @NotNull
    public final boolean[] a(boolean needReport) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_qq_pingdao_xiangqingye_entry");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026INGDAO_XIANGQINGYE_ENTRY)");
        if (needReport) {
            expEntity.reportExpExposure();
        }
        QLog.d("NativeDetailABTestUtils", 1, "getGPEEVars|" + expEntity.getAssignment());
        if (expEntity.isExperiment("exp_qq_pingdao_xiangqingye_entry_A")) {
            return new boolean[]{false, false, false};
        }
        if (expEntity.isExperiment("exp_qq_pingdao_xiangqingye_entry_B")) {
            return new boolean[]{true, true, false};
        }
        if (expEntity.isExperiment("exp_qq_pingdao_xiangqingye_entry_C")) {
            return new boolean[]{false, false, true};
        }
        if (expEntity.isExperiment("exp_qq_pingdao_xiangqingye_entry_D")) {
            return new boolean[]{true, true, true};
        }
        return new boolean[]{false, false, false};
    }
}
