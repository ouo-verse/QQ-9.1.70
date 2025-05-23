package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MqqLbs$CheatApp extends MessageMicro<MqqLbs$CheatApp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_app_name", "uint32_run_status"}, new Object[]{ByteStringMicro.EMPTY, 0}, MqqLbs$CheatApp.class);
    public final PBBytesField bytes_app_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_run_status = PBField.initUInt32(0);
}
