package sw3;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f434906a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f434907b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f434908c;

    i(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2) {
        this.f434906a = constraintLayout;
        this.f434907b = textView;
        this.f434908c = constraintLayout2;
    }

    @NonNull
    public static i e(@NonNull View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tsu);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new i(constraintLayout, textView, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tsu)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f434906a;
    }
}
