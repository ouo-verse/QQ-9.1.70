package tencent.im.group_pro_proto.user;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgTransData$ClientIdentity extends MessageMicro<msgTransData$ClientIdentity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{CommonConstant.ReqAccessTokenParam.CLIENT_ID, "desc", "client_identity_bytes"}, new Object[]{0, "", null}, msgTransData$ClientIdentity.class);
    public final PBUInt32Field client_id = PBField.initUInt32(0);
    public final PBStringField desc = PBField.initString("");
    public msgTransData$ClientIdentityBytes client_identity_bytes = new msgTransData$ClientIdentityBytes();
}
