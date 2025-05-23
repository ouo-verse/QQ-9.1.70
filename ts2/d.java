package ts2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationRichTextView;
import com.tx.x2j.QbGroupNotificationListDefaultItemBinding;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f437362a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f437363b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f437364c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewStub f437365d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final QQProAvatarView f437366e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f437367f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ViewStub f437368g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f437369h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437370i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final QUIButton f437371j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TroopNotificationRichTextView f437372k;

    d(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull ViewStub viewStub, @NonNull QQProAvatarView qQProAvatarView, @NonNull FrameLayout frameLayout, @NonNull ViewStub viewStub2, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull QUIButton qUIButton, @NonNull TroopNotificationRichTextView troopNotificationRichTextView) {
        this.f437362a = relativeLayout;
        this.f437363b = imageView;
        this.f437364c = relativeLayout2;
        this.f437365d = viewStub;
        this.f437366e = qQProAvatarView;
        this.f437367f = frameLayout;
        this.f437368g = viewStub2;
        this.f437369h = textView;
        this.f437370i = linearLayout;
        this.f437371j = qUIButton;
        this.f437372k = troopNotificationRichTextView;
    }

    @NonNull
    public static d e(@NonNull View view) {
        int i3 = R.id.f767642j;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f767642j);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i3 = R.id.f103045zj;
            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.f103045zj);
            if (viewStub != null) {
                i3 = R.id.f103075zm;
                QQProAvatarView qQProAvatarView = (QQProAvatarView) ViewBindings.findChildViewById(view, R.id.f103075zm);
                if (qQProAvatarView != null) {
                    i3 = R.id.f103095zo;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f103095zo);
                    if (frameLayout != null) {
                        i3 = R.id.f103135zs;
                        ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, R.id.f103135zs);
                        if (viewStub2 != null) {
                            i3 = R.id.f103195zy;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f103195zy);
                            if (textView != null) {
                                i3 = R.id.f10326605;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f10326605);
                                if (linearLayout != null) {
                                    i3 = R.id.f10328607;
                                    QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.f10328607);
                                    if (qUIButton != null) {
                                        i3 = R.id.f1033760f;
                                        TroopNotificationRichTextView troopNotificationRichTextView = (TroopNotificationRichTextView) ViewBindings.findChildViewById(view, R.id.f1033760f);
                                        if (troopNotificationRichTextView != null) {
                                            return new d(relativeLayout, imageView, relativeLayout, viewStub, qQProAvatarView, frameLayout, viewStub2, textView, linearLayout, qUIButton, troopNotificationRichTextView);
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
    public static d g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static d h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        QbGroupNotificationListDefaultItemBinding qbGroupNotificationListDefaultItemBinding = new QbGroupNotificationListDefaultItemBinding();
        qbGroupNotificationListDefaultItemBinding.t(layoutInflater, viewGroup, z16);
        View u16 = qbGroupNotificationListDefaultItemBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.fve, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getMRv() {
        return this.f437362a;
    }
}
