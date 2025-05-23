package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ai implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f444756a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f444757b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f444758c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f444759d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f444760e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f444761f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f444762g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f444763h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final CheckBox f444764i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final CheckBox f444765j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f444766k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f444767l;

    ai(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView8) {
        this.f444756a = linearLayout;
        this.f444757b = textView;
        this.f444758c = textView2;
        this.f444759d = textView3;
        this.f444760e = textView4;
        this.f444761f = textView5;
        this.f444762g = textView6;
        this.f444763h = textView7;
        this.f444764i = checkBox;
        this.f444765j = checkBox2;
        this.f444766k = relativeLayout;
        this.f444767l = textView8;
    }

    @NonNull
    public static ai e(@NonNull View view) {
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
                                    i3 = R.id.tpa;
                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.tpa);
                                    if (checkBox != null) {
                                        i3 = R.id.tps;
                                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.tps);
                                        if (checkBox2 != null) {
                                            i3 = R.id.yr9;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.yr9);
                                            if (relativeLayout != null) {
                                                i3 = R.id.yr_;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.yr_);
                                                if (textView8 != null) {
                                                    return new ai((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, checkBox, checkBox2, relativeLayout, textView8);
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
    public static ai g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static ai h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.i0y, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f444756a;
    }
}
