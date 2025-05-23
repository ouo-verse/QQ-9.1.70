package wm4;

import com.tencent.timi.game.utils.l;
import java.util.HashMap;
import ug4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f445832a;

    /* renamed from: b, reason: collision with root package name */
    private static long f445833b;

    /* renamed from: c, reason: collision with root package name */
    private static long f445834c;

    public static void a() {
        f445832a = System.currentTimeMillis();
    }

    public static void b() {
        f445834c = System.currentTimeMillis();
    }

    public static void c() {
        if (f445832a != 0) {
            long currentTimeMillis = System.currentTimeMillis() - f445832a;
            HashMap hashMap = new HashMap();
            hashMap.put("k_cost_time", String.valueOf(currentTimeMillis));
            ((b) mm4.b.b(b.class)).e("e_team_create_total_result", hashMap);
            f445832a = 0L;
            l.i("TeamPerformanceReporter", "TeamCreateTotalTime == " + currentTimeMillis);
        }
    }

    public static void d() {
        if (f445833b != 0) {
            long currentTimeMillis = System.currentTimeMillis() - f445833b;
            HashMap hashMap = new HashMap();
            hashMap.put("k_cost_time", String.valueOf(currentTimeMillis));
            ((b) mm4.b.b(b.class)).e("e_team_join_total_result", hashMap);
            f445833b = 0L;
            l.i("TeamPerformanceReporter", "TeamJoinTotalTime == " + currentTimeMillis);
        }
    }

    public static void e() {
        if (f445834c != 0) {
            long currentTimeMillis = System.currentTimeMillis() - f445834c;
            HashMap hashMap = new HashMap();
            hashMap.put("k_cost_time", String.valueOf(currentTimeMillis));
            ((b) mm4.b.b(b.class)).e("e_team_panel_ui_result", hashMap);
            f445834c = 0L;
            l.i("TeamPerformanceReporter", "TeamPanelDrawTime == " + currentTimeMillis);
        }
    }
}
