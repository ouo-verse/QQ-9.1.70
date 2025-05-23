package sk3;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusInfo;
import com.tencent.mobileqq.zplan.smallhome.status.ipc.ModLoadIPCForZplanImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lsk3/b;", "", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "getCurrentStatusInfo", "", "mapId", "", "isFromGame", "", "enterLoadStatus", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ModLoadIPCForZplanImpl.class, process = "com.tencent.mobileqq")
/* loaded from: classes36.dex */
public interface b {
    void enterLoadStatus(int mapId, boolean isFromGame);

    ZPlanModLoadStatusInfo getCurrentStatusInfo();
}
