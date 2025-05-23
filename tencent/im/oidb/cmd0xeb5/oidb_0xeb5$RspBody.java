package tencent.im.oidb.cmd0xeb5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb5$RspBody extends MessageMicro<oidb_0xeb5$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"cache_ts", "app", "redpoint_cache_ts", "cookies", "max_show_app_num", "expose_id"}, new Object[]{0, null, 0, ByteStringMicro.EMPTY, 0, 0}, oidb_0xeb5$RspBody.class);
    public final PBUInt32Field cache_ts = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xeb5$App> app = PBField.initRepeatMessage(oidb_0xeb5$App.class);
    public final PBUInt32Field redpoint_cache_ts = PBField.initUInt32(0);
    public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field max_show_app_num = PBField.initUInt32(0);
    public final PBUInt32Field expose_id = PBField.initUInt32(0);
}
