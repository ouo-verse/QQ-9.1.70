package xw;

import android.content.Intent;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.h;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private h f448864a = null;

    /* renamed from: b, reason: collision with root package name */
    private QQAppInterface f448865b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: xw.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C11567a extends h {
        C11567a() {
        }

        @Override // com.tencent.mobileqq.app.h
        protected void f(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.i("WTogetherRealNameMainProcessHelper", 2, "onGetRealNameStatusForAV authed:=" + z16);
            }
            a.this.e(z16);
            a.this.f448865b.removeObserver(a.this.f448864a);
        }
    }

    public a(QQAppInterface qQAppInterface) {
        this.f448865b = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z16) {
        Intent intent = new Intent();
        intent.setAction("tencent.video.q2v.avReceiveRealNameMsg");
        intent.putExtra("real_name_result", z16);
        intent.setPackage(this.f448865b.getApplication().getPackageName());
        this.f448865b.getApp().sendBroadcast(intent);
    }

    private boolean g() {
        if (QLog.isColorLevel()) {
            QLog.i("WTogetherRealNameMainProcessHelper", 2, "preCheckRealNameStatus");
        }
        if (this.f448864a != null) {
            if (QLog.isColorLevel()) {
                QLog.i("WTogetherRealNameMainProcessHelper", 2, "preCheckRealNameStatus remove observer");
            }
            this.f448865b.removeObserver(this.f448864a);
        }
        return ((ConfigHandler) this.f448865b.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).s3();
    }

    public void d() {
        h hVar = this.f448864a;
        if (hVar != null) {
            this.f448865b.removeObserver(hVar);
            this.f448864a = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0005, code lost:
    
        if (r3 != 2) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(int i3) {
        boolean g16;
        if (i3 != 1) {
            g16 = false;
        } else {
            g16 = g();
        }
        h();
        return g16;
    }

    public void h() {
        if (QLog.isColorLevel()) {
            QLog.i("WTogetherRealNameMainProcessHelper", 2, "startMonitorRealNameResult");
        }
        if (this.f448864a != null) {
            if (QLog.isColorLevel()) {
                QLog.i("WTogetherRealNameMainProcessHelper", 2, "monitorRealNameResult remove observer");
            }
            this.f448865b.removeObserver(this.f448864a);
            this.f448864a = null;
        }
        C11567a c11567a = new C11567a();
        this.f448864a = c11567a;
        this.f448865b.addObserver(c11567a);
    }
}
