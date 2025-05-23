package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomDisMissReq extends MessageMicro<YoloRoomOuterClass$YoloRoomDisMissReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{AudienceReportConst.ROOM_ID}, new Object[]{0L}, YoloRoomOuterClass$YoloRoomDisMissReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
