package zp;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    private static HashMap<String, BeautyRealConfig.TYPE> f452924g;

    /* renamed from: a, reason: collision with root package name */
    public int f452925a;

    /* renamed from: b, reason: collision with root package name */
    public String f452926b;

    /* renamed from: c, reason: collision with root package name */
    public int f452927c;

    /* renamed from: d, reason: collision with root package name */
    public List<C11707a> f452928d;

    /* renamed from: e, reason: collision with root package name */
    public List<b> f452929e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, List<C11707a>> f452930f;

    /* compiled from: P */
    /* renamed from: zp.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11707a {

        /* renamed from: a, reason: collision with root package name */
        public String f452931a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f452932b;

        /* renamed from: c, reason: collision with root package name */
        public int f452933c;

        /* renamed from: d, reason: collision with root package name */
        public int f452934d;

        /* renamed from: e, reason: collision with root package name */
        public String f452935e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f452936f;

        /* renamed from: g, reason: collision with root package name */
        public HashMap<String, Integer> f452937g;

        /* renamed from: h, reason: collision with root package name */
        public c f452938h;

        /* renamed from: i, reason: collision with root package name */
        public d f452939i;

        /* renamed from: j, reason: collision with root package name */
        public d f452940j;

        /* renamed from: k, reason: collision with root package name */
        public d f452941k;

        /* renamed from: l, reason: collision with root package name */
        public String f452942l;

        /* renamed from: m, reason: collision with root package name */
        public d f452943m;

        /* renamed from: n, reason: collision with root package name */
        public String f452944n;

        /* renamed from: o, reason: collision with root package name */
        private HashMap<BeautyRealConfig.TYPE, Integer> f452945o;

        public C11707a() {
        }

        public C11707a c() {
            C11707a c11707a = new C11707a();
            c11707a.f452931a = this.f452931a;
            c11707a.f452932b = this.f452932b;
            c11707a.f452933c = this.f452933c;
            c11707a.f452934d = this.f452934d;
            c11707a.f452935e = this.f452935e;
            c11707a.f452936f = this.f452936f;
            c11707a.f452937g = this.f452937g;
            c11707a.f452938h = this.f452938h;
            c11707a.f452939i = this.f452939i;
            c11707a.f452940j = this.f452940j;
            c11707a.f452941k = this.f452941k;
            c11707a.f452942l = this.f452942l;
            c11707a.f452943m = this.f452943m;
            c11707a.f452944n = this.f452944n;
            c11707a.f452945o = this.f452945o;
            return c11707a;
        }

        public HashMap<BeautyRealConfig.TYPE, Integer> d() {
            return this.f452945o;
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f452955a;

        /* renamed from: b, reason: collision with root package name */
        public int f452956b;

        /* renamed from: c, reason: collision with root package name */
        public int f452957c;

        public c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public String f452959a;

        /* renamed from: b, reason: collision with root package name */
        public int f452960b;

        public d() {
        }
    }

    private void e(List<C11707a> list) {
        Iterator<C11707a> it = list.iterator();
        while (it.hasNext()) {
            d(it.next());
        }
    }

    private List<C11707a> f() {
        if (!l()) {
            QLog.i("AutoTestConfigBeans", 4, "createNodeFromImageSet | \u65e0\u9700\u521b\u5efa\u65b0\u7684autoTestNode");
            return null;
        }
        Date date = new Date();
        String str = "" + (date.getYear() + 1900) + "_" + (date.getMonth() + 1) + "_" + date.getDate() + File.separator;
        QLog.i("AutoTestConfigBeans", 4, "createNodeFromImageSet | parentFolder:" + str);
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.f452929e) {
            List<C11707a> list = this.f452930f.get(bVar.f452951e);
            if (list != null && list.size() != 0) {
                Iterator<C11707a> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(bVar.c(it.next(), str));
                }
            } else {
                QLog.e("AutoTestConfigBeans", 4, "can not found test cases for " + bVar.f452951e);
            }
        }
        return arrayList;
    }

    private HashMap<BeautyRealConfig.TYPE, Integer> g() {
        if (f452924g == null) {
            k();
        }
        HashMap<BeautyRealConfig.TYPE, Integer> hashMap = new HashMap<>();
        for (BeautyRealConfig.TYPE type : BeautyRealConfig.TYPE.values()) {
            hashMap.put(type, 0);
        }
        return hashMap;
    }

    private c h() {
        c cVar = new c();
        cVar.f452955a = null;
        cVar.f452956b = 0;
        cVar.f452957c = 0;
        return cVar;
    }

    private d i() {
        d dVar = new d();
        dVar.f452959a = null;
        dVar.f452960b = 0;
        return dVar;
    }

    private void j() {
        f452924g.put("\u65e0", BeautyRealConfig.TYPE.NONE);
        f452924g.put("\u7f8e\u767d", BeautyRealConfig.TYPE.LUT_FOUNDATION_ALPHA);
        f452924g.put("\u5c0f\u8138", BeautyRealConfig.TYPE.FACTOR_SMALL_NEW);
        f452924g.put("\u5634\u5f62", BeautyRealConfig.TYPE.MOUTH_SHAPE);
        f452924g.put("\u816e\u7ea2", BeautyRealConfig.TYPE.FACE_FEATURE_REDCHEEK);
        f452924g.put("\u989d\u5934", BeautyRealConfig.TYPE.FOREHEAD);
        f452924g.put("\u6e05\u6670", BeautyRealConfig.TYPE.LUT_CLERA_ALPHA);
        f452924g.put("\u7acb\u4f53", BeautyRealConfig.TYPE.FACE_FEATURE_SOFT);
        f452924g.put("\u6cd5\u4ee4\u7eb9", BeautyRealConfig.TYPE.REMOVE_WRINKLES2);
        f452924g.put("\u78e8\u76ae", BeautyRealConfig.TYPE.BEAUTY);
        f452924g.put("\u7626\u98a7\u9aa8", BeautyRealConfig.TYPE.CHEEKBONE_THIN);
        f452924g.put("\u767d\u7259", BeautyRealConfig.TYPE.TOOTH_WHITEN);
        f452924g.put("\u53e3\u7ea2", BeautyRealConfig.TYPE.FACE_FEATURE_LIPS_LUT_ALPHA);
        f452924g.put("\u7a84\u8138", BeautyRealConfig.TYPE.FACE_THIN);
        f452924g.put("\u7626\u9f3b", BeautyRealConfig.TYPE.NOSE);
        f452924g.put("\u7626\u8138", BeautyRealConfig.TYPE.FACTOR_THIN_NEW);
        f452924g.put("\u5927\u773c", BeautyRealConfig.TYPE.EYE);
        f452924g.put("\u9ed1\u773c\u5708", BeautyRealConfig.TYPE.REMOVE_POUNCH);
    }

    private void k() {
        f452924g = new HashMap<>();
        j();
    }

    private boolean l() {
        HashMap<String, List<C11707a>> hashMap;
        List<b> list = this.f452929e;
        return list != null && list.size() > 0 && (hashMap = this.f452930f) != null && hashMap.size() > 0;
    }

    public void a() {
        List<C11707a> list = this.f452928d;
        if (list != null && list.size() > 0) {
            e(this.f452928d);
        }
        if (l()) {
            Iterator<Map.Entry<String, List<C11707a>>> it = this.f452930f.entrySet().iterator();
            while (it.hasNext()) {
                e(it.next().getValue());
            }
            c(this.f452929e);
            List<C11707a> list2 = this.f452928d;
            if (list2 != null) {
                list2.addAll(f());
            } else {
                this.f452928d = f();
            }
            QLog.i("AutoTestConfigBeans", 4, "checkBeans | autoTestNode size:" + this.f452928d.size());
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public String f452947a;

        /* renamed from: b, reason: collision with root package name */
        public int f452948b;

        /* renamed from: c, reason: collision with root package name */
        public int f452949c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f452950d;

        /* renamed from: e, reason: collision with root package name */
        public String f452951e;

        /* renamed from: f, reason: collision with root package name */
        private String f452952f;

        /* renamed from: g, reason: collision with root package name */
        private String f452953g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f452954h;

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            String str;
            if (this.f452952f != null || (str = this.f452947a) == null) {
                return;
            }
            String str2 = str.split(File.separator)[r0.length - 1];
            int lastIndexOf = str2.lastIndexOf(46);
            if (lastIndexOf < 0) {
                return;
            }
            this.f452952f = str2.substring(0, lastIndexOf);
            this.f452953g = str2.substring(lastIndexOf);
            QLog.i("AutoTestConfigBeans", 4, "file name:" + this.f452952f + ",suffix:" + this.f452953g);
        }

        C11707a c(C11707a c11707a, String str) {
            C11707a c16;
            if (c11707a == null) {
                c16 = new C11707a();
            } else {
                c16 = c11707a.c();
            }
            c16.f452931a = this.f452947a;
            c16.f452933c = this.f452948b;
            c16.f452934d = this.f452949c;
            c16.f452936f = this.f452950d;
            c16.f452935e = "/sdcard/qq_img_auto_test/result_imgs/" + str + this.f452951e + File.separator + this.f452952f + c16.f452944n + this.f452953g;
            return c16;
        }
    }

    private void c(List<b> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private void b(b bVar) {
        if (bVar == null || !bVar.f452950d || TextUtils.isEmpty(bVar.f452947a)) {
            return;
        }
        bVar.b();
        bVar.f452947a = "/sdcard/qq_img_auto_test/test_imgs/" + bVar.f452947a;
    }

    private void d(C11707a c11707a) {
        if (c11707a == null) {
            return;
        }
        if (c11707a.f452937g == null) {
            c11707a.f452937g = new HashMap<>();
        }
        if (c11707a.f452932b) {
            return;
        }
        c11707a.f452945o = g();
        for (Map.Entry<String, Integer> entry : c11707a.f452937g.entrySet()) {
            BeautyRealConfig.TYPE type = f452924g.get(entry.getKey());
            if (type == null) {
                QLog.e("AutoTestConfigBeans", 4, "can not find related TYPE for param key: " + entry.getKey());
            } else {
                c11707a.f452945o.put(type, entry.getValue());
            }
        }
        d dVar = c11707a.f452941k;
        if (dVar == null) {
            c11707a.f452941k = i();
        } else if (!TextUtils.isEmpty(dVar.f452959a)) {
            c11707a.f452941k.f452959a = "/sdcard/qq_img_auto_test/materials/" + c11707a.f452941k.f452959a;
        }
        d dVar2 = c11707a.f452943m;
        if (dVar2 == null) {
            c11707a.f452943m = i();
        } else if (!TextUtils.isEmpty(dVar2.f452959a)) {
            c11707a.f452943m.f452959a = "/sdcard/qq_img_auto_test/lut_res/" + c11707a.f452943m.f452959a;
        }
        if (c11707a.f452939i == null) {
            c11707a.f452939i = i();
        }
        if (c11707a.f452940j == null) {
            c11707a.f452940j = i();
        }
        if (c11707a.f452938h == null) {
            c11707a.f452938h = h();
        }
    }
}
