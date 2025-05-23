package ut;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.tencent.android.androidbypass.Bypass;
import com.tencent.android.androidbypass.parser.api.d;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J:\u0010\u0013\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H'J0\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a8\u0006\u001a"}, d2 = {"Lut/a;", "", "Landroid/net/Uri;", "src", "", "a", "Landroid/widget/TextView;", "tv", "Lcom/tencent/android/androidbypass/Bypass$f;", "options", "Landroid/text/SpannableStringBuilder;", "builder", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "", QCircleSchemeAttr.Polymerize.ALT, "", "traceId", "", "c", "Landroid/content/Context;", "context", "", "mkMaxWidth", "Landroid/view/View;", "b", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface a {
    boolean a(@NotNull Uri src);

    @NotNull
    View b(@NotNull Context context, @NotNull Bypass.f options, @NotNull d parsedResult, @NotNull String alt, int mkMaxWidth);

    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "\u4f7f\u7528rederView\u4ee3\u66ff", imports = {}))
    void c(@Nullable TextView tv5, @NotNull Bypass.f options, @NotNull SpannableStringBuilder builder, @NotNull d parsedResult, @NotNull String alt, long traceId);
}
