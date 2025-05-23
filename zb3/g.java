package zb3;

import com.tencent.mobileqq.zootopia.data.ZootopiaTConnAddress;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0003\u00a8\u0006\u0005"}, d2 = {"Lrv4/c;", "Lzb3/f;", "b", "Lrv4/b;", "a", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {
    public static final ZootopiaEnterRoomData a(rv4.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        rv4.c cVar = bVar.f432567a;
        if (cVar != null) {
            return b(cVar);
        }
        return null;
    }

    public static final ZootopiaEnterRoomData b(rv4.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        int i3 = cVar.f432571d;
        long j3 = cVar.f432568a;
        String str = cVar.f432569b;
        Intrinsics.checkNotNullExpressionValue(str, "this.playerToken");
        rv4.d[] dVarArr = cVar.f432570c;
        Intrinsics.checkNotNullExpressionValue(dVarArr, "this.roomAddr");
        ArrayList arrayList = new ArrayList(dVarArr.length);
        for (rv4.d dVar : dVarArr) {
            String str2 = dVar.f432573a;
            Intrinsics.checkNotNullExpressionValue(str2, "addr.ip");
            arrayList.add(new ZootopiaTConnAddress(str2, dVar.f432574b, dVar.f432575c));
        }
        return new ZootopiaEnterRoomData(i3, j3, str, arrayList);
    }
}
