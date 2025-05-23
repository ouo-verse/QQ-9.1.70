package vp1;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class r implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f443086a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f443087b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f443088c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f443089d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f443090e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f443091f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f443092g;

    r(@NonNull RelativeLayout relativeLayout, @NonNull EditText editText, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView2, @NonNull FrameLayout frameLayout) {
        this.f443086a = relativeLayout;
        this.f443087b = editText;
        this.f443088c = imageView;
        this.f443089d = textView;
        this.f443090e = relativeLayout2;
        this.f443091f = textView2;
        this.f443092g = frameLayout;
    }

    @NonNull
    public static r e(@NonNull View view) {
        int i3 = R.id.et_search_keyword;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_search_keyword);
        if (editText != null) {
            i3 = R.id.ib_clear_text;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ib_clear_text);
            if (imageView != null) {
                i3 = R.id.ijd;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ijd);
                if (textView != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i3 = R.id.kag;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.kag);
                    if (textView2 != null) {
                        i3 = R.id.f110986k0;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f110986k0);
                        if (frameLayout != null) {
                            return new r(relativeLayout, editText, imageView, textView, relativeLayout, textView2, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f443086a;
    }
}
