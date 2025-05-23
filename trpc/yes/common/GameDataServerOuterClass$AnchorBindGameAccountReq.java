package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$AnchorBindGameAccountReq extends MessageMicro<GameDataServerOuterClass$AnchorBindGameAccountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uid", "game_id", "openid", "gopenid"}, new Object[]{0L, 0, "", ""}, GameDataServerOuterClass$AnchorBindGameAccountReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField gopenid = PBField.initString("");
}
