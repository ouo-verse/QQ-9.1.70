package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.guild.aio.halfpop.RoundAngleLinearLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RoundAngleLinearLayout f441949a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundAngleLinearLayout f441950b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f441951c;

    f(@NonNull RoundAngleLinearLayout roundAngleLinearLayout, @NonNull RoundAngleLinearLayout roundAngleLinearLayout2, @NonNull ImageView imageView) {
        this.f441949a = roundAngleLinearLayout;
        this.f441950b = roundAngleLinearLayout2;
        this.f441951c = imageView;
    }

    @NonNull
    public static f e(@NonNull View view) {
        RoundAngleLinearLayout roundAngleLinearLayout = (RoundAngleLinearLayout) view;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f99805qs);
        if (imageView != null) {
            return new f(roundAngleLinearLayout, roundAngleLinearLayout, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f99805qs)));
    }

    @NonNull
    public static f g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eeo, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RoundAngleLinearLayout getRoot() {
        return this.f441949a;
    }
}
