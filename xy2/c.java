package xy2;

/* compiled from: P */
/* loaded from: classes20.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    static final int[] f449077a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    static final long[] f449078b = new long[0];

    /* renamed from: c, reason: collision with root package name */
    static final Object[] f449079c = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int[] iArr, int i3, int i16) {
        int i17 = i3 - 1;
        int i18 = 0;
        while (i18 <= i17) {
            int i19 = (i18 + i17) >>> 1;
            int i26 = iArr[i19];
            if (i26 < i16) {
                i18 = i19 + 1;
            } else if (i26 > i16) {
                i17 = i19 - 1;
            } else {
                return i19;
            }
        }
        return ~i18;
    }
}
