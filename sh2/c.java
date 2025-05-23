package sh2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
    }

    /* compiled from: P */
    /* renamed from: sh2.c$c, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC11228c extends f {
        boolean H0(boolean z16, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, List<String> list);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface d {
        void c(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16, long j3);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface e {
        void a(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface f {
        boolean D();

        boolean O(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3);

        boolean f();

        boolean h0(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3);

        boolean n1(boolean z16, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, String str);

        void o1(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16);

        boolean r(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3);

        boolean t();

        boolean u0(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3);

        boolean w(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface g {
        void a(String str);
    }

    Context a();

    void d(boolean z16);

    void f();

    void g(int i3);

    ViewGroup getContentView();

    void h(View view, boolean z16, boolean z17);

    void hide();

    LinearLayout k();

    f l(f fVar);

    void m(int i3, int i16);

    nh2.b n();

    void o(b bVar, String str);

    void p(View view);

    void q(boolean z16);

    void r(long j3);

    void setAdapter(RecyclerView.Adapter adapter);

    @Deprecated
    void setCacheList(List<com.tencent.mobileqq.qqgift.data.service.d> list);

    void setCacheTabList(List<com.tencent.mobileqq.qqgift.data.service.e> list);

    void setComboOverListener(d dVar);

    void setComboSendDelayTime(int i3);

    void setDtPageExtra(Map<String, String> map);

    void setDtParams(com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar);

    void setEmptyPackClickListener(View.OnClickListener onClickListener);

    void setFirstShowGiftTabConfig(String str);

    void setOnPanelContentHeightChangeListener(e eVar);

    void setPanelEventListener(f fVar);

    void setPanelStyle(com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar);

    void setSceneData(com.tencent.mobileqq.qqgift.data.service.a aVar);

    void setTabSelectedListener(g gVar);

    void t(long j3);

    long u();

    void v();

    void w(String str);

    void x(List<com.tencent.mobileqq.qqgift.mvvm.business.data.c> list);

    int y();

    View z();
}
