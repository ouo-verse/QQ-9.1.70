package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discover.widget.GuildRoundBoardImageView;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f446887a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildRoundBoardImageView f446888b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f446889c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f446890d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f446891e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final QUIButton f446892f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f446893g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f446894h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f446895i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f446896j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final Space f446897k;

    c(@NonNull ConstraintLayout constraintLayout, @NonNull GuildRoundBoardImageView guildRoundBoardImageView, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull QUIButton qUIButton, @NonNull TextView textView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull Space space) {
        this.f446887a = constraintLayout;
        this.f446888b = guildRoundBoardImageView;
        this.f446889c = imageView;
        this.f446890d = constraintLayout2;
        this.f446891e = constraintLayout3;
        this.f446892f = qUIButton;
        this.f446893g = textView;
        this.f446894h = frameLayout;
        this.f446895i = imageView2;
        this.f446896j = textView2;
        this.f446897k = space;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.vzu;
        GuildRoundBoardImageView guildRoundBoardImageView = (GuildRoundBoardImageView) ViewBindings.findChildViewById(view, R.id.vzu);
        if (guildRoundBoardImageView != null) {
            i3 = R.id.w06;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.w06);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i3 = R.id.wji;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.wji);
                if (constraintLayout2 != null) {
                    i3 = R.id.wkv;
                    QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.wkv);
                    if (qUIButton != null) {
                        i3 = R.id.wrw;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wrw);
                        if (textView != null) {
                            i3 = R.id.wvx;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.wvx);
                            if (frameLayout != null) {
                                i3 = R.id.y8a;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.y8a);
                                if (imageView2 != null) {
                                    i3 = R.id.zx9;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.zx9);
                                    if (textView2 != null) {
                                        i3 = R.id.iz9;
                                        Space space = (Space) ViewBindings.findChildViewById(view, R.id.iz9);
                                        if (space != null) {
                                            return new c(constraintLayout, guildRoundBoardImageView, imageView, constraintLayout, constraintLayout2, qUIButton, textView, frameLayout, imageView2, textView2, space);
                                        }
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
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ep6, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f446887a;
    }
}
