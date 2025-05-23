package zx2;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ay2.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import jy2.g;
import tvideo.Video;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private View f453656a;

    /* renamed from: b, reason: collision with root package name */
    private View f453657b;

    /* renamed from: c, reason: collision with root package name */
    private View f453658c;

    /* renamed from: d, reason: collision with root package name */
    private xx2.b f453659d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f453660e;

    /* renamed from: f, reason: collision with root package name */
    private e f453661f;

    public c(View view, xx2.b bVar, ViewGroup viewGroup, e eVar) {
        this.f453659d = bVar;
        this.f453660e = viewGroup;
        this.f453661f = eVar;
        this.f453656a = view.findViewById(R.id.f81874fc);
        this.f453657b = view.findViewById(R.id.vgt);
        this.f453658c = view.findViewById(R.id.vgs);
    }

    public void a(Video video) {
        this.f453659d.v(true);
        if (g.A(video)) {
            this.f453659d.v(false);
            this.f453660e.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
            b(0);
            c(true);
            this.f453661f.V(true);
            return;
        }
        b(8);
        c(false);
        this.f453661f.V(false);
    }

    public void b(int i3) {
        View view = this.f453657b;
        if (view != null && this.f453658c != null) {
            view.setVisibility(i3);
            this.f453658c.setVisibility(i3);
        }
    }

    public void c(boolean z16) {
        ConstraintLayout.LayoutParams layoutParams;
        View view = this.f453656a;
        if (view == null || (layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        if (z16) {
            layoutParams.topToBottom = R.id.f45521s4;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ViewUtils.dip2px(18.0f);
        } else {
            layoutParams.topToBottom = R.id.f41571hf;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ViewUtils.dip2px(7.0f);
        }
        this.f453656a.setLayoutParams(layoutParams);
    }
}
