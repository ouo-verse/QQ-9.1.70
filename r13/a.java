package r13;

import android.content.SharedPreferences;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.manager.api.IKingCardManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u0010\u001a\u00020\t8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lr13/a;", "Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "", "isKingCard", "", "setKingCardState", "Lkotlin/Function1;", "block", "addChangeListener", "", "from", "isFreeFlow", "d", "Ljava/lang/String;", "getManagerName", "()Ljava/lang/String;", "managerName", "<init>", "()V", "e", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements IKingCardManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String managerName = "KingCardManagerImpl";

    @Override // com.tencent.mobileqq.vas.manager.api.IKingCardManager
    public void addChangeListener(@NotNull Function1<? super Boolean, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        return this.managerName;
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IKingCardManager
    public boolean isFreeFlow(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        IVasService service = VasUtil.getService();
        if (service == null) {
            return false;
        }
        int obtainCardState = service.getVasFtManager().obtainCardState(from);
        if (QLog.isColorLevel()) {
            QLog.i("KingCardManagerImpl", 1, "FreeFlowState = " + obtainCardState);
        }
        if (obtainCardState <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IKingCardManager
    public boolean isKingCard() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(VasConstant.SP_KING_CARD, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getContext()\n           \u2026RD, Context.MODE_PRIVATE)");
        int i3 = sharedPreferences.getInt("kingCardSdk", -1);
        if (QLog.isColorLevel()) {
            QLog.i("KingCardManagerImpl", 2, "KingCard Status: sdkStatus=" + i3);
        }
        if (i3 <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IKingCardManager
    public void setKingCardState(boolean isKingCard) {
        if (QLog.isColorLevel()) {
            QLog.i("KingCardManagerImpl", 2, "setKingCardState=" + isKingCard);
        }
        BaseApplication.getContext().getSharedPreferences(VasConstant.SP_KING_CARD, 0).edit().putInt("kingCardSdk", isKingCard ? 1 : 0).apply();
    }
}
