package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class s implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f447004a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f447005b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f447006c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f447007d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RoundImageView f447008e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f447009f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f447010g;

    s(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RoundImageView roundImageView, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView3) {
        this.f447004a = relativeLayout;
        this.f447005b = linearLayout;
        this.f447006c = textView;
        this.f447007d = textView2;
        this.f447008e = roundImageView;
        this.f447009f = relativeLayout2;
        this.f447010g = textView3;
    }

    @NonNull
    public static s e(@NonNull View view) {
        int i3 = R.id.content;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.content);
        if (linearLayout != null) {
            i3 = R.id.f165444w13;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f165444w13);
            if (textView != null) {
                i3 = R.id.w3i;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.w3i);
                if (textView2 != null) {
                    i3 = R.id.wic;
                    RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wic);
                    if (roundImageView != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view;
                        i3 = R.id.wrw;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.wrw);
                        if (textView3 != null) {
                            return new s(relativeLayout, linearLayout, textView, textView2, roundImageView, relativeLayout, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static s g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.euy, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f447004a;
    }
}
