package w71;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.aio.widget.SelectableTextView;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class l implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f444841a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SelectableLinearLayout f444842b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final SelectableTextView f444843c;

    l(@NonNull FrameLayout frameLayout, @NonNull SelectableLinearLayout selectableLinearLayout, @NonNull SelectableTextView selectableTextView) {
        this.f444841a = frameLayout;
        this.f444842b = selectableLinearLayout;
        this.f444843c = selectableTextView;
    }

    @NonNull
    public static l e(@NonNull View view) {
        int i3 = R.id.f28840k1;
        SelectableLinearLayout selectableLinearLayout = (SelectableLinearLayout) ViewBindings.findChildViewById(view, R.id.f28840k1);
        if (selectableLinearLayout != null) {
            i3 = R.id.f28850k2;
            SelectableTextView selectableTextView = (SelectableTextView) ViewBindings.findChildViewById(view, R.id.f28850k2);
            if (selectableTextView != null) {
                return new l((FrameLayout) view, selectableLinearLayout, selectableTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f444841a;
    }
}
