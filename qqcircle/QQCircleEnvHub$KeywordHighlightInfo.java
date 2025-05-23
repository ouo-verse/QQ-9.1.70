package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleEnvHub$KeywordHighlightInfo extends MessageMicro<QQCircleEnvHub$KeywordHighlightInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"keywordHighlightResURL", "keywordHighlightTextAreaWidth"}, new Object[]{"", 0}, QQCircleEnvHub$KeywordHighlightInfo.class);
    public final PBStringField keywordHighlightResURL = PBField.initString("");
    public final PBUInt32Field keywordHighlightTextAreaWidth = PBField.initUInt32(0);
}
