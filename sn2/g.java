package sn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeURLImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g implements c {
    protected ImageView C;
    protected View D;
    public int E;

    /* renamed from: d, reason: collision with root package name */
    protected View f433999d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f434000e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f434001f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f434002h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f434003i;

    /* renamed from: m, reason: collision with root package name */
    protected ImageView f434004m;

    public g(ViewGroup viewGroup, int i3) {
        this.E = i3;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (l(i3)) {
            this.f433999d = from.inflate(i3, (ViewGroup) null, false);
        } else {
            this.f433999d = from.inflate(i3, viewGroup, false);
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        View findViewById = this.f433999d.findViewById(R.id.title);
        if (findViewById != null) {
            TextView textView = (TextView) findViewById;
            this.f434000e = textView;
            textView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        }
        View findViewById2 = this.f433999d.findViewById(R.id.f166931j64);
        if (findViewById2 != null) {
            this.f434001f = (TextView) findViewById2;
        }
        View findViewById3 = this.f433999d.findViewById(R.id.bgt);
        if (findViewById3 != null) {
            this.f434002h = (TextView) findViewById3;
        }
        View findViewById4 = this.f433999d.findViewById(R.id.f165205ca2);
        if (findViewById4 != null) {
            this.f434003i = (TextView) findViewById4;
        }
        View findViewById5 = this.f433999d.findViewById(R.id.image);
        if (findViewById5 != null) {
            this.f434004m = (ImageView) findViewById5;
        }
        ImageView imageView = this.f434004m;
        if (imageView instanceof ThemeImageView) {
            ((ThemeImageView) imageView).setSupportMaskView(false);
        } else if (imageView instanceof ThemeURLImageView) {
            ((ThemeURLImageView) imageView).setSupportMaskView(false);
        }
        View findViewById6 = this.f433999d.findViewById(R.id.i_m);
        if (findViewById6 != null) {
            this.C = (ImageView) findViewById6;
        }
        this.D = this.f433999d.findViewById(R.id.bnd);
        m();
    }

    @Override // sn2.c
    public TextView b() {
        return this.f434000e;
    }

    @Override // sn2.c
    public TextView c() {
        return this.f434001f;
    }

    @Override // sn2.c
    public TextView d() {
        return this.f434003i;
    }

    @Override // sn2.a
    public ImageView f() {
        return this.f434004m;
    }

    @Override // sn2.c
    public ImageView g() {
        return this.C;
    }

    @Override // sn2.d
    public View getView() {
        return this.f433999d;
    }

    @Override // sn2.c
    public View h(String str) {
        return null;
    }

    public View j(int i3) {
        if (i3 != R.layout.f168534a00 && i3 != R.layout.f168531zu && i3 != R.layout.a0v && i3 != R.layout.a0h) {
            return this.f433999d;
        }
        return this.f433999d.findViewById(R.id.ikf);
    }

    @Override // sn2.c
    public TextView k() {
        return this.f434002h;
    }

    public boolean l(int i3) {
        if (i3 != R.layout.bxn && i3 != R.layout.atc && i3 != R.layout.bxm) {
            return true;
        }
        return false;
    }

    public void m() {
        l(this.E);
    }

    public void n(TextView textView, int i3) {
        if (textView == null) {
            return;
        }
        textView.setTextColor(textView.getResources().getColorStateList(i3));
    }

    public g(View view) {
        this.f433999d = view;
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g() {
    }
}
