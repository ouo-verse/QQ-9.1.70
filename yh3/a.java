package yh3;

import com.tencent.mobileqq.zplan.hotpatch.ZPlanHotPatchIPCImpl;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lyh3/a;", "", "Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "loadingData", "", "dispatchProgressEvent", "", "versionInfo", "dispatchStatusChangeEvent", "result", "dispatchHotPatchResult", "Lai3/b;", "cb", "dispatchLoadingError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZPlanHotPatchIPCImpl.class)
/* loaded from: classes36.dex */
public interface a {
    void dispatchHotPatchResult(String result);

    void dispatchLoadingError(String result, ai3.b cb5);

    void dispatchProgressEvent(CommonLoadingData loadingData);

    void dispatchStatusChangeEvent(String versionInfo);
}
