package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCirclePendant$GetMyPendantBannerRsp extends MessageMicro<QQCirclePendant$GetMyPendantBannerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"status", "jump_url", "title", "subtitle", "bttn_text"}, new Object[]{0, "", "", "", ""}, QQCirclePendant$GetMyPendantBannerRsp.class);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField subtitle = PBField.initString("");
    public final PBStringField bttn_text = PBField.initString("");
}
