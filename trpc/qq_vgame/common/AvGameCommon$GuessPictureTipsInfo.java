package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class AvGameCommon$GuessPictureTipsInfo extends MessageMicro<AvGameCommon$GuessPictureTipsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"show_delay_ts", "tips"}, new Object[]{0, ""}, AvGameCommon$GuessPictureTipsInfo.class);
    public final PBUInt32Field show_delay_ts = PBField.initUInt32(0);
    public final PBStringField tips = PBField.initString("");
}
