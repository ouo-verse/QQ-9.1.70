package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class de implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FlexboxLayout f442882a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUISingleLineInputView f442883b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FlexboxLayout f442884c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442885d;

    de(@NonNull FlexboxLayout flexboxLayout, @NonNull QUISingleLineInputView qUISingleLineInputView, @NonNull FlexboxLayout flexboxLayout2, @NonNull TextView textView) {
        this.f442882a = flexboxLayout;
        this.f442883b = qUISingleLineInputView;
        this.f442884c = flexboxLayout2;
        this.f442885d = textView;
    }

    @NonNull
    public static de e(@NonNull View view) {
        int i3 = R.id.xoz;
        QUISingleLineInputView qUISingleLineInputView = (QUISingleLineInputView) ViewBindings.findChildViewById(view, R.id.xoz);
        if (qUISingleLineInputView != null) {
            i3 = R.id.yje;
            FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view, R.id.yje);
            if (flexboxLayout != null) {
                i3 = R.id.f657439r;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f657439r);
                if (textView != null) {
                    return new de((FlexboxLayout) view, qUISingleLineInputView, flexboxLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static de g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f4j, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout getRoot() {
        return this.f442882a;
    }
}
