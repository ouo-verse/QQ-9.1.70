package vy2;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.model.k;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.e;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import wn2.c;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f443707a = false;

    /* renamed from: b, reason: collision with root package name */
    private static int f443708b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static int f443709c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static int f443710d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static int f443711e = -1;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static int f443712a;

        /* renamed from: b, reason: collision with root package name */
        public static int f443713b;

        /* renamed from: c, reason: collision with root package name */
        public static int f443714c;

        /* renamed from: d, reason: collision with root package name */
        public static int f443715d;

        /* renamed from: e, reason: collision with root package name */
        public static int f443716e;

        /* renamed from: f, reason: collision with root package name */
        public static int f443717f;

        /* renamed from: g, reason: collision with root package name */
        public static int f443718g;

        /* renamed from: h, reason: collision with root package name */
        public static long f443719h;

        /* renamed from: i, reason: collision with root package name */
        public static long f443720i;

        /* renamed from: j, reason: collision with root package name */
        public static int f443721j;

        /* renamed from: k, reason: collision with root package name */
        public static int f443722k;

        /* renamed from: l, reason: collision with root package name */
        public static int f443723l;

        /* renamed from: m, reason: collision with root package name */
        public static long f443724m;

        /* renamed from: n, reason: collision with root package name */
        public static long f443725n;

        /* renamed from: o, reason: collision with root package name */
        public static long f443726o;

        /* renamed from: p, reason: collision with root package name */
        public static long f443727p;

        /* renamed from: q, reason: collision with root package name */
        public static boolean f443728q;

        public static void a() {
            f443712a = 0;
            f443713b = 0;
            f443714c = 0;
            f443715d = 0;
            f443716e = 0;
            f443717f = 0;
            f443718g = 0;
            f443719h = 0L;
            f443720i = 0L;
            f443721j = 0;
            f443722k = 0;
            f443723l = 0;
            f443724m = 0L;
            f443725n = 0L;
            f443726o = 0L;
            f443727p = 0L;
            f443728q = false;
        }
    }

    /* compiled from: P */
    /* renamed from: vy2.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C11446b {

        /* renamed from: a, reason: collision with root package name */
        public String f443729a;

        /* renamed from: b, reason: collision with root package name */
        public int f443730b;

        /* renamed from: c, reason: collision with root package name */
        public Pair<CharSequence, CharSequence> f443731c;

        public C11446b(String str, int i3, Pair<CharSequence, CharSequence> pair) {
            this.f443729a = str;
            this.f443730b = i3;
            this.f443731c = pair;
        }

        public String toString() {
            CharSequence charSequence;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("MsgSearchContactInfo{uin='");
            sb5.append(this.f443729a);
            sb5.append('\'');
            sb5.append(", uinType=");
            sb5.append(this.f443730b);
            sb5.append(", matchTitle=[");
            String str = "null";
            String str2 = str;
            if (this.f443731c != null) {
                StringBuilder sb6 = new StringBuilder();
                Object obj = this.f443731c.first;
                if (obj == null) {
                    charSequence = "null";
                } else {
                    charSequence = (CharSequence) obj;
                }
                sb6.append((Object) charSequence);
                sb6.append(", ");
                Object obj2 = this.f443731c.second;
                Object obj3 = str;
                if (obj2 != null) {
                    obj3 = (CharSequence) obj2;
                }
                sb6.append(obj3);
                str2 = sb6.toString();
            }
            sb5.append(str2);
            sb5.append("]");
            sb5.append('}');
            return sb5.toString();
        }
    }

    public static ArrayList<C11446b> b(AppInterface appInterface, String str) {
        int i3;
        String l3;
        boolean z16;
        String l16;
        long nanoTime = System.nanoTime();
        int length = str.length();
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            if (str.charAt(i17) < '\u007f') {
                i16++;
            } else {
                i16 += 2;
            }
        }
        int i18 = (i16 / 2) + 2;
        if (i16 >= 3) {
            i3 = i16 * 2;
        } else {
            i3 = -1;
        }
        ArrayList<C11446b> arrayList = new ArrayList<>();
        if (i16 >= 3) {
            String currentAccountUin = appInterface.getCurrentAccountUin();
            String g16 = ac.g(appInterface, currentAccountUin, true);
            if (g16.toLowerCase().startsWith(str.toLowerCase())) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(g16);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(R.color.skin_search_button)), 0, str.length(), 17);
                arrayList.add(new C11446b(currentAccountUin, 0, new Pair(spannableStringBuilder, null)));
            } else if (currentAccountUin.toLowerCase().startsWith(str.toLowerCase())) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("(" + currentAccountUin + ")");
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(R.color.skin_search_button)), 1, str.length() + 1, 17);
                arrayList.add(new C11446b(currentAccountUin, 0, new Pair(g16, spannableStringBuilder2)));
            } else {
                int[] d16 = com.tencent.mobileqq.search.util.a.d(g16, str, 1);
                if (d16[0] == 0) {
                    int i19 = d16[1];
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(g16);
                    spannableStringBuilder3.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(R.color.skin_search_button)), 0, i19, 17);
                    arrayList.add(new C11446b(currentAccountUin, 0, new Pair(spannableStringBuilder3, null)));
                } else {
                    int[] d17 = com.tencent.mobileqq.search.util.a.d(g16, str, 2);
                    if (d17[0] == 0) {
                        int i26 = d17[1];
                        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(g16);
                        spannableStringBuilder4.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(R.color.skin_search_button)), 0, i26, 17);
                        arrayList.add(new C11446b(currentAccountUin, 0, new Pair(spannableStringBuilder4, null)));
                    }
                }
            }
            i18++;
        }
        ContactSearchEngine contactSearchEngine = new ContactSearchEngine(appInterface, 10001, 29, null);
        contactSearchEngine.init();
        List<k> a16 = contactSearchEngine.a(new pn2.a(str));
        if (a16 != null && !a16.isEmpty()) {
            int i27 = 0;
            for (k kVar : a16) {
                if ((((kVar.I() & 4294967295L) & (-16777216)) >> 24) != 2) {
                    CharSequence charSequence = "null";
                    if (arrayList.size() < i18) {
                        if (kVar.M() != 0 && kVar.M() != 1004) {
                            arrayList.add(new C11446b(kVar.l(), kVar.M(), null));
                        } else {
                            i27++;
                            arrayList.add(new C11446b(kVar.l(), kVar.M(), c(kVar)));
                        }
                        if (QLog.isColorLevel()) {
                            Object[] objArr = new Object[3];
                            if (kVar.l() == null) {
                                l16 = "null";
                            } else {
                                l16 = kVar.l();
                            }
                            objArr[0] = l16;
                            objArr[1] = Integer.valueOf(kVar.M());
                            if (kVar.u() != null) {
                                charSequence = kVar.u();
                            }
                            objArr[2] = charSequence;
                            QLog.d("Q.fts.utils", 2, String.format("contactSearchForTopN, contact uin: %s, uinType: %d, matchTitle: %s", objArr));
                        }
                    } else {
                        if (i27 >= i3) {
                            break;
                        }
                        if (kVar.M() == 0 || kVar.M() == 1004) {
                            i27++;
                            arrayList.add(new C11446b(kVar.l(), kVar.M(), c(kVar)));
                            if (QLog.isColorLevel()) {
                                Object[] objArr2 = new Object[3];
                                if (kVar.l() == null) {
                                    l3 = "null";
                                } else {
                                    l3 = kVar.l();
                                }
                                objArr2[0] = l3;
                                z16 = true;
                                objArr2[1] = Integer.valueOf(kVar.M());
                                if (kVar.u() != null) {
                                    charSequence = kVar.u();
                                }
                                objArr2[2] = charSequence;
                                QLog.d("Q.fts.utils", 2, String.format("contactSearchForTopN, contact uin: %s, uinType: %d, matchTitle: %s", objArr2));
                            }
                        }
                    }
                    z16 = true;
                }
            }
        }
        long nanoTime2 = System.nanoTime();
        if (QLog.isColorLevel()) {
            QLog.d("Q.fts.utils", 2, "contactSearchForTopN, cost: " + ((nanoTime2 - nanoTime) / 1000000) + "ms size: " + arrayList.size() + " contactNum: " + i18 + " friendNum: " + i3);
            for (int i28 = 0; i28 < arrayList.size(); i28++) {
                QLog.i("Q.fts.utils", 2, "index = " + i28 + ", contactInfo = " + arrayList.get(i28));
            }
        }
        return arrayList;
    }

    public static Pair<CharSequence, CharSequence> c(k kVar) {
        if (kVar instanceof c) {
            return ((c) kVar).R();
        }
        if (kVar instanceof wn2.b) {
            return ((wn2.b) kVar).R();
        }
        return null;
    }

    public static int d(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return -1;
        }
        if (f443708b == -1) {
            f443708b = appRuntime.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_compare_flag" + appRuntime.getCurrentAccountUin(), 0);
        }
        return f443708b;
    }

    public static int e(AppInterface appInterface) {
        if (f443710d == -1) {
            f443710d = appInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_extension_conversation_flag" + appInterface.getCurrentAccountUin(), 0);
        }
        return f443710d;
    }

    public static int f(AppInterface appInterface) {
        if (f443709c == -1) {
            f443709c = appInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_extension_flag" + appInterface.getCurrentAccountUin(), 1);
        }
        return f443709c;
    }

    public static int g(BaseApplicationImpl baseApplicationImpl) {
        if (f443711e == -1) {
            f443711e = baseApplicationImpl.getSharedPreferences("fts_sp_file", 0).getInt("fts_notify_flag" + baseApplicationImpl.getRuntime().getAccount(), 0);
        }
        return f443711e;
    }

    private static int h(Context context) {
        Activity activity = (Activity) context;
        if (activity instanceof FTSEntitySearchActivity) {
            return 2;
        }
        if (activity instanceof FTSEntitySearchDetailActivity) {
            return 3;
        }
        return 0;
    }

    public static void i(QQAppInterface qQAppInterface, Context context, final String str, int i3, String str2, final e eVar) {
        String Q;
        if (qQAppInterface != null && context != null) {
            if (i3 != 0 && i3 != 1000 && i3 != 1004) {
                Q = ac.Q(qQAppInterface, str, i3);
            } else if (AppConstants.SYSTEM_MSG_UIN.equals(str)) {
                Q = context.getString(R.string.huc);
            } else if (AppConstants.QQBROADCAST_MSG_UIN.equals(str)) {
                Q = context.getString(R.string.hub);
            } else if (AppConstants.VOTE_MSG_UIN.equals(str)) {
                Q = context.getString(R.string.f173190hw4);
            } else {
                if (i3 == 1000) {
                    TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                    if (troopManager != null) {
                        ac.k0(qQAppInterface, str, troopManager.G(str2), str2, true, null, new e() { // from class: vy2.a
                            @Override // com.tencent.mobileqq.troop.e
                            public final void a(String str3) {
                                b.j(str, eVar, str3);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i3 == 1004) {
                    String n3 = ac.n(qQAppInterface, str2, str);
                    if (n3 != null && n3.equals(str)) {
                        Q = ac.g(qQAppInterface, str, true);
                    } else {
                        Q = n3;
                    }
                } else {
                    Q = ac.Q(qQAppInterface, str, i3);
                }
            }
            eVar.a(Q);
            return;
        }
        eVar.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(String str, e eVar, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        eVar.a(str);
    }

    public static void k(View view) {
        int i3;
        HashMap<String, String> hashMap = new HashMap<>();
        a.f443714c = h(view.getContext());
        Integer num = (Integer) view.getTag(R.id.kxc);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = -1;
        }
        a.f443716e = i3 + 1;
        if (a.f443717f == 1) {
            a.f443719h = a.f443725n + ((System.nanoTime() - a.f443724m) / 1000000);
            a.f443720i = a.f443727p + ((System.nanoTime() - a.f443726o) / 1000000);
        }
        if (a.f443715d == 1) {
            a.f443721j = -1;
            a.f443722k = -1;
            a.f443723l = -1;
        }
        hashMap.put("keyNum", String.valueOf(a.f443712a));
        hashMap.put("firstKeyLen", String.valueOf(a.f443713b));
        hashMap.put("itemPage", String.valueOf(a.f443714c));
        hashMap.put("itemSearchStrategy", String.valueOf(a.f443715d));
        hashMap.put("itemPosition", String.valueOf(a.f443716e));
        hashMap.put("itemType", String.valueOf(a.f443717f));
        hashMap.put("itemUinType", String.valueOf(a.f443718g));
        if (a.f443717f == 1) {
            hashMap.put(VasPerfReportUtils.WHILE_COST_TOTAL, String.valueOf(a.f443719h));
            hashMap.put("searchCost", String.valueOf(a.f443720i));
        }
        hashMap.put("senderNum", String.valueOf(a.f443721j));
        hashMap.put(ComicCancelRedPointPopItemData.JSON_KEY_FRIEND_NUM, String.valueOf(a.f443722k));
        hashMap.put("friendIndex", String.valueOf(a.f443723l));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "actFtsItemClickEvent", true, a.f443719h, a.f443720i, hashMap, "", false);
        if (a.f443717f == 1 && QLog.isColorLevel()) {
            QLog.d("Q.fts.utils", 2, "actFtsItemClickEvent: totalCost = " + a.f443719h + ", searchCost = " + a.f443720i);
        }
    }

    public static ArrayList<String> l(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.replaceAll("[^A-Za-z0-9\\u4e00-\\u9fa5]", " ").split("\\s");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : split) {
            String trim = str2.trim();
            if (trim != null && !TextUtils.isEmpty(trim)) {
                arrayList.add(trim);
            }
        }
        return arrayList;
    }
}
