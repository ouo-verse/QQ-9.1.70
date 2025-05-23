package tencent.im.oidb.cmd0xc6d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc6d$ModuleInfo extends MessageMicro<oidb_cmd0xc6d$ModuleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 26}, new String[]{"bytes_type", "bytes_weight", "bytes_json"}, new Object[]{0, Float.valueOf(0.0f), ByteStringMicro.EMPTY}, oidb_cmd0xc6d$ModuleInfo.class);
    public final PBUInt32Field bytes_type = PBField.initUInt32(0);
    public final PBFloatField bytes_weight = PBField.initFloat(0.0f);
    public final PBBytesField bytes_json = PBField.initBytes(ByteStringMicro.EMPTY);
}
