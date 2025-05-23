package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.guild.aio.halfpop.RoundAngleLinearLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class m implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RoundAngleLinearLayout f441976a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f441977b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f441978c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f441979d;

    m(@NonNull RoundAngleLinearLayout roundAngleLinearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f441976a = roundAngleLinearLayout;
        this.f441977b = textView;
        this.f441978c = textView2;
        this.f441979d = textView3;
    }

    @NonNull
    public static m e(@NonNull View view) {
        int i3 = R.id.vyh;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vyh);
        if (textView != null) {
            i3 = R.id.vyi;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.vyi);
            if (textView2 != null) {
                i3 = R.id.vyj;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.vyj);
                if (textView3 != null) {
                    return new m((RoundAngleLinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static m g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ef6, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RoundAngleLinearLayout getRoot() {
        return this.f441976a;
    }
}
