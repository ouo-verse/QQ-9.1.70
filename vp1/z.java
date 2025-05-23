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
public final class z implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f443145a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f443146b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUISingleLineListItem f443147c;

    z(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull QUISingleLineListItem qUISingleLineListItem) {
        this.f443145a = linearLayout;
        this.f443146b = textView;
        this.f443147c = qUISingleLineListItem;
    }

    @NonNull
    public static z e(@NonNull View view) {
        int i3 = R.id.f83894ks;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f83894ks);
        if (textView != null) {
            i3 = R.id.f85634ph;
            QUISingleLineListItem qUISingleLineListItem = (QUISingleLineListItem) ViewBindings.findChildViewById(view, R.id.f85634ph);
            if (qUISingleLineListItem != null) {
                return new z((LinearLayout) view, textView, qUISingleLineListItem);
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
        View inflate = layoutInflater.inflate(R.layout.eio, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f443145a;
    }
}
