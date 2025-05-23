package tencent.im.oidb.cmd0xb77;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb77$ArkV1MsgBody extends MessageMicro<oidb_cmd0xb77$ArkV1MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 82, 90, 162}, new String[]{"app", "view", "prompt", "ver", "desc", "feature_id", PublicAccountMessageUtilImpl.META_NAME, "items", DownloadInfo.spKey_Config}, new Object[]{"", "", "", "", "", 0, "", null, ""}, oidb_cmd0xb77$ArkV1MsgBody.class);
    public final PBStringField app = PBField.initString("");
    public final PBStringField view = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
    public final PBStringField ver = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field feature_id = PBField.initUInt32(0);
    public final PBStringField meta = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xb77$TemplateItem> items = PBField.initRepeatMessage(oidb_cmd0xb77$TemplateItem.class);
    public final PBStringField config = PBField.initString("");
}
