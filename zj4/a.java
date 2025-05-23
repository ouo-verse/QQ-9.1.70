package zj4;

import android.text.TextUtils;
import com.tencent.timi.game.utils.l;
import java.util.HashMap;
import java.util.Map;
import nf4.f;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* compiled from: P */
    /* renamed from: zj4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C11687a implements f {
        C11687a() {
        }

        @Override // nf4.f
        public void a(boolean z16, int i3, String str, boolean z17) {
            Object obj;
            HashMap hashMap = new HashMap();
            String str2 = "true";
            if (z16) {
                obj = "true";
            } else {
                obj = "false";
            }
            hashMap.put(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, obj);
            hashMap.put("k_err_code", String.valueOf(i3));
            if (str == null) {
                str = "";
            }
            hashMap.put("k_err_msg", str);
            if (!z17) {
                str2 = "false";
            }
            hashMap.put("k_nameauth_error", str2);
            a.c("e_gamelive_prepare_result", hashMap);
        }

        @Override // nf4.f
        public void b(boolean z16, int i3, String str) {
            String str2;
            HashMap hashMap = new HashMap();
            if (z16) {
                str2 = "true";
            } else {
                str2 = "false";
            }
            hashMap.put(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, str2);
            hashMap.put("k_err_code", String.valueOf(i3));
            if (str == null) {
                str = "";
            }
            hashMap.put("k_err_msg", str);
            a.c("e_gamelive_set_result", hashMap);
        }

        @Override // nf4.f
        public void c(int i3, boolean z16, int i16, String str) {
            String str2;
            HashMap hashMap = new HashMap();
            if (z16) {
                str2 = "true";
            } else {
                str2 = "false";
            }
            hashMap.put("k_onekey_first_launch", str2);
            hashMap.put("k_onekey_biz_scene", String.valueOf(i3));
            hashMap.put("k_live_game_id", String.valueOf(i16));
            if (str == null) {
                str = "";
            }
            hashMap.put("k_live_game_name", str);
            a.c("e_gamelive_onekey_launchgame", hashMap);
        }

        @Override // nf4.f
        public void d(boolean z16, int i3, String str) {
            String str2;
            HashMap hashMap = new HashMap();
            if (z16) {
                str2 = "true";
            } else {
                str2 = "false";
            }
            hashMap.put(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, str2);
            hashMap.put("k_err_code", String.valueOf(i3));
            if (str == null) {
                str = "";
            }
            hashMap.put("k_err_msg", str);
            a.c("e_gamelive_nameauth_result", hashMap);
        }

        @Override // nf4.f
        public void e(int i3, boolean z16, String str, int i16, String str2) {
            String str3;
            HashMap hashMap = new HashMap();
            hashMap.put("k_onekey_biz_scene", String.valueOf(i3));
            if (z16) {
                str3 = "true";
            } else {
                str3 = "false";
            }
            hashMap.put("k_onekey_enable", str3);
            if (str == null) {
                str = "";
            }
            hashMap.put("k_live_type", str);
            hashMap.put("k_live_game_id", String.valueOf(i16));
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("k_live_game_name", str2);
            a.c("e_gamelive_startlive_click", hashMap);
        }

        @Override // nf4.f
        public void f(int i3, long j3, boolean z16, int i16, String str) {
            String str2;
            HashMap hashMap = new HashMap();
            hashMap.put("k_cost_time", String.valueOf(System.currentTimeMillis() - j3));
            hashMap.put("k_onekey_biz_scene", String.valueOf(i3));
            if (z16) {
                str2 = "true";
            } else {
                str2 = "false";
            }
            hashMap.put(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, str2);
            hashMap.put("k_err_code", String.valueOf(i16));
            if (str == null) {
                str = "";
            }
            hashMap.put("k_err_msg", str);
            a.c("e_gamelive_onekey_create_result", hashMap);
        }

        @Override // nf4.f
        public void g(int i3, long j3, boolean z16, int i16, String str) {
            String str2;
            HashMap hashMap = new HashMap();
            hashMap.put("k_cost_time", String.valueOf(System.currentTimeMillis() - j3));
            hashMap.put("k_onekey_biz_scene", String.valueOf(i3));
            if (z16) {
                str2 = "true";
            } else {
                str2 = "false";
            }
            hashMap.put(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, str2);
            hashMap.put("k_err_code", String.valueOf(i16));
            if (str == null) {
                str = "";
            }
            hashMap.put("k_err_msg", str);
            a.c("e_gamelive_onekey_query_result", hashMap);
        }
    }

    public static f b() {
        return new C11687a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            if (map == null) {
                map = new HashMap<>();
            }
            try {
                ((ug4.a) mm4.b.b(ug4.a.class)).e(str, map);
            } catch (Exception e16) {
                l.d("QQLivePrepareFragment_AnchorRoomService_OneKeyLiveDevReporter", 1, "devMonitorReport exception " + str, e16);
            } catch (OutOfMemoryError e17) {
                l.d("QQLivePrepareFragment_AnchorRoomService_OneKeyLiveDevReporter", 1, "devMonitorReport oom " + str, e17);
            }
        }
    }
}
