package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameList$CmdGetConfigReq extends MessageMicro<AvGameList$CmdGetConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"game_type", "roomid"}, new Object[]{0, 0L}, AvGameList$CmdGetConfigReq.class);
    public final PBEnumField game_type = PBField.initEnum(0);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
}
