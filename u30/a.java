package u30;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f438175a = new AtomicInteger(2);

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Boolean> f438176b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Set<String> f438177c = new CopyOnWriteArraySet();

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("PIC_LOAD_QFSPictureDataCache", 1, "[addQueueTask] check key should not be null.");
        } else {
            this.f438177c.add(str);
        }
    }

    public int b() {
        return this.f438175a.get();
    }

    public int c() {
        return this.f438177c.size();
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("PIC_LOAD_QFSPictureDataCache", 1, "[isExistsPreloadPicTask] cache key should not be null.");
            return false;
        }
        return this.f438176b.containsKey(str);
    }

    public void e() {
        this.f438176b.clear();
        this.f438177c.clear();
        this.f438175a.set(2);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("PIC_LOAD_QFSPictureDataCache", 1, "[removeQueueTask] cache key should not be null.");
            return;
        }
        this.f438177c.remove(str);
        QLog.d("PIC_LOAD_QFSPictureDataCache", 1, "[removeQueueTask] path file: " + str);
    }

    public void g(int i3) {
        this.f438175a.set(i3);
    }

    public void h(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("PIC_LOAD_QFSPictureDataCache", 1, "[updatePicPreloadCache] cache key should not be null.");
        } else {
            this.f438176b.put(str, Boolean.valueOf(z16));
        }
    }
}
