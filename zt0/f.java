package zt0;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.vaswebviewplugin.ICGameJsPlugin;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f extends av {

    /* renamed from: a, reason: collision with root package name */
    private IAegisLogApi f453195a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    @NotNull
    private ax b(BaseQQAppInterface baseQQAppInterface, Context context, String str) {
        e eVar = new e(baseQQAppInterface, context);
        eVar.f307438c = str;
        eVar.f307439d = ICGameJsPlugin.BUSINESS_NAME;
        eVar.V();
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return eVar;
        }
        for (String str2 : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                eVar.r(split2[0], split2[1]);
            }
        }
        return eVar;
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        this.f453195a.i("ICGameEntrance|ICGameJumpParser", "parse mqq: " + str);
        if (str.startsWith("mqqapi://icgame")) {
            return b(baseQQAppInterface, context, str);
        }
        return null;
    }
}
