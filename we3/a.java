package we3;

import com.tencent.mobileqq.zplan.avatar.impl.engine.ZPlanEngineApiImpl;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH&J\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u000e\u001a\u00020\u0004H&\u00a8\u0006\u000f"}, d2 = {"Lwe3/a;", "", "", "targetViewType", "", "needLoading", "", "from", "", "startEngine", "Lwe3/b;", "callBack", "params", "notifyRoleCompleted", "appForeground", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZPlanEngineApiImpl.class)
/* loaded from: classes36.dex */
public interface a {
    boolean appForeground();

    boolean needLoading(int targetViewType);

    void notifyRoleCompleted(String params);

    void startEngine(String from);

    void startEngine(String from, b callBack);
}
