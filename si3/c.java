package si3;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JW\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062%\b\u0002\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH&Jo\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062%\b\u0002\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH&\u00a8\u0006\u0014"}, d2 = {"Lsi3/c;", "Lvb3/b;", "", "modId", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "", "", "ueParams", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "Lkotlin/ParameterName;", "name", "checkResult", "", "callback", "u", "detailParams", "l0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface c extends vb3.b {
    void l0(int modId, ZootopiaSource source, Map<String, ? extends Object> ueParams, Map<String, ? extends Object> detailParams, Function1<? super EnterModCheckResult, Unit> callback);

    void u(int modId, ZootopiaSource source, Map<String, ? extends Object> ueParams, Function1<? super EnterModCheckResult, Unit> callback);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(c cVar, int i3, ZootopiaSource zootopiaSource, Map map, Function1 function1, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    map = null;
                }
                if ((i16 & 8) != 0) {
                    function1 = null;
                }
                cVar.u(i3, zootopiaSource, map, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startMod");
        }
    }
}
