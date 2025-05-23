package x8;

import com.qzone.proxy.feedcomponent.text.EmoObjectPool;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes36.dex */
public class h extends j {

    /* renamed from: h, reason: collision with root package name */
    private TextLayoutBase f447405h;

    public h(TextLayoutBase textLayoutBase, Pattern pattern) {
        super(pattern);
        this.f447405h = textLayoutBase;
    }

    @Override // x8.j
    public ArrayList<TextCell> c(int i3, boolean z16, TextLayoutBase textLayoutBase, CharSequence charSequence, ArrayList<TextCell> arrayList) {
        arrayList.add(EmoObjectPool.f().h(this.f447411e, Math.max(i3, ViewUtils.dip2px(10.0f)), this.f447405h));
        return arrayList;
    }
}
