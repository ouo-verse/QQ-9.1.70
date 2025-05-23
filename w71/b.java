package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.reply.AIOReplyLinearLayout;
import com.tx.x2j.AioBubbleContentAndReplyBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final AIOReplyLinearLayout f444772a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final m f444773b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final AIOReplyLinearLayout f444774c;

    b(@NonNull AIOReplyLinearLayout aIOReplyLinearLayout, @NonNull m mVar, @NonNull AIOReplyLinearLayout aIOReplyLinearLayout2) {
        this.f444772a = aIOReplyLinearLayout;
        this.f444773b = mVar;
        this.f444774c = aIOReplyLinearLayout2;
    }

    @NonNull
    public static b e(@NonNull View view) {
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f73283t5);
        if (findChildViewById != null) {
            AIOReplyLinearLayout aIOReplyLinearLayout = (AIOReplyLinearLayout) view;
            return new b(aIOReplyLinearLayout, m.e(findChildViewById), aIOReplyLinearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f73283t5)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioBubbleContentAndReplyBinding aioBubbleContentAndReplyBinding = new AioBubbleContentAndReplyBinding();
        aioBubbleContentAndReplyBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioBubbleContentAndReplyBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dui, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public AIOReplyLinearLayout getRoot() {
        return this.f444772a;
    }
}
