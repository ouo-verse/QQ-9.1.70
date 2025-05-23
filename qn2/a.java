package qn2;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.util.al;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.util.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements d<pn2.c, sn2.e>, b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: qn2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class ViewOnClickListenerC11087a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ pn2.c f429090d;

        ViewOnClickListenerC11087a(pn2.c cVar) {
            this.f429090d = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f429090d.v(view);
            pn2.c cVar = this.f429090d;
            al.a(cVar.C, cVar.x(), this.f429090d.getKeywords(), this.f429090d.G());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // qn2.b
    public void b(v vVar, View view, int i3, int i16) {
        String str;
        am.n(view, i3, x.d(vVar), x.h(vVar), String.valueOf(vVar.hashCode()), vVar.getRecallReason());
        View findViewById = view.findViewById(R.id.ikf);
        if (findViewById != null) {
            if (vVar instanceof pn2.c) {
                str = ((pn2.c) vVar).G();
            } else {
                str = "";
            }
            am.r(findViewById, str, x.e(vVar), "", 0, i16, String.valueOf(vVar.hashCode()), vVar.getRecallReason());
        }
    }

    @Override // qn2.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(pn2.c cVar, sn2.e eVar) {
        eVar.o(cVar);
        eVar.getView().setOnClickListener(new ViewOnClickListenerC11087a(cVar));
    }
}
