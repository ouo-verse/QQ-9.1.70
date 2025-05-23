package yk3;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.zplan.utils.stack.ipc.ZPlanLifeCycleRecorderImpl;
import com.tencent.mobileqq.zplan.utils.stack.lifecycle.ProcessName;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0004H&J,\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0004H&J \u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H&J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004H&J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004H&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0006H&\u00a8\u0006\u0016"}, d2 = {"Lyk3/d;", "", "", "isEnginePage", "", "activityName", "", "hashCode", "processName", "", "activityCreate", "activityResume", "activityFinish", "activityDestroy", "sceneType", "sceneParams", "ueEnterAvatarScene", "mapId", "mapName", "doEnterUeMap", "doExitUeMap", "clearInvalidModRes", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZPlanLifeCycleRecorderImpl.class)
/* loaded from: classes36.dex */
public interface d {
    void activityCreate(boolean isEnginePage, String activityName, int hashCode, @ProcessName String processName);

    void activityDestroy(boolean isEnginePage, String activityName, int hashCode);

    void activityFinish(boolean isEnginePage, String activityName, int hashCode);

    void activityResume(boolean isEnginePage, String activityName, int hashCode, @ProcessName String processName);

    void clearInvalidModRes(int mapId);

    void doEnterUeMap(int mapId, String mapName);

    void doExitUeMap(int mapId, String mapName);

    void ueEnterAvatarScene(int sceneType, String sceneParams);
}
