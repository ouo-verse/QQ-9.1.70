package qqcircle;

import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounter$GroupInfo extends MessageMicro<QQCircleCounter$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, h.f248218g}, new Object[]{"", Boolean.FALSE}, QQCircleCounter$GroupInfo.class);
    public final PBStringField groupid = PBField.initString("");
    public final PBBoolField isOpen = PBField.initBool(false);
}
