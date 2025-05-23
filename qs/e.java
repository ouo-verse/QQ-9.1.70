package qs;

import com.tencent.mobileqq.vip.g;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class e extends com.tencent.mobileqq.vip.f {
    public abstract void b(String str);

    public abstract void c(String str, boolean z16, int i3);

    public abstract void d(int i3);

    public abstract void e(String str, int i3);

    public abstract void f(String str, boolean z16);

    @Override // com.tencent.mobileqq.vip.f
    public void onCancel(g gVar) {
        super.onCancel(gVar);
        b(gVar.f313004c);
    }

    @Override // com.tencent.mobileqq.vip.f
    public void onDone(g gVar) {
        boolean z16;
        String str = gVar.f313004c;
        if (gVar.i() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        c(str, z16, gVar.f313006d);
    }

    @Override // com.tencent.mobileqq.vip.f
    public void onNetMobile2None() {
        super.onNetMobile2None();
        d(2);
    }

    @Override // com.tencent.mobileqq.vip.f
    public void onNetWifi2Mobile() {
        super.onNetWifi2Mobile();
        d(1);
    }

    @Override // com.tencent.mobileqq.vip.f
    public void onNetWifi2None() {
        super.onNetWifi2None();
        d(3);
    }

    @Override // com.tencent.mobileqq.vip.f
    public void onProgress(g gVar) {
        super.onProgress(gVar);
        e(gVar.f313004c, (int) gVar.f313015m);
    }

    @Override // com.tencent.mobileqq.vip.f
    public boolean onStart(g gVar) {
        super.onStart(gVar);
        f(gVar.f313004c, true);
        return true;
    }
}
