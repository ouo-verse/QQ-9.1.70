package trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$CreateCFMGroupTeamReq extends MessageMicro<GameDataServerOuterClass$CreateCFMGroupTeamReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uid", GdtGetUserInfoHandler.KEY_AREA, "plat_id", AudienceReportConst.ROOM_ID, "map_id", "match_type"}, new Object[]{0L, 0, 0, 0L, 0, 0}, GameDataServerOuterClass$CreateCFMGroupTeamReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt32Field area = PBField.initUInt32(0);
    public final PBUInt32Field plat_id = PBField.initUInt32(0);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt32Field map_id = PBField.initUInt32(0);
    public final PBUInt32Field match_type = PBField.initUInt32(0);
}
