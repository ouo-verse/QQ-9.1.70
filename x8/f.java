package x8;

import com.qzone.proxy.feedcomponent.text.EmoCell;
import com.qzone.proxy.feedcomponent.text.EmoObjectPool;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f extends j {

    /* renamed from: h, reason: collision with root package name */
    private TextLayoutBase f447404h;

    public f(TextLayoutBase textLayoutBase, Pattern pattern) {
        super(pattern);
        this.f447404h = textLayoutBase;
    }

    @Override // x8.j
    public ArrayList<TextCell> c(int i3, boolean z16, TextLayoutBase textLayoutBase, CharSequence charSequence, ArrayList<TextCell> arrayList) {
        EmoCell e16 = EmoObjectPool.f().e(this.f447411e, i3, this.f447404h);
        e16.cellIndex = 0;
        arrayList.add(e16);
        return arrayList;
    }
}
