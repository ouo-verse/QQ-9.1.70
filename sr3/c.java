package sr3;

import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.qmethod.pandoraex.api.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lsr3/c;", "Lsr3/b;", "", "c", "module", "apiName", "Lcom/tencent/qmethod/pandoraex/api/v;", TransferConfig.ExtendParamFloats.KEY_RULE, "", "e", "<init>", "()V", "d", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class c extends b {
    @Override // sr3.b
    @NotNull
    public String c() {
        return "CanaryReportController";
    }

    @Override // sr3.b
    public boolean e(@NotNull String module, @NotNull String apiName, @NotNull v rule) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(apiName, "apiName");
        Intrinsics.checkParameterIsNotNull(rule, "rule");
        return dr3.a.f394686a.a();
    }
}
