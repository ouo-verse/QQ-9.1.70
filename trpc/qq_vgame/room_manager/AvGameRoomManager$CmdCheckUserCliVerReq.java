package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdCheckUserCliVerReq extends MessageMicro<AvGameRoomManager$CmdCheckUserCliVerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uin", "roomid", "cli_ver"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY}, AvGameRoomManager$CmdCheckUserCliVerReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBBytesField cli_ver = PBField.initBytes(ByteStringMicro.EMPTY);
}
