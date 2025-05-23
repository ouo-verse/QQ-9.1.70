package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMaterialGeneralService$MaterialGeneralSrvReq extends MessageMicro<QShadowMaterialGeneralService$MaterialGeneralSrvReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"srv_func_name", "params"}, new Object[]{"", null}, QShadowMaterialGeneralService$MaterialGeneralSrvReq.class);
    public final PBStringField srv_func_name = PBField.initString("");
    public final PBRepeatMessageField<QShadowMaterialGeneralService$ParamEntry> params = PBField.initRepeatMessage(QShadowMaterialGeneralService$ParamEntry.class);
}
