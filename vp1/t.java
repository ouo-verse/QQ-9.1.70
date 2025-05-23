package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class t implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f443096a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f443097b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f443098c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f443099d;

    t(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f443096a = constraintLayout;
        this.f443097b = textView;
        this.f443098c = textView2;
        this.f443099d = imageView;
    }

    @NonNull
    public static t e(@NonNull View view) {
        int i3 = R.id.arv;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.arv);
        if (textView != null) {
            i3 = R.id.ufp;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ufp);
            if (textView2 != null) {
                i3 = R.id.w1l;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.w1l);
                if (imageView != null) {
                    return new t((ConstraintLayout) view, textView, textView2, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static t g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ehi, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f443096a;
    }
}
