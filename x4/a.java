package x4;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.LoveAlbumTimeEvent;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.widget.QZonePullToRefreshListView;
import java.util.ArrayList;
import s4.d;

/* compiled from: P */
/* loaded from: classes36.dex */
public interface a {
    boolean A();

    View.OnClickListener B(LoveAlbumTimeEvent loveAlbumTimeEvent, long j3);

    long C();

    boolean D();

    boolean E();

    View.OnClickListener a(int i3, int i16);

    int b();

    boolean c();

    void d(String str);

    void e(PhotoCacheData photoCacheData, int i3);

    boolean f();

    AlbumCacheData g();

    LayoutInflater getLayoutInflater();

    QZonePullToRefreshListView getListView();

    Resources getResources();

    boolean h();

    View.OnClickListener i();

    View.OnClickListener j(PhotoPoiArea photoPoiArea);

    Context k();

    int l();

    boolean m();

    View.OnClickListener n(d dVar);

    ArrayList<Integer> o();

    ArrayList<String> p();

    View.OnClickListener q(PhotoPoiArea photoPoiArea);

    View.OnClickListener r(PhotoCacheData photoCacheData);

    View.OnClickListener s(int i3, int i16, String str, PhotoCacheData photoCacheData, d dVar);

    void t(PhotoCacheData photoCacheData, int i3);

    View.OnClickListener u(PhotoCacheData photoCacheData);

    View.OnClickListener v(PhotoPoiArea photoPoiArea);

    boolean w();

    View.OnClickListener x(PhotoCacheData[] photoCacheDataArr, d dVar);

    boolean y();

    View.OnClickListener z(int i3, int i16, String str, PhotoCacheData photoCacheData, d dVar);
}
