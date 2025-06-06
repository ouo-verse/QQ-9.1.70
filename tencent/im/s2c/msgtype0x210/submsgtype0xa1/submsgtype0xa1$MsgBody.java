package tencent.im.s2c.msgtype0x210.submsgtype0xa1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xa1$MsgBody extends MessageMicro<submsgtype0xa1$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 29, 32, 40}, new String[]{"uint32_sub_cmd", "uint64_qid", "fixed32_update_time", "uint32_team_created_destroied", "rpt_uint64_office_face_changed_uins"}, new Object[]{0, 0L, 0, 0, 0L}, submsgtype0xa1$MsgBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_qid = PBField.initUInt64(0);
    public final PBFixed32Field fixed32_update_time = PBField.initFixed32(0);
    public final PBUInt32Field uint32_team_created_destroied = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uint64_office_face_changed_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
