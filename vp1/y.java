package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class y implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f443141a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f443142b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f443143c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QUISingleLineListItem f443144d;

    y(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull QUISingleLineListItem qUISingleLineListItem) {
        this.f443141a = linearLayout;
        this.f443142b = textView;
        this.f443143c = textView2;
        this.f443144d = qUISingleLineListItem;
    }

    @NonNull
    public static y e(@NonNull View view) {
        int i3 = R.id.f83904kt;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f83904kt);
        if (textView != null) {
            i3 = R.id.f83914ku;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f83914ku);
            if (textView2 != null) {
                i3 = R.id.f85634ph;
                QUISingleLineListItem qUISingleLineListItem = (QUISingleLineListItem) ViewBindings.findChildViewById(view, R.id.f85634ph);
                if (qUISingleLineListItem != null) {
                    return new y((LinearLayout) view, textView, textView2, qUISingleLineListItem);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static y g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static y h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ein, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f443141a;
    }
}
