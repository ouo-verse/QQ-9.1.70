package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class redInfo$RedInfo extends MessageMicro<redInfo$RedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50}, new String[]{"str_msg", "uint64_time", "uint64_from_uin", "uint64_label_id", "str_from_nick", "bytes_feeds_id"}, new Object[]{"", 0L, 0L, 0L, "", ByteStringMicro.EMPTY}, redInfo$RedInfo.class);
    public final PBStringField str_msg = PBField.initString("");
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_label_id = PBField.initUInt64(0);
    public final PBStringField str_from_nick = PBField.initString("");
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
