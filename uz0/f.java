package uz0;

import com.tme.karaoke.lib_earback.EarBackScene;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f {
    public static void a() {
        if (com.tme.karaoke.lib_earback.base.c.h()) {
            int a16 = com.tme.karaoke.lib_earback.base.d.a();
            com.tme.karaoke.lib_earback.base.c.m("changeEarback type:" + a16 + " earBackBlueToothSupport\uff1a" + com.tme.karaoke.lib_earback.base.c.c());
            if (a16 == 2) {
                com.tme.karaoke.lib_earback.base.c.p(true, EarBackScene.NormalRecord);
                return;
            } else if (a16 == 3 && com.tme.karaoke.lib_earback.base.c.c()) {
                com.tme.karaoke.lib_earback.base.c.m("changeEarback earBackBlueToothSupport");
                com.tme.karaoke.lib_earback.base.c.p(true, EarBackScene.NormalRecord);
                return;
            } else {
                com.tme.karaoke.lib_earback.base.c.p(false, EarBackScene.NormalRecord);
                return;
            }
        }
        com.tme.karaoke.lib_earback.base.c.p(false, EarBackScene.NormalRecord);
    }
}
