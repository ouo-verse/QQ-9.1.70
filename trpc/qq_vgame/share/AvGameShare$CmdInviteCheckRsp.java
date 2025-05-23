package trpc.qq_vgame.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameShare$CmdInviteCheckRsp extends MessageMicro<AvGameShare$CmdInviteCheckRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"roomid", "share_uin", "game_type", AskAnonymouslyApiPlugin.KEY_SHARE_TYPE}, new Object[]{0L, 0L, 0, 0}, AvGameShare$CmdInviteCheckRsp.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt64Field share_uin = PBField.initUInt64(0);
    public final PBEnumField game_type = PBField.initEnum(0);
    public final PBUInt32Field share_type = PBField.initUInt32(0);
}
