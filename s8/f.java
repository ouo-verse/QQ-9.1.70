package s8;

import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.util.QZLog;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f {

    /* renamed from: g, reason: collision with root package name */
    public static int f433427g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static f f433428h;

    /* renamed from: b, reason: collision with root package name */
    private String f433430b;

    /* renamed from: a, reason: collision with root package name */
    private volatile QQConcurrentHashMap<String, String> f433429a = null;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f433431c = QZoneConfigHelper.N0();

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f433432d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f433433e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f433434f = new Runnable() { // from class: s8.e
        @Override // java.lang.Runnable
        public final void run() {
            f.this.i();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a implements com.tencent.cache.api.c {
        a() {
        }

        @Override // com.tencent.cache.api.c
        public void onClearEnd() {
            f.this.f433432d.set(false);
            if (f.this.f433429a != null) {
                synchronized (f.class) {
                    if (f.this.f433429a != null) {
                        f.this.f433429a.clear();
                        f.this.f433429a = null;
                    }
                }
            }
            QLog.e("FeedDataNickNameHelper", 1, "nick name cache clear end!");
            if (com.qzone.reborn.configx.g.f53821a.b().o0()) {
                f.this.k();
            }
        }

        @Override // com.tencent.cache.api.c
        public void onClearStart() {
            QLog.e("FeedDataNickNameHelper", 1, "nick name cache clear start!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f433436a;

        /* renamed from: b, reason: collision with root package name */
        public QQConcurrentHashMap<String, String> f433437b = new QQConcurrentHashMap<>(Business.QZone, "FeedDataNickNameHelper");
    }

    public static f f() {
        if (f433428h == null) {
            synchronized (f.class) {
                if (f433428h == null) {
                    f433428h = new f();
                }
            }
        }
        return f433428h;
    }

    public static boolean h() {
        return f433427g == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        if (this.f433433e.get()) {
            return;
        }
        synchronized (f.class) {
            this.f433433e.set(true);
            if (!this.f433432d.get()) {
                j();
            }
            this.f433433e.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f433432d.get()) {
            return;
        }
        RFWThreadManager.getInstance().execOnFileThread(this.f433434f);
    }

    private void l(Cursor cursor, b bVar, int i3, int i16, String str) {
        String string = cursor.getString(i3);
        if (!TextUtils.isEmpty(string)) {
            bVar.f433437b.put(str, string);
            return;
        }
        String string2 = cursor.getString(i16);
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        if (string2.length() > 1 && string2.charAt(string2.length() - 1) == '\n') {
            string2 = string2.substring(0, string2.length() - 1);
        }
        bVar.f433437b.put(str, string2);
    }

    private void m(Cursor cursor, b bVar, int i3, int i16, String str) throws UnsupportedEncodingException {
        String decode = SecurityUtile.decode(new String(str.getBytes(), "utf-8"), false);
        String string = cursor.getString(i3);
        if (!TextUtils.isEmpty(string)) {
            bVar.f433437b.put(decode, SecurityUtile.decode(new String(string.getBytes(), "utf-8"), false));
            return;
        }
        String string2 = cursor.getString(i16);
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        String decode2 = SecurityUtile.decode(new String(string2.getBytes(), "utf-8"), false);
        if (decode2.length() > 1 && decode2.charAt(decode2.length() - 1) == '\n') {
            decode2 = decode2.substring(0, decode2.length() - 1);
        }
        bVar.f433437b.put(decode, decode2);
    }

    public String g(String str) {
        QQConcurrentHashMap<String, String> qQConcurrentHashMap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!TextUtils.equals(this.f433430b, LoginData.getInstance().getUinString())) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                b j3 = j();
                if (j3 != null && (qQConcurrentHashMap = j3.f433437b) != null && qQConcurrentHashMap.size() > 0) {
                    return j3.f433437b.get(str);
                }
            } else {
                k();
            }
        } else {
            if (this.f433429a != null && this.f433429a.size() > 0) {
                return this.f433429a.get(str);
            }
            k();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b j() {
        Cursor cursor;
        boolean z16;
        String string;
        String[] strArr = {"uin", "remark", "name"};
        b bVar = new b();
        String uinString = LoginData.getInstance().getUinString();
        bVar.f433436a = uinString;
        this.f433430b = uinString;
        try {
            cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), Uri.parse("content://qq.friendlist/friendlist/" + LoginData.getInstance().getUin()), strArr, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("uin");
                        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("remark");
                        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("name");
                        if (!this.f433431c && MobileQQ.sProcessId == 1) {
                            z16 = false;
                            do {
                                string = cursor.getString(columnIndexOrThrow);
                                if (!TextUtils.isEmpty(string)) {
                                    if (z16) {
                                        m(cursor, bVar, columnIndexOrThrow2, columnIndexOrThrow3, string);
                                    } else {
                                        l(cursor, bVar, columnIndexOrThrow2, columnIndexOrThrow3, string);
                                    }
                                }
                            } while (cursor.moveToNext());
                            this.f433429a = bVar.f433437b;
                            this.f433429a.setCacheListener(new a());
                            this.f433432d.set(true);
                        }
                        z16 = true;
                        do {
                            string = cursor.getString(columnIndexOrThrow);
                            if (!TextUtils.isEmpty(string)) {
                            }
                        } while (cursor.moveToNext());
                        this.f433429a = bVar.f433437b;
                        this.f433429a.setCacheListener(new a());
                        this.f433432d.set(true);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        QZLog.e("FeedDataNickNameHelper", "getFriendListFromQQ occuer Exception,infor=" + QZLog.getStackTraceString(th));
                        th.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            return bVar;
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }
}
