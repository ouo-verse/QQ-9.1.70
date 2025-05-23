package qzone;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ServerRole extends MessageMicro<QzoneActivityPB$ServerRole> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "platid", "partition", "partition_name", "uid", AudienceReportConst.USER_NAME}, new Object[]{0, 0, 0, "", "", ""}, QzoneActivityPB$ServerRole.class);
    public final PBInt32Field area = PBField.initInt32(0);
    public final PBInt32Field platid = PBField.initInt32(0);
    public final PBInt32Field partition = PBField.initInt32(0);
    public final PBStringField partition_name = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBStringField user_name = PBField.initString("");
}
