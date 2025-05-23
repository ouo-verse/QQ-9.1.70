package sk3;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusInfo;
import com.tencent.mobileqq.zplan.smallhome.status.ipc.ModLoadIPCImplForMain;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lsk3/a;", "", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "statusInfo", "", "updateStatus", "clearLoadStatus", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ModLoadIPCImplForMain.class, process = "com.tencent.mobileqq:zplan")
/* loaded from: classes36.dex */
public interface a {
    void clearLoadStatus();

    void updateStatus(ZPlanModLoadStatusInfo statusInfo);
}
