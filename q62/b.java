package q62;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Pair<Integer, Integer>[][] f428451a;

    private static Pair<Integer, Integer>[][] a() {
        Pair<Integer, Integer>[][] pairArr = f428451a;
        if (pairArr[0] != null) {
            Pair<Integer, Integer>[] pairArr2 = pairArr[1];
        }
        return pairArr;
    }

    public static String b(String str, int i3, int i16) {
        Pair<Integer, Integer>[] a16;
        if (!ReadInJoyHelper.B(com.tencent.mobileqq.kandian.base.utils.b.c())) {
            if (QLog.isColorLevel()) {
                QLog.d("RIJSmartCropUtils", 2, "smart crop switch is false ! url : " + str);
            }
            return str;
        }
        if (TextUtils.isEmpty(str) || !str.startsWith("http://qqpublic.qpic.cn")) {
            return str;
        }
        String[] split = str.split("/");
        if (split.length < 2) {
            return str;
        }
        String[] split2 = split[split.length - 2].split("_");
        if (split2.length < 1) {
            return str;
        }
        String str2 = split2[split2.length - 1];
        Pair<Integer, Integer>[][] a17 = a();
        if ("open".equals(str2)) {
            if (a17.length != 2 || (a16 = a17[1]) == null) {
                a16 = u62.a.a(str, 0);
            }
        } else {
            if (!"vsmcut".equals(str2)) {
                return str;
            }
            if (a17.length != 2 || (a16 = a17[0]) == null) {
                a16 = u62.a.a(str, 1);
            }
        }
        Pair<Integer, Integer> a18 = a.a(a16, i3, i16);
        if (a18 == null) {
            return str;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RIJSmartCropUtils", 2, "the picture size : w : " + i3 + " h : " + i16 + ", select scale : " + a18.first + ":" + a18.second);
        }
        String str3 = split[split.length - 1];
        return str.replace(String.format("_%s/%s", str2, str3), String.format("_%s_%d_%d/%s", str2, a18.first, a18.second, str3));
    }

    static {
        f428451a = r0;
        Pair<Integer, Integer>[][] pairArr = {null, null};
    }
}
