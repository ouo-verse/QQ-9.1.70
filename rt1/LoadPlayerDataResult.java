package rt1;

import com.tencent.mobileqq.guild.media.core.data.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lrt1/c;", "", "", "a", "b", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "c", "", "toString", "hashCode", "other", "", "equals", "I", "getPlayerNumInCache", "()I", "playerNumInCache", "getViewerNumInCache", "viewerNumInCache", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "getTailPlayerInfo", "()Lcom/tencent/mobileqq/guild/media/core/data/p;", "tailPlayerInfo", "<init>", "(IILcom/tencent/mobileqq/guild/media/core/data/p;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rt1.c, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class LoadPlayerDataResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int playerNumInCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int viewerNumInCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final p tailPlayerInfo;

    public LoadPlayerDataResult(int i3, int i16, @Nullable p pVar) {
        this.playerNumInCache = i3;
        this.viewerNumInCache = i16;
        this.tailPlayerInfo = pVar;
    }

    /* renamed from: a, reason: from getter */
    public final int getPlayerNumInCache() {
        return this.playerNumInCache;
    }

    /* renamed from: b, reason: from getter */
    public final int getViewerNumInCache() {
        return this.viewerNumInCache;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final p getTailPlayerInfo() {
        return this.tailPlayerInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadPlayerDataResult)) {
            return false;
        }
        LoadPlayerDataResult loadPlayerDataResult = (LoadPlayerDataResult) other;
        if (this.playerNumInCache == loadPlayerDataResult.playerNumInCache && this.viewerNumInCache == loadPlayerDataResult.viewerNumInCache && Intrinsics.areEqual(this.tailPlayerInfo, loadPlayerDataResult.tailPlayerInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = ((this.playerNumInCache * 31) + this.viewerNumInCache) * 31;
        p pVar = this.tailPlayerInfo;
        if (pVar == null) {
            hashCode = 0;
        } else {
            hashCode = pVar.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        return "LoadPlayerDataResult(playerNumInCache=" + this.playerNumInCache + ", viewerNumInCache=" + this.viewerNumInCache + ", tailPlayerInfo=" + this.tailPlayerInfo + ")";
    }
}
