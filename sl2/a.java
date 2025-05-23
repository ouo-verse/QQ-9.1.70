package sl2;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements BusinessObserver {
    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        if (i3 == 1 && bundle != null) {
            int i16 = bundle.getInt("btype");
            String string = bundle.getString("bid");
            if (((INotifyMsgApi) QRoute.api(INotifyMsgApi.class)).checkBusinessType(i16) && !TextUtils.isEmpty(string)) {
                a(i16, string, bundle);
            }
        }
    }

    public void a(int i3, String str, Bundle bundle) {
    }
}
