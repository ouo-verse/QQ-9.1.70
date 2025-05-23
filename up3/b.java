package up3;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.open.agent.util.g;
import com.tencent.open.agent.util.t;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f439758a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f439759b;

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, JSONObject> f439760c;

    public static void a(String str) {
        t.b("open_log", "addImBlockUin uin=", g.C(str));
        d(str, "im_block_uins");
        c(str, "im_block_uins", true);
    }

    public static void b(String str) {
        t.b("open_log", "addLoginHistory uin=", g.C(str));
        m();
        d(str, "login_history");
        c(str, "login_history", true);
        if (!k()) {
            h().edit().putBoolean("have_ever_login", true).commit();
        }
    }

    private static void c(String str, String str2, boolean z16) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            synchronized (str2) {
                String string = h().getString(str2, "");
                boolean z17 = true;
                if (string.length() > 0) {
                    if (!Pattern.compile("(^|,)" + str + "($|,)").matcher(string).find()) {
                        if (z16) {
                            str3 = str + "," + string;
                        } else {
                            str3 = string + "," + str;
                        }
                        string = str3;
                    } else {
                        z17 = false;
                    }
                } else {
                    string = str;
                }
                t.f("open_log", "commaFormatAdd: " + MsfSdkUtils.getShortUin(str) + ", needAdd: " + z17);
                if (z17) {
                    h().edit().putString(str2, string).commit();
                }
            }
        }
    }

    private static void d(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (str2) {
                String string = h().getString(str2, "");
                if (string.length() > 0) {
                    Matcher matcher = Pattern.compile("(^|,)" + str + "($|,)").matcher(string);
                    if (matcher.find()) {
                        String str3 = ",";
                        if (matcher.start() == 0 || matcher.end() == string.length()) {
                            str3 = "";
                        }
                        String replaceFirst = matcher.replaceFirst(str3);
                        t.f("open_log", "commaFormatDelete: " + MsfSdkUtils.getShortUin(str));
                        h().edit().putString(str2, replaceFirst).commit();
                    }
                }
            }
        }
    }

    private static ArrayList<String> e(String str) {
        ArrayList<String> arrayList;
        synchronized (str) {
            String string = h().getString(str, "");
            if (string.length() > 0) {
                String[] split = string.split(",");
                arrayList = new ArrayList<>();
                for (String str2 : split) {
                    arrayList.add(str2);
                }
            } else {
                arrayList = null;
            }
        }
        return arrayList;
    }

    public static void f(String str) {
        t.b("open_log", "delImBlockUin uin=", g.C(str));
        d(str, "im_block_uins");
    }

    public static void g(String str) {
        d(str, "login_history");
    }

    @TargetApi(11)
    public static synchronized SharedPreferences h() {
        SharedPreferences sharedPreferences;
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        synchronized (b.class) {
            if (f439758a == null) {
                t.f("open_log", "get sp create");
                BaseApplication context = BaseApplication.getContext();
                SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(context, "shared_prefs_open", "common_mmkv_configurations");
                f439758a = fromSpAdapter;
                boolean z16 = fromSpAdapter.getBoolean("_migrate_flag_", false);
                t.e("open_log", "migrated sp has migrated? " + z16);
                if (!z16) {
                    try {
                        Map<String, ?> all = context.getSharedPreferences("shared_prefs_open", 4).getAll();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("migrated sp map: ");
                        if (all == null) {
                            valueOf = "null";
                        } else {
                            valueOf = Integer.valueOf(all.size());
                        }
                        sb5.append(valueOf);
                        t.f("open_log", sb5.toString());
                        if (all != null && all.size() > 0) {
                            QMMKV.migrateToSpAdapter(context, "shared_prefs_open", "common_mmkv_configurations");
                        } else {
                            Map<String, ?> all2 = context.getSharedPreferences("shared_prefs_open", 0).getAll();
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("migrated private sp map: ");
                            if (all2 == null) {
                                valueOf2 = "null";
                            } else {
                                valueOf2 = Integer.valueOf(all2.size());
                            }
                            sb6.append(valueOf2);
                            t.f("open_log", sb6.toString());
                            QMMKV.migrateToSpAdapter(context, "shared_prefs_open", 0, "common_mmkv_configurations");
                        }
                        Map<String, ?> all3 = f439758a.getAll();
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("migrated mmkv map: ");
                        if (all3 == null) {
                            valueOf3 = "null";
                        } else {
                            valueOf3 = Integer.valueOf(all3.size());
                        }
                        sb7.append(valueOf3);
                        t.f("open_log", sb7.toString());
                    } catch (Throwable th5) {
                        t.d("open_log", "migrated catch exception", th5);
                    }
                    f439758a.edit().putBoolean("_migrate_flag_", true).apply();
                }
                t.f("open_log", "get sp create end");
            }
            sharedPreferences = f439758a;
        }
        return sharedPreferences;
    }

    public static String i() {
        ArrayList<String> e16 = e("im_block_uins");
        if (e16 != null && e16.size() > 0) {
            return e16.get(0);
        }
        return null;
    }

    public static ArrayList<String> j() {
        m();
        return e("login_history");
    }

    public static boolean k() {
        if (!f439759b) {
            f439759b = h().getBoolean("have_ever_login", false);
        }
        return f439759b;
    }

    private static synchronized JSONObject l(String str) {
        JSONObject jSONObject;
        synchronized (b.class) {
            HashMap<String, JSONObject> hashMap = f439760c;
            if (hashMap == null) {
                f439760c = new HashMap<>();
                jSONObject = null;
            } else {
                jSONObject = hashMap.get(str);
            }
            if (jSONObject == null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(h().getString(str, "{}"));
                    try {
                        f439760c.put(str, jSONObject2);
                        jSONObject = jSONObject2;
                    } catch (JSONException e16) {
                        e = e16;
                        jSONObject = jSONObject2;
                        e.printStackTrace();
                        return jSONObject;
                    }
                } catch (JSONException e17) {
                    e = e17;
                }
            }
        }
        return jSONObject;
    }

    private static void m() {
        ArrayList arrayList;
        String[] split;
        if (!k()) {
            boolean z16 = false;
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("accountList", 0);
            String string = sharedPreferences.getString("last_account", null);
            String string2 = sharedPreferences.getString("accList", null);
            t.f("open_log", "mergeOldData accList: " + string2);
            if (!TextUtils.isEmpty(string2) && (split = string2.split(",")) != null) {
                arrayList = new ArrayList(split.length);
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                        arrayList.add(str);
                    }
                }
            } else {
                arrayList = null;
            }
            List<SimpleAccount> loginedAccountList = MsfSdkUtils.getLoginedAccountList();
            if (loginedAccountList != null) {
                for (SimpleAccount simpleAccount : loginedAccountList) {
                    t.f("open_log", "mergeOldData account: " + MsfSdkUtils.getShortUin(simpleAccount.getUin()) + ", isLogin: " + simpleAccount.isLogined());
                    if (simpleAccount.isLogined()) {
                        c(simpleAccount.getUin(), "login_history", true);
                        z16 = true;
                    } else {
                        if (simpleAccount.getUin().equals(string)) {
                            string = null;
                        }
                        if (arrayList != null) {
                            Iterator it = arrayList.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    String str2 = (String) it.next();
                                    if (simpleAccount.getUin().equals(str2)) {
                                        arrayList.remove(str2);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (arrayList != null) {
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    c((String) it5.next(), "login_history", true);
                    z16 = true;
                }
            }
            if (!TextUtils.isEmpty(string)) {
                c(string, "login_history", true);
                z16 = true;
            }
            if (z16) {
                h().edit().putBoolean("have_ever_login", true).commit();
            }
        }
    }

    private static synchronized void n(String str, JSONObject jSONObject) {
        synchronized (b.class) {
            HashMap<String, JSONObject> hashMap = f439760c;
            if (hashMap != null) {
                hashMap.put(str, jSONObject);
            }
            h().edit().putString(str, jSONObject.toString()).commit();
        }
    }

    public static void o(String str, long j3) {
        JSONObject l3 = l("last_skey_update_time");
        if (l3 != null) {
            try {
                l3.put(str, j3);
                n("last_skey_update_time", l3);
                t.e("open_log", "saveUpdateSkeyTime uin=", g.C(str));
            } catch (JSONException e16) {
                t.d("open_log", "saveUpdateSkeyTime", e16);
            }
        }
    }

    public static boolean p(String str) {
        boolean z16;
        JSONObject l3 = l("last_skey_update_time");
        if (l3 != null) {
            try {
            } catch (JSONException e16) {
                t.d("open_log", "shouldUpdateSkey", e16);
            }
            if (System.currentTimeMillis() - l3.getLong(str) <= 43200000) {
                z16 = false;
                t.e("open_log", "shouldUpdateSkey ret=", Boolean.valueOf(z16));
                return z16;
            }
        }
        z16 = true;
        t.e("open_log", "shouldUpdateSkey ret=", Boolean.valueOf(z16));
        return z16;
    }
}
