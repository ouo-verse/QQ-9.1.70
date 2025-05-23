package sn2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends g {
    public View F;
    public TextView G;
    public TextView H;
    public TextView I;

    public e(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    private void p(pn2.c cVar) {
        int i3;
        if (b() != null) {
            b().setText(cVar.getTitle());
        }
        if (c() != null) {
            c().setText(cVar.getSubTitle());
        }
        if (this.H != null && !TextUtils.isEmpty(cVar.H())) {
            this.H.setText(cVar.H());
        }
        if (this.I != null && !TextUtils.isEmpty(cVar.N)) {
            this.I.setText(cVar.N);
            c().setMaxWidth(q(this.f433999d.getContext(), b(), this.I, this.C) - SearchUtils.l(75.0f, c().getResources()));
        }
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
        if (f() != null) {
            if (cVar.J != 0) {
                f().setImageResource(cVar.J);
                f().setVisibility(0);
            } else if (!TextUtils.isEmpty(cVar.K)) {
                int dimensionPixelSize = getView().getResources().getDimensionPixelSize(R.dimen.f159238y4);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = dimensionPixelSize;
                obtain.mRequestHeight = dimensionPixelSize;
                obtain.mMemoryCacheKeySuffix = "isAvatar";
                obtain.mFailedDrawable = colorDrawable;
                obtain.mLoadingDrawable = colorDrawable;
                URLDrawable drawable = URLDrawable.getDrawable(cVar.K, obtain);
                drawable.setDecodeHandler(((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getDecodeHandler());
                if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                    drawable.restartDownload();
                }
                f().setImageDrawable(drawable);
                f().setVisibility(0);
            } else {
                f().setVisibility(8);
            }
        }
        if (this.F != null) {
            Object tag = getView().getTag(R.id.kxc);
            if (tag instanceof Integer) {
                i3 = ((Integer) tag).intValue();
            } else {
                i3 = -1;
            }
            this.F.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
            if (i3 > 0) {
                layoutParams.height = ViewUtils.dip2px(R.dimen.ald);
            } else if (i3 == 0) {
                layoutParams.height = 0;
                this.F.setLayoutParams(layoutParams);
            }
        }
        if (k() != null && !TextUtils.isEmpty(cVar.getDescription())) {
            k().setText(cVar.getDescription());
            k().setVisibility(0);
        }
        if (g() != null) {
            if (cVar.r()) {
                g().setVisibility(0);
            } else {
                g().setVisibility(8);
            }
            if (!TextUtils.isEmpty(cVar.Q)) {
                int dimensionPixelSize2 = getView().getResources().getDimensionPixelSize(R.dimen.ahl);
                URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                obtain2.mRequestWidth = dimensionPixelSize2;
                obtain2.mRequestHeight = dimensionPixelSize2;
                obtain2.mMemoryCacheKeySuffix = "rightIcon";
                obtain2.mLoadingDrawable = colorDrawable;
                obtain2.mFailedDrawable = colorDrawable;
                URLDrawable drawable2 = URLDrawable.getDrawable(cVar.Q, obtain2);
                if (drawable2.getStatus() != 1 && drawable2.getStatus() != 0) {
                    drawable2.restartDownload();
                }
                g().setImageDrawable(drawable2);
                g().setVisibility(0);
            } else {
                g().setVisibility(8);
            }
            if (cVar.I == -5) {
                g().setVisibility(0);
                this.f433999d.findViewById(R.id.ikf).setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg_selector);
            }
        }
    }

    public static int q(Context context, View... viewArr) {
        int i3;
        int i16;
        int i17 = context.getResources().getDisplayMetrics().widthPixels;
        for (View view : viewArr) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                i16 = ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                i3 = ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
            } else {
                i3 = 0;
                i16 = 0;
            }
            view.measure(0, 0);
            i17 = ((i17 - view.getMeasuredWidth()) - i16) - i3;
        }
        return i17;
    }

    private void r(pn2.c cVar, e eVar) {
        if (cVar.x() != 8) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        TextView b16 = eVar.b();
        TextView textView = eVar.G;
        if (textView != null) {
            sb5.append(textView.getText());
        }
        if (b16 != null) {
            sb5.append(b16.getText());
        }
        TextView textView2 = eVar.H;
        if (textView2 != null) {
            sb5.append(textView2.getText());
        }
        cVar.N(sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sn2.g
    public void a() {
        super.a();
        this.F = this.f433999d.findViewById(R.id.bnd);
        int i3 = this.E;
        if (i3 == R.layout.f168534a00) {
            this.G = (TextView) this.f433999d.findViewById(R.id.text1);
            this.H = (TextView) this.f433999d.findViewById(R.id.text2);
            b().setMaxWidth(q(this.f433999d.getContext(), this.G, this.H, this.C));
            if (aq.a()) {
                this.f433999d.findViewById(R.id.ikf).setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
                return;
            }
            return;
        }
        if (i3 == R.layout.f168531zu) {
            this.I = (TextView) this.f433999d.findViewById(R.id.f0s);
        }
    }

    public void o(pn2.c cVar) {
        m();
        int i3 = cVar.I;
        if (i3 == -5 || i3 == -4 || i3 == -3 || i3 == -1) {
            p(cVar);
        }
        r(cVar, this);
    }
}
