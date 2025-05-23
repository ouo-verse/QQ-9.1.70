package u03;

import com.tencent.cachedrawable.dynamicdrawable.report.a;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.VasNtToggle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lu03/e;", "Lcom/tencent/cachedrawable/dynamicdrawable/business/report/b;", "Lcom/tencent/cachedrawable/dynamicdrawable/report/a$a;", "data", "", "a", "", "Z", "isEnable", "()Z", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e implements com.tencent.cachedrawable.dynamicdrawable.business.report.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isEnable = VasNtToggle.VAS_DYNAMIC_REPORT.isEnable(false);

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.report.b
    public void a(@NotNull a.C1007a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.isEnable) {
            ReportInfo.report$default(VasNtCommonReporter.getDynamicDrawable().setNum1(data.b()).setNum2(data.c()).setNum3(data.i()), false, 1, null);
        }
    }
}
