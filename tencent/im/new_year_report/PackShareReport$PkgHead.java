package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PackShareReport$PkgHead extends MessageMicro<PackShareReport$PkgHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50}, new String[]{"cmdtype", "uin", "seq", "resp_name", "retcode", "retmsg"}, new Object[]{0, 0L, 0L, ByteStringMicro.EMPTY, 0, ""}, PackShareReport$PkgHead.class);
    public final PBUInt32Field cmdtype = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBBytesField resp_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBStringField retmsg = PBField.initString("");
}
