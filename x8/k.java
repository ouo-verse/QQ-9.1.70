package x8;

import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import com.qzone.proxy.feedcomponent.text.TopicTextCell;
import com.qzonex.utils.richtext.element.TopicElement;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J@\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a8\u0006\u0014"}, d2 = {"Lx8/k;", "Lx8/j;", "", "bound", "", "clickable", "Lcom/qzone/proxy/feedcomponent/text/TextLayoutBase;", "view", "", "text", "Ljava/util/ArrayList;", "Lcom/qzone/proxy/feedcomponent/text/TextCell;", "cells", "c", "Ljava/util/regex/Pattern;", "pattern", "<init>", "(Ljava/util/regex/Pattern;)V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k extends j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Pattern pattern) {
        super(pattern);
        Intrinsics.checkNotNullParameter(pattern, "pattern");
    }

    @Override // x8.j
    public ArrayList<TextCell> c(int bound, boolean clickable, TextLayoutBase view, CharSequence text, ArrayList<TextCell> cells) {
        Intrinsics.checkNotNullParameter(cells, "cells");
        TopicElement a16 = xd.a.a(this.f447411e);
        TopicTextCell topicTextCell = new TopicTextCell();
        if (a16 == null) {
            cells.add(topicTextCell);
            return cells;
        }
        topicTextCell.type = 1;
        ef.a aVar = ef.a.f396213a;
        topicTextCell.setTextColor(aVar.a("#465A90", -16776961));
        topicTextCell.text = a16.getTopic();
        topicTextCell.setUrl(a16.getUrl());
        topicTextCell.setInnerLinkTextColor(aVar.a("#465A90", -16776961));
        cells.add(topicTextCell);
        return cells;
    }
}
