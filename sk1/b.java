package sk1;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.widget.u;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\u0007B1\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0007\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\f\u0010\nR\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0013\u0010\u001d\u00a8\u0006\""}, d2 = {"Lsk1/b;", "Landroid/text/style/CharacterStyle;", "Landroid/text/TextPaint;", "textPaint", "", "updateDrawState", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "url", "b", "getDisplayText", "displayText", "", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "iconType", "d", "I", "getColor", "()I", "color", "e", "renderText", "", "f", "Z", "()Z", "isRich", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)V", "g", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends CharacterStyle {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String displayText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer iconType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int color;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String renderText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isRich;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u0010"}, d2 = {"Lsk1/b$a;", "", "", "d", "", "url", "Landroid/widget/EditText;", "editText", "Lsk1/b;", "b", "iconType", "displayText", "Landroid/text/SpannableString;", "c", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sk1.b$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d() {
            return ContextCompat.getColor(BaseApplication.context, R.color.qui_common_text_link);
        }

        @NotNull
        public final b b(@NotNull String url, @NotNull EditText editText) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(editText, "editText");
            return new b(url, null, null, ContextCompat.getColor(editText.getContext(), R.color.qui_common_text_link));
        }

        @NotNull
        public final SpannableString c(int iconType, @NotNull String displayText, @NotNull String url, @NotNull EditText editText) {
            Intrinsics.checkNotNullParameter(displayText, "displayText");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(editText, "editText");
            SpannableString spannableString = new SpannableString("\u200b" + displayText);
            a aVar = a.f433915a;
            Context context = editText.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "editText.context");
            Drawable b16 = a.b(aVar, iconType, context, null, 4, null);
            if (b16 != null) {
                Paint.FontMetrics fontMetrics = editText.getPaint().getFontMetrics();
                int i3 = (int) ((fontMetrics.descent - fontMetrics.ascent) * 1.2d);
                b16.setBounds(0, 0, i3, i3);
                spannableString.setSpan(new u(b16, 1), 0, 1, 33);
            }
            spannableString.setSpan(new b(url, displayText, Integer.valueOf(iconType), ContextCompat.getColor(editText.getContext(), R.color.qui_common_text_link)), 0, spannableString.length(), 33);
            return spannableString;
        }

        Companion() {
        }
    }

    public /* synthetic */ b(String str, String str2, Integer num, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? null : str2, (i16 & 4) != 0 ? null : num, (i16 & 8) != 0 ? INSTANCE.d() : i3);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getIconType() {
        return this.iconType;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getRenderText() {
        return this.renderText;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsRich() {
        return this.isRich;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setUnderlineText(false);
        textPaint.setColor(this.color);
    }

    public b(@NotNull String url, @Nullable String str, @Nullable Integer num, int i3) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.displayText = str;
        this.iconType = num;
        this.color = i3;
        this.renderText = str == null || str.length() == 0 ? url : str;
        this.isRich = !(str == null || str.length() == 0);
    }
}
