package sn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.aq;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f implements b {

    /* renamed from: d, reason: collision with root package name */
    protected View f433995d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f433996e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f433997f;

    /* renamed from: h, reason: collision with root package name */
    protected List<c> f433998h;

    public f() {
    }

    @Override // sn2.b
    public TextView b() {
        return this.f433996e;
    }

    @Override // sn2.b
    public List<c> e() {
        return this.f433998h;
    }

    @Override // sn2.b
    public TextView getMoreView() {
        return this.f433997f;
    }

    @Override // sn2.d
    public View getView() {
        return this.f433995d;
    }

    public f(ViewGroup viewGroup, int i3) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        this.f433995d = inflate;
        this.f433997f = (TextView) inflate.findViewById(R.id.ezq);
        ArrayList arrayList = new ArrayList();
        this.f433998h = arrayList;
        arrayList.add(new g(this.f433995d.findViewById(R.id.dor)));
        this.f433998h.add(new g(this.f433995d.findViewById(R.id.doy)));
        this.f433998h.add(new g(this.f433995d.findViewById(R.id.f165845dp4)));
        if (i3 == R.layout.f168430vz || i3 == R.layout.bxc) {
            this.f433998h.add(new g(this.f433995d.findViewById(R.id.dp_)));
            this.f433998h.add(new g(this.f433995d.findViewById(R.id.dpa)));
        }
        if (aq.a()) {
            for (c cVar : this.f433998h) {
                g gVar = (g) cVar;
                cVar.getView().setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
                gVar.n(cVar.b(), R.color.qui_common_text_primary);
                gVar.n(cVar.c(), R.color.qui_common_text_primary);
                gVar.n(cVar.k(), R.color.qui_common_text_secondary);
            }
        }
    }
}
