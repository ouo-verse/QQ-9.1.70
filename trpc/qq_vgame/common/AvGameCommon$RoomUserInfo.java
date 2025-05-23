package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameCommon$RoomUserInfo extends MessageMicro<AvGameCommon$RoomUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56}, new String[]{"uin", "role", "status", "enter_time", "cli_ver", "match_tag", "game_view"}, new Object[]{0L, 0, 0, 0, ByteStringMicro.EMPTY, 0, 0}, AvGameCommon$RoomUserInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field role = PBField.initUInt32(0);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBUInt32Field enter_time = PBField.initUInt32(0);
    public final PBBytesField cli_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField match_tag = PBField.initEnum(0);
    public final PBUInt32Field game_view = PBField.initUInt32(0);
}
