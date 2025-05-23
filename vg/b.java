package vg;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jo.h;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b implements c {

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<a> f441568d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, View> f441569e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private int f441570f;

    private String d(a aVar, String str) {
        return aVar.getTAG() + "#" + str;
    }

    public void a(int i3, View view) {
        this.f441569e.put(Integer.valueOf(i3), view);
    }

    public void b(cf.b bVar) {
        Iterator<a> it = this.f441568d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            k(next, "handleBroadcastMessage");
            next.t(bVar);
            j(next, "handleBroadcastMessage");
        }
    }

    @Override // vg.c
    public void c() {
        Iterator<a> it = this.f441568d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            k(next, "onResumed");
            next.c();
            j(next, "onResumed");
        }
    }

    public int e() {
        return this.f441570f;
    }

    public Object f(Class<? extends a> cls) {
        Iterator<a> it = this.f441568d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getClass() == cls) {
                return next;
            }
        }
        return null;
    }

    public ArrayList<a> g() {
        return this.f441568d;
    }

    public View h(int i3) {
        return this.f441569e.get(Integer.valueOf(i3));
    }

    public void i(View view, ViewGroup viewGroup) {
        Iterator<a> it = this.f441568d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            k(next, "initView");
            next.G(viewGroup);
            next.u(view);
            j(next, "initView");
        }
    }

    public void l() {
        Iterator<a> it = this.f441568d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            k(next, NodeProps.ON_ATTACHED_TO_WINDOW);
            next.z();
            j(next, NodeProps.ON_ATTACHED_TO_WINDOW);
        }
    }

    public void m() {
        Iterator<a> it = this.f441568d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            k(next, NodeProps.ON_DETACHED_FROM_WINDOW);
            next.B();
            j(next, NodeProps.ON_DETACHED_FROM_WINDOW);
        }
    }

    public void o(BusinessFeedData businessFeedData, int i3) {
        Iterator<a> it = this.f441568d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            k(next, "onBindData");
            next.E(businessFeedData, i3);
            j(next, "onBindData");
        }
    }

    @Override // vg.c
    public void onDestroy() {
        Iterator<a> it = this.f441568d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            k(next, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            next.onDestroy();
            j(next, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // vg.c
    public void onPaused() {
        Iterator<a> it = this.f441568d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            k(next, "onPaused");
            next.onPaused();
            j(next, "onPaused");
        }
    }

    @Override // vg.c
    public void onStop() {
        Iterator<a> it = this.f441568d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            k(next, DKHippyEvent.EVENT_STOP);
            next.onStop();
            j(next, DKHippyEvent.EVENT_STOP);
        }
    }

    @Override // vg.c
    public void onViewHolderAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        Iterator<a> it = this.f441568d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            k(next, "onViewHolderAttachedToWindow");
            next.onViewHolderAttachedToWindow(viewHolder);
            j(next, "onViewHolderAttachedToWindow");
        }
    }

    @Override // vg.c
    public void onViewHolderDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        Iterator<a> it = this.f441568d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            k(next, "onViewHolderDetachedFromWindow");
            next.onViewHolderDetachedFromWindow(viewHolder);
            j(next, "onViewHolderDetachedFromWindow");
        }
    }

    public void p(int i3) {
        this.f441570f = i3;
    }

    public void n(List<Class<? extends a>> list) {
        if (list == null) {
            QLog.e("QZoneFeedPresenterManager", 1, "registerPresenters  presenterClasses == null");
            return;
        }
        Iterator<Class<? extends a>> it = list.iterator();
        while (it.hasNext()) {
            try {
                a newInstance = it.next().newInstance();
                if (newInstance.y()) {
                    this.f441568d.add(newInstance);
                    newInstance.F(this);
                }
            } catch (IllegalAccessException | InstantiationException e16) {
                QLog.e("QZoneFeedPresenterManager", 1, "registerPresenters  e = " + e16.getMessage());
            }
        }
    }

    private void j(a aVar, String str) {
        if (aVar != null) {
            h.f410717a.g("section_lifecycle").b(d(aVar, str));
        }
    }

    private void k(a aVar, String str) {
        if (aVar != null) {
            h.f410717a.g("section_lifecycle").h(d(aVar, str));
        }
    }
}
