package tencent.im.oidb.cmd0x1122;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x1122$FetchSelectReq extends MessageMicro<oidb_0x1122$FetchSelectReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"req_uins", "req_tags"}, new Object[]{0L, 0L}, oidb_0x1122$FetchSelectReq.class);
    public final PBRepeatField<Long> req_tags;
    public final PBRepeatField<Long> req_uins;

    public oidb_0x1122$FetchSelectReq() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.req_uins = PBField.initRepeat(pBUInt64Field);
        this.req_tags = PBField.initRepeat(pBUInt64Field);
    }
}
