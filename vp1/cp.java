package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tx.x2j.GuildPersonalProfileFeedContainerBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cp implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442751a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442752b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442753c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442754d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RecyclerView f442755e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442756f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f442757g;

    cp(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull TextView textView2, @NonNull ImageView imageView2) {
        this.f442751a = linearLayout;
        this.f442752b = imageView;
        this.f442753c = textView;
        this.f442754d = relativeLayout;
        this.f442755e = recyclerView;
        this.f442756f = textView2;
        this.f442757g = imageView2;
    }

    @NonNull
    public static cp e(@NonNull View view) {
        int i3 = R.id.f164999bn3;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164999bn3);
        if (imageView != null) {
            i3 = R.id.f165588wt3;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f165588wt3);
            if (textView != null) {
                i3 = R.id.wug;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.wug);
                if (relativeLayout != null) {
                    i3 = R.id.wxi;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.wxi);
                    if (recyclerView != null) {
                        i3 = R.id.f165641x33;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f165641x33);
                        if (textView2 != null) {
                            i3 = R.id.ezw;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ezw);
                            if (imageView2 != null) {
                                return new cp((LinearLayout) view, imageView, textView, relativeLayout, recyclerView, textView2, imageView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static cp g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static cp h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildPersonalProfileFeedContainerBinding guildPersonalProfileFeedContainerBinding = new GuildPersonalProfileFeedContainerBinding();
        guildPersonalProfileFeedContainerBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildPersonalProfileFeedContainerBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.f1z, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442751a;
    }
}
