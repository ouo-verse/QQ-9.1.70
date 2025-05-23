package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class aq implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442273a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442274b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442275c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442276d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442277e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442278f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f442279g;

    aq(@NonNull View view, @NonNull RoundImageView roundImageView, @NonNull RoundImageView roundImageView2, @NonNull RoundImageView roundImageView3, @NonNull RoundImageView roundImageView4, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView) {
        this.f442273a = view;
        this.f442274b = roundImageView;
        this.f442275c = roundImageView2;
        this.f442276d = roundImageView3;
        this.f442277e = roundImageView4;
        this.f442278f = relativeLayout;
        this.f442279g = textView;
    }

    @NonNull
    public static aq e(@NonNull View view) {
        int i3 = R.id.wid;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wid);
        if (roundImageView != null) {
            i3 = R.id.wie;
            RoundImageView roundImageView2 = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wie);
            if (roundImageView2 != null) {
                i3 = R.id.wif;
                RoundImageView roundImageView3 = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wif);
                if (roundImageView3 != null) {
                    i3 = R.id.wig;
                    RoundImageView roundImageView4 = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wig);
                    if (roundImageView4 != null) {
                        i3 = R.id.wii;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.wii);
                        if (relativeLayout != null) {
                            i3 = R.id.wrw;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wrw);
                            if (textView != null) {
                                return new aq(view, roundImageView, roundImageView2, roundImageView3, roundImageView4, relativeLayout, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static aq f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.el8, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442273a;
    }
}
