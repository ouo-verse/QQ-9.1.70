package t4;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.BaseAdapter;
import androidx.fragment.app.Fragment;
import com.qzone.album.business.search.SearchFilterComposition;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f435372a;

    public static a N() {
        if (f435372a == null) {
            com.qzone.album.env.common.b.a();
        }
        return f435372a;
    }

    public static void S(a aVar) {
        f435372a = aVar;
    }

    public abstract void A(Fragment fragment);

    public abstract void B(Activity activity, long j3, ArrayList<AlbumCacheData> arrayList, ArrayList<PhotoCacheData> arrayList2, int i3, boolean z16, boolean z17, int i16, View view);

    public abstract void C(Activity activity, long j3, AlbumCacheData albumCacheData, SearchFilterComposition searchFilterComposition, int i3, List<PhotoCacheData> list, int i16, boolean z16, String str);

    public abstract void D(Activity activity, long j3, AlbumCacheData albumCacheData, SearchFilterComposition searchFilterComposition, int i3, List<PhotoCacheData> list, int i16, boolean z16, String str, int i17, ArrayList<String> arrayList, int i18, int i19);

    public abstract Activity E(Activity activity);

    public abstract Handler F(Activity activity);

    public abstract int G(Activity activity, View view);

    public abstract View H(Activity activity);

    public abstract boolean I(Activity activity, View view);

    public abstract boolean J(Activity activity);

    public abstract boolean K(Activity activity, View view);

    public abstract void L(Activity activity, View view, int i3);

    public abstract void M(Activity activity);

    public abstract boolean O(String str);

    public abstract Intent P(Activity activity, AlbumCacheData albumCacheData, long j3);

    public abstract String Q(Object obj);

    public abstract String R(Object obj);

    public abstract Intent T(Activity activity, AlbumCacheData albumCacheData, long j3, SearchFilterComposition searchFilterComposition);

    public abstract Intent U(Activity activity, AlbumCacheData albumCacheData, int i3, String str, long j3);

    public abstract void V(String str, boolean z16);

    public abstract void a(Activity activity);

    public abstract boolean b(Intent intent);

    public abstract long c(Activity activity, Intent intent);

    public abstract void d(Activity activity);

    public abstract void e(Activity activity);

    public abstract void f(Fragment fragment, String str, int i3);

    public abstract void g(Activity activity);

    public abstract void h(Intent intent);

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public abstract void l();

    public abstract boolean m();

    public abstract void n(Fragment fragment);

    public abstract void o(Fragment fragment, AlbumCacheData albumCacheData, long j3);

    public abstract Intent p(Fragment fragment, String str);

    public abstract Intent q(Fragment fragment, AlbumCacheData albumCacheData, int i3, String str, long j3);

    public abstract void r(Fragment fragment, int i3);

    public abstract void s(Fragment fragment, Intent intent);

    public abstract void t(Fragment fragment, ArrayList<String> arrayList);

    public abstract void u(Activity activity, BaseAdapter baseAdapter);

    public abstract void v();

    public abstract void w();

    public abstract void x(Fragment fragment);

    public abstract int y(Fragment fragment, String str, String str2);

    public abstract void z(Fragment fragment);
}
