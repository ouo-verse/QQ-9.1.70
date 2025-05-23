package tencent.im.oidb.cmd0x5d2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5d2$FriendInfo extends MessageMicro<oidb_0x5d2$FriendInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"uin", "gender", "age", VipFunCallConstants.KEY_GROUP, "login", "remark"}, new Object[]{0L, 0, 0, 0, 0, ByteStringMicro.EMPTY}, oidb_0x5d2$FriendInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBUInt32Field age = PBField.initUInt32(0);
    public final PBUInt32Field group = PBField.initUInt32(0);
    public final PBUInt32Field login = PBField.initUInt32(0);
    public final PBBytesField remark = PBField.initBytes(ByteStringMicro.EMPTY);
}
