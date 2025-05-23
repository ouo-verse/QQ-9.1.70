package qqcircle;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDurationReport$DurationDialog extends MessageMicro<QQCircleDurationReport$DurationDialog> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66}, new String[]{"id", LinkReportConstant$BizKey.DIALOG_TYPE, "icon", "title", "content", "jump_url", "jump_text", "toast_text"}, new Object[]{"", 0, "", "", "", "", "", ""}, QQCircleDurationReport$DurationDialog.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429301id = PBField.initString("");
    public final PBUInt32Field dialog_type = PBField.initUInt32(0);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField jump_text = PBField.initString("");
    public final PBStringField toast_text = PBField.initString("");
}
