package tencent.im.oidb.cmd0x9c6;

import appoint.define.appoint_define$InterestTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c6$InterestMsg extends MessageMicro<cmd0x9c6$InterestMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint64_ddwUin", "msg_interest_tag", "rpt_latest_interest_tags", "uint32_mod_time"}, new Object[]{0L, null, null, 0}, cmd0x9c6$InterestMsg.class);
    public final PBUInt64Field uint64_ddwUin = PBField.initUInt64(0);
    public appoint_define$InterestTag msg_interest_tag = new appoint_define$InterestTag();
    public final PBRepeatMessageField<appoint_define$InterestTag> rpt_latest_interest_tags = PBField.initRepeatMessage(appoint_define$InterestTag.class);
    public final PBUInt32Field uint32_mod_time = PBField.initUInt32(0);
}
