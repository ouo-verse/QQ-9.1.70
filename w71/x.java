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
import com.tencent.qqnt.aio.holder.template.BubbleLayoutCompatPress;
import com.tencent.qqnt.aio.holder.template.TemplateLayout;
import com.tx.x2j.AioViewMsgListGrayTipsTempleteBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class x implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final TemplateLayout f444927a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TemplateLayout f444928b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final BubbleLayoutCompatPress f444929c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444930d;

    x(@NonNull TemplateLayout templateLayout, @NonNull TemplateLayout templateLayout2, @NonNull BubbleLayoutCompatPress bubbleLayoutCompatPress, @NonNull FrameLayout frameLayout) {
        this.f444927a = templateLayout;
        this.f444928b = templateLayout2;
        this.f444929c = bubbleLayoutCompatPress;
        this.f444930d = frameLayout;
    }

    @NonNull
    public static x e(@NonNull View view) {
        TemplateLayout templateLayout = (TemplateLayout) view;
        int i3 = R.id.zfv;
        BubbleLayoutCompatPress bubbleLayoutCompatPress = (BubbleLayoutCompatPress) ViewBindings.findChildViewById(view, R.id.zfv);
        if (bubbleLayoutCompatPress != null) {
            i3 = R.id.f166336f24;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f166336f24);
            if (frameLayout != null) {
                return new x(templateLayout, templateLayout, bubbleLayoutCompatPress, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static x g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioViewMsgListGrayTipsTempleteBinding aioViewMsgListGrayTipsTempleteBinding = new AioViewMsgListGrayTipsTempleteBinding();
        aioViewMsgListGrayTipsTempleteBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioViewMsgListGrayTipsTempleteBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dwv, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public TemplateLayout getRoot() {
        return this.f444927a;
    }
}
