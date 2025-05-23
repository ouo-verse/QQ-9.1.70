package ri3;

import com.tencent.mobileqq.zplan.minihome.MapMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lri3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "a", "Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "d", "()Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "mode", "", "b", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "hostUin", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "hostHaveOwnRoom", "Ljava/lang/String;", "()Ljava/lang/String;", "hostName", "<init>", "(Lcom/tencent/mobileqq/zplan/minihome/MapMode;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ri3.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class MapModeInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final MapMode mode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final Long hostUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final Boolean hostHaveOwnRoom;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String hostName;

    public MapModeInfo(MapMode mode, Long l3, Boolean bool, String str) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.mode = mode;
        this.hostUin = l3;
        this.hostHaveOwnRoom = bool;
        this.hostName = str;
    }

    /* renamed from: a, reason: from getter */
    public final Boolean getHostHaveOwnRoom() {
        return this.hostHaveOwnRoom;
    }

    /* renamed from: b, reason: from getter */
    public final String getHostName() {
        return this.hostName;
    }

    /* renamed from: c, reason: from getter */
    public final Long getHostUin() {
        return this.hostUin;
    }

    /* renamed from: d, reason: from getter */
    public final MapMode getMode() {
        return this.mode;
    }

    public int hashCode() {
        int hashCode = this.mode.hashCode() * 31;
        Long l3 = this.hostUin;
        int hashCode2 = (hashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
        Boolean bool = this.hostHaveOwnRoom;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.hostName;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "MapModeInfo(mode=" + this.mode + ", hostUin=" + this.hostUin + ", hostHaveOwnRoom=" + this.hostHaveOwnRoom + ", hostName=" + this.hostName + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MapModeInfo)) {
            return false;
        }
        MapModeInfo mapModeInfo = (MapModeInfo) other;
        return this.mode == mapModeInfo.mode && Intrinsics.areEqual(this.hostUin, mapModeInfo.hostUin) && Intrinsics.areEqual(this.hostHaveOwnRoom, mapModeInfo.hostHaveOwnRoom) && Intrinsics.areEqual(this.hostName, mapModeInfo.hostName);
    }

    public /* synthetic */ MapModeInfo(MapMode mapMode, Long l3, Boolean bool, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(mapMode, (i3 & 2) != 0 ? -1L : l3, (i3 & 4) != 0 ? Boolean.FALSE : bool, (i3 & 8) != 0 ? "\u8da3\u90bb" : str);
    }
}
