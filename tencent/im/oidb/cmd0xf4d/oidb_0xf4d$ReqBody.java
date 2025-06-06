package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf4d$ReqBody extends MessageMicro<oidb_0xf4d$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50}, new String[]{"uin", "uin_source", "rowkey", "begin_delta_time", "end_delta_time", "danmu_cookie"}, new Object[]{"", 0, "", 0, 0, ByteStringMicro.EMPTY}, oidb_0xf4d$ReqBody.class);
    public final PBStringField uin = PBField.initString("");
    public final PBUInt32Field uin_source = PBField.initUInt32(0);
    public final PBStringField rowkey = PBField.initString("");
    public final PBUInt32Field begin_delta_time = PBField.initUInt32(0);
    public final PBUInt32Field end_delta_time = PBField.initUInt32(0);
    public final PBBytesField danmu_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
