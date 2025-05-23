package xz2;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.aio.event.ShortCutBarEvent;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.aio.shortcutbar.i;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a implements h {

    /* renamed from: d, reason: collision with root package name */
    com.tencent.aio.api.runtime.a f449169d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f449170e;

    /* renamed from: f, reason: collision with root package name */
    i f449171f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: xz2.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11579a implements i {
        C11579a() {
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.i
        public boolean a(int i3, boolean z16) {
            return a.this.b(i3);
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.i
        public boolean b(int i3, boolean z16) {
            return a.this.b(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i3) {
        if (!c(i3)) {
            return false;
        }
        QQToast.makeText(this.f449170e.getApp(), "\u6210\u4e3aQQ\u597d\u53cb\u540e\u5c31\u53ef\u4ee5\u53d1\u9001\u56fe\u7247\u4e86\u54e6", 0).show();
        return true;
    }

    private boolean c(int i3) {
        if (i3 != 1003 && i3 != 1005) {
            return false;
        }
        return true;
    }

    private void e() {
        com.tencent.aio.api.runtime.a aVar = this.f449169d;
        if (aVar != null && aVar.e() != null) {
            if (this.f449171f == null) {
                this.f449171f = new C11579a();
            }
            this.f449169d.e().h(new ShortCutBarEvent.SetShortcutPanelClickListener(this.f449171f));
            return;
        }
        QLog.e(getTag(), 1, "[initAndAddListener] mAioContext == null || mAioContext.getMessenger() == null");
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.L0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "SquareTempAioDisplayHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b bVar) {
        this.f449170e = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.f449169d = bVar.a();
        e();
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        this.f449170e = null;
        this.f449169d = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int i3) {
    }
}
