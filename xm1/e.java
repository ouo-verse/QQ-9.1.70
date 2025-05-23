package xm1;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e extends com.tencent.mobileqq.guild.feed.part.d {
    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        RFWLayoutPreLoaderFactory.getLayoutLoader(gj1.a.a().c()).preloadView(activity, R.layout.euu, 10);
    }
}
