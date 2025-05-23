package u23;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.api.IVasColorName;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalElement;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lu23/b;", "Lcom/tencent/qqnt/chats/inject/title/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "view", "", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends com.tencent.qqnt.chats.inject.title.a {
    @Override // com.tencent.qqnt.chats.inject.title.a
    public void a(@NotNull g item, @NotNull SingleLineTextView view) {
        String str;
        VASPersonalElement vASPersonalElement;
        VASPersonalNamePlate vASPersonalNamePlate;
        int intValue;
        int intValue2;
        int intValue3;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.n() != 1) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (VipNtMMKV.INSTANCE.getShowColorName().decodeBool(str, true) && (vASPersonalElement = item.s().vasPersonalInfo) != null && (vASPersonalNamePlate = vASPersonalElement.personalNamePlateInfo) != null && vASPersonalNamePlate.vipType != null) {
            IVasColorName iVasColorName = (IVasColorName) QRoute.api(IVasColorName.class);
            Integer num = vASPersonalElement.personalNamePlateInfo.isGray;
            if (num == null) {
                intValue = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num, "personalNamePlateInfo.isGray ?: 0");
                intValue = num.intValue();
            }
            Integer num2 = vASPersonalElement.personalNamePlateInfo.vipType;
            if (num2 == null) {
                intValue2 = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num2, "personalNamePlateInfo.vipType ?: 0");
                intValue2 = num2.intValue();
            }
            Integer num3 = vASPersonalElement.colorNickId;
            if (num3 == null) {
                intValue3 = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num3, "colorNickId ?: 0");
                intValue3 = num3.intValue();
            }
            iVasColorName.updateTitle(intValue, intValue2, intValue3, view, false, false);
        }
    }
}
