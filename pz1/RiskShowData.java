package pz1;

import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lpz1/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/State;", "a", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/State;", "b", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/State;", "c", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/State;)V", "state", "", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/e;", "Ljava/util/List;", "()Ljava/util/List;", "setRiskList", "(Ljava/util/List;)V", "riskList", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/State;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pz1.f, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class RiskShowData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private State state;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<? extends com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e> riskList;

    public RiskShowData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e> a() {
        return this.riskList;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final State getState() {
        return this.state;
    }

    public final void c(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.state = state;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RiskShowData)) {
            return false;
        }
        RiskShowData riskShowData = (RiskShowData) other;
        if (this.state == riskShowData.state && Intrinsics.areEqual(this.riskList, riskShowData.riskList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.state.hashCode() * 31) + this.riskList.hashCode();
    }

    @NotNull
    public String toString() {
        return "RiskShowData(state=" + this.state + ", riskList=" + this.riskList + ")";
    }

    public RiskShowData(@NotNull State state, @NotNull List<? extends com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e> riskList) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(riskList, "riskList");
        this.state = state;
        this.riskList = riskList;
    }

    public /* synthetic */ RiskShowData(State state, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? State.IDLE : state, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
