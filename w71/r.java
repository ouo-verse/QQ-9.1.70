package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.widget.CommonImageView;
import com.tx.x2j.AioTextExtContentBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class r implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f444889a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f444890b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f444891c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final CommonImageView f444892d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f444893e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f444894f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f444895g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f444896h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f444897i;

    r(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView, @NonNull CommonImageView commonImageView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4) {
        this.f444889a = relativeLayout;
        this.f444890b = relativeLayout2;
        this.f444891c = textView;
        this.f444892d = commonImageView;
        this.f444893e = textView2;
        this.f444894f = imageView;
        this.f444895g = textView3;
        this.f444896h = relativeLayout3;
        this.f444897i = relativeLayout4;
    }

    @NonNull
    public static r e(@NonNull View view) {
        int i3 = R.id.f74203vm;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f74203vm);
        if (relativeLayout != null) {
            i3 = R.id.f74213vn;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f74213vn);
            if (textView != null) {
                i3 = R.id.f74223vo;
                CommonImageView commonImageView = (CommonImageView) ViewBindings.findChildViewById(view, R.id.f74223vo);
                if (commonImageView != null) {
                    i3 = R.id.f74233vp;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f74233vp);
                    if (textView2 != null) {
                        i3 = R.id.f74243vq;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f74243vq);
                        if (imageView != null) {
                            i3 = R.id.f74253vr;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f74253vr);
                            if (textView3 != null) {
                                i3 = R.id.f74263vs;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f74263vs);
                                if (relativeLayout2 != null) {
                                    RelativeLayout relativeLayout3 = (RelativeLayout) view;
                                    return new r(relativeLayout3, relativeLayout, textView, commonImageView, textView2, imageView, textView3, relativeLayout2, relativeLayout3);
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
    public static r g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static r h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioTextExtContentBinding aioTextExtContentBinding = new AioTextExtContentBinding();
        aioTextExtContentBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioTextExtContentBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dwf, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f444889a;
    }
}
