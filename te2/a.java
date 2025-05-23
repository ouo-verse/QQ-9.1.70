package te2;

import com.tencent.ecommerce.base.logger.api.IECLog;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lte2/a;", "Lcom/tencent/ecommerce/base/logger/api/IECLog;", "", "isColorLevel", "", "tag", "msg", "", "logError", "logInfo", "logWarn", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements IECLog {
    @Override // com.tencent.ecommerce.base.logger.api.IECLog
    public boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    @Override // com.tencent.ecommerce.base.logger.api.IECLog
    public void logError(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.e(tag, 1, msg2);
    }

    @Override // com.tencent.ecommerce.base.logger.api.IECLog
    public void logInfo(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i(tag, 1, msg2);
    }

    @Override // com.tencent.ecommerce.base.logger.api.IECLog
    public void logWarn(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.w(tag, 1, msg2);
    }
}
