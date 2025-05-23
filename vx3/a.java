package vx3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.android.androidbypass.MarkdownTextView;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.markdown.codeblock.ObservableScrollView;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f443638a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f443639b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f443640c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final MarkdownTextView f443641d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f443642e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f443643f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f443644g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f443645h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f443646i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f443647j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ObservableScrollView f443648k;

    a(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull MarkdownTextView markdownTextView, @NonNull FrameLayout frameLayout2, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView2, @NonNull View view, @NonNull ObservableScrollView observableScrollView) {
        this.f443638a = linearLayout;
        this.f443639b = frameLayout;
        this.f443640c = imageView;
        this.f443641d = markdownTextView;
        this.f443642e = frameLayout2;
        this.f443643f = textView;
        this.f443644g = imageView2;
        this.f443645h = relativeLayout;
        this.f443646i = textView2;
        this.f443647j = view;
        this.f443648k = observableScrollView;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.u09;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.u09);
        if (frameLayout != null) {
            i3 = R.id.u0_;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.u0_);
            if (imageView != null) {
                i3 = R.id.u0a;
                MarkdownTextView markdownTextView = (MarkdownTextView) ViewBindings.findChildViewById(view, R.id.u0a);
                if (markdownTextView != null) {
                    i3 = R.id.u0b;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.u0b);
                    if (frameLayout2 != null) {
                        i3 = R.id.u0c;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.u0c);
                        if (textView != null) {
                            i3 = R.id.u9k;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.u9k);
                            if (imageView2 != null) {
                                i3 = R.id.u9l;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.u9l);
                                if (relativeLayout != null) {
                                    i3 = R.id.u9q;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.u9q);
                                    if (textView2 != null) {
                                        i3 = R.id.uzi;
                                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.uzi);
                                        if (findChildViewById != null) {
                                            i3 = R.id.iig;
                                            ObservableScrollView observableScrollView = (ObservableScrollView) ViewBindings.findChildViewById(view, R.id.iig);
                                            if (observableScrollView != null) {
                                                return new a((LinearLayout) view, frameLayout, imageView, markdownTextView, frameLayout2, textView, imageView2, relativeLayout, textView2, findChildViewById, observableScrollView);
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
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167779e35, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f443638a;
    }
}
