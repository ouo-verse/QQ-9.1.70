package wq2;

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
import com.tencent.mobileqq.sharepanel.multiSelect.widget.SharePanelAvatarView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f446062a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f446063b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final SharePanelAvatarView f446064c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f446065d;

    c(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull SharePanelAvatarView sharePanelAvatarView, @NonNull TextView textView) {
        this.f446062a = constraintLayout;
        this.f446063b = imageView;
        this.f446064c = sharePanelAvatarView;
        this.f446065d = textView;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.f164481za;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164481za);
        if (imageView != null) {
            i3 = R.id.f164552t20;
            SharePanelAvatarView sharePanelAvatarView = (SharePanelAvatarView) ViewBindings.findChildViewById(view, R.id.f164552t20);
            if (sharePanelAvatarView != null) {
                i3 = R.id.f5e;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f5e);
                if (textView != null) {
                    return new c((ConstraintLayout) view, imageView, sharePanelAvatarView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hqd, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f446062a;
    }
}
