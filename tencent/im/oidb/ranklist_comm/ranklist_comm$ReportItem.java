package tencent.im.oidb.ranklist_comm;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ranklist_comm$ReportItem extends MessageMicro<ranklist_comm$ReportItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"openid", LocalPhotoFaceInfo.SCORE, "rpt_extra_param"}, new Object[]{"", 0, null}, ranklist_comm$ReportItem.class);
    public final PBStringField openid = PBField.initString("");
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBRepeatMessageField<ranklist_comm$ExtraParam> rpt_extra_param = PBField.initRepeatMessage(ranklist_comm$ExtraParam.class);
}
