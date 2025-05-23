package x52;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    private static void a(List<Integer> list, char[] cArr, char[] cArr2, int i3, int i16, int i17, int i18) {
        int i19;
        int i26 = i16 - i3;
        int i27 = i18 - i17;
        int max = Math.max(i26, i27);
        if (i26 == i27) {
            c(list, max, 0);
            return;
        }
        int i28 = i26 + 1;
        int i29 = i27 + 1;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i28, i29);
        for (int i36 = 0; i36 < i28; i36++) {
            iArr[i36][0] = i36;
        }
        for (int i37 = 0; i37 < i29; i37++) {
            iArr[0][i37] = i37;
        }
        for (int i38 = 1; i38 < i28; i38++) {
            for (int i39 = 1; i39 < i29; i39++) {
                int i46 = i38 - 1;
                int i47 = i39 - 1;
                if (cArr[i46 + i3] == cArr2[i47 + i17]) {
                    i19 = 0;
                } else {
                    i19 = 1;
                }
                int[] iArr2 = iArr[i38];
                int[] iArr3 = iArr[i46];
                iArr2[i39] = e(iArr3[i39] + 1, iArr2[i47] + 1, iArr3[i47] + i19);
            }
        }
        ArrayList arrayList = new ArrayList(max * 2);
        int i48 = i28 - 1;
        int i49 = i29 - 1;
        while (true) {
            if (i48 <= 0 && i49 <= 0) {
                break;
            }
            if (i48 == 0) {
                arrayList.add(1);
            } else {
                if (i49 == 0) {
                    arrayList.add(2);
                } else {
                    int i56 = i49 - 1;
                    int i57 = iArr[i48][i56];
                    int[] iArr4 = iArr[i48 - 1];
                    int i58 = iArr4[i49];
                    int i59 = iArr4[i56];
                    if (i57 < i58 && i57 < i59) {
                        arrayList.add(1);
                    } else if (i58 < i59) {
                        arrayList.add(2);
                    } else {
                        arrayList.add(0);
                        i48--;
                    }
                }
                i48--;
            }
            i49--;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            list.add((Integer) arrayList.get(size));
        }
    }

    public static int[] b(char[] cArr, char[] cArr2, Set<Character> set) {
        boolean z16;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i3 == cArr.length) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i16 == cArr2.length) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16 && z17) {
                break;
            }
            if (z16) {
                c(arrayList, cArr2.length - i16, 1);
                break;
            }
            if (z17) {
                c(arrayList, cArr.length - i3, 2);
                break;
            }
            boolean contains = set.contains(Character.valueOf(cArr[i3]));
            boolean contains2 = set.contains(Character.valueOf(cArr2[i16]));
            if (contains && contains2) {
                int d16 = d(cArr, i3 + 1, set);
                int d17 = d(cArr2, i16 + 1, set);
                a(arrayList, cArr, cArr2, i3, d16, i16, d17);
                i3 = d16;
                i16 = d17;
            } else {
                if (contains) {
                    arrayList.add(1);
                } else if (contains2) {
                    arrayList.add(2);
                    i3++;
                } else {
                    arrayList.add(0);
                    i3++;
                }
                i16++;
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            iArr[i17] = ((Integer) arrayList.get(i17)).intValue();
        }
        return iArr;
    }

    private static void c(List<Integer> list, int i3, int i16) {
        for (int i17 = 0; i17 < i3; i17++) {
            list.add(Integer.valueOf(i16));
        }
    }

    private static int d(char[] cArr, int i3, Set<Character> set) {
        while (i3 < cArr.length) {
            if (!set.contains(Character.valueOf(cArr[i3]))) {
                return i3;
            }
            i3++;
        }
        return cArr.length;
    }

    private static int e(int i3, int i16, int i17) {
        return Math.min(i3, Math.min(i16, i17));
    }
}
