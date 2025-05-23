package sz;

import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.player.e;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.List;
import mz.d;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a extends com.tencent.biz.pubaccount.weishi.presenter.a<com.tencent.biz.pubaccount.weishi.drama.c> implements com.tencent.biz.pubaccount.weishi.drama.b, jz.c<d> {

    /* renamed from: f, reason: collision with root package name */
    private boolean f434999f;

    private void B0(int i3, String str, boolean z16) {
        x.f("AbsWSDramaPagePresenterLog", "[AbsWSDramaPagePresenter.java][handleOnFailed] errorCode:" + i3 + ", errorMsg:" + str + ", isFirst:" + z16);
        com.tencent.biz.pubaccount.weishi.drama.c x06 = x0();
        if (x06 == null) {
            return;
        }
        this.f434999f = false;
        x06.hideLoading();
        F0(i3, str);
    }

    private void C0(List<d> list, boolean z16, boolean z17, Object obj) {
        com.tencent.biz.pubaccount.weishi.drama.c x06 = x0();
        if (x06 == null) {
            return;
        }
        this.f434999f = false;
        x06.hideLoading();
        if (list.size() > 0) {
            D0(list, E0(z16, z17, list, obj));
        } else {
            F0(-1, "");
        }
    }

    private void D0(List<d> list, boolean z16) {
        com.tencent.biz.pubaccount.weishi.drama.c x06 = x0();
        if (x06 == null) {
            return;
        }
        if (z16) {
            x06.c(list);
        } else {
            x06.setData(list);
        }
    }

    private void F0(int i3, String str) {
        com.tencent.biz.pubaccount.weishi.drama.c x06 = x0();
        if (x06 == null || x06.getAdapter() == null || !x06.getAdapter().isEmpty()) {
            return;
        }
        x06.O0(i3, str);
    }

    private String getFrom() {
        com.tencent.biz.pubaccount.weishi.drama.c x06 = x0();
        if (x06 != null) {
            return x06.getFrom();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public pz.b A0() {
        com.tencent.biz.pubaccount.weishi.drama.a z06 = z0();
        if (z06 != null) {
            return z06.r();
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.b
    public void U0(boolean z16, boolean z17) {
        if (this.f434999f) {
            return;
        }
        this.f434999f = y0(z16, z17, getFrom());
    }

    @Override // jz.c
    public void d0(List<d> list, boolean z16, boolean z17, Object obj) {
        C0(list, z16, z17, obj);
    }

    @Override // jz.c
    public void i(int i3, String str, boolean z16, boolean z17) {
        B0(i3, str, z16);
    }

    public abstract boolean y0(boolean z16, boolean z17, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public com.tencent.biz.pubaccount.weishi.drama.a z0() {
        com.tencent.biz.pubaccount.weishi.drama.c x06 = x0();
        if (x06 != null) {
            return x06.getAdapter();
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.b
    public void c() {
        U0(true, false);
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.b
    public void doOnPause() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.b
    public void doOnResume() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.b
    public void S0(e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.b
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.b
    public void d(e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.b
    public void T0(RecyclerView.ViewHolder viewHolder, int i3) {
    }

    public boolean E0(boolean z16, boolean z17, List<d> list, Object obj) {
        return z17;
    }
}
