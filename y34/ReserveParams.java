package y34;

import com.tencent.robot.discoveryv2.common.reserve.ReserveViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Ly34/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "uin", "Lcom/tencent/robot/discoveryv2/common/reserve/ReserveViewModel;", "b", "Lcom/tencent/robot/discoveryv2/common/reserve/ReserveViewModel;", "()Lcom/tencent/robot/discoveryv2/common/reserve/ReserveViewModel;", "viewModel", "<init>", "(Ljava/lang/String;Lcom/tencent/robot/discoveryv2/common/reserve/ReserveViewModel;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: y34.f, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class ReserveParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ReserveViewModel viewModel;

    public ReserveParams(@NotNull String uin, @NotNull ReserveViewModel viewModel) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.uin = uin;
        this.viewModel = viewModel;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ReserveViewModel getViewModel() {
        return this.viewModel;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReserveParams)) {
            return false;
        }
        ReserveParams reserveParams = (ReserveParams) other;
        if (Intrinsics.areEqual(this.uin, reserveParams.uin) && Intrinsics.areEqual(this.viewModel, reserveParams.viewModel)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.uin.hashCode() * 31) + this.viewModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "ReserveParams(uin=" + this.uin + ", viewModel=" + this.viewModel + ")";
    }
}
