package tencent.im.group_pro_proto.group_pro.comm;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgTransData$TransData extends MessageMicro<msgTransData$TransData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_client_identity"}, new Object[]{null}, msgTransData$TransData.class);
    public msgTransData$ClientIdentity rpt_client_identity = new MessageMicro<msgTransData$ClientIdentity>() { // from class: tencent.im.group_pro_proto.group_pro.comm.msgTransData$ClientIdentity
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{CommonConstant.ReqAccessTokenParam.CLIENT_ID, "desc"}, new Object[]{0, ""}, msgTransData$ClientIdentity.class);
        public final PBUInt32Field client_id = PBField.initUInt32(0);
        public final PBStringField desc = PBField.initString("");
    };
}
