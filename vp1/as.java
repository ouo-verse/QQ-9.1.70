package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.main.view.QQGuildChannelRecyclerViewEx;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class as implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442283a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final DragFrameLayout f442284b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QQGuildChannelRecyclerViewEx f442285c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewStub f442286d;

    as(@NonNull View view, @NonNull DragFrameLayout dragFrameLayout, @NonNull QQGuildChannelRecyclerViewEx qQGuildChannelRecyclerViewEx, @NonNull ViewStub viewStub) {
        this.f442283a = view;
        this.f442284b = dragFrameLayout;
        this.f442285c = qQGuildChannelRecyclerViewEx;
        this.f442286d = viewStub;
    }

    @NonNull
    public static as e(@NonNull View view) {
        int i3 = R.id.ulf;
        DragFrameLayout dragFrameLayout = (DragFrameLayout) ViewBindings.findChildViewById(view, R.id.ulf);
        if (dragFrameLayout != null) {
            i3 = R.id.eap;
            QQGuildChannelRecyclerViewEx qQGuildChannelRecyclerViewEx = (QQGuildChannelRecyclerViewEx) ViewBindings.findChildViewById(view, R.id.eap);
            if (qQGuildChannelRecyclerViewEx != null) {
                i3 = R.id.f89384zm;
                ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.f89384zm);
                if (viewStub != null) {
                    return new as(view, dragFrameLayout, qQGuildChannelRecyclerViewEx, viewStub);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static as f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.emm, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442283a;
    }
}
