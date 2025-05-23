package yp3;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.addfriend.commonchannel.e;
import com.tencent.mobileqq.onlinestatus.OnlineStateOpenSdkCommonChannelActionHandler;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.tofumsg.handlers.TofuOpenSdkCommonChannelActionHandler;
import com.tencent.mobileqq.troop.opensdkhandler.GuildBindTroopChannelActionHandler;
import com.tencent.mobileqq.wink.share.WinkShareOpenSdkCommonChannelActionHandler;
import java.util.HashMap;
import zp3.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/OpenSdkApi/Inject_commonchannel_action_handler.yml", version = 1)
    public static HashMap<String, Class<? extends c>> f450782a;

    static {
        HashMap<String, Class<? extends c>> hashMap = new HashMap<>();
        f450782a = hashMap;
        hashMap.put("3007", GuildBindTroopChannelActionHandler.class);
        f450782a.put("3006", e.class);
        f450782a.put("3005", TofuOpenSdkCommonChannelActionHandler.class);
        f450782a.put("3004", WinkShareOpenSdkCommonChannelActionHandler.class);
        f450782a.put("3002", OnlineStateOpenSdkCommonChannelActionHandler.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static c a(String str, BaseQQAppInterface baseQQAppInterface, Context context) {
        Class<? extends c> cls;
        if (str != null && (cls = f450782a.get(str)) != null) {
            try {
                return cls.newInstance();
            } catch (Exception e16) {
                hd0.c.h("CommonChannelJumpActionInjectManager", "createInjectHandler exception", e16);
            }
        }
        return null;
    }
}
