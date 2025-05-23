package zx4;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import cy4.ZPlanResourceBusinessData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J2\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH&\u00a8\u0006\u0014"}, d2 = {"Lzx4/g;", "", "Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "loadingData", "", "notifyHotPatchProgress", "", "versionInfo", "c", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "a", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "", "errorCode", "errorMessage", "totalTaskCount", "failedTaskCount", "b", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface g {
    void a(@NotNull ZPlanResourceBusinessData businessData);

    void b(@NotNull ZPlanSceneResourceErrType errType, int errorCode, @Nullable String errorMessage, int totalTaskCount, int failedTaskCount);

    void c(@NotNull String versionInfo);

    void notifyHotPatchProgress(@NotNull CommonLoadingData loadingData);
}
