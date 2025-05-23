package rt2;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectfriend.relationlist.d;
import com.tencent.mobileqq.selectfriend.relationlist.vm.ListType;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import st2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\rB\u001f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J,\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u001a\u0010\u0012\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lrt2/a;", "Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "", "Lcom/tencent/mobileqq/selectfriend/relationlist/d;", "e", "", "categoryId", "f", "Lcom/tencent/mobileqq/selectfriend/relationlist/vm/ListType;", "b", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "sharedNode", "Landroid/graphics/drawable/Drawable;", "a", "", "fromNet", "Lkotlin/Function1;", "", "callback", "c", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", "getConfig", "()Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Ljava/util/List;", "allTroopsList", "<init>", "(Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;Ljava/util/List;)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends com.tencent.mobileqq.selectfriend.relationlist.model.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final TroopSelectorConfig config;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<TroopInfo> allTroopsList;

    /* JADX WARN: Multi-variable type inference failed */
    public a(TroopSelectorConfig troopSelectorConfig, List<? extends TroopInfo> allTroopsList) {
        Intrinsics.checkNotNullParameter(allTroopsList, "allTroopsList");
        this.config = troopSelectorConfig;
        this.allTroopsList = allTroopsList;
    }

    private final List<d> e() {
        List<d> list;
        d f16;
        d f17;
        d f18;
        ArrayList arrayList = new ArrayList();
        TroopSelectorConfig troopSelectorConfig = this.config;
        boolean z16 = false;
        if ((troopSelectorConfig != null && troopSelectorConfig.f()) && (f18 = f(1)) != null) {
            arrayList.add(f18);
        }
        TroopSelectorConfig troopSelectorConfig2 = this.config;
        if ((troopSelectorConfig2 != null && troopSelectorConfig2.j()) && (f17 = f(2)) != null) {
            arrayList.add(f17);
        }
        TroopSelectorConfig troopSelectorConfig3 = this.config;
        if (troopSelectorConfig3 != null && troopSelectorConfig3.g()) {
            z16 = true;
        }
        if (z16 && (f16 = f(3)) != null) {
            arrayList.add(f16);
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.model.a
    public Drawable a(SharedNode sharedNode) {
        Intrinsics.checkNotNullParameter(sharedNode, "sharedNode");
        return null;
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.model.a
    public ListType b() {
        return ListType.GROUPED;
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.model.a
    public void c(boolean fromNet, Function1<? super List<d>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(e());
    }

    private final d f(int categoryId) {
        if (categoryId == 1) {
            d dVar = new d(null, null, (byte) 0, null, 15, null);
            dVar.d(HardCodeUtil.qqStr(R.string.f20671592));
            List<TroopInfo> list = this.allTroopsList;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                TroopInfo troopInfo = (TroopInfo) obj;
                if (troopInfo.isOwner() && !troopInfo.isTroopBlocked) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                dVar.c().add(b.f434715a.b((TroopInfo) it.next()));
            }
            dVar.e(String.valueOf(arrayList.size()));
            return dVar;
        }
        if (categoryId == 2) {
            d dVar2 = new d(null, null, (byte) 0, null, 15, null);
            dVar2.d(HardCodeUtil.qqStr(R.string.f20673594));
            List<TroopInfo> list2 = this.allTroopsList;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                TroopInfo troopInfo2 = (TroopInfo) obj2;
                if (troopInfo2.isAdmin() && !troopInfo2.isTroopBlocked) {
                    arrayList2.add(obj2);
                }
            }
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                dVar2.c().add(b.f434715a.b((TroopInfo) it5.next()));
            }
            dVar2.e(String.valueOf(arrayList2.size()));
            return dVar2;
        }
        if (categoryId != 3) {
            return null;
        }
        d dVar3 = new d(null, null, (byte) 0, null, 15, null);
        dVar3.d(HardCodeUtil.qqStr(R.string.f20672593));
        List<TroopInfo> list3 = this.allTroopsList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list3) {
            TroopInfo troopInfo3 = (TroopInfo) obj3;
            if ((troopInfo3.isAdmin() || troopInfo3.isOwner() || troopInfo3.isTroopBlocked) ? false : true) {
                arrayList3.add(obj3);
            }
        }
        Iterator it6 = arrayList3.iterator();
        while (it6.hasNext()) {
            dVar3.c().add(b.f434715a.b((TroopInfo) it6.next()));
        }
        dVar3.e(String.valueOf(arrayList3.size()));
        return dVar3;
    }
}
