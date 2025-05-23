package te3;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0010"}, d2 = {"Lte3/a;", "Lvb3/b;", "Lcom/tencent/mobileqq/zplan/avatar/api/hippy/a;", "handle", "", "d", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lorg/json/JSONObject;", "params", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "Lcom/tencent/mobileqq/zplan/avatar/api/hippy/BaseHippyUeActionHandler;", "M0", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "g0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface a extends vb3.b {
    void F(com.tencent.mobileqq.zplan.avatar.api.hippy.a handle);

    BaseHippyUeActionHandler M0(JSONObject params, Promise promise);

    void d(com.tencent.mobileqq.zplan.avatar.api.hippy.a handle);

    AvatarEngineType g0();

    com.tencent.mobileqq.zplan.avatar.api.hippy.a m();
}
