package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8c8$ReqMsgInfo extends MessageMicro<oidb_cmd0x8c8$ReqMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56}, new String[]{"uint64_feeds_id", "uint32_feeds_style", "bytes_recommend_reason", "uint32_biu_time", "feeds_type", "uint32_business_id", "rpt_topic_id"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0, 0, 0, 0}, oidb_cmd0x8c8$ReqMsgInfo.class);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBEnumField feeds_type = PBField.initEnum(0);
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_topic_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
