package xk;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {
    public static ArrayList<String> a(List<LocalMediaInfo> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < list.size(); i3++) {
            LocalMediaInfo localMediaInfo = list.get(i3);
            if (localMediaInfo != null) {
                arrayList.add(localMediaInfo.path);
            }
        }
        return arrayList;
    }
}
