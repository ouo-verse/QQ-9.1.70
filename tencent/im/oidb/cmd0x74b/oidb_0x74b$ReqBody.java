package tencent.im.oidb.cmd0x74b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x74b$ReqBody extends MessageMicro<oidb_0x74b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 80}, new String[]{"rpt_uint64_uin", "rpt_uint64_tinyid", "rpt_uint32_video_size", "rpt_head_type"}, new Object[]{0L, 0L, 0, 0}, oidb_0x74b$ReqBody.class);
    public final PBRepeatField<Integer> rpt_head_type;
    public final PBRepeatField<Integer> rpt_uint32_video_size;
    public final PBRepeatField<Long> rpt_uint64_tinyid;
    public final PBRepeatField<Long> rpt_uint64_uin;

    public oidb_0x74b$ReqBody() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.rpt_uint64_uin = PBField.initRepeat(pBUInt64Field);
        this.rpt_uint64_tinyid = PBField.initRepeat(pBUInt64Field);
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.rpt_uint32_video_size = PBField.initRepeat(pBUInt32Field);
        this.rpt_head_type = PBField.initRepeat(pBUInt32Field);
    }
}
