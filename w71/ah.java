package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqui.widget.InterceptParentTouchLayout;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ah implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final InterceptParentTouchLayout f444744a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f444745b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final InterceptParentTouchLayout f444746c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f444747d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f444748e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444749f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f444750g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final QUICheckBox f444751h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f444752i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f444753j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final QUIButton f444754k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f444755l;

    ah(@NonNull InterceptParentTouchLayout interceptParentTouchLayout, @NonNull TextView textView, @NonNull InterceptParentTouchLayout interceptParentTouchLayout2, @NonNull RecyclerView recyclerView, @NonNull TextView textView2, @NonNull FrameLayout frameLayout, @NonNull TextView textView3, @NonNull QUICheckBox qUICheckBox, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull QUIButton qUIButton, @NonNull LinearLayout linearLayout) {
        this.f444744a = interceptParentTouchLayout;
        this.f444745b = textView;
        this.f444746c = interceptParentTouchLayout2;
        this.f444747d = recyclerView;
        this.f444748e = textView2;
        this.f444749f = frameLayout;
        this.f444750g = textView3;
        this.f444751h = qUICheckBox;
        this.f444752i = textView4;
        this.f444753j = textView5;
        this.f444754k = qUIButton;
        this.f444755l = linearLayout;
    }

    @NonNull
    public static ah e(@NonNull View view) {
        int i3 = R.id.f164256p2;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f164256p2);
        if (textView != null) {
            InterceptParentTouchLayout interceptParentTouchLayout = (InterceptParentTouchLayout) view;
            i3 = R.id.f165251vc3;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f165251vc3);
            if (recyclerView != null) {
                i3 = R.id.ekt;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ekt);
                if (textView2 != null) {
                    i3 = R.id.f_y;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f_y);
                    if (frameLayout != null) {
                        i3 = R.id.fbx;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.fbx);
                        if (textView3 != null) {
                            i3 = R.id.h1y;
                            QUICheckBox qUICheckBox = (QUICheckBox) ViewBindings.findChildViewById(view, R.id.h1y);
                            if (qUICheckBox != null) {
                                i3 = R.id.h1z;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.h1z);
                                if (textView4 != null) {
                                    i3 = R.id.f166661h24;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f166661h24);
                                    if (textView5 != null) {
                                        i3 = R.id.send_btn;
                                        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.send_btn);
                                        if (qUIButton != null) {
                                            i3 = R.id.jst;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.jst);
                                            if (linearLayout != null) {
                                                return new ah(interceptParentTouchLayout, textView, interceptParentTouchLayout, recyclerView, textView2, frameLayout, textView3, qUICheckBox, textView4, textView5, qUIButton, linearLayout);
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
    public static ah g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static ah h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fr7, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterceptParentTouchLayout getRoot() {
        return this.f444744a;
    }
}
