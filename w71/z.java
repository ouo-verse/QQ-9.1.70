package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class z implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f444936a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f444937b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f444938c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f444939d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f444940e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f444941f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f444942g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f444943h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final CheckBox f444944i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final CheckBox f444945j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final CheckBox f444946k;

    z(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3) {
        this.f444936a = linearLayout;
        this.f444937b = textView;
        this.f444938c = textView2;
        this.f444939d = textView3;
        this.f444940e = textView4;
        this.f444941f = textView5;
        this.f444942g = textView6;
        this.f444943h = textView7;
        this.f444944i = checkBox;
        this.f444945j = checkBox2;
        this.f444946k = checkBox3;
    }

    @NonNull
    public static z e(@NonNull View view) {
        int i3 = R.id.td7;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.td7);
        if (textView != null) {
            i3 = R.id.f164657te0;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f164657te0);
            if (textView2 != null) {
                i3 = R.id.ten;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.ten);
                if (textView3 != null) {
                    i3 = R.id.teo;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.teo);
                    if (textView4 != null) {
                        i3 = R.id.tep;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tep);
                        if (textView5 != null) {
                            i3 = R.id.teq;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.teq);
                            if (textView6 != null) {
                                i3 = R.id.ter;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.ter);
                                if (textView7 != null) {
                                    i3 = R.id.tp_;
                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.tp_);
                                    if (checkBox != null) {
                                        i3 = R.id.tpa;
                                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.tpa);
                                        if (checkBox2 != null) {
                                            i3 = R.id.tps;
                                            CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.tps);
                                            if (checkBox3 != null) {
                                                return new z((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, checkBox, checkBox2, checkBox3);
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
    public static z g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static z h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e0q, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f444936a;
    }
}
