package weprotocols;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class WEProtocolsVaslive$BatchGetQLiveInfoReq extends MessageMicro<WEProtocolsVaslive$BatchGetQLiveInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"roomId"}, new Object[]{0L}, WEProtocolsVaslive$BatchGetQLiveInfoReq.class);
    public final PBRepeatField<Long> roomId = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
