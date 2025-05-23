package wp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f446005b;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, View> f446006a = new ConcurrentHashMap<>();

    a() {
    }

    public static a a() {
        if (f446005b == null) {
            synchronized (a.class) {
                if (f446005b == null) {
                    f446005b = new a();
                }
            }
        }
        return f446005b;
    }

    public View b(int i3) {
        return this.f446006a.remove(Integer.valueOf(i3));
    }

    public void c(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        this.f446006a.put(Integer.valueOf(R.layout.dny), from.inflate(R.layout.dny, (ViewGroup) null));
        this.f446006a.put(Integer.valueOf(R.layout.dnv), from.inflate(R.layout.dnv, (ViewGroup) null));
    }
}
