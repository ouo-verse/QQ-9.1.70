package vf2;

import android.widget.TextView;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.ecommerce.biz.live.IECLiveNumberFontLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lvf2/a;", "Lcom/tencent/ecommerce/biz/live/IECLiveNumberFontLoader;", "Landroid/widget/TextView;", "textView", "", "setNumberTypeFace", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements IECLiveNumberFontLoader {
    @Override // com.tencent.ecommerce.biz.live.IECLiveNumberFontLoader
    public void setNumberTypeFace(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        RFWTypefaceUtil.setNumberTypeface(textView, "https://dlied5.qq.com/now/qq-live/fonts/EurostileNextPro-Bold.ttf");
    }
}
