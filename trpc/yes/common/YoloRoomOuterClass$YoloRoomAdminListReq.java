package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomAdminListReq extends MessageMicro<YoloRoomOuterClass$YoloRoomAdminListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{AudienceReportConst.ROOM_ID, "client_key"}, new Object[]{0L, ByteStringMicro.EMPTY}, YoloRoomOuterClass$YoloRoomAdminListReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBBytesField client_key = PBField.initBytes(ByteStringMicro.EMPTY);
}
