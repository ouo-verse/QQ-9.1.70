package wz2;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.qqnt.aio.refresher.be;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0014\u00a8\u0006\u000f"}, d2 = {"Lwz2/b;", "Lcom/tencent/qqnt/aio/refresher/be;", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalNamePlate;", "vasData", "", "d", "Landroid/content/res/Resources;", "res", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "data", "Landroid/graphics/drawable/Drawable;", "c", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends be {
    @Override // com.tencent.qqnt.aio.refresher.be
    @Nullable
    protected Drawable c(@NotNull Resources res, @NotNull AIOMsgItem msgItem, @NotNull VASPersonalNamePlate data) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.vas.vipicon.a aVar = (com.tencent.mobileqq.vas.vipicon.a) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.vipicon.a.class);
        a.C1005a a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
        Integer num = data.gameNamePlateId;
        Intrinsics.checkNotNullExpressionValue(num, "data.gameNamePlateId");
        String e16 = aVar.e(num.intValue());
        Intrinsics.checkNotNullExpressionValue(e16, "business.getExtIconPath(data.gameNamePlateId)");
        return a16.d(e16).a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.aio.refresher.be
    public boolean d(@NotNull VASPersonalNamePlate vasData) {
        Integer num;
        Intrinsics.checkNotNullParameter(vasData, "vasData");
        if (SimpleUIUtil.isNowSimpleMode() || (num = vasData.gameNamePlateId) == null || num == null) {
            return false;
        }
        if (num != null && num.intValue() == 0) {
            return false;
        }
        return true;
    }
}
