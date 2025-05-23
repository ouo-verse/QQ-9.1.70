package xn2;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends c {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f448190d;

        a(y yVar) {
            this.f448190d = yVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f448190d.v(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(IFaceDecoder iFaceDecoder, com.tencent.mobileqq.search.view.d dVar) {
        super(iFaceDecoder, dVar);
    }

    @Override // xn2.c, qn2.f, qn2.d
    /* renamed from: g */
    public void a(y yVar, sn2.c cVar) {
        super.a(yVar, cVar);
        if (TextUtils.isEmpty(yVar.m())) {
            cVar.k().setVisibility(8);
            ((yn2.b) cVar).q().setVisibility(0);
        } else {
            cVar.k().setVisibility(0);
            cVar.k().setText(yVar.m());
            ((yn2.b) cVar).q().setVisibility(8);
        }
        if (cVar.d() != null) {
            CharSequence o16 = yVar.o();
            if (TextUtils.isEmpty(o16)) {
                cVar.d().setVisibility(8);
            } else {
                cVar.d().setVisibility(0);
                cVar.d().setText(o16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xn2.c, qn2.f
    public void h(y yVar, sn2.c cVar) {
        super.h(yVar, cVar);
        ((yn2.b) cVar).q().setOnClickListener(new a(yVar));
    }

    @Override // qn2.f
    public void m(y yVar, sn2.c cVar) {
    }
}
