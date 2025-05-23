package tencent.im.oidb.device;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class MiniFileProto$MiniFile extends MessageMicro<MiniFileProto$MiniFile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"md5", "name", "length"}, new Object[]{ByteStringMicro.EMPTY, "", 0L}, MiniFileProto$MiniFile.class);
    public final PBBytesField md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField name = PBField.initString("");
    public final PBUInt64Field length = PBField.initUInt64(0);
}
