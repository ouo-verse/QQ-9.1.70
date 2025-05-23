package tencent.im.oidb.cmd0x5d2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5d2$FriendList extends MessageMicro<oidb_0x5d2$FriendList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "nick"}, new Object[]{0L, ByteStringMicro.EMPTY}, oidb_0x5d2$FriendList.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBBytesField nick = PBField.initBytes(ByteStringMicro.EMPTY);
}
