package rs0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lrs0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tinyId", "nickName", "c", "Z", "()Z", "isGuest", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "aio-guild-live-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rs0.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class LiveUserEnterTipsModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nickName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isGuest;

    public LiveUserEnterTipsModel(@NotNull String tinyId, @NotNull String nickName, boolean z16) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        this.tinyId = tinyId;
        this.nickName = nickName;
        this.isGuest = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsGuest() {
        return this.isGuest;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveUserEnterTipsModel)) {
            return false;
        }
        LiveUserEnterTipsModel liveUserEnterTipsModel = (LiveUserEnterTipsModel) other;
        if (Intrinsics.areEqual(this.tinyId, liveUserEnterTipsModel.tinyId) && Intrinsics.areEqual(this.nickName, liveUserEnterTipsModel.nickName) && this.isGuest == liveUserEnterTipsModel.isGuest) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.tinyId.hashCode() * 31) + this.nickName.hashCode()) * 31;
        boolean z16 = this.isGuest;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "LiveUserEnterTipsModel(tinyId=" + this.tinyId + ", nickName=" + this.nickName + ", isGuest=" + this.isGuest + ")";
    }
}
