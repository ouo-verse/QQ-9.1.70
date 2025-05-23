package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x6f$QimFriendNotifyToQQ extends MessageMicro<SubMsgType0x6f$QimFriendNotifyToQQ> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_notify_type", "msg_add_notify_to_qq", "msg_upgrade_notify", "msg_add_not_login_frd_notify_to_qq"}, new Object[]{0, null, null, null}, SubMsgType0x6f$QimFriendNotifyToQQ.class);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public SubMsgType0x6f$AddQimFriendNotifyToQQ msg_add_notify_to_qq = new SubMsgType0x6f$AddQimFriendNotifyToQQ();
    public SubMsgType0x6f$UpgradeQimFriendNotify msg_upgrade_notify = new MessageMicro<SubMsgType0x6f$UpgradeQimFriendNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$UpgradeQimFriendNotify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "bytes_wording"}, new Object[]{0L, ByteStringMicro.EMPTY}, SubMsgType0x6f$UpgradeQimFriendNotify.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ msg_add_not_login_frd_notify_to_qq = new SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ();
}
