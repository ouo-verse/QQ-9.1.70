package t74;

import android.graphics.drawable.Drawable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.sqshow.widget.pag.ZPlanPAGView;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGView;
import xv4.ab;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ*\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0011J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J*\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ \u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a8\u0006\u001f"}, d2 = {"Lt74/f;", "", "Lcom/tencent/sqshow/widget/pag/ZPlanPAGView;", "view", "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "Lorg/libpag/PAGView$PAGViewListener;", "listener", "", "d", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "Lxv4/ab;", "spMaterial", tl.h.F, "", "pic", "i", "Landroid/graphics/drawable/Drawable;", "defaultDra", "j", "g", "Lcom/tencent/sqshow/widget/pag/ZPlanPAGView$c;", "k", "e", "f", "b", "c", "pagUrl", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f435541a = new f();

    f() {
    }

    public final pu4.g a(String pagUrl, String pic) {
        pu4.g gVar = new pu4.g();
        gVar.f427436c = pic;
        gVar.f427437d = "png";
        gVar.f427434a = pagUrl;
        gVar.f427435b = "pag";
        return gVar;
    }

    public final pu4.g b(String pic) {
        pu4.g gVar = new pu4.g();
        gVar.f427434a = pic;
        gVar.f427435b = "png";
        return gVar;
    }

    public final pu4.g c(String pic) {
        pu4.g gVar = new pu4.g();
        gVar.f427436c = pic;
        gVar.f427437d = "png";
        return gVar;
    }

    public final void d(ZPlanPAGView view, pu4.g material, PAGView.PAGViewListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(material, "material");
        Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
        Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
        view.setLoadingDrawable(TRANSPARENT);
        view.stop();
        view.a(material, listener);
    }

    public final void e(ZPlanMediaView view, String pic) {
        Intrinsics.checkNotNullParameter(view, "view");
        Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
        Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
        f(view, pic, TRANSPARENT);
    }

    public final void f(ZPlanMediaView view, String pic, Drawable defaultDra) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(defaultDra, "defaultDra");
        pu4.g b16 = b(pic);
        view.setDefaultDrawable(defaultDra);
        view.e(b16);
    }

    public final void g(ZPlanMediaView view, pu4.g material, Drawable defaultDra, PAGView.PAGViewListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(defaultDra, "defaultDra");
        view.stop();
        view.setDefaultDrawable(defaultDra);
        view.setPagListener(listener);
        view.e(material);
    }

    public final void h(ZPlanMediaView view, ab spMaterial) {
        Intrinsics.checkNotNullParameter(view, "view");
        Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
        Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
        j(view, spMaterial, "", TRANSPARENT);
    }

    public final void i(ZPlanMediaView view, ab spMaterial, String pic) {
        Intrinsics.checkNotNullParameter(view, "view");
        Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
        Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
        j(view, spMaterial, pic, TRANSPARENT);
    }

    public final void j(ZPlanMediaView view, ab spMaterial, String pic, Drawable defaultDra) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(defaultDra, "defaultDra");
        if (spMaterial != null) {
            f fVar = f435541a;
            fVar.g(view, fVar.a(spMaterial.f448769b, pic), defaultDra, null);
        }
    }

    public final void k(ZPlanPAGView view, ab spMaterial, String pic, ZPlanPAGView.c listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pic, "pic");
        pu4.g a16 = a(spMaterial != null ? spMaterial.f448769b : null, pic);
        view.stop();
        Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
        Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
        view.setLoadingDrawable(TRANSPARENT);
        view.s(listener);
        if (spMaterial != null) {
            view.C(a16);
        } else {
            view.c(a16);
        }
    }
}
