package y3;

import android.app.Activity;
import com.qwallet.activity.QWalletAppInterface;
import com.qwallet.activity.sso.f;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements f {

    /* renamed from: f, reason: collision with root package name */
    protected static final String f449297f = "b";

    /* renamed from: d, reason: collision with root package name */
    protected c f449298d = new c();

    /* renamed from: e, reason: collision with root package name */
    protected Activity f449299e;

    public b(a aVar) {
        WeakReference<Activity> baseActivity = aVar.getBaseActivity();
        if (baseActivity != null) {
            this.f449299e = baseActivity.get();
        }
        QLog.i(f449297f, 2, "\u3010QvipPayWalletBaseBizManager\u3011" + this.f449299e);
        QWalletAppInterface.getInstance().registUIObserver(this);
    }

    public void a() {
        QWalletAppInterface.getInstance().unRegistUIObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        if (QLog.isColorLevel()) {
            QLog.d(f449297f, 2, "isActivityValid: " + this.f449299e);
        }
        if (this.f449299e != null) {
            return true;
        }
        return false;
    }

    protected void d(int i3, boolean z16, Object obj) {
        throw null;
    }

    @Override // com.qwallet.activity.sso.f
    public void g3(int i3, boolean z16, boolean z17, Object obj) {
        if (!z16) {
            QLog.e(f449297f, 1, "get sso command rsp isSuccess: " + z16);
            c(i3, z17, obj);
            return;
        }
        d(i3, z17, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i3, boolean z16, Object obj) {
    }
}
