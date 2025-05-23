package vw;

import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageGaussianBlurFilter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends QQAVImageFilterGroup {
    public b() {
        super(null);
        for (int i3 = 0; i3 < 3; i3++) {
            addFilter(new QQAVImageGaussianBlurFilter());
        }
    }
}
