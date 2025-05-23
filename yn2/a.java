package yn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements sn2.b {

    /* renamed from: d, reason: collision with root package name */
    protected View f450669d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f450670e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f450671f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f450672h;

    /* renamed from: i, reason: collision with root package name */
    private List<sn2.c> f450673i;

    /* renamed from: m, reason: collision with root package name */
    private sn2.c f450674m;

    public a() {
    }

    public sn2.c a() {
        return this.f450674m;
    }

    @Override // sn2.b
    public TextView b() {
        return this.f450670e;
    }

    @Override // sn2.b
    public List<sn2.c> e() {
        return this.f450673i;
    }

    @Override // sn2.b
    public TextView getMoreView() {
        return this.f450671f;
    }

    @Override // sn2.d
    public View getView() {
        return this.f450669d;
    }

    public LinearLayout j() {
        return this.f450672h;
    }

    public a(ViewGroup viewGroup, int i3) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        this.f450669d = inflate;
        this.f450671f = (TextView) inflate.findViewById(R.id.ezq);
        this.f450673i = new ArrayList();
        this.f450672h = (LinearLayout) this.f450669d.findViewById(R.id.ecl);
        this.f450674m = new c(this.f450669d.findViewById(R.id.dpb));
    }
}
