package tencent.im.s2c.msgtype0x210.submsgtype0x135;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* loaded from: classes29.dex */
public final class ModulePushPb$MsgBody extends MessageMicro<ModulePushPb$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 72}, new String[]{"int32_service_id", "int32_sub_service_id", "int32_notify_id", "int32_push_id", "int32_type", "int32_recall_flag", "msg_content", "uint64_timestamp", QQHealthReportApiImpl.MSG_TYPE_KEY}, new Object[]{0, 0, 0, 0, 0, 0, null, 0L, 0}, ModulePushPb$MsgBody.class);
    public final PBInt32Field int32_service_id = PBField.initInt32(0);
    public final PBInt32Field int32_sub_service_id = PBField.initInt32(0);
    public final PBInt32Field int32_notify_id = PBField.initInt32(0);
    public final PBInt32Field int32_push_id = PBField.initInt32(0);
    public final PBInt32Field int32_type = PBField.initInt32(0);
    public final PBInt32Field int32_recall_flag = PBField.initInt32(0);
    public ModulePushPb$Content msg_content = new ModulePushPb$Content();
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
    public final PBInt32Field msg_type = PBField.initInt32(0);
}
