package yb4;

import com.tencent.common.app.AppInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\f\u00a2\u0006\u0004\b\u0013\u0010\u0011J\u0012\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lyb4/d;", "", "", "method", "c", "", "data", "a", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "Lcom/tencent/common/app/AppInterface;", "b", "", "I", "d", "()I", "setSource", "(I)V", "source", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int source;

    public d() {
    }

    public abstract Object a(String method, byte[] data);

    public final AppInterface b(com.tencent.mobileqq.zootopia.api.e<?> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-2, "\u83b7\u53d6app\u5f02\u5e38");
        }
        if (z16) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    public abstract String c(String method);

    /* renamed from: d, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    public d(int i3) {
        this();
        this.source = i3;
    }
}
