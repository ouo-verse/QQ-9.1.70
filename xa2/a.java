package xa2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.view.AreaMarkInfoComponent;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final AreaMarkInfoComponent f447564a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f447565b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f447566c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f447567d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f447568e;

    a(@NonNull AreaMarkInfoComponent areaMarkInfoComponent, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull View view) {
        this.f447564a = areaMarkInfoComponent;
        this.f447565b = textView;
        this.f447566c = textView2;
        this.f447567d = imageView;
        this.f447568e = view;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.sv7;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.sv7);
        if (textView != null) {
            i3 = R.id.bal;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.bal);
            if (textView2 != null) {
                i3 = R.id.u9x;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.u9x);
                if (imageView != null) {
                    i3 = R.id.e_1;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.e_1);
                    if (findChildViewById != null) {
                        return new a((AreaMarkInfoComponent) view, textView, textView2, imageView, findChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fmt, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public AreaMarkInfoComponent getRoot() {
        return this.f447564a;
    }
}
