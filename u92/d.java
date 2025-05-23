package u92;

import android.os.Bundle;
import com.tencent.cache.api.Business;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newnearby.servlet.ServletObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.nowsummarycard.NowSummaryCard$MiniCard;
import com.tencent.nowsummarycard.NowSummaryCard$NearbyMiniCardReq;
import com.tencent.nowsummarycard.NowSummaryCard$NearbyMiniCardRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d implements Manager, b {

    /* renamed from: e, reason: collision with root package name */
    private static final com.tencent.cache.api.collection.a<String, NowSummaryCard$MiniCard> f438581e = new com.tencent.cache.api.collection.a<>(Business.Leba, "MiniCard", 250);

    /* renamed from: d, reason: collision with root package name */
    public QQAppInterface f438582d;

    public d(QQAppInterface qQAppInterface) {
        this.f438582d = qQAppInterface;
    }

    public static boolean d(String str) {
        return f438581e.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<NowSummaryCard$MiniCard> e(List<Long> list) {
        NowSummaryCard$MiniCard nowSummaryCard$MiniCard;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                String valueOf = String.valueOf(it.next().longValue());
                com.tencent.cache.api.collection.a<String, NowSummaryCard$MiniCard> aVar = f438581e;
                if (aVar.b(valueOf)) {
                    nowSummaryCard$MiniCard = aVar.e(valueOf);
                } else {
                    nowSummaryCard$MiniCard = new NowSummaryCard$MiniCard();
                }
                arrayList.add(nowSummaryCard$MiniCard);
            }
        }
        return arrayList;
    }

    private static List<Long> f(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                if (!d(String.valueOf(longValue))) {
                    arrayList.add(Long.valueOf(longValue));
                }
            }
        }
        return arrayList;
    }

    public static NowSummaryCard$MiniCard g(String str) {
        return f438581e.e(str);
    }

    public static void h(String str, Object obj) {
        f438581e.f(str, (NowSummaryCard$MiniCard) obj);
    }

    @Override // u92.b
    public void a(List<Long> list, int i3, u92.a aVar) {
        List<Long> f16 = f(list);
        if (f16 != null && !f16.isEmpty()) {
            NowSummaryCard$NearbyMiniCardReq nowSummaryCard$NearbyMiniCardReq = new NowSummaryCard$NearbyMiniCardReq();
            nowSummaryCard$NearbyMiniCardReq.target_id.set(f16);
            nowSummaryCard$NearbyMiniCardReq.id_type.set(i3);
            com.tencent.mobileqq.newnearby.servlet.b.a(new a(aVar, f16, list), nowSummaryCard$NearbyMiniCardReq.toByteArray(), "NowSummaryCard.NearbyMiniCardReq");
            return;
        }
        try {
            aVar.a(0, e(list), "");
        } catch (AbstractMethodError e16) {
            QLog.e("MiniCardManager", 2, "getMiniCardList fail: " + e16.getMessage());
        }
    }

    public void i() {
        f438581e.d();
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        i();
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a extends ServletObserver {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ u92.a f438583f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f438584h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f438585i;

        a(u92.a aVar, List list, List list2) {
            this.f438583f = aVar;
            this.f438584h = list;
            this.f438585i = list2;
        }

        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        public void c(int i3, byte[] bArr, Bundle bundle) {
            if (i3 != 0) {
                u92.a aVar = this.f438583f;
                if (aVar != null) {
                    aVar.a(i3, null, "Request error.");
                    return;
                }
                return;
            }
            NowSummaryCard$NearbyMiniCardRsp nowSummaryCard$NearbyMiniCardRsp = new NowSummaryCard$NearbyMiniCardRsp();
            try {
                nowSummaryCard$NearbyMiniCardRsp.mergeFrom(bArr);
                List<NowSummaryCard$MiniCard> list = nowSummaryCard$NearbyMiniCardRsp.mini_card.get();
                QLog.d("MiniCardManager", 1, "getMiniCardList size: " + list.size() + ", retCode: " + nowSummaryCard$NearbyMiniCardRsp.ret_code.get());
                synchronized (d.f438581e) {
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        d.f438581e.f(String.valueOf(this.f438584h.get(i16)), list.get(i16));
                    }
                }
                if (this.f438583f != null) {
                    try {
                        this.f438583f.a(i3, d.e(this.f438585i), "");
                    } catch (AbstractMethodError e16) {
                        QLog.e("MiniCardManager", 2, "getMiniCardList fail: " + e16.getMessage());
                    }
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                if (this.f438583f != null) {
                    this.f438583f.a(1, null, "" + e17);
                }
                QLog.e("MiniCardManager", 1, "getMiniCardList error: " + e17);
            }
        }
    }
}
