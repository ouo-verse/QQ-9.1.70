package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.xweb.FileReaderHelper;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StQQProfilePointInfo extends MessageMicro<QQCircleFeedBase$StQQProfilePointInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{FileReaderHelper.TXT_EXT, "touin"}, new Object[]{"", ""}, QQCircleFeedBase$StQQProfilePointInfo.class);
    public final PBStringField txt = PBField.initString("");
    public final PBStringField touin = PBField.initString("");
}
