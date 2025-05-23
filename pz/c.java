package pz;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.drama.WSDramaPageFragment;
import com.tencent.mobileqq.R;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class c extends com.tencent.biz.pubaccount.weishi.baseui.a<mz.d> {

    /* renamed from: i, reason: collision with root package name */
    private qz.c f428081i;

    /* renamed from: m, reason: collision with root package name */
    private final WeakReference<com.tencent.biz.pubaccount.weishi.drama.c> f428082m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.j();
        }
    }

    public c(Context context, View view, com.tencent.biz.pubaccount.weishi.drama.c cVar) {
        super(context, view);
        this.f428082m = new WeakReference<>(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        com.tencent.biz.pubaccount.weishi.drama.c cVar = this.f428082m.get();
        if (cVar instanceof WSDramaPageFragment) {
            vz.a.o((WSDramaPageFragment) cVar, ((mz.d) this.f80417h).d(), ((mz.d) this.f80417h).f(), vz.a.f443763a);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void a() {
        qz.c cVar = new qz.c(this.f80416f);
        this.f428081i = cVar;
        g(R.id.f1182673o, cVar);
        this.f80414d.setOnClickListener(new a());
    }

    public qz.c i() {
        return this.f428081i;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void c() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void d() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void e(int i3) {
    }
}
