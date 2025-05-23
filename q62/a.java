package q62;

import android.util.Pair;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    public static Pair<Integer, Integer> a(Pair<Integer, Integer>[] pairArr, int i3, int i16) {
        int length = pairArr.length;
        double d16 = 1.0d;
        double d17 = (i16 * 1.0d) / i3;
        double d18 = Double.MAX_VALUE;
        Pair<Integer, Integer> pair = null;
        int i17 = 0;
        while (i17 < length) {
            double intValue = ((((Integer) pairArr[i17].second).intValue() * d16) / ((Integer) pairArr[i17].first).intValue()) - d17;
            double abs = Math.abs(intValue);
            if (abs < d18) {
                d18 = Math.abs(intValue);
                pair = pairArr[i17];
            } else if (abs == d18 && pair != null) {
                if (Math.abs(((Integer) pair.second).intValue() - i16) + Math.abs(((Integer) pair.first).intValue() - i3) > Math.abs(((Integer) pairArr[i17].second).intValue() - i16) + Math.abs(((Integer) pairArr[i17].first).intValue() - i3)) {
                    double abs2 = Math.abs(intValue);
                    pair = pairArr[i17];
                    d18 = abs2;
                }
            }
            i17++;
            d16 = 1.0d;
        }
        return pair;
    }
}
