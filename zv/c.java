package zv;

import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static volatile c f453527b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f453528a;

    c() {
        HashMap hashMap = new HashMap();
        this.f453528a = hashMap;
        hashMap.put(Const.BUNDLE_KEY_REQUEST, new String("-1"));
        this.f453528a.put("update", new String("-1"));
        this.f453528a.put("load", new String("-1"));
    }

    public static c c() {
        if (f453527b == null) {
            synchronized (c.class) {
                if (f453527b == null) {
                    f453527b = new c();
                }
            }
        }
        return f453527b;
    }

    public void a(String str, int i3) {
        try {
            this.f453528a.put(str, String.valueOf(i3));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public String b(String str) {
        return this.f453528a.get(str);
    }
}
