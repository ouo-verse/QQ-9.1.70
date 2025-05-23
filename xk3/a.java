package xk3;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.zplan.ipc.annotation.SyncMethod;
import com.tencent.mobileqq.zplan.utils.stack.UEActivityManagerService;
import com.tencent.mobileqq.zplan.utils.stack.lifecycle.ProcessName;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0002H'J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H'J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H'J\b\u0010\f\u001a\u00020\u0004H&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u000f"}, d2 = {"Lxk3/a;", "", "", "activityName", "", "hashCode", "processName", "", OperateCustomButton.OPERATE_CREATE, "key", "finish", "destroy", "getActiveSceneCounter", "", "isTopEngineActivity", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = UEActivityManagerService.class)
/* loaded from: classes36.dex */
public interface a {
    @SyncMethod
    void create(String activityName, int hashCode, @ProcessName String processName);

    @SyncMethod
    void destroy(String activityName, int hashCode);

    @SyncMethod
    void finish(String key);

    int getActiveSceneCounter();

    boolean isTopEngineActivity(String activityName, int hashCode);
}
