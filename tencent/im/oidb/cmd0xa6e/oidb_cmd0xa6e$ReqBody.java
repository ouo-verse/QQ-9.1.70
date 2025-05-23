package tencent.im.oidb.cmd0xa6e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xa6e$ReqBody extends MessageMicro<oidb_cmd0xa6e$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 80, 88, 96}, new String[]{"rpt_topiclist", "uint32_req_pv", "uint32_req_followed_count", "uint32_req_ugc_count"}, new Object[]{0L, 0, 0, 0}, oidb_cmd0xa6e$ReqBody.class);
    public final PBRepeatField<Long> rpt_topiclist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_req_pv = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_followed_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_ugc_count = PBField.initUInt32(0);
}
