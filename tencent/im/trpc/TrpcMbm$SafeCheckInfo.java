package tencent.im.trpc;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcMbm$SafeCheckInfo extends MessageMicro<TrpcMbm$SafeCheckInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58, 66, 74}, new String[]{"scene", "verify_method", "client_ver", AudienceReportConst.CLIENT_TYPE, "platform", "dev_name", "guid", "qimei36", "user_agent"}, new Object[]{0, 0, "", 0, "", "", "", "", ""}, TrpcMbm$SafeCheckInfo.class);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBEnumField verify_method = PBField.initEnum(0);
    public final PBStringField client_ver = PBField.initString("");
    public final PBEnumField client_type = PBField.initEnum(0);
    public final PBStringField platform = PBField.initString("");
    public final PBStringField dev_name = PBField.initString("");
    public final PBStringField guid = PBField.initString("");
    public final PBStringField qimei36 = PBField.initString("");
    public final PBStringField user_agent = PBField.initString("");
}
