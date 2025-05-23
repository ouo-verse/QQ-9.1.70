package qw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qqnt.chats.view.SkinnableRecycleView;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final QUIBadgeDragLayout f430253a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SkinnableRecycleView f430254b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUIBadgeDragLayout f430255c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final SmartRefreshLayout f430256d;

    a(@NonNull QUIBadgeDragLayout qUIBadgeDragLayout, @NonNull SkinnableRecycleView skinnableRecycleView, @NonNull QUIBadgeDragLayout qUIBadgeDragLayout2, @NonNull SmartRefreshLayout smartRefreshLayout) {
        this.f430253a = qUIBadgeDragLayout;
        this.f430254b = skinnableRecycleView;
        this.f430255c = qUIBadgeDragLayout2;
        this.f430256d = smartRefreshLayout;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.tug;
        SkinnableRecycleView skinnableRecycleView = (SkinnableRecycleView) ViewBindings.findChildViewById(view, R.id.tug);
        if (skinnableRecycleView != null) {
            QUIBadgeDragLayout qUIBadgeDragLayout = (QUIBadgeDragLayout) view;
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, R.id.f72183q6);
            if (smartRefreshLayout != null) {
                return new a(qUIBadgeDragLayout, skinnableRecycleView, qUIBadgeDragLayout, smartRefreshLayout);
            }
            i3 = R.id.f72183q6;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fpe, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public QUIBadgeDragLayout getRoot() {
        return this.f430253a;
    }
}
