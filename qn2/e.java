package qn2;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.search.model.v;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e implements d<v, sn2.b> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ do2.f f429092d;

        a(do2.f fVar) {
            this.f429092d = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f429092d.v(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // qn2.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(v vVar, sn2.b bVar) {
        fo2.b bVar2 = (fo2.b) bVar;
        if (vVar instanceof do2.f) {
            do2.f fVar = (do2.f) vVar;
            if (!TextUtils.isEmpty(fVar.C)) {
                bVar2.f400166i.setVisibility(0);
                bVar2.f400167m.setText(fVar.C);
            } else {
                bVar2.f400166i.setVisibility(8);
            }
            bVar2.f400166i.setOnClickListener(new a(fVar));
            if (TextUtils.isEmpty(fVar.D)) {
                bVar2.f400166i.setEnabled(false);
            }
        }
    }
}
