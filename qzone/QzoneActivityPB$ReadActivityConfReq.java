package qzone;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ReadActivityConfReq extends MessageMicro<QzoneActivityPB$ReadActivityConfReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{WidgetCacheQzoneVipData.ISVIP}, new Object[]{Boolean.FALSE}, QzoneActivityPB$ReadActivityConfReq.class);
    public final PBBoolField is_vip = PBField.initBool(false);
}
