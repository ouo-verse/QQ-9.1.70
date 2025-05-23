package qh1;

import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreType;
import com.tencent.mobileqq.guild.discoveryv2.content.model.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0010B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ1\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001J\t\u0010\u000b\u001a\u00020\bH\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\u00a8\u0006 "}, d2 = {"Lqh1/c;", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/LoadMoreType;", "loadMoreType", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/k;", "refreshType", "", "isEnd", "", "endMsg", "b", "toString", "", "hashCode", "other", "equals", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/LoadMoreType;", "e", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/model/LoadMoreType;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/k;", "f", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/model/k;", "c", "Z", "g", "()Z", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/model/LoadMoreType;Lcom/tencent/mobileqq/guild/discoveryv2/content/model/k;ZLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qh1.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class MVPFeedsRefreshUIState {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final MVPFeedsRefreshUIState f428935f = new MVPFeedsRefreshUIState(LoadMoreType.NONE, new k.RefreshFinish(true), false, "\u6682\u65e0\u66f4\u591a\u5185\u5bb9");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LoadMoreType loadMoreType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final k refreshType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isEnd;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String endMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lqh1/c$a;", "", "Lqh1/c;", com.tencent.tmdownloader.a.CONNTECTSTATE_INIT, "Lqh1/c;", "a", "()Lqh1/c;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qh1.c$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MVPFeedsRefreshUIState a() {
            return MVPFeedsRefreshUIState.f428935f;
        }

        Companion() {
        }
    }

    public MVPFeedsRefreshUIState(@NotNull LoadMoreType loadMoreType, @NotNull k refreshType, boolean z16, @NotNull String endMsg) {
        Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        Intrinsics.checkNotNullParameter(endMsg, "endMsg");
        this.loadMoreType = loadMoreType;
        this.refreshType = refreshType;
        this.isEnd = z16;
        this.endMsg = endMsg;
    }

    public static /* synthetic */ MVPFeedsRefreshUIState c(MVPFeedsRefreshUIState mVPFeedsRefreshUIState, LoadMoreType loadMoreType, k kVar, boolean z16, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            loadMoreType = mVPFeedsRefreshUIState.loadMoreType;
        }
        if ((i3 & 2) != 0) {
            kVar = mVPFeedsRefreshUIState.refreshType;
        }
        if ((i3 & 4) != 0) {
            z16 = mVPFeedsRefreshUIState.isEnd;
        }
        if ((i3 & 8) != 0) {
            str = mVPFeedsRefreshUIState.endMsg;
        }
        return mVPFeedsRefreshUIState.b(loadMoreType, kVar, z16, str);
    }

    @NotNull
    public final MVPFeedsRefreshUIState b(@NotNull LoadMoreType loadMoreType, @NotNull k refreshType, boolean isEnd, @NotNull String endMsg) {
        Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        Intrinsics.checkNotNullParameter(endMsg, "endMsg");
        return new MVPFeedsRefreshUIState(loadMoreType, refreshType, isEnd, endMsg);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getEndMsg() {
        return this.endMsg;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final LoadMoreType getLoadMoreType() {
        return this.loadMoreType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MVPFeedsRefreshUIState)) {
            return false;
        }
        MVPFeedsRefreshUIState mVPFeedsRefreshUIState = (MVPFeedsRefreshUIState) other;
        if (this.loadMoreType == mVPFeedsRefreshUIState.loadMoreType && Intrinsics.areEqual(this.refreshType, mVPFeedsRefreshUIState.refreshType) && this.isEnd == mVPFeedsRefreshUIState.isEnd && Intrinsics.areEqual(this.endMsg, mVPFeedsRefreshUIState.endMsg)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final k getRefreshType() {
        return this.refreshType;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.loadMoreType.hashCode() * 31) + this.refreshType.hashCode()) * 31;
        boolean z16 = this.isEnd;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.endMsg.hashCode();
    }

    @NotNull
    public String toString() {
        return "MVPFeedsRefreshUIState(loadMoreType=" + this.loadMoreType + ", refreshType=" + this.refreshType + ", isEnd=" + this.isEnd + ", endMsg=" + this.endMsg + ")";
    }
}
