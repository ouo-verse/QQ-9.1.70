package s32;

import com.tencent.mobileqq.qqlive.config.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import d32.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f433171a;

    /* renamed from: b, reason: collision with root package name */
    private static final List<ITPPlayer> f433172b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static final List<ISuperPlayer> f433173c = new ArrayList();

    a() {
    }

    private boolean a() {
        int i3;
        boolean z16;
        d dVar = new d();
        if (dVar.f392748k != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("ICGamePlayerPool", 4, "playerConfig:" + dVar.f392748k);
            }
            f fVar = dVar.f392748k;
            z16 = fVar.f271192b;
            i3 = fVar.f271191a;
        } else {
            i3 = 3;
            z16 = false;
        }
        int size = f433172b.size() + f433173c.size();
        if (!z16 || size >= i3) {
            return false;
        }
        return true;
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f433171a == null) {
                f433171a = new a();
            }
            aVar = f433171a;
        }
        return aVar;
    }

    private void f(ISuperPlayer iSuperPlayer) {
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnVideoPreparedListener(null);
            iSuperPlayer.setOnInfoListener(null);
            iSuperPlayer.setOnErrorListener(null);
            iSuperPlayer.setOnCompletionListener(null);
            iSuperPlayer.setOnVideoSizeChangedListener(null);
            iSuperPlayer.reset();
        }
    }

    public ISuperPlayer b() {
        List<ISuperPlayer> list = f433173c;
        synchronized (list) {
            QLog.i("ICGamePlayerPool", 1, "getISuperPlayer current size is " + list.size());
            if (list.isEmpty()) {
                return null;
            }
            return list.remove(0);
        }
    }

    public void d(ISuperPlayer iSuperPlayer) {
        if (a()) {
            QLog.d("ICGamePlayerPool", 1, "recycle player:" + iSuperPlayer);
            f(iSuperPlayer);
            List<ISuperPlayer> list = f433173c;
            synchronized (list) {
                list.add(iSuperPlayer);
            }
            return;
        }
        QLog.d("ICGamePlayerPool", 1, "release player:" + iSuperPlayer);
        iSuperPlayer.release();
    }

    public void e() {
        List<ITPPlayer> list = f433172b;
        synchronized (list) {
            Iterator<ITPPlayer> it = list.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            f433172b.clear();
        }
        List<ISuperPlayer> list2 = f433173c;
        synchronized (list2) {
            Iterator<ISuperPlayer> it5 = list2.iterator();
            while (it5.hasNext()) {
                it5.next().release();
            }
            f433173c.clear();
        }
    }
}
