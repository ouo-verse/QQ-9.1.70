package rw;

import android.content.res.Resources;
import com.tencent.av.ui.m;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b {
    public static c a(Resources resources, int i3) {
        int[][] b16 = b(i3);
        if (b16 == null) {
            return null;
        }
        c cVar = new c();
        for (int[] iArr : b16) {
            int i16 = iArr[0];
            cVar.a(new a(i16, resources.getString(i16), iArr[1]));
        }
        cVar.f432588d = i3;
        return cVar;
    }

    private static int[][] b(int i3) {
        if (i3 == m.a.f75990a) {
            return new int[][]{new int[]{m.e.f76014a, R.drawable.dcq}, new int[]{m.e.f76015b, R.drawable.f161372dd1}, new int[]{m.e.f76018e, R.drawable.dcs}, new int[]{m.e.f76024k, R.drawable.n6l}, new int[]{m.e.f76020g, R.drawable.n7n}, new int[]{m.e.f76028o, R.drawable.n7h}, new int[]{m.e.f76027n, R.drawable.n6g}, new int[]{m.e.f76030q, R.drawable.n6h}, new int[]{m.e.f76026m, R.drawable.n7g}, new int[]{m.e.f76019f, R.drawable.dcu}, new int[]{m.e.f76016c, R.drawable.dct}, new int[]{m.e.f76017d, R.drawable.dcy}, new int[]{m.e.f76025l, R.drawable.n7i}};
        }
        if (i3 == m.a.f75992c) {
            return new int[][]{new int[]{m.e.f76022i, R.drawable.f161371dd0}, new int[]{m.e.f76014a, R.drawable.dcq}, new int[]{m.e.f76015b, R.drawable.f161372dd1}, new int[]{m.e.f76030q, R.drawable.n6h}, new int[]{m.e.f76018e, R.drawable.dcs}, new int[]{m.e.f76016c, R.drawable.dct}, new int[]{m.e.f76021h, R.drawable.dcr}};
        }
        if (i3 == m.a.f75993d) {
            return new int[][]{new int[]{m.e.f76014a, R.drawable.dcq}, new int[]{m.e.f76015b, R.drawable.f161372dd1}, new int[]{m.e.f76018e, R.drawable.dcs}, new int[]{m.e.f76029p, R.drawable.n7k}, new int[]{m.e.f76024k, R.drawable.n6l}, new int[]{m.e.f76016c, R.drawable.dct}, new int[]{m.e.f76020g, R.drawable.n7n}, new int[]{m.e.f76028o, R.drawable.n7h}, new int[]{m.e.f76027n, R.drawable.n6g}, new int[]{m.e.f76030q, R.drawable.n6h}, new int[]{m.e.f76021h, R.drawable.dcr}, new int[]{m.e.f76022i, R.drawable.f161371dd0}, new int[]{m.e.f76025l, R.drawable.n7i}};
        }
        if (i3 == m.a.f75991b) {
            return new int[][]{new int[]{m.e.f76014a, R.drawable.dcq}, new int[]{m.e.f76029p, R.drawable.n7k}, new int[]{m.e.f76024k, R.drawable.n6l}, new int[]{m.e.f76015b, R.drawable.f161372dd1}, new int[]{m.e.f76030q, R.drawable.n6h}};
        }
        if (i3 != m.a.f75994e && i3 != m.a.f75995f) {
            int i16 = m.a.f75990a;
            return null;
        }
        return null;
    }

    public static int c(int i3) {
        if (i3 == m.e.f76015b) {
            return 101;
        }
        if (i3 == m.e.f76020g) {
            return 103;
        }
        if (i3 == m.e.f76024k) {
            return 104;
        }
        if (i3 == m.e.f76029p) {
            return 119;
        }
        if (i3 == m.e.f76016c) {
            return 105;
        }
        if (i3 == m.e.f76017d) {
            return 106;
        }
        if (i3 == m.e.f76019f) {
            return 108;
        }
        if (i3 == m.e.f76021h) {
            return 110;
        }
        if (i3 == m.e.f76025l) {
            return 111;
        }
        if (i3 == m.e.f76018e) {
            return 112;
        }
        if (i3 == m.e.f76014a) {
            return 113;
        }
        if (i3 == m.e.f76022i) {
            return 114;
        }
        if (i3 == m.e.f76027n) {
            return 115;
        }
        if (i3 == m.e.f76026m) {
            return 116;
        }
        if (i3 == m.e.f76028o) {
            return 118;
        }
        if (i3 == m.e.f76030q) {
            return 120;
        }
        return 117;
    }
}
