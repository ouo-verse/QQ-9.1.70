package tencent.im.s2c.msgtype0x210.submsgtype0x15d;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x15d$StatusEventMessage extends MessageMicro<SubMsgType0x15d$StatusEventMessage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56}, new String[]{"appid", "instance_id", AudienceReportConst.CLIENT_TYPE, CGNonAgeReport.EVENT_TYPE, "online_devices", "pc_support_info", "plat_type"}, new Object[]{0, 0, 0, 0, null, null, 0}, SubMsgType0x15d$StatusEventMessage.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field instance_id = PBField.initUInt32(0);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBUInt32Field event_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<SubMsgType0x15d$OnlineDevInfo> online_devices = PBField.initRepeatMessage(SubMsgType0x15d$OnlineDevInfo.class);
    public SubMsgType0x15d$PCSupportInfo pc_support_info = new SubMsgType0x15d$PCSupportInfo();
    public final PBUInt32Field plat_type = PBField.initUInt32(0);
}
