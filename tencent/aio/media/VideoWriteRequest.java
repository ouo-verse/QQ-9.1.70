package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class VideoWriteRequest extends MessageMicro<VideoWriteRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 58}, new String[]{QCircleRelationGroupRequest.GROUP_ID, "categoryId", "matchId", "operType", IProfileProtocolConst.PARAM_TARGET_UIN, "roomTitle", "roomCover"}, new Object[]{0L, 0, "", 0, 0L, "", ""}, VideoWriteRequest.class);
    public final PBUInt64Field gid = PBField.initUInt64(0);
    public final PBUInt32Field categoryId = PBField.initUInt32(0);
    public final PBStringField matchId = PBField.initString("");
    public final PBUInt32Field operType = PBField.initUInt32(0);
    public final PBUInt64Field targetUin = PBField.initUInt64(0);
    public final PBStringField roomTitle = PBField.initString("");
    public final PBStringField roomCover = PBField.initString("");
}
