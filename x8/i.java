package x8;

import com.qzone.proxy.feedcomponent.text.EmoObjectPool;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes36.dex */
public class i extends j {

    /* renamed from: h, reason: collision with root package name */
    private TextLayoutBase f447406h;

    public i(TextLayoutBase textLayoutBase, Pattern pattern) {
        super(pattern);
        this.f447406h = textLayoutBase;
    }

    @Override // x8.j
    public ArrayList<TextCell> c(int i3, boolean z16, TextLayoutBase textLayoutBase, CharSequence charSequence, ArrayList<TextCell> arrayList) {
        TextCell j3 = EmoObjectPool.f().j(this.f447411e, Math.max(i3, ViewUtils.dip2px(10.0f)), this.f447406h);
        if (j3 == null) {
            j3 = new TextCell(0, this.f447411e);
        }
        arrayList.add(j3);
        return arrayList;
    }
}
