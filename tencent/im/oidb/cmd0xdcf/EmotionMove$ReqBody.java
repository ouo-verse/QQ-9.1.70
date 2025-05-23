package tencent.im.oidb.cmd0xdcf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class EmotionMove$ReqBody extends MessageMicro<EmotionMove$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"msg_comm_info", "str_req_filename", "uint32_capacity_incr"}, new Object[]{null, "", 0}, EmotionMove$ReqBody.class);
    public EmotionMove$PlatInfo msg_comm_info = new EmotionMove$PlatInfo();
    public final PBRepeatField<String> str_req_filename = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field uint32_capacity_incr = PBField.initUInt32(0);
}
