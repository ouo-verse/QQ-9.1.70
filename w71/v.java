package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.holder.template.TemplateLayout;
import com.tx.x2j.AioTofuTemplateLayoutBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class v implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final TemplateLayout f444921a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TemplateLayout f444922b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444923c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444924d;

    v(@NonNull TemplateLayout templateLayout, @NonNull TemplateLayout templateLayout2, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.f444921a = templateLayout;
        this.f444922b = templateLayout2;
        this.f444923c = frameLayout;
        this.f444924d = frameLayout2;
    }

    @NonNull
    public static v e(@NonNull View view) {
        TemplateLayout templateLayout = (TemplateLayout) view;
        int i3 = R.id.f99265pb;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f99265pb);
        if (frameLayout != null) {
            i3 = R.id.f99275pc;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f99275pc);
            if (frameLayout2 != null) {
                return new v(templateLayout, templateLayout, frameLayout, frameLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static v g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioTofuTemplateLayoutBinding aioTofuTemplateLayoutBinding = new AioTofuTemplateLayoutBinding();
        aioTofuTemplateLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioTofuTemplateLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dwp, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public TemplateLayout getRoot() {
        return this.f444921a;
    }
}
