package qk3;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.zplan.smallhome.reenter.SmallHomeReEnterIPCImpl;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0007H&\u00a8\u0006\r"}, d2 = {"Lqk3/a;", "", "", "modId", "", "modName", GetAdInfoRequest.SOURCE_FROM, "", "onModStart", "Lorg/json/JSONObject;", "enterParams", "onModFirstFrameCallback", QCircleLpReportDc05507.KEY_CLEAR, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = SmallHomeReEnterIPCImpl.class, process = "com.tencent.mobileqq:zplan")
/* loaded from: classes36.dex */
public interface a {
    void clear();

    void onModFirstFrameCallback(JSONObject enterParams);

    void onModStart(int modId, String modName, String sourceFrom);
}
