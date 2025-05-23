package ww1;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.guild.jump.api.IJumpParserApi;
import com.tencent.mobileqq.utils.ax;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h extends ax implements IJumpParserApi.c, IJumpParserApi.d, IJumpParserApi.e {
    private final IJumpParserApi.b Q;

    public h(BaseQQAppInterface baseQQAppInterface, Context context, IJumpParserApi.b bVar) {
        super(baseQQAppInterface, context);
        this.Q = bVar;
    }

    public static ax F(BaseQQAppInterface baseQQAppInterface, Context context, IJumpParserApi.b bVar, String str, JumpParserResult jumpParserResult, IJumpParserApi.a aVar) {
        h hVar = new h(baseQQAppInterface, context, bVar);
        aVar.f226401a = hVar;
        aVar.f226402b = hVar;
        aVar.f226403c = hVar;
        hVar.f307438c = str;
        if (jumpParserResult != null) {
            hVar.f307439d = jumpParserResult.getServer();
            hVar.f307440e = jumpParserResult.getAction();
            hVar.s(jumpParserResult.getParamMap());
        }
        return hVar;
    }

    @Override // com.tencent.mobileqq.guild.jump.api.IJumpParserApi.d
    public String a() {
        return this.f307445j;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        return this.Q.a();
    }

    @Override // com.tencent.mobileqq.guild.jump.api.IJumpParserApi.c
    public String getPackageName() {
        return this.f307444i;
    }

    @Override // com.tencent.mobileqq.guild.jump.api.IJumpParserApi.e
    public String getSource() {
        return this.f307438c;
    }
}
