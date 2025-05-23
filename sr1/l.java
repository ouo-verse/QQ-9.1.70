package sr1;

import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class l extends b {
    public l(h hVar) {
        super(hVar);
    }

    private void f(int i3) {
        if (QQGuildUIUtil.A(d().getContext())) {
            d().setVisibility(0);
        } else {
            d().setVisibility(i3);
        }
    }

    private void g(float f16, j jVar) {
        if (f16 < jVar.m() && f16 > jVar.p()) {
            a().setVisibility(0);
        } else {
            a().setVisibility(4);
        }
    }

    public void h(float f16, float f17) {
        QLog.i("Guild.MF.Gesture.VisibleComponent", 1, "updateVisibleByAnim translationX = " + f16 + " targetTranslationX = " + f17);
        a().setVisibility(0);
        j i3 = b().i();
        if (f17 == i3.p()) {
            f(8);
            c().setVisibility(0);
        } else if (f17 == i3.m()) {
            f(0);
            c().setVisibility(8);
        }
    }

    public void i(float f16) {
        j i3 = b().i();
        g(f16, i3);
        float n3 = i3.n();
        if (f16 < n3) {
            f(8);
            c().setVisibility(0);
        } else if (f16 > n3) {
            f(0);
            c().setVisibility(8);
        } else {
            f(4);
            c().setVisibility(4);
        }
    }
}
