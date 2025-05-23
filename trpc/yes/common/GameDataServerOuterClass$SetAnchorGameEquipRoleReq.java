package trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$SetAnchorGameEquipRoleReq extends MessageMicro<GameDataServerOuterClass$SetAnchorGameEquipRoleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "partition", "equip_status", "uid", AudienceReportConst.ANCHOR_ID, "a2_key", AudienceReportConst.ROOM_ID}, new Object[]{0, 0, 0, 0L, "", ByteStringMicro.EMPTY, 0L}, GameDataServerOuterClass$SetAnchorGameEquipRoleReq.class);
    public final PBUInt32Field area = PBField.initUInt32(0);
    public final PBUInt32Field partition = PBField.initUInt32(0);
    public final PBInt32Field equip_status = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField anchor_id = PBField.initString("");
    public final PBBytesField a2_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
