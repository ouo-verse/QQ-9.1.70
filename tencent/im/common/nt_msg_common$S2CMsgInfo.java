package tencent.im.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_msg_common$S2CMsgInfo extends MessageMicro<nt_msg_common$S2CMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField content;
    public final PBBytesField from_nick;
    public final PBUInt32Field s2c_notify_type = PBField.initUInt32(0);
    public final PBBytesField title;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"s2c_notify_type", "from_nick", "title", "content"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro}, nt_msg_common$S2CMsgInfo.class);
    }

    public nt_msg_common$S2CMsgInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.from_nick = PBField.initBytes(byteStringMicro);
        this.title = PBField.initBytes(byteStringMicro);
        this.content = PBField.initBytes(byteStringMicro);
    }
}
