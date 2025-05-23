package tencent.im.oidb.cmd0xb85;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xb85$ReqBody extends MessageMicro<Oidb_0xb85$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 90, 98}, new String[]{"openid", "openkey", "appid", "service_id", "report_score_req", "get_ranklist_req"}, new Object[]{"", "", 0, 0, null, null}, Oidb_0xb85$ReqBody.class);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField openkey = PBField.initString("");
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBInt32Field service_id = PBField.initInt32(0);
    public Oidb_0xb85$ReportScoreReqBody report_score_req = new Oidb_0xb85$ReportScoreReqBody();
    public Oidb_0xb85$GetRankListReqBody get_ranklist_req = new Oidb_0xb85$GetRankListReqBody();
}
