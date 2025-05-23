package yf0;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.ecommerce.base.device.api.IECDeviceInfo;
import com.tencent.luggage.wxa.yf.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016\u00a8\u0006\u0015"}, d2 = {"Lyf0/a;", "Lcom/tencent/ecommerce/base/device/api/IECDeviceInfo;", "Landroid/content/Context;", "context", "", "checkDeviceHasNavigationBar", "", "getNavigationBarHeight", "Landroid/util/DisplayMetrics;", "getSystemDisplayMetrics", "getAppDisplayMetrics", "", "getAppFontScale", "Landroid/view/View;", "view", "", "resetViewSize2Normal", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, e.NAME, "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECDeviceInfo {
    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    public boolean checkDeviceHasNavigationBar(@NotNull Context context) {
        throw new IllegalArgumentException("IECDeviceInfo checkDeviceHasNavigationBar not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    @Nullable
    public DisplayMetrics getAppDisplayMetrics() {
        return null;
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    public float getAppFontScale() {
        return 1.0f;
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    public int getNavigationBarHeight(@NotNull Context context) {
        throw new IllegalArgumentException("IECDeviceInfo getNavigationBarHeight not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    @NotNull
    public DisplayMetrics getSystemDisplayMetrics() {
        return Resources.getSystem().getDisplayMetrics();
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    public void hideNavigationBar(@NotNull Context activity) {
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    public void resetViewSize2Normal(@NotNull Context context, @NotNull View view) {
    }
}
