package tencent.im.oidb.cmd0xe13;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xe13$ReportInfo extends MessageMicro<oidb_cmd0xe13$ReportInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_time", "bytes_report"}, new Object[]{0L, ByteStringMicro.EMPTY}, oidb_cmd0xe13$ReportInfo.class);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBBytesField bytes_report = PBField.initBytes(ByteStringMicro.EMPTY);
}
