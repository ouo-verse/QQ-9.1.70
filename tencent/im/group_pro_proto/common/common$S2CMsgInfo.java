package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$S2CMsgInfo extends MessageMicro<common$S2CMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField content;
    public final PBBytesField from_nick;
    public final PBUInt32Field s2c_notify_type = PBField.initUInt32(0);
    public final PBBytesField title;
    public final PBBytesField title_v8992;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"s2c_notify_type", "from_nick", "title", "content", "title_v8992"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, common$S2CMsgInfo.class);
    }

    public common$S2CMsgInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.from_nick = PBField.initBytes(byteStringMicro);
        this.title = PBField.initBytes(byteStringMicro);
        this.content = PBField.initBytes(byteStringMicro);
        this.title_v8992 = PBField.initBytes(byteStringMicro);
    }
}
