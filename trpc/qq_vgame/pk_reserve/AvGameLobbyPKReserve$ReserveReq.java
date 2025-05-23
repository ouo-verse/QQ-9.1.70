package trpc.qq_vgame.pk_reserve;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class AvGameLobbyPKReserve$ReserveReq extends MessageMicro<AvGameLobbyPKReserve$ReserveReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"pk_id", "is_reserve"}, new Object[]{0, Boolean.FALSE}, AvGameLobbyPKReserve$ReserveReq.class);
    public final PBUInt32Field pk_id = PBField.initUInt32(0);
    public final PBBoolField is_reserve = PBField.initBool(false);
}
