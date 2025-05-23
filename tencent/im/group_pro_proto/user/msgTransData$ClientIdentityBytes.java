package tencent.im.group_pro_proto.user;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgTransData$ClientIdentityBytes extends MessageMicro<msgTransData$ClientIdentityBytes> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{CommonConstant.ReqAccessTokenParam.CLIENT_ID, "identitys", "default_identitys"}, new Object[]{0, null, null}, msgTransData$ClientIdentityBytes.class);
    public final PBUInt32Field client_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<msgTransData$Identity> identitys = PBField.initRepeatMessage(msgTransData$Identity.class);
    public final PBRepeatMessageField<msgTransData$IdentityV3> default_identitys = PBField.initRepeatMessage(msgTransData$IdentityV3.class);
}
