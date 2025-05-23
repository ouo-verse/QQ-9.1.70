package z94;

import h94.FinishAIMakeFaceData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s94.FaceInfoSyncData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lz94/a;", "", "Ls94/b;", "data", "", "c", "Lh94/a;", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: z94.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11666a {
        public static void a(a aVar, FaceInfoSyncData data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        public static void b(a aVar, FinishAIMakeFaceData data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }

    void c(FaceInfoSyncData data);

    void d(FinishAIMakeFaceData data);
}
