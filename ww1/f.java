package ww1;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.guild.jump.api.IJumpParserApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f extends av {

    /* renamed from: a, reason: collision with root package name */
    private IJumpParserApi f446617a;

    private synchronized IJumpParserApi b() {
        if (this.f446617a == null) {
            this.f446617a = (IJumpParserApi) QRoute.api(IJumpParserApi.class);
        }
        return this.f446617a;
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        IJumpParserApi.a aVar = new IJumpParserApi.a();
        return h.F(baseQQAppInterface, context, b().createActionableForRobot(baseQQAppInterface, context, jumpParserResult, aVar), str, jumpParserResult, aVar);
    }
}
