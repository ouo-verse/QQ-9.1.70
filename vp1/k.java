package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class k implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f443025a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f443026b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f443027c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f443028d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final l f443029e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RoundImageView f443030f;

    k(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull l lVar, @NonNull RoundImageView roundImageView) {
        this.f443025a = linearLayout;
        this.f443026b = imageView;
        this.f443027c = textView;
        this.f443028d = imageView2;
        this.f443029e = lVar;
        this.f443030f = roundImageView;
    }

    @NonNull
    public static k e(@NonNull View view) {
        int i3 = R.id.t2p;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.t2p);
        if (imageView != null) {
            i3 = R.id.ato;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ato);
            if (textView != null) {
                i3 = R.id.ugr;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ugr);
                if (imageView2 != null) {
                    i3 = R.id.uxq;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.uxq);
                    if (findChildViewById != null) {
                        l e16 = l.e(findChildViewById);
                        i3 = R.id.vzu;
                        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.vzu);
                        if (roundImageView != null) {
                            return new k((LinearLayout) view, imageView, textView, imageView2, e16, roundImageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static k g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.efw, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f443025a;
    }
}
