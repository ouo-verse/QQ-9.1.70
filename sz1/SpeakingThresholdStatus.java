package sz1;

import com.tencent.mobileqq.qqguildsdk.data.cv;
import com.tencent.mobileqq.qqguildsdk.data.fc;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0014\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001\u0005BW\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u001b\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u001b\u00a2\u0006\u0004\b,\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b#\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\r\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\r\u001a\u0004\b(\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010+\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b*\u0010\u001f\"\u0004\b\u0017\u0010!\u00a8\u0006/"}, d2 = {"Lsz1/e;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/fc;", "threshold", "", "a", h.F, "", "toString", "", "hashCode", "other", "equals", "Z", "getGuildNeedRealName", "()Z", "g", "(Z)V", "guildNeedRealName", "b", "getGuildNeedJoinRole", "setGuildNeedJoinRole", "guildNeedJoinRole", "c", "getGuildIsNeedJoinTime", "e", "guildIsNeedJoinTime", "", "d", "J", "getGuildNeedJoinTime", "()J", "f", "(J)V", "guildNeedJoinTime", "getDirectMsgNeedRealName", "directMsgNeedRealName", "getDirectMsgNeedJoinRole", "setDirectMsgNeedJoinRole", "directMsgNeedJoinRole", "getDirectMsgIsNeedJoinTime", "directMsgIsNeedJoinTime", "getDirectMsgNeedJoinTime", "directMsgNeedJoinTime", "<init>", "(ZZZJZZZJ)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: sz1.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class SpeakingThresholdStatus {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean guildNeedRealName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean guildNeedJoinRole;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean guildIsNeedJoinTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long guildNeedJoinTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean directMsgNeedRealName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean directMsgNeedJoinRole;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean directMsgIsNeedJoinTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private long directMsgNeedJoinTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lsz1/e$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/fc;", "threshold", "Lsz1/e;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sz1.e$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SpeakingThresholdStatus a(@NotNull fc threshold) {
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(threshold, "threshold");
            boolean c16 = threshold.c();
            boolean f16 = threshold.f();
            if (threshold.b() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            long b16 = threshold.b();
            boolean e16 = threshold.e();
            boolean a16 = threshold.a();
            if (threshold.d() != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            return new SpeakingThresholdStatus(c16, f16, z16, b16, e16, a16, z17, threshold.d());
        }

        Companion() {
        }
    }

    public SpeakingThresholdStatus() {
        this(false, false, false, 0L, false, false, false, 0L, 255, null);
    }

    public final boolean a(@NotNull fc threshold) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(threshold, "threshold");
        if (this.guildNeedRealName != threshold.c() || this.guildNeedJoinRole != threshold.f()) {
            return false;
        }
        boolean z18 = this.guildIsNeedJoinTime;
        if (threshold.b() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z18 != z16 || this.directMsgNeedRealName != threshold.e() || this.directMsgNeedJoinRole != threshold.a()) {
            return false;
        }
        boolean z19 = this.directMsgIsNeedJoinTime;
        if (threshold.d() != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z19 != z17) {
            return false;
        }
        boolean z26 = this.guildIsNeedJoinTime;
        if (z26 && (!z26 || this.guildNeedJoinTime != threshold.b())) {
            return false;
        }
        boolean z27 = this.directMsgIsNeedJoinTime;
        if (z27 && (!z27 || this.directMsgNeedJoinTime != threshold.d())) {
            return false;
        }
        return true;
    }

    public final void b(boolean z16) {
        this.directMsgIsNeedJoinTime = z16;
    }

    public final void c(long j3) {
        this.directMsgNeedJoinTime = j3;
    }

    public final void d(boolean z16) {
        this.directMsgNeedRealName = z16;
    }

    public final void e(boolean z16) {
        this.guildIsNeedJoinTime = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpeakingThresholdStatus)) {
            return false;
        }
        SpeakingThresholdStatus speakingThresholdStatus = (SpeakingThresholdStatus) other;
        if (this.guildNeedRealName == speakingThresholdStatus.guildNeedRealName && this.guildNeedJoinRole == speakingThresholdStatus.guildNeedJoinRole && this.guildIsNeedJoinTime == speakingThresholdStatus.guildIsNeedJoinTime && this.guildNeedJoinTime == speakingThresholdStatus.guildNeedJoinTime && this.directMsgNeedRealName == speakingThresholdStatus.directMsgNeedRealName && this.directMsgNeedJoinRole == speakingThresholdStatus.directMsgNeedJoinRole && this.directMsgIsNeedJoinTime == speakingThresholdStatus.directMsgIsNeedJoinTime && this.directMsgNeedJoinTime == speakingThresholdStatus.directMsgNeedJoinTime) {
            return true;
        }
        return false;
    }

    public final void f(long j3) {
        this.guildNeedJoinTime = j3;
    }

    public final void g(boolean z16) {
        this.guildNeedRealName = z16;
    }

    @NotNull
    public final fc h() {
        cv g16 = new cv.a().m(this.guildNeedRealName).k(this.guildNeedJoinRole).l(this.guildNeedJoinTime).j(this.directMsgNeedRealName).h(this.directMsgNeedJoinRole).i(this.directMsgNeedJoinTime).g();
        Intrinsics.checkNotNullExpressionValue(g16, "Builder()\n            .g\u2026ime)\n            .build()");
        return g16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.guildNeedRealName;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.guildNeedJoinRole;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        ?? r27 = this.guildIsNeedJoinTime;
        int i19 = r27;
        if (r27 != 0) {
            i19 = 1;
        }
        int a16 = (((i18 + i19) * 31) + androidx.fragment.app.a.a(this.guildNeedJoinTime)) * 31;
        ?? r28 = this.directMsgNeedRealName;
        int i26 = r28;
        if (r28 != 0) {
            i26 = 1;
        }
        int i27 = (a16 + i26) * 31;
        ?? r29 = this.directMsgNeedJoinRole;
        int i28 = r29;
        if (r29 != 0) {
            i28 = 1;
        }
        int i29 = (i27 + i28) * 31;
        boolean z17 = this.directMsgIsNeedJoinTime;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i29 + i3) * 31) + androidx.fragment.app.a.a(this.directMsgNeedJoinTime);
    }

    @NotNull
    public String toString() {
        return "SpeakingThresholdStatus(guildNeedRealName=" + this.guildNeedRealName + ", guildNeedJoinRole=" + this.guildNeedJoinRole + ", guildIsNeedJoinTime=" + this.guildIsNeedJoinTime + ", guildNeedJoinTime=" + this.guildNeedJoinTime + ", directMsgNeedRealName=" + this.directMsgNeedRealName + ", directMsgNeedJoinRole=" + this.directMsgNeedJoinRole + ", directMsgIsNeedJoinTime=" + this.directMsgIsNeedJoinTime + ", directMsgNeedJoinTime=" + this.directMsgNeedJoinTime + ")";
    }

    public SpeakingThresholdStatus(boolean z16, boolean z17, boolean z18, long j3, boolean z19, boolean z26, boolean z27, long j16) {
        this.guildNeedRealName = z16;
        this.guildNeedJoinRole = z17;
        this.guildIsNeedJoinTime = z18;
        this.guildNeedJoinTime = j3;
        this.directMsgNeedRealName = z19;
        this.directMsgNeedJoinRole = z26;
        this.directMsgIsNeedJoinTime = z27;
        this.directMsgNeedJoinTime = j16;
    }

    public /* synthetic */ SpeakingThresholdStatus(boolean z16, boolean z17, boolean z18, long j3, boolean z19, boolean z26, boolean z27, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18, (i3 & 8) != 0 ? 0L : j3, (i3 & 16) != 0 ? false : z19, (i3 & 32) != 0 ? false : z26, (i3 & 64) == 0 ? z27 : false, (i3 & 128) == 0 ? j16 : 0L);
    }
}
