package zb3;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.zootopia.data.ZootopiaTConnAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\t\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lzb3/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getSceneId", "()I", WadlProxyConsts.SCENE_ID, "", "b", "J", "()J", "roomId", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "token", "", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaTConnAddress;", "d", "Ljava/util/List;", "()Ljava/util/List;", "addressList", "<init>", "(IJLjava/lang/String;Ljava/util/List;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zb3.f, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaEnterRoomData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String token;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ZootopiaTConnAddress> addressList;

    public ZootopiaEnterRoomData(int i3, long j3, String token, List<ZootopiaTConnAddress> addressList) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(addressList, "addressList");
        this.sceneId = i3;
        this.roomId = j3;
        this.token = token;
        this.addressList = addressList;
    }

    public final List<ZootopiaTConnAddress> a() {
        return this.addressList;
    }

    /* renamed from: b, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: c, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (((((this.sceneId * 31) + com.tencent.mobileqq.vas.banner.c.a(this.roomId)) * 31) + this.token.hashCode()) * 31) + this.addressList.hashCode();
    }

    public String toString() {
        return "ZootopiaEnterRoomData(sceneId=" + this.sceneId + ", roomId=" + this.roomId + ", token=" + this.token + ", addressList=" + this.addressList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaEnterRoomData)) {
            return false;
        }
        ZootopiaEnterRoomData zootopiaEnterRoomData = (ZootopiaEnterRoomData) other;
        return this.sceneId == zootopiaEnterRoomData.sceneId && this.roomId == zootopiaEnterRoomData.roomId && Intrinsics.areEqual(this.token, zootopiaEnterRoomData.token) && Intrinsics.areEqual(this.addressList, zootopiaEnterRoomData.addressList);
    }
}
