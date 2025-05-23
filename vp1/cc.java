package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cc implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442675a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442676b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442677c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442678d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442679e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442680f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final QUIButton f442681g;

    cc(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull RoundImageView roundImageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull QUIButton qUIButton) {
        this.f442675a = frameLayout;
        this.f442676b = linearLayout;
        this.f442677c = roundImageView;
        this.f442678d = textView;
        this.f442679e = textView2;
        this.f442680f = linearLayout2;
        this.f442681g = qUIButton;
    }

    @NonNull
    public static cc e(@NonNull View view) {
        int i3 = R.id.tou;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.tou);
        if (linearLayout != null) {
            i3 = R.id.vzu;
            RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.vzu);
            if (roundImageView != null) {
                i3 = R.id.w3j;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.w3j);
                if (textView != null) {
                    i3 = R.id.wrw;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.wrw);
                    if (textView2 != null) {
                        i3 = R.id.x1s;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.x1s);
                        if (linearLayout2 != null) {
                            i3 = R.id.f165979ya4;
                            QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.f165979ya4);
                            if (qUIButton != null) {
                                return new cc((FrameLayout) view, linearLayout, roundImageView, textView, textView2, linearLayout2, qUIButton);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static cc g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f0q, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442675a;
    }
}
