package qzone;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$StPattonAction extends MessageMicro<QZIntimateSpaceReader$StPattonAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{32, 42}, new String[]{"action_type", QZoneAdTianshuFeedData.KEY_SCHEMA_URL}, new Object[]{1, ""}, QZIntimateSpaceReader$StPattonAction.class);
    public final PBEnumField action_type = PBField.initEnum(1);
    public final PBStringField schema_url = PBField.initString("");
}
