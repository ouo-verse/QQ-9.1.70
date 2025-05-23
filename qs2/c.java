package qs2;

import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.f;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\nH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lqs2/c;", "", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/f;", "data", "", "l", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/b;", "result", "a", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/a;", "d", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/h;", "r", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a {
        public static void a(@NotNull c cVar, @NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.a data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        public static void b(@NotNull c cVar, @NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        public static void c(@NotNull c cVar, @NotNull List<f> data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        public static void d(@NotNull c cVar, @NotNull List<h> data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }

    void a(@NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.b result);

    void d(@NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.a data);

    void l(@NotNull List<f> data);

    void r(@NotNull List<h> data);
}
