package xo4;

import android.content.Context;
import android.os.Looper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u001b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lxo4/b;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "", "I", "", "troopUin", "H", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInterface", "Landroid/content/Context;", "ctx", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class b extends ax {
    public b(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.I();
        } catch (Exception e16) {
            QLog.e("TroopGuildFeedsListAction", 1, "e: " + e16);
        }
    }

    public boolean H(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return true;
    }

    public abstract void I();

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            try {
                I();
            } catch (Exception e16) {
                QLog.e("TroopGuildFeedsListAction", 1, "e: " + e16);
            }
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: xo4.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.G(b.this);
                }
            });
        }
        return true;
    }
}
