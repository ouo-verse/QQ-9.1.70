package t5;

import android.text.TextUtils;
import com.qzone.common.business.model.BusinessContentCacheData;
import com.qzone.common.business.service.QZoneContentCacheService;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static QZoneContentCacheService f435422e;

    /* renamed from: a, reason: collision with root package name */
    private int f435423a;

    /* renamed from: b, reason: collision with root package name */
    private String f435424b;

    /* renamed from: c, reason: collision with root package name */
    private String f435425c;

    /* renamed from: d, reason: collision with root package name */
    private BusinessContentCacheData f435426d;

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e().d(str);
    }

    private void c() {
        if (TextUtils.isEmpty(this.f435424b)) {
            return;
        }
        BusinessContentCacheData h16 = e().h(this.f435424b);
        this.f435426d = h16;
        if (h16 != null) {
            this.f435425c = new String(h16.getContent());
            this.f435423a = this.f435426d.getTimestamp();
        }
    }

    public static QZoneContentCacheService e() {
        if (f435422e == null) {
            synchronized (a.class) {
                if (f435422e == null) {
                    f435422e = new QZoneContentCacheService();
                }
            }
        }
        return f435422e;
    }

    public void a() {
        if (TextUtils.isEmpty(this.f435424b)) {
            return;
        }
        e().d(this.f435424b);
        h();
    }

    public String d() {
        String str = this.f435425c;
        return str == null ? "" : str;
    }

    public String f() {
        return this.f435424b;
    }

    public boolean g(String str, int i3, int i16) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i16 != 1) {
            if (i3 - this.f435423a < 5) {
                return false;
            }
            String str2 = this.f435425c;
            if (str2 != null && str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public void i(String str) {
        h();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f435424b = str;
        c();
    }

    public void j(String str, String str2, int i3) {
        if (TextUtils.isEmpty(this.f435424b)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (i3 == 1) {
                a();
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str + "<{@QzOnEaT@}>" + str2;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (g(str, currentTimeMillis, i3)) {
            if (this.f435426d == null) {
                BusinessContentCacheData businessContentCacheData = new BusinessContentCacheData();
                this.f435426d = businessContentCacheData;
                businessContentCacheData.setUnikey(this.f435424b);
            }
            this.f435425c = str;
            this.f435423a = currentTimeMillis;
            this.f435426d.setContent(str);
            this.f435426d.setTimestamp(currentTimeMillis);
            e().l(this.f435426d, i3);
        }
    }

    private void h() {
        this.f435424b = null;
        this.f435425c = null;
        this.f435426d = null;
        this.f435423a = 0;
    }
}
