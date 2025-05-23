package x83;

import androidx.annotation.CallSuper;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;
import z93.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0015J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H&R\u0014\u0010\u000f\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lx83/a;", "", "", "i", "isStartProcess", "e", "", h.F, "d", "g", "b", "f", "", "c", "()Ljava/lang/String;", "logTag", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class a {
    public void b() {
        QLog.d(c(), 1, "destroyProcess ");
        if (!e(false)) {
            QLog.d(c(), 1, "destroyProcess, isSwitchOpen is false ");
        } else {
            f();
        }
    }

    @NotNull
    public abstract String c();

    public boolean d() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean e(boolean isStartProcess) {
        boolean z16;
        if (!w83.b.f445025a.H()) {
            QLog.d(c(), 1, "isSwitchOpen, isAlbumMasterSwitchOpen is false ");
            return false;
        }
        e h16 = Wink.INSTANCE.h();
        if (h16 != null) {
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            z16 = h16.a(context);
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i(c(), 1, "isSwitchOpen, hasStoragePermission is false ");
            return false;
        }
        if (isStartProcess && !v83.e.f441245a.f()) {
            QLog.d(c(), 1, "isSwitchOpen, isMemoryAlbumAuthorize is false ");
            return false;
        }
        if (d()) {
            return true;
        }
        QLog.d(c(), 1, "isSwitchOpen, isExtraSwitchOpen is false ");
        return false;
    }

    public abstract void f();

    public abstract boolean g();

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void h() {
        QLog.d(c(), 1, "onStartSwitchClose ");
    }

    public boolean i() {
        QLog.d(c(), 1, "startProcess ");
        if (!e(true)) {
            QLog.d(c(), 1, "startProcess, isSwitchOpen is false ");
            h();
            return false;
        }
        return g();
    }
}
