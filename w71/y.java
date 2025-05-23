package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.holder.template.BubbleLayoutCompatPress;
import com.tencent.qqnt.aio.holder.template.TemplateLayout;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class y implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final TemplateLayout f444931a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final BubbleLayoutCompatPress f444932b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewStub f444933c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444934d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TemplateLayout f444935e;

    y(@NonNull TemplateLayout templateLayout, @NonNull BubbleLayoutCompatPress bubbleLayoutCompatPress, @NonNull ViewStub viewStub, @NonNull FrameLayout frameLayout, @NonNull TemplateLayout templateLayout2) {
        this.f444931a = templateLayout;
        this.f444932b = bubbleLayoutCompatPress;
        this.f444933c = viewStub;
        this.f444934d = frameLayout;
        this.f444935e = templateLayout2;
    }

    @NonNull
    public static y e(@NonNull View view) {
        int i3 = R.id.zfv;
        BubbleLayoutCompatPress bubbleLayoutCompatPress = (BubbleLayoutCompatPress) ViewBindings.findChildViewById(view, R.id.zfv);
        if (bubbleLayoutCompatPress != null) {
            i3 = R.id.zgh;
            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.zgh);
            if (viewStub != null) {
                i3 = R.id.f166336f24;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f166336f24);
                if (frameLayout != null) {
                    TemplateLayout templateLayout = (TemplateLayout) view;
                    return new y(templateLayout, bubbleLayoutCompatPress, viewStub, frameLayout, templateLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static y g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dwx, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public TemplateLayout getRoot() {
        return this.f444931a;
    }
}
