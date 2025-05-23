package tencent.im.oidb.location;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* loaded from: classes29.dex */
public final class qq_lbs_share$PushExtInfo extends MessageMicro<qq_lbs_share$PushExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{ProtocolDownloaderConstants.HEADER_FRIEND_UIN, AudienceReportConst.CLIENT_TYPE}, new Object[]{0L, 1}, qq_lbs_share$PushExtInfo.class);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0);
    public final PBEnumField client_type = PBField.initEnum(1);
}
