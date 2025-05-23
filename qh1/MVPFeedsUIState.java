package qh1;

import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh1.d;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0011B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b#\u0010$J1\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\"\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lqh1/e;", "", "Lri1/a;", "success", "Lqh1/c;", "refreshState", "Lqh1/b;", "listState", "", QCircleLpReportDc05507.KEY_CLEAR, "b", "", "toString", "", "hashCode", "other", "equals", "a", "Lri1/a;", "g", "()Lri1/a;", "Lqh1/c;", "e", "()Lqh1/c;", "c", "Lqh1/b;", "d", "()Lqh1/b;", "Z", "getClear", "()Z", "Lqh1/d;", "f", "()Lqh1/d;", "reserveUIState", "<init>", "(Lri1/a;Lqh1/c;Lqh1/b;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qh1.e, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class MVPFeedsUIState {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final MVPFeedsUIState f428942f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ri1.a success;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MVPFeedsRefreshUIState refreshState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MVPFeedsListUIState listState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean clear;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lqh1/e$a;", "", "Lqh1/e;", com.tencent.tmdownloader.a.CONNTECTSTATE_INIT, "Lqh1/e;", "a", "()Lqh1/e;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qh1.e$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MVPFeedsUIState a() {
            return MVPFeedsUIState.f428942f;
        }

        Companion() {
        }
    }

    static {
        ri1.a a16 = ri1.a.a(-1);
        Intrinsics.checkNotNullExpressionValue(a16, "error(GProStateCode.TYPE_DEFAULT_VALUE)");
        f428942f = new MVPFeedsUIState(a16, MVPFeedsRefreshUIState.INSTANCE.a(), MVPFeedsListUIState.INSTANCE.a(), false, 8, null);
    }

    public MVPFeedsUIState(@NotNull ri1.a success, @NotNull MVPFeedsRefreshUIState refreshState, @NotNull MVPFeedsListUIState listState, boolean z16) {
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(refreshState, "refreshState");
        Intrinsics.checkNotNullParameter(listState, "listState");
        this.success = success;
        this.refreshState = refreshState;
        this.listState = listState;
        this.clear = z16;
    }

    public static /* synthetic */ MVPFeedsUIState c(MVPFeedsUIState mVPFeedsUIState, ri1.a aVar, MVPFeedsRefreshUIState mVPFeedsRefreshUIState, MVPFeedsListUIState mVPFeedsListUIState, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aVar = mVPFeedsUIState.success;
        }
        if ((i3 & 2) != 0) {
            mVPFeedsRefreshUIState = mVPFeedsUIState.refreshState;
        }
        if ((i3 & 4) != 0) {
            mVPFeedsListUIState = mVPFeedsUIState.listState;
        }
        if ((i3 & 8) != 0) {
            z16 = mVPFeedsUIState.clear;
        }
        return mVPFeedsUIState.b(aVar, mVPFeedsRefreshUIState, mVPFeedsListUIState, z16);
    }

    @NotNull
    public final MVPFeedsUIState b(@NotNull ri1.a success, @NotNull MVPFeedsRefreshUIState refreshState, @NotNull MVPFeedsListUIState listState, boolean clear) {
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(refreshState, "refreshState");
        Intrinsics.checkNotNullParameter(listState, "listState");
        return new MVPFeedsUIState(success, refreshState, listState, clear);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final MVPFeedsListUIState getListState() {
        return this.listState;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final MVPFeedsRefreshUIState getRefreshState() {
        return this.refreshState;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MVPFeedsUIState)) {
            return false;
        }
        MVPFeedsUIState mVPFeedsUIState = (MVPFeedsUIState) other;
        if (Intrinsics.areEqual(this.success, mVPFeedsUIState.success) && Intrinsics.areEqual(this.refreshState, mVPFeedsUIState.refreshState) && Intrinsics.areEqual(this.listState, mVPFeedsUIState.listState) && this.clear == mVPFeedsUIState.clear) {
            return true;
        }
        return false;
    }

    @NotNull
    public final d f() {
        if (!this.listState.d().isEmpty()) {
            return d.c.f428940a;
        }
        if (this.refreshState.getRefreshType().getRefreshing()) {
            return new d.C11077d();
        }
        if (!this.success.d()) {
            return new d.b();
        }
        if (this.listState.d().isEmpty()) {
            return new d.a();
        }
        return d.c.f428940a;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final ri1.a getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.success.hashCode() * 31) + this.refreshState.hashCode()) * 31) + this.listState.hashCode()) * 31;
        boolean z16 = this.clear;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "MVPFeedsUIState(success=" + this.success + ", refreshState=" + this.refreshState + ", listState=" + this.listState + ", clear=" + this.clear + ")";
    }

    public /* synthetic */ MVPFeedsUIState(ri1.a aVar, MVPFeedsRefreshUIState mVPFeedsRefreshUIState, MVPFeedsListUIState mVPFeedsListUIState, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, mVPFeedsRefreshUIState, mVPFeedsListUIState, (i3 & 8) != 0 ? false : z16);
    }
}
