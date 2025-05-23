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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tx.x2j.GuildPersonalProfileJoinedContainerBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cs implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442791a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442792b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442793c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442794d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442795e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442796f;

    cs(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView2) {
        this.f442791a = linearLayout;
        this.f442792b = linearLayout2;
        this.f442793c = imageView;
        this.f442794d = textView;
        this.f442795e = relativeLayout;
        this.f442796f = imageView2;
    }

    @NonNull
    public static cs e(@NonNull View view) {
        int i3 = R.id.b8q;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.b8q);
        if (linearLayout != null) {
            i3 = R.id.f164999bn3;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164999bn3);
            if (imageView != null) {
                i3 = R.id.f165588wt3;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f165588wt3);
                if (textView != null) {
                    i3 = R.id.f165589wt4;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f165589wt4);
                    if (relativeLayout != null) {
                        i3 = R.id.ezw;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ezw);
                        if (imageView2 != null) {
                            return new cs((LinearLayout) view, linearLayout, imageView, textView, relativeLayout, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static cs g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static cs h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildPersonalProfileJoinedContainerBinding guildPersonalProfileJoinedContainerBinding = new GuildPersonalProfileJoinedContainerBinding();
        guildPersonalProfileJoinedContainerBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildPersonalProfileJoinedContainerBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.f168147f23, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442791a;
    }
}
