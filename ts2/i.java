package ts2;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaEditView;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f437401a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f437402b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437403c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final NestedScrollView f437404d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final InputMethodGuard f437405e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final HWMediaEditView f437406f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RecyclerView f437407g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f437408h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final QUIButton f437409i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f437410j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final FrameLayout f437411k;

    i(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull NestedScrollView nestedScrollView, @NonNull InputMethodGuard inputMethodGuard, @NonNull HWMediaEditView hWMediaEditView, @NonNull RecyclerView recyclerView, @NonNull FrameLayout frameLayout2, @NonNull QUIButton qUIButton, @NonNull TextView textView, @NonNull FrameLayout frameLayout3) {
        this.f437401a = frameLayout;
        this.f437402b = imageView;
        this.f437403c = linearLayout;
        this.f437404d = nestedScrollView;
        this.f437405e = inputMethodGuard;
        this.f437406f = hWMediaEditView;
        this.f437407g = recyclerView;
        this.f437408h = frameLayout2;
        this.f437409i = qUIButton;
        this.f437410j = textView;
        this.f437411k = frameLayout3;
    }

    @NonNull
    public static i e(@NonNull View view) {
        int i3 = R.id.azb;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.azb);
        if (imageView != null) {
            i3 = R.id.b9t;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.b9t);
            if (linearLayout != null) {
                i3 = R.id.xc8;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.xc8);
                if (nestedScrollView != null) {
                    i3 = R.id.dmx;
                    InputMethodGuard inputMethodGuard = (InputMethodGuard) ViewBindings.findChildViewById(view, R.id.dmx);
                    if (inputMethodGuard != null) {
                        i3 = R.id.yzx;
                        HWMediaEditView hWMediaEditView = (HWMediaEditView) ViewBindings.findChildViewById(view, R.id.yzx);
                        if (hWMediaEditView != null) {
                            i3 = R.id.z07;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.z07);
                            if (recyclerView != null) {
                                FrameLayout frameLayout = (FrameLayout) view;
                                i3 = R.id.f903752a;
                                QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.f903752a);
                                if (qUIButton != null) {
                                    i3 = R.id.f903852b;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f903852b);
                                    if (textView != null) {
                                        i3 = R.id.jo9;
                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.jo9);
                                        if (frameLayout2 != null) {
                                            return new i(frameLayout, imageView, linearLayout, nestedScrollView, inputMethodGuard, hWMediaEditView, recyclerView, frameLayout, qUIButton, textView, frameLayout2);
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

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f437401a;
    }
}
