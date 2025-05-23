package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class q implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f443078a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final OverScrollRecyclerViewWithHeaderFooter f443079b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f443080c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443081d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RecyclerView f443082e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final r f443083f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443084g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f443085h;

    q(@NonNull LinearLayout linearLayout, @NonNull OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView, @NonNull r rVar, @NonNull LinearLayout linearLayout3, @NonNull FrameLayout frameLayout2) {
        this.f443078a = linearLayout;
        this.f443079b = overScrollRecyclerViewWithHeaderFooter;
        this.f443080c = frameLayout;
        this.f443081d = linearLayout2;
        this.f443082e = recyclerView;
        this.f443083f = rVar;
        this.f443084g = linearLayout3;
        this.f443085h = frameLayout2;
    }

    @NonNull
    public static q e(@NonNull View view) {
        int i3 = R.id.t8o;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) ViewBindings.findChildViewById(view, R.id.t8o);
        if (overScrollRecyclerViewWithHeaderFooter != null) {
            i3 = R.id.t8p;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.t8p);
            if (frameLayout != null) {
                i3 = R.id.t8v;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.t8v);
                if (linearLayout != null) {
                    i3 = R.id.f80734c_;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f80734c_);
                    if (recyclerView != null) {
                        i3 = R.id.search_box;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.search_box);
                        if (findChildViewById != null) {
                            r e16 = r.e(findChildViewById);
                            i3 = R.id.f80854cl;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f80854cl);
                            if (linearLayout2 != null) {
                                i3 = R.id.f81064d6;
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f81064d6);
                                if (frameLayout2 != null) {
                                    return new q((LinearLayout) view, overScrollRecyclerViewWithHeaderFooter, frameLayout, linearLayout, recyclerView, e16, linearLayout2, frameLayout2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static q g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168042eh4, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f443078a;
    }
}
