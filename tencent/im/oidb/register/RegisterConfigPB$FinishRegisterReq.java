package tencent.im.oidb.register;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class RegisterConfigPB$FinishRegisterReq extends MessageMicro<RegisterConfigPB$FinishRegisterReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"call_back_info", "ue_version"}, new Object[]{ByteStringMicro.EMPTY, ""}, RegisterConfigPB$FinishRegisterReq.class);
    public final PBBytesField call_back_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField ue_version = PBField.initString("");
}
