package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$GetUserGameMainPageInfoReq extends MessageMicro<GameDataServerOuterClass$GetUserGameMainPageInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uid", "game_id", "scene", "display_uid", "display_yes_uid"}, new Object[]{0L, 0, 0, 0L, 0L}, GameDataServerOuterClass$GetUserGameMainPageInfoReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBInt32Field scene = PBField.initInt32(0);
    public final PBUInt64Field display_uid = PBField.initUInt64(0);
    public final PBUInt64Field display_yes_uid = PBField.initUInt64(0);
}
