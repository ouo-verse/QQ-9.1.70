package tencent.im.oidb.cmd0xefe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xefe$RspBody extends MessageMicro<oidb_cmd0xefe$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"mute_friend", "whitelist", "update_time"}, new Object[]{0L, 0L, 0L}, oidb_cmd0xefe$RspBody.class);
    public final PBRepeatField<Long> mute_friend;
    public final PBInt64Field update_time;
    public final PBRepeatField<Long> whitelist;

    public oidb_cmd0xefe$RspBody() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.mute_friend = PBField.initRepeat(pBUInt64Field);
        this.whitelist = PBField.initRepeat(pBUInt64Field);
        this.update_time = PBField.initInt64(0L);
    }
}
