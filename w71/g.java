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
import com.tx.x2j.AioMsgBubbleTemplateLayoutBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final TemplateLayout f444791a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewStub f444792b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final BubbleLayoutCompatPress f444793c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewStub f444794d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ViewStub f444795e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ViewStub f444796f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444797g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444798h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ViewStub f444799i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ViewStub f444800j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ViewStub f444801k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444802l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444803m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444804n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444805o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444806p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final TemplateLayout f444807q;

    g(@NonNull TemplateLayout templateLayout, @NonNull ViewStub viewStub, @NonNull BubbleLayoutCompatPress bubbleLayoutCompatPress, @NonNull ViewStub viewStub2, @NonNull ViewStub viewStub3, @NonNull ViewStub viewStub4, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ViewStub viewStub5, @NonNull ViewStub viewStub6, @NonNull ViewStub viewStub7, @NonNull FrameLayout frameLayout3, @NonNull FrameLayout frameLayout4, @NonNull FrameLayout frameLayout5, @NonNull FrameLayout frameLayout6, @NonNull FrameLayout frameLayout7, @NonNull TemplateLayout templateLayout2) {
        this.f444791a = templateLayout;
        this.f444792b = viewStub;
        this.f444793c = bubbleLayoutCompatPress;
        this.f444794d = viewStub2;
        this.f444795e = viewStub3;
        this.f444796f = viewStub4;
        this.f444797g = frameLayout;
        this.f444798h = frameLayout2;
        this.f444799i = viewStub5;
        this.f444800j = viewStub6;
        this.f444801k = viewStub7;
        this.f444802l = frameLayout3;
        this.f444803m = frameLayout4;
        this.f444804n = frameLayout5;
        this.f444805o = frameLayout6;
        this.f444806p = frameLayout7;
        this.f444807q = templateLayout2;
    }

    @NonNull
    public static g e(@NonNull View view) {
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
                                        i3 = R.id.zgh;
                                        ViewStub viewStub6 = (ViewStub) ViewBindings.findChildViewById(view, R.id.zgh);
                                        if (viewStub6 != null) {
                                            i3 = R.id.zgk;
                                            ViewStub viewStub7 = (ViewStub) ViewBindings.findChildViewById(view, R.id.zgk);
                                            if (viewStub7 != null) {
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
                                                                    return new g(templateLayout, viewStub, bubbleLayoutCompatPress, viewStub2, viewStub3, viewStub4, frameLayout, frameLayout2, viewStub5, viewStub6, viewStub7, frameLayout3, frameLayout4, frameLayout5, frameLayout6, frameLayout7, templateLayout);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static g g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioMsgBubbleTemplateLayoutBinding aioMsgBubbleTemplateLayoutBinding = new AioMsgBubbleTemplateLayoutBinding();
        aioMsgBubbleTemplateLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioMsgBubbleTemplateLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dvl, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public TemplateLayout getRoot() {
        return this.f444791a;
    }
}
