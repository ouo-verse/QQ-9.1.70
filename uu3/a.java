package uu3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.AIOInputSendBtn;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tx.x2j.AioInputbarLayoutBinding;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f440052a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final AIOEditText f440053b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f440054c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final AIOInputSendBtn f440055d;

    a(@NonNull ConstraintLayout constraintLayout, @NonNull AIOEditText aIOEditText, @NonNull ConstraintLayout constraintLayout2, @NonNull AIOInputSendBtn aIOInputSendBtn) {
        this.f440052a = constraintLayout;
        this.f440053b = aIOEditText;
        this.f440054c = constraintLayout2;
        this.f440055d = aIOInputSendBtn;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.input;
        AIOEditText aIOEditText = (AIOEditText) ViewBindings.findChildViewById(view, R.id.input);
        if (aIOEditText != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            AIOInputSendBtn aIOInputSendBtn = (AIOInputSendBtn) ViewBindings.findChildViewById(view, R.id.send_btn);
            if (aIOInputSendBtn != null) {
                return new a(constraintLayout, aIOEditText, constraintLayout, aIOInputSendBtn);
            }
            i3 = R.id.send_btn;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static a h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioInputbarLayoutBinding aioInputbarLayoutBinding = new AioInputbarLayoutBinding();
        aioInputbarLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioInputbarLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dvf, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f440052a;
    }
}
