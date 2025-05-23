package qb2;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.mobileqq.now.widget.RoundedRectImageView;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e extends d {
    public FrameLayout C;
    public FrameAnimationView D;
    public TextView E;
    public TextView F;
    public int G;

    /* renamed from: e, reason: collision with root package name */
    public View f428789e;

    /* renamed from: f, reason: collision with root package name */
    public RoundedRectImageView f428790f;

    /* renamed from: h, reason: collision with root package name */
    public CircleBoarderImageView f428791h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f428792i;

    /* renamed from: m, reason: collision with root package name */
    public FrameLayout f428793m;

    public e(View view) {
        super(view);
        this.G = -1;
        this.f428789e = view;
        this.f428790f = (RoundedRectImageView) view.findViewById(R.id.tnb);
        this.f428791h = (CircleBoarderImageView) view.findViewById(R.id.snp);
        this.f428792i = (TextView) view.findViewById(R.id.sos);
        this.f428793m = (FrameLayout) view.findViewById(R.id.sns);
        this.C = (FrameLayout) view.findViewById(R.id.sou);
        this.D = (FrameAnimationView) view.findViewById(R.id.sot);
        this.E = (TextView) view.findViewById(R.id.f120687_8);
        this.F = (TextView) view.findViewById(R.id.f7805461);
        view.setTag(this);
    }
}
