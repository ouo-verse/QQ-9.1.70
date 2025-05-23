package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x111$ReqBody extends MessageMicro<subcmd0x111$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{2186}, new String[]{"msg_subcmd_0x111_req_body"}, new Object[]{null}, subcmd0x111$ReqBody.class);
    public subcmd0x111$SubCmd0x111ReqBody msg_subcmd_0x111_req_body = new MessageMicro<subcmd0x111$SubCmd0x111ReqBody>() { // from class: tencent.im.cs.cmd0x6ff.subcmd0x111$SubCmd0x111ReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_start_time", "rpt_uint32_fieldlist", "rpt_uint64_uinlist"}, new Object[]{0, 0, 0L}, subcmd0x111$SubCmd0x111ReqBody.class);
        public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
        public final PBRepeatField<Integer> rpt_uint32_fieldlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBRepeatField<Long> rpt_uint64_uinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
}
