package tencent.im.s2c.msgtype0x210.submsgtype0x42;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x42$GameStatusSync extends MessageMicro<Submsgtype0x42$GameStatusSync> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_game_appid", "bytes_data"}, new Object[]{0, ByteStringMicro.EMPTY}, Submsgtype0x42$GameStatusSync.class);
    public final PBUInt32Field uint32_game_appid = PBField.initUInt32(0);
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
