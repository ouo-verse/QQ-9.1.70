package xa2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.qqnt.chats.view.SkinnableRecycleView;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final DragFrameLayout f447576a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SkinnableRecycleView f447577b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final DragFrameLayout f447578c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f447579d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f447580e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f447581f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f447582g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final SmartRefreshLayout f447583h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final FrameLayout f447584i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f447585j;

    d(@NonNull DragFrameLayout dragFrameLayout, @NonNull SkinnableRecycleView skinnableRecycleView, @NonNull DragFrameLayout dragFrameLayout2, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.f447576a = dragFrameLayout;
        this.f447577b = skinnableRecycleView;
        this.f447578c = dragFrameLayout2;
        this.f447579d = relativeLayout;
        this.f447580e = imageView;
        this.f447581f = textView;
        this.f447582g = relativeLayout2;
        this.f447583h = smartRefreshLayout;
        this.f447584i = frameLayout;
        this.f447585j = frameLayout2;
    }

    @NonNull
    public static d e(@NonNull View view) {
        int i3 = R.id.tug;
        SkinnableRecycleView skinnableRecycleView = (SkinnableRecycleView) ViewBindings.findChildViewById(view, R.id.tug);
        if (skinnableRecycleView != null) {
            DragFrameLayout dragFrameLayout = (DragFrameLayout) view;
            i3 = R.id.bwb;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.bwb);
            if (relativeLayout != null) {
                i3 = R.id.bwf;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.bwf);
                if (imageView != null) {
                    i3 = R.id.bws;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.bws);
                    if (textView != null) {
                        i3 = R.id.f28980ke;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f28980ke);
                        if (relativeLayout2 != null) {
                            i3 = R.id.f71863pa;
                            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, R.id.f71863pa);
                            if (smartRefreshLayout != null) {
                                i3 = R.id.f99735ql;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f99735ql);
                                if (frameLayout != null) {
                                    i3 = R.id.f100135ro;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f100135ro);
                                    if (frameLayout2 != null) {
                                        return new d(dragFrameLayout, skinnableRecycleView, dragFrameLayout, relativeLayout, imageView, textView, relativeLayout2, smartRefreshLayout, frameLayout, frameLayout2);
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

    @NonNull
    public static d g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fmw, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public DragFrameLayout getRoot() {
        return this.f447576a;
    }
}
