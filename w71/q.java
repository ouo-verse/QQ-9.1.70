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
import com.tx.x2j.AioSenderBubbleTemplateBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class q implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final TemplateLayout f444874a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewStub f444875b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final BubbleLayoutCompatPress f444876c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewStub f444877d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ViewStub f444878e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ViewStub f444879f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444880g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444881h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ViewStub f444882i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444883j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444884k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444885l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444886m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444887n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final TemplateLayout f444888o;

    q(@NonNull TemplateLayout templateLayout, @NonNull ViewStub viewStub, @NonNull BubbleLayoutCompatPress bubbleLayoutCompatPress, @NonNull ViewStub viewStub2, @NonNull ViewStub viewStub3, @NonNull ViewStub viewStub4, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ViewStub viewStub5, @NonNull FrameLayout frameLayout3, @NonNull FrameLayout frameLayout4, @NonNull FrameLayout frameLayout5, @NonNull FrameLayout frameLayout6, @NonNull FrameLayout frameLayout7, @NonNull TemplateLayout templateLayout2) {
        this.f444874a = templateLayout;
        this.f444875b = viewStub;
        this.f444876c = bubbleLayoutCompatPress;
        this.f444877d = viewStub2;
        this.f444878e = viewStub3;
        this.f444879f = viewStub4;
        this.f444880g = frameLayout;
        this.f444881h = frameLayout2;
        this.f444882i = viewStub5;
        this.f444883j = frameLayout3;
        this.f444884k = frameLayout4;
        this.f444885l = frameLayout5;
        this.f444886m = frameLayout6;
        this.f444887n = frameLayout7;
        this.f444888o = templateLayout2;
    }

    @NonNull
    public static q e(@NonNull View view) {
        int i3 = R.id.t1c;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.t1c);
        if (viewStub != null) {
            i3 = R.id.f164907u83;
            BubbleLayoutCompatPress bubbleLayoutCompatPress = (BubbleLayoutCompatPress) ViewBindings.findChildViewById(view, R.id.f164907u83);
            if (bubbleLayoutCompatPress != null) {
                i3 = R.id.f164908u84;
                ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, R.id.f164908u84);
                if (viewStub2 != null) {
                    i3 = R.id.yhi;
                    ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, R.id.yhi);
                    if (viewStub3 != null) {
                        i3 = R.id.zfq;
                        ViewStub viewStub4 = (ViewStub) ViewBindings.findChildViewById(view, R.id.zfq);
                        if (viewStub4 != null) {
                            i3 = R.id.zfr;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.zfr);
                            if (frameLayout != null) {
                                i3 = R.id.zfz;
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.zfz);
                                if (frameLayout2 != null) {
                                    i3 = R.id.zg7;
                                    ViewStub viewStub5 = (ViewStub) ViewBindings.findChildViewById(view, R.id.zg7);
                                    if (viewStub5 != null) {
                                        i3 = R.id.f166334f21;
                                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f166334f21);
                                        if (frameLayout3 != null) {
                                            i3 = R.id.zgt;
                                            FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.zgt);
                                            if (frameLayout4 != null) {
                                                i3 = R.id.f166336f24;
                                                FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f166336f24);
                                                if (frameLayout5 != null) {
                                                    i3 = R.id.zgu;
                                                    FrameLayout frameLayout6 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.zgu);
                                                    if (frameLayout6 != null) {
                                                        i3 = R.id.zqy;
                                                        FrameLayout frameLayout7 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.zqy);
                                                        if (frameLayout7 != null) {
                                                            TemplateLayout templateLayout = (TemplateLayout) view;
                                                            return new q(templateLayout, viewStub, bubbleLayoutCompatPress, viewStub2, viewStub3, viewStub4, frameLayout, frameLayout2, viewStub5, frameLayout3, frameLayout4, frameLayout5, frameLayout6, frameLayout7, templateLayout);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static q g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioSenderBubbleTemplateBinding aioSenderBubbleTemplateBinding = new AioSenderBubbleTemplateBinding();
        aioSenderBubbleTemplateBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioSenderBubbleTemplateBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dwc, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public TemplateLayout getRoot() {
        return this.f444874a;
    }
}
