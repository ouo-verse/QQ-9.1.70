package tencent.im.oidb.cmd0x5d1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5d1$ReqBody extends MessageMicro<Oidb_0x5d1$ReqBody> {
    public static final int MSG_CLEAR_FRIEND_ID_FIELD_NUMBER = 4;
    public static final int MSG_SET_FRIEND_ID_FIELD_NUMBER = 3;
    public static final int UINT32_CMD_FIELD_NUMBER = 1;
    public static final int UINT32_ID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_cmd", "uint32_id", "msg_set_friend_id", "msg_clear_friend_id"}, new Object[]{0, 0, null, null}, Oidb_0x5d1$ReqBody.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public Oidb_0x5d1$SetFriendIdReq msg_set_friend_id = new Oidb_0x5d1$SetFriendIdReq();
    public Oidb_0x5d1$ClearFriendIdReq msg_clear_friend_id = new Oidb_0x5d1$ClearFriendIdReq();
}
