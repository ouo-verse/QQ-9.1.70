package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class x implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f443135a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f443136b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f443137c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f443138d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f443139e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f443140f;

    x(@NonNull FrameLayout frameLayout, @NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout2, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f443135a = frameLayout;
        this.f443136b = constraintLayout;
        this.f443137c = frameLayout2;
        this.f443138d = view;
        this.f443139e = textView;
        this.f443140f = textView2;
    }

    @NonNull
    public static x e(@NonNull View view) {
        int i3 = R.id.b8q;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.b8q);
        if (constraintLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i3 = R.id.f84024l5;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.f84024l5);
            if (findChildViewById != null) {
                i3 = R.id.f166931j64;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f166931j64);
                if (textView != null) {
                    i3 = R.id.title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                    if (textView2 != null) {
                        return new x(frameLayout, constraintLayout, frameLayout, findChildViewById, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static x g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168043ei0, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f443135a;
    }
}
