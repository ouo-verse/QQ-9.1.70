package trpc.qq_vgame.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameShare$CmdGetShareLinkReq extends MessageMicro<AvGameShare$CmdGetShareLinkReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48}, new String[]{"roomid", "share_uin", "share_name", AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "play_game_id", "game_type"}, new Object[]{0L, 0L, "", 0, "", 0}, AvGameShare$CmdGetShareLinkReq.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt64Field share_uin = PBField.initUInt64(0);
    public final PBStringField share_name = PBField.initString("");
    public final PBUInt32Field share_type = PBField.initUInt32(0);
    public final PBStringField play_game_id = PBField.initString("");
    public final PBEnumField game_type = PBField.initEnum(0);
}
