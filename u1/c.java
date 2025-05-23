package u1;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final a f438043a;

    /* renamed from: b, reason: collision with root package name */
    private final List<b> f438044b;

    public c(a aVar) {
        if (a.f438033h.equals(aVar)) {
            this.f438043a = aVar;
            ArrayList arrayList = new ArrayList();
            this.f438044b = arrayList;
            arrayList.add(new b(aVar, new int[]{1}));
            return;
        }
        throw new IllegalArgumentException("Only QR Code is supported at this time");
    }

    private b a(int i3) {
        if (i3 >= this.f438044b.size()) {
            List<b> list = this.f438044b;
            b bVar = list.get(list.size() - 1);
            for (int size = this.f438044b.size(); size <= i3; size++) {
                a aVar = this.f438043a;
                bVar = bVar.g(new b(aVar, new int[]{1, aVar.d(size - 1)}));
                this.f438044b.add(bVar);
            }
        }
        return this.f438044b.get(i3);
    }

    public void b(int[] iArr, int i3) {
        if (i3 != 0) {
            int length = iArr.length - i3;
            if (length > 0) {
                b a16 = a(i3);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] d16 = new b(this.f438043a, iArr2).h(i3, 1).b(a16)[1].d();
                int length2 = i3 - d16.length;
                for (int i16 = 0; i16 < length2; i16++) {
                    iArr[length + i16] = 0;
                }
                System.arraycopy(d16, 0, iArr, length + length2, d16.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
