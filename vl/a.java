package vl;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.activities.titlebuilder.QzoneBaseTitle;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends QzoneBaseTitle {

    /* renamed from: a0, reason: collision with root package name */
    private TextView f441812a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f441813b0;

    /* renamed from: c0, reason: collision with root package name */
    private View.OnClickListener f441814c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f441815d0;

    /* compiled from: P */
    /* renamed from: vl.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class ViewOnClickListenerC11424a implements View.OnClickListener {
        ViewOnClickListenerC11424a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (a.this.f441814c0 != null) {
                a.this.f441814c0.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(com.qzone.common.activities.titlebuilder.f fVar) {
        super(fVar);
    }

    private int F() {
        return getResources().getColor(R.color.qui_common_bg_bottom_standard);
    }

    @Override // com.qzone.common.activities.titlebuilder.QzoneBaseTitle, com.qzone.common.activities.titlebuilder.a
    public void E1(int i3, int i16, boolean z16) {
        super.E1(i3, i16, z16);
        SystemBarCompact j3 = j();
        if (j3 != null) {
            j3.setStatusBarColor(F());
            if (ImmersiveUtils.couldSetStatusTextColor()) {
                j3.setStatusBarColor(F());
                ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNightForQzone(), f().getWindow());
            } else {
                j3.setStatusBarColor(SimpleUIUtil.SIMPLE_UI_STATUS_BAR_COLOR_PRE_M);
            }
        }
        H();
    }

    public void G(boolean z16) {
        this.f441815d0 = z16;
    }

    public void H() {
        int color = getResources().getColor(R.color.qui_common_text_primary);
        int color2 = getResources().getColor(R.color.qui_common_bg_bottom_standard);
        TextView textView = this.f45555d;
        if (textView != null) {
            textView.setTextColor(color);
            this.f45555d.setBackgroundResource(0);
        }
        TextView textView2 = this.f441812a0;
        if (textView2 != null) {
            textView2.setTextColor(color);
            this.f441812a0.setBackgroundResource(0);
            this.f441812a0.getPaint().setFakeBoldText(true);
        }
        TextView textView3 = this.f45557f;
        if (textView3 != null) {
            textView3.setTextColor(getResources().getColorStateList(R.color.cni));
            this.f45557f.setBackgroundResource(R.drawable.f162202ld2);
            this.f45557f.setTextSize(1, 14.0f);
            this.f45557f.setPadding(ar.e(16.0f), 0, ar.e(16.0f), 0);
            this.f45557f.getLayoutParams().height = ar.e(29.0f);
            ViewGroup.LayoutParams layoutParams = this.f45557f.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).rightMargin = ar.e(16.0f);
            }
        }
        ViewGroup viewGroup = this.f45558h;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(0);
        }
        ViewGroup viewGroup2 = this.M;
        if (viewGroup2 != null) {
            viewGroup2.setBackgroundColor(color2);
        }
    }

    @Override // com.qzone.common.activities.titlebuilder.QzoneBaseTitle, com.qzone.common.activities.titlebuilder.a
    public void K3(Intent intent) {
        super.K3(intent);
        ViewGroup viewGroup = this.H;
        if (viewGroup == null) {
            return;
        }
        TextView textView = (TextView) viewGroup.findViewById(R.id.f67843ef);
        this.f441812a0 = textView;
        textView.setOnClickListener(new ViewOnClickListenerC11424a());
        View findViewById = this.H.findViewById(R.id.f67793ea);
        this.f441813b0 = findViewById;
        s5.a.c((ImageView) findViewById, R.color.qui_common_text_secondary);
    }

    @Override // com.qzone.common.activities.titlebuilder.QzoneBaseTitle, com.qzone.common.activities.titlebuilder.a
    public void b5(boolean z16) {
        G(z16);
    }

    @Override // com.qzone.common.activities.titlebuilder.QzoneBaseTitle
    protected int h() {
        return R.layout.hlz;
    }

    @Override // com.qzone.common.activities.titlebuilder.QzoneBaseTitle, com.qzone.common.activities.titlebuilder.a
    public void setTitle(int i3) {
        TextView textView = this.f441812a0;
        if (textView == null) {
            return;
        }
        textView.setText(i3);
    }

    @Override // com.qzone.common.activities.titlebuilder.QzoneBaseTitle, com.qzone.common.activities.titlebuilder.a
    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f441812a0;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }
}
