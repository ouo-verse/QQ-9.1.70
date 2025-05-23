package w71;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.reply.ReplyTextRelativeLayout;
import com.tencent.mobileqq.qqui.widget.MosaicTextView;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.qqnt.aio.widget.AIOMsgTextView;
import com.tencent.qqnt.aio.widget.AsyncImageView;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class m implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ReplyTextRelativeLayout f444844a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f444845b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f444846c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f444847d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f444848e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f444849f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f444850g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f444851h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f444852i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f444853j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final MosaicTextView f444854k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final AIOMsgTextView f444855l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f444856m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final AsyncImageView f444857n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final RoundBubbleImageView f444858o;

    m(@NonNull ReplyTextRelativeLayout replyTextRelativeLayout, @NonNull View view, @NonNull View view2, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull RelativeLayout relativeLayout2, @NonNull MosaicTextView mosaicTextView, @NonNull AIOMsgTextView aIOMsgTextView, @NonNull TextView textView4, @NonNull AsyncImageView asyncImageView, @NonNull RoundBubbleImageView roundBubbleImageView) {
        this.f444844a = replyTextRelativeLayout;
        this.f444845b = view;
        this.f444846c = view2;
        this.f444847d = textView;
        this.f444848e = imageView;
        this.f444849f = relativeLayout;
        this.f444850g = imageView2;
        this.f444851h = textView2;
        this.f444852i = textView3;
        this.f444853j = relativeLayout2;
        this.f444854k = mosaicTextView;
        this.f444855l = aIOMsgTextView;
        this.f444856m = textView4;
        this.f444857n = asyncImageView;
        this.f444858o = roundBubbleImageView;
    }

    @NonNull
    public static m e(@NonNull View view) {
        int i3 = R.id.lew;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.lew);
        if (findChildViewById != null) {
            i3 = R.id.lfc;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.lfc);
            if (findChildViewById2 != null) {
                i3 = R.id.lin;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.lin);
                if (textView != null) {
                    i3 = R.id.d_m;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.d_m);
                    if (imageView != null) {
                        i3 = R.id.ddn;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ddn);
                        if (relativeLayout != null) {
                            i3 = R.id.f165947lo3;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165947lo3);
                            if (imageView2 != null) {
                                i3 = R.id.f1e;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f1e);
                                if (textView2 != null) {
                                    i3 = R.id.f24820_6;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f24820_6);
                                    if (textView3 != null) {
                                        i3 = R.id.i7f;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.i7f);
                                        if (relativeLayout2 != null) {
                                            i3 = R.id.f86974t4;
                                            MosaicTextView mosaicTextView = (MosaicTextView) ViewBindings.findChildViewById(view, R.id.f86974t4);
                                            if (mosaicTextView != null) {
                                                i3 = R.id.f87044ta;
                                                AIOMsgTextView aIOMsgTextView = (AIOMsgTextView) ViewBindings.findChildViewById(view, R.id.f87044ta);
                                                if (aIOMsgTextView != null) {
                                                    i3 = R.id.f86984t5;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f86984t5);
                                                    if (textView4 != null) {
                                                        i3 = R.id.jkq;
                                                        AsyncImageView asyncImageView = (AsyncImageView) ViewBindings.findChildViewById(view, R.id.jkq);
                                                        if (asyncImageView != null) {
                                                            i3 = R.id.jks;
                                                            RoundBubbleImageView roundBubbleImageView = (RoundBubbleImageView) ViewBindings.findChildViewById(view, R.id.jks);
                                                            if (roundBubbleImageView != null) {
                                                                return new m((ReplyTextRelativeLayout) view, findChildViewById, findChildViewById2, textView, imageView, relativeLayout, imageView2, textView2, textView3, relativeLayout2, mosaicTextView, aIOMsgTextView, textView4, asyncImageView, roundBubbleImageView);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ReplyTextRelativeLayout getRoot() {
        return this.f444844a;
    }
}
