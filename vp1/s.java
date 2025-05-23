package vp1;

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
/* loaded from: classes13.dex */
public final class s implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f443093a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f443094b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final CheckBox f443095c;

    s(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull CheckBox checkBox) {
        this.f443093a = constraintLayout;
        this.f443094b = textView;
        this.f443095c = checkBox;
    }

    @NonNull
    public static s e(@NonNull View view) {
        int i3 = R.id.ufp;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ufp);
        if (textView != null) {
            i3 = R.id.f82444gw;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.f82444gw);
            if (checkBox != null) {
                return new s((ConstraintLayout) view, textView, checkBox);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static s g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ehh, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f443093a;
    }
}
