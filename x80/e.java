package x80;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends c {
    private w80.d R;

    public e(int i3) {
        super(i3, R.id.f53002bb);
    }

    @Override // x80.c, x80.a, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public /* bridge */ /* synthetic */ void N0(@NonNull View view) {
        super.N0(view);
    }

    @Override // x80.a
    protected String h1() {
        return this.R.f444975c;
    }

    @Override // x80.a
    protected String i1() {
        return this.R.f444974b;
    }

    @Override // x80.c, x80.a, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: k1 */
    public void L0(w80.c cVar, int i3) {
        this.R = cVar.f444967e;
        super.L0(cVar, i3);
    }

    @Override // x80.c
    protected String n1() {
        return this.I.a();
    }

    @Override // x80.c
    @NonNull
    protected String o1() {
        return this.I.i();
    }

    @Override // x80.a, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // x80.c
    protected List<w80.h> p1() {
        return this.R.f444973a;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public String w0() {
        return "QCircleSearchGameUnionGiftsPresenter";
    }
}
