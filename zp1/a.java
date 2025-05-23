package zp1;

import androidx.core.util.Supplier;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002JC\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lzp1/a;", "FeedType", "", "", "position", "feed", "Landroidx/core/util/Supplier;", "", "", "dtParamSupplier", "mediaIndex", "", "f", "(ILjava/lang/Object;Landroidx/core/util/Supplier;I)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a<FeedType> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: zp1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C11708a {
        public static /* synthetic */ void a(a aVar, int i3, Object obj, Supplier supplier, int i16, int i17, Object obj2) {
            if (obj2 == null) {
                if ((i17 & 8) != 0) {
                    i16 = -1;
                }
                aVar.f(i3, obj, supplier, i16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openMorePanel");
        }
    }

    void f(int position, FeedType feed, @NotNull Supplier<Map<String, Object>> dtParamSupplier, int mediaIndex);
}
