package x8;

import com.qzone.proxy.feedcomponent.text.EmoObjectPool;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e extends j {

    /* renamed from: h, reason: collision with root package name */
    private TextLayoutBase f447403h;

    public e(TextLayoutBase textLayoutBase, Pattern pattern) {
        super(pattern);
        this.f447403h = textLayoutBase;
    }

    @Override // x8.j
    public ArrayList<TextCell> c(int i3, boolean z16, TextLayoutBase textLayoutBase, CharSequence charSequence, ArrayList<TextCell> arrayList) {
        arrayList.add(EmoObjectPool.f().e(this.f447411e, i3, this.f447403h).cloneEmoCell());
        return arrayList;
    }
}
