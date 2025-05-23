package tencent.im.oidb.cmd0xe0a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe0a$RspBody extends MessageMicro<cmd0xe0a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"cache_ts", "disabled", "app", "group_disabled", "redpoint_cache_ts"}, new Object[]{0, 0, null, 0, 0}, cmd0xe0a$RspBody.class);
    public final PBUInt32Field cache_ts = PBField.initUInt32(0);
    public final PBUInt32Field disabled = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0xe0a$App> app = PBField.initRepeatMessage(cmd0xe0a$App.class);
    public final PBUInt32Field group_disabled = PBField.initUInt32(0);
    public final PBUInt32Field redpoint_cache_ts = PBField.initUInt32(0);
}
