package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.guild.aio.panel.photo.InterceptParentTouchLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class z implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final InterceptParentTouchLayout f442061a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442062b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final InterceptParentTouchLayout f442063c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f442064d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final QUICheckBox f442065e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442066f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f442067g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final QUIButton f442068h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442069i;

    z(@NonNull InterceptParentTouchLayout interceptParentTouchLayout, @NonNull TextView textView, @NonNull InterceptParentTouchLayout interceptParentTouchLayout2, @NonNull RecyclerView recyclerView, @NonNull QUICheckBox qUICheckBox, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull QUIButton qUIButton, @NonNull LinearLayout linearLayout) {
        this.f442061a = interceptParentTouchLayout;
        this.f442062b = textView;
        this.f442063c = interceptParentTouchLayout2;
        this.f442064d = recyclerView;
        this.f442065e = qUICheckBox;
        this.f442066f = textView2;
        this.f442067g = textView3;
        this.f442068h = qUIButton;
        this.f442069i = linearLayout;
    }

    @NonNull
    public static z e(@NonNull View view) {
        int i3 = R.id.f164256p2;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f164256p2);
        if (textView != null) {
            InterceptParentTouchLayout interceptParentTouchLayout = (InterceptParentTouchLayout) view;
            i3 = R.id.f165251vc3;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f165251vc3);
            if (recyclerView != null) {
                i3 = R.id.h1y;
                QUICheckBox qUICheckBox = (QUICheckBox) ViewBindings.findChildViewById(view, R.id.h1y);
                if (qUICheckBox != null) {
                    i3 = R.id.h1z;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.h1z);
                    if (textView2 != null) {
                        i3 = R.id.f166661h24;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f166661h24);
                        if (textView3 != null) {
                            i3 = R.id.send_btn;
                            QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.send_btn);
                            if (qUIButton != null) {
                                i3 = R.id.jst;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.jst);
                                if (linearLayout != null) {
                                    return new z(interceptParentTouchLayout, textView, interceptParentTouchLayout, recyclerView, qUICheckBox, textView2, textView3, qUIButton, linearLayout);
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
    public static z g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static z h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f2b, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterceptParentTouchLayout getRoot() {
        return this.f442061a;
    }
}
