package vn0;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.guild.aio.util.ui.EmoTextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class k implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f441966a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f441967b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f441968c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f441969d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final EmoTextView f441970e;

    k(@NonNull View view, @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull EmoTextView emoTextView) {
        this.f441966a = view;
        this.f441967b = constraintLayout;
        this.f441968c = imageView;
        this.f441969d = textView;
        this.f441970e = emoTextView;
    }

    @NonNull
    public static k e(@NonNull View view) {
        int i3 = R.id.vy5;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.vy5);
        if (constraintLayout != null) {
            i3 = R.id.f73093sm;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f73093sm);
            if (imageView != null) {
                i3 = R.id.f73253t2;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f73253t2);
                if (textView != null) {
                    i3 = R.id.f73333t_;
                    EmoTextView emoTextView = (EmoTextView) ViewBindings.findChildViewById(view, R.id.f73333t_);
                    if (emoTextView != null) {
                        return new k(view, constraintLayout, imageView, textView, emoTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f441966a;
    }
}
