package wd2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.api.ISecurityUtile;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import uq3.c;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    protected static final Object f445480d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, ArrayList<String>> f445481a = new ConcurrentHashMap(32);

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, ArrayList<String>> f445482b = new ConcurrentHashMap(32);

    /* renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f445483c;

    public a(SQLiteDatabase sQLiteDatabase) {
        this.f445483c = sQLiteDatabase;
    }

    private ArrayList<String> a(String str) {
        if (this.f445482b.containsKey(str)) {
            return this.f445482b.get(str);
        }
        Matcher matcher = Pattern.compile("\\s*\\w+\\s*(!<|!>|>|<|==|=|>=|<=|!=|=!|<>)\\s*\\?\\s*").matcher(str);
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            Matcher matcher2 = Pattern.compile("\\w+").matcher(matcher.group().trim());
            matcher2.find();
            arrayList.add(matcher2.group());
        }
        this.f445482b.put(str, arrayList);
        return arrayList;
    }

    private ArrayList<String> b(String str, String[] strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("QCircleDbCacheDatabase.EncryptUtil", 2, str);
        }
        try {
            String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str2 : strArr) {
                String trim = str2.toLowerCase().trim();
                for (String str3 : split) {
                    String[] split2 = str3.trim().split(" ");
                    if (split2.length > 1 && trim.equals(split2[1].toLowerCase())) {
                        arrayList.add(split2[0]);
                    }
                }
            }
            return arrayList;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QCircleDbCacheDatabase.EncryptUtil", 2, "analyseTableField exception: ", e16);
            }
            return new ArrayList<>();
        }
    }

    private byte[] c(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return ((ISecurityUtile) QRoute.api(ISecurityUtile.class)).encode(bArr);
        }
        return bArr;
    }

    public static String f(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.startsWith("@$#%&^")) {
            return str;
        }
        synchronized (f445480d) {
            String substring = str.substring(6);
            if (substring.length() > 0) {
                str2 = ((ISecurityUtile) QRoute.api(ISecurityUtile.class)).encode(substring);
            } else {
                str2 = substring;
            }
            if (TextUtils.isEmpty(str2) || str2.equals(substring)) {
                try {
                    LockMethodProxy.sleep(200L);
                } catch (Exception e16) {
                    QLog.e("QCircleDbCacheDatabase.EncryptUtil", 1, e16, new Object[0]);
                }
                str2 = ((ISecurityUtile) QRoute.api(ISecurityUtile.class)).encode(substring);
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.equals(substring)) {
                    }
                }
                LocalMultiProcConfig.putInt4Uin("dbencrypt_" + QUA.getQUA3(), 0, QCircleHostStubUtil.getCurrentAccountLongUin());
                return str2;
            }
            return str2;
        }
    }

    public static String g(String str) {
        String str2;
        if (!i()) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith("@$#%&^")) {
            return str;
        }
        if (str.length() > 0) {
            str2 = ((ISecurityUtile) QRoute.api(ISecurityUtile.class)).encode(str);
        } else {
            str2 = str;
        }
        if (!TextUtils.isEmpty(str2) && !str2.equals(str)) {
            return "@$#%&^" + str2;
        }
        return str;
    }

    public static boolean i() {
        int intValue = c.X0("QZoneSetting", "db_encryption", 0).intValue();
        int int4Uin = LocalMultiProcConfig.getInt4Uin("dbencrypt_" + QUA.getQUA3(), 1, QCircleHostStubUtil.getCurrentAccountLongUin());
        if (intValue != 1 || int4Uin != 1) {
            return false;
        }
        return true;
    }

    public static boolean j(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        return false;
    }

    private Cursor k(String str, String[] strArr) {
        try {
            Cursor rawQuery = this.f445483c.rawQuery(str, strArr);
            if (rawQuery == null) {
                return null;
            }
            try {
                return new com.tencent.mobileqq.qcircle.api.db.c(rawQuery, this.f445483c.getPath());
            } catch (Throwable unused) {
                return rawQuery;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public ContentValues d(String str, String str2, ContentValues contentValues) {
        if (contentValues != null && contentValues.size() > 0) {
            if (!j(str, str2)) {
                return contentValues;
            }
            ContentValues contentValues2 = new ContentValues(contentValues);
            ArrayList<String> h16 = h(str2);
            if (h16 != null) {
                Iterator<String> it = h16.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (contentValues.containsKey(next)) {
                        Object obj = contentValues.get(next);
                        if (obj instanceof String) {
                            String str3 = (String) contentValues.get(next);
                            if (str3 != null && str3.length() > 0) {
                                contentValues2.put(next, g(str3));
                            }
                        } else if (obj instanceof byte[]) {
                            contentValues2.put(next, c((byte[]) obj));
                        } else if (obj instanceof Long) {
                            contentValues2.put(next, g(String.valueOf(obj)));
                        } else if (obj instanceof Integer) {
                            contentValues2.put(next, g(String.valueOf(obj)));
                        } else if (obj instanceof Double) {
                            contentValues2.put(next, g(String.valueOf(obj)));
                        }
                    }
                }
            }
            return contentValues2;
        }
        return contentValues;
    }

    public void e(String str, String str2, String str3, String[] strArr) {
        ArrayList<String> h16;
        if (str3 != null && strArr != null && j(str, str2) && (h16 = h(str2)) != null) {
            ArrayList<String> a16 = a(str3);
            for (int i3 = 0; i3 < a16.size(); i3++) {
                if (h16.contains(a16.get(i3))) {
                    strArr[i3] = g(strArr[i3]);
                }
            }
        }
    }

    public ArrayList<String> h(String str) {
        Cursor k3;
        if (!i()) {
            return null;
        }
        if (!this.f445481a.containsKey(str) && (k3 = k("select sql from sqlite_master where type=? and name=?", new String[]{"table", str})) != null) {
            if (k3.moveToFirst()) {
                this.f445481a.put(str, b(k3.getString(0), new String[]{"STRING"}));
            }
            k3.close();
        }
        return this.f445481a.get(str);
    }
}
