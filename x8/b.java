package x8;

import com.qzone.proxy.feedcomponent.text.ColorTextCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import com.qzone.widget.x;
import com.qzonex.utils.richtext.element.ColorElement;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends j {
    public b(Pattern pattern) {
        super(pattern);
    }

    @Override // x8.j
    public ArrayList<TextCell> c(int i3, boolean z16, TextLayoutBase textLayoutBase, CharSequence charSequence, ArrayList<TextCell> arrayList) {
        ColorElement e16 = x.e(this.f447411e);
        ColorTextCell colorTextCell = new ColorTextCell();
        if (e16 == null) {
            arrayList.add(colorTextCell);
            return arrayList;
        }
        colorTextCell.type = 9;
        colorTextCell.setTextColor(e16.color);
        colorTextCell.setClickable(false);
        colorTextCell.text = e16.text;
        colorTextCell.useDefaultFont = e16.useDefaultFont;
        colorTextCell.useSuperFont = e16.useSuperFont;
        colorTextCell.useLinkTextColor = e16.useLinkTextColor;
        colorTextCell.setTextBold(e16.isBold);
        arrayList.add(colorTextCell);
        return arrayList;
    }
}
