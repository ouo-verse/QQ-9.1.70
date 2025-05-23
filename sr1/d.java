package sr1;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes14.dex */
public interface d {
    boolean a();

    void addGestureListener(rr1.a aVar);

    void b(int i3);

    void c(int i3);

    void d(Intent intent);

    int e();

    boolean f();

    void g(int i3);

    boolean h();

    void i(boolean z16);

    boolean j();

    void k(View view, ViewGroup viewGroup, ViewGroup viewGroup2, ViewGroup viewGroup3);

    boolean l();

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();

    void removeGestureListener(rr1.a aVar);
}
