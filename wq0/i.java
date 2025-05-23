package wq0;

import android.graphics.drawable.Drawable;
import android.text.Spanned;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lwq0/i;", "Lcom/tencent/aio/widget/textView/view/a;", "Landroid/text/Spanned;", "text", "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class i implements com.tencent.aio.widget.textView.view.a {
    @Override // com.tencent.aio.widget.textView.view.a
    @NotNull
    public ArrayList<Drawable> a(@NotNull Spanned text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ArrayList<Drawable> arrayList = new ArrayList<>();
        try {
            for (EmoticonSpan emoticonSpan : (EmoticonSpan[]) text.getSpans(0, text.length(), EmoticonSpan.class)) {
                if (emoticonSpan.getDrawable() != null) {
                    arrayList.add(emoticonSpan.getDrawable());
                }
            }
        } catch (Exception e16) {
            QLog.e("GuildSpanCallback", 1, "[getEmotionSpanDrawable] Exception: " + e16.getMessage());
        }
        return arrayList;
    }
}
