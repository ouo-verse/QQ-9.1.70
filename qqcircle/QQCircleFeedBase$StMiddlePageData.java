package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StMiddlePageData extends MessageMicro<QQCircleFeedBase$StMiddlePageData> {
    public static final int BOTTOM_BUTTON = 0;
    public static final int NOT_SHOW_BOTTOM_BUTTON = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"jumpSMShowType"}, new Object[]{0}, QQCircleFeedBase$StMiddlePageData.class);
    public final PBEnumField jumpSMShowType = PBField.initEnum(0);
}
