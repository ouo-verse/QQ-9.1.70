package tencent.im.oidb.cmd0xd79;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd79$content extends MessageMicro<Oidb_0xd79$content> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_slice_content"}, new Object[]{ByteStringMicro.EMPTY}, Oidb_0xd79$content.class);
    public final PBRepeatField<ByteStringMicro> bytes_slice_content = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
