package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f444818a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f444819b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f444820c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f444821d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f444822e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f444823f;

    j(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f444818a = frameLayout;
        this.f444819b = imageView;
        this.f444820c = constraintLayout;
        this.f444821d = textView;
        this.f444822e = textView2;
        this.f444823f = textView3;
    }

    @NonNull
    public static j e(@NonNull View view) {
        int i3 = R.id.y36;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.y36);
        if (imageView != null) {
            i3 = R.id.zfy;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.zfy);
            if (constraintLayout != null) {
                i3 = R.id.f167042k73;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f167042k73);
                if (textView != null) {
                    i3 = R.id.f109756go;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f109756go);
                    if (textView2 != null) {
                        i3 = R.id.kbs;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.kbs);
                        if (textView3 != null) {
                            return new j((FrameLayout) view, imageView, constraintLayout, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static j g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167614dw1, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f444818a;
    }
}
