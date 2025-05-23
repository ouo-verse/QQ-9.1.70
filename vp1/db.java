package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class db implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442869a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442870b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442871c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f442872d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final QUIButton f442873e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442874f;

    db(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull FrameLayout frameLayout, @NonNull RecyclerView recyclerView, @NonNull QUIButton qUIButton, @NonNull FrameLayout frameLayout2) {
        this.f442869a = linearLayout;
        this.f442870b = textView;
        this.f442871c = frameLayout;
        this.f442872d = recyclerView;
        this.f442873e = qUIButton;
        this.f442874f = frameLayout2;
    }

    @NonNull
    public static db e(@NonNull View view) {
        int i3 = R.id.aou;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.aou);
        if (textView != null) {
            i3 = R.id.content;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.content);
            if (frameLayout != null) {
                i3 = R.id.i4m;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.i4m);
                if (recyclerView != null) {
                    i3 = R.id.j6p;
                    QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.j6p);
                    if (qUIButton != null) {
                        i3 = R.id.title_container;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.title_container);
                        if (frameLayout2 != null) {
                            return new db((LinearLayout) view, textView, frameLayout, recyclerView, qUIButton, frameLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static db g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f4g, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442869a;
    }
}
