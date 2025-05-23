package pw2;

import com.tencent.tvideo.protocol.pb.AdAction;
import com.tencent.tvideo.protocol.pb.AdActionField;
import com.tencent.tvideo.protocol.pb.AdActionType;
import com.tencent.tvideo.protocol.pb.AdFeedInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class t {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f427783a;

        static {
            int[] iArr = new int[AdActionType.values().length];
            f427783a = iArr;
            try {
                iArr[AdActionType.AD_ACTION_TYPE_OPEN_H5.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static Map<AdActionField, mv2.a> a(AdFeedInfo adFeedInfo) {
        HashMap hashMap = new HashMap();
        if (adFeedInfo != null && !y.i(adFeedInfo.action_dict)) {
            for (Map.Entry<Integer, AdAction> entry : adFeedInfo.action_dict.entrySet()) {
                AdActionField fromValue = AdActionField.fromValue(entry.getKey().intValue());
                AdAction value = entry.getValue();
                Object b16 = b(value);
                if (fromValue != null && value != null) {
                    hashMap.put(fromValue, new mv2.a(value.action_type, value, b16));
                }
            }
        }
        return hashMap;
    }

    public static Object b(AdAction adAction) {
        AdActionType adActionType;
        if (adAction == null || (adActionType = adAction.action_type) == null) {
            return null;
        }
        try {
            if (a.f427783a[adActionType.ordinal()] != 1) {
                return null;
            }
            return adAction.action_item.web_action;
        } catch (Exception unused) {
            return null;
        }
    }
}
