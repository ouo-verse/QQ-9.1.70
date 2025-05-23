package si3;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.zplan.mod.impl.ModEnterIPCImpl;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000f"}, d2 = {"Lsi3/d;", "", "", "modId", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "skipRedirect", "", "", "extras", "Lsi3/e;", "callback", "", "startMod", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ModEnterIPCImpl.class)
/* loaded from: classes36.dex */
public interface d {
    void startMod(int modId, ZootopiaSource source, boolean skipRedirect, Map<String, ? extends Object> extras, e callback);
}
