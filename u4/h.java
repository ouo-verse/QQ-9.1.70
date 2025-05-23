package u4;

import android.os.Handler;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.qzone.album.ui.widget.QzoneGestureSelectListView;
import com.tencent.widget.AbsListView;

/* compiled from: P */
/* loaded from: classes36.dex */
public interface h {
    void E1(String str, String str2);

    void J();

    void J1();

    void L0(int i3);

    void N1(s4.e eVar);

    void P(int i3, View.OnClickListener onClickListener, boolean z16);

    boolean X0();

    boolean checkNetworkConnect();

    void e1(int i3);

    void finish();

    void g1();

    Handler getHandler();

    QzoneGestureSelectListView getListView();

    void i1(s4.e eVar);

    void j1(int i3);

    void m0(int i3);

    void notifyAdapter(BaseAdapter baseAdapter);

    int s1(int i3, AbsListView absListView, int i16);

    void setTitle(String str);

    void t();

    TextView u();

    TextView v();

    TextView x();

    void y();

    boolean z();

    p4.c z2();
}
