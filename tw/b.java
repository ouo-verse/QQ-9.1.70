package tw;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static final c f437858c = new c(21, 4, 1.1f, 2.7f);

    /* renamed from: d, reason: collision with root package name */
    private static final c f437859d = new c(27, 8, 1.8f, 5.0f);

    /* renamed from: a, reason: collision with root package name */
    private a f437860a = null;

    /* renamed from: b, reason: collision with root package name */
    private int f437861b = 0;

    public b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            f437858c.c(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            f437859d.c(str2);
        }
        if (QLog.isColorLevel()) {
            QLog.i("MachineLevelHelper", 2, String.format("init, middle[%s], high[%s], config[%s, %s]", f437858c, f437859d, str, str2));
        }
    }

    public int a() {
        int i3 = this.f437861b;
        if (i3 != 0) {
            return i3;
        }
        if (this.f437860a == null) {
            this.f437860a = a.a();
        }
        c cVar = f437859d;
        if (cVar.b(this.f437860a)) {
            this.f437861b = 7;
        } else if (f437858c.b(this.f437860a)) {
            this.f437861b = 4;
        } else {
            this.f437861b = 3;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MachineLevelHelper", 2, String.format("getCurMachineLevel, level: %s, middle[%s], high[%s], cur[%s]", Integer.valueOf(this.f437861b), f437858c, cVar, this.f437860a));
        }
        return this.f437861b;
    }
}
