package vk2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\u0012\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lvk2/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "curType", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "troopUin", "c", "curFriendUin", "Z", "()Z", "inGuildLive", "<init>", "(ILjava/lang/String;Ljava/lang/String;Z)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vk2.e, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class QWalletSessionInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int curType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String curFriendUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean inGuildLive;

    public QWalletSessionInfo(int i3, @NotNull String troopUin, @NotNull String curFriendUin, boolean z16) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        this.curType = i3;
        this.troopUin = troopUin;
        this.curFriendUin = curFriendUin;
        this.inGuildLive = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCurFriendUin() {
        return this.curFriendUin;
    }

    /* renamed from: b, reason: from getter */
    public final int getCurType() {
        return this.curType;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getInGuildLive() {
        return this.inGuildLive;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QWalletSessionInfo)) {
            return false;
        }
        QWalletSessionInfo qWalletSessionInfo = (QWalletSessionInfo) other;
        if (this.curType == qWalletSessionInfo.curType && Intrinsics.areEqual(this.troopUin, qWalletSessionInfo.troopUin) && Intrinsics.areEqual(this.curFriendUin, qWalletSessionInfo.curFriendUin) && this.inGuildLive == qWalletSessionInfo.inGuildLive) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.curType * 31) + this.troopUin.hashCode()) * 31) + this.curFriendUin.hashCode()) * 31;
        boolean z16 = this.inGuildLive;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "QWalletSessionInfo(curType=" + this.curType + ", troopUin=" + this.troopUin + ", curFriendUin=" + this.curFriendUin + ", inGuildLive=" + this.inGuildLive + ')';
    }
}
