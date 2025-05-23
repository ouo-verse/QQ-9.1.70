package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class af implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f444733a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUISecNavBar f444734b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f444735c;

    af(@NonNull LinearLayout linearLayout, @NonNull QUISecNavBar qUISecNavBar, @NonNull LinearLayout linearLayout2) {
        this.f444733a = linearLayout;
        this.f444734b = qUISecNavBar;
        this.f444735c = linearLayout2;
    }

    @NonNull
    public static af e(@NonNull View view) {
        QUISecNavBar qUISecNavBar = (QUISecNavBar) ViewBindings.findChildViewById(view, R.id.rlCommenTitle);
        if (qUISecNavBar != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new af(linearLayout, qUISecNavBar, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rlCommenTitle)));
    }

    @NonNull
    public static af g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static af h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fmn, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f444733a;
    }
}
