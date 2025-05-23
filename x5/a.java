package x5;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<Long, List<BusinessFeedData>> f447215a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static long f447216b = 0;

    public static void a(BusinessFeedData businessFeedData) {
        long j3 = businessFeedData.getUser().uin;
        if (j3 == 0) {
            return;
        }
        f447216b = j3;
        if (f447215a.containsKey(Long.valueOf(j3))) {
            f447215a.get(Long.valueOf(j3)).add(businessFeedData);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(businessFeedData);
        f447215a.put(Long.valueOf(j3), arrayList);
    }
}
