package xp3;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.appauth_comm$AuthGroupTuple;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lxp3/d;", "", "", "serverId", "", "Ltencent/im/oidb/appauth_comm$AuthGroupTuple;", "a", "", "b", "Ljava/util/Map;", "authGroupDataMap", "<init>", "()V", "opensdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f448293a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, List<appauth_comm$AuthGroupTuple>> authGroupDataMap;

    static {
        List listOf;
        Map<Integer, List<appauth_comm$AuthGroupTuple>> mapOf;
        appauth_comm$AuthGroupTuple appauth_comm_authgrouptuple = new appauth_comm$AuthGroupTuple();
        appauth_comm_authgrouptuple.auth_group_type.set(0);
        appauth_comm_authgrouptuple.auth_group_id.set(3006);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(appauth_comm_authgrouptuple);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(3006, listOf));
        authGroupDataMap = mapOf;
    }

    d() {
    }

    @JvmStatic
    @Nullable
    public static final List<appauth_comm$AuthGroupTuple> a(int serverId) {
        return authGroupDataMap.get(Integer.valueOf(serverId));
    }
}
