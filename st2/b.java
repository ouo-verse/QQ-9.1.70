package st2;

import androidx.collection.ArrayMap;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.troop.adapter.contact.d;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J/\u0010\f\u001a\u00020\n2'\u0010\u000b\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0015"}, d2 = {"Lst2/b;", "", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfoList", "f", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dataList", "", "innerCallback", "d", "troopInfo", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "b", "", "troopUin", "c", "<init>", "()V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f434715a = new b();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(Function1 innerCallback, List troopInfoList, ArrayMap troopInfoMap, int i3, String str, ArrayList foundContacts, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(innerCallback, "$innerCallback");
        Intrinsics.checkNotNullParameter(troopInfoList, "$troopInfoList");
        Intrinsics.checkNotNullParameter(troopInfoMap, "$troopInfoMap");
        Intrinsics.checkNotNullExpressionValue(foundContacts, "foundContacts");
        Iterator it = foundContacts.iterator();
        while (it.hasNext()) {
            RecentContactInfo recentContactInfo = (RecentContactInfo) it.next();
            TroopInfo troopInfo = (TroopInfo) troopInfoMap.get(recentContactInfo.peerUid);
            long j3 = recentContactInfo.msgTime;
            if (troopInfo != null && j3 != troopInfo.lastMsgTime) {
                troopInfo.lastMsgTime = j3;
            }
        }
        innerCallback.invoke(f434715a.f(troopInfoList));
    }

    private final List<TroopInfo> f(List<? extends TroopInfo> troopInfoList) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TroopInfo troopInfo : troopInfoList) {
            arrayList.add(new d(troopInfo.troopmask.ordinal(), troopInfo));
        }
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new com.tencent.mobileqq.troop.adapter.contact.b());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object obj = ((d) it.next()).f293809b;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.data.troop.TroopInfo");
            arrayList2.add((TroopInfo) obj);
        }
        return arrayList2;
    }

    public final SharedNode b(TroopInfo troopInfo) {
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        String troopUin = troopInfo.getTroopUin();
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopInfo.troopUin");
        String valueOf = String.valueOf(troopInfo.getMemberNum());
        String troopDisplayName = troopInfo.getTroopDisplayName();
        Intrinsics.checkNotNullExpressionValue(troopDisplayName, "troopInfo.troopDisplayName");
        return new SharedNode(troopUin, "1", "", valueOf, 4, troopDisplayName, false, false, troopInfo);
    }

    public final SharedNode c(String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        String valueOf = String.valueOf(troopInfoFromCache != null ? Integer.valueOf(troopInfoFromCache.getMemberNum()) : null);
        String troopDisplayName = troopInfoFromCache != null ? troopInfoFromCache.getTroopDisplayName() : null;
        return new SharedNode(troopUin, "1", "", valueOf, 4, troopDisplayName == null ? "" : troopDisplayName, false, false, troopInfoFromCache != null ? troopInfoFromCache : "");
    }

    public final void d(final Function1<? super List<? extends TroopInfo>, Unit> innerCallback) {
        Intrinsics.checkNotNullParameter(innerCallback, "innerCallback");
        final List<TroopInfo> sortedJoinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getSortedJoinedTroopInfoFromCache();
        aa recentContactService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        if (recentContactService == null) {
            innerCallback.invoke(sortedJoinedTroopInfoFromCache);
            return;
        }
        ArrayList arrayList = new ArrayList();
        final ArrayMap arrayMap = new ArrayMap();
        for (TroopInfo troopInfo : sortedJoinedTroopInfoFromCache) {
            arrayMap.put(troopInfo.getTroopUin(), troopInfo);
            arrayList.add(new Contact(2, troopInfo.getTroopUin(), ""));
        }
        if (!arrayList.isEmpty()) {
            recentContactService.d(arrayList, new IGetContactsCallback() { // from class: st2.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
                public final void onResult(int i3, String str, ArrayList arrayList2, ArrayList arrayList3) {
                    b.e(Function1.this, sortedJoinedTroopInfoFromCache, arrayMap, i3, str, arrayList2, arrayList3);
                }
            });
        } else {
            innerCallback.invoke(sortedJoinedTroopInfoFromCache);
        }
    }
}
