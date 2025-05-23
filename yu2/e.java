package yu2;

import androidx.annotation.NonNull;
import com.tencent.qqlive.ona.protocol.jce.AdInsideEmptyItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import com.tencent.qqlive.ona.protocol.jce.AdTempletItem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {
    public static List<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.b> a(ArrayList<AdTempletItem> arrayList) {
        AdInsideEmptyItem adInsideEmptyItem;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (arrayList == null) {
            return copyOnWriteArrayList;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            AdTempletItem adTempletItem = arrayList.get(i3);
            if (adTempletItem != null && adTempletItem.viewType == 3 && (adInsideEmptyItem = (AdInsideEmptyItem) b.b(adTempletItem.data, new AdInsideEmptyItem())) != null) {
                com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.b bVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.b();
                bVar.f303588b = i3;
                bVar.f303587a = adInsideEmptyItem;
                copyOnWriteArrayList.add(bVar);
            }
        }
        return copyOnWriteArrayList;
    }

    @NonNull
    public static List<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> b(ArrayList<AdTempletItem> arrayList, String str, boolean z16) {
        AdInsideVideoItem adInsideVideoItem;
        ArrayList arrayList2 = new ArrayList();
        if (arrayList == null) {
            return arrayList2;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            AdTempletItem adTempletItem = arrayList.get(i3);
            if (adTempletItem != null && adTempletItem.viewType == 4 && (adInsideVideoItem = (AdInsideVideoItem) b.b(adTempletItem.data, new AdInsideVideoItem())) != null) {
                arrayList2.add(b.a(adInsideVideoItem, str, i3, z16));
            }
        }
        return arrayList2;
    }
}
