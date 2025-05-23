package yw2;

import com.tencent.mobileqq.R;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Integer, Integer> f451366a;

    static {
        HashMap hashMap = new HashMap();
        f451366a = hashMap;
        hashMap.put(Integer.valueOf(R.id.xlj), 3);
        f451366a.put(Integer.valueOf(R.id.tba), 1);
        f451366a.put(Integer.valueOf(R.id.taz), 2);
        f451366a.put(Integer.valueOf(R.id.t_0), 4);
        f451366a.put(Integer.valueOf(R.id.f29790ml), 15);
        f451366a.put(Integer.valueOf(R.id.f29810mn), 5);
        f451366a.put(Integer.valueOf(R.id.xli), 2);
        f451366a.put(Integer.valueOf(R.id.klf), 6);
        f451366a.put(Integer.valueOf(R.id.f100115rm), 1);
        f451366a.put(Integer.valueOf(R.id.t_1), 4);
        f451366a.put(Integer.valueOf(R.id.f29820mo), 5);
        f451366a.put(Integer.valueOf(R.id.xla), 14);
        f451366a.put(Integer.valueOf(R.id.xl_), 7);
        f451366a.put(Integer.valueOf(R.id.xld), 8);
        f451366a.put(Integer.valueOf(R.id.xlc), 9);
        f451366a.put(Integer.valueOf(R.id.xl9), 10);
        f451366a.put(Integer.valueOf(R.id.xl6), 11);
        f451366a.put(Integer.valueOf(R.id.f29800mm), 16);
    }

    public static int a(int i3) {
        Integer num = f451366a.get(Integer.valueOf(i3));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
