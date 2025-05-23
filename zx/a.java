package zx;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public long f453621a;

    /* renamed from: b, reason: collision with root package name */
    public long f453622b;

    /* renamed from: c, reason: collision with root package name */
    public long f453623c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f453624d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<b> f453625e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<b> f453626f = new ArrayList<>();

    public ArrayList<b> b() {
        return this.f453626f;
    }

    public ArrayList<b> c() {
        return this.f453625e;
    }

    public void d(ArrayList<String> arrayList) {
        this.f453626f.clear();
        int size = arrayList == null ? 0 : arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = arrayList.get(i3);
            if (!TextUtils.isEmpty(str)) {
                b bVar = new b();
                bVar.b(str);
                this.f453626f.add(bVar);
            }
        }
        this.f453625e.addAll(this.f453626f);
        if (QLog.isColorLevel()) {
            QLog.d("parceJson2DynamicInfoItemList", 2, "mDynamicInfoList.size():" + this.f453626f.size());
        }
    }

    public void a(ArrayList<b> arrayList) {
        if (arrayList != null) {
            this.f453625e.addAll(arrayList);
        }
        if (QLog.isColorLevel()) {
            QLog.d("addOldDynamicInfoItemList", 2, "mDynamicInfoList.size():" + this.f453625e.size());
        }
    }
}
