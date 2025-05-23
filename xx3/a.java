package xx3;

import com.tencent.mobileqq.component.qrcode.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lxx3/a;", "Lcom/tencent/mobileqq/component/qrcode/a;", "", "color", "", "a", "Lcom/tencent/mobileqq/component/qrcode/f;", "list", "<init>", "(Ljava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends com.tencent.mobileqq.component.qrcode.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull List<f> list) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "list");
    }

    @Override // com.tencent.mobileqq.component.qrcode.a
    @NotNull
    public List<Integer> a(int color) {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(color), Integer.valueOf(color), Integer.valueOf(color));
        return arrayListOf;
    }
}
