package wt2;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lwt2/a;", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "a", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f446500a = new a();

    a() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(TroopInfo troopInfo) {
        Long longOrNull;
        if (troopInfo == null || (r1 = troopInfo.getTroopUin()) == null || longOrNull == null) {
            return false;
        }
        return troopInfo.isOwnerOrAdmin() && ((ITroopShortcutApi) QRoute.api(ITroopShortcutApi.class)).getUseNewSwitch(longOrNull.longValue());
    }
}
