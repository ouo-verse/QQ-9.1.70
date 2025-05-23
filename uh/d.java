package uh;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001BG\u0012\b\b\u0003\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010 \u001a\u00020\n\u0012\b\b\u0002\u0010'\u001a\u00020!\u00a2\u0006\u0004\b(\u0010)R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Luh/d;", "", "", "a", "I", "c", "()I", "setDrawableId", "(I)V", "drawableId", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "buttonText", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "d", "()Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "onClickListener", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnLongClickListener;", "e", "()Landroid/view/View$OnLongClickListener;", "setOnLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "onLongClickListener", "setContentDescription", "contentDescription", "", "f", "Z", "()Z", "setShowRedDot", "(Z)V", "showRedDot", "<init>", "(ILjava/lang/String;Landroid/view/View$OnClickListener;Landroid/view/View$OnLongClickListener;Ljava/lang/String;Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int drawableId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String buttonText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener onClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View.OnLongClickListener onLongClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String contentDescription;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean showRedDot;

    public d() {
        this(0, null, null, null, null, false, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    /* renamed from: b, reason: from getter */
    public final String getContentDescription() {
        return this.contentDescription;
    }

    /* renamed from: c, reason: from getter */
    public final int getDrawableId() {
        return this.drawableId;
    }

    /* renamed from: d, reason: from getter */
    public final View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    /* renamed from: e, reason: from getter */
    public final View.OnLongClickListener getOnLongClickListener() {
        return this.onLongClickListener;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getShowRedDot() {
        return this.showRedDot;
    }

    public d(int i3, String buttonText, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, String contentDescription, boolean z16) {
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        this.drawableId = i3;
        this.buttonText = buttonText;
        this.onClickListener = onClickListener;
        this.onLongClickListener = onLongClickListener;
        this.contentDescription = contentDescription;
        this.showRedDot = z16;
    }

    public /* synthetic */ d(int i3, String str, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, String str2, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? null : onClickListener, (i16 & 8) != 0 ? null : onLongClickListener, (i16 & 16) == 0 ? str2 : "", (i16 & 32) != 0 ? false : z16);
    }
}
