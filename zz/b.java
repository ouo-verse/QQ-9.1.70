package zz;

import UserGrowth.stFriendFeed;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {
    private static a00.b a(stSimpleMetaFeed stsimplemetafeed) {
        a00.b bVar = new a00.b();
        bVar.c(stsimplemetafeed);
        return bVar;
    }

    private static void c(a00.b bVar) {
        bVar.i(WeiShiCacheManager.O().K().contains(bVar.b()));
    }

    public static List<a00.b> b(stFriendFeed stfriendfeed) {
        if (stfriendfeed == null) {
            return Collections.emptyList();
        }
        ArrayList<stSimpleMetaFeed> arrayList = stfriendfeed.friendFeeds;
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(a(arrayList.get(0)));
            for (int i3 = 1; i3 < arrayList.size(); i3++) {
                stSimpleMetaFeed stsimplemetafeed = arrayList.get(i3);
                a00.b bVar = (a00.b) arrayList2.get(arrayList2.size() - 1);
                if (!bVar.c(stsimplemetafeed)) {
                    c(bVar);
                    a00.b a16 = a(stsimplemetafeed);
                    a16.h(i3);
                    arrayList2.add(a16);
                }
            }
            c((a00.b) arrayList2.get(arrayList2.size() - 1));
            WeiShiCacheManager.O().t(arrayList2);
            return arrayList2;
        }
        return Collections.emptyList();
    }
}
