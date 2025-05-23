package ws3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class cb {
    public static final ca a(Object[] objArr) {
        List emptyList;
        Iterator it = ArrayIteratorKt.iterator(objArr);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        CollectionsKt__CollectionsKt.emptyList();
        ca caVar = new ca(0, 0, 0, 0L, 0L, 0, 0, 0, emptyList, false, false);
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "curDownLoadFailFileNum")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                caVar.f446230a = vs3.a.a((String) next2);
            } else if (Intrinsics.areEqual(next, "curDownLoadedPauseFileNum")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                vs3.a.a((String) next3);
            } else if (Intrinsics.areEqual(next, "curDownLoadedFileNum")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                caVar.f446231b = vs3.a.a((String) next4);
            } else if (Intrinsics.areEqual(next, "curDownloadingFileNum")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                vs3.a.a((String) next5);
            } else if (Intrinsics.areEqual(next, "totalDownLoadedFileNum")) {
                Object next6 = it.next();
                Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                caVar.f446232c = vs3.a.a((String) next6);
            } else if (Intrinsics.areEqual(next, "curDownLoadedBytes")) {
                Object next7 = it.next();
                Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.String");
                caVar.f446233d = vs3.a.b((String) next7);
            } else if (Intrinsics.areEqual(next, "totalDownLoadedBytes")) {
                Object next8 = it.next();
                Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                caVar.f446234e = vs3.a.b((String) next8);
            } else if (Intrinsics.areEqual(next, "curSpeedBps")) {
                Object next9 = it.next();
                Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.String");
                caVar.f446235f = vs3.a.a((String) next9);
            } else if (Intrinsics.areEqual(next, "avgSpeedBps")) {
                Object next10 = it.next();
                Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.String");
                caVar.f446236g = vs3.a.a((String) next10);
            } else if (Intrinsics.areEqual(next, "maxSpeedBps")) {
                Object next11 = it.next();
                Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.String");
                vs3.a.a((String) next11);
            } else if (Intrinsics.areEqual(next, "remainDownLoadSeconds")) {
                Object next12 = it.next();
                Intrinsics.checkNotNull(next12, "null cannot be cast to non-null type kotlin.String");
                caVar.f446237h = vs3.a.a((String) next12);
            } else {
                if (Intrinsics.areEqual(next, "failFileIdList")) {
                    Object next13 = it.next();
                    Intrinsics.checkNotNull(next13, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) next13).intValue();
                    ArrayList arrayList = new ArrayList(intValue);
                    for (int i3 = 0; i3 < intValue; i3++) {
                        Object next14 = it.next();
                        Intrinsics.checkNotNull(next14, "null cannot be cast to non-null type kotlin.String");
                        arrayList.add((String) next14);
                    }
                    caVar.f446238i = arrayList;
                } else if (Intrinsics.areEqual(next, "allFileIdList")) {
                    Object next15 = it.next();
                    Intrinsics.checkNotNull(next15, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) next15).intValue();
                    ArrayList arrayList2 = new ArrayList(intValue2);
                    for (int i16 = 0; i16 < intValue2; i16++) {
                        Object next16 = it.next();
                        Intrinsics.checkNotNull(next16, "null cannot be cast to non-null type kotlin.String");
                        arrayList2.add((String) next16);
                    }
                } else if (Intrinsics.areEqual(next, "hasNormalFileDownloading")) {
                    Object next17 = it.next();
                    Intrinsics.checkNotNull(next17, "null cannot be cast to non-null type kotlin.Int");
                    ((Integer) next17).intValue();
                } else if (Intrinsics.areEqual(next, "onlyCompressInnerFileDownloading")) {
                    Object next18 = it.next();
                    Intrinsics.checkNotNull(next18, "null cannot be cast to non-null type kotlin.Int");
                    ((Integer) next18).intValue();
                } else if (Intrinsics.areEqual(next, "isAllFileAlreadyDownloaded")) {
                    Object next19 = it.next();
                    Intrinsics.checkNotNull(next19, "null cannot be cast to non-null type kotlin.Int");
                    caVar.f446239j = ((Integer) next19).intValue() == 1;
                } else if (Intrinsics.areEqual(next, "saveFileSetDir")) {
                    Object next20 = it.next();
                    Intrinsics.checkNotNull(next20, "null cannot be cast to non-null type kotlin.String");
                } else if (Intrinsics.areEqual(next, "allWaitingStatusTask")) {
                    Object next21 = it.next();
                    Intrinsics.checkNotNull(next21, "null cannot be cast to non-null type kotlin.Int");
                    caVar.f446240k = ((Integer) next21).intValue() == 1;
                }
            }
        }
        return caVar;
    }
}
