package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloTeamOuterClass$YoloTeamCreateRsp extends MessageMicro<YoloTeamOuterClass$YoloTeamCreateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{QZoneDTLoginReporter.SCHEMA}, new Object[]{""}, YoloTeamOuterClass$YoloTeamCreateRsp.class);
    public final PBStringField schema = PBField.initString("");
}
