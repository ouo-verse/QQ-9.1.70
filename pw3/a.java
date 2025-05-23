package pw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f427788a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f427789b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f427790c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f427791d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f427792e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f427793f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f427794g;

    a(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f427788a = linearLayout;
        this.f427789b = linearLayout2;
        this.f427790c = imageView;
        this.f427791d = imageView2;
        this.f427792e = imageView3;
        this.f427793f = textView;
        this.f427794g = textView2;
    }

    @NonNull
    public static a e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.f166761m53;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f166761m53);
        if (imageView != null) {
            i3 = R.id.f166762m54;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f166762m54);
            if (imageView2 != null) {
                i3 = R.id.f70903mp;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f70903mp);
                if (imageView3 != null) {
                    i3 = R.id.f70913mq;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f70913mq);
                    if (textView != null) {
                        i3 = R.id.f166763m55;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f166763m55);
                        if (textView2 != null) {
                            return new a(linearLayout, linearLayout, imageView, imageView2, imageView3, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static a h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e28, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f427788a;
    }
}
