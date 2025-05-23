package ts2;

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
import com.tx.x2j.QbGroupNotificationDetailContainerLayoutBinding;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f437333a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUISecNavBar f437334b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437335c;

    b(@NonNull LinearLayout linearLayout, @NonNull QUISecNavBar qUISecNavBar, @NonNull LinearLayout linearLayout2) {
        this.f437333a = linearLayout;
        this.f437334b = qUISecNavBar;
        this.f437335c = linearLayout2;
    }

    @NonNull
    public static b e(@NonNull View view) {
        QUISecNavBar qUISecNavBar = (QUISecNavBar) ViewBindings.findChildViewById(view, R.id.idz);
        if (qUISecNavBar != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new b(linearLayout, qUISecNavBar, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.idz)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        QbGroupNotificationDetailContainerLayoutBinding qbGroupNotificationDetailContainerLayoutBinding = new QbGroupNotificationDetailContainerLayoutBinding();
        qbGroupNotificationDetailContainerLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = qbGroupNotificationDetailContainerLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.fva, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f437333a;
    }
}
