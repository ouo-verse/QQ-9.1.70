package sn;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {
    public static List<Path> a(float f16, float f17, List<Path> list, List<String> list2) {
        Matrix matrix = new Matrix();
        matrix.setScale(f16, f17);
        ArrayList arrayList = new ArrayList();
        for (Path path : list) {
            Path path2 = new Path();
            path.transform(matrix, path2);
            arrayList.add(path2);
        }
        return arrayList;
    }
}
