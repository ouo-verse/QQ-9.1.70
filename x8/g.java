package x8;

import android.graphics.Color;
import com.qzone.proxy.feedcomponent.text.ColorTextCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import com.qzonex.utils.richtext.element.HighlightElement;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g extends j {
    public g(Pattern pattern) {
        super(pattern);
    }

    @Override // x8.j
    public ArrayList<TextCell> c(int i3, boolean z16, TextLayoutBase textLayoutBase, CharSequence charSequence, ArrayList<TextCell> arrayList) {
        HighlightElement a16 = lp.b.a(this.f447411e);
        ColorTextCell colorTextCell = new ColorTextCell();
        if (a16 == null) {
            arrayList.add(colorTextCell);
            return arrayList;
        }
        colorTextCell.setTextColor(Color.parseColor("#777777"));
        colorTextCell.setClickable(false);
        colorTextCell.text = a16.text;
        arrayList.add(colorTextCell);
        return arrayList;
    }
}
