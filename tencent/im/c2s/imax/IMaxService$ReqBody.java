package tencent.im.c2s.imax;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class IMaxService$ReqBody extends MessageMicro<IMaxService$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"int32_type", "msg_exposure", "msg_ignoreAD"}, new Object[]{0, null, null}, IMaxService$ReqBody.class);
    public final PBInt32Field int32_type = PBField.initInt32(0);
    public IMaxService$ExposureMsg msg_exposure = new MessageMicro<IMaxService$ExposureMsg>() { // from class: tencent.im.c2s.imax.IMaxService$ExposureMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"str_ad_id", "uint32_action_type", "uint64_uin"}, new Object[]{"", 0, 0L}, IMaxService$ExposureMsg.class);
        public final PBStringField str_ad_id = PBField.initString("");
        public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    };
    public IMaxService$IgnoreADMsg msg_ignoreAD = new MessageMicro<IMaxService$IgnoreADMsg>() { // from class: tencent.im.c2s.imax.IMaxService$IgnoreADMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "str_ad_id"}, new Object[]{0L, ""}, IMaxService$IgnoreADMsg.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBStringField str_ad_id = PBField.initString("");
    };
}
