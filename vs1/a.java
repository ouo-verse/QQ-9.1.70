package vs1;

import androidx.annotation.NonNull;
import com.tencent.util.AppSetting;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f443284a;

    /* renamed from: b, reason: collision with root package name */
    private int f443285b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f443286c = new Object();

    public a(int i3) {
        if (i3 >= 0) {
            this.f443284a = new Object[i3];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be >= 0");
    }

    private boolean c(@NonNull T t16) {
        for (int i3 = 0; i3 < this.f443285b; i3++) {
            if (this.f443284a[i3] == t16) {
                return true;
            }
        }
        return false;
    }

    public T a() {
        synchronized (this.f443286c) {
            int i3 = this.f443285b;
            if (i3 <= 0) {
                return null;
            }
            int i16 = i3 - 1;
            Object[] objArr = this.f443284a;
            T t16 = (T) objArr[i16];
            objArr[i16] = null;
            this.f443285b = i3 - 1;
            return t16;
        }
    }

    public int b() {
        int i3;
        synchronized (this.f443286c) {
            i3 = this.f443285b;
        }
        return i3;
    }

    public boolean d(@NonNull T t16) {
        synchronized (this.f443286c) {
            if (!AppSetting.isPublicVersion() && c(t16)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i3 = this.f443285b;
            Object[] objArr = this.f443284a;
            if (i3 < objArr.length) {
                objArr[i3] = t16;
                this.f443285b = i3 + 1;
                return true;
            }
            return false;
        }
    }
}
