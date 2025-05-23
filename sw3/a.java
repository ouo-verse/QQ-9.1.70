package sw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f434885a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f434886b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final CheckBox f434887c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f434888d;

    a(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull CheckBox checkBox, @NonNull ConstraintLayout constraintLayout2) {
        this.f434885a = constraintLayout;
        this.f434886b = textView;
        this.f434887c = checkBox;
        this.f434888d = constraintLayout2;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.tsu;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tsu);
        if (textView != null) {
            i3 = R.id.dv_;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.dv_);
            if (checkBox != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new a(constraintLayout, textView, checkBox, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e0r, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f434885a;
    }
}
