package x64;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.robot.widget.bottomdialog.DefaultFunctionEmitter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import x64.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lx64/n;", "Lcom/tencent/robot/widget/bottomdialog/DefaultFunctionEmitter;", "Lx64/m;", "", "f", "callback", "", "e", "", "isHalfMode", "", "accumulatedValue", "totalAvailableHint", "w0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "mNeedResort", "<init>", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class n extends DefaultFunctionEmitter<m> implements m {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedResort;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((m) t16).m()), Integer.valueOf(((m) t17).m()));
            return compareValues;
        }
    }

    private final List<m> f() {
        if (this.mNeedResort) {
            ArrayList<m> d16 = d();
            if (d16.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(d16, new a());
            }
        }
        return d();
    }

    @Override // x64.m
    public int Q(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        Iterator<T> it = f().iterator();
        while (it.hasNext()) {
            accumulatedValue += ((m) it.next()).Q(isHalfMode, accumulatedValue, totalAvailableHint);
        }
        return accumulatedValue;
    }

    @Override // com.tencent.robot.widget.bottomdialog.DefaultFunctionEmitter, ml3.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull m callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mNeedResort = true;
        super.a(callback);
    }

    @Override // x64.m
    public int m() {
        return m.a.a(this);
    }

    @Override // x64.m
    public int w0(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        Iterator<T> it = f().iterator();
        while (it.hasNext()) {
            accumulatedValue += ((m) it.next()).w0(isHalfMode, accumulatedValue, totalAvailableHint);
        }
        return accumulatedValue;
    }
}
