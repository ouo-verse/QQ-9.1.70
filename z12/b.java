package z12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.guild.aio.msglist.holder.template.BubbleLayoutCompatPress;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f451731a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f451732b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final BubbleLayoutCompatPress f451733c;

    b(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull BubbleLayoutCompatPress bubbleLayoutCompatPress) {
        this.f451731a = constraintLayout;
        this.f451732b = constraintLayout2;
        this.f451733c = bubbleLayoutCompatPress;
    }

    @NonNull
    public static b e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        BubbleLayoutCompatPress bubbleLayoutCompatPress = (BubbleLayoutCompatPress) ViewBindings.findChildViewById(view, R.id.zfv);
        if (bubbleLayoutCompatPress != null) {
            return new b(constraintLayout, constraintLayout, bubbleLayoutCompatPress);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.zfv)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ewf, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f451731a;
    }
}
