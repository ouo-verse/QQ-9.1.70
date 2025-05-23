package vu3;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"Lvu3/e;", "Lvu3/f;", "", "isExperiment", "a", "", "reportExpExposure", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e implements f {
    @Override // vu3.f
    public boolean a() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_AI_smart_chat_recom_nearby");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(EXP_NAME)");
        return expEntity.isExperiment("exp_AI_smart_chat_recom_nearby_2");
    }

    @Override // vu3.f
    public boolean isExperiment() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_AI_smart_chat_recom_nearby");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(EXP_NAME)");
        return expEntity.isExperiment("exp_AI_smart_chat_recom_nearby_1") || expEntity.isExperiment("exp_AI_smart_chat_recom_nearby_2");
    }

    @Override // vu3.f
    public void reportExpExposure() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_AI_smart_chat_recom_nearby");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(EXP_NAME)");
        expEntity.reportExpExposure();
        QLog.d("AssistedChatNearbyProABTest", 1, "reportExpExposure assignment=" + expEntity.getAssignment());
    }
}
